/**
 * PubMedPubDateTypePubStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class PubMedPubDateTypePubStatus implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected PubMedPubDateTypePubStatus(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _value1 = new org.apache.axis.types.NMToken("received");
    public static final org.apache.axis.types.NMToken _value2 = new org.apache.axis.types.NMToken("accepted");
    public static final org.apache.axis.types.NMToken _value3 = new org.apache.axis.types.NMToken("epublish");
    public static final org.apache.axis.types.NMToken _value4 = new org.apache.axis.types.NMToken("ppublish");
    public static final org.apache.axis.types.NMToken _value5 = new org.apache.axis.types.NMToken("revised");
    public static final org.apache.axis.types.NMToken _value6 = new org.apache.axis.types.NMToken("aheadofprint");
    public static final org.apache.axis.types.NMToken _value7 = new org.apache.axis.types.NMToken("retracted");
    public static final org.apache.axis.types.NMToken _value8 = new org.apache.axis.types.NMToken("ecollection");
    public static final org.apache.axis.types.NMToken _value9 = new org.apache.axis.types.NMToken("pmc");
    public static final org.apache.axis.types.NMToken _value10 = new org.apache.axis.types.NMToken("pmcr");
    public static final org.apache.axis.types.NMToken _value11 = new org.apache.axis.types.NMToken("pubmed");
    public static final org.apache.axis.types.NMToken _value12 = new org.apache.axis.types.NMToken("pubmedr");
    public static final org.apache.axis.types.NMToken _value13 = new org.apache.axis.types.NMToken("premedline");
    public static final org.apache.axis.types.NMToken _value14 = new org.apache.axis.types.NMToken("medline");
    public static final org.apache.axis.types.NMToken _value15 = new org.apache.axis.types.NMToken("medliner");
    public static final org.apache.axis.types.NMToken _value16 = new org.apache.axis.types.NMToken("entrez");
    public static final org.apache.axis.types.NMToken _value17 = new org.apache.axis.types.NMToken("pmc-release");
    public static final PubMedPubDateTypePubStatus value1 = new PubMedPubDateTypePubStatus(_value1);
    public static final PubMedPubDateTypePubStatus value2 = new PubMedPubDateTypePubStatus(_value2);
    public static final PubMedPubDateTypePubStatus value3 = new PubMedPubDateTypePubStatus(_value3);
    public static final PubMedPubDateTypePubStatus value4 = new PubMedPubDateTypePubStatus(_value4);
    public static final PubMedPubDateTypePubStatus value5 = new PubMedPubDateTypePubStatus(_value5);
    public static final PubMedPubDateTypePubStatus value6 = new PubMedPubDateTypePubStatus(_value6);
    public static final PubMedPubDateTypePubStatus value7 = new PubMedPubDateTypePubStatus(_value7);
    public static final PubMedPubDateTypePubStatus value8 = new PubMedPubDateTypePubStatus(_value8);
    public static final PubMedPubDateTypePubStatus value9 = new PubMedPubDateTypePubStatus(_value9);
    public static final PubMedPubDateTypePubStatus value10 = new PubMedPubDateTypePubStatus(_value10);
    public static final PubMedPubDateTypePubStatus value11 = new PubMedPubDateTypePubStatus(_value11);
    public static final PubMedPubDateTypePubStatus value12 = new PubMedPubDateTypePubStatus(_value12);
    public static final PubMedPubDateTypePubStatus value13 = new PubMedPubDateTypePubStatus(_value13);
    public static final PubMedPubDateTypePubStatus value14 = new PubMedPubDateTypePubStatus(_value14);
    public static final PubMedPubDateTypePubStatus value15 = new PubMedPubDateTypePubStatus(_value15);
    public static final PubMedPubDateTypePubStatus value16 = new PubMedPubDateTypePubStatus(_value16);
    public static final PubMedPubDateTypePubStatus value17 = new PubMedPubDateTypePubStatus(_value17);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static PubMedPubDateTypePubStatus fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        PubMedPubDateTypePubStatus enumeration = (PubMedPubDateTypePubStatus)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static PubMedPubDateTypePubStatus fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(PubMedPubDateTypePubStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">PubMedPubDateType>PubStatus"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
