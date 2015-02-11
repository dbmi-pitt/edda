package edu.pitt.dbmi.edda.lens.traverser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Transaction;

import edu.pitt.dbmi.edda.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.rdbms.pojo.Publication;

public class Traverser {

	public static final String CONST_DATA_DIR_PATH = "T:\\EDDA\\DATA";

	private DataSourceManager dataSourceManager;

	public static void main(String[] args) {
		Traverser traverser = new Traverser();
		try {
			traverser.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Traverser() {
		;
	}

	public void execute() {
		try {
			initializeDataSourceManager();
			tryWalkDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void initializeDataSourceManager() {
		dataSourceManager = new DataSourceManager();
		dataSourceManager
				.setHibernateConnectionUrl("jdbc:mysql://localhost:3306/pdfg");
		dataSourceManager.setHibernateShowSql("true");
		dataSourceManager.setHibernateUserName("edda");
		dataSourceManager.setHibernateUserPassword("edda");
		dataSourceManager.setHibernateHbm2ddlAuto("create");
//		deletePublications();
	}

	public void tryWalkDirectory() throws IOException {
		IOFileFilter alwaysSelectFilter = FileFilterUtils.trueFileFilter();
		EddaDirectoryWalker walker = new EddaDirectoryWalker(alwaysSelectFilter);
		final String[] domains = { "GALACTOMANNAN" };
		walker.setDomains(domains);
		walker.setStartDirectoryPath(CONST_DATA_DIR_PATH);
		walker.walkDirectory();
		Collection<Object> fileObjs = walker.getResults();
		System.out.println("There are " + fileObjs.size() + " files");
		for (Object fileObj : fileObjs) {
			File f = (File) fileObj;
			Publication p = stuffPublicationFromFilePath(f);
			p = stuffPublicationFromFileContents(f, p);
			savePublication(p);
		}
	}

	private Publication stuffPublicationFromFileContents(File f, Publication p)
			throws IOException {
		LineIterator lineIterator = FileUtils.lineIterator(f);
		while (lineIterator.hasNext()) {
			String nextLine = lineIterator.next();
			if (nextLine.matches("^\\W*AU\\s+\\-.*")) {
				p.setAuthors(chompLineCategory(nextLine));
			} else if (nextLine.matches("^\\W*TI\\s+\\-.*")) {
				p.setTitle(chompLineCategory(nextLine));
			} else if (nextLine.matches("^\\W*AB\\s+\\-.*")) {
				p.setPublicationAbstract(chompLineCategory(nextLine));
			}
		}
		String fullText = FileUtils.readFileToString(f);
		p.setFileText(fullText);
		return p;
	}

	private Publication stuffPublicationFromFilePath(File f) {
		Publication p = new Publication();
		String filePath = f.getPath();
		Scanner sc = 	new Scanner(filePath);
		System.out.println(File.separator);
		sc.useDelimiter("\\\\");
		ArrayList<String> pathParts = new ArrayList<String>();
		while (sc.hasNext()) {
			pathParts.add(sc.next());
		}
		sc.close();
		p.setDomain(pathParts.get(3));
		p.setPartition(generalizePartition(pathParts.get(6)));
		p.setClassification(generalizeClassification(pathParts.get(7)));
		p.setFileName(generalizeFileName(pathParts.get(pathParts.size()-1)));
		return p;
	}

	private String generalizeFileName(String fileName) {
		String result = null;
		Pattern digits = Pattern.compile("\\d+");
		Matcher matcher = digits.matcher(fileName);
		if (matcher.find()) {
			result = matcher.group(0);
		}
	return result;
}

	@SuppressWarnings("unused")
	private void deletePublications() {
		Query q = dataSourceManager.getSession().createSQLQuery(
				"drop table if exists Publication");
		q.executeUpdate();
	}



	private String generalizePartition(String rawPartition) {
		String formattedResponse = "UNKNOWN";
		Pattern p = Pattern.compile("TEST|TRAIN|A|B");
		Matcher m = p.matcher(rawPartition);
		if (m.find()) {
			formattedResponse = m.group(0);
			if (formattedResponse.equals("TEST")) {
				formattedResponse = "B";
			}
			else if (formattedResponse.equals("TRAIN")) {
				formattedResponse = "A";
			}
		}
		return formattedResponse;
	}
	
	private String generalizeClassification(String classification) {
		String formattedResponse = "UNKNOWN";
		Pattern p = Pattern.compile("Y|N");
		Matcher m = p.matcher(classification);
		if (m.find()) {
			formattedResponse = m.group(0);
		}
		return formattedResponse;
	}

	private void savePublication(Publication p) {
		dataSourceManager.getSession().saveOrUpdate(p);
		saveAndFlushSession();
	}

	private void saveAndFlushSession() {
		Transaction tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().flush();
		tx.commit();
	}

	private String chompLineCategory(String line) {
		String result = StringUtils.substringAfter(line, "-");
		result = StringUtils.trimToEmpty(result);
		return result;
	}

}
