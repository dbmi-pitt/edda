package edu.pitt.dbmi.edda.rdbms;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.rdbms.pojo.Publication;

public class HibernateTester {

	private Session session;

	public static void main(String[] args) {
		HibernateTester tester = new HibernateTester();
		tester.execute();

	}

	private void execute() {
		DataSourceManager dataSourceManager = new DataSourceManager();
		dataSourceManager
				.setHibernateConnectionUrl("jdbc:mysql://localhost:3306/pdf");
		dataSourceManager.setHibernateShowSql("true");
		dataSourceManager.setHibernateUserName("edda");
		dataSourceManager.setHibernateUserPassword("edda");
		dataSourceManager.setHibernateHbm2ddlAuto("update");
		session = dataSourceManager.getSession();
		deletePublications();
		Publication publication = new Publication();
		publication.setTitle("Tebeka-Mitchell Summary");
		publication.setAuthors("Mitchell K.J., Tebeka T. B.");
		publication.setAuthors("Text Summerization");
		publication.setPublicationAbstract("Stuff using Text Summerization");
		publication.setClassification("include");
		publication.setPubMedId("PM0000");
		session.saveOrUpdate(publication);
		saveAndFlushSession();
		
		displayPublications();
	}

	private void deletePublications() {
		Query q = session.createQuery("delete Publication");
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	private void displayPublications() {
		List<Publication> publications = session.createCriteria(Publication.class)
				.add(Restrictions.like("title", "%Mitchell%")).list();
		for (Publication publication : publications) {
			System.out.println(publication);
		}
	}

	private void saveAndFlushSession() {
		Transaction tx = session.beginTransaction();
		session.flush();
		tx.commit();
	}

}
