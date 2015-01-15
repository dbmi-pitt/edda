/**
 * FullRecordData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class FullRecordData  implements java.io.Serializable {
    private com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair[] options;

    private java.lang.String records;

    public FullRecordData() {
    }

    public FullRecordData(
           com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair[] options,
           java.lang.String records) {
           this.options = options;
           this.records = records;
    }


    /**
     * Gets the options value for this FullRecordData.
     * 
     * @return options
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.LabelValuesPair[] getOptions() {
        return options;
    }


    /**
     * Sets the options value for this FullRecordData.
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
     * Gets the records value for this FullRecordData.
     * 
     * @return records
     */
    public java.lang.String getRecords() {
        return records;
    }


    /**
     * Sets the records value for this FullRecordData.
     * 
     * @param records
     */
    public void setRecords(java.lang.String records) {
        this.records = records;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullRecordData)) return false;
        FullRecordData other = (FullRecordData) obj;
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
            ((this.records==null && other.getRecords()==null) || 
             (this.records!=null &&
              this.records.equals(other.getRecords())));
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
        if (getRecords() != null) {
            _hashCode += getRecords().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FullRecordData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "fullRecordData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("", "options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records");
        elemField.setXmlName(new javax.xml.namespace.QName("", "records"));
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
