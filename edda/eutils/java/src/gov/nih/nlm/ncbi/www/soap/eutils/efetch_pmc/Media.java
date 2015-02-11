/**
 * Media.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class Media  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText altText;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc longDesc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId objectId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption caption;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions;

    private java.lang.String alternateFormOf;  // attribute

    private java.lang.String id;  // attribute

    private java.lang.Object contentType;  // attribute

    private java.lang.Object mimetype;  // attribute

    private java.lang.Object mimeSubtype;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MediaPosition position;  // attribute

    private org.w3.www._1999.xlink.Type type;  // attribute

    private java.lang.Object role;  // attribute

    private java.lang.Object title;  // attribute

    private org.w3.www._1999.xlink.Show show;  // attribute

    private org.w3.www._1999.xlink.Actuate actuate;  // attribute

    public Media() {
    }

    public Media(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText altText,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc longDesc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId objectId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption caption,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions,
           java.lang.String alternateFormOf,
           java.lang.String id,
           java.lang.Object contentType,
           java.lang.Object mimetype,
           java.lang.Object mimeSubtype,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MediaPosition position,
           org.w3.www._1999.xlink.Type type,
           java.lang.Object role,
           java.lang.Object title,
           org.w3.www._1999.xlink.Show show,
           org.w3.www._1999.xlink.Actuate actuate) {
           this.altText = altText;
           this.longDesc = longDesc;
           this.email = email;
           this.extLink = extLink;
           this.uri = uri;
           this.objectId = objectId;
           this.label = label;
           this.caption = caption;
           this.attrib = attrib;
           this.copyrightStatement = copyrightStatement;
           this.permissions = permissions;
           this.alternateFormOf = alternateFormOf;
           this.id = id;
           this.contentType = contentType;
           this.mimetype = mimetype;
           this.mimeSubtype = mimeSubtype;
           this.position = position;
           this.type = type;
           this.role = role;
           this.title = title;
           this.show = show;
           this.actuate = actuate;
    }


    /**
     * Gets the altText value for this Media.
     * 
     * @return altText
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText getAltText() {
        return altText;
    }


    /**
     * Sets the altText value for this Media.
     * 
     * @param altText
     */
    public void setAltText(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText altText) {
        this.altText = altText;
    }


    /**
     * Gets the longDesc value for this Media.
     * 
     * @return longDesc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc getLongDesc() {
        return longDesc;
    }


    /**
     * Sets the longDesc value for this Media.
     * 
     * @param longDesc
     */
    public void setLongDesc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc longDesc) {
        this.longDesc = longDesc;
    }


    /**
     * Gets the email value for this Media.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Media.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email) {
        this.email = email;
    }


    /**
     * Gets the extLink value for this Media.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this Media.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink) {
        this.extLink = extLink;
    }


    /**
     * Gets the uri value for this Media.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this Media.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri) {
        this.uri = uri;
    }


    /**
     * Gets the objectId value for this Media.
     * 
     * @return objectId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this Media.
     * 
     * @param objectId
     */
    public void setObjectId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the label value for this Media.
     * 
     * @return label
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label getLabel() {
        return label;
    }


    /**
     * Sets the label value for this Media.
     * 
     * @param label
     */
    public void setLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label) {
        this.label = label;
    }


    /**
     * Gets the caption value for this Media.
     * 
     * @return caption
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption getCaption() {
        return caption;
    }


    /**
     * Sets the caption value for this Media.
     * 
     * @param caption
     */
    public void setCaption(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption caption) {
        this.caption = caption;
    }


    /**
     * Gets the attrib value for this Media.
     * 
     * @return attrib
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib getAttrib() {
        return attrib;
    }


    /**
     * Sets the attrib value for this Media.
     * 
     * @param attrib
     */
    public void setAttrib(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib) {
        this.attrib = attrib;
    }


    /**
     * Gets the copyrightStatement value for this Media.
     * 
     * @return copyrightStatement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement getCopyrightStatement() {
        return copyrightStatement;
    }


    /**
     * Sets the copyrightStatement value for this Media.
     * 
     * @param copyrightStatement
     */
    public void setCopyrightStatement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement) {
        this.copyrightStatement = copyrightStatement;
    }


    /**
     * Gets the permissions value for this Media.
     * 
     * @return permissions
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this Media.
     * 
     * @param permissions
     */
    public void setPermissions(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
        this.permissions = permissions;
    }


    /**
     * Gets the alternateFormOf value for this Media.
     * 
     * @return alternateFormOf
     */
    public java.lang.String getAlternateFormOf() {
        return alternateFormOf;
    }


    /**
     * Sets the alternateFormOf value for this Media.
     * 
     * @param alternateFormOf
     */
    public void setAlternateFormOf(java.lang.String alternateFormOf) {
        this.alternateFormOf = alternateFormOf;
    }


    /**
     * Gets the id value for this Media.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Media.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the contentType value for this Media.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this Media.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }


    /**
     * Gets the mimetype value for this Media.
     * 
     * @return mimetype
     */
    public java.lang.Object getMimetype() {
        return mimetype;
    }


    /**
     * Sets the mimetype value for this Media.
     * 
     * @param mimetype
     */
    public void setMimetype(java.lang.Object mimetype) {
        this.mimetype = mimetype;
    }


    /**
     * Gets the mimeSubtype value for this Media.
     * 
     * @return mimeSubtype
     */
    public java.lang.Object getMimeSubtype() {
        return mimeSubtype;
    }


    /**
     * Sets the mimeSubtype value for this Media.
     * 
     * @param mimeSubtype
     */
    public void setMimeSubtype(java.lang.Object mimeSubtype) {
        this.mimeSubtype = mimeSubtype;
    }


    /**
     * Gets the position value for this Media.
     * 
     * @return position
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MediaPosition getPosition() {
        return position;
    }


    /**
     * Sets the position value for this Media.
     * 
     * @param position
     */
    public void setPosition(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MediaPosition position) {
        this.position = position;
    }


    /**
     * Gets the type value for this Media.
     * 
     * @return type
     */
    public org.w3.www._1999.xlink.Type getType() {
        return type;
    }


    /**
     * Sets the type value for this Media.
     * 
     * @param type
     */
    public void setType(org.w3.www._1999.xlink.Type type) {
        this.type = type;
    }


    /**
     * Gets the role value for this Media.
     * 
     * @return role
     */
    public java.lang.Object getRole() {
        return role;
    }


    /**
     * Sets the role value for this Media.
     * 
     * @param role
     */
    public void setRole(java.lang.Object role) {
        this.role = role;
    }


    /**
     * Gets the title value for this Media.
     * 
     * @return title
     */
    public java.lang.Object getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Media.
     * 
     * @param title
     */
    public void setTitle(java.lang.Object title) {
        this.title = title;
    }


    /**
     * Gets the show value for this Media.
     * 
     * @return show
     */
    public org.w3.www._1999.xlink.Show getShow() {
        return show;
    }


    /**
     * Sets the show value for this Media.
     * 
     * @param show
     */
    public void setShow(org.w3.www._1999.xlink.Show show) {
        this.show = show;
    }


    /**
     * Gets the actuate value for this Media.
     * 
     * @return actuate
     */
    public org.w3.www._1999.xlink.Actuate getActuate() {
        return actuate;
    }


    /**
     * Sets the actuate value for this Media.
     * 
     * @param actuate
     */
    public void setActuate(org.w3.www._1999.xlink.Actuate actuate) {
        this.actuate = actuate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.altText==null && other.getAltText()==null) || 
             (this.altText!=null &&
              this.altText.equals(other.getAltText()))) &&
            ((this.longDesc==null && other.getLongDesc()==null) || 
             (this.longDesc!=null &&
              this.longDesc.equals(other.getLongDesc()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.extLink==null && other.getExtLink()==null) || 
             (this.extLink!=null &&
              this.extLink.equals(other.getExtLink()))) &&
            ((this.uri==null && other.getUri()==null) || 
             (this.uri!=null &&
              this.uri.equals(other.getUri()))) &&
            ((this.objectId==null && other.getObjectId()==null) || 
             (this.objectId!=null &&
              this.objectId.equals(other.getObjectId()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.caption==null && other.getCaption()==null) || 
             (this.caption!=null &&
              this.caption.equals(other.getCaption()))) &&
            ((this.attrib==null && other.getAttrib()==null) || 
             (this.attrib!=null &&
              this.attrib.equals(other.getAttrib()))) &&
            ((this.copyrightStatement==null && other.getCopyrightStatement()==null) || 
             (this.copyrightStatement!=null &&
              this.copyrightStatement.equals(other.getCopyrightStatement()))) &&
            ((this.permissions==null && other.getPermissions()==null) || 
             (this.permissions!=null &&
              this.permissions.equals(other.getPermissions()))) &&
            ((this.alternateFormOf==null && other.getAlternateFormOf()==null) || 
             (this.alternateFormOf!=null &&
              this.alternateFormOf.equals(other.getAlternateFormOf()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.contentType==null && other.getContentType()==null) || 
             (this.contentType!=null &&
              this.contentType.equals(other.getContentType()))) &&
            ((this.mimetype==null && other.getMimetype()==null) || 
             (this.mimetype!=null &&
              this.mimetype.equals(other.getMimetype()))) &&
            ((this.mimeSubtype==null && other.getMimeSubtype()==null) || 
             (this.mimeSubtype!=null &&
              this.mimeSubtype.equals(other.getMimeSubtype()))) &&
            ((this.position==null && other.getPosition()==null) || 
             (this.position!=null &&
              this.position.equals(other.getPosition()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
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
        if (getAltText() != null) {
            _hashCode += getAltText().hashCode();
        }
        if (getLongDesc() != null) {
            _hashCode += getLongDesc().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getExtLink() != null) {
            _hashCode += getExtLink().hashCode();
        }
        if (getUri() != null) {
            _hashCode += getUri().hashCode();
        }
        if (getObjectId() != null) {
            _hashCode += getObjectId().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getCaption() != null) {
            _hashCode += getCaption().hashCode();
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
        if (getAlternateFormOf() != null) {
            _hashCode += getAlternateFormOf().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        if (getMimetype() != null) {
            _hashCode += getMimetype().hashCode();
        }
        if (getMimeSubtype() != null) {
            _hashCode += getMimeSubtype().hashCode();
        }
        if (getPosition() != null) {
            _hashCode += getPosition().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
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
        new org.apache.axis.description.TypeDesc(Media.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">media"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("alternateFormOf");
        attrField.setXmlName(new javax.xml.namespace.QName("", "alternate-form-of"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mimetype");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mimetype"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mimeSubtype");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mime-subtype"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("position");
        attrField.setXmlName(new javax.xml.namespace.QName("", "position"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>media>position"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("type");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">type"));
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
        elemField.setFieldName("altText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "alt-text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">alt-text"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "long-desc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">long-desc"));
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
        elemField.setFieldName("extLink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "ext-link"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ext-link"));
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
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "object-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">object-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">label"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caption");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "caption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">caption"));
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
