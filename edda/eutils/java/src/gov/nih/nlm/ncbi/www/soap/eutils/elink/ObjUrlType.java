/**
 * ObjUrlType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.elink;

public class ObjUrlType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType url;

    private gov.nih.nlm.ncbi.www.soap.eutils.elink.IconUrlType iconUrl;

    private java.lang.String linkName;

    private java.lang.String[] subjectType;

    private java.lang.String[] category;

    private java.lang.String[] attribute;

    private gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType provider;

    private java.lang.String subProvider;

    public ObjUrlType() {
    }

    public ObjUrlType(
           gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType url,
           gov.nih.nlm.ncbi.www.soap.eutils.elink.IconUrlType iconUrl,
           java.lang.String linkName,
           java.lang.String[] subjectType,
           java.lang.String[] category,
           java.lang.String[] attribute,
           gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType provider,
           java.lang.String subProvider) {
           this.url = url;
           this.iconUrl = iconUrl;
           this.linkName = linkName;
           this.subjectType = subjectType;
           this.category = category;
           this.attribute = attribute;
           this.provider = provider;
           this.subProvider = subProvider;
    }


    /**
     * Gets the url value for this ObjUrlType.
     * 
     * @return url
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType getUrl() {
        return url;
    }


    /**
     * Sets the url value for this ObjUrlType.
     * 
     * @param url
     */
    public void setUrl(gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType url) {
        this.url = url;
    }


    /**
     * Gets the iconUrl value for this ObjUrlType.
     * 
     * @return iconUrl
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.elink.IconUrlType getIconUrl() {
        return iconUrl;
    }


    /**
     * Sets the iconUrl value for this ObjUrlType.
     * 
     * @param iconUrl
     */
    public void setIconUrl(gov.nih.nlm.ncbi.www.soap.eutils.elink.IconUrlType iconUrl) {
        this.iconUrl = iconUrl;
    }


    /**
     * Gets the linkName value for this ObjUrlType.
     * 
     * @return linkName
     */
    public java.lang.String getLinkName() {
        return linkName;
    }


    /**
     * Sets the linkName value for this ObjUrlType.
     * 
     * @param linkName
     */
    public void setLinkName(java.lang.String linkName) {
        this.linkName = linkName;
    }


    /**
     * Gets the subjectType value for this ObjUrlType.
     * 
     * @return subjectType
     */
    public java.lang.String[] getSubjectType() {
        return subjectType;
    }


    /**
     * Sets the subjectType value for this ObjUrlType.
     * 
     * @param subjectType
     */
    public void setSubjectType(java.lang.String[] subjectType) {
        this.subjectType = subjectType;
    }

    public java.lang.String getSubjectType(int i) {
        return this.subjectType[i];
    }

    public void setSubjectType(int i, java.lang.String _value) {
        this.subjectType[i] = _value;
    }


    /**
     * Gets the category value for this ObjUrlType.
     * 
     * @return category
     */
    public java.lang.String[] getCategory() {
        return category;
    }


    /**
     * Sets the category value for this ObjUrlType.
     * 
     * @param category
     */
    public void setCategory(java.lang.String[] category) {
        this.category = category;
    }

    public java.lang.String getCategory(int i) {
        return this.category[i];
    }

    public void setCategory(int i, java.lang.String _value) {
        this.category[i] = _value;
    }


    /**
     * Gets the attribute value for this ObjUrlType.
     * 
     * @return attribute
     */
    public java.lang.String[] getAttribute() {
        return attribute;
    }


    /**
     * Sets the attribute value for this ObjUrlType.
     * 
     * @param attribute
     */
    public void setAttribute(java.lang.String[] attribute) {
        this.attribute = attribute;
    }

    public java.lang.String getAttribute(int i) {
        return this.attribute[i];
    }

    public void setAttribute(int i, java.lang.String _value) {
        this.attribute[i] = _value;
    }


    /**
     * Gets the provider value for this ObjUrlType.
     * 
     * @return provider
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType getProvider() {
        return provider;
    }


    /**
     * Sets the provider value for this ObjUrlType.
     * 
     * @param provider
     */
    public void setProvider(gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType provider) {
        this.provider = provider;
    }


    /**
     * Gets the subProvider value for this ObjUrlType.
     * 
     * @return subProvider
     */
    public java.lang.String getSubProvider() {
        return subProvider;
    }


    /**
     * Sets the subProvider value for this ObjUrlType.
     * 
     * @param subProvider
     */
    public void setSubProvider(java.lang.String subProvider) {
        this.subProvider = subProvider;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjUrlType)) return false;
        ObjUrlType other = (ObjUrlType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.iconUrl==null && other.getIconUrl()==null) || 
             (this.iconUrl!=null &&
              this.iconUrl.equals(other.getIconUrl()))) &&
            ((this.linkName==null && other.getLinkName()==null) || 
             (this.linkName!=null &&
              this.linkName.equals(other.getLinkName()))) &&
            ((this.subjectType==null && other.getSubjectType()==null) || 
             (this.subjectType!=null &&
              java.util.Arrays.equals(this.subjectType, other.getSubjectType()))) &&
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              java.util.Arrays.equals(this.category, other.getCategory()))) &&
            ((this.attribute==null && other.getAttribute()==null) || 
             (this.attribute!=null &&
              java.util.Arrays.equals(this.attribute, other.getAttribute()))) &&
            ((this.provider==null && other.getProvider()==null) || 
             (this.provider!=null &&
              this.provider.equals(other.getProvider()))) &&
            ((this.subProvider==null && other.getSubProvider()==null) || 
             (this.subProvider!=null &&
              this.subProvider.equals(other.getSubProvider())));
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
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getIconUrl() != null) {
            _hashCode += getIconUrl().hashCode();
        }
        if (getLinkName() != null) {
            _hashCode += getLinkName().hashCode();
        }
        if (getSubjectType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubjectType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubjectType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCategory() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategory());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategory(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAttribute() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttribute());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttribute(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProvider() != null) {
            _hashCode += getProvider().hashCode();
        }
        if (getSubProvider() != null) {
            _hashCode += getSubProvider().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObjUrlType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "ObjUrlType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "UrlType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iconUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IconUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IconUrlType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "SubjectType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "SubjectType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Category"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attribute");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Attribute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Attribute"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provider");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Provider"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "ProviderType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subProvider");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "SubProvider"));
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
