package edu.pitt.dbmi.edda.summarization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.pitt.coder.NobleCoder;
import edu.pitt.dbmi.edda.summarization.lens.enlreader.Annotation;
import edu.pitt.dbmi.edda.summarization.lingpipe.SentenceFinder;
import edu.pitt.dbmi.edda.summarization.noblecoder.ConceptFinder;
import edu.pitt.dbmi.edda.summarization.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Document;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.EndNoteLibraryOutput;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.NounPhraseMention;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Sentence;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.WordMention;
import edu.pitt.terminology.util.TerminologyException;

public class SummarizedAbstractBuilder {
	
	private static final String CONST_SUMMARIZATION_OUTPUT_DIRECTORY_PATH = "C:\\Users\\kjm84\\Desktop\\galacto\\output\\";
	private static final String CONST_HUMAN_OUTPUT = "human";
	private static final String CONST_ITEXT_OUTPUT = "itext";
	private static final String CONST_PDFBOX_OUTPUT = "pdfbox";
	
	private final int CONST_MEDIAN_CHARS_PER_ABSTRACT = 1276;

	private DataSourceManager dataSourceManager;

	private NobleCoder coder;

	private EndNoteLibraryOutput enlParsedEntry;
	private String pdfText = null;
	private String keywordsText = null;

	private Document dbDoc;
	private Sentence dbSentence;
	private NounPhraseMention dbNounPhraseMention;
	private WordMention dbWordMention;

	private int sSeq = 0;

	private final List<Object> pojosToSave = new ArrayList<Object>();
	
	private CommandLine commandLine;

	public static void main(String[] args) {
		try {
			SummarizedAbstractBuilder eddaStandAlone = new SummarizedAbstractBuilder(args);
			eddaStandAlone.executePdfs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SummarizedAbstractBuilder(String[] args) {
		parseCommandLineArguments(args);
	}
	
	private void parseCommandLineArguments(String[] args) {
		final CommandLineParser cmdLinePosixParser = new PosixParser();
		final Options posixOptions = constructOptions();
		
		try {
			commandLine = cmdLinePosixParser.parse(posixOptions,
					args);

		} catch (ParseException parseException) // checked exception
		{
			System.err
					.println("Encountered exception while parsing using PosixParser:\n"
							+ parseException.getMessage());
		}
	}
	
	private Options constructOptions() {
		final Options options = new Options();
		Option o = new Option("pdfSource", "human|pdfBox|iText");
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		options.addOption(o);
		
		o = new Option("summaryOutput",
				"Location of the summarization output directory");
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		options.addOption(o);
		
		o = new Option("dbUrl",
				"Database url including database");
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		options.addOption(o);
		
		o = new Option("dbUser",
				"Database user name");
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		options.addOption(o);
		
		o = new Option("dbPassword",
				"Database password");
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		options.addOption(o);
		
		o = new Option("hibernateShowSql",
				"Show hibernate sql");
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		options.addOption(o);
		
		o = new Option("hibernateHbm2ddlAuto",
				"Show hibernate sql");
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		options.addOption(o);
		
		dataSourceManager = new DataSourceManager();
		dataSourceManager
				.setHibernateConnectionUrl("jdbc:mysql://localhost:3306/enl");
		dataSourceManager.setHibernateUserName("edda");
		dataSourceManager.setHibernateUserPassword("edda");
		dataSourceManager.setHibernateShowSql("false");
		dataSourceManager.setHibernateHbm2ddlAuto("update");
		
		return options;
	}

	private void executePdfs() throws Exception {

		openNobleCoder();

		executeDatabasePreparation();
		
		removeTableRows();
		
		if (commandLine.getOptionValue("pdfSource").equals("CONST_HUMAN_OUTPUT")) {
			setOutputFileDirectory(CONST_HUMAN_OUTPUT);
			runUsingHumanText();
		}
		else if (commandLine.getOptionValue("pdfSource").equals("CONST_ITEXT_OUTPUT")) {
			setOutputFileDirectory(CONST_ITEXT_OUTPUT);
			runUsingPdfBoxText();
		}
		else /*  PdfBox */ {
			setOutputFileDirectory(CONST_PDFBOX_OUTPUT);
			runUsingItextText();
		}


		closeNobleCoder();
	}
	
	@SuppressWarnings("unchecked")
	private void runUsingHumanText() throws Exception {
		Criteria crit = dataSourceManager
				.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(Restrictions.and(Restrictions.isNotNull("humanPdf"),
						Restrictions.ne("humanPdf", "UNKNOWN")));
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		for (EndNoteLibraryOutput enlParsedEntry : enlParsedEntries) {
			this.enlParsedEntry = enlParsedEntry;
			this.pdfText = enlParsedEntry.getHumanPdf();
			this.keywordsText = enlParsedEntry.getKeywords();
			execute();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void runUsingPdfBoxText() throws Exception {
		Criteria crit = dataSourceManager
				.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(Restrictions.and(Restrictions.isNotNull("pdfBoxText"),
						Restrictions.ne("pdfBoxText", "UNKNOWN")));
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		for (EndNoteLibraryOutput enlParsedEntry : enlParsedEntries) {
			this.enlParsedEntry = enlParsedEntry;
			this.pdfText = enlParsedEntry.getPdfText();
			this.keywordsText = enlParsedEntry.getKeywords();
			execute();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void runUsingItextText() throws Exception {
		Criteria crit = dataSourceManager
				.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(Restrictions.and(Restrictions.isNotNull("iTextText"),
						Restrictions.ne("iTextText", "UNKNOWN")));
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		for (EndNoteLibraryOutput enlParsedEntry : enlParsedEntries) {
			this.enlParsedEntry = enlParsedEntry;
			this.pdfText = enlParsedEntry.getPdfText();
			this.keywordsText = enlParsedEntry.getKeywords();
			execute();
		}
	}
	
	public void execute() throws Exception {
		try {
			executeDocumentPreprocessing();
			activateKeywordConcepts();
			if (dbDoc.getContent().length() > CONST_MEDIAN_CHARS_PER_ABSTRACT) {
				executeDocumentSummarization();
			} else {
				copyOriginalContent();
			}
			executeDocumentCleanUp();
		} catch (Exception x) {
			System.err.println(x.getMessage());
		}
	}

	private void executeDatabasePreparation() {
		createOrUseCachedDataSourceManager();
		if (getDebugging()) {
			System.out.println("createOrUseCachedDataSourceManager");
		}
	}

	private DataSourceManager createOrUseCachedDataSourceManager() {
		if (dataSourceManager == null) {
			dataSourceManager = new DataSourceManager();
			dataSourceManager
					.setHibernateConnectionUrl("jdbc:mysql://localhost:3306/enl");
			dataSourceManager.setHibernateUserName("edda");
			dataSourceManager.setHibernateUserPassword("edda");
			dataSourceManager.setHibernateShowSql("false");
			dataSourceManager.setHibernateHbm2ddlAuto("update");
		}
		return dataSourceManager;
	}


	@SuppressWarnings("unchecked")
	private void activateKeywordConcepts() {
		final String[] keywordLines = keywordsText.split("\n");
		final HashSet<String> uniqueKeywordConcepts = new HashSet<String>();
		for (String keywordLine : keywordLines) {
			List<Annotation> conceptAnnotations = ConceptFinder.getInstance().findConcepts(keywordLine);
			for (Annotation conceptAnnot : conceptAnnotations) {
				uniqueKeywordConcepts.add(conceptAnnot.getUnderLyingText());
			}
		}
		final ArrayList<WordMention> pojosToSave = new ArrayList<WordMention>();
		for (String concept : uniqueKeywordConcepts) {
			Criteria crit = dataSourceManager
					.getSession()
					.createCriteria(WordMention.class)
					.add(Restrictions.eq("stemmedContent", concept));
			List<WordMention> wordMentionsToActivate = crit.list();
			for (WordMention wordMentionToActive : wordMentionsToActivate) {
				wordMentionToActive.setIsKeyword(true);
				pojosToSave.add(wordMentionToActive);
			}
		}
	}

	private void copyOriginalContent() throws IOException {
		File directory = new File(getOutputFileDirectory());
		if (directory != null && directory.exists() && directory.isDirectory()) {
			String documentName = dbDoc.getUrl();
			FileWriter writerForCluster = new FileWriter(new File(directory,
					documentName));
			writerForCluster
					.append(StringUtils.trimToEmpty(dbDoc.getContent()));
			writerForCluster.flush();
			writerForCluster.close();
		}
	}

	private void executeDocumentPreprocessing() throws TerminologyException {
		clearPojos();
		if (getDebugging()) {
			System.out.println("clearPojos");
		}
		insertDocument();
		if (getDebugging()) {
			System.out.println("insertDocument");
		}
		saveOrUpdatePojos(pojosToSave);
		if (getDebugging()) {
			System.out.println("saveOrUpdatePojos");
		}
	}

	private void executeDocumentSummarization() throws SummarizationException, IOException {
		SingleDocumentTebekaSummarizer summarizer = new SingleDocumentTebekaSummarizer();
		summarizer.setDataSourceManager(dataSourceManager);
		summarizer
				.setMedianCharactersPerAbstract(CONST_MEDIAN_CHARS_PER_ABSTRACT);
		summarizer.setRelativeScoring(getRelativeScoring());
		summarizer.setOutputDirectoryPath(getOutputFileDirectory());
		if (getDebugging()) {
			System.out.println("Executing summarizer");
		}
		summarizer.execute();
		if (getDebugging()) {
			System.out.println("Finished summarizer");
		}
		writeSummary(summarizer.getAccumulatingSummary());
	}
	
	private void writeSummary(String completeSummary) throws IOException  {
		File directory = new File(
				getOutputFileDirectory());
		if (directory != null && directory.exists() && directory.isDirectory()) {
			String documentName = dbDoc.getUrl();
			FileWriter writerForCluster = new FileWriter(new File(directory,
					documentName));
			writerForCluster.append("TI - " + enlParsedEntry.getTitle() + "\n");
			writerForCluster.append("AB - " + completeSummary + "\n");
			writerForCluster.flush();
			writerForCluster.close();
		}
	}

	private void insertDocument() throws TerminologyException {
		dbDoc = new Document();
		String relativePath = enlParsedEntry.getInternalPdf();
		relativePath = StringUtils.substringAfter(relativePath, "/");
		relativePath = StringUtils.substringBefore(relativePath, "/");
		relativePath += ".txt";
		dbDoc.setUrl(relativePath);
		dbDoc.setContent(pdfText);
		dbDoc.setSequence(0);
		dbDoc.setCluster(0);
		pojosToSave.add(dbDoc);
		List<Annotation> sentenceAnnotations = SentenceFinder.getInstance().annotateSentences(pdfText);
		sSeq = 0;
		for (Annotation sentenceAnnotation : sentenceAnnotations) {
			if (isBadSentence(sentenceAnnotation)) {
				continue;
			}
			insertSentence(sentenceAnnotation);
			sSeq++;
		}
	}

	private void insertSentence(Annotation sentenceAnnot) throws TerminologyException {
		dbSentence = new Sentence();
		pojosToSave.add(dbSentence);
		dbSentence.setDocumentSPos(sentenceAnnot.getsPos());
		dbSentence.setDocumentEPos(sentenceAnnot.getePos());
		dbSentence.setSentenceSeq(sSeq);
		dbSentence.setCluster(0);
		dbSentence.setIsActive(true);
		dbSentence.setWordCount(0.0d);
		dbSentence.setRelativeScore(0.0d);
		dbSentence.setScore(0.0d);
		dbSentence.setContent(getAnnotationText(sentenceAnnot));
		dbDoc.addSentence(dbSentence);

		List<Annotation> nounPhraseMentionAnnots = ConceptFinder.getInstance().findConcepts(getAnnotationText(sentenceAnnot), sentenceAnnot.getsPos());
		for (Annotation nounPhraseMentionAnnot : nounPhraseMentionAnnots) {
			insertNounPhraseMention(sentenceAnnot, nounPhraseMentionAnnot);
		}
	}

	private void insertNounPhraseMention(Annotation sentenceAnnot,
			Annotation nounPhraseMentionAnnot) {
		dbNounPhraseMention = new NounPhraseMention();
		pojosToSave.add(dbNounPhraseMention);
		dbNounPhraseMention.setDocumentSPos(nounPhraseMentionAnnot.getsPos());
		dbNounPhraseMention.setDocumentEPos(nounPhraseMentionAnnot.getePos());
		int sentenceSPos = nounPhraseMentionAnnot.getsPos()
				- sentenceAnnot.getsPos();
		int sentenceEPos = nounPhraseMentionAnnot.getePos()
				- sentenceAnnot.getsPos();
		dbNounPhraseMention.setSentenceSPos(sentenceSPos);
		dbNounPhraseMention.setSentenceEPos(sentenceEPos);
		dbNounPhraseMention
				.setContent(getAnnotationText(nounPhraseMentionAnnot));
		dbDoc.addNounPhraseMention(dbNounPhraseMention);
		dbSentence.addNounPhraseMention(dbNounPhraseMention);

		Annotation wordMentionAnnot = new Annotation("WordMention", nounPhraseMentionAnnot.getsPos(), nounPhraseMentionAnnot.getePos(), nounPhraseMentionAnnot.getUnderLyingText());
		insertWordMention(wordMentionAnnot);
	}

	private void insertWordMention(Annotation wordMentionAnnot) {
		dbWordMention = new WordMention();
		pojosToSave.add(dbWordMention);
		dbWordMention.setContent(wordMentionAnnot.getUnderLyingText());
		dbWordMention.setStemmedContent(wordMentionAnnot.getUnderLyingText());
		dbWordMention.setDocument(dbDoc);
		int docSPos = wordMentionAnnot.getsPos();
		int docEPos = wordMentionAnnot.getePos();
		dbWordMention.setDocumentSPos(docSPos);
		dbWordMention.setDocumentEPos(docEPos);
		int senSPos = dbSentence.getDocumentSPos();
		dbWordMention.setSentenceSPos(docSPos - senSPos);
		dbWordMention.setSentenceEPos(docEPos - senSPos);
		dbWordMention.setIsStopWord(isStopWordToken(wordMentionAnnot));
		dbWordMention.setCluster(0);
		dbNounPhraseMention.addWordMention(dbWordMention);
		dbSentence.addWordMention(dbWordMention);
		dbDoc.addWordMention(dbWordMention);
	}

	private boolean isStopWordToken(Annotation token) {
		return StopwordDetector.getInstance().isStopword(
				token.getUnderLyingText());
	}

	private boolean isBadSentence(Annotation sentenceAnnot) {
		return isDummySentence(sentenceAnnot) || hasTooManyLines(sentenceAnnot);
	}

	private boolean hasTooManyLines(Annotation sentenceAnnot) {
		String sentenceText = getAnnotationText(sentenceAnnot);
		String[] lines = sentenceText.split("\n");
		return lines.length > getMaxEolnsPerSentence();
	}

	private String getAnnotationText(Annotation annot) {
		return annot.getUnderLyingText();
	}

	private boolean isDummySentence(Annotation sentenceAnnot) {
		return sentenceAnnot.getsPos() == 0 && sentenceAnnot.getePos() == 1;
	}

	private void executeDocumentCleanUp() {
		removePojos();
		if (getDebugging()) {
			System.out.println("removePojos");
		}
	}

	private void clearPojos() {
		dbDoc = null;
		dbSentence = null;
		dbNounPhraseMention = null;
		dbWordMention = null;
		pojosToSave.clear();
	}

	private void saveOrUpdatePojos(List<Object> pojosToSave) {
		Transaction tx = null;
		try {
			tx = dataSourceManager.getSession().beginTransaction();
			for (Object pojo : pojosToSave) {
				dataSourceManager.getSession().saveOrUpdate(pojo);
			}
			dataSourceManager.getSession().flush();
			tx.commit();
		} catch (Exception x) {
			System.err.println("saveOrUpdatePojos: " + x.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
	}

	private void removePojos() {
		Transaction tx = null;
		try {
			tx = dataSourceManager.getSession().beginTransaction();
			for (Object pojo : pojosToSave) {
				dataSourceManager.getSession().delete(pojo);
			}
			dataSourceManager.getSession().flush();
			tx.commit();
		} catch (Exception x) {
			System.err.println("removePojos: " + x.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
	}

	private void removeTableRows() {
		
		String hql = null;
		Transaction tx = null;
		
		hql = "delete from WordMention";
		tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().createQuery(hql).executeUpdate();
		tx.commit();

		hql = "delete from NormalizedWord";
		tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().createQuery(hql).executeUpdate();
		tx.commit();

		hql = "delete from NounPhraseMention";
		tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().createQuery(hql).executeUpdate();
		tx.commit();

		hql = "delete from NormalizedNounPhrase";
		tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().createQuery(hql).executeUpdate();
		tx.commit();

		hql = "delete from Sentence";
		tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().createQuery(hql).executeUpdate();
		tx.commit();

		hql = "delete from Document";
		tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().createQuery(hql).executeUpdate();
		tx.commit();
	}
	
	protected void openNobleCoder() {
		if (coder == null) {
			try {
				URL terminologyUrl = new URL(
						"file:///C:/nobletools/terminologies/TIES_Pathology.term");
				File terminologyFileHandle = new File(terminologyUrl.toURI());
				coder = new NobleCoder(terminologyFileHandle);
				if (debugging) {
					System.out
							.println("Successfully opened NobleCoder data source.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeNobleCoder() {
		;
	}


	protected String outputFileDirectory = "C:\\Users\\kjm84\\Desktop\\galacto\\output\\corey";
	public void setOutputFileDirectory(String outputFileDirectory) {
		this.outputFileDirectory = outputFileDirectory;
	}
	public String getOutputFileDirectory() {
		return this.outputFileDirectory;
	}

	protected Boolean isRelativeScoring = false;
	public void setRelativeScoring(Boolean isRelativeScoring) {
		this.isRelativeScoring = isRelativeScoring;
	}
	public Boolean getRelativeScoring() {
		return this.isRelativeScoring;
	}

	protected Integer maxEolnsPerSentence = new Integer(7);
	public void setMaxEolnsPerSentence(Integer maxEolnsPerSentence) {
		this.maxEolnsPerSentence = maxEolnsPerSentence;
	}
	public Integer getMaxEolnsPerSentence() {
		return this.maxEolnsPerSentence;
	}

	protected Boolean saveStopWords = false;
	public void setSaveStopWords(Boolean saveStopWords) {
		this.saveStopWords = saveStopWords;
	}
	public Boolean getSaveStopWords() {
		return this.saveStopWords;
	}

	protected String hibernateDialect = org.hibernate.dialect.MySQLDialect.class
			.getName();

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getHibernateDialect() {
		return this.hibernateDialect;
	}

	protected String hibernateDriver = "com.mysql.jdbc.Driver";

	public void setHibernateDriver(String hibernateDriver) {
		this.hibernateDriver = hibernateDriver;
	}

	public String getHibernateDriver() {
		return this.hibernateDriver;
	}

	protected String hibernateConnectionUrl = "jdbc:mysql://localhost:3306/obpbio1";

	public void setHibernateConnectionUrl(String hibernateConnectionUrl) {
		this.hibernateConnectionUrl = hibernateConnectionUrl;
	}

	public String getHibernateConnectionUrl() {
		return this.hibernateConnectionUrl;
	}

	protected String hibernateUserName = "edda";

	public void setHibernateUserName(String hibernateUserName) {
		this.hibernateUserName = hibernateUserName;
	}

	public String getHibernateUserName() {
		return this.hibernateUserName;
	}

	protected String hibernateUserPassword = "****";

	public void setHibernateUserPassword(String hibernateUserPassword) {
		this.hibernateUserPassword = hibernateUserPassword;
	}

	public String getHibernateUserPassword() {
		return this.hibernateUserPassword;
	}

	protected String hibernateHbm2ddlAuto = "update";

	public void setHibernateHbm2ddlAuto(String hibernateHbm2ddlAuto) {
		this.hibernateHbm2ddlAuto = hibernateHbm2ddlAuto;
	}

	public String getHibernateHbm2ddlAuto() {
		return this.hibernateHbm2ddlAuto;
	}

	protected String hibernateShowSql = "false";

	public void setHibernateShowSql(String hibernateShowSql) {
		this.hibernateShowSql = hibernateShowSql;
	}

	public String getHibernateShowSql() {
		return this.hibernateShowSql;
	}

	protected Boolean debugging = false;

	public void setDebugging(Boolean debugging) {
		this.debugging = debugging;
	}

	public Boolean getDebugging() {
		return this.debugging;
	}


}
