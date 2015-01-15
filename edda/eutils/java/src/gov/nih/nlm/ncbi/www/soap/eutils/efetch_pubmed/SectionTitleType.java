/**
 * SectionTitleType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class SectionTitleType  implements java.io.Serializable, org.apache.axis.encoding.SimpleType {
    private java.lang.String _value;

    private java.lang.String book;  // attribute

    private java.lang.String part;  // attribute

    private java.lang.String sec;  // attribute

    public SectionTitleType() {
    }

    // Simple Types must have a String constructor
    public SectionTitleType(java.lang.String _value) {
        this._value = _value;
    }
    // Simple Types must have a toString for serializing the value
    public java.lang.String toString() {
        return _value;
    }


    /**
     * Gets the _value value for this SectionTitleType.
     * 
     * @return _value
     */
    public java.lang.String get_value() {
        return _value;
    }


    /**
     * Sets the _value value for this SectionTitleType.
     * 
     * @param _value
     */
    public void set_value(java.lang.String _value) {
        this._value = _value;
    }


    /**
     * Gets the book value for this SectionTitleType.
     * 
     * @return book
     */
    public java.lang.String getBook() {
        return book;
    }


    /**
     * Sets the book value for this SectionTitleType.
     * 
     * @param book
     */
    public void setBook(java.lang.String book) {
        this.book = book;
    }


    /**
     * Gets the part value for this SectionTitleType.
     * 
     * @return part
     */
    public java.lang.String getPart() {
        return part;
    }


    /**
     * Sets the part value for this SectionTitleType.
     * 
     * @param part
     */
    public void setPart(java.lang.String part) {
        this.part = part;
    }


    /**
     * Gets the sec value for this SectionTitleType.
     * 
     * @return sec
     */
    public java.lang.String getSec() {
        return sec;
    }


    /**
     * Sets the sec value for this SectionTitleType.
     * 
     * @param sec
     */
    public void setSec(java.lang.String sec) {
        this.sec = sec;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SectionTitleType)) return false;
        SectionTitleType other = (SectionTitleType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._value==null && other.get_value()==null) || 
             (this._value!=null &&
              this._value.equals(other.get_value()))) &&
            ((this.book==null && other.getBook()==null) || 
             (this.book!=null &&
              this.book.equals(other.getBook()))) &&
            ((this.part==null && other.getPart()==null) || 
             (this.part!=null &&
              this.part.equals(other.getPart()))) &&
            ((this.sec==null && other.getSec()==null) || 
             (this.sec!=null &&
              this.sec.equals(other.getSec())));
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
        if (get_value() != null) {
            _hashCode += get_value().hashCode();
        }
        if (getBook() != null) {
            _hashCode += getBook().hashCode();
        }
        if (getPart() != null) {
            _hashCode += getPart().hashCode();
        }
        if (getSec() != null) {
            _hashCode += getSec().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SectionTitleType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SectionTitleType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("book");
        attrField.setXmlName(new javax.xml.namespace.QName("", "book"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("part");
        attrField.setXmlName(new javax.xml.namespace.QName("", "part"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sec");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sec"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
          new  org.apache.axis.encoding.ser.SimpleSerializer(
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
          new  org.apache.axis.encoding.ser.SimpleDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
