/**
 * AbstractTextTypeNlmCategory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class AbstractTextTypeNlmCategory implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AbstractTextTypeNlmCategory(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _UNLABELLED = new org.apache.axis.types.NMToken("UNLABELLED");
    public static final org.apache.axis.types.NMToken _BACKGROUND = new org.apache.axis.types.NMToken("BACKGROUND");
    public static final org.apache.axis.types.NMToken _OBJECTIVE = new org.apache.axis.types.NMToken("OBJECTIVE");
    public static final org.apache.axis.types.NMToken _METHODS = new org.apache.axis.types.NMToken("METHODS");
    public static final org.apache.axis.types.NMToken _RESULTS = new org.apache.axis.types.NMToken("RESULTS");
    public static final org.apache.axis.types.NMToken _CONCLUSIONS = new org.apache.axis.types.NMToken("CONCLUSIONS");
    public static final org.apache.axis.types.NMToken _UNASSIGNED = new org.apache.axis.types.NMToken("UNASSIGNED");
    public static final AbstractTextTypeNlmCategory UNLABELLED = new AbstractTextTypeNlmCategory(_UNLABELLED);
    public static final AbstractTextTypeNlmCategory BACKGROUND = new AbstractTextTypeNlmCategory(_BACKGROUND);
    public static final AbstractTextTypeNlmCategory OBJECTIVE = new AbstractTextTypeNlmCategory(_OBJECTIVE);
    public static final AbstractTextTypeNlmCategory METHODS = new AbstractTextTypeNlmCategory(_METHODS);
    public static final AbstractTextTypeNlmCategory RESULTS = new AbstractTextTypeNlmCategory(_RESULTS);
    public static final AbstractTextTypeNlmCategory CONCLUSIONS = new AbstractTextTypeNlmCategory(_CONCLUSIONS);
    public static final AbstractTextTypeNlmCategory UNASSIGNED = new AbstractTextTypeNlmCategory(_UNASSIGNED);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static AbstractTextTypeNlmCategory fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        AbstractTextTypeNlmCategory enumeration = (AbstractTextTypeNlmCategory)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AbstractTextTypeNlmCategory fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AbstractTextTypeNlmCategory.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">AbstractTextType>NlmCategory"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
