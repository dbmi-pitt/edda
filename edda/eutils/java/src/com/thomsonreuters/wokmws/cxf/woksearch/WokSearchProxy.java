package com.thomsonreuters.wokmws.cxf.woksearch;

public class WokSearchProxy implements com.thomsonreuters.wokmws.cxf.woksearch.WokSearch {
  private String _endpoint = null;
  private com.thomsonreuters.wokmws.cxf.woksearch.WokSearch wokSearch = null;
  
  public WokSearchProxy() {
    _initWokSearchProxy();
  }
  
  public WokSearchProxy(String endpoint) {
    _endpoint = endpoint;
    _initWokSearchProxy();
  }
  
  private void _initWokSearchProxy() {
    try {
      wokSearch = (new com.thomsonreuters.wokmws.cxf.woksearch.WokSearchServiceLocator()).getWokSearchPort();
      if (wokSearch != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wokSearch)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wokSearch)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wokSearch != null)
      ((javax.xml.rpc.Stub)wokSearch)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.WokSearch getWokSearch() {
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch;
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.CitedReference[] citedReferencesRetrieve(java.lang.String queryId, com.thomsonreuters.wokmws.cxf.woksearch.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearch.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearch.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearch.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearch.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearch.SessionException, com.thomsonreuters.wokmws.cxf.woksearch.QueryException{
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch.citedReferencesRetrieve(queryId, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.FullRecordSearchResults relatedRecords(java.lang.String databaseId, java.lang.String uid, com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc[] editions, com.thomsonreuters.wokmws.cxf.woksearch.TimeSpan timeSpan, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearch.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearch.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearch.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearch.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearch.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearch.SessionException, com.thomsonreuters.wokmws.cxf.woksearch.QueryException{
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch.relatedRecords(databaseId, uid, editions, timeSpan, queryLanguage, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.CitedReferencesSearchResults citedReferences(java.lang.String databaseId, java.lang.String uid, com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc[] editions, com.thomsonreuters.wokmws.cxf.woksearch.TimeSpan timeSpan, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearch.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearch.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearch.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearch.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearch.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearch.SessionException, com.thomsonreuters.wokmws.cxf.woksearch.QueryException{
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch.citedReferences(databaseId, uid, editions, timeSpan, queryLanguage, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.FullRecordData retrieve(java.lang.String queryId, com.thomsonreuters.wokmws.cxf.woksearch.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearch.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearch.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearch.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearch.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearch.SessionException, com.thomsonreuters.wokmws.cxf.woksearch.QueryException{
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch.retrieve(queryId, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.FullRecordSearchResults search(com.thomsonreuters.wokmws.cxf.woksearch.QueryParameters queryParameters, com.thomsonreuters.wokmws.cxf.woksearch.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearch.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearch.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearch.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearch.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearch.SessionException, com.thomsonreuters.wokmws.cxf.woksearch.QueryException{
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch.search(queryParameters, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.FullRecordSearchResults citingArticles(java.lang.String databaseId, java.lang.String uid, com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc[] editions, com.thomsonreuters.wokmws.cxf.woksearch.TimeSpan timeSpan, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearch.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearch.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearch.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearch.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearch.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearch.SessionException, com.thomsonreuters.wokmws.cxf.woksearch.QueryException{
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch.citingArticles(databaseId, uid, editions, timeSpan, queryLanguage, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearch.FullRecordSearchResults retrieveById(java.lang.String databaseId, java.lang.String[] uids, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearch.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearch.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearch.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearch.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearch.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearch.SessionException, com.thomsonreuters.wokmws.cxf.woksearch.QueryException{
    if (wokSearch == null)
      _initWokSearchProxy();
    return wokSearch.retrieveById(databaseId, uids, queryLanguage, retrieveParameters);
  }
  
  
}