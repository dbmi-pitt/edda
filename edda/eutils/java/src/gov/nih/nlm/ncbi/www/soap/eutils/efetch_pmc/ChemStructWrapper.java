/**
 * ChemStructWrapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class ChemStructWrapper  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId[] objectId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption caption;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText altText;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc longDesc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct chemStruct;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic graphic;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media media;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat preformat;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions;

    private java.lang.String id;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapperPosition position;  // attribute

    private java.lang.Object contentType;  // attribute

    public ChemStructWrapper() {
    }

    public ChemStructWrapper(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId[] objectId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption caption,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText altText,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc longDesc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct chemStruct,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic graphic,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media media,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat preformat,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions,
           java.lang.String id,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapperPosition position,
           java.lang.Object contentType) {
           this.objectId = objectId;
           this.label = label;
           this.caption = caption;
           this.altText = altText;
           this.longDesc = longDesc;
           this.email = email;
           this.extLink = extLink;
           this.uri = uri;
           this.chemStruct = chemStruct;
           this.graphic = graphic;
           this.media = media;
           this.preformat = preformat;
           this.attrib = attrib;
           this.copyrightStatement = copyrightStatement;
           this.permissions = permissions;
           this.id = id;
           this.position = position;
           this.contentType = contentType;
    }


    /**
     * Gets the objectId value for this ChemStructWrapper.
     * 
     * @return objectId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId[] getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this ChemStructWrapper.
     * 
     * @param objectId
     */
    public void setObjectId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId[] objectId) {
        this.objectId = objectId;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId getObjectId(int i) {
        return this.objectId[i];
    }

    public void setObjectId(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId _value) {
        this.objectId[i] = _value;
    }


    /**
     * Gets the label value for this ChemStructWrapper.
     * 
     * @return label
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label getLabel() {
        return label;
    }


    /**
     * Sets the label value for this ChemStructWrapper.
     * 
     * @param label
     */
    public void setLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label) {
        this.label = label;
    }


    /**
     * Gets the caption value for this ChemStructWrapper.
     * 
     * @return caption
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption getCaption() {
        return caption;
    }


    /**
     * Sets the caption value for this ChemStructWrapper.
     * 
     * @param caption
     */
    public void setCaption(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption caption) {
        this.caption = caption;
    }


    /**
     * Gets the altText value for this ChemStructWrapper.
     * 
     * @return altText
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText getAltText() {
        return altText;
    }


    /**
     * Sets the altText value for this ChemStructWrapper.
     * 
     * @param altText
     */
    public void setAltText(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText altText) {
        this.altText = altText;
    }


    /**
     * Gets the longDesc value for this ChemStructWrapper.
     * 
     * @return longDesc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc getLongDesc() {
        return longDesc;
    }


    /**
     * Sets the longDesc value for this ChemStructWrapper.
     * 
     * @param longDesc
     */
    public void setLongDesc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc longDesc) {
        this.longDesc = longDesc;
    }


    /**
     * Gets the email value for this ChemStructWrapper.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ChemStructWrapper.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email) {
        this.email = email;
    }


    /**
     * Gets the extLink value for this ChemStructWrapper.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this ChemStructWrapper.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink) {
        this.extLink = extLink;
    }


    /**
     * Gets the uri value for this ChemStructWrapper.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this ChemStructWrapper.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri) {
        this.uri = uri;
    }


    /**
     * Gets the chemStruct value for this ChemStructWrapper.
     * 
     * @return chemStruct
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct getChemStruct() {
        return chemStruct;
    }


    /**
     * Sets the chemStruct value for this ChemStructWrapper.
     * 
     * @param chemStruct
     */
    public void setChemStruct(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct chemStruct) {
        this.chemStruct = chemStruct;
    }


    /**
     * Gets the graphic value for this ChemStructWrapper.
     * 
     * @return graphic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic getGraphic() {
        return graphic;
    }


    /**
     * Sets the graphic value for this ChemStructWrapper.
     * 
     * @param graphic
     */
    public void setGraphic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic graphic) {
        this.graphic = graphic;
    }


    /**
     * Gets the media value for this ChemStructWrapper.
     * 
     * @return media
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media getMedia() {
        return media;
    }


    /**
     * Sets the media value for this ChemStructWrapper.
     * 
     * @param media
     */
    public void setMedia(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media media) {
        this.media = media;
    }


    /**
     * Gets the preformat value for this ChemStructWrapper.
     * 
     * @return preformat
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat getPreformat() {
        return preformat;
    }


    /**
     * Sets the preformat value for this ChemStructWrapper.
     * 
     * @param preformat
     */
    public void setPreformat(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat preformat) {
        this.preformat = preformat;
    }


    /**
     * Gets the attrib value for this ChemStructWrapper.
     * 
     * @return attrib
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib getAttrib() {
        return attrib;
    }


    /**
     * Sets the attrib value for this ChemStructWrapper.
     * 
     * @param attrib
     */
    public void setAttrib(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib) {
        this.attrib = attrib;
    }


    /**
     * Gets the copyrightStatement value for this ChemStructWrapper.
     * 
     * @return copyrightStatement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement getCopyrightStatement() {
        return copyrightStatement;
    }


    /**
     * Sets the copyrightStatement value for this ChemStructWrapper.
     * 
     * @param copyrightStatement
     */
    public void setCopyrightStatement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement) {
        this.copyrightStatement = copyrightStatement;
    }


    /**
     * Gets the permissions value for this ChemStructWrapper.
     * 
     * @return permissions
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this ChemStructWrapper.
     * 
     * @param permissions
     */
    public void setPermissions(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
        this.permissions = permissions;
    }


    /**
     * Gets the id value for this ChemStructWrapper.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ChemStructWrapper.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the position value for this ChemStructWrapper.
     * 
     * @return position
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapperPosition getPosition() {
        return position;
    }


    /**
     * Sets the position value for this ChemStructWrapper.
     * 
     * @param position
     */
    public void setPosition(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapperPosition position) {
        this.position = position;
    }


    /**
     * Gets the contentType value for this ChemStructWrapper.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this ChemStructWrapper.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChemStructWrapper)) return false;
        ChemStructWrapper other = (ChemStructWrapper) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectId==null && other.getObjectId()==null) || 
             (this.objectId!=null &&
              java.util.Arrays.equals(this.objectId, other.getObjectId()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.caption==null && other.getCaption()==null) || 
             (this.caption!=null &&
              this.caption.equals(other.getCaption()))) &&
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
            ((this.chemStruct==null && other.getChemStruct()==null) || 
             (this.chemStruct!=null &&
              this.chemStruct.equals(other.getChemStruct()))) &&
            ((this.graphic==null && other.getGraphic()==null) || 
             (this.graphic!=null &&
              this.graphic.equals(other.getGraphic()))) &&
            ((this.media==null && other.getMedia()==null) || 
             (this.media!=null &&
              this.media.equals(other.getMedia()))) &&
            ((this.preformat==null && other.getPreformat()==null) || 
             (this.preformat!=null &&
              this.preformat.equals(other.getPreformat()))) &&
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
            ((this.position==null && other.getPosition()==null) || 
             (this.position!=null &&
              this.position.equals(other.getPosition()))) &&
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
        if (getObjectId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjectId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjectId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getCaption() != null) {
            _hashCode += getCaption().hashCode();
        }
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
        if (getChemStruct() != null) {
            _hashCode += getChemStruct().hashCode();
        }
        if (getGraphic() != null) {
            _hashCode += getGraphic().hashCode();
        }
        if (getMedia() != null) {
            _hashCode += getMedia().hashCode();
        }
        if (getPreformat() != null) {
            _hashCode += getPreformat().hashCode();
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
        if (getPosition() != null) {
            _hashCode += getPosition().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChemStructWrapper.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">chem-struct-wrapper"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("position");
        attrField.setXmlName(new javax.xml.namespace.QName("", "position"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>chem-struct-wrapper>position"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "object-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "object-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("chemStruct");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "chem-struct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">chem-struct"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("graphic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "graphic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">graphic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("media");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "media"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">media"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preformat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "preformat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">preformat"));
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
