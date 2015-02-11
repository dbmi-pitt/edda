/**
 * BookType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class BookType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PublisherType publisher;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookTitleType bookTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubDateType pubDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BeginningDateType beginningDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EndingDateType endingDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[][] authorList;

    private java.lang.String volume;

    private java.lang.String volumeTitle;

    private java.lang.String edition;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CollectionTitleType collectionTitle;

    private java.lang.String[] isbn;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID;

    private java.lang.String medium;

    private java.lang.String reportNumber;

    public BookType() {
    }

    public BookType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PublisherType publisher,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookTitleType bookTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubDateType pubDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BeginningDateType beginningDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EndingDateType endingDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[][] authorList,
           java.lang.String volume,
           java.lang.String volumeTitle,
           java.lang.String edition,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CollectionTitleType collectionTitle,
           java.lang.String[] isbn,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] ELocationID,
           java.lang.String medium,
           java.lang.String reportNumber) {
           this.publisher = publisher;
           this.bookTitle = bookTitle;
           this.pubDate = pubDate;
           this.beginningDate = beginningDate;
           this.endingDate = endingDate;
           this.authorList = authorList;
           this.volume = volume;
           this.volumeTitle = volumeTitle;
           this.edition = edition;
           this.collectionTitle = collectionTitle;
           this.isbn = isbn;
           this.ELocationID = ELocationID;
           this.medium = medium;
           this.reportNumber = reportNumber;
    }


    /**
     * Gets the publisher value for this BookType.
     * 
     * @return publisher
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PublisherType getPublisher() {
        return publisher;
    }


    /**
     * Sets the publisher value for this BookType.
     * 
     * @param publisher
     */
    public void setPublisher(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PublisherType publisher) {
        this.publisher = publisher;
    }


    /**
     * Gets the bookTitle value for this BookType.
     * 
     * @return bookTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookTitleType getBookTitle() {
        return bookTitle;
    }


    /**
     * Sets the bookTitle value for this BookType.
     * 
     * @param bookTitle
     */
    public void setBookTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BookTitleType bookTitle) {
        this.bookTitle = bookTitle;
    }


    /**
     * Gets the pubDate value for this BookType.
     * 
     * @return pubDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubDateType getPubDate() {
        return pubDate;
    }


    /**
     * Sets the pubDate value for this BookType.
     * 
     * @param pubDate
     */
    public void setPubDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PubDateType pubDate) {
        this.pubDate = pubDate;
    }


    /**
     * Gets the beginningDate value for this BookType.
     * 
     * @return beginningDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BeginningDateType getBeginningDate() {
        return beginningDate;
    }


    /**
     * Sets the beginningDate value for this BookType.
     * 
     * @param beginningDate
     */
    public void setBeginningDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.BeginningDateType beginningDate) {
        this.beginningDate = beginningDate;
    }


    /**
     * Gets the endingDate value for this BookType.
     * 
     * @return endingDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EndingDateType getEndingDate() {
        return endingDate;
    }


    /**
     * Sets the endingDate value for this BookType.
     * 
     * @param endingDate
     */
    public void setEndingDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EndingDateType endingDate) {
        this.endingDate = endingDate;
    }


    /**
     * Gets the authorList value for this BookType.
     * 
     * @return authorList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.AuthorType[][] getAuthorList() {
        return authorList;
    }


    /**
     * Sets the authorList value for this BookType.
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
     * Gets the volume value for this BookType.
     * 
     * @return volume
     */
    public java.lang.String getVolume() {
        return volume;
    }


    /**
     * Sets the volume value for this BookType.
     * 
     * @param volume
     */
    public void setVolume(java.lang.String volume) {
        this.volume = volume;
    }


    /**
     * Gets the volumeTitle value for this BookType.
     * 
     * @return volumeTitle
     */
    public java.lang.String getVolumeTitle() {
        return volumeTitle;
    }


    /**
     * Sets the volumeTitle value for this BookType.
     * 
     * @param volumeTitle
     */
    public void setVolumeTitle(java.lang.String volumeTitle) {
        this.volumeTitle = volumeTitle;
    }


    /**
     * Gets the edition value for this BookType.
     * 
     * @return edition
     */
    public java.lang.String getEdition() {
        return edition;
    }


    /**
     * Sets the edition value for this BookType.
     * 
     * @param edition
     */
    public void setEdition(java.lang.String edition) {
        this.edition = edition;
    }


    /**
     * Gets the collectionTitle value for this BookType.
     * 
     * @return collectionTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CollectionTitleType getCollectionTitle() {
        return collectionTitle;
    }


    /**
     * Sets the collectionTitle value for this BookType.
     * 
     * @param collectionTitle
     */
    public void setCollectionTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CollectionTitleType collectionTitle) {
        this.collectionTitle = collectionTitle;
    }


    /**
     * Gets the isbn value for this BookType.
     * 
     * @return isbn
     */
    public java.lang.String[] getIsbn() {
        return isbn;
    }


    /**
     * Sets the isbn value for this BookType.
     * 
     * @param isbn
     */
    public void setIsbn(java.lang.String[] isbn) {
        this.isbn = isbn;
    }

    public java.lang.String getIsbn(int i) {
        return this.isbn[i];
    }

    public void setIsbn(int i, java.lang.String _value) {
        this.isbn[i] = _value;
    }


    /**
     * Gets the ELocationID value for this BookType.
     * 
     * @return ELocationID
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ELocationIDType[] getELocationID() {
        return ELocationID;
    }


    /**
     * Sets the ELocationID value for this BookType.
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
     * Gets the medium value for this BookType.
     * 
     * @return medium
     */
    public java.lang.String getMedium() {
        return medium;
    }


    /**
     * Sets the medium value for this BookType.
     * 
     * @param medium
     */
    public void setMedium(java.lang.String medium) {
        this.medium = medium;
    }


    /**
     * Gets the reportNumber value for this BookType.
     * 
     * @return reportNumber
     */
    public java.lang.String getReportNumber() {
        return reportNumber;
    }


    /**
     * Sets the reportNumber value for this BookType.
     * 
     * @param reportNumber
     */
    public void setReportNumber(java.lang.String reportNumber) {
        this.reportNumber = reportNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BookType)) return false;
        BookType other = (BookType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.publisher==null && other.getPublisher()==null) || 
             (this.publisher!=null &&
              this.publisher.equals(other.getPublisher()))) &&
            ((this.bookTitle==null && other.getBookTitle()==null) || 
             (this.bookTitle!=null &&
              this.bookTitle.equals(other.getBookTitle()))) &&
            ((this.pubDate==null && other.getPubDate()==null) || 
             (this.pubDate!=null &&
              this.pubDate.equals(other.getPubDate()))) &&
            ((this.beginningDate==null && other.getBeginningDate()==null) || 
             (this.beginningDate!=null &&
              this.beginningDate.equals(other.getBeginningDate()))) &&
            ((this.endingDate==null && other.getEndingDate()==null) || 
             (this.endingDate!=null &&
              this.endingDate.equals(other.getEndingDate()))) &&
            ((this.authorList==null && other.getAuthorList()==null) || 
             (this.authorList!=null &&
              java.util.Arrays.equals(this.authorList, other.getAuthorList()))) &&
            ((this.volume==null && other.getVolume()==null) || 
             (this.volume!=null &&
              this.volume.equals(other.getVolume()))) &&
            ((this.volumeTitle==null && other.getVolumeTitle()==null) || 
             (this.volumeTitle!=null &&
              this.volumeTitle.equals(other.getVolumeTitle()))) &&
            ((this.edition==null && other.getEdition()==null) || 
             (this.edition!=null &&
              this.edition.equals(other.getEdition()))) &&
            ((this.collectionTitle==null && other.getCollectionTitle()==null) || 
             (this.collectionTitle!=null &&
              this.collectionTitle.equals(other.getCollectionTitle()))) &&
            ((this.isbn==null && other.getIsbn()==null) || 
             (this.isbn!=null &&
              java.util.Arrays.equals(this.isbn, other.getIsbn()))) &&
            ((this.ELocationID==null && other.getELocationID()==null) || 
             (this.ELocationID!=null &&
              java.util.Arrays.equals(this.ELocationID, other.getELocationID()))) &&
            ((this.medium==null && other.getMedium()==null) || 
             (this.medium!=null &&
              this.medium.equals(other.getMedium()))) &&
            ((this.reportNumber==null && other.getReportNumber()==null) || 
             (this.reportNumber!=null &&
              this.reportNumber.equals(other.getReportNumber())));
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
        if (getPublisher() != null) {
            _hashCode += getPublisher().hashCode();
        }
        if (getBookTitle() != null) {
            _hashCode += getBookTitle().hashCode();
        }
        if (getPubDate() != null) {
            _hashCode += getPubDate().hashCode();
        }
        if (getBeginningDate() != null) {
            _hashCode += getBeginningDate().hashCode();
        }
        if (getEndingDate() != null) {
            _hashCode += getEndingDate().hashCode();
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
        if (getVolume() != null) {
            _hashCode += getVolume().hashCode();
        }
        if (getVolumeTitle() != null) {
            _hashCode += getVolumeTitle().hashCode();
        }
        if (getEdition() != null) {
            _hashCode += getEdition().hashCode();
        }
        if (getCollectionTitle() != null) {
            _hashCode += getCollectionTitle().hashCode();
        }
        if (getIsbn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIsbn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIsbn(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getMedium() != null) {
            _hashCode += getMedium().hashCode();
        }
        if (getReportNumber() != null) {
            _hashCode += getReportNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BookType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BookType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisher");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Publisher"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PublisherType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BookTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BookTitleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PubDateType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beginningDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BeginningDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "BeginningDateType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endingDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "EndingDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "EndingDateType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("volume");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Volume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volumeTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "VolumeTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Edition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collectionTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CollectionTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CollectionTitleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isbn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Isbn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Isbn"));
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
        elemField.setFieldName("medium");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Medium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ReportNumber"));
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
