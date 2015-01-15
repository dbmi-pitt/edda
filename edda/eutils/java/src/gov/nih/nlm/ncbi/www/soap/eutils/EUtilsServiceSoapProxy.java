package gov.nih.nlm.ncbi.www.soap.eutils;

public class EUtilsServiceSoapProxy implements gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceSoap {
  private String _endpoint = null;
  private gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceSoap eUtilsServiceSoap = null;
  
  public EUtilsServiceSoapProxy() {
    _initEUtilsServiceSoapProxy();
  }
  
  public EUtilsServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initEUtilsServiceSoapProxy();
  }
  
  private void _initEUtilsServiceSoapProxy() {
    try {
      eUtilsServiceSoap = (new gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceLocator()).geteUtilsServiceSoap();
      if (eUtilsServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eUtilsServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eUtilsServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eUtilsServiceSoap != null)
      ((javax.xml.rpc.Stub)eUtilsServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceSoap getEUtilsServiceSoap() {
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap;
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.egquery.Result run_eGquery(gov.nih.nlm.ncbi.www.soap.eutils.egquery.EGqueryRequest request) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_eGquery(request);
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.einfo.EInfoResult run_eInfo(gov.nih.nlm.ncbi.www.soap.eutils.einfo.EInfoRequest request) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_eInfo(request);
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchResult run_eSearch(gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchRequest request) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_eSearch(request);
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.esummary.ESummaryResult run_eSummary(gov.nih.nlm.ncbi.www.soap.eutils.esummary.ESummaryRequest request) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_eSummary(request);
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkResult run_eLink(gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkRequest request) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_eLink(request);
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.espell.ESpellResult run_eSpell(gov.nih.nlm.ncbi.www.soap.eutils.espell.ESpellRequest request) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_eSpell(request);
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.epost.EPostResult run_ePost(gov.nih.nlm.ncbi.www.soap.eutils.epost.EPostRequest request) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_ePost(request);
  }
  
  
}