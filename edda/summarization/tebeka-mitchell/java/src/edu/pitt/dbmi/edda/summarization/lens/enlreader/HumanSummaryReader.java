package edu.pitt.dbmi.edda.summarization.lens.enlreader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.summarization.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.EndNoteLibraryOutput;

public class HumanSummaryReader {

	public static final String CONST_DATA_PATH = "T:\\EDDA\\DATA\\"
			+ "GALACTOMANNAN\\Text Excerpts_Corey\\Text Excerpts";

	private DataSourceManager dataSourceManager;

	public static void main(String[] args) {
		HumanSummaryReader humanSummaryReader = new HumanSummaryReader();
		humanSummaryReader.executeUpdate();
	}

	public HumanSummaryReader() {
		;
	}

	public void executeUpdate() {
		try {
			initializeDataSourceManager();
			dataSourceManager.setHibernateHbm2ddlAuto("update");

			cacheFullEntries();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void cacheFullEntries() throws IOException {
		File humanAnnotatedDirectory = new File(CONST_DATA_PATH);
		if (humanAnnotatedDirectory.exists()
				&& humanAnnotatedDirectory.isDirectory()) {
			final File[] files = humanAnnotatedDirectory.listFiles();
			for (File file : files) {
				String internalPdf = StringUtils.substringBefore(
						file.getName(), "_");
				System.out.println("Got id of " + internalPdf);
				if (internalPdf.equals(".DS")) {
					continue;
				}
				Criteria crit = dataSourceManager
						.getSession()
						.createCriteria(EndNoteLibraryOutput.class)
						.add(Restrictions.like("internalPdf", "%" + internalPdf
								+ "%"));
				EndNoteLibraryOutput enlParsedEntry = (EndNoteLibraryOutput) crit
						.uniqueResult();
				String content = FileUtils.readFileToString(file);
				enlParsedEntry.setHumanPdf(content);
				Transaction tx = dataSourceManager.getSession()
						.beginTransaction();
				dataSourceManager.getSession().saveOrUpdate(enlParsedEntry);
				dataSourceManager.getSession().flush();
				tx.commit();
			}
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

}
