/**
 * PersonGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class PersonGroup  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous anonymous;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private java.lang.String id;  // attribute

    private java.lang.Object personGroupType;  // attribute

    public PersonGroup() {
    }

    public PersonGroup(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous anonymous,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           org.apache.axis.message.MessageElement [] _any,
           java.lang.String id,
           java.lang.Object personGroupType) {
           this.anonymous = anonymous;
           this.collab = collab;
           this.name = name;
           this.stringName = stringName;
           this.aff = aff;
           this.etal = etal;
           this.x = x;
           this._any = _any;
           this.id = id;
           this.personGroupType = personGroupType;
    }


    /**
     * Gets the anonymous value for this PersonGroup.
     * 
     * @return anonymous
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous getAnonymous() {
        return anonymous;
    }


    /**
     * Sets the anonymous value for this PersonGroup.
     * 
     * @param anonymous
     */
    public void setAnonymous(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous anonymous) {
        this.anonymous = anonymous;
    }


    /**
     * Gets the collab value for this PersonGroup.
     * 
     * @return collab
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab getCollab() {
        return collab;
    }


    /**
     * Sets the collab value for this PersonGroup.
     * 
     * @param collab
     */
    public void setCollab(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab) {
        this.collab = collab;
    }


    /**
     * Gets the name value for this PersonGroup.
     * 
     * @return name
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name getName() {
        return name;
    }


    /**
     * Sets the name value for this PersonGroup.
     * 
     * @param name
     */
    public void setName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name) {
        this.name = name;
    }


    /**
     * Gets the stringName value for this PersonGroup.
     * 
     * @return stringName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName getStringName() {
        return stringName;
    }


    /**
     * Sets the stringName value for this PersonGroup.
     * 
     * @param stringName
     */
    public void setStringName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName) {
        this.stringName = stringName;
    }


    /**
     * Gets the aff value for this PersonGroup.
     * 
     * @return aff
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff getAff() {
        return aff;
    }


    /**
     * Sets the aff value for this PersonGroup.
     * 
     * @param aff
     */
    public void setAff(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff) {
        this.aff = aff;
    }


    /**
     * Gets the etal value for this PersonGroup.
     * 
     * @return etal
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal getEtal() {
        return etal;
    }


    /**
     * Sets the etal value for this PersonGroup.
     * 
     * @param etal
     */
    public void setEtal(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal) {
        this.etal = etal;
    }


    /**
     * Gets the x value for this PersonGroup.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this PersonGroup.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the _any value for this PersonGroup.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this PersonGroup.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the id value for this PersonGroup.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this PersonGroup.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the personGroupType value for this PersonGroup.
     * 
     * @return personGroupType
     */
    public java.lang.Object getPersonGroupType() {
        return personGroupType;
    }


    /**
     * Sets the personGroupType value for this PersonGroup.
     * 
     * @param personGroupType
     */
    public void setPersonGroupType(java.lang.Object personGroupType) {
        this.personGroupType = personGroupType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PersonGroup)) return false;
        PersonGroup other = (PersonGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anonymous==null && other.getAnonymous()==null) || 
             (this.anonymous!=null &&
              this.anonymous.equals(other.getAnonymous()))) &&
            ((this.collab==null && other.getCollab()==null) || 
             (this.collab!=null &&
              this.collab.equals(other.getCollab()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.stringName==null && other.getStringName()==null) || 
             (this.stringName!=null &&
              this.stringName.equals(other.getStringName()))) &&
            ((this.aff==null && other.getAff()==null) || 
             (this.aff!=null &&
              this.aff.equals(other.getAff()))) &&
            ((this.etal==null && other.getEtal()==null) || 
             (this.etal!=null &&
              this.etal.equals(other.getEtal()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.personGroupType==null && other.getPersonGroupType()==null) || 
             (this.personGroupType!=null &&
              this.personGroupType.equals(other.getPersonGroupType())));
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
        if (getAnonymous() != null) {
            _hashCode += getAnonymous().hashCode();
        }
        if (getCollab() != null) {
            _hashCode += getCollab().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getStringName() != null) {
            _hashCode += getStringName().hashCode();
        }
        if (getAff() != null) {
            _hashCode += getAff().hashCode();
        }
        if (getEtal() != null) {
            _hashCode += getEtal().hashCode();
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getPersonGroupType() != null) {
            _hashCode += getPersonGroupType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PersonGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">person-group"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("personGroupType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "person-group-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anonymous");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "anonymous"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">anonymous"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "collab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">collab"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">name"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "string-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">string-name"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aff");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "aff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">aff"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "etal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">etal"));
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
