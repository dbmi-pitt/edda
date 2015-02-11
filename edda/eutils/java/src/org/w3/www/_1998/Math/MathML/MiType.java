/**
 * MiType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class MiType  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private org.w3.www._1998.Math.MathML.Mathvariant mathvariant;  // attribute

    private org.w3.www._1998.Math.MathML.Mathsize mathsize;  // attribute

    private java.lang.String mathcolor;  // attribute

    private java.lang.String mathbackground;  // attribute

    private org.apache.axis.types.NMTokens _class;  // attribute

    private java.lang.String style;  // attribute

    private org.apache.axis.types.IDRef xref;  // attribute

    private org.apache.axis.types.Id id;  // attribute

    private java.lang.Object href;  // attribute

    public MiType() {
    }

    public MiType(
           org.apache.axis.message.MessageElement [] _any,
           org.w3.www._1998.Math.MathML.Mathvariant mathvariant,
           org.w3.www._1998.Math.MathML.Mathsize mathsize,
           java.lang.String mathcolor,
           java.lang.String mathbackground,
           org.apache.axis.types.NMTokens _class,
           java.lang.String style,
           org.apache.axis.types.IDRef xref,
           org.apache.axis.types.Id id,
           java.lang.Object href) {
           this._any = _any;
           this.mathvariant = mathvariant;
           this.mathsize = mathsize;
           this.mathcolor = mathcolor;
           this.mathbackground = mathbackground;
           this._class = _class;
           this.style = style;
           this.xref = xref;
           this.id = id;
           this.href = href;
    }


    /**
     * Gets the _any value for this MiType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this MiType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the mathvariant value for this MiType.
     * 
     * @return mathvariant
     */
    public org.w3.www._1998.Math.MathML.Mathvariant getMathvariant() {
        return mathvariant;
    }


    /**
     * Sets the mathvariant value for this MiType.
     * 
     * @param mathvariant
     */
    public void setMathvariant(org.w3.www._1998.Math.MathML.Mathvariant mathvariant) {
        this.mathvariant = mathvariant;
    }


    /**
     * Gets the mathsize value for this MiType.
     * 
     * @return mathsize
     */
    public org.w3.www._1998.Math.MathML.Mathsize getMathsize() {
        return mathsize;
    }


    /**
     * Sets the mathsize value for this MiType.
     * 
     * @param mathsize
     */
    public void setMathsize(org.w3.www._1998.Math.MathML.Mathsize mathsize) {
        this.mathsize = mathsize;
    }


    /**
     * Gets the mathcolor value for this MiType.
     * 
     * @return mathcolor
     */
    public java.lang.String getMathcolor() {
        return mathcolor;
    }


    /**
     * Sets the mathcolor value for this MiType.
     * 
     * @param mathcolor
     */
    public void setMathcolor(java.lang.String mathcolor) {
        this.mathcolor = mathcolor;
    }


    /**
     * Gets the mathbackground value for this MiType.
     * 
     * @return mathbackground
     */
    public java.lang.String getMathbackground() {
        return mathbackground;
    }


    /**
     * Sets the mathbackground value for this MiType.
     * 
     * @param mathbackground
     */
    public void setMathbackground(java.lang.String mathbackground) {
        this.mathbackground = mathbackground;
    }


    /**
     * Gets the _class value for this MiType.
     * 
     * @return _class
     */
    public org.apache.axis.types.NMTokens get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this MiType.
     * 
     * @param _class
     */
    public void set_class(org.apache.axis.types.NMTokens _class) {
        this._class = _class;
    }


    /**
     * Gets the style value for this MiType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this MiType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the xref value for this MiType.
     * 
     * @return xref
     */
    public org.apache.axis.types.IDRef getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this MiType.
     * 
     * @param xref
     */
    public void setXref(org.apache.axis.types.IDRef xref) {
        this.xref = xref;
    }


    /**
     * Gets the id value for this MiType.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this MiType.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the href value for this MiType.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this MiType.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MiType)) return false;
        MiType other = (MiType) obj;
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
            ((this.mathvariant==null && other.getMathvariant()==null) || 
             (this.mathvariant!=null &&
              this.mathvariant.equals(other.getMathvariant()))) &&
            ((this.mathsize==null && other.getMathsize()==null) || 
             (this.mathsize!=null &&
              this.mathsize.equals(other.getMathsize()))) &&
            ((this.mathcolor==null && other.getMathcolor()==null) || 
             (this.mathcolor!=null &&
              this.mathcolor.equals(other.getMathcolor()))) &&
            ((this.mathbackground==null && other.getMathbackground()==null) || 
             (this.mathbackground!=null &&
              this.mathbackground.equals(other.getMathbackground()))) &&
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
        if (getMathvariant() != null) {
            _hashCode += getMathvariant().hashCode();
        }
        if (getMathsize() != null) {
            _hashCode += getMathsize().hashCode();
        }
        if (getMathcolor() != null) {
            _hashCode += getMathcolor().hashCode();
        }
        if (getMathbackground() != null) {
            _hashCode += getMathbackground().hashCode();
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
        new org.apache.axis.description.TypeDesc(MiType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mi.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathvariant");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathvariant"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">mathvariant"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathsize");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathsize"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">mathsize"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathcolor");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathcolor"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathbackground");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathbackground"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
