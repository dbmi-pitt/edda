/**
 * AccessDate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class AccessDate  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private java.lang.Object contentType;  // attribute

    public AccessDate() {
    }

    public AccessDate(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           org.apache.axis.message.MessageElement [] _any,
           java.lang.Object contentType) {
           this.day = day;
           this.month = month;
           this.season = season;
           this.year = year;
           this.x = x;
           this._any = _any;
           this.contentType = contentType;
    }


    /**
     * Gets the day value for this AccessDate.
     * 
     * @return day
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day getDay() {
        return day;
    }


    /**
     * Sets the day value for this AccessDate.
     * 
     * @param day
     */
    public void setDay(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day) {
        this.day = day;
    }


    /**
     * Gets the month value for this AccessDate.
     * 
     * @return month
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month getMonth() {
        return month;
    }


    /**
     * Sets the month value for this AccessDate.
     * 
     * @param month
     */
    public void setMonth(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month) {
        this.month = month;
    }


    /**
     * Gets the season value for this AccessDate.
     * 
     * @return season
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season getSeason() {
        return season;
    }


    /**
     * Sets the season value for this AccessDate.
     * 
     * @param season
     */
    public void setSeason(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season) {
        this.season = season;
    }


    /**
     * Gets the year value for this AccessDate.
     * 
     * @return year
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year getYear() {
        return year;
    }


    /**
     * Sets the year value for this AccessDate.
     * 
     * @param year
     */
    public void setYear(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year) {
        this.year = year;
    }


    /**
     * Gets the x value for this AccessDate.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this AccessDate.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the _any value for this AccessDate.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this AccessDate.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the contentType value for this AccessDate.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this AccessDate.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccessDate)) return false;
        AccessDate other = (AccessDate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.season==null && other.getSeason()==null) || 
             (this.season!=null &&
              this.season.equals(other.getSeason()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
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
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getSeason() != null) {
            _hashCode += getSeason().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccessDate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">access-date"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">day"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">month"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("season");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "season"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">season"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">year"));
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
