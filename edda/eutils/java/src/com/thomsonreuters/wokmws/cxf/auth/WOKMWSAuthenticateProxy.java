package com.thomsonreuters.wokmws.cxf.auth;

public class WOKMWSAuthenticateProxy implements com.thomsonreuters.wokmws.cxf.auth.WOKMWSAuthenticate {
  private String _endpoint = null;
  private com.thomsonreuters.wokmws.cxf.auth.WOKMWSAuthenticate wOKMWSAuthenticate = null;
  
  public WOKMWSAuthenticateProxy() {
    _initWOKMWSAuthenticateProxy();
  }
  
  public WOKMWSAuthenticateProxy(String endpoint) {
    _endpoint = endpoint;
    _initWOKMWSAuthenticateProxy();
  }
  
  private void _initWOKMWSAuthenticateProxy() {
    try {
      wOKMWSAuthenticate = (new com.thomsonreuters.wokmws.cxf.auth.WOKMWSAuthenticateServiceLocator()).getWOKMWSAuthenticatePort();
      if (wOKMWSAuthenticate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wOKMWSAuthenticate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wOKMWSAuthenticate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wOKMWSAuthenticate != null)
      ((javax.xml.rpc.Stub)wOKMWSAuthenticate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.thomsonreuters.wokmws.cxf.auth.WOKMWSAuthenticate getWOKMWSAuthenticate() {
    if (wOKMWSAuthenticate == null)
      _initWOKMWSAuthenticateProxy();
    return wOKMWSAuthenticate;
  }
  
  public java.lang.String authenticate() throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.auth.InvalidInputException, com.thomsonreuters.wokmws.cxf.auth.InternalServerException, com.thomsonreuters.wokmws.cxf.auth.ESTIWSException, com.thomsonreuters.wokmws.cxf.auth.AuthenticationException, com.thomsonreuters.wokmws.cxf.auth.SessionException, com.thomsonreuters.wokmws.cxf.auth.QueryException{
    if (wOKMWSAuthenticate == null)
      _initWOKMWSAuthenticateProxy();
    return wOKMWSAuthenticate.authenticate();
  }
  
  public void closeSession() throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.auth.InvalidInputException, com.thomsonreuters.wokmws.cxf.auth.InternalServerException, com.thomsonreuters.wokmws.cxf.auth.ESTIWSException, com.thomsonreuters.wokmws.cxf.auth.AuthenticationException, com.thomsonreuters.wokmws.cxf.auth.SessionException, com.thomsonreuters.wokmws.cxf.auth.QueryException{
    if (wOKMWSAuthenticate == null)
      _initWOKMWSAuthenticateProxy();
    wOKMWSAuthenticate.closeSession();
  }
  
  
}