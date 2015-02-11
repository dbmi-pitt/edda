/**
 * ConditionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class ConditionType  implements java.io.Serializable {
    private java.lang.String encoding;  // attribute

    private org.apache.axis.types.URI definitionURL;  // attribute

    public ConditionType() {
    }

    public ConditionType(
           java.lang.String encoding,
           org.apache.axis.types.URI definitionURL) {
           this.encoding = encoding;
           this.definitionURL = definitionURL;
    }


    /**
     * Gets the encoding value for this ConditionType.
     * 
     * @return encoding
     */
    public java.lang.String getEncoding() {
        return encoding;
    }


    /**
     * Sets the encoding value for this ConditionType.
     * 
     * @param encoding
     */
    public void setEncoding(java.lang.String encoding) {
        this.encoding = encoding;
    }


    /**
     * Gets the definitionURL value for this ConditionType.
     * 
     * @return definitionURL
     */
    public org.apache.axis.types.URI getDefinitionURL() {
        return definitionURL;
    }


    /**
     * Sets the definitionURL value for this ConditionType.
     * 
     * @param definitionURL
     */
    public void setDefinitionURL(org.apache.axis.types.URI definitionURL) {
        this.definitionURL = definitionURL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConditionType)) return false;
        ConditionType other = (ConditionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.encoding==null && other.getEncoding()==null) || 
             (this.encoding!=null &&
              this.encoding.equals(other.getEncoding()))) &&
            ((this.definitionURL==null && other.getDefinitionURL()==null) || 
             (this.definitionURL!=null &&
              this.definitionURL.equals(other.getDefinitionURL())));
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
        if (getEncoding() != null) {
            _hashCode += getEncoding().hashCode();
        }
        if (getDefinitionURL() != null) {
            _hashCode += getDefinitionURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConditionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "condition.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("encoding");
        attrField.setXmlName(new javax.xml.namespace.QName("", "encoding"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("definitionURL");
        attrField.setXmlName(new javax.xml.namespace.QName("", "definitionURL"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        typeDesc.addFieldDesc(attrField);
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
