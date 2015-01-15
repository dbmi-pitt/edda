/**
 * CommentsCorrectionsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class CommentsCorrectionsType  implements java.io.Serializable {
    private java.lang.String refSource;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID;

    private java.lang.String note;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsTypeRefType refType;  // attribute

    public CommentsCorrectionsType() {
    }

    public CommentsCorrectionsType(
           java.lang.String refSource,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID,
           java.lang.String note,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsTypeRefType refType) {
           this.refSource = refSource;
           this.PMID = PMID;
           this.note = note;
           this.refType = refType;
    }


    /**
     * Gets the refSource value for this CommentsCorrectionsType.
     * 
     * @return refSource
     */
    public java.lang.String getRefSource() {
        return refSource;
    }


    /**
     * Sets the refSource value for this CommentsCorrectionsType.
     * 
     * @param refSource
     */
    public void setRefSource(java.lang.String refSource) {
        this.refSource = refSource;
    }


    /**
     * Gets the PMID value for this CommentsCorrectionsType.
     * 
     * @return PMID
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType getPMID() {
        return PMID;
    }


    /**
     * Sets the PMID value for this CommentsCorrectionsType.
     * 
     * @param PMID
     */
    public void setPMID(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID) {
        this.PMID = PMID;
    }


    /**
     * Gets the note value for this CommentsCorrectionsType.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this CommentsCorrectionsType.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the refType value for this CommentsCorrectionsType.
     * 
     * @return refType
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsTypeRefType getRefType() {
        return refType;
    }


    /**
     * Sets the refType value for this CommentsCorrectionsType.
     * 
     * @param refType
     */
    public void setRefType(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsTypeRefType refType) {
        this.refType = refType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommentsCorrectionsType)) return false;
        CommentsCorrectionsType other = (CommentsCorrectionsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.refSource==null && other.getRefSource()==null) || 
             (this.refSource!=null &&
              this.refSource.equals(other.getRefSource()))) &&
            ((this.PMID==null && other.getPMID()==null) || 
             (this.PMID!=null &&
              this.PMID.equals(other.getPMID()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.refType==null && other.getRefType()==null) || 
             (this.refType!=null &&
              this.refType.equals(other.getRefType())));
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
        if (getRefSource() != null) {
            _hashCode += getRefSource().hashCode();
        }
        if (getPMID() != null) {
            _hashCode += getPMID().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getRefType() != null) {
            _hashCode += getRefType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommentsCorrectionsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CommentsCorrectionsType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("refType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "RefType"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">CommentsCorrectionsType>RefType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "RefSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PMID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PMID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PMIDType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Note"));
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
