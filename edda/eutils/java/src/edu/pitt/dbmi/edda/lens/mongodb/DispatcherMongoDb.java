package edu.pitt.dbmi.edda.lens.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBDecoder;
import com.mongodb.DBObject;
import com.mongodb.DefaultDBDecoder;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import edu.pitt.dbmi.edda.lens.openi.DispatcherOpenI;

public class DispatcherMongoDb {
	
	private static String CONST_QUERY = "http://openi.nlm.nih.gov/retrieve.php?query=DOC[Article]AREA[PMID]20398291";

	public static void main(String[] args) {
		DispatcherMongoDb dispatcherMongoDb = new DispatcherMongoDb();
		try {
			dispatcherMongoDb.execute();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public DispatcherMongoDb() {
	}

	public void execute() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("edda");
		DBCollection pubmedArticleCollection = db
				.getCollection("pubmedArticle");
		DispatcherOpenI dispatcherOpenI = new DispatcherOpenI();
		String jsonQueryResponse = dispatcherOpenI.executeQuery(CONST_QUERY);
		System.out.println(jsonQueryResponse.substring(0, 10));
		int len = jsonQueryResponse.length();
		System.out.println(jsonQueryResponse.substring(len - 10, len));
		DBObject decodedJsonQueryResponse = (DBObject) JSON.parse(jsonQueryResponse);
		pubmedArticleCollection.insert(decodedJsonQueryResponse);
		DBObject fetchedJsonQueryResponse = pubmedArticleCollection.findOne();
		System.out.println(fetchedJsonQueryResponse);
	}


}
