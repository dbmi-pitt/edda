/**
 * LinkInfoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.elink;

public class LinkInfoType  implements java.io.Serializable {
    private java.lang.String dbTo;

    private java.lang.String linkName;

    private java.lang.String menuTag;

    private java.lang.String htmlTag;

    private gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType url;

    private java.lang.String priority;

    public LinkInfoType() {
    }

    public LinkInfoType(
           java.lang.String dbTo,
           java.lang.String linkName,
           java.lang.String menuTag,
           java.lang.String htmlTag,
           gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType url,
           java.lang.String priority) {
           this.dbTo = dbTo;
           this.linkName = linkName;
           this.menuTag = menuTag;
           this.htmlTag = htmlTag;
           this.url = url;
           this.priority = priority;
    }


    /**
     * Gets the dbTo value for this LinkInfoType.
     * 
     * @return dbTo
     */
    public java.lang.String getDbTo() {
        return dbTo;
    }


    /**
     * Sets the dbTo value for this LinkInfoType.
     * 
     * @param dbTo
     */
    public void setDbTo(java.lang.String dbTo) {
        this.dbTo = dbTo;
    }


    /**
     * Gets the linkName value for this LinkInfoType.
     * 
     * @return linkName
     */
    public java.lang.String getLinkName() {
        return linkName;
    }


    /**
     * Sets the linkName value for this LinkInfoType.
     * 
     * @param linkName
     */
    public void setLinkName(java.lang.String linkName) {
        this.linkName = linkName;
    }


    /**
     * Gets the menuTag value for this LinkInfoType.
     * 
     * @return menuTag
     */
    public java.lang.String getMenuTag() {
        return menuTag;
    }


    /**
     * Sets the menuTag value for this LinkInfoType.
     * 
     * @param menuTag
     */
    public void setMenuTag(java.lang.String menuTag) {
        this.menuTag = menuTag;
    }


    /**
     * Gets the htmlTag value for this LinkInfoType.
     * 
     * @return htmlTag
     */
    public java.lang.String getHtmlTag() {
        return htmlTag;
    }


    /**
     * Sets the htmlTag value for this LinkInfoType.
     * 
     * @param htmlTag
     */
    public void setHtmlTag(java.lang.String htmlTag) {
        this.htmlTag = htmlTag;
    }


    /**
     * Gets the url value for this LinkInfoType.
     * 
     * @return url
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType getUrl() {
        return url;
    }


    /**
     * Sets the url value for this LinkInfoType.
     * 
     * @param url
     */
    public void setUrl(gov.nih.nlm.ncbi.www.soap.eutils.elink.UrlType url) {
        this.url = url;
    }


    /**
     * Gets the priority value for this LinkInfoType.
     * 
     * @return priority
     */
    public java.lang.String getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this LinkInfoType.
     * 
     * @param priority
     */
    public void setPriority(java.lang.String priority) {
        this.priority = priority;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LinkInfoType)) return false;
        LinkInfoType other = (LinkInfoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dbTo==null && other.getDbTo()==null) || 
             (this.dbTo!=null &&
              this.dbTo.equals(other.getDbTo()))) &&
            ((this.linkName==null && other.getLinkName()==null) || 
             (this.linkName!=null &&
              this.linkName.equals(other.getLinkName()))) &&
            ((this.menuTag==null && other.getMenuTag()==null) || 
             (this.menuTag!=null &&
              this.menuTag.equals(other.getMenuTag()))) &&
            ((this.htmlTag==null && other.getHtmlTag()==null) || 
             (this.htmlTag!=null &&
              this.htmlTag.equals(other.getHtmlTag()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority())));
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
        if (getDbTo() != null) {
            _hashCode += getDbTo().hashCode();
        }
        if (getLinkName() != null) {
            _hashCode += getLinkName().hashCode();
        }
        if (getMenuTag() != null) {
            _hashCode += getMenuTag().hashCode();
        }
        if (getHtmlTag() != null) {
            _hashCode += getHtmlTag().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LinkInfoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkInfoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "DbTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("menuTag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "MenuTag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("htmlTag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "HtmlTag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "UrlType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
