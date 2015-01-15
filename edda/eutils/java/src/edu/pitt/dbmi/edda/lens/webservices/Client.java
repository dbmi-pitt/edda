package edu.pitt.dbmi.edda.lens.webservices;

import gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceSoapProxy;
import gov.nih.nlm.ncbi.www.soap.eutils.egquery.EGqueryRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.egquery.Result;
import gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchResult;
import gov.nih.nlm.ncbi.www.soap.eutils.espell.ESpellRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.espell.ESpellResult;
import gov.nih.nlm.ncbi.www.soap.eutils.esummary.DocSumType;
import gov.nih.nlm.ncbi.www.soap.eutils.esummary.ESummaryRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.esummary.ESummaryResult;
import gov.nih.nlm.ncbi.www.soap.eutils.esummary.ItemType;


public class Client {
	 public static void main(String[] args) throws Exception
	    {
	        // eInfo utility returns a list of available databases
	        try
	        {
	            EUtilsServiceSoapProxy service = new EUtilsServiceSoapProxy();
	            EGqueryRequest req = new EGqueryRequest();
	            
	            req.setTerm("FLJ10578");
	            //req.setTool("human");
	            
	            Result res = service.run_eGquery(req);
	         // results output
	            System.out.println("Search term: " + res.getTerm());
	            System.out.println("Results: ");
	            
	            for (int i = 0; i < res.getEGQueryResult().getResultItem().length; i++)
	            {
	                System.out.println("  " + res.getEGQueryResult().getResultItem()[i].getDbName() +
	                                   ": " + res.getEGQueryResult().getResultItem()[i].getCount() + " : " + 
	                                   res.getEGQueryResult().getResultItem()[i].getMenuName());
	                
	            }
	            

	            // call NCBI ESpell utility
	            ESpellRequest ereq = new ESpellRequest();
	            ereq.setDb("pubmed");
	            ereq.setTerm("mouss");
	            ESpellResult eResult = service.run_eSpell(ereq);
	            // results output
	            System.out.println("Misspelled word: " + eResult.getQuery());
	            System.out.println("Corrected word: " + eResult.getCorrectedQuery());
	            
	            ESearchRequest sreq = new ESearchRequest();
	            sreq.setUsehistory("true");
	            sreq.setDb("gene");
	            sreq.setTerm("TBK1");
	            
	            ESearchResult sres = service.run_eSearch(sreq);
	            
	            
	            System.out.println("Found ids: " + sres.getCount());
	            String id = sres.getIdList()[0];
	            System.out.print("First " + sres.getRetMax() + " ids: ");
	            
	           
	            for (int i = 0; i < sres.getIdList().length; i++)
	            {
	                System.out.print(sres.getIdList()[i] + " ");
	            }
	            System.out.println();
	            
	            ESummaryRequest eSummaryRequest = new ESummaryRequest();
	            eSummaryRequest.setDb("gene");
	            eSummaryRequest.setId(id);
	            //eSummaryRequest.setQuery_key("filter=human");
	            
	            ESummaryResult result = service.run_eSummary(eSummaryRequest);
	            
	            DocSumType[] list = result.getDocSum();
	            for (DocSumType docSumType : list) {
					ItemType[] itemTypes = docSumType.getItem();
					for (ItemType itemType : itemTypes) {
						System.out.println(itemType.getName() + " : " + itemType.getItemContent());
					}
					
				}
	            

	            
	        }
	        catch(Exception e) { System.out.println(e.toString()); }
	    } 
}
