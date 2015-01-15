/**
 * WokSearchServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class WokSearchServiceLocator extends org.apache.axis.client.Service implements com.thomsonreuters.wokmws.cxf.woksearch.WokSearchService {

    public WokSearchServiceLocator() {
    }


    public WokSearchServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WokSearchServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WokSearchPort
    private java.lang.String WokSearchPort_address = "http://search.isiknowledge.com/esti/wokmws/ws/WokSearch";

    public java.lang.String getWokSearchPortAddress() {
        return WokSearchPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WokSearchPortWSDDServiceName = "WokSearchPort";

    public java.lang.String getWokSearchPortWSDDServiceName() {
        return WokSearchPortWSDDServiceName;
    }

    public void setWokSearchPortWSDDServiceName(java.lang.String name) {
        WokSearchPortWSDDServiceName = name;
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.WokSearch getWokSearchPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WokSearchPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWokSearchPort(endpoint);
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.WokSearch getWokSearchPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.thomsonreuters.wokmws.cxf.woksearch.WokSearchServiceSoapBindingStub _stub = new com.thomsonreuters.wokmws.cxf.woksearch.WokSearchServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWokSearchPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWokSearchPortEndpointAddress(java.lang.String address) {
        WokSearchPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.thomsonreuters.wokmws.cxf.woksearch.WokSearch.class.isAssignableFrom(serviceEndpointInterface)) {
                com.thomsonreuters.wokmws.cxf.woksearch.WokSearchServiceSoapBindingStub _stub = new com.thomsonreuters.wokmws.cxf.woksearch.WokSearchServiceSoapBindingStub(new java.net.URL(WokSearchPort_address), this);
                _stub.setPortName(getWokSearchPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WokSearchPort".equals(inputPortName)) {
            return getWokSearchPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "WokSearchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "WokSearchPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WokSearchPort".equals(portName)) {
            setWokSearchPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
