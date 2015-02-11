/**
 * EFetchResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class EFetchResult  implements java.io.Serializable {
    private java.lang.String ERROR;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Article[] pmcArticleset;

    private java.lang.String[] idList;

    public EFetchResult() {
    }

    public EFetchResult(
           java.lang.String ERROR,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Article[] pmcArticleset,
           java.lang.String[] idList) {
           this.ERROR = ERROR;
           this.pmcArticleset = pmcArticleset;
           this.idList = idList;
    }


    /**
     * Gets the ERROR value for this EFetchResult.
     * 
     * @return ERROR
     */
    public java.lang.String getERROR() {
        return ERROR;
    }


    /**
     * Sets the ERROR value for this EFetchResult.
     * 
     * @param ERROR
     */
    public void setERROR(java.lang.String ERROR) {
        this.ERROR = ERROR;
    }


    /**
     * Gets the pmcArticleset value for this EFetchResult.
     * 
     * @return pmcArticleset
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Article[] getPmcArticleset() {
        return pmcArticleset;
    }


    /**
     * Sets the pmcArticleset value for this EFetchResult.
     * 
     * @param pmcArticleset
     */
    public void setPmcArticleset(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Article[] pmcArticleset) {
        this.pmcArticleset = pmcArticleset;
    }


    /**
     * Gets the idList value for this EFetchResult.
     * 
     * @return idList
     */
    public java.lang.String[] getIdList() {
        return idList;
    }


    /**
     * Sets the idList value for this EFetchResult.
     * 
     * @param idList
     */
    public void setIdList(java.lang.String[] idList) {
        this.idList = idList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EFetchResult)) return false;
        EFetchResult other = (EFetchResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ERROR==null && other.getERROR()==null) || 
             (this.ERROR!=null &&
              this.ERROR.equals(other.getERROR()))) &&
            ((this.pmcArticleset==null && other.getPmcArticleset()==null) || 
             (this.pmcArticleset!=null &&
              java.util.Arrays.equals(this.pmcArticleset, other.getPmcArticleset()))) &&
            ((this.idList==null && other.getIdList()==null) || 
             (this.idList!=null &&
              java.util.Arrays.equals(this.idList, other.getIdList())));
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
        if (getERROR() != null) {
            _hashCode += getERROR().hashCode();
        }
        if (getPmcArticleset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPmcArticleset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPmcArticleset(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdList(), i);
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
        new org.apache.axis.description.TypeDesc(EFetchResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">eFetchResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "ERROR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pmcArticleset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "pmc-articleset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "IdList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "Id"));
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
