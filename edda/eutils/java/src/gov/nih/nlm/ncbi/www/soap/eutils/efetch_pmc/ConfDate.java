/**
 * ConfDate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class ConfDate  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day[] day;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month[] month;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season[] season;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year[] year;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X[] x;

    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private java.lang.Object contentType;  // attribute

    public ConfDate() {
    }

    public ConfDate(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day[] day,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month[] month,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season[] season,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year[] year,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X[] x,
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
     * Gets the day value for this ConfDate.
     * 
     * @return day
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day[] getDay() {
        return day;
    }


    /**
     * Sets the day value for this ConfDate.
     * 
     * @param day
     */
    public void setDay(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day[] day) {
        this.day = day;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day getDay(int i) {
        return this.day[i];
    }

    public void setDay(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day _value) {
        this.day[i] = _value;
    }


    /**
     * Gets the month value for this ConfDate.
     * 
     * @return month
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month[] getMonth() {
        return month;
    }


    /**
     * Sets the month value for this ConfDate.
     * 
     * @param month
     */
    public void setMonth(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month[] month) {
        this.month = month;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month getMonth(int i) {
        return this.month[i];
    }

    public void setMonth(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month _value) {
        this.month[i] = _value;
    }


    /**
     * Gets the season value for this ConfDate.
     * 
     * @return season
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season[] getSeason() {
        return season;
    }


    /**
     * Sets the season value for this ConfDate.
     * 
     * @param season
     */
    public void setSeason(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season[] season) {
        this.season = season;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season getSeason(int i) {
        return this.season[i];
    }

    public void setSeason(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season _value) {
        this.season[i] = _value;
    }


    /**
     * Gets the year value for this ConfDate.
     * 
     * @return year
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year[] getYear() {
        return year;
    }


    /**
     * Sets the year value for this ConfDate.
     * 
     * @param year
     */
    public void setYear(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year[] year) {
        this.year = year;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year getYear(int i) {
        return this.year[i];
    }

    public void setYear(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year _value) {
        this.year[i] = _value;
    }


    /**
     * Gets the x value for this ConfDate.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X[] getX() {
        return x;
    }


    /**
     * Sets the x value for this ConfDate.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X[] x) {
        this.x = x;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX(int i) {
        return this.x[i];
    }

    public void setX(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X _value) {
        this.x[i] = _value;
    }


    /**
     * Gets the _any value for this ConfDate.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this ConfDate.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the contentType value for this ConfDate.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this ConfDate.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfDate)) return false;
        ConfDate other = (ConfDate) obj;
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
              java.util.Arrays.equals(this.day, other.getDay()))) &&
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              java.util.Arrays.equals(this.month, other.getMonth()))) &&
            ((this.season==null && other.getSeason()==null) || 
             (this.season!=null &&
              java.util.Arrays.equals(this.season, other.getSeason()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              java.util.Arrays.equals(this.year, other.getYear()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              java.util.Arrays.equals(this.x, other.getX()))) &&
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
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDay());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDay(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMonth() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMonth());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMonth(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSeason() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSeason());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSeason(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getYear() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getYear());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getYear(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getX() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getX());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getX(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(ConfDate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-date"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "day"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "month"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("season");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "season"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "season"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "year"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "x"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "x"));
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
