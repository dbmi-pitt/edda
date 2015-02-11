/**
 * LocationLabelTypeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class LocationLabelTypeType implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected LocationLabelTypeType(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _part = new org.apache.axis.types.NMToken("part");
    public static final org.apache.axis.types.NMToken _chapter = new org.apache.axis.types.NMToken("chapter");
    public static final org.apache.axis.types.NMToken _section = new org.apache.axis.types.NMToken("section");
    public static final org.apache.axis.types.NMToken _appendix = new org.apache.axis.types.NMToken("appendix");
    public static final org.apache.axis.types.NMToken _figure = new org.apache.axis.types.NMToken("figure");
    public static final org.apache.axis.types.NMToken _table = new org.apache.axis.types.NMToken("table");
    public static final org.apache.axis.types.NMToken _box = new org.apache.axis.types.NMToken("box");
    public static final LocationLabelTypeType part = new LocationLabelTypeType(_part);
    public static final LocationLabelTypeType chapter = new LocationLabelTypeType(_chapter);
    public static final LocationLabelTypeType section = new LocationLabelTypeType(_section);
    public static final LocationLabelTypeType appendix = new LocationLabelTypeType(_appendix);
    public static final LocationLabelTypeType figure = new LocationLabelTypeType(_figure);
    public static final LocationLabelTypeType table = new LocationLabelTypeType(_table);
    public static final LocationLabelTypeType box = new LocationLabelTypeType(_box);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static LocationLabelTypeType fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        LocationLabelTypeType enumeration = (LocationLabelTypeType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static LocationLabelTypeType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(LocationLabelTypeType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">LocationLabelType>Type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
