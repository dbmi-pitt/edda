package com.thomsonreuters.wokmws.cxf.woksearchlite;

public class WokSearchLiteProxy implements com.thomsonreuters.wokmws.cxf.woksearchlite.WokSearchLite {
  private String _endpoint = null;
  private com.thomsonreuters.wokmws.cxf.woksearchlite.WokSearchLite wokSearchLite = null;
  
  public WokSearchLiteProxy() {
    _initWokSearchLiteProxy();
  }
  
  public WokSearchLiteProxy(String endpoint) {
    _endpoint = endpoint;
    _initWokSearchLiteProxy();
  }
  
  private void _initWokSearchLiteProxy() {
    try {
      wokSearchLite = (new com.thomsonreuters.wokmws.cxf.woksearchlite.WokSearchLiteServiceLocator()).getWokSearchLitePort();
      if (wokSearchLite != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wokSearchLite)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wokSearchLite)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wokSearchLite != null)
      ((javax.xml.rpc.Stub)wokSearchLite)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearchlite.WokSearchLite getWokSearchLite() {
    if (wokSearchLite == null)
      _initWokSearchLiteProxy();
    return wokSearchLite;
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults retrieveById(java.lang.String databaseId, java.lang.String[] uids, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException{
    if (wokSearchLite == null)
      _initWokSearchLiteProxy();
    return wokSearchLite.retrieveById(databaseId, uids, queryLanguage, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults retrieve(java.lang.String queryId, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException{
    if (wokSearchLite == null)
      _initWokSearchLiteProxy();
    return wokSearchLite.retrieve(queryId, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults search(com.thomsonreuters.wokmws.cxf.woksearchlite.QueryParameters queryParameters, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException{
    if (wokSearchLite == null)
      _initWokSearchLiteProxy();
    return wokSearchLite.search(queryParameters, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults citingArticles(java.lang.String databaseId, java.lang.String uid, com.thomsonreuters.wokmws.cxf.woksearchlite.EditionDesc[] editionDesc, com.thomsonreuters.wokmws.cxf.woksearchlite.TimeSpan timeSpan, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException{
    if (wokSearchLite == null)
      _initWokSearchLiteProxy();
    return wokSearchLite.citingArticles(databaseId, uid, editionDesc, timeSpan, queryLanguage, retrieveParameters);
  }
  
  public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults relatedRecords(java.lang.String databaseId, java.lang.String uid, com.thomsonreuters.wokmws.cxf.woksearchlite.EditionDesc[] editionDesc, com.thomsonreuters.wokmws.cxf.woksearchlite.TimeSpan timeSpan, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException{
    if (wokSearchLite == null)
      _initWokSearchLiteProxy();
    return wokSearchLite.relatedRecords(databaseId, uid, editionDesc, timeSpan, queryLanguage, retrieveParameters);
  }
  
  
}