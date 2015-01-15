/**
 * IconUrlTypeLNG.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.elink;

public class IconUrlTypeLNG implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected IconUrlTypeLNG(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _DA = new org.apache.axis.types.NMToken("DA");
    public static final org.apache.axis.types.NMToken _DE = new org.apache.axis.types.NMToken("DE");
    public static final org.apache.axis.types.NMToken _EN = new org.apache.axis.types.NMToken("EN");
    public static final org.apache.axis.types.NMToken _EL = new org.apache.axis.types.NMToken("EL");
    public static final org.apache.axis.types.NMToken _ES = new org.apache.axis.types.NMToken("ES");
    public static final org.apache.axis.types.NMToken _FR = new org.apache.axis.types.NMToken("FR");
    public static final org.apache.axis.types.NMToken _IT = new org.apache.axis.types.NMToken("IT");
    public static final org.apache.axis.types.NMToken _IW = new org.apache.axis.types.NMToken("IW");
    public static final org.apache.axis.types.NMToken _JA = new org.apache.axis.types.NMToken("JA");
    public static final org.apache.axis.types.NMToken _NL = new org.apache.axis.types.NMToken("NL");
    public static final org.apache.axis.types.NMToken _NO = new org.apache.axis.types.NMToken("NO");
    public static final org.apache.axis.types.NMToken _RU = new org.apache.axis.types.NMToken("RU");
    public static final org.apache.axis.types.NMToken _SV = new org.apache.axis.types.NMToken("SV");
    public static final org.apache.axis.types.NMToken _ZH = new org.apache.axis.types.NMToken("ZH");
    public static final IconUrlTypeLNG DA = new IconUrlTypeLNG(_DA);
    public static final IconUrlTypeLNG DE = new IconUrlTypeLNG(_DE);
    public static final IconUrlTypeLNG EN = new IconUrlTypeLNG(_EN);
    public static final IconUrlTypeLNG EL = new IconUrlTypeLNG(_EL);
    public static final IconUrlTypeLNG ES = new IconUrlTypeLNG(_ES);
    public static final IconUrlTypeLNG FR = new IconUrlTypeLNG(_FR);
    public static final IconUrlTypeLNG IT = new IconUrlTypeLNG(_IT);
    public static final IconUrlTypeLNG IW = new IconUrlTypeLNG(_IW);
    public static final IconUrlTypeLNG JA = new IconUrlTypeLNG(_JA);
    public static final IconUrlTypeLNG NL = new IconUrlTypeLNG(_NL);
    public static final IconUrlTypeLNG NO = new IconUrlTypeLNG(_NO);
    public static final IconUrlTypeLNG RU = new IconUrlTypeLNG(_RU);
    public static final IconUrlTypeLNG SV = new IconUrlTypeLNG(_SV);
    public static final IconUrlTypeLNG ZH = new IconUrlTypeLNG(_ZH);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static IconUrlTypeLNG fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        IconUrlTypeLNG enumeration = (IconUrlTypeLNG)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static IconUrlTypeLNG fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(IconUrlTypeLNG.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", ">IconUrlType>LNG"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
