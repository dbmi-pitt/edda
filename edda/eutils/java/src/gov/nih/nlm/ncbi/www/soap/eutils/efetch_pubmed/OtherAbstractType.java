/**
 * OtherAbstractType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class OtherAbstractType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractTextType[] abstractText;

    private java.lang.String copyrightInformation;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractTypeType type;  // attribute

    private java.lang.String language;  // attribute

    public OtherAbstractType() {
    }

    public OtherAbstractType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractTextType[] abstractText,
           java.lang.String copyrightInformation,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractTypeType type,
           java.lang.String language) {
           this.abstractText = abstractText;
           this.copyrightInformation = copyrightInformation;
           this.type = type;
           this.language = language;
    }


    /**
     * Gets the abstractText value for this OtherAbstractType.
     * 
     * @return abstractText
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractTextType[] getAbstractText() {
        return abstractText;
    }


    /**
     * Sets the abstractText value for this OtherAbstractType.
     * 
     * @param abstractText
     */
    public void setAbstractText(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractTextType[] abstractText) {
        this.abstractText = abstractText;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractTextType getAbstractText(int i) {
        return this.abstractText[i];
    }

    public void setAbstractText(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractTextType _value) {
        this.abstractText[i] = _value;
    }


    /**
     * Gets the copyrightInformation value for this OtherAbstractType.
     * 
     * @return copyrightInformation
     */
    public java.lang.String getCopyrightInformation() {
        return copyrightInformation;
    }


    /**
     * Sets the copyrightInformation value for this OtherAbstractType.
     * 
     * @param copyrightInformation
     */
    public void setCopyrightInformation(java.lang.String copyrightInformation) {
        this.copyrightInformation = copyrightInformation;
    }


    /**
     * Gets the type value for this OtherAbstractType.
     * 
     * @return type
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractTypeType getType() {
        return type;
    }


    /**
     * Sets the type value for this OtherAbstractType.
     * 
     * @param type
     */
    public void setType(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractTypeType type) {
        this.type = type;
    }


    /**
     * Gets the language value for this OtherAbstractType.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this OtherAbstractType.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OtherAbstractType)) return false;
        OtherAbstractType other = (OtherAbstractType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abstractText==null && other.getAbstractText()==null) || 
             (this.abstractText!=null &&
              java.util.Arrays.equals(this.abstractText, other.getAbstractText()))) &&
            ((this.copyrightInformation==null && other.getCopyrightInformation()==null) || 
             (this.copyrightInformation!=null &&
              this.copyrightInformation.equals(other.getCopyrightInformation()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage())));
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
        if (getAbstractText() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAbstractText());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAbstractText(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCopyrightInformation() != null) {
            _hashCode += getCopyrightInformation().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OtherAbstractType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "OtherAbstractType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">OtherAbstractType>Type"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("language");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Language"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abstractText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AbstractText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AbstractTextType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("copyrightInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CopyrightInformation"));
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
