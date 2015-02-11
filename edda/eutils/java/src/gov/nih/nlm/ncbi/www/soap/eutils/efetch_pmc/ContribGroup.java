/**
 * ContribGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class ContribGroup  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Contrib contrib;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Address address;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorComment authorComment;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bio bio;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OnBehalfOf onBehalfOf;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role role;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private java.lang.String id;  // attribute

    private java.lang.Object contentType;  // attribute

    public ContribGroup() {
    }

    public ContribGroup(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Contrib contrib,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Address address,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorComment authorComment,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bio bio,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OnBehalfOf onBehalfOf,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role role,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           java.lang.String id,
           java.lang.Object contentType) {
           this.contrib = contrib;
           this.address = address;
           this.aff = aff;
           this.authorComment = authorComment;
           this.bio = bio;
           this.email = email;
           this.etal = etal;
           this.extLink = extLink;
           this.fn = fn;
           this.onBehalfOf = onBehalfOf;
           this.role = role;
           this.uri = uri;
           this.xref = xref;
           this.x = x;
           this.id = id;
           this.contentType = contentType;
    }


    /**
     * Gets the contrib value for this ContribGroup.
     * 
     * @return contrib
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Contrib getContrib() {
        return contrib;
    }


    /**
     * Sets the contrib value for this ContribGroup.
     * 
     * @param contrib
     */
    public void setContrib(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Contrib contrib) {
        this.contrib = contrib;
    }


    /**
     * Gets the address value for this ContribGroup.
     * 
     * @return address
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Address getAddress() {
        return address;
    }


    /**
     * Sets the address value for this ContribGroup.
     * 
     * @param address
     */
    public void setAddress(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Address address) {
        this.address = address;
    }


    /**
     * Gets the aff value for this ContribGroup.
     * 
     * @return aff
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff getAff() {
        return aff;
    }


    /**
     * Sets the aff value for this ContribGroup.
     * 
     * @param aff
     */
    public void setAff(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff) {
        this.aff = aff;
    }


    /**
     * Gets the authorComment value for this ContribGroup.
     * 
     * @return authorComment
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorComment getAuthorComment() {
        return authorComment;
    }


    /**
     * Sets the authorComment value for this ContribGroup.
     * 
     * @param authorComment
     */
    public void setAuthorComment(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorComment authorComment) {
        this.authorComment = authorComment;
    }


    /**
     * Gets the bio value for this ContribGroup.
     * 
     * @return bio
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bio getBio() {
        return bio;
    }


    /**
     * Sets the bio value for this ContribGroup.
     * 
     * @param bio
     */
    public void setBio(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bio bio) {
        this.bio = bio;
    }


    /**
     * Gets the email value for this ContribGroup.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ContribGroup.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email) {
        this.email = email;
    }


    /**
     * Gets the etal value for this ContribGroup.
     * 
     * @return etal
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal getEtal() {
        return etal;
    }


    /**
     * Sets the etal value for this ContribGroup.
     * 
     * @param etal
     */
    public void setEtal(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal) {
        this.etal = etal;
    }


    /**
     * Gets the extLink value for this ContribGroup.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this ContribGroup.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink) {
        this.extLink = extLink;
    }


    /**
     * Gets the fn value for this ContribGroup.
     * 
     * @return fn
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn getFn() {
        return fn;
    }


    /**
     * Sets the fn value for this ContribGroup.
     * 
     * @param fn
     */
    public void setFn(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn) {
        this.fn = fn;
    }


    /**
     * Gets the onBehalfOf value for this ContribGroup.
     * 
     * @return onBehalfOf
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OnBehalfOf getOnBehalfOf() {
        return onBehalfOf;
    }


    /**
     * Sets the onBehalfOf value for this ContribGroup.
     * 
     * @param onBehalfOf
     */
    public void setOnBehalfOf(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OnBehalfOf onBehalfOf) {
        this.onBehalfOf = onBehalfOf;
    }


    /**
     * Gets the role value for this ContribGroup.
     * 
     * @return role
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role getRole() {
        return role;
    }


    /**
     * Sets the role value for this ContribGroup.
     * 
     * @param role
     */
    public void setRole(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role role) {
        this.role = role;
    }


    /**
     * Gets the uri value for this ContribGroup.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this ContribGroup.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri) {
        this.uri = uri;
    }


    /**
     * Gets the xref value for this ContribGroup.
     * 
     * @return xref
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this ContribGroup.
     * 
     * @param xref
     */
    public void setXref(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref) {
        this.xref = xref;
    }


    /**
     * Gets the x value for this ContribGroup.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this ContribGroup.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the id value for this ContribGroup.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ContribGroup.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the contentType value for this ContribGroup.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this ContribGroup.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContribGroup)) return false;
        ContribGroup other = (ContribGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contrib==null && other.getContrib()==null) || 
             (this.contrib!=null &&
              this.contrib.equals(other.getContrib()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.aff==null && other.getAff()==null) || 
             (this.aff!=null &&
              this.aff.equals(other.getAff()))) &&
            ((this.authorComment==null && other.getAuthorComment()==null) || 
             (this.authorComment!=null &&
              this.authorComment.equals(other.getAuthorComment()))) &&
            ((this.bio==null && other.getBio()==null) || 
             (this.bio!=null &&
              this.bio.equals(other.getBio()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.etal==null && other.getEtal()==null) || 
             (this.etal!=null &&
              this.etal.equals(other.getEtal()))) &&
            ((this.extLink==null && other.getExtLink()==null) || 
             (this.extLink!=null &&
              this.extLink.equals(other.getExtLink()))) &&
            ((this.fn==null && other.getFn()==null) || 
             (this.fn!=null &&
              this.fn.equals(other.getFn()))) &&
            ((this.onBehalfOf==null && other.getOnBehalfOf()==null) || 
             (this.onBehalfOf!=null &&
              this.onBehalfOf.equals(other.getOnBehalfOf()))) &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.uri==null && other.getUri()==null) || 
             (this.uri!=null &&
              this.uri.equals(other.getUri()))) &&
            ((this.xref==null && other.getXref()==null) || 
             (this.xref!=null &&
              this.xref.equals(other.getXref()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
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
        if (getContrib() != null) {
            _hashCode += getContrib().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getAff() != null) {
            _hashCode += getAff().hashCode();
        }
        if (getAuthorComment() != null) {
            _hashCode += getAuthorComment().hashCode();
        }
        if (getBio() != null) {
            _hashCode += getBio().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getEtal() != null) {
            _hashCode += getEtal().hashCode();
        }
        if (getExtLink() != null) {
            _hashCode += getExtLink().hashCode();
        }
        if (getFn() != null) {
            _hashCode += getFn().hashCode();
        }
        if (getOnBehalfOf() != null) {
            _hashCode += getOnBehalfOf().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getUri() != null) {
            _hashCode += getUri().hashCode();
        }
        if (getXref() != null) {
            _hashCode += getXref().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
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
        new org.apache.axis.description.TypeDesc(ContribGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contrib-group"));
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
        elemField.setFieldName("contrib");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contrib"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contrib"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">address"));
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
        elemField.setFieldName("authorComment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "author-comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">author-comment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "bio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">bio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">email"));
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
        elemField.setFieldName("extLink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "ext-link"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ext-link"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onBehalfOf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "on-behalf-of"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">on-behalf-of"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">role"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uri");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "uri"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">uri"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "xref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">xref"));
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
