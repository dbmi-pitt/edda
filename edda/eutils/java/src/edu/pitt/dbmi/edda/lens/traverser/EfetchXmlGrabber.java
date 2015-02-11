package edu.pitt.dbmi.edda.lens.traverser;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.lens.consumer.EUtilsSearcher;
import edu.pitt.dbmi.edda.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.rdbms.pojo.Publication;

public class EfetchXmlGrabber {

	private DataSourceManager dataSourceManager;
	private EUtilsSearcher searcher = new EUtilsSearcher();

	public static void main(String[] args) {
		EfetchXmlGrabber efetchXmlGrabber = new EfetchXmlGrabber();
		try {
			efetchXmlGrabber.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public EfetchXmlGrabber() {
	
	}

	public void execute() throws IOException {
		initializeDataSourceManager();
		eFetchXml();

	}

	@SuppressWarnings("unchecked")
	private void eFetchXml() {
		Criteria crit = dataSourceManager.getSession().createCriteria(
				Publication.class);
		crit.add(Restrictions.and(Restrictions.eq("classification", "Y"),
				Restrictions.and(Restrictions.ne("pubMedId", "MISSING"),
						Restrictions.ne("pubMedId", "VAGUE"))));
		List<Publication> publications = crit.list();
		for (Publication publication : publications) {
			tryEFetchXml(publication);
		}
	}

	private void tryEFetchXml(Publication publication) {
		String payLoadXml = searcher.searchForArticle(publication.getPubMedId());
		System.out.println( payLoadXml);
		publication.setEfetchXml(payLoadXml);
		updatePublication(publication);
	}

	private void initializeDataSourceManager() {
		dataSourceManager = new DataSourceManager();
		dataSourceManager
				.setHibernateConnectionUrl("jdbc:mysql://localhost:3306/pdfg");
		dataSourceManager.setHibernateShowSql("true");
		dataSourceManager.setHibernateUserName("edda");
		dataSourceManager.setHibernateUserPassword("edda");
		dataSourceManager.setHibernateHbm2ddlAuto("update");
	}
	
	private void updatePublication(Publication publication) {
		Transaction tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().saveOrUpdate(publication);
		dataSourceManager.getSession().flush();
		tx.commit();
	}
}
