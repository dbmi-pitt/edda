/**
 * Type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class Type implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Type(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _value1 = new org.apache.axis.types.NMToken("e-notation");
    public static final org.apache.axis.types.NMToken _value2 = new org.apache.axis.types.NMToken("integer");
    public static final org.apache.axis.types.NMToken _value3 = new org.apache.axis.types.NMToken("rational");
    public static final org.apache.axis.types.NMToken _value4 = new org.apache.axis.types.NMToken("real");
    public static final org.apache.axis.types.NMToken _value5 = new org.apache.axis.types.NMToken("complex-cartesian");
    public static final org.apache.axis.types.NMToken _value6 = new org.apache.axis.types.NMToken("complex-polar");
    public static final org.apache.axis.types.NMToken _value7 = new org.apache.axis.types.NMToken("constant");
    public static final Type value1 = new Type(_value1);
    public static final Type value2 = new Type(_value2);
    public static final Type value3 = new Type(_value3);
    public static final Type value4 = new Type(_value4);
    public static final Type value5 = new Type(_value5);
    public static final Type value6 = new Type(_value6);
    public static final Type value7 = new Type(_value7);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Type fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Type enumeration = (Type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Type fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        try {
            return fromValue(new org.apache.axis.types.NMToken(value));
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_.toString();}
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
        new org.apache.axis.description.TypeDesc(Type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
