/**
 * CnType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class CnType  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private org.apache.axis.types.PositiveInteger base;  // attribute

    private org.w3.www._1998.Math.MathML.Type type;  // attribute

    private java.lang.String encoding;  // attribute

    private org.apache.axis.types.URI definitionURL;  // attribute

    private org.apache.axis.types.NMTokens _class;  // attribute

    private java.lang.String style;  // attribute

    private org.apache.axis.types.IDRef xref;  // attribute

    private org.apache.axis.types.Id id;  // attribute

    private java.lang.Object href;  // attribute

    public CnType() {
    }

    public CnType(
           org.apache.axis.message.MessageElement [] _any,
           org.apache.axis.types.PositiveInteger base,
           org.w3.www._1998.Math.MathML.Type type,
           java.lang.String encoding,
           org.apache.axis.types.URI definitionURL,
           org.apache.axis.types.NMTokens _class,
           java.lang.String style,
           org.apache.axis.types.IDRef xref,
           org.apache.axis.types.Id id,
           java.lang.Object href) {
           this._any = _any;
           this.base = base;
           this.type = type;
           this.encoding = encoding;
           this.definitionURL = definitionURL;
           this._class = _class;
           this.style = style;
           this.xref = xref;
           this.id = id;
           this.href = href;
    }


    /**
     * Gets the _any value for this CnType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this CnType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the base value for this CnType.
     * 
     * @return base
     */
    public org.apache.axis.types.PositiveInteger getBase() {
        return base;
    }


    /**
     * Sets the base value for this CnType.
     * 
     * @param base
     */
    public void setBase(org.apache.axis.types.PositiveInteger base) {
        this.base = base;
    }


    /**
     * Gets the type value for this CnType.
     * 
     * @return type
     */
    public org.w3.www._1998.Math.MathML.Type getType() {
        return type;
    }


    /**
     * Sets the type value for this CnType.
     * 
     * @param type
     */
    public void setType(org.w3.www._1998.Math.MathML.Type type) {
        this.type = type;
    }


    /**
     * Gets the encoding value for this CnType.
     * 
     * @return encoding
     */
    public java.lang.String getEncoding() {
        return encoding;
    }


    /**
     * Sets the encoding value for this CnType.
     * 
     * @param encoding
     */
    public void setEncoding(java.lang.String encoding) {
        this.encoding = encoding;
    }


    /**
     * Gets the definitionURL value for this CnType.
     * 
     * @return definitionURL
     */
    public org.apache.axis.types.URI getDefinitionURL() {
        return definitionURL;
    }


    /**
     * Sets the definitionURL value for this CnType.
     * 
     * @param definitionURL
     */
    public void setDefinitionURL(org.apache.axis.types.URI definitionURL) {
        this.definitionURL = definitionURL;
    }


    /**
     * Gets the _class value for this CnType.
     * 
     * @return _class
     */
    public org.apache.axis.types.NMTokens get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this CnType.
     * 
     * @param _class
     */
    public void set_class(org.apache.axis.types.NMTokens _class) {
        this._class = _class;
    }


    /**
     * Gets the style value for this CnType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this CnType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the xref value for this CnType.
     * 
     * @return xref
     */
    public org.apache.axis.types.IDRef getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this CnType.
     * 
     * @param xref
     */
    public void setXref(org.apache.axis.types.IDRef xref) {
        this.xref = xref;
    }


    /**
     * Gets the id value for this CnType.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this CnType.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the href value for this CnType.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this CnType.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CnType)) return false;
        CnType other = (CnType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.base==null && other.getBase()==null) || 
             (this.base!=null &&
              this.base.equals(other.getBase()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.encoding==null && other.getEncoding()==null) || 
             (this.encoding!=null &&
              this.encoding.equals(other.getEncoding()))) &&
            ((this.definitionURL==null && other.getDefinitionURL()==null) || 
             (this.definitionURL!=null &&
              this.definitionURL.equals(other.getDefinitionURL()))) &&
            ((this._class==null && other.get_class()==null) || 
             (this._class!=null &&
              this._class.equals(other.get_class()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              this.style.equals(other.getStyle()))) &&
            ((this.xref==null && other.getXref()==null) || 
             (this.xref!=null &&
              this.xref.equals(other.getXref()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.href==null && other.getHref()==null) || 
             (this.href!=null &&
              this.href.equals(other.getHref())));
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
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBase() != null) {
            _hashCode += getBase().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getEncoding() != null) {
            _hashCode += getEncoding().hashCode();
        }
        if (getDefinitionURL() != null) {
            _hashCode += getDefinitionURL().hashCode();
        }
        if (get_class() != null) {
            _hashCode += get_class().hashCode();
        }
        if (getStyle() != null) {
            _hashCode += getStyle().hashCode();
        }
        if (getXref() != null) {
            _hashCode += getXref().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getHref() != null) {
            _hashCode += getHref().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CnType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "cn.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("base");
        attrField.setXmlName(new javax.xml.namespace.QName("", "base"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">base"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">type"));
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
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("_class");
        attrField.setXmlName(new javax.xml.namespace.QName("", "class"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "NMTOKENS"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("style");
        attrField.setXmlName(new javax.xml.namespace.QName("", "style"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("xref");
        attrField.setXmlName(new javax.xml.namespace.QName("", "xref"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "IDREF"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "ID"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("href");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "href"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
