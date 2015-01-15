package edu.pitt.dbmi.edda.lens.traverser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.rdbms.pojo.EndNoteLibraryOutput;

public class EddaRdbmsToFileSystemTransferer {
	
	private DataSourceManager dataSourceManager;

	public static void main(String[] args) {
		try {
			EddaRdbmsToFileSystemTransferer xFerer = new EddaRdbmsToFileSystemTransferer();
			xFerer.initialize();
			xFerer.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private void initialize() {
		createOrUseCachedDataSourceManager();
		
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
	private void execute() throws IOException {
		Criterion c1 = Restrictions.isNotNull("pdfText");
		Criterion c2 = Restrictions.ne("pdfText", "UNKNOWN");
		Criterion c3 = Restrictions.and(c1, c2);
		Criterion c4 = 
				Restrictions.eq("entryAbstract", "UNKNOWN");
		Criterion c5 = Restrictions.and(c3, c4);
		Criteria crit = dataSourceManager
				.getSession()
				.createCriteria(EndNoteLibraryOutput.class)
				.add(c5).addOrder(Order.asc("internalPdf"));			
		List<EndNoteLibraryOutput> enlParsedEntries = crit.list();
		File outputDirectory = new File("C:\\Users\\kjm84\\Desktop\\NoAbstractPdfs43");
		for (EndNoteLibraryOutput enlParsedEntry : enlParsedEntries) {
			String pdfText = enlParsedEntry.getPdfText();
			String internalPdf = enlParsedEntry.getInternalPdf();
			System.out.println(internalPdf);
			String[] pathParts = internalPdf.split("\\/");
			File subDirectory = new File(outputDirectory, pathParts[1]);
			subDirectory.mkdir();
			File pdfAsTextFile = new File(subDirectory, pathParts[2].replaceAll("pdf", "txt"));
			FileUtils.write(pdfAsTextFile, pdfText);			
		}
	}

	
}
