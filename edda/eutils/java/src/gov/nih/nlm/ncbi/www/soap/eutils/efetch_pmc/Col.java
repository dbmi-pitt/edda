/**
 * Col.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class Col  implements java.io.Serializable {
    private java.lang.String id;  // attribute

    private java.lang.String alternateFormOf;  // attribute

    private java.lang.Object contentType;  // attribute

    private java.lang.Object style;  // attribute

    private java.lang.Object span;  // attribute

    private java.lang.Object width;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColAlign align;  // attribute

    private java.lang.Object _char;  // attribute

    private java.lang.Object charoff;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColValign valign;  // attribute

    public Col() {
    }

    public Col(
           java.lang.String id,
           java.lang.String alternateFormOf,
           java.lang.Object contentType,
           java.lang.Object style,
           java.lang.Object span,
           java.lang.Object width,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColAlign align,
           java.lang.Object _char,
           java.lang.Object charoff,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColValign valign) {
           this.id = id;
           this.alternateFormOf = alternateFormOf;
           this.contentType = contentType;
           this.style = style;
           this.span = span;
           this.width = width;
           this.align = align;
           this._char = _char;
           this.charoff = charoff;
           this.valign = valign;
    }


    /**
     * Gets the id value for this Col.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Col.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the alternateFormOf value for this Col.
     * 
     * @return alternateFormOf
     */
    public java.lang.String getAlternateFormOf() {
        return alternateFormOf;
    }


    /**
     * Sets the alternateFormOf value for this Col.
     * 
     * @param alternateFormOf
     */
    public void setAlternateFormOf(java.lang.String alternateFormOf) {
        this.alternateFormOf = alternateFormOf;
    }


    /**
     * Gets the contentType value for this Col.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this Col.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }


    /**
     * Gets the style value for this Col.
     * 
     * @return style
     */
    public java.lang.Object getStyle() {
        return style;
    }


    /**
     * Sets the style value for this Col.
     * 
     * @param style
     */
    public void setStyle(java.lang.Object style) {
        this.style = style;
    }


    /**
     * Gets the span value for this Col.
     * 
     * @return span
     */
    public java.lang.Object getSpan() {
        return span;
    }


    /**
     * Sets the span value for this Col.
     * 
     * @param span
     */
    public void setSpan(java.lang.Object span) {
        this.span = span;
    }


    /**
     * Gets the width value for this Col.
     * 
     * @return width
     */
    public java.lang.Object getWidth() {
        return width;
    }


    /**
     * Sets the width value for this Col.
     * 
     * @param width
     */
    public void setWidth(java.lang.Object width) {
        this.width = width;
    }


    /**
     * Gets the align value for this Col.
     * 
     * @return align
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColAlign getAlign() {
        return align;
    }


    /**
     * Sets the align value for this Col.
     * 
     * @param align
     */
    public void setAlign(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColAlign align) {
        this.align = align;
    }


    /**
     * Gets the _char value for this Col.
     * 
     * @return _char
     */
    public java.lang.Object get_char() {
        return _char;
    }


    /**
     * Sets the _char value for this Col.
     * 
     * @param _char
     */
    public void set_char(java.lang.Object _char) {
        this._char = _char;
    }


    /**
     * Gets the charoff value for this Col.
     * 
     * @return charoff
     */
    public java.lang.Object getCharoff() {
        return charoff;
    }


    /**
     * Sets the charoff value for this Col.
     * 
     * @param charoff
     */
    public void setCharoff(java.lang.Object charoff) {
        this.charoff = charoff;
    }


    /**
     * Gets the valign value for this Col.
     * 
     * @return valign
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColValign getValign() {
        return valign;
    }


    /**
     * Sets the valign value for this Col.
     * 
     * @param valign
     */
    public void setValign(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColValign valign) {
        this.valign = valign;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Col)) return false;
        Col other = (Col) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.alternateFormOf==null && other.getAlternateFormOf()==null) || 
             (this.alternateFormOf!=null &&
              this.alternateFormOf.equals(other.getAlternateFormOf()))) &&
            ((this.contentType==null && other.getContentType()==null) || 
             (this.contentType!=null &&
              this.contentType.equals(other.getContentType()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              this.style.equals(other.getStyle()))) &&
            ((this.span==null && other.getSpan()==null) || 
             (this.span!=null &&
              this.span.equals(other.getSpan()))) &&
            ((this.width==null && other.getWidth()==null) || 
             (this.width!=null &&
              this.width.equals(other.getWidth()))) &&
            ((this.align==null && other.getAlign()==null) || 
             (this.align!=null &&
              this.align.equals(other.getAlign()))) &&
            ((this._char==null && other.get_char()==null) || 
             (this._char!=null &&
              this._char.equals(other.get_char()))) &&
            ((this.charoff==null && other.getCharoff()==null) || 
             (this.charoff!=null &&
              this.charoff.equals(other.getCharoff()))) &&
            ((this.valign==null && other.getValign()==null) || 
             (this.valign!=null &&
              this.valign.equals(other.getValign())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getAlternateFormOf() != null) {
            _hashCode += getAlternateFormOf().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        if (getStyle() != null) {
            _hashCode += getStyle().hashCode();
        }
        if (getSpan() != null) {
            _hashCode += getSpan().hashCode();
        }
        if (getWidth() != null) {
            _hashCode += getWidth().hashCode();
        }
        if (getAlign() != null) {
            _hashCode += getAlign().hashCode();
        }
        if (get_char() != null) {
            _hashCode += get_char().hashCode();
        }
        if (getCharoff() != null) {
            _hashCode += getCharoff().hashCode();
        }
        if (getValign() != null) {
            _hashCode += getValign().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Col.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">col"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alternateFormOf");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alternate-form-of"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("style");
        attrField.setXmlName(new javax.xml.namespace.QName("", "style"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("span");
        attrField.setXmlName(new javax.xml.namespace.QName("", "span"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("width");
        attrField.setXmlName(new javax.xml.namespace.QName("", "width"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("align");
        attrField.setXmlName(new javax.xml.namespace.QName("", "align"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>col>align"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("_char");
        attrField.setXmlName(new javax.xml.namespace.QName("", "char"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("charoff");
        attrField.setXmlName(new javax.xml.namespace.QName("", "charoff"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("valign");
        attrField.setXmlName(new javax.xml.namespace.QName("", "valign"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>col>valign"));
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
