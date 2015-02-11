/**
 * JournalType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class JournalType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ISSNType ISSN;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalIssueType journalIssue;

    private java.lang.String title;

    private java.lang.String ISOAbbreviation;

    public JournalType() {
    }

    public JournalType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ISSNType ISSN,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalIssueType journalIssue,
           java.lang.String title,
           java.lang.String ISOAbbreviation) {
           this.ISSN = ISSN;
           this.journalIssue = journalIssue;
           this.title = title;
           this.ISOAbbreviation = ISOAbbreviation;
    }


    /**
     * Gets the ISSN value for this JournalType.
     * 
     * @return ISSN
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ISSNType getISSN() {
        return ISSN;
    }


    /**
     * Sets the ISSN value for this JournalType.
     * 
     * @param ISSN
     */
    public void setISSN(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ISSNType ISSN) {
        this.ISSN = ISSN;
    }


    /**
     * Gets the journalIssue value for this JournalType.
     * 
     * @return journalIssue
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalIssueType getJournalIssue() {
        return journalIssue;
    }


    /**
     * Sets the journalIssue value for this JournalType.
     * 
     * @param journalIssue
     */
    public void setJournalIssue(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalIssueType journalIssue) {
        this.journalIssue = journalIssue;
    }


    /**
     * Gets the title value for this JournalType.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this JournalType.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the ISOAbbreviation value for this JournalType.
     * 
     * @return ISOAbbreviation
     */
    public java.lang.String getISOAbbreviation() {
        return ISOAbbreviation;
    }


    /**
     * Sets the ISOAbbreviation value for this JournalType.
     * 
     * @param ISOAbbreviation
     */
    public void setISOAbbreviation(java.lang.String ISOAbbreviation) {
        this.ISOAbbreviation = ISOAbbreviation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JournalType)) return false;
        JournalType other = (JournalType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ISSN==null && other.getISSN()==null) || 
             (this.ISSN!=null &&
              this.ISSN.equals(other.getISSN()))) &&
            ((this.journalIssue==null && other.getJournalIssue()==null) || 
             (this.journalIssue!=null &&
              this.journalIssue.equals(other.getJournalIssue()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.ISOAbbreviation==null && other.getISOAbbreviation()==null) || 
             (this.ISOAbbreviation!=null &&
              this.ISOAbbreviation.equals(other.getISOAbbreviation())));
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
        if (getISSN() != null) {
            _hashCode += getISSN().hashCode();
        }
        if (getJournalIssue() != null) {
            _hashCode += getJournalIssue().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getISOAbbreviation() != null) {
            _hashCode += getISOAbbreviation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JournalType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "JournalType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ISSN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ISSN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ISSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("journalIssue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "JournalIssue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "JournalIssueType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ISOAbbreviation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ISOAbbreviation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
