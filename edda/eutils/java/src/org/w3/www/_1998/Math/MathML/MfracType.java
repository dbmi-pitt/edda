/**
 * MfracType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class MfracType  implements java.io.Serializable {
    private boolean bevelled;  // attribute

    private org.w3.www._1998.Math.MathML.Centering denomalign;  // attribute

    private org.w3.www._1998.Math.MathML.Centering numalign;  // attribute

    private org.w3.www._1998.Math.MathML.Linethickness linethickness;  // attribute

    private org.apache.axis.types.NMTokens _class;  // attribute

    private java.lang.String style;  // attribute

    private org.apache.axis.types.IDRef xref;  // attribute

    private org.apache.axis.types.Id id;  // attribute

    private java.lang.Object href;  // attribute

    public MfracType() {
    }

    public MfracType(
           boolean bevelled,
           org.w3.www._1998.Math.MathML.Centering denomalign,
           org.w3.www._1998.Math.MathML.Centering numalign,
           org.w3.www._1998.Math.MathML.Linethickness linethickness,
           org.apache.axis.types.NMTokens _class,
           java.lang.String style,
           org.apache.axis.types.IDRef xref,
           org.apache.axis.types.Id id,
           java.lang.Object href) {
           this.bevelled = bevelled;
           this.denomalign = denomalign;
           this.numalign = numalign;
           this.linethickness = linethickness;
           this._class = _class;
           this.style = style;
           this.xref = xref;
           this.id = id;
           this.href = href;
    }


    /**
     * Gets the bevelled value for this MfracType.
     * 
     * @return bevelled
     */
    public boolean isBevelled() {
        return bevelled;
    }


    /**
     * Sets the bevelled value for this MfracType.
     * 
     * @param bevelled
     */
    public void setBevelled(boolean bevelled) {
        this.bevelled = bevelled;
    }


    /**
     * Gets the denomalign value for this MfracType.
     * 
     * @return denomalign
     */
    public org.w3.www._1998.Math.MathML.Centering getDenomalign() {
        return denomalign;
    }


    /**
     * Sets the denomalign value for this MfracType.
     * 
     * @param denomalign
     */
    public void setDenomalign(org.w3.www._1998.Math.MathML.Centering denomalign) {
        this.denomalign = denomalign;
    }


    /**
     * Gets the numalign value for this MfracType.
     * 
     * @return numalign
     */
    public org.w3.www._1998.Math.MathML.Centering getNumalign() {
        return numalign;
    }


    /**
     * Sets the numalign value for this MfracType.
     * 
     * @param numalign
     */
    public void setNumalign(org.w3.www._1998.Math.MathML.Centering numalign) {
        this.numalign = numalign;
    }


    /**
     * Gets the linethickness value for this MfracType.
     * 
     * @return linethickness
     */
    public org.w3.www._1998.Math.MathML.Linethickness getLinethickness() {
        return linethickness;
    }


    /**
     * Sets the linethickness value for this MfracType.
     * 
     * @param linethickness
     */
    public void setLinethickness(org.w3.www._1998.Math.MathML.Linethickness linethickness) {
        this.linethickness = linethickness;
    }


    /**
     * Gets the _class value for this MfracType.
     * 
     * @return _class
     */
    public org.apache.axis.types.NMTokens get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this MfracType.
     * 
     * @param _class
     */
    public void set_class(org.apache.axis.types.NMTokens _class) {
        this._class = _class;
    }


    /**
     * Gets the style value for this MfracType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this MfracType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the xref value for this MfracType.
     * 
     * @return xref
     */
    public org.apache.axis.types.IDRef getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this MfracType.
     * 
     * @param xref
     */
    public void setXref(org.apache.axis.types.IDRef xref) {
        this.xref = xref;
    }


    /**
     * Gets the id value for this MfracType.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this MfracType.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the href value for this MfracType.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this MfracType.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MfracType)) return false;
        MfracType other = (MfracType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.bevelled == other.isBevelled() &&
            ((this.denomalign==null && other.getDenomalign()==null) || 
             (this.denomalign!=null &&
              this.denomalign.equals(other.getDenomalign()))) &&
            ((this.numalign==null && other.getNumalign()==null) || 
             (this.numalign!=null &&
              this.numalign.equals(other.getNumalign()))) &&
            ((this.linethickness==null && other.getLinethickness()==null) || 
             (this.linethickness!=null &&
              this.linethickness.equals(other.getLinethickness()))) &&
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
        _hashCode += (isBevelled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDenomalign() != null) {
            _hashCode += getDenomalign().hashCode();
        }
        if (getNumalign() != null) {
            _hashCode += getNumalign().hashCode();
        }
        if (getLinethickness() != null) {
            _hashCode += getLinethickness().hashCode();
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
        new org.apache.axis.description.TypeDesc(MfracType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mfrac.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bevelled");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bevelled"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("denomalign");
        attrField.setXmlName(new javax.xml.namespace.QName("", "denomalign"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "centering"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("numalign");
        attrField.setXmlName(new javax.xml.namespace.QName("", "numalign"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "centering"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("linethickness");
        attrField.setXmlName(new javax.xml.namespace.QName("", "linethickness"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">linethickness"));
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
