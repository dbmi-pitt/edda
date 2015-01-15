/**
 * KeywordListTypeOwner.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class KeywordListTypeOwner implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected KeywordListTypeOwner(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _value1 = new org.apache.axis.types.NMToken("NLM");
    public static final org.apache.axis.types.NMToken _value2 = new org.apache.axis.types.NMToken("NLM-AUTO");
    public static final org.apache.axis.types.NMToken _value3 = new org.apache.axis.types.NMToken("NASA");
    public static final org.apache.axis.types.NMToken _value4 = new org.apache.axis.types.NMToken("PIP");
    public static final org.apache.axis.types.NMToken _value5 = new org.apache.axis.types.NMToken("KIE");
    public static final org.apache.axis.types.NMToken _value6 = new org.apache.axis.types.NMToken("NOTNLM");
    public static final org.apache.axis.types.NMToken _value7 = new org.apache.axis.types.NMToken("HHS");
    public static final KeywordListTypeOwner value1 = new KeywordListTypeOwner(_value1);
    public static final KeywordListTypeOwner value2 = new KeywordListTypeOwner(_value2);
    public static final KeywordListTypeOwner value3 = new KeywordListTypeOwner(_value3);
    public static final KeywordListTypeOwner value4 = new KeywordListTypeOwner(_value4);
    public static final KeywordListTypeOwner value5 = new KeywordListTypeOwner(_value5);
    public static final KeywordListTypeOwner value6 = new KeywordListTypeOwner(_value6);
    public static final KeywordListTypeOwner value7 = new KeywordListTypeOwner(_value7);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static KeywordListTypeOwner fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        KeywordListTypeOwner enumeration = (KeywordListTypeOwner)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static KeywordListTypeOwner fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(KeywordListTypeOwner.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">KeywordListType>Owner"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
