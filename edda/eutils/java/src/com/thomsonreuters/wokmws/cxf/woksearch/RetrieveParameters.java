/**
 * RetrieveParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class RetrieveParameters  implements java.io.Serializable {
    private com.thomsonreuters.wokmws.cxf.woksearch.CollectionFields[] collectionFields;

    private int count;

    private com.thomsonreuters.wokmws.cxf.woksearch.QueryField[] fields;

    private int firstRecord;

    private com.thomsonreuters.wokmws.cxf.woksearch.KeyValuePair[] options;

    public RetrieveParameters() {
    }

    public RetrieveParameters(
           com.thomsonreuters.wokmws.cxf.woksearch.CollectionFields[] collectionFields,
           int count,
           com.thomsonreuters.wokmws.cxf.woksearch.QueryField[] fields,
           int firstRecord,
           com.thomsonreuters.wokmws.cxf.woksearch.KeyValuePair[] options) {
           this.collectionFields = collectionFields;
           this.count = count;
           this.fields = fields;
           this.firstRecord = firstRecord;
           this.options = options;
    }


    /**
     * Gets the collectionFields value for this RetrieveParameters.
     * 
     * @return collectionFields
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.CollectionFields[] getCollectionFields() {
        return collectionFields;
    }


    /**
     * Sets the collectionFields value for this RetrieveParameters.
     * 
     * @param collectionFields
     */
    public void setCollectionFields(com.thomsonreuters.wokmws.cxf.woksearch.CollectionFields[] collectionFields) {
        this.collectionFields = collectionFields;
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.CollectionFields getCollectionFields(int i) {
        return this.collectionFields[i];
    }

    public void setCollectionFields(int i, com.thomsonreuters.wokmws.cxf.woksearch.CollectionFields _value) {
        this.collectionFields[i] = _value;
    }


    /**
     * Gets the count value for this RetrieveParameters.
     * 
     * @return count
     */
    public int getCount() {
        return count;
    }


    /**
     * Sets the count value for this RetrieveParameters.
     * 
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }


    /**
     * Gets the fields value for this RetrieveParameters.
     * 
     * @return fields
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.QueryField[] getFields() {
        return fields;
    }


    /**
     * Sets the fields value for this RetrieveParameters.
     * 
     * @param fields
     */
    public void setFields(com.thomsonreuters.wokmws.cxf.woksearch.QueryField[] fields) {
        this.fields = fields;
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.QueryField getFields(int i) {
        return this.fields[i];
    }

    public void setFields(int i, com.thomsonreuters.wokmws.cxf.woksearch.QueryField _value) {
        this.fields[i] = _value;
    }


    /**
     * Gets the firstRecord value for this RetrieveParameters.
     * 
     * @return firstRecord
     */
    public int getFirstRecord() {
        return firstRecord;
    }


    /**
     * Sets the firstRecord value for this RetrieveParameters.
     * 
     * @param firstRecord
     */
    public void setFirstRecord(int firstRecord) {
        this.firstRecord = firstRecord;
    }


    /**
     * Gets the options value for this RetrieveParameters.
     * 
     * @return options
     */
    public com.thomsonreuters.wokmws.cxf.woksearch.KeyValuePair[] getOptions() {
        return options;
    }


    /**
     * Sets the options value for this RetrieveParameters.
     * 
     * @param options
     */
    public void setOptions(com.thomsonreuters.wokmws.cxf.woksearch.KeyValuePair[] options) {
        this.options = options;
    }

    public com.thomsonreuters.wokmws.cxf.woksearch.KeyValuePair getOptions(int i) {
        return this.options[i];
    }

    public void setOptions(int i, com.thomsonreuters.wokmws.cxf.woksearch.KeyValuePair _value) {
        this.options[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetrieveParameters)) return false;
        RetrieveParameters other = (RetrieveParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.collectionFields==null && other.getCollectionFields()==null) || 
             (this.collectionFields!=null &&
              java.util.Arrays.equals(this.collectionFields, other.getCollectionFields()))) &&
            this.count == other.getCount() &&
            ((this.fields==null && other.getFields()==null) || 
             (this.fields!=null &&
              java.util.Arrays.equals(this.fields, other.getFields()))) &&
            this.firstRecord == other.getFirstRecord() &&
            ((this.options==null && other.getOptions()==null) || 
             (this.options!=null &&
              java.util.Arrays.equals(this.options, other.getOptions())));
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
        if (getCollectionFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCollectionFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCollectionFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCount();
        if (getFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getFirstRecord();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetrieveParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "retrieveParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collectionFields");
        elemField.setXmlName(new javax.xml.namespace.QName("", "collectionFields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "collectionFields"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("count");
        elemField.setXmlName(new javax.xml.namespace.QName("", "count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fields");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "queryField"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("", "options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "keyValuePair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
