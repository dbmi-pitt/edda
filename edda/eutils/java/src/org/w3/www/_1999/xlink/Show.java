/**
 * Show.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1999.xlink;

public class Show implements java.io.Serializable {
    private org.apache.axis.types.Token _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Show(org.apache.axis.types.Token value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.Token _value1 = new org.apache.axis.types.Token("embed");
    public static final org.apache.axis.types.Token _value2 = new org.apache.axis.types.Token("new");
    public static final org.apache.axis.types.Token _value3 = new org.apache.axis.types.Token("none");
    public static final org.apache.axis.types.Token _value4 = new org.apache.axis.types.Token("other");
    public static final org.apache.axis.types.Token _value5 = new org.apache.axis.types.Token("replace");
    public static final Show value1 = new Show(_value1);
    public static final Show value2 = new Show(_value2);
    public static final Show value3 = new Show(_value3);
    public static final Show value4 = new Show(_value4);
    public static final Show value5 = new Show(_value5);
    public org.apache.axis.types.Token getValue() { return _value_;}
    public static Show fromValue(org.apache.axis.types.Token value)
          throws java.lang.IllegalArgumentException {
        Show enumeration = (Show)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Show fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        try {
            return fromValue(new org.apache.axis.types.Token(value));
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
        new org.apache.axis.description.TypeDesc(Show.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">show"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
