/**
 * LiteRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomsonreuters.wokmws.cxf.woksearchlite;

public class LiteRecord  implements java.io.Serializable {
    private com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] authors;

    private com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] keywords;

    private com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] other;

    private com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] source;

    private com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] title;

    private java.lang.String UT;

    public LiteRecord() {
    }

    public LiteRecord(
           com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] authors,
           com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] keywords,
           com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] other,
           com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] source,
           com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] title,
           java.lang.String UT) {
           this.authors = authors;
           this.keywords = keywords;
           this.other = other;
           this.source = source;
           this.title = title;
           this.UT = UT;
    }


    /**
     * Gets the authors value for this LiteRecord.
     * 
     * @return authors
     */
    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] getAuthors() {
        return authors;
    }


    /**
     * Sets the authors value for this LiteRecord.
     * 
     * @param authors
     */
    public void setAuthors(com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] authors) {
        this.authors = authors;
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair getAuthors(int i) {
        return this.authors[i];
    }

    public void setAuthors(int i, com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair _value) {
        this.authors[i] = _value;
    }


    /**
     * Gets the keywords value for this LiteRecord.
     * 
     * @return keywords
     */
    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this LiteRecord.
     * 
     * @param keywords
     */
    public void setKeywords(com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] keywords) {
        this.keywords = keywords;
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair getKeywords(int i) {
        return this.keywords[i];
    }

    public void setKeywords(int i, com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair _value) {
        this.keywords[i] = _value;
    }


    /**
     * Gets the other value for this LiteRecord.
     * 
     * @return other
     */
    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] getOther() {
        return other;
    }


    /**
     * Sets the other value for this LiteRecord.
     * 
     * @param other
     */
    public void setOther(com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] other) {
        this.other = other;
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair getOther(int i) {
        return this.other[i];
    }

    public void setOther(int i, com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair _value) {
        this.other[i] = _value;
    }


    /**
     * Gets the source value for this LiteRecord.
     * 
     * @return source
     */
    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] getSource() {
        return source;
    }


    /**
     * Sets the source value for this LiteRecord.
     * 
     * @param source
     */
    public void setSource(com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] source) {
        this.source = source;
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair getSource(int i) {
        return this.source[i];
    }

    public void setSource(int i, com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair _value) {
        this.source[i] = _value;
    }


    /**
     * Gets the title value for this LiteRecord.
     * 
     * @return title
     */
    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] getTitle() {
        return title;
    }


    /**
     * Sets the title value for this LiteRecord.
     * 
     * @param title
     */
    public void setTitle(com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair[] title) {
        this.title = title;
    }

    public com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair getTitle(int i) {
        return this.title[i];
    }

    public void setTitle(int i, com.thomsonreuters.wokmws.cxf.woksearchlite.LabelValuesPair _value) {
        this.title[i] = _value;
    }


    /**
     * Gets the UT value for this LiteRecord.
     * 
     * @return UT
     */
    public java.lang.String getUT() {
        return UT;
    }


    /**
     * Sets the UT value for this LiteRecord.
     * 
     * @param UT
     */
    public void setUT(java.lang.String UT) {
        this.UT = UT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LiteRecord)) return false;
        LiteRecord other = (LiteRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authors==null && other.getAuthors()==null) || 
             (this.authors!=null &&
              java.util.Arrays.equals(this.authors, other.getAuthors()))) &&
            ((this.keywords==null && other.getKeywords()==null) || 
             (this.keywords!=null &&
              java.util.Arrays.equals(this.keywords, other.getKeywords()))) &&
            ((this.other==null && other.getOther()==null) || 
             (this.other!=null &&
              java.util.Arrays.equals(this.other, other.getOther()))) &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              java.util.Arrays.equals(this.source, other.getSource()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              java.util.Arrays.equals(this.title, other.getTitle()))) &&
            ((this.UT==null && other.getUT()==null) || 
             (this.UT!=null &&
              this.UT.equals(other.getUT())));
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
        if (getAuthors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuthors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuthors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getKeywords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOther() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOther());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOther(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSource() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSource());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSource(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTitle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTitle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTitle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUT() != null) {
            _hashCode += getUT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LiteRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "liteRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "keywords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("other");
        elemField.setXmlName(new javax.xml.namespace.QName("", "other"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://woksearchlite.cxf.wokmws.thomsonreuters.com", "labelValuesPair"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UT"));
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
