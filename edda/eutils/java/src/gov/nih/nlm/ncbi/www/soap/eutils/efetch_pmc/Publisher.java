/**
 * Publisher.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class Publisher  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc;

    private java.lang.Object contentType;  // attribute

    public Publisher() {
    }

    public Publisher(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc,
           java.lang.Object contentType) {
           this.publisherName = publisherName;
           this.publisherLoc = publisherLoc;
           this.contentType = contentType;
    }


    /**
     * Gets the publisherName value for this Publisher.
     * 
     * @return publisherName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName getPublisherName() {
        return publisherName;
    }


    /**
     * Sets the publisherName value for this Publisher.
     * 
     * @param publisherName
     */
    public void setPublisherName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName) {
        this.publisherName = publisherName;
    }


    /**
     * Gets the publisherLoc value for this Publisher.
     * 
     * @return publisherLoc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc getPublisherLoc() {
        return publisherLoc;
    }


    /**
     * Sets the publisherLoc value for this Publisher.
     * 
     * @param publisherLoc
     */
    public void setPublisherLoc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc) {
        this.publisherLoc = publisherLoc;
    }


    /**
     * Gets the contentType value for this Publisher.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this Publisher.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Publisher)) return false;
        Publisher other = (Publisher) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.publisherName==null && other.getPublisherName()==null) || 
             (this.publisherName!=null &&
              this.publisherName.equals(other.getPublisherName()))) &&
            ((this.publisherLoc==null && other.getPublisherLoc()==null) || 
             (this.publisherLoc!=null &&
              this.publisherLoc.equals(other.getPublisherLoc()))) &&
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
        if (getPublisherName() != null) {
            _hashCode += getPublisherName().hashCode();
        }
        if (getPublisherLoc() != null) {
            _hashCode += getPublisherLoc().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Publisher.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "publisher-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher-name"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherLoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "publisher-loc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher-loc"));
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
