package gov.nih.nlm.ncbi.www.soap.eutils;

public class EUtilsPubmedServiceSoapProxy implements gov.nih.nlm.ncbi.www.soap.eutils.EUtilsPubmedServiceSoap {
  private String _endpoint = null;
  private gov.nih.nlm.ncbi.www.soap.eutils.EUtilsPubmedServiceSoap eUtilsServiceSoap = null;
  
  public EUtilsPubmedServiceSoapProxy() {
    _initEUtilsServiceSoapProxy();
  }
  
  public EUtilsPubmedServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initEUtilsServiceSoapProxy();
  }
  
  private void _initEUtilsServiceSoapProxy() {
    try {
      eUtilsServiceSoap = (new gov.nih.nlm.ncbi.www.soap.eutils.EFetchPubmedServiceLocator()).geteUtilsServiceSoap();
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
  
  public gov.nih.nlm.ncbi.www.soap.eutils.EUtilsPubmedServiceSoap getEUtilsServiceSoap() {
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap;
  }
  
  public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EFetchResult run_eFetch(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EFetchRequest inpp) throws java.rmi.RemoteException{
    if (eUtilsServiceSoap == null)
      _initEUtilsServiceSoapProxy();
    return eUtilsServiceSoap.run_eFetch(inpp);
  }
  
  
}