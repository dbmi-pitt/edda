/**
 * PubmedArticleSet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class PubmedArticleSet  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedArticleType pubmedArticle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookArticleType pubmedBookArticle;

    public PubmedArticleSet() {
    }

    public PubmedArticleSet(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedArticleType pubmedArticle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookArticleType pubmedBookArticle) {
           this.pubmedArticle = pubmedArticle;
           this.pubmedBookArticle = pubmedBookArticle;
    }


    /**
     * Gets the pubmedArticle value for this PubmedArticleSet.
     * 
     * @return pubmedArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedArticleType getPubmedArticle() {
        return pubmedArticle;
    }


    /**
     * Sets the pubmedArticle value for this PubmedArticleSet.
     * 
     * @param pubmedArticle
     */
    public void setPubmedArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedArticleType pubmedArticle) {
        this.pubmedArticle = pubmedArticle;
    }


    /**
     * Gets the pubmedBookArticle value for this PubmedArticleSet.
     * 
     * @return pubmedBookArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookArticleType getPubmedBookArticle() {
        return pubmedBookArticle;
    }


    /**
     * Sets the pubmedBookArticle value for this PubmedArticleSet.
     * 
     * @param pubmedBookArticle
     */
    public void setPubmedBookArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookArticleType pubmedBookArticle) {
        this.pubmedBookArticle = pubmedBookArticle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PubmedArticleSet)) return false;
        PubmedArticleSet other = (PubmedArticleSet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubmedArticle==null && other.getPubmedArticle()==null) || 
             (this.pubmedArticle!=null &&
              this.pubmedArticle.equals(other.getPubmedArticle()))) &&
            ((this.pubmedBookArticle==null && other.getPubmedBookArticle()==null) || 
             (this.pubmedBookArticle!=null &&
              this.pubmedBookArticle.equals(other.getPubmedBookArticle())));
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
        if (getPubmedArticle() != null) {
            _hashCode += getPubmedArticle().hashCode();
        }
        if (getPubmedBookArticle() != null) {
            _hashCode += getPubmedBookArticle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PubmedArticleSet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">PubmedArticleSet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubmedArticle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubmedArticle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubmedArticleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubmedBookArticle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubmedBookArticle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubmedBookArticleType"));
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
