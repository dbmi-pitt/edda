/**
 * OtherAbstractTypeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class OtherAbstractTypeType implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected OtherAbstractTypeType(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _AAMC = new org.apache.axis.types.NMToken("AAMC");
    public static final org.apache.axis.types.NMToken _AIDS = new org.apache.axis.types.NMToken("AIDS");
    public static final org.apache.axis.types.NMToken _KIE = new org.apache.axis.types.NMToken("KIE");
    public static final org.apache.axis.types.NMToken _PIP = new org.apache.axis.types.NMToken("PIP");
    public static final org.apache.axis.types.NMToken _NASA = new org.apache.axis.types.NMToken("NASA");
    public static final org.apache.axis.types.NMToken _Publisher = new org.apache.axis.types.NMToken("Publisher");
    public static final OtherAbstractTypeType AAMC = new OtherAbstractTypeType(_AAMC);
    public static final OtherAbstractTypeType AIDS = new OtherAbstractTypeType(_AIDS);
    public static final OtherAbstractTypeType KIE = new OtherAbstractTypeType(_KIE);
    public static final OtherAbstractTypeType PIP = new OtherAbstractTypeType(_PIP);
    public static final OtherAbstractTypeType NASA = new OtherAbstractTypeType(_NASA);
    public static final OtherAbstractTypeType Publisher = new OtherAbstractTypeType(_Publisher);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static OtherAbstractTypeType fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        OtherAbstractTypeType enumeration = (OtherAbstractTypeType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static OtherAbstractTypeType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(OtherAbstractTypeType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">OtherAbstractType>Type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
