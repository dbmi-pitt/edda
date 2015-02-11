/**
 * VerseGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class VerseGroup  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Subtitle subtitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseLine verseLine;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions;

    private java.lang.String id;  // attribute

    private java.lang.Object contentType;  // attribute

    public VerseGroup() {
    }

    public VerseGroup(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Subtitle subtitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseLine verseLine,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions,
           java.lang.String id,
           java.lang.Object contentType) {
           this.title = title;
           this.subtitle = subtitle;
           this.verseLine = verseLine;
           this.verseGroup = verseGroup;
           this.attrib = attrib;
           this.copyrightStatement = copyrightStatement;
           this.permissions = permissions;
           this.id = id;
           this.contentType = contentType;
    }


    /**
     * Gets the title value for this VerseGroup.
     * 
     * @return title
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title getTitle() {
        return title;
    }


    /**
     * Sets the title value for this VerseGroup.
     * 
     * @param title
     */
    public void setTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title) {
        this.title = title;
    }


    /**
     * Gets the subtitle value for this VerseGroup.
     * 
     * @return subtitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Subtitle getSubtitle() {
        return subtitle;
    }


    /**
     * Sets the subtitle value for this VerseGroup.
     * 
     * @param subtitle
     */
    public void setSubtitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Subtitle subtitle) {
        this.subtitle = subtitle;
    }


    /**
     * Gets the verseLine value for this VerseGroup.
     * 
     * @return verseLine
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseLine getVerseLine() {
        return verseLine;
    }


    /**
     * Sets the verseLine value for this VerseGroup.
     * 
     * @param verseLine
     */
    public void setVerseLine(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseLine verseLine) {
        this.verseLine = verseLine;
    }


    /**
     * Gets the verseGroup value for this VerseGroup.
     * 
     * @return verseGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup getVerseGroup() {
        return verseGroup;
    }


    /**
     * Sets the verseGroup value for this VerseGroup.
     * 
     * @param verseGroup
     */
    public void setVerseGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup) {
        this.verseGroup = verseGroup;
    }


    /**
     * Gets the attrib value for this VerseGroup.
     * 
     * @return attrib
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib getAttrib() {
        return attrib;
    }


    /**
     * Sets the attrib value for this VerseGroup.
     * 
     * @param attrib
     */
    public void setAttrib(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib) {
        this.attrib = attrib;
    }


    /**
     * Gets the copyrightStatement value for this VerseGroup.
     * 
     * @return copyrightStatement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement getCopyrightStatement() {
        return copyrightStatement;
    }


    /**
     * Sets the copyrightStatement value for this VerseGroup.
     * 
     * @param copyrightStatement
     */
    public void setCopyrightStatement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement) {
        this.copyrightStatement = copyrightStatement;
    }


    /**
     * Gets the permissions value for this VerseGroup.
     * 
     * @return permissions
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this VerseGroup.
     * 
     * @param permissions
     */
    public void setPermissions(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
        this.permissions = permissions;
    }


    /**
     * Gets the id value for this VerseGroup.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this VerseGroup.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the contentType value for this VerseGroup.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this VerseGroup.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VerseGroup)) return false;
        VerseGroup other = (VerseGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.subtitle==null && other.getSubtitle()==null) || 
             (this.subtitle!=null &&
              this.subtitle.equals(other.getSubtitle()))) &&
            ((this.verseLine==null && other.getVerseLine()==null) || 
             (this.verseLine!=null &&
              this.verseLine.equals(other.getVerseLine()))) &&
            ((this.verseGroup==null && other.getVerseGroup()==null) || 
             (this.verseGroup!=null &&
              this.verseGroup.equals(other.getVerseGroup()))) &&
            ((this.attrib==null && other.getAttrib()==null) || 
             (this.attrib!=null &&
              this.attrib.equals(other.getAttrib()))) &&
            ((this.copyrightStatement==null && other.getCopyrightStatement()==null) || 
             (this.copyrightStatement!=null &&
              this.copyrightStatement.equals(other.getCopyrightStatement()))) &&
            ((this.permissions==null && other.getPermissions()==null) || 
             (this.permissions!=null &&
              this.permissions.equals(other.getPermissions()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
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
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getSubtitle() != null) {
            _hashCode += getSubtitle().hashCode();
        }
        if (getVerseLine() != null) {
            _hashCode += getVerseLine().hashCode();
        }
        if (getVerseGroup() != null) {
            _hashCode += getVerseGroup().hashCode();
        }
        if (getAttrib() != null) {
            _hashCode += getAttrib().hashCode();
        }
        if (getCopyrightStatement() != null) {
            _hashCode += getCopyrightStatement().hashCode();
        }
        if (getPermissions() != null) {
            _hashCode += getPermissions().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VerseGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">verse-group"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">title"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "subtitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">subtitle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verseLine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "verse-line"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">verse-line"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verseGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "verse-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">verse-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attrib");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "attrib"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">attrib"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("copyrightStatement");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "copyright-statement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">copyright-statement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
