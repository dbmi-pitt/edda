/**
 * Notation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class Notation implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Notation(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _actuarial = "actuarial";
    public static final java.lang.String _longdiv = "longdiv";
    public static final java.lang.String _radical = "radical";
    public static final java.lang.String _box = "box";
    public static final java.lang.String _roundedbox = "roundedbox";
    public static final java.lang.String _circle = "circle";
    public static final java.lang.String _left = "left";
    public static final java.lang.String _right = "right";
    public static final java.lang.String _top = "top";
    public static final java.lang.String _bottom = "bottom";
    public static final java.lang.String _updiagonalstrike = "updiagonalstrike";
    public static final java.lang.String _downdiagonalstrike = "downdiagonalstrike";
    public static final java.lang.String _verticalstrike = "verticalstrike";
    public static final java.lang.String _horizontalstrike = "horizontalstrike";
    public static final Notation actuarial = new Notation(_actuarial);
    public static final Notation longdiv = new Notation(_longdiv);
    public static final Notation radical = new Notation(_radical);
    public static final Notation box = new Notation(_box);
    public static final Notation roundedbox = new Notation(_roundedbox);
    public static final Notation circle = new Notation(_circle);
    public static final Notation left = new Notation(_left);
    public static final Notation right = new Notation(_right);
    public static final Notation top = new Notation(_top);
    public static final Notation bottom = new Notation(_bottom);
    public static final Notation updiagonalstrike = new Notation(_updiagonalstrike);
    public static final Notation downdiagonalstrike = new Notation(_downdiagonalstrike);
    public static final Notation verticalstrike = new Notation(_verticalstrike);
    public static final Notation horizontalstrike = new Notation(_horizontalstrike);
    public java.lang.String getValue() { return _value_;}
    public static Notation fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Notation enumeration = (Notation)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Notation fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Notation.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">notation"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
