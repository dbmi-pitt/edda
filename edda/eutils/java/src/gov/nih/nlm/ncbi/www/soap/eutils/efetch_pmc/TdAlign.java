/**
 * TdAlign.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class TdAlign implements java.io.Serializable {
    private org.apache.axis.types.Token _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TdAlign(org.apache.axis.types.Token value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.Token _value1 = new org.apache.axis.types.Token("left");
    public static final org.apache.axis.types.Token _value2 = new org.apache.axis.types.Token("center");
    public static final org.apache.axis.types.Token _value3 = new org.apache.axis.types.Token("right");
    public static final org.apache.axis.types.Token _value4 = new org.apache.axis.types.Token("justify");
    public static final org.apache.axis.types.Token _value5 = new org.apache.axis.types.Token("char");
    public static final TdAlign value1 = new TdAlign(_value1);
    public static final TdAlign value2 = new TdAlign(_value2);
    public static final TdAlign value3 = new TdAlign(_value3);
    public static final TdAlign value4 = new TdAlign(_value4);
    public static final TdAlign value5 = new TdAlign(_value5);
    public org.apache.axis.types.Token getValue() { return _value_;}
    public static TdAlign fromValue(org.apache.axis.types.Token value)
          throws java.lang.IllegalArgumentException {
        TdAlign enumeration = (TdAlign)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TdAlign fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(TdAlign.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>td>align"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}