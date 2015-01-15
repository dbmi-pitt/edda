/**
 * OtherIDTypeSource.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class OtherIDTypeSource implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected OtherIDTypeSource(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _NASA = new org.apache.axis.types.NMToken("NASA");
    public static final org.apache.axis.types.NMToken _KIE = new org.apache.axis.types.NMToken("KIE");
    public static final org.apache.axis.types.NMToken _PIP = new org.apache.axis.types.NMToken("PIP");
    public static final org.apache.axis.types.NMToken _POP = new org.apache.axis.types.NMToken("POP");
    public static final org.apache.axis.types.NMToken _ARPL = new org.apache.axis.types.NMToken("ARPL");
    public static final org.apache.axis.types.NMToken _CPC = new org.apache.axis.types.NMToken("CPC");
    public static final org.apache.axis.types.NMToken _IND = new org.apache.axis.types.NMToken("IND");
    public static final org.apache.axis.types.NMToken _CPFH = new org.apache.axis.types.NMToken("CPFH");
    public static final org.apache.axis.types.NMToken _CLML = new org.apache.axis.types.NMToken("CLML");
    public static final org.apache.axis.types.NMToken _NRCBL = new org.apache.axis.types.NMToken("NRCBL");
    public static final org.apache.axis.types.NMToken _NLM = new org.apache.axis.types.NMToken("NLM");
    public static final OtherIDTypeSource NASA = new OtherIDTypeSource(_NASA);
    public static final OtherIDTypeSource KIE = new OtherIDTypeSource(_KIE);
    public static final OtherIDTypeSource PIP = new OtherIDTypeSource(_PIP);
    public static final OtherIDTypeSource POP = new OtherIDTypeSource(_POP);
    public static final OtherIDTypeSource ARPL = new OtherIDTypeSource(_ARPL);
    public static final OtherIDTypeSource CPC = new OtherIDTypeSource(_CPC);
    public static final OtherIDTypeSource IND = new OtherIDTypeSource(_IND);
    public static final OtherIDTypeSource CPFH = new OtherIDTypeSource(_CPFH);
    public static final OtherIDTypeSource CLML = new OtherIDTypeSource(_CLML);
    public static final OtherIDTypeSource NRCBL = new OtherIDTypeSource(_NRCBL);
    public static final OtherIDTypeSource NLM = new OtherIDTypeSource(_NLM);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static OtherIDTypeSource fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        OtherIDTypeSource enumeration = (OtherIDTypeSource)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static OtherIDTypeSource fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(OtherIDTypeSource.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">OtherIDType>Source"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
