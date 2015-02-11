/**
 * CitedReferencesSearchResults.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class CitedReferencesSearchResults  implements java.io.Serializable {
    private java.lang.String queryID;

    private com.thomsonreuters.wokmws.cxf.woksearch.CitedReference[] records;

    private int recordsFound;

    private long recordsSearched;

    public CitedReferencesSearchResults() {
    }

    public CitedReferencesSearchResults(
           java.lang.String queryID,
           com.thomsonreuters.wokmws.cxf.woksearch.CitedReference[] records,
           int recordsFound,
           long recordsSearched) {
           this.queryID = queryID;
           this.records = records;
           this.recordsFound = recordsFound;
           this.recordsSearched = recordsSearched;
    }


    /**
     * Gets the queryID value for this CitedReferencesSearchResults.
     * 
     * @return queryID
     */
    public java.lang.String getQueryID() {
        return queryID;
    }


    /**
     * Sets the queryID value for this CitedReferencesSearchResults.
     * 
     * @param queryID
     */
    public void setQueryID(java.lang.String queryID) {
        this.queryID = queryID;
    }


    /**
     * Gets the records value for this CitedReferencesSearchResults.
     * 
     * @return records
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.CitedReference[] getRecords() {
        return records;
    }


    /**
     * Sets the records value for this CitedReferencesSearchResults.
     * 
     * @param records
     */
    public void setRecords(com.thomsonreuters.wokmws.cxf.woksearch.CitedReference[] records) {
        this.records = records;
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.CitedReference getRecords(int i) {
        return this.records[i];
    }

    public void setRecords(int i, com.thomsonreuters.wokmws.cxf.woksearch.CitedReference _value) {
        this.records[i] = _value;
    }


    /**
     * Gets the recordsFound value for this CitedReferencesSearchResults.
     * 
     * @return recordsFound
     */
    public int getRecordsFound() {
        return recordsFound;
    }


    /**
     * Sets the recordsFound value for this CitedReferencesSearchResults.
     * 
     * @param recordsFound
     */
    public void setRecordsFound(int recordsFound) {
        this.recordsFound = recordsFound;
    }


    /**
     * Gets the recordsSearched value for this CitedReferencesSearchResults.
     * 
     * @return recordsSearched
     */
    public long getRecordsSearched() {
        return recordsSearched;
    }


    /**
     * Sets the recordsSearched value for this CitedReferencesSearchResults.
     * 
     * @param recordsSearched
     */
    public void setRecordsSearched(long recordsSearched) {
        this.recordsSearched = recordsSearched;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CitedReferencesSearchResults)) return false;
        CitedReferencesSearchResults other = (CitedReferencesSearchResults) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.queryID==null && other.getQueryID()==null) || 
             (this.queryID!=null &&
              this.queryID.equals(other.getQueryID()))) &&
            ((this.records==null && other.getRecords()==null) || 
             (this.records!=null &&
              java.util.Arrays.equals(this.records, other.getRecords()))) &&
            this.recordsFound == other.getRecordsFound() &&
            this.recordsSearched == other.getRecordsSearched();
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
        if (getQueryID() != null) {
            _hashCode += getQueryID().hashCode();
        }
        if (getRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getRecordsFound();
        _hashCode += new Long(getRecordsSearched()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CitedReferencesSearchResults.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "citedReferencesSearchResults"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "queryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records");
        elemField.setXmlName(new javax.xml.namespace.QName("", "records"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "citedReference"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordsFound");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recordsFound"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordsSearched");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recordsSearched"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
