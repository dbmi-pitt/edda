/**
 * CommentsCorrectionsTypeRefType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class CommentsCorrectionsTypeRefType implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CommentsCorrectionsTypeRefType(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _CommentOn = new org.apache.axis.types.NMToken("CommentOn");
    public static final org.apache.axis.types.NMToken _CommentIn = new org.apache.axis.types.NMToken("CommentIn");
    public static final org.apache.axis.types.NMToken _ErratumIn = new org.apache.axis.types.NMToken("ErratumIn");
    public static final org.apache.axis.types.NMToken _ErratumFor = new org.apache.axis.types.NMToken("ErratumFor");
    public static final org.apache.axis.types.NMToken _PartialRetractionIn = new org.apache.axis.types.NMToken("PartialRetractionIn");
    public static final org.apache.axis.types.NMToken _PartialRetractionOf = new org.apache.axis.types.NMToken("PartialRetractionOf");
    public static final org.apache.axis.types.NMToken _RepublishedFrom = new org.apache.axis.types.NMToken("RepublishedFrom");
    public static final org.apache.axis.types.NMToken _RepublishedIn = new org.apache.axis.types.NMToken("RepublishedIn");
    public static final org.apache.axis.types.NMToken _RetractionOf = new org.apache.axis.types.NMToken("RetractionOf");
    public static final org.apache.axis.types.NMToken _RetractionIn = new org.apache.axis.types.NMToken("RetractionIn");
    public static final org.apache.axis.types.NMToken _UpdateIn = new org.apache.axis.types.NMToken("UpdateIn");
    public static final org.apache.axis.types.NMToken _UpdateOf = new org.apache.axis.types.NMToken("UpdateOf");
    public static final org.apache.axis.types.NMToken _SummaryForPatientsIn = new org.apache.axis.types.NMToken("SummaryForPatientsIn");
    public static final org.apache.axis.types.NMToken _OriginalReportIn = new org.apache.axis.types.NMToken("OriginalReportIn");
    public static final org.apache.axis.types.NMToken _ReprintOf = new org.apache.axis.types.NMToken("ReprintOf");
    public static final org.apache.axis.types.NMToken _ReprintIn = new org.apache.axis.types.NMToken("ReprintIn");
    public static final org.apache.axis.types.NMToken _Cites = new org.apache.axis.types.NMToken("Cites");
    public static final CommentsCorrectionsTypeRefType CommentOn = new CommentsCorrectionsTypeRefType(_CommentOn);
    public static final CommentsCorrectionsTypeRefType CommentIn = new CommentsCorrectionsTypeRefType(_CommentIn);
    public static final CommentsCorrectionsTypeRefType ErratumIn = new CommentsCorrectionsTypeRefType(_ErratumIn);
    public static final CommentsCorrectionsTypeRefType ErratumFor = new CommentsCorrectionsTypeRefType(_ErratumFor);
    public static final CommentsCorrectionsTypeRefType PartialRetractionIn = new CommentsCorrectionsTypeRefType(_PartialRetractionIn);
    public static final CommentsCorrectionsTypeRefType PartialRetractionOf = new CommentsCorrectionsTypeRefType(_PartialRetractionOf);
    public static final CommentsCorrectionsTypeRefType RepublishedFrom = new CommentsCorrectionsTypeRefType(_RepublishedFrom);
    public static final CommentsCorrectionsTypeRefType RepublishedIn = new CommentsCorrectionsTypeRefType(_RepublishedIn);
    public static final CommentsCorrectionsTypeRefType RetractionOf = new CommentsCorrectionsTypeRefType(_RetractionOf);
    public static final CommentsCorrectionsTypeRefType RetractionIn = new CommentsCorrectionsTypeRefType(_RetractionIn);
    public static final CommentsCorrectionsTypeRefType UpdateIn = new CommentsCorrectionsTypeRefType(_UpdateIn);
    public static final CommentsCorrectionsTypeRefType UpdateOf = new CommentsCorrectionsTypeRefType(_UpdateOf);
    public static final CommentsCorrectionsTypeRefType SummaryForPatientsIn = new CommentsCorrectionsTypeRefType(_SummaryForPatientsIn);
    public static final CommentsCorrectionsTypeRefType OriginalReportIn = new CommentsCorrectionsTypeRefType(_OriginalReportIn);
    public static final CommentsCorrectionsTypeRefType ReprintOf = new CommentsCorrectionsTypeRefType(_ReprintOf);
    public static final CommentsCorrectionsTypeRefType ReprintIn = new CommentsCorrectionsTypeRefType(_ReprintIn);
    public static final CommentsCorrectionsTypeRefType Cites = new CommentsCorrectionsTypeRefType(_Cites);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static CommentsCorrectionsTypeRefType fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        CommentsCorrectionsTypeRefType enumeration = (CommentsCorrectionsTypeRefType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CommentsCorrectionsTypeRefType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CommentsCorrectionsTypeRefType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">CommentsCorrectionsType>RefType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
