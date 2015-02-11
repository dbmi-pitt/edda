package edu.pitt.dbmi.edda.lens.traverser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.lens.consumer.EUtilsSearcher;
import edu.pitt.dbmi.edda.lens.digester.Id;
import edu.pitt.dbmi.edda.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.rdbms.pojo.Publication;

public class PubMedIdFinder {

	private DataSourceManager dataSourceManager;
	private EUtilsSearcher searcher = new EUtilsSearcher();

	public static void main(String[] args) {
		PubMedIdFinder pubMedIdFinder = new PubMedIdFinder();
		try {
			pubMedIdFinder.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PubMedIdFinder() {
		;
	}

	public void execute() throws IOException {
		initializeDataSourceManager();
		deriveSearchUris();
		deriveIdLists();
	}

	@SuppressWarnings("unchecked")
	private void deriveIdLists() {
		Criteria crit = dataSourceManager.getSession().createCriteria(
				Publication.class);
		crit.add(Restrictions.and(Restrictions.eq("pubMedId", "UNKNOWN"),
				Restrictions.ne("uriSearcher", "UNKNOWN")
				));
		
		List<Publication> publications = crit.list();
		for (Publication publication : publications) {
			tryDeriveIdList(publication);
		}
	}

	private void tryDeriveIdList(Publication publication) {
		searcher = new EUtilsSearcher();
		searcher.setPublication(publication);
		searcher.searchForPubMedId();
		parseResponse(publication);
		updatePublication(publication);
	}
	
	private void updatePublication(Publication publication) {
		Transaction tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().saveOrUpdate(publication);
		dataSourceManager.getSession().flush();
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	private void deriveSearchUris() {
		Criteria crit = dataSourceManager.getSession().createCriteria(
				Publication.class);
		crit.add(Restrictions.and(Restrictions.eq("pubMedId", "UNKNOWN"),
				Restrictions.eq("uriSearcher", "UNKNOWN")
				));
		List<Publication> publications = crit.list();
		for (Publication publication : publications) {
			tryDeriveSearchUri(publication);
		}
	}

	private void tryDeriveSearchUri(Publication publication) {
		try {
			deriveSearchUri(publication);
		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	private void deriveSearchUri(Publication publication)
			throws UnsupportedEncodingException {
		searcher = new EUtilsSearcher();
		searcher.setPublication(publication);
		searcher.createHttpGetQuery();
		publication.setUriSearcher(searcher.getRequest());
		updatePublication(publication);
	}

	private void parseResponse(Publication publication) {
		Collection<Id> idCollection = searcher.getPubMedIds();
		String pubMedId = "UNKNOWN";
		if (idCollection.size() == 0) {
			pubMedId = "MISSING";
		} else if (idCollection.size() > 1) {
			pubMedId = "VAGUE";
		} else if (idCollection.size() == 1) {
			pubMedId = idCollection.iterator().next().getValue();
		}
		System.out.println("Setting pubMedId to be " + pubMedId);
		publication.setPubMedId(pubMedId);
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

}
