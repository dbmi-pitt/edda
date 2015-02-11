/**
 * InvestigatorType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class InvestigatorType  implements java.io.Serializable {
    private java.lang.String lastName;

    private java.lang.String foreName;

    private java.lang.String initials;

    private java.lang.String suffix;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] nameID;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] identifier;

    private java.lang.String affiliation;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorTypeValidYN validYN;  // attribute

    public InvestigatorType() {
    }

    public InvestigatorType(
           java.lang.String lastName,
           java.lang.String foreName,
           java.lang.String initials,
           java.lang.String suffix,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] nameID,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] identifier,
           java.lang.String affiliation,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorTypeValidYN validYN) {
           this.lastName = lastName;
           this.foreName = foreName;
           this.initials = initials;
           this.suffix = suffix;
           this.nameID = nameID;
           this.identifier = identifier;
           this.affiliation = affiliation;
           this.validYN = validYN;
    }


    /**
     * Gets the lastName value for this InvestigatorType.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this InvestigatorType.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the foreName value for this InvestigatorType.
     * 
     * @return foreName
     */
    public java.lang.String getForeName() {
        return foreName;
    }


    /**
     * Sets the foreName value for this InvestigatorType.
     * 
     * @param foreName
     */
    public void setForeName(java.lang.String foreName) {
        this.foreName = foreName;
    }


    /**
     * Gets the initials value for this InvestigatorType.
     * 
     * @return initials
     */
    public java.lang.String getInitials() {
        return initials;
    }


    /**
     * Sets the initials value for this InvestigatorType.
     * 
     * @param initials
     */
    public void setInitials(java.lang.String initials) {
        this.initials = initials;
    }


    /**
     * Gets the suffix value for this InvestigatorType.
     * 
     * @return suffix
     */
    public java.lang.String getSuffix() {
        return suffix;
    }


    /**
     * Sets the suffix value for this InvestigatorType.
     * 
     * @param suffix
     */
    public void setSuffix(java.lang.String suffix) {
        this.suffix = suffix;
    }


    /**
     * Gets the nameID value for this InvestigatorType.
     * 
     * @return nameID
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] getNameID() {
        return nameID;
    }


    /**
     * Sets the nameID value for this InvestigatorType.
     * 
     * @param nameID
     */
    public void setNameID(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] nameID) {
        this.nameID = nameID;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType getNameID(int i) {
        return this.nameID[i];
    }

    public void setNameID(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType _value) {
        this.nameID[i] = _value;
    }


    /**
     * Gets the identifier value for this InvestigatorType.
     * 
     * @return identifier
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] getIdentifier() {
        return identifier;
    }


    /**
     * Sets the identifier value for this InvestigatorType.
     * 
     * @param identifier
     */
    public void setIdentifier(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType[] identifier) {
        this.identifier = identifier;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType getIdentifier(int i) {
        return this.identifier[i];
    }

    public void setIdentifier(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.IdentifierType _value) {
        this.identifier[i] = _value;
    }


    /**
     * Gets the affiliation value for this InvestigatorType.
     * 
     * @return affiliation
     */
    public java.lang.String getAffiliation() {
        return affiliation;
    }


    /**
     * Sets the affiliation value for this InvestigatorType.
     * 
     * @param affiliation
     */
    public void setAffiliation(java.lang.String affiliation) {
        this.affiliation = affiliation;
    }


    /**
     * Gets the validYN value for this InvestigatorType.
     * 
     * @return validYN
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorTypeValidYN getValidYN() {
        return validYN;
    }


    /**
     * Sets the validYN value for this InvestigatorType.
     * 
     * @param validYN
     */
    public void setValidYN(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorTypeValidYN validYN) {
        this.validYN = validYN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InvestigatorType)) return false;
        InvestigatorType other = (InvestigatorType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.foreName==null && other.getForeName()==null) || 
             (this.foreName!=null &&
              this.foreName.equals(other.getForeName()))) &&
            ((this.initials==null && other.getInitials()==null) || 
             (this.initials!=null &&
              this.initials.equals(other.getInitials()))) &&
            ((this.suffix==null && other.getSuffix()==null) || 
             (this.suffix!=null &&
              this.suffix.equals(other.getSuffix()))) &&
            ((this.nameID==null && other.getNameID()==null) || 
             (this.nameID!=null &&
              java.util.Arrays.equals(this.nameID, other.getNameID()))) &&
            ((this.identifier==null && other.getIdentifier()==null) || 
             (this.identifier!=null &&
              java.util.Arrays.equals(this.identifier, other.getIdentifier()))) &&
            ((this.affiliation==null && other.getAffiliation()==null) || 
             (this.affiliation!=null &&
              this.affiliation.equals(other.getAffiliation()))) &&
            ((this.validYN==null && other.getValidYN()==null) || 
             (this.validYN!=null &&
              this.validYN.equals(other.getValidYN())));
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
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getForeName() != null) {
            _hashCode += getForeName().hashCode();
        }
        if (getInitials() != null) {
            _hashCode += getInitials().hashCode();
        }
        if (getSuffix() != null) {
            _hashCode += getSuffix().hashCode();
        }
        if (getNameID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNameID());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNameID(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdentifier() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdentifier());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdentifier(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAffiliation() != null) {
            _hashCode += getAffiliation().hashCode();
        }
        if (getValidYN() != null) {
            _hashCode += getValidYN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InvestigatorType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "InvestigatorType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("validYN");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ValidYN"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">InvestigatorType>ValidYN"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "LastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foreName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ForeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("initials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Initials"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suffix");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Suffix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "NameID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "IdentifierType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "IdentifierType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affiliation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Affiliation"));
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
