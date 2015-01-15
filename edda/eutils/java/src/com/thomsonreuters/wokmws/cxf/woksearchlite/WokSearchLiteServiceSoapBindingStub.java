/**
 * WokSearchLiteServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearchlite;

public class WokSearchLiteServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.thomsonreuters.wokmws.cxf.woksearchlite.WokSearchLite {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "databaseId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "uids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "queryLanguage"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "retrieveParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieveParameters"), com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "searchResults"));
        oper.setReturnClass(com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieve");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "queryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "retrieveParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieveParameters"), com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "searchResults"));
        oper.setReturnClass(com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("search");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "queryParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "queryParameters"), com.thomsonreuters.wokmws.cxf.woksearchlite.QueryParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "retrieveParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieveParameters"), com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "searchResults"));
        oper.setReturnClass(com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("citingArticles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "databaseId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "uid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "editionDesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "editionDesc"), com.thomsonreuters.wokmws.cxf.woksearchlite.EditionDesc[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "timeSpan"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "timeSpan"), com.thomsonreuters.wokmws.cxf.woksearchlite.TimeSpan.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "queryLanguage"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "retrieveParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieveParameters"), com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "searchResults"));
        oper.setReturnClass(com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("relatedRecords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "databaseId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "uid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "editionDesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "editionDesc"), com.thomsonreuters.wokmws.cxf.woksearchlite.EditionDesc[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "timeSpan"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "timeSpan"), com.thomsonreuters.wokmws.cxf.woksearchlite.TimeSpan.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "queryLanguage"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "retrieveParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieveParameters"), com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "searchResults"));
        oper.setReturnClass(com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"),
                      "com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException",
                      new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException"), 
                      true
                     ));
        _operations[4] = oper;

    }

    public WokSearchLiteServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WokSearchLiteServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WokSearchLiteServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "AuthenticationException");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "editionDesc");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.EditionDesc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "ESTIWSException");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InternalServerException");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "InvalidInputException");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "labelValuesPair");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "liteRecord");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.LiteRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "QueryException");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "queryField");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.QueryField.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "queryParameters");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.QueryParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieveParameters");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "searchResults");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "SessionException");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "timeSpan");
            cachedSerQNames.add(qName);
            cls = com.thomsonreuters.wokmws.cxf.woksearchlite.TimeSpan.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults retrieveById(java.lang.String databaseId, java.lang.String[] uids, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieveById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {databaseId, uids, queryLanguage, retrieveParameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) org.apache.axis.utils.JavaUtils.convert(_resp, com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults retrieve(java.lang.String queryId, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "retrieve"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {queryId, retrieveParameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) org.apache.axis.utils.JavaUtils.convert(_resp, com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults search(com.thomsonreuters.wokmws.cxf.woksearchlite.QueryParameters queryParameters, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "search"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {queryParameters, retrieveParameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) org.apache.axis.utils.JavaUtils.convert(_resp, com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults citingArticles(java.lang.String databaseId, java.lang.String uid, com.thomsonreuters.wokmws.cxf.woksearchlite.EditionDesc[] editionDesc, com.thomsonreuters.wokmws.cxf.woksearchlite.TimeSpan timeSpan, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "citingArticles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {databaseId, uid, editionDesc, timeSpan, queryLanguage, retrieveParameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) org.apache.axis.utils.JavaUtils.convert(_resp, com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults relatedRecords(java.lang.String databaseId, java.lang.String uid, com.thomsonreuters.wokmws.cxf.woksearchlite.EditionDesc[] editionDesc, com.thomsonreuters.wokmws.cxf.woksearchlite.TimeSpan timeSpan, java.lang.String queryLanguage, com.thomsonreuters.wokmws.cxf.woksearchlite.RetrieveParameters retrieveParameters) throws java.rmi.RemoteException, com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException, com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException, com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException, com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException, com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException, com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "relatedRecords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {databaseId, uid, editionDesc, timeSpan, queryLanguage, retrieveParameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults) org.apache.axis.utils.JavaUtils.convert(_resp, com.thomsonreuters.wokmws.cxf.woksearchlite.SearchResults.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InvalidInputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.InternalServerException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.ESTIWSException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.AuthenticationException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.SessionException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) {
              throw (com.thomsonreuters.wokmws.cxf.woksearchlite.QueryException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
