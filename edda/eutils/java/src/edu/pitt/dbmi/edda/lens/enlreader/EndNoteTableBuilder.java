package edu.pitt.dbmi.edda.lens.enlreader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.examples.PDFToTextConverter;
import edu.pitt.dbmi.edda.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.rdbms.pojo.EndNoteLibraryEntry;
import edu.pitt.dbmi.edda.rdbms.pojo.EndNoteLibraryOutput;

public class EndNoteTableBuilder {

	public static final String CONST_DATA_PATH = "T:\\EDDA\\DATA\\"
			+ "GALACTOMANNAN\\ENL_for_ReferenceFiler\\Galacto_Enriched_March20-with-PDFs.txt";

	public static final String CONST_PDF_PATH = "T:\\EDDA\\DATA\\"
			+ "GALACTOMANNAN\\ENL_for_ReferenceFiler\\"
			+ "Galacto_Enriched_March20-with-PDFs.Data\\PDF\\";

	private DataSourceManager dataSourceManager;

	private static final String[] sectionNames = { "Reference Type:",
			"Record Number:", "Author:", "Year:", "Title:", "Journal:",
			"Original Publication:", "Volume:", "Issue:", "Pages:",
			"Epub Date:", "Date:", "Short Title:", "ISSN:", "DOI:", "PMCID:",
			"Accession Number:", "Keywords:", "Abstract:", "Notes:", "URL:",
			"Author Address:", "Database Provider:", "Language:" };

	private static final String[][] mutatorCrossReferenceTable = {
			{ "setAbstract", "setEntryAbstract" },
			{ "setDate", "setEntryDate" } };
	private static HashMap<String, String> mutatorCrossReferenceMap = new HashMap<String, String>();

	static {
		for (String[] mutatorKeyValuePair : mutatorCrossReferenceTable) {
			mutatorCrossReferenceMap.put(mutatorKeyValuePair[0],
					mutatorKeyValuePair[1]);
		}
	}

	public static void main(String[] args) {
		EndNoteTableBuilder builder = new EndNoteTableBuilder();
		// builder.executeCreate();
		// builder.executeUpdate();
		 builder.executePdfs();
		
	}
	
	@SuppressWarnings("unused")
	private void executeCreate() {
		try {
			initializeDataSourceManager();
			dataSourceManager.setHibernateHbm2ddlAuto("create");
			cacheFullEntries();
			parseEnlEntries();
			storePdfsForEmptyAbstracts();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void executePdfs() {
		try {
			initializeDataSourceManager();
			dataSourceManager.setHibernateHbm2ddlAuto("update");
			storePdfsForEmptyAbstracts();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void storePdfsForEmptyAbstracts() {
		Criteria crit = dataSourceManager.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(Restrictions.isNotNull("internalPdf"))
				.add(Restrictions.ne("internalPdf", "UNKNOWN"))
				.add(Restrictions.eq("entryAbstract", "UNKNOWN"));
		crit.list();
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		for (EndNoteLibraryOutput enlParsedEntry : enlParsedEntries) {
			System.out.println(enlParsedEntry.getInternalPdf());
			processPdf(enlParsedEntry);
		}
	}

	private void processPdf(EndNoteLibraryOutput enlParsedEntry) {
		if (!enlParsedEntry.getInternalPdf().equals("UNKNOWN")
				&& !enlParsedEntry.getInternalPdf().contains("Agarwal")) {
			String pdfAsText = PDFToTextConverter.getInstance()
					.convertPDFToText(CONST_PDF_PATH
							+ enlParsedEntry.getInternalPdf());
			enlParsedEntry.setPdfText(pdfAsText);
			Transaction tx = dataSourceManager.getSession().beginTransaction();
			dataSourceManager.getSession().saveOrUpdate(enlParsedEntry);
			dataSourceManager.getSession().flush();
			tx.commit();
		}
	}

	@SuppressWarnings("unused")
	private void executeUpdate() {
		try {
			initializeDataSourceManager();
			dataSourceManager.setHibernateHbm2ddlAuto("update");
			parseEnlEntries();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void initializeDataSourceManager() throws IOException {
		dataSourceManager = new DataSourceManager();
		dataSourceManager
				.setHibernateConnectionUrl("jdbc:mysql://localhost:3306/enl");
		dataSourceManager.setHibernateShowSql("true");
		dataSourceManager.setHibernateUserName("edda");
		dataSourceManager.setHibernateUserPassword("edda");

	}

	public void cacheFullEntries() throws IOException {
		File file = new File(CONST_DATA_PATH);
		if (file.exists() && file.isFile()) {
			LineIterator lineIterator = FileUtils.lineIterator(file);
			int recordNumber = 1;
			String accumulator = "";
			String line = null;
			while (lineIterator.hasNext()) {
				line = lineIterator.next();
				line = line.replaceAll("^\\W*", ""); // Clear away control
														// characters at
														// beginning.
				if (line.startsWith("Reference Type:")) {
					if (accumulator.length() > 0) {
						EndNoteLibraryEntry entry = new EndNoteLibraryEntry();
						entry.setRecordNumber(recordNumber++);
						entry.setRecordText(accumulator);
						Transaction tx = dataSourceManager.getSession()
								.beginTransaction();
						dataSourceManager.getSession().saveOrUpdate(entry);
						dataSourceManager.getSession().flush();
						tx.commit();
						accumulator = "";
					}
				}
				accumulator += line + "\n";
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void parseEnlEntries() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Criteria crit = dataSourceManager.getSession().createCriteria(
				EndNoteLibraryEntry.class);
		List<EndNoteLibraryEntry> enlEntries = crit.list();
		for (EndNoteLibraryEntry enlEntry : enlEntries) {
			parseEnlEntry(enlEntry);
		}
	}

	private void parseEnlEntry(EndNoteLibraryEntry enlEntry)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		String recordText = enlEntry.getRecordText();
		final TreeSet<Annotation> sortedSectionHeaderFragments = extractSectionHeaders(recordText);
		final Stack<Annotation> annotationStack = stackSectionHeaders(sortedSectionHeaderFragments);
		final TreeSet<Annotation> sortedSectionBodyFragments = grabInterspersedTextAsBodyFragments(
				recordText, annotationStack);
		storeToDatabase(sortedSectionHeaderFragments,
				sortedSectionBodyFragments);
	}

	private TreeSet<Annotation> extractSectionHeaders(String recordText) {
		Pattern pattern = buildRegex();
		Matcher matcher = pattern.matcher(recordText);
		final TreeSet<Annotation> sortedSectionHeaderFragments = new TreeSet<Annotation>(
				Annotation.annotationComparator);
		while (matcher.find()) {
			sortedSectionHeaderFragments.add(new Annotation("sectionHeader",
					matcher.start(), matcher.end(), matcher.group()));
		}
		return sortedSectionHeaderFragments;
	}

	private Stack<Annotation> stackSectionHeaders(
			TreeSet<Annotation> sortedSectionHeaderFragments) {
		final Stack<Annotation> annotationStack = new Stack<Annotation>();
		for (Iterator<Annotation> descendingIterator = sortedSectionHeaderFragments
				.descendingIterator(); descendingIterator.hasNext();) {
			annotationStack.push(descendingIterator.next());
		}
		return annotationStack;
	}

	private TreeSet<Annotation> grabInterspersedTextAsBodyFragments(
			String recordText, Stack<Annotation> annotationStack) {
		final TreeSet<Annotation> sortedSectionBodyFragments = new TreeSet<Annotation>(
				Annotation.annotationComparator);
		while (annotationStack.size() > 1) {
			Annotation annotOne = annotationStack.pop();
			Annotation annotTwo = annotationStack.peek();
			String underLyingText = recordText.substring(annotOne.getePos(),
					annotTwo.getsPos());
			sortedSectionBodyFragments.add(new Annotation("sectionBody",
					annotOne.getePos(), annotTwo.getsPos(), underLyingText));
		}
		if (annotationStack.size() == 1) {
			Annotation annotOne = annotationStack.pop();
			String underLyingText = recordText.substring(annotOne.getePos(),
					recordText.length());
			sortedSectionBodyFragments.add(new Annotation("sectionBody",
					annotOne.getePos(), recordText.length(), underLyingText));
		}
		return sortedSectionBodyFragments;
	}

	private void storeToDatabase(
			TreeSet<Annotation> sortedSectionHeaderFragments,
			TreeSet<Annotation> sortedSectionBodyFragments)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		EndNoteLibraryOutput enlOutput = new EndNoteLibraryOutput();
		Iterator<Annotation> headerIterator = sortedSectionHeaderFragments
				.iterator();
		Iterator<Annotation> bodyIterator = sortedSectionBodyFragments
				.iterator();
		while (headerIterator.hasNext() && bodyIterator.hasNext()) {
			Annotation header = headerIterator.next();
			Annotation body = bodyIterator.next();
			String bodyText = StringUtils.chomp(body.getUnderLyingText());
			bodyText = StringUtils.trimToEmpty(bodyText);
			System.out.println(header.getUnderLyingText() + "\n" + bodyText);
			String methodName = convertHeaderToMutatorName(header);
			Method mutator = getMethodForMethodName(enlOutput.getClass(),
					methodName);
			if (mutator == null) {
				System.err.println("no mutator for " + methodName);
			} else if (mutator.getParameterTypes()[0] == String.class) {
				final Object[] stringParameters = { bodyText };
				mutator.invoke(enlOutput, stringParameters);
			} else if (mutator.getParameterTypes()[0] == Integer.class) {
				final Object[] parameters = { new Integer(bodyText) };
				mutator.invoke(enlOutput, parameters);
			} else if (mutator.getParameterTypes()[0] == Long.class) {
				final Object[] parameters = { new Long(bodyText) };
				mutator.invoke(enlOutput, parameters);
			} else {
				System.err.println(mutator.getName() + " has signature with "
						+ enlOutput.getClass().getName());
			}
		}
		extractAndStoreInternalPdfAttachement(enlOutput);
		Transaction tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().saveOrUpdate(enlOutput);
		dataSourceManager.getSession().flush();
		tx.commit();
	}

	private void extractAndStoreInternalPdfAttachement(
			EndNoteLibraryOutput enlOutput) {
		Pattern pattern = Pattern
				.compile("internal-pdf\\:\\/\\/\\d+\\/[^\\.]+\\.pdf");
		Matcher matcher = pattern.matcher(StringUtils.trimToEmpty(enlOutput
				.getUrl()));
		if (matcher.find()) {
			String internalPdf = matcher.group(0);
			internalPdf = StringUtils.substringAfter(internalPdf,
					"internal-pdf:/");
			enlOutput.setInternalPdf(internalPdf);
		} else {
			matcher = pattern.matcher(StringUtils.trimToEmpty(enlOutput
					.getNotes()));
			if (matcher.find()) {
				String internalPdf = matcher.group(0);
				internalPdf = StringUtils.substringAfter(internalPdf,
						"internal-pdf:/");
				enlOutput.setInternalPdf(internalPdf);
			}
		}
	}

	private Method getMethodForMethodName(Class<?> cls, String methodName) {
		Method[] methods = cls.getMethods();
		Method resultMethod = null;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				resultMethod = method;
			}
		}
		return resultMethod;
	}

	private String convertHeaderToMutatorName(Annotation header) {
		String headerText = header.getUnderLyingText();
		headerText = headerText.replaceAll("[^a-zA-Z ]", "");
		headerText = StringUtils.trim(headerText);
		String[] mutatorNameParts = headerText.split("\\s+");
		for (int idx = 0; idx < mutatorNameParts.length; idx++) {
			mutatorNameParts[idx] = StringUtils
					.capitalize(mutatorNameParts[idx].toLowerCase());
		}
		String mutatorName = "set" + StringUtils.join(mutatorNameParts);
		if (mutatorCrossReferenceMap.get(mutatorName) != null) {
			mutatorName = mutatorCrossReferenceMap.get(mutatorName);
		}
		return mutatorName;
	}

	private Pattern buildRegex() {
		StringBuffer sb = new StringBuffer();
		for (String sectionName : sectionNames) {
			sectionName = sectionName.replaceAll("\\s", "\\\\s");
			if (sb.length() > 0) {
				sb.append("|");
			}
			sb.append("^\\W*" + sectionName);
		}
		return Pattern.compile(sb.toString(), Pattern.MULTILINE);
	}
}
