/**
 * LabelValuesPair.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class LabelValuesPair  implements java.io.Serializable {
    private java.lang.String label;

    private java.lang.String[] values;

    public LabelValuesPair() {
    }

    public LabelValuesPair(
           java.lang.String label,
           java.lang.String[] values) {
           this.label = label;
           this.values = values;
    }


    /**
     * Gets the label value for this LabelValuesPair.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this LabelValuesPair.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the values value for this LabelValuesPair.
     * 
     * @return values
     */
    public java.lang.String[] getValues() {
        return values;
    }


    /**
     * Sets the values value for this LabelValuesPair.
     * 
     * @param values
     */
    public void setValues(java.lang.String[] values) {
        this.values = values;
    }

    public java.lang.String getValues(int i) {
        return this.values[i];
    }

    public void setValues(int i, java.lang.String _value) {
        this.values[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LabelValuesPair)) return false;
        LabelValuesPair other = (LabelValuesPair) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.values==null && other.getValues()==null) || 
             (this.values!=null &&
              java.util.Arrays.equals(this.values, other.getValues())));
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
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValues(), i);
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
        new org.apache.axis.description.TypeDesc(LabelValuesPair.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("values");
        elemField.setXmlName(new javax.xml.namespace.QName("", "values"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
