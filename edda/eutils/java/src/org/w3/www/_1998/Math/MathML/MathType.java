/**
 * MathType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class MathType  implements java.io.Serializable {
    private java.lang.String baseline;  // attribute

    private org.w3.www._1998.Math.MathML.Overflow overflow;  // attribute

    private org.apache.axis.types.URI altimg;  // attribute

    private java.lang.String alttext;  // attribute

    private java.lang.String type;  // attribute

    private java.lang.String name;  // attribute

    private java.lang.String height;  // attribute

    private java.lang.String width;  // attribute

    private java.lang.String macros;  // attribute

    private org.w3.www._1998.Math.MathML.Display display;  // attribute

    private org.apache.axis.types.NMTokens _class;  // attribute

    private java.lang.String style;  // attribute

    private org.apache.axis.types.IDRef xref;  // attribute

    private org.apache.axis.types.Id id;  // attribute

    private java.lang.Object href;  // attribute

    public MathType() {
    }

    public MathType(
           java.lang.String baseline,
           org.w3.www._1998.Math.MathML.Overflow overflow,
           org.apache.axis.types.URI altimg,
           java.lang.String alttext,
           java.lang.String type,
           java.lang.String name,
           java.lang.String height,
           java.lang.String width,
           java.lang.String macros,
           org.w3.www._1998.Math.MathML.Display display,
           org.apache.axis.types.NMTokens _class,
           java.lang.String style,
           org.apache.axis.types.IDRef xref,
           org.apache.axis.types.Id id,
           java.lang.Object href) {
           this.baseline = baseline;
           this.overflow = overflow;
           this.altimg = altimg;
           this.alttext = alttext;
           this.type = type;
           this.name = name;
           this.height = height;
           this.width = width;
           this.macros = macros;
           this.display = display;
           this._class = _class;
           this.style = style;
           this.xref = xref;
           this.id = id;
           this.href = href;
    }


    /**
     * Gets the baseline value for this MathType.
     * 
     * @return baseline
     */
    public java.lang.String getBaseline() {
        return baseline;
    }


    /**
     * Sets the baseline value for this MathType.
     * 
     * @param baseline
     */
    public void setBaseline(java.lang.String baseline) {
        this.baseline = baseline;
    }


    /**
     * Gets the overflow value for this MathType.
     * 
     * @return overflow
     */
    public org.w3.www._1998.Math.MathML.Overflow getOverflow() {
        return overflow;
    }


    /**
     * Sets the overflow value for this MathType.
     * 
     * @param overflow
     */
    public void setOverflow(org.w3.www._1998.Math.MathML.Overflow overflow) {
        this.overflow = overflow;
    }


    /**
     * Gets the altimg value for this MathType.
     * 
     * @return altimg
     */
    public org.apache.axis.types.URI getAltimg() {
        return altimg;
    }


    /**
     * Sets the altimg value for this MathType.
     * 
     * @param altimg
     */
    public void setAltimg(org.apache.axis.types.URI altimg) {
        this.altimg = altimg;
    }


    /**
     * Gets the alttext value for this MathType.
     * 
     * @return alttext
     */
    public java.lang.String getAlttext() {
        return alttext;
    }


    /**
     * Sets the alttext value for this MathType.
     * 
     * @param alttext
     */
    public void setAlttext(java.lang.String alttext) {
        this.alttext = alttext;
    }


    /**
     * Gets the type value for this MathType.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this MathType.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the name value for this MathType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this MathType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the height value for this MathType.
     * 
     * @return height
     */
    public java.lang.String getHeight() {
        return height;
    }


    /**
     * Sets the height value for this MathType.
     * 
     * @param height
     */
    public void setHeight(java.lang.String height) {
        this.height = height;
    }


    /**
     * Gets the width value for this MathType.
     * 
     * @return width
     */
    public java.lang.String getWidth() {
        return width;
    }


    /**
     * Sets the width value for this MathType.
     * 
     * @param width
     */
    public void setWidth(java.lang.String width) {
        this.width = width;
    }


    /**
     * Gets the macros value for this MathType.
     * 
     * @return macros
     */
    public java.lang.String getMacros() {
        return macros;
    }


    /**
     * Sets the macros value for this MathType.
     * 
     * @param macros
     */
    public void setMacros(java.lang.String macros) {
        this.macros = macros;
    }


    /**
     * Gets the display value for this MathType.
     * 
     * @return display
     */
    public org.w3.www._1998.Math.MathML.Display getDisplay() {
        return display;
    }


    /**
     * Sets the display value for this MathType.
     * 
     * @param display
     */
    public void setDisplay(org.w3.www._1998.Math.MathML.Display display) {
        this.display = display;
    }


    /**
     * Gets the _class value for this MathType.
     * 
     * @return _class
     */
    public org.apache.axis.types.NMTokens get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this MathType.
     * 
     * @param _class
     */
    public void set_class(org.apache.axis.types.NMTokens _class) {
        this._class = _class;
    }


    /**
     * Gets the style value for this MathType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this MathType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the xref value for this MathType.
     * 
     * @return xref
     */
    public org.apache.axis.types.IDRef getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this MathType.
     * 
     * @param xref
     */
    public void setXref(org.apache.axis.types.IDRef xref) {
        this.xref = xref;
    }


    /**
     * Gets the id value for this MathType.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this MathType.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the href value for this MathType.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this MathType.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MathType)) return false;
        MathType other = (MathType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.baseline==null && other.getBaseline()==null) || 
             (this.baseline!=null &&
              this.baseline.equals(other.getBaseline()))) &&
            ((this.overflow==null && other.getOverflow()==null) || 
             (this.overflow!=null &&
              this.overflow.equals(other.getOverflow()))) &&
            ((this.altimg==null && other.getAltimg()==null) || 
             (this.altimg!=null &&
              this.altimg.equals(other.getAltimg()))) &&
            ((this.alttext==null && other.getAlttext()==null) || 
             (this.alttext!=null &&
              this.alttext.equals(other.getAlttext()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.height==null && other.getHeight()==null) || 
             (this.height!=null &&
              this.height.equals(other.getHeight()))) &&
            ((this.width==null && other.getWidth()==null) || 
             (this.width!=null &&
              this.width.equals(other.getWidth()))) &&
            ((this.macros==null && other.getMacros()==null) || 
             (this.macros!=null &&
              this.macros.equals(other.getMacros()))) &&
            ((this.display==null && other.getDisplay()==null) || 
             (this.display!=null &&
              this.display.equals(other.getDisplay()))) &&
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
        if (getBaseline() != null) {
            _hashCode += getBaseline().hashCode();
        }
        if (getOverflow() != null) {
            _hashCode += getOverflow().hashCode();
        }
        if (getAltimg() != null) {
            _hashCode += getAltimg().hashCode();
        }
        if (getAlttext() != null) {
            _hashCode += getAlttext().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getHeight() != null) {
            _hashCode += getHeight().hashCode();
        }
        if (getWidth() != null) {
            _hashCode += getWidth().hashCode();
        }
        if (getMacros() != null) {
            _hashCode += getMacros().hashCode();
        }
        if (getDisplay() != null) {
            _hashCode += getDisplay().hashCode();
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
        new org.apache.axis.description.TypeDesc(MathType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "math.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("baseline");
        attrField.setXmlName(new javax.xml.namespace.QName("", "baseline"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("overflow");
        attrField.setXmlName(new javax.xml.namespace.QName("", "overflow"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">overflow"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("altimg");
        attrField.setXmlName(new javax.xml.namespace.QName("", "altimg"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alttext");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alttext"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("height");
        attrField.setXmlName(new javax.xml.namespace.QName("", "height"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("width");
        attrField.setXmlName(new javax.xml.namespace.QName("", "width"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("macros");
        attrField.setXmlName(new javax.xml.namespace.QName("", "macros"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("display");
        attrField.setXmlName(new javax.xml.namespace.QName("", "display"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">display"));
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
