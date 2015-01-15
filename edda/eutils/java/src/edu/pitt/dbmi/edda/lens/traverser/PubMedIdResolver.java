package edu.pitt.dbmi.edda.lens.traverser;

import java.util.Collection;
import java.util.List;

import edu.pitt.dbmi.edda.lens.consumer.DoiPdfFinder;
import edu.pitt.dbmi.edda.lens.consumer.EUtilsSearcher;
import edu.pitt.dbmi.edda.lens.digester.ArticleId;
import edu.pitt.dbmi.edda.lens.digester.ArticleLoader;
import edu.pitt.dbmi.edda.lens.digester.Id;
import edu.pitt.dbmi.edda.lens.digester.PubMedIdLoader;
import edu.pitt.dbmi.edda.rdbms.pojo.Publication;

public class PubMedIdResolver {

	public static void main(String[] args) {

	}
	
	private void identifyAndCache(Publication p) {
		try {
			EUtilsSearcher searcher = new EUtilsSearcher();
			searcher.setPublication(p);
			searcher.searchForPubMedId();
			Collection<Id> idList = searcher.getPubMedIds();
			String requestUrl = searcher.getRequest();
			p.setUriSearcher(requestUrl);
//			PubMedIdLoader pubMedIdLoader = new PubMedIdLoader();
//			pubMedIdLoader.setInputXml(responseXml);
//			pubMedIdLoader.execute();
//			List<Id> idsList = pubMedIdLoader.getIds();
//			if (!idsList.isEmpty()) {
//				Id pubMedId = idsList.get(0);
//				p.setPubMedId(pubMedId.getValue());
//			} else {
//				System.err
//						.println("Failed to find PMID for\n" + p.getTitle());
//				p.setPubMedId("UNKNOWN");
//			}
//			dataSourceManager.getSession().saveOrUpdate(p);
//			saveAndFlushSession();
		} catch (Exception x) {
			System.err.println(p);
		}

	}
	
//   	String responseXml = searcher.searchForArticle(publication.getPubMedId());
//	ArticleLoader articleIdLoader = new ArticleLoader();
//	articleIdLoader.setInputXml(responseXml);
//	articleIdLoader.execute();
//	String pdfUrl = "UNKNOWN";
//	for (ArticleId id : articleIdLoader.getArticleIds()) {
//		if (id.getArticleIdType().equals("doi")) {
//			DoiPdfFinder doiFinder = new DoiPdfFinder();
//			pdfUrl = doiFinder.findDoi(id.fetchValue());
//			if (pdfUrl.equals("UNKNOWN")) {
//				System.err.println(doiFinder.getRedirectedUri());
////				System.err.println(doiFinder.getRequest());
//			}
//			else {
//				System.out.println("Success pdf url is " + pdfUrl);
//			}
//		}
//		System.out.println(id);

}
