/**
 * Contrib.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class Contrib  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous anonymous;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Degrees degrees;

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

    private java.lang.Object contribType;  // attribute

    private java.lang.String id;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribCorresp corresp;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribEqualContrib equalContrib;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribDeceased deceased;  // attribute

    private java.lang.String rid;  // attribute

    private org.w3.www._1999.xlink.Type type;  // attribute

    private java.lang.Object href;  // attribute

    private java.lang.Object role2;  // attribute

    private java.lang.Object title;  // attribute

    private org.w3.www._1999.xlink.Show show;  // attribute

    private org.w3.www._1999.xlink.Actuate actuate;  // attribute

    public Contrib() {
    }

    public Contrib(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous anonymous,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Degrees degrees,
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
           java.lang.Object contribType,
           java.lang.String id,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribCorresp corresp,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribEqualContrib equalContrib,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribDeceased deceased,
           java.lang.String rid,
           org.w3.www._1999.xlink.Type type,
           java.lang.Object href,
           java.lang.Object role2,
           java.lang.Object title,
           org.w3.www._1999.xlink.Show show,
           org.w3.www._1999.xlink.Actuate actuate) {
           this.anonymous = anonymous;
           this.collab = collab;
           this.name = name;
           this.stringName = stringName;
           this.degrees = degrees;
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
           this.contribType = contribType;
           this.id = id;
           this.corresp = corresp;
           this.equalContrib = equalContrib;
           this.deceased = deceased;
           this.rid = rid;
           this.type = type;
           this.href = href;
           this.role2 = role2;
           this.title = title;
           this.show = show;
           this.actuate = actuate;
    }


    /**
     * Gets the anonymous value for this Contrib.
     * 
     * @return anonymous
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous getAnonymous() {
        return anonymous;
    }


    /**
     * Sets the anonymous value for this Contrib.
     * 
     * @param anonymous
     */
    public void setAnonymous(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous anonymous) {
        this.anonymous = anonymous;
    }


    /**
     * Gets the collab value for this Contrib.
     * 
     * @return collab
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab getCollab() {
        return collab;
    }


    /**
     * Sets the collab value for this Contrib.
     * 
     * @param collab
     */
    public void setCollab(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab) {
        this.collab = collab;
    }


    /**
     * Gets the name value for this Contrib.
     * 
     * @return name
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name getName() {
        return name;
    }


    /**
     * Sets the name value for this Contrib.
     * 
     * @param name
     */
    public void setName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name) {
        this.name = name;
    }


    /**
     * Gets the stringName value for this Contrib.
     * 
     * @return stringName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName getStringName() {
        return stringName;
    }


    /**
     * Sets the stringName value for this Contrib.
     * 
     * @param stringName
     */
    public void setStringName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName) {
        this.stringName = stringName;
    }


    /**
     * Gets the degrees value for this Contrib.
     * 
     * @return degrees
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Degrees getDegrees() {
        return degrees;
    }


    /**
     * Sets the degrees value for this Contrib.
     * 
     * @param degrees
     */
    public void setDegrees(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Degrees degrees) {
        this.degrees = degrees;
    }


    /**
     * Gets the address value for this Contrib.
     * 
     * @return address
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Address getAddress() {
        return address;
    }


    /**
     * Sets the address value for this Contrib.
     * 
     * @param address
     */
    public void setAddress(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Address address) {
        this.address = address;
    }


    /**
     * Gets the aff value for this Contrib.
     * 
     * @return aff
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff getAff() {
        return aff;
    }


    /**
     * Sets the aff value for this Contrib.
     * 
     * @param aff
     */
    public void setAff(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff) {
        this.aff = aff;
    }


    /**
     * Gets the authorComment value for this Contrib.
     * 
     * @return authorComment
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorComment getAuthorComment() {
        return authorComment;
    }


    /**
     * Sets the authorComment value for this Contrib.
     * 
     * @param authorComment
     */
    public void setAuthorComment(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorComment authorComment) {
        this.authorComment = authorComment;
    }


    /**
     * Gets the bio value for this Contrib.
     * 
     * @return bio
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bio getBio() {
        return bio;
    }


    /**
     * Sets the bio value for this Contrib.
     * 
     * @param bio
     */
    public void setBio(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bio bio) {
        this.bio = bio;
    }


    /**
     * Gets the email value for this Contrib.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Contrib.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email) {
        this.email = email;
    }


    /**
     * Gets the etal value for this Contrib.
     * 
     * @return etal
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal getEtal() {
        return etal;
    }


    /**
     * Sets the etal value for this Contrib.
     * 
     * @param etal
     */
    public void setEtal(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal) {
        this.etal = etal;
    }


    /**
     * Gets the extLink value for this Contrib.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this Contrib.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink) {
        this.extLink = extLink;
    }


    /**
     * Gets the fn value for this Contrib.
     * 
     * @return fn
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn getFn() {
        return fn;
    }


    /**
     * Sets the fn value for this Contrib.
     * 
     * @param fn
     */
    public void setFn(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn) {
        this.fn = fn;
    }


    /**
     * Gets the onBehalfOf value for this Contrib.
     * 
     * @return onBehalfOf
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OnBehalfOf getOnBehalfOf() {
        return onBehalfOf;
    }


    /**
     * Sets the onBehalfOf value for this Contrib.
     * 
     * @param onBehalfOf
     */
    public void setOnBehalfOf(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OnBehalfOf onBehalfOf) {
        this.onBehalfOf = onBehalfOf;
    }


    /**
     * Gets the role value for this Contrib.
     * 
     * @return role
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role getRole() {
        return role;
    }


    /**
     * Sets the role value for this Contrib.
     * 
     * @param role
     */
    public void setRole(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role role) {
        this.role = role;
    }


    /**
     * Gets the uri value for this Contrib.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this Contrib.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri) {
        this.uri = uri;
    }


    /**
     * Gets the xref value for this Contrib.
     * 
     * @return xref
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this Contrib.
     * 
     * @param xref
     */
    public void setXref(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref) {
        this.xref = xref;
    }


    /**
     * Gets the x value for this Contrib.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this Contrib.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the contribType value for this Contrib.
     * 
     * @return contribType
     */
    public java.lang.Object getContribType() {
        return contribType;
    }


    /**
     * Sets the contribType value for this Contrib.
     * 
     * @param contribType
     */
    public void setContribType(java.lang.Object contribType) {
        this.contribType = contribType;
    }


    /**
     * Gets the id value for this Contrib.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Contrib.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the corresp value for this Contrib.
     * 
     * @return corresp
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribCorresp getCorresp() {
        return corresp;
    }


    /**
     * Sets the corresp value for this Contrib.
     * 
     * @param corresp
     */
    public void setCorresp(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribCorresp corresp) {
        this.corresp = corresp;
    }


    /**
     * Gets the equalContrib value for this Contrib.
     * 
     * @return equalContrib
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribEqualContrib getEqualContrib() {
        return equalContrib;
    }


    /**
     * Sets the equalContrib value for this Contrib.
     * 
     * @param equalContrib
     */
    public void setEqualContrib(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribEqualContrib equalContrib) {
        this.equalContrib = equalContrib;
    }


    /**
     * Gets the deceased value for this Contrib.
     * 
     * @return deceased
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribDeceased getDeceased() {
        return deceased;
    }


    /**
     * Sets the deceased value for this Contrib.
     * 
     * @param deceased
     */
    public void setDeceased(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribDeceased deceased) {
        this.deceased = deceased;
    }


    /**
     * Gets the rid value for this Contrib.
     * 
     * @return rid
     */
    public java.lang.String getRid() {
        return rid;
    }


    /**
     * Sets the rid value for this Contrib.
     * 
     * @param rid
     */
    public void setRid(java.lang.String rid) {
        this.rid = rid;
    }


    /**
     * Gets the type value for this Contrib.
     * 
     * @return type
     */
    public org.w3.www._1999.xlink.Type getType() {
        return type;
    }


    /**
     * Sets the type value for this Contrib.
     * 
     * @param type
     */
    public void setType(org.w3.www._1999.xlink.Type type) {
        this.type = type;
    }


    /**
     * Gets the href value for this Contrib.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this Contrib.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }


    /**
     * Gets the role2 value for this Contrib.
     * 
     * @return role2
     */
    public java.lang.Object getRole2() {
        return role2;
    }


    /**
     * Sets the role2 value for this Contrib.
     * 
     * @param role2
     */
    public void setRole2(java.lang.Object role2) {
        this.role2 = role2;
    }


    /**
     * Gets the title value for this Contrib.
     * 
     * @return title
     */
    public java.lang.Object getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Contrib.
     * 
     * @param title
     */
    public void setTitle(java.lang.Object title) {
        this.title = title;
    }


    /**
     * Gets the show value for this Contrib.
     * 
     * @return show
     */
    public org.w3.www._1999.xlink.Show getShow() {
        return show;
    }


    /**
     * Sets the show value for this Contrib.
     * 
     * @param show
     */
    public void setShow(org.w3.www._1999.xlink.Show show) {
        this.show = show;
    }


    /**
     * Gets the actuate value for this Contrib.
     * 
     * @return actuate
     */
    public org.w3.www._1999.xlink.Actuate getActuate() {
        return actuate;
    }


    /**
     * Sets the actuate value for this Contrib.
     * 
     * @param actuate
     */
    public void setActuate(org.w3.www._1999.xlink.Actuate actuate) {
        this.actuate = actuate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Contrib)) return false;
        Contrib other = (Contrib) obj;
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
            ((this.degrees==null && other.getDegrees()==null) || 
             (this.degrees!=null &&
              this.degrees.equals(other.getDegrees()))) &&
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
            ((this.contribType==null && other.getContribType()==null) || 
             (this.contribType!=null &&
              this.contribType.equals(other.getContribType()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.corresp==null && other.getCorresp()==null) || 
             (this.corresp!=null &&
              this.corresp.equals(other.getCorresp()))) &&
            ((this.equalContrib==null && other.getEqualContrib()==null) || 
             (this.equalContrib!=null &&
              this.equalContrib.equals(other.getEqualContrib()))) &&
            ((this.deceased==null && other.getDeceased()==null) || 
             (this.deceased!=null &&
              this.deceased.equals(other.getDeceased()))) &&
            ((this.rid==null && other.getRid()==null) || 
             (this.rid!=null &&
              this.rid.equals(other.getRid()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.href==null && other.getHref()==null) || 
             (this.href!=null &&
              this.href.equals(other.getHref()))) &&
            ((this.role2==null && other.getRole2()==null) || 
             (this.role2!=null &&
              this.role2.equals(other.getRole2()))) &&
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
        if (getDegrees() != null) {
            _hashCode += getDegrees().hashCode();
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
        if (getContribType() != null) {
            _hashCode += getContribType().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getCorresp() != null) {
            _hashCode += getCorresp().hashCode();
        }
        if (getEqualContrib() != null) {
            _hashCode += getEqualContrib().hashCode();
        }
        if (getDeceased() != null) {
            _hashCode += getDeceased().hashCode();
        }
        if (getRid() != null) {
            _hashCode += getRid().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getHref() != null) {
            _hashCode += getHref().hashCode();
        }
        if (getRole2() != null) {
            _hashCode += getRole2().hashCode();
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
        new org.apache.axis.description.TypeDesc(Contrib.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contrib"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contribType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "contrib-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("corresp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "corresp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>contrib>corresp"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("equalContrib");
        attrField.setXmlName(new javax.xml.namespace.QName("", "equal-contrib"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>contrib>equal-contrib"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("deceased");
        attrField.setXmlName(new javax.xml.namespace.QName("", "deceased"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>contrib>deceased"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rid"));
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
        elemField.setFieldName("degrees");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "degrees"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">degrees"));
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
