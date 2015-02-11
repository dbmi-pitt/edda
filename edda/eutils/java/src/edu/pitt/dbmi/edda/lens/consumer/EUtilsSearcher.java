package edu.pitt.dbmi.edda.lens.consumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import edu.pitt.dbmi.edda.lens.digester.Id;
import edu.pitt.dbmi.edda.lens.digester.PubMedIdLoader;
import edu.pitt.dbmi.edda.lens.traverser.StopWordDetector;
import edu.pitt.dbmi.edda.rdbms.pojo.Publication;

public class EUtilsSearcher extends RestConsumer {

	private final ArrayList<String> titleTokens = new ArrayList<String>();
	private final ArrayList<String> authorTokens = new ArrayList<String>();
	private final ArrayList<Id> pubMedIds = new ArrayList<Id>();
	
	private static final String[] pmids = {"20166072", "21735422", "18843747"};

	public ArrayList<Id> getPubMedIds() {
		return pubMedIds;
	}

	private Publication publication;
	private String state = "TITLE_SHRINKING";
	private int tBoundary = -1;
	private int aBoundary = -1;
	private int zeroCalls = 4;
	private int twoCalls = 3;

	// R. R. Klont, M. A. Mennink-Kersten and P. E. Verweij
	// Utility of Aspergillus antigen detection in specimens other than serum
	// specimens

	public static void main(String[] args) {
//		testOne(args);
		testTwo(args);
	}
	
	private static void testTwo(String[] args) {
		
		for (String pmid : pmids) {
			EUtilsSearcher searcher = new EUtilsSearcher();
			Publication publication = new Publication();
			String articleXml = searcher.searchForArticle(pmid);
			System.out.println(articleXml);
		}
	}

	public static void testOne(String[] args) {
		EUtilsSearcher searcher = new EUtilsSearcher();
		Publication publication = new Publication();
		publication
				.setAuthors("R. R. Klont, M. A. Mennink-Kersten and P. E. Verweij ");
		publication
				.setTitle("Utility of Aspergillus antigen detection in specimens other than serum specimens");
		searcher.setPublication(publication);
		searcher.searchForPubMedId();
	}

	public EUtilsSearcher() {
		;
	}
	
	public void searchForPubMedId() {
		setRequest(publication.getUriSearcher());
		System.out.println("Searching ==> " + getRequest());
		executePost();
    	deriveIdListFromResponse(getResponse());
	}
	
	public void createHttpGetQuery() {
		tokenize(publication.getTitle(), titleTokens);
		tokenize(publication.getAuthors(), authorTokens);
		sortTokensBySize(titleTokens);
		sortTokensBySize(authorTokens);
		StringBuffer requestBuffer = new StringBuffer();
		requestBuffer.append(CONST_ENTREZ_PATH);
		requestBuffer.append("esearch.fcgi?db=pubmed&term=");
		for (int idx = 0; idx < Math.min(titleTokens.size(), 4); idx++) {
			requestBuffer.append(titleTokens.get(idx) + "[ti]+");
		}
		for (int idx = 0; idx < Math.min(authorTokens.size(), 2); idx++) {
			requestBuffer.append(authorTokens.get(idx) + "[au]+");
		}
		String requestAsString = requestBuffer.toString();
		requestAsString = StringUtils.stripEnd(requestAsString, "+");
		setRequest(requestAsString);
	}


	private void sortTokensBySize(List<String> tokens) {
		Collections.sort(tokens, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		
	}

	public void searchForPubMedIdIteratively() {
		tokenize(publication.getTitle(), titleTokens);
		tokenize(publication.getAuthors(), authorTokens);
		Collections.sort(authorTokens, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		tBoundary = titleTokens.size();
		aBoundary = 0;
		state = "TITLE_SHRINKING";
		while (!state.equals("FINISHED")) {
			String requestUrl = formulateQuery();
			System.out.println(requestUrl);
			setRequest(requestUrl);
			setUrlSanitizer(new OpenEyeUrlSanitizer());
			executeQuery();
			deriveIdListFromResponse(getResponse());
			if (pubMedIds.size() == 1 || tBoundary < 0
					|| aBoundary > authorTokens.size()) {
				state = "FINISHED";
			} else if (state.equals("TITLE_SHRINKING")) {
				if (pubMedIds.size() == 0) {
					tBoundary--;
				} else if (pubMedIds.size() > 0) {
					aBoundary = 1;
					state = "AUTHOR_POPPING";
				}
			} else if (state.equals("AUTHOR_POPPING")) {
				if (pubMedIds.size() == 0) {
					tBoundary--;
					state = "TITLE_SHRINKING";
				} else if (pubMedIds.size() > 0) {
					aBoundary++;
					state = "AUTHOR_POPPING";
				}
			}
		}
		if (pubMedIds.size() == 1) {
			System.out.println("Success: pubmedId = " + pubMedIds.get(0));
		} else if (pubMedIds.size() > 1) {
			System.out.println("Choosing first one: pubmedId = "
					+ pubMedIds.get(0));
		} else if (pubMedIds.size() == 0) {
			System.out.println("Found no pubmed id here. ");
		}
	}

	private void deriveIdListCleverly() {
		pubMedIds.clear();
		if (zeroCalls > 0) {
			zeroCalls--;
		} else if (twoCalls > 0) {
			twoCalls--;
			pubMedIds.add(new Id());
			pubMedIds.add(new Id());
		} else {
			pubMedIds.add(new Id());
		}
	}

	private void deriveIdListRandomly() {
		Random generator = new Random((new Date()).getTime());
		int idListSize = generator.nextInt(2);
		pubMedIds.clear();
		if (idListSize >= 1) {
			pubMedIds.add(new Id());
		}
		if (idListSize >= 2) {
			pubMedIds.add(new Id());
		}
	}

	private void deriveIdListFromResponse(String response) {
		PubMedIdLoader loader = new PubMedIdLoader();
		loader.setInputXml(response);
		loader.execute();
		pubMedIds.clear();
		pubMedIds.addAll(loader.getIds());
	}

	private String formulateQuery() {
		StringBuffer requestBuffer = new StringBuffer();
		requestBuffer.append(CONST_ENTREZ_PATH);
		requestBuffer.append("esearch.fcgi?db=pubmed&term=");
		requestBuffer.append(transformToQuery());
		String requestUrl = requestBuffer.toString();
		return requestUrl;
	}

	private String transformToQuery() {
		String query = "";
		if (state.equals("TITLE_SHRINKING")) {
			query = transformTitleShrinking();
		} else if (state.equals("AUTHOR_POPPING")) {
			query = transformAuthorPopping();
		}
		return query;
	}

	private String transformAuthorPopping() {
		String query = transformTitleShrinking();
		for (int aIdx = 0; aIdx < aBoundary; aIdx++) {
			query += "+" + authorTokens.get(aIdx) + "[au]";
		}
		if (query.startsWith("+")) {
			query = query.substring(1, query.length());
		}
		return query;
	}

	private String transformTitleShrinking() {
		String query = "";
		for (int tIdx = 0; tIdx < tBoundary; tIdx++) {
			query += titleTokens.get(tIdx) + "[ti]+";
		}
		if (query.endsWith("+")) {
			query = query.substring(0, query.length() - 1);
		}
		return query;
	}

	private void tokenize(String tgt, ArrayList<String> tokensTgt) {
		final String[] tokenCandidates = tgt.replaceAll("[^a-zA-Z0-9\\- ]", " ")
				.toLowerCase().split("\\s+");
		HashSet<String> uniqueFilter = new HashSet<String>();
		StopWordDetector stopWordDetector = new StopWordDetector();
		for (String token : tokenCandidates) {
			boolean isViableToken = !stopWordDetector.isStopWord(token);
			isViableToken = isViableToken && token.length() > 2;
			if (isViableToken) {
				uniqueFilter.add(token);
			}
		}
		tokensTgt.addAll(uniqueFilter);
	}

	public String searchForArticle(String pubMedId) {
		StringBuffer requestBuffer = new StringBuffer();
		requestBuffer.append(CONST_ENTREZ_PATH);
		requestBuffer.append("efetch.fcgi?db=pubmed&id=");
		requestBuffer.append(pubMedId);
		requestBuffer.append("&retmode=xml");
		requestBuffer.append("&rettype=medline");
		String requestUrl = requestBuffer.toString();
		setRequest(requestUrl);
		System.out.println(requestUrl);
		setUrlSanitizer(new PassThruUrlSanitizer());
		executeQuery();
		return getResponse();
	}

	@SuppressWarnings("unused")
	private String reduceToWords(String title) {
		char[] chars = title.toCharArray();
		ArrayList<String> tokens = new ArrayList<String>();
		String currentToken = "";
		for (char c : chars) {
			if (Character.isAlphabetic(c) || Character.isDigit(c)) {
				currentToken += c;
			} else if (c != '[' || tokens.size() == 0) {
				if (currentToken.length() > 0) {
					tokens.add(currentToken);
					currentToken = "";
				}
			} else { // c is '[' and we have words so stop
				break;
			}
		}
		String result = StringUtils.join(tokens, "+");
		return result;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}
}
