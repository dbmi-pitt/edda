/**
 * QueryParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class QueryParameters  implements java.io.Serializable {
    private java.lang.String databaseID;

    private com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc[] editions;

    private java.lang.String queryLanguage;

    private java.lang.String symbolicTimeSpan;

    private com.thomsonreuters.wokmws.cxf.woksearch.TimeSpan timeSpan;

    private java.lang.String userQuery;

    public QueryParameters() {
    }

    public QueryParameters(
           java.lang.String databaseID,
           com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc[] editions,
           java.lang.String queryLanguage,
           java.lang.String symbolicTimeSpan,
           com.thomsonreuters.wokmws.cxf.woksearch.TimeSpan timeSpan,
           java.lang.String userQuery) {
           this.databaseID = databaseID;
           this.editions = editions;
           this.queryLanguage = queryLanguage;
           this.symbolicTimeSpan = symbolicTimeSpan;
           this.timeSpan = timeSpan;
           this.userQuery = userQuery;
    }


    /**
     * Gets the databaseID value for this QueryParameters.
     * 
     * @return databaseID
     */
    public java.lang.String getDatabaseID() {
        return databaseID;
    }


    /**
     * Sets the databaseID value for this QueryParameters.
     * 
     * @param databaseID
     */
    public void setDatabaseID(java.lang.String databaseID) {
        this.databaseID = databaseID;
    }


    /**
     * Gets the editions value for this QueryParameters.
     * 
     * @return editions
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc[] getEditions() {
        return editions;
    }


    /**
     * Sets the editions value for this QueryParameters.
     * 
     * @param editions
     */
    public void setEditions(com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc[] editions) {
        this.editions = editions;
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc getEditions(int i) {
        return this.editions[i];
    }

    public void setEditions(int i, com.thomsonreuters.wokmws.cxf.woksearch.EditionDesc _value) {
        this.editions[i] = _value;
    }


    /**
     * Gets the queryLanguage value for this QueryParameters.
     * 
     * @return queryLanguage
     */
    public java.lang.String getQueryLanguage() {
        return queryLanguage;
    }


    /**
     * Sets the queryLanguage value for this QueryParameters.
     * 
     * @param queryLanguage
     */
    public void setQueryLanguage(java.lang.String queryLanguage) {
        this.queryLanguage = queryLanguage;
    }


    /**
     * Gets the symbolicTimeSpan value for this QueryParameters.
     * 
     * @return symbolicTimeSpan
     */
    public java.lang.String getSymbolicTimeSpan() {
        return symbolicTimeSpan;
    }


    /**
     * Sets the symbolicTimeSpan value for this QueryParameters.
     * 
     * @param symbolicTimeSpan
     */
    public void setSymbolicTimeSpan(java.lang.String symbolicTimeSpan) {
        this.symbolicTimeSpan = symbolicTimeSpan;
    }


    /**
     * Gets the timeSpan value for this QueryParameters.
     * 
     * @return timeSpan
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.TimeSpan getTimeSpan() {
        return timeSpan;
    }


    /**
     * Sets the timeSpan value for this QueryParameters.
     * 
     * @param timeSpan
     */
    public void setTimeSpan(com.thomsonreuters.wokmws.cxf.woksearch.TimeSpan timeSpan) {
        this.timeSpan = timeSpan;
    }


    /**
     * Gets the userQuery value for this QueryParameters.
     * 
     * @return userQuery
     */
    public java.lang.String getUserQuery() {
        return userQuery;
    }


    /**
     * Sets the userQuery value for this QueryParameters.
     * 
     * @param userQuery
     */
    public void setUserQuery(java.lang.String userQuery) {
        this.userQuery = userQuery;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryParameters)) return false;
        QueryParameters other = (QueryParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.databaseID==null && other.getDatabaseID()==null) || 
             (this.databaseID!=null &&
              this.databaseID.equals(other.getDatabaseID()))) &&
            ((this.editions==null && other.getEditions()==null) || 
             (this.editions!=null &&
              java.util.Arrays.equals(this.editions, other.getEditions()))) &&
            ((this.queryLanguage==null && other.getQueryLanguage()==null) || 
             (this.queryLanguage!=null &&
              this.queryLanguage.equals(other.getQueryLanguage()))) &&
            ((this.symbolicTimeSpan==null && other.getSymbolicTimeSpan()==null) || 
             (this.symbolicTimeSpan!=null &&
              this.symbolicTimeSpan.equals(other.getSymbolicTimeSpan()))) &&
            ((this.timeSpan==null && other.getTimeSpan()==null) || 
             (this.timeSpan!=null &&
              this.timeSpan.equals(other.getTimeSpan()))) &&
            ((this.userQuery==null && other.getUserQuery()==null) || 
             (this.userQuery!=null &&
              this.userQuery.equals(other.getUserQuery())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDatabaseID() != null) {
            _hashCode += getDatabaseID().hashCode();
        }
        if (getEditions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEditions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEditions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQueryLanguage() != null) {
            _hashCode += getQueryLanguage().hashCode();
        }
        if (getSymbolicTimeSpan() != null) {
            _hashCode += getSymbolicTimeSpan().hashCode();
        }
        if (getTimeSpan() != null) {
            _hashCode += getTimeSpan().hashCode();
        }
        if (getUserQuery() != null) {
            _hashCode += getUserQuery().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "queryParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("databaseID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "databaseID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "editions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "editionDesc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryLanguage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "queryLanguage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbolicTimeSpan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "symbolicTimeSpan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeSpan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeSpan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "timeSpan"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userQuery");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userQuery"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
