/**
 * DeclareType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class DeclareType  implements java.io.Serializable {
    private java.lang.String type;  // attribute

    private java.lang.String scope;  // attribute

    private org.apache.axis.types.NonNegativeInteger nargs;  // attribute

    private org.w3.www._1998.Math.MathML.Occurrence occurrence;  // attribute

    private java.lang.String encoding;  // attribute

    private org.apache.axis.types.URI definitionURL;  // attribute

    public DeclareType() {
    }

    public DeclareType(
           java.lang.String type,
           java.lang.String scope,
           org.apache.axis.types.NonNegativeInteger nargs,
           org.w3.www._1998.Math.MathML.Occurrence occurrence,
           java.lang.String encoding,
           org.apache.axis.types.URI definitionURL) {
           this.type = type;
           this.scope = scope;
           this.nargs = nargs;
           this.occurrence = occurrence;
           this.encoding = encoding;
           this.definitionURL = definitionURL;
    }


    /**
     * Gets the type value for this DeclareType.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this DeclareType.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the scope value for this DeclareType.
     * 
     * @return scope
     */
    public java.lang.String getScope() {
        return scope;
    }


    /**
     * Sets the scope value for this DeclareType.
     * 
     * @param scope
     */
    public void setScope(java.lang.String scope) {
        this.scope = scope;
    }


    /**
     * Gets the nargs value for this DeclareType.
     * 
     * @return nargs
     */
    public org.apache.axis.types.NonNegativeInteger getNargs() {
        return nargs;
    }


    /**
     * Sets the nargs value for this DeclareType.
     * 
     * @param nargs
     */
    public void setNargs(org.apache.axis.types.NonNegativeInteger nargs) {
        this.nargs = nargs;
    }


    /**
     * Gets the occurrence value for this DeclareType.
     * 
     * @return occurrence
     */
    public org.w3.www._1998.Math.MathML.Occurrence getOccurrence() {
        return occurrence;
    }


    /**
     * Sets the occurrence value for this DeclareType.
     * 
     * @param occurrence
     */
    public void setOccurrence(org.w3.www._1998.Math.MathML.Occurrence occurrence) {
        this.occurrence = occurrence;
    }


    /**
     * Gets the encoding value for this DeclareType.
     * 
     * @return encoding
     */
    public java.lang.String getEncoding() {
        return encoding;
    }


    /**
     * Sets the encoding value for this DeclareType.
     * 
     * @param encoding
     */
    public void setEncoding(java.lang.String encoding) {
        this.encoding = encoding;
    }


    /**
     * Gets the definitionURL value for this DeclareType.
     * 
     * @return definitionURL
     */
    public org.apache.axis.types.URI getDefinitionURL() {
        return definitionURL;
    }


    /**
     * Sets the definitionURL value for this DeclareType.
     * 
     * @param definitionURL
     */
    public void setDefinitionURL(org.apache.axis.types.URI definitionURL) {
        this.definitionURL = definitionURL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeclareType)) return false;
        DeclareType other = (DeclareType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.scope==null && other.getScope()==null) || 
             (this.scope!=null &&
              this.scope.equals(other.getScope()))) &&
            ((this.nargs==null && other.getNargs()==null) || 
             (this.nargs!=null &&
              this.nargs.equals(other.getNargs()))) &&
            ((this.occurrence==null && other.getOccurrence()==null) || 
             (this.occurrence!=null &&
              this.occurrence.equals(other.getOccurrence()))) &&
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getScope() != null) {
            _hashCode += getScope().hashCode();
        }
        if (getNargs() != null) {
            _hashCode += getNargs().hashCode();
        }
        if (getOccurrence() != null) {
            _hashCode += getOccurrence().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(DeclareType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "declare.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("scope");
        attrField.setXmlName(new javax.xml.namespace.QName("", "scope"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nargs");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nargs"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("occurrence");
        attrField.setXmlName(new javax.xml.namespace.QName("", "occurrence"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">occurrence"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
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
