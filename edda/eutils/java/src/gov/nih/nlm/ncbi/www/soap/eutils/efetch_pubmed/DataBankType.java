/**
 * DataBankType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class DataBankType  implements java.io.Serializable {
    private java.lang.String dataBankName;

    private java.lang.String[] accessionNumberList;

    public DataBankType() {
    }

    public DataBankType(
           java.lang.String dataBankName,
           java.lang.String[] accessionNumberList) {
           this.dataBankName = dataBankName;
           this.accessionNumberList = accessionNumberList;
    }


    /**
     * Gets the dataBankName value for this DataBankType.
     * 
     * @return dataBankName
     */
    public java.lang.String getDataBankName() {
        return dataBankName;
    }


    /**
     * Sets the dataBankName value for this DataBankType.
     * 
     * @param dataBankName
     */
    public void setDataBankName(java.lang.String dataBankName) {
        this.dataBankName = dataBankName;
    }


    /**
     * Gets the accessionNumberList value for this DataBankType.
     * 
     * @return accessionNumberList
     */
    public java.lang.String[] getAccessionNumberList() {
        return accessionNumberList;
    }


    /**
     * Sets the accessionNumberList value for this DataBankType.
     * 
     * @param accessionNumberList
     */
    public void setAccessionNumberList(java.lang.String[] accessionNumberList) {
        this.accessionNumberList = accessionNumberList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataBankType)) return false;
        DataBankType other = (DataBankType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataBankName==null && other.getDataBankName()==null) || 
             (this.dataBankName!=null &&
              this.dataBankName.equals(other.getDataBankName()))) &&
            ((this.accessionNumberList==null && other.getAccessionNumberList()==null) || 
             (this.accessionNumberList!=null &&
              java.util.Arrays.equals(this.accessionNumberList, other.getAccessionNumberList())));
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
        if (getDataBankName() != null) {
            _hashCode += getDataBankName().hashCode();
        }
        if (getAccessionNumberList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccessionNumberList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccessionNumberList(), i);
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
        new org.apache.axis.description.TypeDesc(DataBankType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DataBankType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataBankName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DataBankName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessionNumberList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AccessionNumberList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AccessionNumber"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
