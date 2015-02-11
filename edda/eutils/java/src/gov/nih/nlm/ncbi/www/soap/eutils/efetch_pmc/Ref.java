/**
 * Ref.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class Ref  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Citation citation;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NlmCitation nlmCitation;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Note note;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private java.lang.String id;  // attribute

    private java.lang.Object contentType;  // attribute

    public Ref() {
    }

    public Ref(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Citation citation,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NlmCitation nlmCitation,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Note note,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           java.lang.String id,
           java.lang.Object contentType) {
           this.label = label;
           this.citation = citation;
           this.nlmCitation = nlmCitation;
           this.note = note;
           this.x = x;
           this.id = id;
           this.contentType = contentType;
    }


    /**
     * Gets the label value for this Ref.
     * 
     * @return label
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label getLabel() {
        return label;
    }


    /**
     * Sets the label value for this Ref.
     * 
     * @param label
     */
    public void setLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label) {
        this.label = label;
    }


    /**
     * Gets the citation value for this Ref.
     * 
     * @return citation
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Citation getCitation() {
        return citation;
    }


    /**
     * Sets the citation value for this Ref.
     * 
     * @param citation
     */
    public void setCitation(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Citation citation) {
        this.citation = citation;
    }


    /**
     * Gets the nlmCitation value for this Ref.
     * 
     * @return nlmCitation
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NlmCitation getNlmCitation() {
        return nlmCitation;
    }


    /**
     * Sets the nlmCitation value for this Ref.
     * 
     * @param nlmCitation
     */
    public void setNlmCitation(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NlmCitation nlmCitation) {
        this.nlmCitation = nlmCitation;
    }


    /**
     * Gets the note value for this Ref.
     * 
     * @return note
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Note getNote() {
        return note;
    }


    /**
     * Sets the note value for this Ref.
     * 
     * @param note
     */
    public void setNote(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Note note) {
        this.note = note;
    }


    /**
     * Gets the x value for this Ref.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this Ref.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the id value for this Ref.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Ref.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the contentType value for this Ref.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this Ref.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ref)) return false;
        Ref other = (Ref) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.citation==null && other.getCitation()==null) || 
             (this.citation!=null &&
              this.citation.equals(other.getCitation()))) &&
            ((this.nlmCitation==null && other.getNlmCitation()==null) || 
             (this.nlmCitation!=null &&
              this.nlmCitation.equals(other.getNlmCitation()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.contentType==null && other.getContentType()==null) || 
             (this.contentType!=null &&
              this.contentType.equals(other.getContentType())));
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
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getCitation() != null) {
            _hashCode += getCitation().hashCode();
        }
        if (getNlmCitation() != null) {
            _hashCode += getNlmCitation().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ref.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ref"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">label"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "citation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">citation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nlmCitation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "nlm-citation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">nlm-citation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">note"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "x"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">x"));
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
