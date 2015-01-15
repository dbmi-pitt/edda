/**
 * Mathvariant.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class Mathvariant implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Mathvariant(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "normal";
    public static final java.lang.String _value2 = "bold";
    public static final java.lang.String _value3 = "italic";
    public static final java.lang.String _value4 = "bold-italic";
    public static final java.lang.String _value5 = "double-struck";
    public static final java.lang.String _value6 = "bold-fraktur";
    public static final java.lang.String _value7 = "script";
    public static final java.lang.String _value8 = "bold-script";
    public static final java.lang.String _value9 = "fraktur";
    public static final java.lang.String _value10 = "sans-serif";
    public static final java.lang.String _value11 = "bold-sans-serif";
    public static final java.lang.String _value12 = "sans-serif-italic";
    public static final java.lang.String _value13 = "sans-serif-bold-italic";
    public static final java.lang.String _value14 = "monospace";
    public static final Mathvariant value1 = new Mathvariant(_value1);
    public static final Mathvariant value2 = new Mathvariant(_value2);
    public static final Mathvariant value3 = new Mathvariant(_value3);
    public static final Mathvariant value4 = new Mathvariant(_value4);
    public static final Mathvariant value5 = new Mathvariant(_value5);
    public static final Mathvariant value6 = new Mathvariant(_value6);
    public static final Mathvariant value7 = new Mathvariant(_value7);
    public static final Mathvariant value8 = new Mathvariant(_value8);
    public static final Mathvariant value9 = new Mathvariant(_value9);
    public static final Mathvariant value10 = new Mathvariant(_value10);
    public static final Mathvariant value11 = new Mathvariant(_value11);
    public static final Mathvariant value12 = new Mathvariant(_value12);
    public static final Mathvariant value13 = new Mathvariant(_value13);
    public static final Mathvariant value14 = new Mathvariant(_value14);
    public java.lang.String getValue() { return _value_;}
    public static Mathvariant fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Mathvariant enumeration = (Mathvariant)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Mathvariant fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Mathvariant.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">mathvariant"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
