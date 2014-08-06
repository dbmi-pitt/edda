package edu.pitt.dbmi.edda.summarization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.summarization.lens.enlreader.Annotation;
import edu.pitt.dbmi.edda.summarization.noblecoder.ConceptFinder;
import edu.pitt.dbmi.edda.summarization.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Document;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.EndNoteLibraryOutput;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.NounPhraseMention;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Sentence;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.WordMention;
import edu.pitt.terminology.util.TerminologyException;

public class SummarizedAbstractBuilder {
	
	protected String outputFileDirectory = "/home/edda/Desktop/galacto/output/human";

	private static final String CONST_FS_DIRECTORY_OUTPUT = "fsdirectory";
	private static final String CONST_HUMAN_OUTPUT = "human";
	private static final String CONST_ITEXT_OUTPUT = "itext";
	private static final String CONST_PDFBOX_OUTPUT = "pdfbox";

	private final int CONST_MEDIAN_CHARS_PER_ABSTRACT = 1276;

	protected String hibernateDriver = "com.mysql.jdbc.Driver";
	protected String hibernateDialect = org.hibernate.dialect.MySQLDialect.class
			.getName();
	protected Boolean saveStopWords = false;
	protected Integer maxEolnsPerSentence = new Integer(7);
	protected Boolean isRelativeScoring = false;

	private DataSourceManager dataSourceManager;

	private ConceptFinder conceptFinder;

	private EndNoteLibraryOutput enlParsedEntry;
	private String documentText = null;
	private String keywordsText = null;

	private Document dbDoc;
	private Sentence dbSentence;
	private NounPhraseMention dbNounPhraseMention;
	private WordMention dbWordMention;

	private int sSeq = 0;

	private final List<Object> pojosToSave = new ArrayList<>();

	private CommandLine commandLine;
	private Options posixOptions;

	public static void main(String[] args) {
		try {
			SummarizedAbstractBuilder eddaStandAlone = new SummarizedAbstractBuilder(
					args);
			eddaStandAlone.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SummarizedAbstractBuilder(String[] args) {
		parseCommandLineArguments(args);
	}

	private void parseCommandLineArguments(String[] args) {
		final CommandLineParser cmdLinePosixParser = new PosixParser();
		posixOptions = constructOptions();
		try {
			commandLine = cmdLinePosixParser.parse(posixOptions, args);
		} catch (ParseException parseException) // checked exception
		{
			parseException.printStackTrace();
			usage();
		}
	}

	private Options constructOptions() {
		final Options options = new Options();
		options.addOption(buildStandardOption("pdfSource", "human|pdfBox|iText"));
		options.addOption(buildStandardOption("summaryOutput",
				"Location of the summarization output directory"));
		options.addOption(buildStandardOption("coderResource",
				"Location of noble coder terminology"));
		options.addOption(buildStandardOption("dbUrl",
				"Database url including database"));
		options.addOption(buildStandardOption("dbUser", "Database user name"));
		options.addOption(buildStandardOption("dbPassword", "Database password"));
		options.addOption(buildStandardOption("hibernateShowSql",
				"Show hibernate sql"));
		options.addOption(buildStandardOption("hibernateHbm2ddlAuto",
				"Show hibernate sql"));
		options.addOption(buildStandardOption("isDebugging",
				"Show debugging diagnostics?"));
		return options;
	}

	private Option buildStandardOption(String key, String desc) {
		Option o = new Option(key, desc);
		o.setOptionalArg(false);
		o.setRequired(true);
		o.setArgs(1);
		o.setType(String.class);
		o.setValueSeparator(' ');
		return o;
	}

	private void usage() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(getClass().getSimpleName(), posixOptions);
	}

	private void execute() throws Exception {


		final String optionValue = commandLine.getOptionValue("pdfSource");

		// System.out.println("Using option " + optionValue);

		switch (optionValue) {
		case CONST_FS_DIRECTORY_OUTPUT:
			runUsingFsDirectory();
			break;
		case CONST_HUMAN_OUTPUT:
			setOutputFileDirectory(CONST_HUMAN_OUTPUT);
			runUsingHumanText();
			break;
		case CONST_ITEXT_OUTPUT:
			setOutputFileDirectory(CONST_ITEXT_OUTPUT);
			runUsingItextText();
			break;
		default:
			setOutputFileDirectory(CONST_PDFBOX_OUTPUT);
			runUsingPdfBoxText();
			break;
		}
	}

	private void runUsingFsDirectory() throws Exception {
		executeDatabasePreparation();
		File d = new File("T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\PDF-Clean");
		File[] fArray = d.listFiles();
		int numberFilesProcessed = 0;
		for (File f : fArray) {
			String fileName = f.getName();
			System.out.println("Processing " + fileName);
			boolean isRunnable = fileName.compareTo("Hariharan-2002-Pancreas after kidne.clean") == 0;
			isRunnable = isRunnable || fileName.compareTo("Siemionow-2006-Controversies follow.clean") == 0;	
			isRunnable = isRunnable || fileName.compareTo("Wall-2004-Hepatocellular cance.clean") == 0;	
			isRunnable = isRunnable || true;
			if (isRunnable) {
				fileName = StringUtils.substringBefore(fileName, ".");
				fileName = "/" + fileName + "/";
				enlParsedEntry = new EndNoteLibraryOutput();
				enlParsedEntry.setInternalPdf(fileName);
				documentText = FileUtils.readFileToString(f);
				keywordsText = "";
				removeTableRows();
				executeDocument();
				numberFilesProcessed++;
				if (numberFilesProcessed % 10 == 0) {
					dataSourceManager = null;
					executeDatabasePreparation();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void runUsingHumanText() throws Exception {
		Criteria crit = dataSourceManager
				.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(Restrictions.and(Restrictions.isNotNull("humanPdf"),
						Restrictions.ne("humanPdf", "UNKNOWN")));
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		for (EndNoteLibraryOutput currentEnlParsedEntry : enlParsedEntries) {
			enlParsedEntry = currentEnlParsedEntry;
			documentText = currentEnlParsedEntry.getHumanPdf();
			keywordsText = currentEnlParsedEntry.getKeywords();
			executeDocument();
		}
	}

	@SuppressWarnings("unchecked")
	private void runUsingPdfBoxText() throws Exception {
		Criteria crit;
		crit = dataSourceManager
				.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(Restrictions.and(Restrictions.isNotNull("pdfText"),
						Restrictions.ne("pdfText", "UNKNOWN")));
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		for (EndNoteLibraryOutput currentEnlParsedEntry : enlParsedEntries) {
			enlParsedEntry = currentEnlParsedEntry;
			documentText = currentEnlParsedEntry.getPdfText();
			keywordsText = currentEnlParsedEntry.getKeywords();
			executeDocument();
		}
	}

	@SuppressWarnings("unchecked")
	private void runUsingItextText() throws Exception {
		Criteria crit;
		crit = dataSourceManager
				.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(Restrictions.and(Restrictions.isNotNull("iTextText"),
						Restrictions.ne("iTextText", "UNKNOWN")));
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		for (EndNoteLibraryOutput currentEnlParsedEntry : enlParsedEntries) {
			enlParsedEntry = currentEnlParsedEntry;
			documentText = currentEnlParsedEntry.getPdfText();
			keywordsText = currentEnlParsedEntry.getKeywords();
			executeDocument();
		}
	}

	public void executeDocument() throws Exception {
		conceptFinder = new ConceptFinder();
		conceptFinder.setTerminologyPath(commandLine
				.getOptionValue("coderResource"));
		conceptFinder.initialize();
		executeDocumentPreprocessing();
		activateKeywordConcepts();
		if (dbDoc.getContent().length() > CONST_MEDIAN_CHARS_PER_ABSTRACT) {
			executeDocumentSummarization();
		} else {
			copyOriginalContent();
		}
		executeDocumentCleanUp();
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
			dataSourceManager.setHibernateConnectionUrl(commandLine
					.getOptionValue("dbUrl"));
			dataSourceManager.setHibernateUserName(commandLine
					.getOptionValue("dbUser"));
			dataSourceManager.setHibernateUserPassword(commandLine
					.getOptionValue("dbPassword"));
			dataSourceManager.setHibernateShowSql(commandLine
					.getOptionValue("hibernateShowSql"));
			dataSourceManager.setHibernateHbm2ddlAuto(commandLine
					.getOptionValue("hibernateHbm2ddlAuto"));
		}
		return dataSourceManager;
	}

	@SuppressWarnings("unchecked")
	private void activateKeywordConcepts() {
		final String[] keywordLines = keywordsText.split("\n");
		final HashSet<String> uniqueKeywordConcepts = new HashSet<>();
		for (String keywordLine : keywordLines) {
			List<Annotation> conceptAnnotations = conceptFinder
					.findConcepts(keywordLine);
			for (Annotation conceptAnnot : conceptAnnotations) {
				uniqueKeywordConcepts.add(conceptAnnot.getUnderLyingText());
			}
		}
		final ArrayList<WordMention> pojosToSave = new ArrayList<>();
		for (String concept : uniqueKeywordConcepts) {
			Criteria crit = dataSourceManager.getSession()
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
		if (directory.exists() && directory.isDirectory()) {
			String documentName = dbDoc.getUrl();
			try (FileWriter writerForCluster = new FileWriter(new File(
					directory, documentName))) {
				writerForCluster.append(StringUtils.trimToEmpty(dbDoc
						.getContent()));
				writerForCluster.flush();
			}
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
		if (!pojosToSave.isEmpty()) {
			saveOrUpdatePojos(pojosToSave);
		}
		if (getDebugging()) {
			System.out.println("saveOrUpdatePojos");
		}
	}

	private void executeDocumentSummarization() throws SummarizationException,
			IOException {
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

	private void writeSummary(String completeSummary) throws IOException {
		File directory = new File(getOutputFileDirectory());
		if (directory.exists() && directory.isDirectory()) {
			String documentName = dbDoc.getUrl();
			try (FileWriter writerForCluster = new FileWriter(new File(
					directory, documentName))) {
				writerForCluster.append("TI - " + enlParsedEntry.getTitle()
						+ "\n");
				writerForCluster.append("AB - " + completeSummary + "\n");
				writerForCluster.flush();
			}
		}
	}

	private void insertDocument() throws TerminologyException {
		dbDoc = new Document();
		String relativePath = enlParsedEntry.getInternalPdf();
		relativePath = StringUtils.substringAfter(relativePath, "/");
		relativePath = StringUtils.substringBefore(relativePath, "/");
		relativePath += ".txt";
		dbDoc.setUrl(relativePath);
		dbDoc.setContent(documentText);
		dbDoc.setSequence(0);
		dbDoc.setCluster(0);
		pojosToSave.add(dbDoc);
		List<Annotation> sentenceAnnotations = SentenceFinderFactory
				.getInstance(
						SentenceFinderFactory.CONST_SENTENCE_FINDER_LINGPIPE)
				.annotateSentences(documentText);
		sSeq = 0;
		for (Annotation sentenceAnnotation : sentenceAnnotations) {
			if (isBadSentence(sentenceAnnotation)) {
				continue;
			}
			if (getDebugging()) {
				System.out.println("SENTENCE: "
						+ sentenceAnnotation.getUnderLyingText());
			}
			insertSentence(sentenceAnnotation);
			sSeq++;
		}
	}

	private void insertSentence(Annotation sentenceAnnot)
			throws TerminologyException {
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

		List<Annotation> nounPhraseMentionAnnots = conceptFinder.findConcepts(
				getAnnotationText(sentenceAnnot), sentenceAnnot.getsPos());
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

		Annotation wordMentionAnnot = new Annotation("WordMention",
				nounPhraseMentionAnnot.getsPos(),
				nounPhraseMentionAnnot.getePos(),
				nounPhraseMentionAnnot.getUnderLyingText());
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
		} catch (HibernateException x) {
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

	public void setOutputFileDirectory(String outputFileDirectory) {
		this.outputFileDirectory = outputFileDirectory;
	}

	public String getOutputFileDirectory() {
		return commandLine.getOptionValue("summaryOutput");
	}

	public void setRelativeScoring(Boolean isRelativeScoring) {
		this.isRelativeScoring = isRelativeScoring;
	}

	public Boolean getRelativeScoring() {
		return this.isRelativeScoring;
	}

	public void setMaxEolnsPerSentence(Integer maxEolnsPerSentence) {
		this.maxEolnsPerSentence = maxEolnsPerSentence;
	}

	public Integer getMaxEolnsPerSentence() {
		return this.maxEolnsPerSentence;
	}

	public void setSaveStopWords(Boolean saveStopWords) {
		this.saveStopWords = saveStopWords;
	}

	public Boolean getSaveStopWords() {
		return this.saveStopWords;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getHibernateDialect() {
		return this.hibernateDialect;
	}

	public Boolean getDebugging() {
		return new Boolean(commandLine.getOptionValue("isDebugging"));
	}

}
