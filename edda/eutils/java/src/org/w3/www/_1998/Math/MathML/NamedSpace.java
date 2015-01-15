/**
 * NamedSpace.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class NamedSpace implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected NamedSpace(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _veryverythinmathspace = "veryverythinmathspace";
    public static final java.lang.String _verythinmathspace = "verythinmathspace";
    public static final java.lang.String _thinmathspace = "thinmathspace";
    public static final java.lang.String _mediummathspace = "mediummathspace";
    public static final java.lang.String _thickmathspace = "thickmathspace";
    public static final java.lang.String _verythickmathspace = "verythickmathspace";
    public static final java.lang.String _veryverythickmathspace = "veryverythickmathspace";
    public static final NamedSpace veryverythinmathspace = new NamedSpace(_veryverythinmathspace);
    public static final NamedSpace verythinmathspace = new NamedSpace(_verythinmathspace);
    public static final NamedSpace thinmathspace = new NamedSpace(_thinmathspace);
    public static final NamedSpace mediummathspace = new NamedSpace(_mediummathspace);
    public static final NamedSpace thickmathspace = new NamedSpace(_thickmathspace);
    public static final NamedSpace verythickmathspace = new NamedSpace(_verythickmathspace);
    public static final NamedSpace veryverythickmathspace = new NamedSpace(_veryverythickmathspace);
    public java.lang.String getValue() { return _value_;}
    public static NamedSpace fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        NamedSpace enumeration = (NamedSpace)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static NamedSpace fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(NamedSpace.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "named-space"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
