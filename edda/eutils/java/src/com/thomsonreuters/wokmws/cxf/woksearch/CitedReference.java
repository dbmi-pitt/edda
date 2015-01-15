/**
 * CitedReference.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearch;

public class CitedReference  implements java.io.Serializable {
    private java.lang.String articleID;

    private java.lang.String citedAuthor;

    private java.lang.String citedTitle;

    private java.lang.String citedWork;

    private java.lang.String page;

    private java.lang.String recID;

    private java.lang.String refID;

    private java.lang.String timesCited;

    private java.lang.String volume;

    private java.lang.String year;

    public CitedReference() {
    }

    public CitedReference(
           java.lang.String articleID,
           java.lang.String citedAuthor,
           java.lang.String citedTitle,
           java.lang.String citedWork,
           java.lang.String page,
           java.lang.String recID,
           java.lang.String refID,
           java.lang.String timesCited,
           java.lang.String volume,
           java.lang.String year) {
           this.articleID = articleID;
           this.citedAuthor = citedAuthor;
           this.citedTitle = citedTitle;
           this.citedWork = citedWork;
           this.page = page;
           this.recID = recID;
           this.refID = refID;
           this.timesCited = timesCited;
           this.volume = volume;
           this.year = year;
    }


    /**
     * Gets the articleID value for this CitedReference.
     * 
     * @return articleID
     */
    public java.lang.String getArticleID() {
        return articleID;
    }


    /**
     * Sets the articleID value for this CitedReference.
     * 
     * @param articleID
     */
    public void setArticleID(java.lang.String articleID) {
        this.articleID = articleID;
    }


    /**
     * Gets the citedAuthor value for this CitedReference.
     * 
     * @return citedAuthor
     */
    public java.lang.String getCitedAuthor() {
        return citedAuthor;
    }


    /**
     * Sets the citedAuthor value for this CitedReference.
     * 
     * @param citedAuthor
     */
    public void setCitedAuthor(java.lang.String citedAuthor) {
        this.citedAuthor = citedAuthor;
    }


    /**
     * Gets the citedTitle value for this CitedReference.
     * 
     * @return citedTitle
     */
    public java.lang.String getCitedTitle() {
        return citedTitle;
    }


    /**
     * Sets the citedTitle value for this CitedReference.
     * 
     * @param citedTitle
     */
    public void setCitedTitle(java.lang.String citedTitle) {
        this.citedTitle = citedTitle;
    }


    /**
     * Gets the citedWork value for this CitedReference.
     * 
     * @return citedWork
     */
    public java.lang.String getCitedWork() {
        return citedWork;
    }


    /**
     * Sets the citedWork value for this CitedReference.
     * 
     * @param citedWork
     */
    public void setCitedWork(java.lang.String citedWork) {
        this.citedWork = citedWork;
    }


    /**
     * Gets the page value for this CitedReference.
     * 
     * @return page
     */
    public java.lang.String getPage() {
        return page;
    }


    /**
     * Sets the page value for this CitedReference.
     * 
     * @param page
     */
    public void setPage(java.lang.String page) {
        this.page = page;
    }


    /**
     * Gets the recID value for this CitedReference.
     * 
     * @return recID
     */
    public java.lang.String getRecID() {
        return recID;
    }


    /**
     * Sets the recID value for this CitedReference.
     * 
     * @param recID
     */
    public void setRecID(java.lang.String recID) {
        this.recID = recID;
    }


    /**
     * Gets the refID value for this CitedReference.
     * 
     * @return refID
     */
    public java.lang.String getRefID() {
        return refID;
    }


    /**
     * Sets the refID value for this CitedReference.
     * 
     * @param refID
     */
    public void setRefID(java.lang.String refID) {
        this.refID = refID;
    }


    /**
     * Gets the timesCited value for this CitedReference.
     * 
     * @return timesCited
     */
    public java.lang.String getTimesCited() {
        return timesCited;
    }


    /**
     * Sets the timesCited value for this CitedReference.
     * 
     * @param timesCited
     */
    public void setTimesCited(java.lang.String timesCited) {
        this.timesCited = timesCited;
    }


    /**
     * Gets the volume value for this CitedReference.
     * 
     * @return volume
     */
    public java.lang.String getVolume() {
        return volume;
    }


    /**
     * Sets the volume value for this CitedReference.
     * 
     * @param volume
     */
    public void setVolume(java.lang.String volume) {
        this.volume = volume;
    }


    /**
     * Gets the year value for this CitedReference.
     * 
     * @return year
     */
    public java.lang.String getYear() {
        return year;
    }


    /**
     * Sets the year value for this CitedReference.
     * 
     * @param year
     */
    public void setYear(java.lang.String year) {
        this.year = year;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CitedReference)) return false;
        CitedReference other = (CitedReference) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.articleID==null && other.getArticleID()==null) || 
             (this.articleID!=null &&
              this.articleID.equals(other.getArticleID()))) &&
            ((this.citedAuthor==null && other.getCitedAuthor()==null) || 
             (this.citedAuthor!=null &&
              this.citedAuthor.equals(other.getCitedAuthor()))) &&
            ((this.citedTitle==null && other.getCitedTitle()==null) || 
             (this.citedTitle!=null &&
              this.citedTitle.equals(other.getCitedTitle()))) &&
            ((this.citedWork==null && other.getCitedWork()==null) || 
             (this.citedWork!=null &&
              this.citedWork.equals(other.getCitedWork()))) &&
            ((this.page==null && other.getPage()==null) || 
             (this.page!=null &&
              this.page.equals(other.getPage()))) &&
            ((this.recID==null && other.getRecID()==null) || 
             (this.recID!=null &&
              this.recID.equals(other.getRecID()))) &&
            ((this.refID==null && other.getRefID()==null) || 
             (this.refID!=null &&
              this.refID.equals(other.getRefID()))) &&
            ((this.timesCited==null && other.getTimesCited()==null) || 
             (this.timesCited!=null &&
              this.timesCited.equals(other.getTimesCited()))) &&
            ((this.volume==null && other.getVolume()==null) || 
             (this.volume!=null &&
              this.volume.equals(other.getVolume()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear())));
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
        if (getArticleID() != null) {
            _hashCode += getArticleID().hashCode();
        }
        if (getCitedAuthor() != null) {
            _hashCode += getCitedAuthor().hashCode();
        }
        if (getCitedTitle() != null) {
            _hashCode += getCitedTitle().hashCode();
        }
        if (getCitedWork() != null) {
            _hashCode += getCitedWork().hashCode();
        }
        if (getPage() != null) {
            _hashCode += getPage().hashCode();
        }
        if (getRecID() != null) {
            _hashCode += getRecID().hashCode();
        }
        if (getRefID() != null) {
            _hashCode += getRefID().hashCode();
        }
        if (getTimesCited() != null) {
            _hashCode += getTimesCited().hashCode();
        }
        if (getVolume() != null) {
            _hashCode += getVolume().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CitedReference.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearch.cxf.wokmws.thomsonreuters.com", "citedReference"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "articleID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citedAuthor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "citedAuthor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citedTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "citedTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citedWork");
        elemField.setXmlName(new javax.xml.namespace.QName("", "citedWork"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("page");
        elemField.setXmlName(new javax.xml.namespace.QName("", "page"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "refID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timesCited");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timesCited"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volume");
        elemField.setXmlName(new javax.xml.namespace.QName("", "volume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("", "year"));
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
