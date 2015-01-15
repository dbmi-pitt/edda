/**
 * MglyphType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class MglyphType  implements java.io.Serializable {
    private java.lang.String alt;  // attribute

    private java.lang.String fontfamily;  // attribute

    private org.apache.axis.types.PositiveInteger index;  // attribute

    public MglyphType() {
    }

    public MglyphType(
           java.lang.String alt,
           java.lang.String fontfamily,
           org.apache.axis.types.PositiveInteger index) {
           this.alt = alt;
           this.fontfamily = fontfamily;
           this.index = index;
    }


    /**
     * Gets the alt value for this MglyphType.
     * 
     * @return alt
     */
    public java.lang.String getAlt() {
        return alt;
    }


    /**
     * Sets the alt value for this MglyphType.
     * 
     * @param alt
     */
    public void setAlt(java.lang.String alt) {
        this.alt = alt;
    }


    /**
     * Gets the fontfamily value for this MglyphType.
     * 
     * @return fontfamily
     */
    public java.lang.String getFontfamily() {
        return fontfamily;
    }


    /**
     * Sets the fontfamily value for this MglyphType.
     * 
     * @param fontfamily
     */
    public void setFontfamily(java.lang.String fontfamily) {
        this.fontfamily = fontfamily;
    }


    /**
     * Gets the index value for this MglyphType.
     * 
     * @return index
     */
    public org.apache.axis.types.PositiveInteger getIndex() {
        return index;
    }


    /**
     * Sets the index value for this MglyphType.
     * 
     * @param index
     */
    public void setIndex(org.apache.axis.types.PositiveInteger index) {
        this.index = index;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MglyphType)) return false;
        MglyphType other = (MglyphType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.alt==null && other.getAlt()==null) || 
             (this.alt!=null &&
              this.alt.equals(other.getAlt()))) &&
            ((this.fontfamily==null && other.getFontfamily()==null) || 
             (this.fontfamily!=null &&
              this.fontfamily.equals(other.getFontfamily()))) &&
            ((this.index==null && other.getIndex()==null) || 
             (this.index!=null &&
              this.index.equals(other.getIndex())));
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
        if (getAlt() != null) {
            _hashCode += getAlt().hashCode();
        }
        if (getFontfamily() != null) {
            _hashCode += getFontfamily().hashCode();
        }
        if (getIndex() != null) {
            _hashCode += getIndex().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MglyphType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mglyph.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fontfamily");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fontfamily"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("index");
        attrField.setXmlName(new javax.xml.namespace.QName("", "index"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "positiveInteger"));
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
