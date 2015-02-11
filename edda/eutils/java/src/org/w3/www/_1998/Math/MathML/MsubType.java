/**
 * MsubType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class MsubType  implements java.io.Serializable {
    private java.lang.String subscriptshift;  // attribute

    private org.apache.axis.types.NMTokens _class;  // attribute

    private java.lang.String style;  // attribute

    private org.apache.axis.types.IDRef xref;  // attribute

    private org.apache.axis.types.Id id;  // attribute

    private java.lang.Object href;  // attribute

    public MsubType() {
    }

    public MsubType(
           java.lang.String subscriptshift,
           org.apache.axis.types.NMTokens _class,
           java.lang.String style,
           org.apache.axis.types.IDRef xref,
           org.apache.axis.types.Id id,
           java.lang.Object href) {
           this.subscriptshift = subscriptshift;
           this._class = _class;
           this.style = style;
           this.xref = xref;
           this.id = id;
           this.href = href;
    }


    /**
     * Gets the subscriptshift value for this MsubType.
     * 
     * @return subscriptshift
     */
    public java.lang.String getSubscriptshift() {
        return subscriptshift;
    }


    /**
     * Sets the subscriptshift value for this MsubType.
     * 
     * @param subscriptshift
     */
    public void setSubscriptshift(java.lang.String subscriptshift) {
        this.subscriptshift = subscriptshift;
    }


    /**
     * Gets the _class value for this MsubType.
     * 
     * @return _class
     */
    public org.apache.axis.types.NMTokens get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this MsubType.
     * 
     * @param _class
     */
    public void set_class(org.apache.axis.types.NMTokens _class) {
        this._class = _class;
    }


    /**
     * Gets the style value for this MsubType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this MsubType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the xref value for this MsubType.
     * 
     * @return xref
     */
    public org.apache.axis.types.IDRef getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this MsubType.
     * 
     * @param xref
     */
    public void setXref(org.apache.axis.types.IDRef xref) {
        this.xref = xref;
    }


    /**
     * Gets the id value for this MsubType.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this MsubType.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the href value for this MsubType.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this MsubType.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsubType)) return false;
        MsubType other = (MsubType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subscriptshift==null && other.getSubscriptshift()==null) || 
             (this.subscriptshift!=null &&
              this.subscriptshift.equals(other.getSubscriptshift()))) &&
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
        if (getSubscriptshift() != null) {
            _hashCode += getSubscriptshift().hashCode();
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
        new org.apache.axis.description.TypeDesc(MsubType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "msub.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscriptshift");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscriptshift"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
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
