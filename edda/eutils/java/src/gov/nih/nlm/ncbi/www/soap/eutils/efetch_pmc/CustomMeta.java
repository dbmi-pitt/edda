/**
 * CustomMeta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class CustomMeta  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaName metaName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaValue metaValue;

    private java.lang.String id;  // attribute

    private org.w3.www._1999.xlink.Type type;  // attribute

    private java.lang.Object href;  // attribute

    private java.lang.Object role;  // attribute

    private java.lang.Object title;  // attribute

    private org.w3.www._1999.xlink.Show show;  // attribute

    private org.w3.www._1999.xlink.Actuate actuate;  // attribute

    public CustomMeta() {
    }

    public CustomMeta(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaName metaName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaValue metaValue,
           java.lang.String id,
           org.w3.www._1999.xlink.Type type,
           java.lang.Object href,
           java.lang.Object role,
           java.lang.Object title,
           org.w3.www._1999.xlink.Show show,
           org.w3.www._1999.xlink.Actuate actuate) {
           this.metaName = metaName;
           this.metaValue = metaValue;
           this.id = id;
           this.type = type;
           this.href = href;
           this.role = role;
           this.title = title;
           this.show = show;
           this.actuate = actuate;
    }


    /**
     * Gets the metaName value for this CustomMeta.
     * 
     * @return metaName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaName getMetaName() {
        return metaName;
    }


    /**
     * Sets the metaName value for this CustomMeta.
     * 
     * @param metaName
     */
    public void setMetaName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaName metaName) {
        this.metaName = metaName;
    }


    /**
     * Gets the metaValue value for this CustomMeta.
     * 
     * @return metaValue
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaValue getMetaValue() {
        return metaValue;
    }


    /**
     * Sets the metaValue value for this CustomMeta.
     * 
     * @param metaValue
     */
    public void setMetaValue(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaValue metaValue) {
        this.metaValue = metaValue;
    }


    /**
     * Gets the id value for this CustomMeta.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this CustomMeta.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the type value for this CustomMeta.
     * 
     * @return type
     */
    public org.w3.www._1999.xlink.Type getType() {
        return type;
    }


    /**
     * Sets the type value for this CustomMeta.
     * 
     * @param type
     */
    public void setType(org.w3.www._1999.xlink.Type type) {
        this.type = type;
    }


    /**
     * Gets the href value for this CustomMeta.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this CustomMeta.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }


    /**
     * Gets the role value for this CustomMeta.
     * 
     * @return role
     */
    public java.lang.Object getRole() {
        return role;
    }


    /**
     * Sets the role value for this CustomMeta.
     * 
     * @param role
     */
    public void setRole(java.lang.Object role) {
        this.role = role;
    }


    /**
     * Gets the title value for this CustomMeta.
     * 
     * @return title
     */
    public java.lang.Object getTitle() {
        return title;
    }


    /**
     * Sets the title value for this CustomMeta.
     * 
     * @param title
     */
    public void setTitle(java.lang.Object title) {
        this.title = title;
    }


    /**
     * Gets the show value for this CustomMeta.
     * 
     * @return show
     */
    public org.w3.www._1999.xlink.Show getShow() {
        return show;
    }


    /**
     * Sets the show value for this CustomMeta.
     * 
     * @param show
     */
    public void setShow(org.w3.www._1999.xlink.Show show) {
        this.show = show;
    }


    /**
     * Gets the actuate value for this CustomMeta.
     * 
     * @return actuate
     */
    public org.w3.www._1999.xlink.Actuate getActuate() {
        return actuate;
    }


    /**
     * Sets the actuate value for this CustomMeta.
     * 
     * @param actuate
     */
    public void setActuate(org.w3.www._1999.xlink.Actuate actuate) {
        this.actuate = actuate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomMeta)) return false;
        CustomMeta other = (CustomMeta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metaName==null && other.getMetaName()==null) || 
             (this.metaName!=null &&
              this.metaName.equals(other.getMetaName()))) &&
            ((this.metaValue==null && other.getMetaValue()==null) || 
             (this.metaValue!=null &&
              this.metaValue.equals(other.getMetaValue()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.href==null && other.getHref()==null) || 
             (this.href!=null &&
              this.href.equals(other.getHref()))) &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.show==null && other.getShow()==null) || 
             (this.show!=null &&
              this.show.equals(other.getShow()))) &&
            ((this.actuate==null && other.getActuate()==null) || 
             (this.actuate!=null &&
              this.actuate.equals(other.getActuate())));
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
        if (getMetaName() != null) {
            _hashCode += getMetaName().hashCode();
        }
        if (getMetaValue() != null) {
            _hashCode += getMetaValue().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getHref() != null) {
            _hashCode += getHref().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getShow() != null) {
            _hashCode += getShow().hashCode();
        }
        if (getActuate() != null) {
            _hashCode += getActuate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomMeta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">custom-meta"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">type"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("href");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "href"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("role");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "role"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("title");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "title"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("show");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "show"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">show"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("actuate");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "actuate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">actuate"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "meta-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">meta-name"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "meta-value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">meta-value"));
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
