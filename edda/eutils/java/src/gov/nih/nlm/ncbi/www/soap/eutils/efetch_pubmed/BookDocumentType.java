/**
 * BookDocumentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class BookDocumentType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleIdType[] articleIdList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookType book;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType[] locationLabel;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType articleTitle;

    private java.lang.String vernacularTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType pagination;

    private java.lang.String[] language;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[][] authorList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GroupList groupList;

    private java.lang.String[] publicationType;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType _abstract;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] sections;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] keywordList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ContributionDateType contributionDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType dateRevised;

    private java.lang.String citationString;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] grantList;

    public BookDocumentType() {
    }

    public BookDocumentType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleIdType[] articleIdList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookType book,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType[] locationLabel,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType articleTitle,
           java.lang.String vernacularTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType pagination,
           java.lang.String[] language,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[][] authorList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GroupList groupList,
           java.lang.String[] publicationType,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType _abstract,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] sections,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] keywordList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ContributionDateType contributionDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType dateRevised,
           java.lang.String citationString,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] grantList) {
           this.PMID = PMID;
           this.articleIdList = articleIdList;
           this.book = book;
           this.locationLabel = locationLabel;
           this.articleTitle = articleTitle;
           this.vernacularTitle = vernacularTitle;
           this.pagination = pagination;
           this.language = language;
           this.authorList = authorList;
           this.groupList = groupList;
           this.publicationType = publicationType;
           this._abstract = _abstract;
           this.sections = sections;
           this.keywordList = keywordList;
           this.contributionDate = contributionDate;
           this.dateRevised = dateRevised;
           this.citationString = citationString;
           this.grantList = grantList;
    }


    /**
     * Gets the PMID value for this BookDocumentType.
     * 
     * @return PMID
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType getPMID() {
        return PMID;
    }


    /**
     * Sets the PMID value for this BookDocumentType.
     * 
     * @param PMID
     */
    public void setPMID(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID) {
        this.PMID = PMID;
    }


    /**
     * Gets the articleIdList value for this BookDocumentType.
     * 
     * @return articleIdList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleIdType[] getArticleIdList() {
        return articleIdList;
    }


    /**
     * Sets the articleIdList value for this BookDocumentType.
     * 
     * @param articleIdList
     */
    public void setArticleIdList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleIdType[] articleIdList) {
        this.articleIdList = articleIdList;
    }


    /**
     * Gets the book value for this BookDocumentType.
     * 
     * @return book
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookType getBook() {
        return book;
    }


    /**
     * Sets the book value for this BookDocumentType.
     * 
     * @param book
     */
    public void setBook(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookType book) {
        this.book = book;
    }


    /**
     * Gets the locationLabel value for this BookDocumentType.
     * 
     * @return locationLabel
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType[] getLocationLabel() {
        return locationLabel;
    }


    /**
     * Sets the locationLabel value for this BookDocumentType.
     * 
     * @param locationLabel
     */
    public void setLocationLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType[] locationLabel) {
        this.locationLabel = locationLabel;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType getLocationLabel(int i) {
        return this.locationLabel[i];
    }

    public void setLocationLabel(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.LocationLabelType _value) {
        this.locationLabel[i] = _value;
    }


    /**
     * Gets the articleTitle value for this BookDocumentType.
     * 
     * @return articleTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType getArticleTitle() {
        return articleTitle;
    }


    /**
     * Sets the articleTitle value for this BookDocumentType.
     * 
     * @param articleTitle
     */
    public void setArticleTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleTitleType articleTitle) {
        this.articleTitle = articleTitle;
    }


    /**
     * Gets the vernacularTitle value for this BookDocumentType.
     * 
     * @return vernacularTitle
     */
    public java.lang.String getVernacularTitle() {
        return vernacularTitle;
    }


    /**
     * Sets the vernacularTitle value for this BookDocumentType.
     * 
     * @param vernacularTitle
     */
    public void setVernacularTitle(java.lang.String vernacularTitle) {
        this.vernacularTitle = vernacularTitle;
    }


    /**
     * Gets the pagination value for this BookDocumentType.
     * 
     * @return pagination
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType getPagination() {
        return pagination;
    }


    /**
     * Sets the pagination value for this BookDocumentType.
     * 
     * @param pagination
     */
    public void setPagination(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PaginationType pagination) {
        this.pagination = pagination;
    }


    /**
     * Gets the language value for this BookDocumentType.
     * 
     * @return language
     */
    public java.lang.String[] getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this BookDocumentType.
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
     * Gets the authorList value for this BookDocumentType.
     * 
     * @return authorList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[][] getAuthorList() {
        return authorList;
    }


    /**
     * Sets the authorList value for this BookDocumentType.
     * 
     * @param authorList
     */
    public void setAuthorList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[][] authorList) {
        this.authorList = authorList;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[] getAuthorList(int i) {
        return this.authorList[i];
    }

    public void setAuthorList(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[] _value) {
        this.authorList[i] = _value;
    }


    /**
     * Gets the groupList value for this BookDocumentType.
     * 
     * @return groupList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GroupList getGroupList() {
        return groupList;
    }


    /**
     * Sets the groupList value for this BookDocumentType.
     * 
     * @param groupList
     */
    public void setGroupList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GroupList groupList) {
        this.groupList = groupList;
    }


    /**
     * Gets the publicationType value for this BookDocumentType.
     * 
     * @return publicationType
     */
    public java.lang.String[] getPublicationType() {
        return publicationType;
    }


    /**
     * Sets the publicationType value for this BookDocumentType.
     * 
     * @param publicationType
     */
    public void setPublicationType(java.lang.String[] publicationType) {
        this.publicationType = publicationType;
    }

    public java.lang.String getPublicationType(int i) {
        return this.publicationType[i];
    }

    public void setPublicationType(int i, java.lang.String _value) {
        this.publicationType[i] = _value;
    }


    /**
     * Gets the _abstract value for this BookDocumentType.
     * 
     * @return _abstract
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType get_abstract() {
        return _abstract;
    }


    /**
     * Sets the _abstract value for this BookDocumentType.
     * 
     * @param _abstract
     */
    public void set_abstract(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AbstractType _abstract) {
        this._abstract = _abstract;
    }


    /**
     * Gets the sections value for this BookDocumentType.
     * 
     * @return sections
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] getSections() {
        return sections;
    }


    /**
     * Sets the sections value for this BookDocumentType.
     * 
     * @param sections
     */
    public void setSections(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SectionType[] sections) {
        this.sections = sections;
    }


    /**
     * Gets the keywordList value for this BookDocumentType.
     * 
     * @return keywordList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] getKeywordList() {
        return keywordList;
    }


    /**
     * Sets the keywordList value for this BookDocumentType.
     * 
     * @param keywordList
     */
    public void setKeywordList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] keywordList) {
        this.keywordList = keywordList;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[] getKeywordList(int i) {
        return this.keywordList[i];
    }

    public void setKeywordList(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[] _value) {
        this.keywordList[i] = _value;
    }


    /**
     * Gets the contributionDate value for this BookDocumentType.
     * 
     * @return contributionDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ContributionDateType getContributionDate() {
        return contributionDate;
    }


    /**
     * Sets the contributionDate value for this BookDocumentType.
     * 
     * @param contributionDate
     */
    public void setContributionDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ContributionDateType contributionDate) {
        this.contributionDate = contributionDate;
    }


    /**
     * Gets the dateRevised value for this BookDocumentType.
     * 
     * @return dateRevised
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType getDateRevised() {
        return dateRevised;
    }


    /**
     * Sets the dateRevised value for this BookDocumentType.
     * 
     * @param dateRevised
     */
    public void setDateRevised(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType dateRevised) {
        this.dateRevised = dateRevised;
    }


    /**
     * Gets the citationString value for this BookDocumentType.
     * 
     * @return citationString
     */
    public java.lang.String getCitationString() {
        return citationString;
    }


    /**
     * Sets the citationString value for this BookDocumentType.
     * 
     * @param citationString
     */
    public void setCitationString(java.lang.String citationString) {
        this.citationString = citationString;
    }


    /**
     * Gets the grantList value for this BookDocumentType.
     * 
     * @return grantList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] getGrantList() {
        return grantList;
    }


    /**
     * Sets the grantList value for this BookDocumentType.
     * 
     * @param grantList
     */
    public void setGrantList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GrantType[] grantList) {
        this.grantList = grantList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BookDocumentType)) return false;
        BookDocumentType other = (BookDocumentType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PMID==null && other.getPMID()==null) || 
             (this.PMID!=null &&
              this.PMID.equals(other.getPMID()))) &&
            ((this.articleIdList==null && other.getArticleIdList()==null) || 
             (this.articleIdList!=null &&
              java.util.Arrays.equals(this.articleIdList, other.getArticleIdList()))) &&
            ((this.book==null && other.getBook()==null) || 
             (this.book!=null &&
              this.book.equals(other.getBook()))) &&
            ((this.locationLabel==null && other.getLocationLabel()==null) || 
             (this.locationLabel!=null &&
              java.util.Arrays.equals(this.locationLabel, other.getLocationLabel()))) &&
            ((this.articleTitle==null && other.getArticleTitle()==null) || 
             (this.articleTitle!=null &&
              this.articleTitle.equals(other.getArticleTitle()))) &&
            ((this.vernacularTitle==null && other.getVernacularTitle()==null) || 
             (this.vernacularTitle!=null &&
              this.vernacularTitle.equals(other.getVernacularTitle()))) &&
            ((this.pagination==null && other.getPagination()==null) || 
             (this.pagination!=null &&
              this.pagination.equals(other.getPagination()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              java.util.Arrays.equals(this.language, other.getLanguage()))) &&
            ((this.authorList==null && other.getAuthorList()==null) || 
             (this.authorList!=null &&
              java.util.Arrays.equals(this.authorList, other.getAuthorList()))) &&
            ((this.groupList==null && other.getGroupList()==null) || 
             (this.groupList!=null &&
              this.groupList.equals(other.getGroupList()))) &&
            ((this.publicationType==null && other.getPublicationType()==null) || 
             (this.publicationType!=null &&
              java.util.Arrays.equals(this.publicationType, other.getPublicationType()))) &&
            ((this._abstract==null && other.get_abstract()==null) || 
             (this._abstract!=null &&
              this._abstract.equals(other.get_abstract()))) &&
            ((this.sections==null && other.getSections()==null) || 
             (this.sections!=null &&
              java.util.Arrays.equals(this.sections, other.getSections()))) &&
            ((this.keywordList==null && other.getKeywordList()==null) || 
             (this.keywordList!=null &&
              java.util.Arrays.equals(this.keywordList, other.getKeywordList()))) &&
            ((this.contributionDate==null && other.getContributionDate()==null) || 
             (this.contributionDate!=null &&
              this.contributionDate.equals(other.getContributionDate()))) &&
            ((this.dateRevised==null && other.getDateRevised()==null) || 
             (this.dateRevised!=null &&
              this.dateRevised.equals(other.getDateRevised()))) &&
            ((this.citationString==null && other.getCitationString()==null) || 
             (this.citationString!=null &&
              this.citationString.equals(other.getCitationString()))) &&
            ((this.grantList==null && other.getGrantList()==null) || 
             (this.grantList!=null &&
              java.util.Arrays.equals(this.grantList, other.getGrantList())));
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
        if (getPMID() != null) {
            _hashCode += getPMID().hashCode();
        }
        if (getArticleIdList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArticleIdList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArticleIdList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBook() != null) {
            _hashCode += getBook().hashCode();
        }
        if (getLocationLabel() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLocationLabel());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLocationLabel(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArticleTitle() != null) {
            _hashCode += getArticleTitle().hashCode();
        }
        if (getVernacularTitle() != null) {
            _hashCode += getVernacularTitle().hashCode();
        }
        if (getPagination() != null) {
            _hashCode += getPagination().hashCode();
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
        if (getGroupList() != null) {
            _hashCode += getGroupList().hashCode();
        }
        if (getPublicationType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublicationType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublicationType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (get_abstract() != null) {
            _hashCode += get_abstract().hashCode();
        }
        if (getSections() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSections());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSections(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getKeywordList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywordList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywordList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContributionDate() != null) {
            _hashCode += getContributionDate().hashCode();
        }
        if (getDateRevised() != null) {
            _hashCode += getDateRevised().hashCode();
        }
        if (getCitationString() != null) {
            _hashCode += getCitationString().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BookDocumentType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BookDocumentType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PMID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PMID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PMIDType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleIdList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleIdList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleIdType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleId"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("book");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Book"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BookType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locationLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "LocationLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "LocationLabelType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleTitleType"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("pagination");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Pagination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PaginationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Language"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Language"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AuthorList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "AuthorListType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GroupList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">GroupList"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PublicationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PublicationType"));
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
        elemField.setFieldName("sections");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Sections"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SectionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Section"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "KeywordList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "KeywordListType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ContributionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ContributionDateType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateRevised");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateRevised"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateRevisedType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citationString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CitationString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grantList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GrantList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GrantType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Grant"));
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
