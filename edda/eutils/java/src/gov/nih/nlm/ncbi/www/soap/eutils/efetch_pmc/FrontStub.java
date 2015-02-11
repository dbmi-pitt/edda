/**
 * FrontStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class FrontStub  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] articleId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup titleGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup contribGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes authorNotes;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History history;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] _abstract;

    public FrontStub() {
    }

    public FrontStub(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] articleId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup titleGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup contribGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes authorNotes,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History history,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] _abstract) {
           this.articleId = articleId;
           this.titleGroup = titleGroup;
           this.contribGroup = contribGroup;
           this.aff = aff;
           this.x = x;
           this.authorNotes = authorNotes;
           this.fpage = fpage;
           this.lpage = lpage;
           this.pageRange = pageRange;
           this.elocationId = elocationId;
           this.history = history;
           this.permissions = permissions;
           this._abstract = _abstract;
    }


    /**
     * Gets the articleId value for this FrontStub.
     * 
     * @return articleId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] getArticleId() {
        return articleId;
    }


    /**
     * Sets the articleId value for this FrontStub.
     * 
     * @param articleId
     */
    public void setArticleId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] articleId) {
        this.articleId = articleId;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId getArticleId(int i) {
        return this.articleId[i];
    }

    public void setArticleId(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId _value) {
        this.articleId[i] = _value;
    }


    /**
     * Gets the titleGroup value for this FrontStub.
     * 
     * @return titleGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup getTitleGroup() {
        return titleGroup;
    }


    /**
     * Sets the titleGroup value for this FrontStub.
     * 
     * @param titleGroup
     */
    public void setTitleGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup titleGroup) {
        this.titleGroup = titleGroup;
    }


    /**
     * Gets the contribGroup value for this FrontStub.
     * 
     * @return contribGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup getContribGroup() {
        return contribGroup;
    }


    /**
     * Sets the contribGroup value for this FrontStub.
     * 
     * @param contribGroup
     */
    public void setContribGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup contribGroup) {
        this.contribGroup = contribGroup;
    }


    /**
     * Gets the aff value for this FrontStub.
     * 
     * @return aff
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff getAff() {
        return aff;
    }


    /**
     * Sets the aff value for this FrontStub.
     * 
     * @param aff
     */
    public void setAff(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff) {
        this.aff = aff;
    }


    /**
     * Gets the x value for this FrontStub.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this FrontStub.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the authorNotes value for this FrontStub.
     * 
     * @return authorNotes
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes getAuthorNotes() {
        return authorNotes;
    }


    /**
     * Sets the authorNotes value for this FrontStub.
     * 
     * @param authorNotes
     */
    public void setAuthorNotes(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes authorNotes) {
        this.authorNotes = authorNotes;
    }


    /**
     * Gets the fpage value for this FrontStub.
     * 
     * @return fpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage getFpage() {
        return fpage;
    }


    /**
     * Sets the fpage value for this FrontStub.
     * 
     * @param fpage
     */
    public void setFpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage) {
        this.fpage = fpage;
    }


    /**
     * Gets the lpage value for this FrontStub.
     * 
     * @return lpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage getLpage() {
        return lpage;
    }


    /**
     * Sets the lpage value for this FrontStub.
     * 
     * @param lpage
     */
    public void setLpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage) {
        this.lpage = lpage;
    }


    /**
     * Gets the pageRange value for this FrontStub.
     * 
     * @return pageRange
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange getPageRange() {
        return pageRange;
    }


    /**
     * Sets the pageRange value for this FrontStub.
     * 
     * @param pageRange
     */
    public void setPageRange(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange) {
        this.pageRange = pageRange;
    }


    /**
     * Gets the elocationId value for this FrontStub.
     * 
     * @return elocationId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId getElocationId() {
        return elocationId;
    }


    /**
     * Sets the elocationId value for this FrontStub.
     * 
     * @param elocationId
     */
    public void setElocationId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId) {
        this.elocationId = elocationId;
    }


    /**
     * Gets the history value for this FrontStub.
     * 
     * @return history
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History getHistory() {
        return history;
    }


    /**
     * Sets the history value for this FrontStub.
     * 
     * @param history
     */
    public void setHistory(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History history) {
        this.history = history;
    }


    /**
     * Gets the permissions value for this FrontStub.
     * 
     * @return permissions
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this FrontStub.
     * 
     * @param permissions
     */
    public void setPermissions(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
        this.permissions = permissions;
    }


    /**
     * Gets the _abstract value for this FrontStub.
     * 
     * @return _abstract
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] get_abstract() {
        return _abstract;
    }


    /**
     * Sets the _abstract value for this FrontStub.
     * 
     * @param _abstract
     */
    public void set_abstract(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] _abstract) {
        this._abstract = _abstract;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract get_abstract(int i) {
        return this._abstract[i];
    }

    public void set_abstract(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract _value) {
        this._abstract[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FrontStub)) return false;
        FrontStub other = (FrontStub) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.articleId==null && other.getArticleId()==null) || 
             (this.articleId!=null &&
              java.util.Arrays.equals(this.articleId, other.getArticleId()))) &&
            ((this.titleGroup==null && other.getTitleGroup()==null) || 
             (this.titleGroup!=null &&
              this.titleGroup.equals(other.getTitleGroup()))) &&
            ((this.contribGroup==null && other.getContribGroup()==null) || 
             (this.contribGroup!=null &&
              this.contribGroup.equals(other.getContribGroup()))) &&
            ((this.aff==null && other.getAff()==null) || 
             (this.aff!=null &&
              this.aff.equals(other.getAff()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this.authorNotes==null && other.getAuthorNotes()==null) || 
             (this.authorNotes!=null &&
              this.authorNotes.equals(other.getAuthorNotes()))) &&
            ((this.fpage==null && other.getFpage()==null) || 
             (this.fpage!=null &&
              this.fpage.equals(other.getFpage()))) &&
            ((this.lpage==null && other.getLpage()==null) || 
             (this.lpage!=null &&
              this.lpage.equals(other.getLpage()))) &&
            ((this.pageRange==null && other.getPageRange()==null) || 
             (this.pageRange!=null &&
              this.pageRange.equals(other.getPageRange()))) &&
            ((this.elocationId==null && other.getElocationId()==null) || 
             (this.elocationId!=null &&
              this.elocationId.equals(other.getElocationId()))) &&
            ((this.history==null && other.getHistory()==null) || 
             (this.history!=null &&
              this.history.equals(other.getHistory()))) &&
            ((this.permissions==null && other.getPermissions()==null) || 
             (this.permissions!=null &&
              this.permissions.equals(other.getPermissions()))) &&
            ((this._abstract==null && other.get_abstract()==null) || 
             (this._abstract!=null &&
              java.util.Arrays.equals(this._abstract, other.get_abstract())));
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
        if (getArticleId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArticleId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArticleId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTitleGroup() != null) {
            _hashCode += getTitleGroup().hashCode();
        }
        if (getContribGroup() != null) {
            _hashCode += getContribGroup().hashCode();
        }
        if (getAff() != null) {
            _hashCode += getAff().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (getAuthorNotes() != null) {
            _hashCode += getAuthorNotes().hashCode();
        }
        if (getFpage() != null) {
            _hashCode += getFpage().hashCode();
        }
        if (getLpage() != null) {
            _hashCode += getLpage().hashCode();
        }
        if (getPageRange() != null) {
            _hashCode += getPageRange().hashCode();
        }
        if (getElocationId() != null) {
            _hashCode += getElocationId().hashCode();
        }
        if (getHistory() != null) {
            _hashCode += getHistory().hashCode();
        }
        if (getPermissions() != null) {
            _hashCode += getPermissions().hashCode();
        }
        if (get_abstract() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_abstract());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_abstract(), i);
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
        new org.apache.axis.description.TypeDesc(FrontStub.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">front-stub"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titleGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "title-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">title-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contribGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contrib-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contrib-group"));
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
        elemField.setFieldName("x");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "x"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">x"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorNotes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "author-notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">author-notes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fpage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fpage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fpage"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lpage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "lpage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">lpage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageRange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "page-range"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">page-range"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elocationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "elocation-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">elocation-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "history"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">history"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_abstract");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "abstract"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "abstract"));
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
