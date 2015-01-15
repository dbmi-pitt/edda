/**
 * Conference.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class Conference  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate[] confDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName[] confName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfNum[] confNum;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc[] confLoc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor[] confSponsor;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfTheme[] confTheme;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfAcronym[] confAcronym;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X[] x;

    public Conference() {
    }

    public Conference(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate[] confDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName[] confName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfNum[] confNum,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc[] confLoc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor[] confSponsor,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfTheme[] confTheme,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfAcronym[] confAcronym,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X[] x) {
           this.confDate = confDate;
           this.confName = confName;
           this.confNum = confNum;
           this.confLoc = confLoc;
           this.confSponsor = confSponsor;
           this.confTheme = confTheme;
           this.confAcronym = confAcronym;
           this.x = x;
    }


    /**
     * Gets the confDate value for this Conference.
     * 
     * @return confDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate[] getConfDate() {
        return confDate;
    }


    /**
     * Sets the confDate value for this Conference.
     * 
     * @param confDate
     */
    public void setConfDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate[] confDate) {
        this.confDate = confDate;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate getConfDate(int i) {
        return this.confDate[i];
    }

    public void setConfDate(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate _value) {
        this.confDate[i] = _value;
    }


    /**
     * Gets the confName value for this Conference.
     * 
     * @return confName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName[] getConfName() {
        return confName;
    }


    /**
     * Sets the confName value for this Conference.
     * 
     * @param confName
     */
    public void setConfName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName[] confName) {
        this.confName = confName;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName getConfName(int i) {
        return this.confName[i];
    }

    public void setConfName(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName _value) {
        this.confName[i] = _value;
    }


    /**
     * Gets the confNum value for this Conference.
     * 
     * @return confNum
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfNum[] getConfNum() {
        return confNum;
    }


    /**
     * Sets the confNum value for this Conference.
     * 
     * @param confNum
     */
    public void setConfNum(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfNum[] confNum) {
        this.confNum = confNum;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfNum getConfNum(int i) {
        return this.confNum[i];
    }

    public void setConfNum(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfNum _value) {
        this.confNum[i] = _value;
    }


    /**
     * Gets the confLoc value for this Conference.
     * 
     * @return confLoc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc[] getConfLoc() {
        return confLoc;
    }


    /**
     * Sets the confLoc value for this Conference.
     * 
     * @param confLoc
     */
    public void setConfLoc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc[] confLoc) {
        this.confLoc = confLoc;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc getConfLoc(int i) {
        return this.confLoc[i];
    }

    public void setConfLoc(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc _value) {
        this.confLoc[i] = _value;
    }


    /**
     * Gets the confSponsor value for this Conference.
     * 
     * @return confSponsor
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor[] getConfSponsor() {
        return confSponsor;
    }


    /**
     * Sets the confSponsor value for this Conference.
     * 
     * @param confSponsor
     */
    public void setConfSponsor(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor[] confSponsor) {
        this.confSponsor = confSponsor;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor getConfSponsor(int i) {
        return this.confSponsor[i];
    }

    public void setConfSponsor(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor _value) {
        this.confSponsor[i] = _value;
    }


    /**
     * Gets the confTheme value for this Conference.
     * 
     * @return confTheme
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfTheme[] getConfTheme() {
        return confTheme;
    }


    /**
     * Sets the confTheme value for this Conference.
     * 
     * @param confTheme
     */
    public void setConfTheme(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfTheme[] confTheme) {
        this.confTheme = confTheme;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfTheme getConfTheme(int i) {
        return this.confTheme[i];
    }

    public void setConfTheme(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfTheme _value) {
        this.confTheme[i] = _value;
    }


    /**
     * Gets the confAcronym value for this Conference.
     * 
     * @return confAcronym
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfAcronym[] getConfAcronym() {
        return confAcronym;
    }


    /**
     * Sets the confAcronym value for this Conference.
     * 
     * @param confAcronym
     */
    public void setConfAcronym(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfAcronym[] confAcronym) {
        this.confAcronym = confAcronym;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfAcronym getConfAcronym(int i) {
        return this.confAcronym[i];
    }

    public void setConfAcronym(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfAcronym _value) {
        this.confAcronym[i] = _value;
    }


    /**
     * Gets the x value for this Conference.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X[] getX() {
        return x;
    }


    /**
     * Sets the x value for this Conference.
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Conference)) return false;
        Conference other = (Conference) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.confDate==null && other.getConfDate()==null) || 
             (this.confDate!=null &&
              java.util.Arrays.equals(this.confDate, other.getConfDate()))) &&
            ((this.confName==null && other.getConfName()==null) || 
             (this.confName!=null &&
              java.util.Arrays.equals(this.confName, other.getConfName()))) &&
            ((this.confNum==null && other.getConfNum()==null) || 
             (this.confNum!=null &&
              java.util.Arrays.equals(this.confNum, other.getConfNum()))) &&
            ((this.confLoc==null && other.getConfLoc()==null) || 
             (this.confLoc!=null &&
              java.util.Arrays.equals(this.confLoc, other.getConfLoc()))) &&
            ((this.confSponsor==null && other.getConfSponsor()==null) || 
             (this.confSponsor!=null &&
              java.util.Arrays.equals(this.confSponsor, other.getConfSponsor()))) &&
            ((this.confTheme==null && other.getConfTheme()==null) || 
             (this.confTheme!=null &&
              java.util.Arrays.equals(this.confTheme, other.getConfTheme()))) &&
            ((this.confAcronym==null && other.getConfAcronym()==null) || 
             (this.confAcronym!=null &&
              java.util.Arrays.equals(this.confAcronym, other.getConfAcronym()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              java.util.Arrays.equals(this.x, other.getX())));
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
        if (getConfDate() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfDate());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConfDate(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConfName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConfName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConfNum() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfNum());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConfNum(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConfLoc() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfLoc());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConfLoc(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConfSponsor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfSponsor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConfSponsor(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConfTheme() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfTheme());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConfTheme(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConfAcronym() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConfAcronym());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConfAcronym(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Conference.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conference"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-name"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-num"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-num"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confLoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-loc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-loc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confSponsor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-sponsor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-sponsor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confTheme");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-theme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-theme"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confAcronym");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-acronym"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-acronym"));
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
