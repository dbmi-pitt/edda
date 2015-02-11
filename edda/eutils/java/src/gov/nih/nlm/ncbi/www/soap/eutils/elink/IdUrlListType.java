/**
 * IdUrlListType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.elink;

public class IdUrlListType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlSetType[] idUrlSet;

    private java.lang.String[][] firstChars;

    public IdUrlListType() {
    }

    public IdUrlListType(
           gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlSetType[] idUrlSet,
           java.lang.String[][] firstChars) {
           this.idUrlSet = idUrlSet;
           this.firstChars = firstChars;
    }


    /**
     * Gets the idUrlSet value for this IdUrlListType.
     * 
     * @return idUrlSet
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlSetType[] getIdUrlSet() {
        return idUrlSet;
    }


    /**
     * Sets the idUrlSet value for this IdUrlListType.
     * 
     * @param idUrlSet
     */
    public void setIdUrlSet(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlSetType[] idUrlSet) {
        this.idUrlSet = idUrlSet;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlSetType getIdUrlSet(int i) {
        return this.idUrlSet[i];
    }

    public void setIdUrlSet(int i, gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlSetType _value) {
        this.idUrlSet[i] = _value;
    }


    /**
     * Gets the firstChars value for this IdUrlListType.
     * 
     * @return firstChars
     */
    public java.lang.String[][] getFirstChars() {
        return firstChars;
    }


    /**
     * Sets the firstChars value for this IdUrlListType.
     * 
     * @param firstChars
     */
    public void setFirstChars(java.lang.String[][] firstChars) {
        this.firstChars = firstChars;
    }

    public java.lang.String[] getFirstChars(int i) {
        return this.firstChars[i];
    }

    public void setFirstChars(int i, java.lang.String[] _value) {
        this.firstChars[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdUrlListType)) return false;
        IdUrlListType other = (IdUrlListType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idUrlSet==null && other.getIdUrlSet()==null) || 
             (this.idUrlSet!=null &&
              java.util.Arrays.equals(this.idUrlSet, other.getIdUrlSet()))) &&
            ((this.firstChars==null && other.getFirstChars()==null) || 
             (this.firstChars!=null &&
              java.util.Arrays.equals(this.firstChars, other.getFirstChars())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIdUrlSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdUrlSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdUrlSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFirstChars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFirstChars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFirstChars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdUrlListType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdUrlListType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUrlSet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdUrlSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdUrlSetType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstChars");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "FirstChars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "FirstCharsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
