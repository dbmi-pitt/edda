/**
 * Linebreak.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class Linebreak implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Linebreak(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _auto = "auto";
    public static final java.lang.String _newline = "newline";
    public static final java.lang.String _indentingnewline = "indentingnewline";
    public static final java.lang.String _nobreak = "nobreak";
    public static final java.lang.String _goodbreak = "goodbreak";
    public static final java.lang.String _badbreak = "badbreak";
    public static final Linebreak auto = new Linebreak(_auto);
    public static final Linebreak newline = new Linebreak(_newline);
    public static final Linebreak indentingnewline = new Linebreak(_indentingnewline);
    public static final Linebreak nobreak = new Linebreak(_nobreak);
    public static final Linebreak goodbreak = new Linebreak(_goodbreak);
    public static final Linebreak badbreak = new Linebreak(_badbreak);
    public java.lang.String getValue() { return _value_;}
    public static Linebreak fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Linebreak enumeration = (Linebreak)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Linebreak fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Linebreak.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">linebreak"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
