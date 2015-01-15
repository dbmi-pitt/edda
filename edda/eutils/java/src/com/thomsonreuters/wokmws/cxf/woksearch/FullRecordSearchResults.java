/**
 * FullRecordSearchResults.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class FullRecordSearchResults  implements java.io.Serializable {
    private com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair[] options;

    private java.lang.String parent;

    private java.lang.String queryID;

    private java.lang.String records;

    private int recordsFound;

    private long recordsSearched;

    public FullRecordSearchResults() {
    }

    public FullRecordSearchResults(
           com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair[] options,
           java.lang.String parent,
           java.lang.String queryID,
           java.lang.String records,
           int recordsFound,
           long recordsSearched) {
           this.options = options;
           this.parent = parent;
           this.queryID = queryID;
           this.records = records;
           this.recordsFound = recordsFound;
           this.recordsSearched = recordsSearched;
    }


    /**
     * Gets the options value for this FullRecordSearchResults.
     * 
     * @return options
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair[] getOptions() {
        return options;
    }


    /**
     * Sets the options value for this FullRecordSearchResults.
     * 
     * @param options
     */
    public void setOptions(com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair[] options) {
        this.options = options;
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair getOptions(int i) {
        return this.options[i];
    }

    public void setOptions(int i, com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair _value) {
        this.options[i] = _value;
    }


    /**
     * Gets the parent value for this FullRecordSearchResults.
     * 
     * @return parent
     */
    public java.lang.String getParent() {
        return parent;
    }


    /**
     * Sets the parent value for this FullRecordSearchResults.
     * 
     * @param parent
     */
    public void setParent(java.lang.String parent) {
        this.parent = parent;
    }


    /**
     * Gets the queryID value for this FullRecordSearchResults.
     * 
     * @return queryID
     */
    public java.lang.String getQueryID() {
        return queryID;
    }


    /**
     * Sets the queryID value for this FullRecordSearchResults.
     * 
     * @param queryID
     */
    public void setQueryID(java.lang.String queryID) {
        this.queryID = queryID;
    }


    /**
     * Gets the records value for this FullRecordSearchResults.
     * 
     * @return records
     */
    public java.lang.String getRecords() {
        return records;
    }


    /**
     * Sets the records value for this FullRecordSearchResults.
     * 
     * @param records
     */
    public void setRecords(java.lang.String records) {
        this.records = records;
    }


    /**
     * Gets the recordsFound value for this FullRecordSearchResults.
     * 
     * @return recordsFound
     */
    public int getRecordsFound() {
        return recordsFound;
    }


    /**
     * Sets the recordsFound value for this FullRecordSearchResults.
     * 
     * @param recordsFound
     */
    public void setRecordsFound(int recordsFound) {
        this.recordsFound = recordsFound;
    }


    /**
     * Gets the recordsSearched value for this FullRecordSearchResults.
     * 
     * @return recordsSearched
     */
    public long getRecordsSearched() {
        return recordsSearched;
    }


    /**
     * Sets the recordsSearched value for this FullRecordSearchResults.
     * 
     * @param recordsSearched
     */
    public void setRecordsSearched(long recordsSearched) {
        this.recordsSearched = recordsSearched;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullRecordSearchResults)) return false;
        FullRecordSearchResults other = (FullRecordSearchResults) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.options==null && other.getOptions()==null) || 
             (this.options!=null &&
              java.util.Arrays.equals(this.options, other.getOptions()))) &&
            ((this.parent==null && other.getParent()==null) || 
             (this.parent!=null &&
              this.parent.equals(other.getParent()))) &&
            ((this.queryID==null && other.getQueryID()==null) || 
             (this.queryID!=null &&
              this.queryID.equals(other.getQueryID()))) &&
            ((this.records==null && other.getRecords()==null) || 
             (this.records!=null &&
              this.records.equals(other.getRecords()))) &&
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
        if (getOptions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOptions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOptions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParent() != null) {
            _hashCode += getParent().hashCode();
        }
        if (getQueryID() != null) {
            _hashCode += getQueryID().hashCode();
        }
        if (getRecords() != null) {
            _hashCode += getRecords().hashCode();
        }
        _hashCode += getRecordsFound();
        _hashCode += new Long(getRecordsSearched()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FullRecordSearchResults.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "fullRecordSearchResults"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("", "options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "queryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records");
        elemField.setXmlName(new javax.xml.namespace.QName("", "records"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
