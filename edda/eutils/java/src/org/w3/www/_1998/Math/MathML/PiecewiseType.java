/**
 * PiecewiseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class PiecewiseType  implements java.io.Serializable {
    private org.w3.www._1998.Math.MathML.PieceType[] piece;

    private org.w3.www._1998.Math.MathML.OtherwiseType otherwise;

    private org.w3.www._1998.Math.MathML.PieceType[] piece2;

    private org.apache.axis.types.NMTokens _class;  // attribute

    private java.lang.String style;  // attribute

    private org.apache.axis.types.IDRef xref;  // attribute

    private org.apache.axis.types.Id id;  // attribute

    private java.lang.Object href;  // attribute

    public PiecewiseType() {
    }

    public PiecewiseType(
           org.w3.www._1998.Math.MathML.PieceType[] piece,
           org.w3.www._1998.Math.MathML.OtherwiseType otherwise,
           org.w3.www._1998.Math.MathML.PieceType[] piece2,
           org.apache.axis.types.NMTokens _class,
           java.lang.String style,
           org.apache.axis.types.IDRef xref,
           org.apache.axis.types.Id id,
           java.lang.Object href) {
           this.piece = piece;
           this.otherwise = otherwise;
           this.piece2 = piece2;
           this._class = _class;
           this.style = style;
           this.xref = xref;
           this.id = id;
           this.href = href;
    }


    /**
     * Gets the piece value for this PiecewiseType.
     * 
     * @return piece
     */
    public org.w3.www._1998.Math.MathML.PieceType[] getPiece() {
        return piece;
    }


    /**
     * Sets the piece value for this PiecewiseType.
     * 
     * @param piece
     */
    public void setPiece(org.w3.www._1998.Math.MathML.PieceType[] piece) {
        this.piece = piece;
    }

    public org.w3.www._1998.Math.MathML.PieceType getPiece(int i) {
        return this.piece[i];
    }

    public void setPiece(int i, org.w3.www._1998.Math.MathML.PieceType _value) {
        this.piece[i] = _value;
    }


    /**
     * Gets the otherwise value for this PiecewiseType.
     * 
     * @return otherwise
     */
    public org.w3.www._1998.Math.MathML.OtherwiseType getOtherwise() {
        return otherwise;
    }


    /**
     * Sets the otherwise value for this PiecewiseType.
     * 
     * @param otherwise
     */
    public void setOtherwise(org.w3.www._1998.Math.MathML.OtherwiseType otherwise) {
        this.otherwise = otherwise;
    }


    /**
     * Gets the piece2 value for this PiecewiseType.
     * 
     * @return piece2
     */
    public org.w3.www._1998.Math.MathML.PieceType[] getPiece2() {
        return piece2;
    }


    /**
     * Sets the piece2 value for this PiecewiseType.
     * 
     * @param piece2
     */
    public void setPiece2(org.w3.www._1998.Math.MathML.PieceType[] piece2) {
        this.piece2 = piece2;
    }

    public org.w3.www._1998.Math.MathML.PieceType getPiece2(int i) {
        return this.piece2[i];
    }

    public void setPiece2(int i, org.w3.www._1998.Math.MathML.PieceType _value) {
        this.piece2[i] = _value;
    }


    /**
     * Gets the _class value for this PiecewiseType.
     * 
     * @return _class
     */
    public org.apache.axis.types.NMTokens get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this PiecewiseType.
     * 
     * @param _class
     */
    public void set_class(org.apache.axis.types.NMTokens _class) {
        this._class = _class;
    }


    /**
     * Gets the style value for this PiecewiseType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this PiecewiseType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the xref value for this PiecewiseType.
     * 
     * @return xref
     */
    public org.apache.axis.types.IDRef getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this PiecewiseType.
     * 
     * @param xref
     */
    public void setXref(org.apache.axis.types.IDRef xref) {
        this.xref = xref;
    }


    /**
     * Gets the id value for this PiecewiseType.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this PiecewiseType.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the href value for this PiecewiseType.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this PiecewiseType.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PiecewiseType)) return false;
        PiecewiseType other = (PiecewiseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.piece==null && other.getPiece()==null) || 
             (this.piece!=null &&
              java.util.Arrays.equals(this.piece, other.getPiece()))) &&
            ((this.otherwise==null && other.getOtherwise()==null) || 
             (this.otherwise!=null &&
              this.otherwise.equals(other.getOtherwise()))) &&
            ((this.piece2==null && other.getPiece2()==null) || 
             (this.piece2!=null &&
              java.util.Arrays.equals(this.piece2, other.getPiece2()))) &&
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
        if (getPiece() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPiece());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPiece(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOtherwise() != null) {
            _hashCode += getOtherwise().hashCode();
        }
        if (getPiece2() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPiece2());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPiece2(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(PiecewiseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "piecewise.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
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
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("piece");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "piece"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "piece"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherwise");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "otherwise"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "otherwise.type"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("piece");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "piece"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "piece"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
