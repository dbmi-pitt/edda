/**
 * PubmedBookArticleType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class PubmedBookArticleType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookDocumentType bookDocument;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookDataType pubmedBookData;

    public PubmedBookArticleType() {
    }

    public PubmedBookArticleType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookDocumentType bookDocument,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookDataType pubmedBookData) {
           this.bookDocument = bookDocument;
           this.pubmedBookData = pubmedBookData;
    }


    /**
     * Gets the bookDocument value for this PubmedBookArticleType.
     * 
     * @return bookDocument
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookDocumentType getBookDocument() {
        return bookDocument;
    }


    /**
     * Sets the bookDocument value for this PubmedBookArticleType.
     * 
     * @param bookDocument
     */
    public void setBookDocument(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookDocumentType bookDocument) {
        this.bookDocument = bookDocument;
    }


    /**
     * Gets the pubmedBookData value for this PubmedBookArticleType.
     * 
     * @return pubmedBookData
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookDataType getPubmedBookData() {
        return pubmedBookData;
    }


    /**
     * Sets the pubmedBookData value for this PubmedBookArticleType.
     * 
     * @param pubmedBookData
     */
    public void setPubmedBookData(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubmedBookDataType pubmedBookData) {
        this.pubmedBookData = pubmedBookData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PubmedBookArticleType)) return false;
        PubmedBookArticleType other = (PubmedBookArticleType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bookDocument==null && other.getBookDocument()==null) || 
             (this.bookDocument!=null &&
              this.bookDocument.equals(other.getBookDocument()))) &&
            ((this.pubmedBookData==null && other.getPubmedBookData()==null) || 
             (this.pubmedBookData!=null &&
              this.pubmedBookData.equals(other.getPubmedBookData())));
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
        if (getBookDocument() != null) {
            _hashCode += getBookDocument().hashCode();
        }
        if (getPubmedBookData() != null) {
            _hashCode += getPubmedBookData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PubmedBookArticleType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubmedBookArticleType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookDocument");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BookDocument"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BookDocumentType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubmedBookData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubmedBookData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubmedBookDataType"));
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
