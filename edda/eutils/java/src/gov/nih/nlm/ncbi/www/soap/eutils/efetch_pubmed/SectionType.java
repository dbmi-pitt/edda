/**
 * SectionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class SectionType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType locationLabel;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionTitleType sectionTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] section;

    public SectionType() {
    }

    public SectionType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType locationLabel,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionTitleType sectionTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] section) {
           this.locationLabel = locationLabel;
           this.sectionTitle = sectionTitle;
           this.section = section;
    }


    /**
     * Gets the locationLabel value for this SectionType.
     * 
     * @return locationLabel
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType getLocationLabel() {
        return locationLabel;
    }


    /**
     * Sets the locationLabel value for this SectionType.
     * 
     * @param locationLabel
     */
    public void setLocationLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType locationLabel) {
        this.locationLabel = locationLabel;
    }


    /**
     * Gets the sectionTitle value for this SectionType.
     * 
     * @return sectionTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionTitleType getSectionTitle() {
        return sectionTitle;
    }


    /**
     * Sets the sectionTitle value for this SectionType.
     * 
     * @param sectionTitle
     */
    public void setSectionTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionTitleType sectionTitle) {
        this.sectionTitle = sectionTitle;
    }


    /**
     * Gets the section value for this SectionType.
     * 
     * @return section
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] getSection() {
        return section;
    }


    /**
     * Sets the section value for this SectionType.
     * 
     * @param section
     */
    public void setSection(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] section) {
        this.section = section;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType getSection(int i) {
        return this.section[i];
    }

    public void setSection(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType _value) {
        this.section[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SectionType)) return false;
        SectionType other = (SectionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.locationLabel==null && other.getLocationLabel()==null) || 
             (this.locationLabel!=null &&
              this.locationLabel.equals(other.getLocationLabel()))) &&
            ((this.sectionTitle==null && other.getSectionTitle()==null) || 
             (this.sectionTitle!=null &&
              this.sectionTitle.equals(other.getSectionTitle()))) &&
            ((this.section==null && other.getSection()==null) || 
             (this.section!=null &&
              java.util.Arrays.equals(this.section, other.getSection())));
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
        if (getLocationLabel() != null) {
            _hashCode += getLocationLabel().hashCode();
        }
        if (getSectionTitle() != null) {
            _hashCode += getSectionTitle().hashCode();
        }
        if (getSection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSection(), i);
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
        new org.apache.axis.description.TypeDesc(SectionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SectionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locationLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "LocationLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "LocationLabelType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sectionTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SectionTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SectionTitleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("section");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Section"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SectionType"));
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
