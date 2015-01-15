/**
 * SecMeta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class SecMeta  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup[] contribGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] kwdGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions;

    public SecMeta() {
    }

    public SecMeta(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup[] contribGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] kwdGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
           this.contribGroup = contribGroup;
           this.kwdGroup = kwdGroup;
           this.permissions = permissions;
    }


    /**
     * Gets the contribGroup value for this SecMeta.
     * 
     * @return contribGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup[] getContribGroup() {
        return contribGroup;
    }


    /**
     * Sets the contribGroup value for this SecMeta.
     * 
     * @param contribGroup
     */
    public void setContribGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup[] contribGroup) {
        this.contribGroup = contribGroup;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup getContribGroup(int i) {
        return this.contribGroup[i];
    }

    public void setContribGroup(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup _value) {
        this.contribGroup[i] = _value;
    }


    /**
     * Gets the kwdGroup value for this SecMeta.
     * 
     * @return kwdGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] getKwdGroup() {
        return kwdGroup;
    }


    /**
     * Sets the kwdGroup value for this SecMeta.
     * 
     * @param kwdGroup
     */
    public void setKwdGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] kwdGroup) {
        this.kwdGroup = kwdGroup;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup getKwdGroup(int i) {
        return this.kwdGroup[i];
    }

    public void setKwdGroup(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup _value) {
        this.kwdGroup[i] = _value;
    }


    /**
     * Gets the permissions value for this SecMeta.
     * 
     * @return permissions
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this SecMeta.
     * 
     * @param permissions
     */
    public void setPermissions(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
        this.permissions = permissions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SecMeta)) return false;
        SecMeta other = (SecMeta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contribGroup==null && other.getContribGroup()==null) || 
             (this.contribGroup!=null &&
              java.util.Arrays.equals(this.contribGroup, other.getContribGroup()))) &&
            ((this.kwdGroup==null && other.getKwdGroup()==null) || 
             (this.kwdGroup!=null &&
              java.util.Arrays.equals(this.kwdGroup, other.getKwdGroup()))) &&
            ((this.permissions==null && other.getPermissions()==null) || 
             (this.permissions!=null &&
              this.permissions.equals(other.getPermissions())));
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
        if (getContribGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContribGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContribGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getKwdGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKwdGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKwdGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPermissions() != null) {
            _hashCode += getPermissions().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SecMeta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sec-meta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contribGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contrib-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contrib-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kwdGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "kwd-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "kwd-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permissions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "permissions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">permissions"));
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
