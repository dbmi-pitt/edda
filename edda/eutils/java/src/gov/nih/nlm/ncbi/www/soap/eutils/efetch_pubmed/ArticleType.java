/**
 * ArticleType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class ArticleType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalType journal;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType articleTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType pagination;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID2;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType _abstract;

    private java.lang.String affiliation;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[] authorList;

    private java.lang.String[] language;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DataBankType[] dataBankList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] grantList;

    private java.lang.String[] publicationTypeList;

    private java.lang.String vernacularTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleDateType[] articleDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTypePubModel pubModel;  // attribute

    public ArticleType() {
    }

    public ArticleType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalType journal,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType articleTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType pagination,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID2,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType _abstract,
           java.lang.String affiliation,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[] authorList,
           java.lang.String[] language,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DataBankType[] dataBankList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] grantList,
           java.lang.String[] publicationTypeList,
           java.lang.String vernacularTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleDateType[] articleDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTypePubModel pubModel) {
           this.journal = journal;
           this.articleTitle = articleTitle;
           this.pagination = pagination;
           this.ELocationID = ELocationID;
           this.ELocationID2 = ELocationID2;
           this._abstract = _abstract;
           this.affiliation = affiliation;
           this.authorList = authorList;
           this.language = language;
           this.dataBankList = dataBankList;
           this.grantList = grantList;
           this.publicationTypeList = publicationTypeList;
           this.vernacularTitle = vernacularTitle;
           this.articleDate = articleDate;
           this.pubModel = pubModel;
    }


    /**
     * Gets the journal value for this ArticleType.
     * 
     * @return journal
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalType getJournal() {
        return journal;
    }


    /**
     * Sets the journal value for this ArticleType.
     * 
     * @param journal
     */
    public void setJournal(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.JournalType journal) {
        this.journal = journal;
    }


    /**
     * Gets the articleTitle value for this ArticleType.
     * 
     * @return articleTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType getArticleTitle() {
        return articleTitle;
    }


    /**
     * Sets the articleTitle value for this ArticleType.
     * 
     * @param articleTitle
     */
    public void setArticleTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType articleTitle) {
        this.articleTitle = articleTitle;
    }


    /**
     * Gets the pagination value for this ArticleType.
     * 
     * @return pagination
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType getPagination() {
        return pagination;
    }


    /**
     * Sets the pagination value for this ArticleType.
     * 
     * @param pagination
     */
    public void setPagination(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType pagination) {
        this.pagination = pagination;
    }


    /**
     * Gets the ELocationID value for this ArticleType.
     * 
     * @return ELocationID
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] getELocationID() {
        return ELocationID;
    }


    /**
     * Sets the ELocationID value for this ArticleType.
     * 
     * @param ELocationID
     */
    public void setELocationID(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID) {
        this.ELocationID = ELocationID;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType getELocationID(int i) {
        return this.ELocationID[i];
    }

    public void setELocationID(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType _value) {
        this.ELocationID[i] = _value;
    }


    /**
     * Gets the ELocationID2 value for this ArticleType.
     * 
     * @return ELocationID2
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] getELocationID2() {
        return ELocationID2;
    }


    /**
     * Sets the ELocationID2 value for this ArticleType.
     * 
     * @param ELocationID2
     */
    public void setELocationID2(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID2) {
        this.ELocationID2 = ELocationID2;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType getELocationID2(int i) {
        return this.ELocationID2[i];
    }

    public void setELocationID2(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType _value) {
        this.ELocationID2[i] = _value;
    }


    /**
     * Gets the _abstract value for this ArticleType.
     * 
     * @return _abstract
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType get_abstract() {
        return _abstract;
    }


    /**
     * Sets the _abstract value for this ArticleType.
     * 
     * @param _abstract
     */
    public void set_abstract(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType _abstract) {
        this._abstract = _abstract;
    }


    /**
     * Gets the affiliation value for this ArticleType.
     * 
     * @return affiliation
     */
    public java.lang.String getAffiliation() {
        return affiliation;
    }


    /**
     * Sets the affiliation value for this ArticleType.
     * 
     * @param affiliation
     */
    public void setAffiliation(java.lang.String affiliation) {
        this.affiliation = affiliation;
    }


    /**
     * Gets the authorList value for this ArticleType.
     * 
     * @return authorList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[] getAuthorList() {
        return authorList;
    }


    /**
     * Sets the authorList value for this ArticleType.
     * 
     * @param authorList
     */
    public void setAuthorList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[] authorList) {
        this.authorList = authorList;
    }


    /**
     * Gets the language value for this ArticleType.
     * 
     * @return language
     */
    public java.lang.String[] getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this ArticleType.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String[] language) {
        this.language = language;
    }

    public java.lang.String getLanguage(int i) {
        return this.language[i];
    }

    public void setLanguage(int i, java.lang.String _value) {
        this.language[i] = _value;
    }


    /**
     * Gets the dataBankList value for this ArticleType.
     * 
     * @return dataBankList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DataBankType[] getDataBankList() {
        return dataBankList;
    }


    /**
     * Sets the dataBankList value for this ArticleType.
     * 
     * @param dataBankList
     */
    public void setDataBankList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DataBankType[] dataBankList) {
        this.dataBankList = dataBankList;
    }


    /**
     * Gets the grantList value for this ArticleType.
     * 
     * @return grantList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] getGrantList() {
        return grantList;
    }


    /**
     * Sets the grantList value for this ArticleType.
     * 
     * @param grantList
     */
    public void setGrantList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] grantList) {
        this.grantList = grantList;
    }


    /**
     * Gets the publicationTypeList value for this ArticleType.
     * 
     * @return publicationTypeList
     */
    public java.lang.String[] getPublicationTypeList() {
        return publicationTypeList;
    }


    /**
     * Sets the publicationTypeList value for this ArticleType.
     * 
     * @param publicationTypeList
     */
    public void setPublicationTypeList(java.lang.String[] publicationTypeList) {
        this.publicationTypeList = publicationTypeList;
    }


    /**
     * Gets the vernacularTitle value for this ArticleType.
     * 
     * @return vernacularTitle
     */
    public java.lang.String getVernacularTitle() {
        return vernacularTitle;
    }


    /**
     * Sets the vernacularTitle value for this ArticleType.
     * 
     * @param vernacularTitle
     */
    public void setVernacularTitle(java.lang.String vernacularTitle) {
        this.vernacularTitle = vernacularTitle;
    }


    /**
     * Gets the articleDate value for this ArticleType.
     * 
     * @return articleDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleDateType[] getArticleDate() {
        return articleDate;
    }


    /**
     * Sets the articleDate value for this ArticleType.
     * 
     * @param articleDate
     */
    public void setArticleDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleDateType[] articleDate) {
        this.articleDate = articleDate;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleDateType getArticleDate(int i) {
        return this.articleDate[i];
    }

    public void setArticleDate(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleDateType _value) {
        this.articleDate[i] = _value;
    }


    /**
     * Gets the pubModel value for this ArticleType.
     * 
     * @return pubModel
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTypePubModel getPubModel() {
        return pubModel;
    }


    /**
     * Sets the pubModel value for this ArticleType.
     * 
     * @param pubModel
     */
    public void setPubModel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTypePubModel pubModel) {
        this.pubModel = pubModel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArticleType)) return false;
        ArticleType other = (ArticleType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.journal==null && other.getJournal()==null) || 
             (this.journal!=null &&
              this.journal.equals(other.getJournal()))) &&
            ((this.articleTitle==null && other.getArticleTitle()==null) || 
             (this.articleTitle!=null &&
              this.articleTitle.equals(other.getArticleTitle()))) &&
            ((this.pagination==null && other.getPagination()==null) || 
             (this.pagination!=null &&
              this.pagination.equals(other.getPagination()))) &&
            ((this.ELocationID==null && other.getELocationID()==null) || 
             (this.ELocationID!=null &&
              java.util.Arrays.equals(this.ELocationID, other.getELocationID()))) &&
            ((this.ELocationID2==null && other.getELocationID2()==null) || 
             (this.ELocationID2!=null &&
              java.util.Arrays.equals(this.ELocationID2, other.getELocationID2()))) &&
            ((this._abstract==null && other.get_abstract()==null) || 
             (this._abstract!=null &&
              this._abstract.equals(other.get_abstract()))) &&
            ((this.affiliation==null && other.getAffiliation()==null) || 
             (this.affiliation!=null &&
              this.affiliation.equals(other.getAffiliation()))) &&
            ((this.authorList==null && other.getAuthorList()==null) || 
             (this.authorList!=null &&
              java.util.Arrays.equals(this.authorList, other.getAuthorList()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              java.util.Arrays.equals(this.language, other.getLanguage()))) &&
            ((this.dataBankList==null && other.getDataBankList()==null) || 
             (this.dataBankList!=null &&
              java.util.Arrays.equals(this.dataBankList, other.getDataBankList()))) &&
            ((this.grantList==null && other.getGrantList()==null) || 
             (this.grantList!=null &&
              java.util.Arrays.equals(this.grantList, other.getGrantList()))) &&
            ((this.publicationTypeList==null && other.getPublicationTypeList()==null) || 
             (this.publicationTypeList!=null &&
              java.util.Arrays.equals(this.publicationTypeList, other.getPublicationTypeList()))) &&
            ((this.vernacularTitle==null && other.getVernacularTitle()==null) || 
             (this.vernacularTitle!=null &&
              this.vernacularTitle.equals(other.getVernacularTitle()))) &&
            ((this.articleDate==null && other.getArticleDate()==null) || 
             (this.articleDate!=null &&
              java.util.Arrays.equals(this.articleDate, other.getArticleDate()))) &&
            ((this.pubModel==null && other.getPubModel()==null) || 
             (this.pubModel!=null &&
              this.pubModel.equals(other.getPubModel())));
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
        if (getJournal() != null) {
            _hashCode += getJournal().hashCode();
        }
        if (getArticleTitle() != null) {
            _hashCode += getArticleTitle().hashCode();
        }
        if (getPagination() != null) {
            _hashCode += getPagination().hashCode();
        }
        if (getELocationID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getELocationID());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getELocationID(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getELocationID2() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getELocationID2());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getELocationID2(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (get_abstract() != null) {
            _hashCode += get_abstract().hashCode();
        }
        if (getAffiliation() != null) {
            _hashCode += getAffiliation().hashCode();
        }
        if (getAuthorList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuthorList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuthorList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLanguage() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLanguage());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLanguage(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDataBankList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDataBankList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDataBankList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGrantList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrantList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrantList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPublicationTypeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublicationTypeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublicationTypeList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVernacularTitle() != null) {
            _hashCode += getVernacularTitle().hashCode();
        }
        if (getArticleDate() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArticleDate());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArticleDate(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPubModel() != null) {
            _hashCode += getPubModel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArticleType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pubModel");
        attrField.setXmlName(new javax.xml.namespace.QName("", "PubModel"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">ArticleType>PubModel"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("journal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Journal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "JournalType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleTitleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagination");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Pagination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PaginationType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ELocationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ELocationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ELocationIDType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ELocationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ELocationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ELocationIDType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_abstract");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Abstract"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AbstractType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affiliation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Affiliation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AuthorList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AuthorType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Author"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Language"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Language"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataBankList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DataBankList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DataBankType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DataBank"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grantList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GrantList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GrantType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Grant"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationTypeList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PublicationTypeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PublicationType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vernacularTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "VernacularTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleDateType"));
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
