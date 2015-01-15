/**
 * WOKMWSAuthenticate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.auth;

public interface WOKMWSAuthenticate extends java.rmi.Remote {
    public java.lang.String authenticate() throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.auth.InvalidInputException, com.thomsonreuters.wokmws.cxf.auth.InternalServerException, com.thomsonreuters.wokmws.cxf.auth.ESTIWSException, com.thomsonreuters.wokmws.cxf.auth.AuthenticationException, com.thomsonreuters.wokmws.cxf.auth.SessionException, com.thomsonreuters.wokmws.cxf.auth.QueryException;
    public void closeSession() throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.auth.InvalidInputException, com.thomsonreuters.wokmws.cxf.auth.InternalServerException, com.thomsonreuters.wokmws.cxf.auth.ESTIWSException, com.thomsonreuters.wokmws.cxf.auth.AuthenticationException, com.thomsonreuters.wokmws.cxf.auth.SessionException, com.thomsonreuters.wokmws.cxf.auth.QueryException;
}
