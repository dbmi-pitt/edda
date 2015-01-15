/**
 * List.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class List  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ListItem[] listItem;

    private java.lang.Object id;  // attribute

    private java.lang.Object listType;  // attribute

    private java.lang.Object prefixWord;  // attribute

    private java.lang.Object listContent;  // attribute

    public List() {
    }

    public List(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ListItem[] listItem,
           java.lang.Object id,
           java.lang.Object listType,
           java.lang.Object prefixWord,
           java.lang.Object listContent) {
           this.label = label;
           this.title = title;
           this.listItem = listItem;
           this.id = id;
           this.listType = listType;
           this.prefixWord = prefixWord;
           this.listContent = listContent;
    }


    /**
     * Gets the label value for this List.
     * 
     * @return label
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label getLabel() {
        return label;
    }


    /**
     * Sets the label value for this List.
     * 
     * @param label
     */
    public void setLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label) {
        this.label = label;
    }


    /**
     * Gets the title value for this List.
     * 
     * @return title
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title getTitle() {
        return title;
    }


    /**
     * Sets the title value for this List.
     * 
     * @param title
     */
    public void setTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title) {
        this.title = title;
    }


    /**
     * Gets the listItem value for this List.
     * 
     * @return listItem
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ListItem[] getListItem() {
        return listItem;
    }


    /**
     * Sets the listItem value for this List.
     * 
     * @param listItem
     */
    public void setListItem(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ListItem[] listItem) {
        this.listItem = listItem;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ListItem getListItem(int i) {
        return this.listItem[i];
    }

    public void setListItem(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ListItem _value) {
        this.listItem[i] = _value;
    }


    /**
     * Gets the id value for this List.
     * 
     * @return id
     */
    public java.lang.Object getId() {
        return id;
    }


    /**
     * Sets the id value for this List.
     * 
     * @param id
     */
    public void setId(java.lang.Object id) {
        this.id = id;
    }


    /**
     * Gets the listType value for this List.
     * 
     * @return listType
     */
    public java.lang.Object getListType() {
        return listType;
    }


    /**
     * Sets the listType value for this List.
     * 
     * @param listType
     */
    public void setListType(java.lang.Object listType) {
        this.listType = listType;
    }


    /**
     * Gets the prefixWord value for this List.
     * 
     * @return prefixWord
     */
    public java.lang.Object getPrefixWord() {
        return prefixWord;
    }


    /**
     * Sets the prefixWord value for this List.
     * 
     * @param prefixWord
     */
    public void setPrefixWord(java.lang.Object prefixWord) {
        this.prefixWord = prefixWord;
    }


    /**
     * Gets the listContent value for this List.
     * 
     * @return listContent
     */
    public java.lang.Object getListContent() {
        return listContent;
    }


    /**
     * Sets the listContent value for this List.
     * 
     * @param listContent
     */
    public void setListContent(java.lang.Object listContent) {
        this.listContent = listContent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof List)) return false;
        List other = (List) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.listItem==null && other.getListItem()==null) || 
             (this.listItem!=null &&
              java.util.Arrays.equals(this.listItem, other.getListItem()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.listType==null && other.getListType()==null) || 
             (this.listType!=null &&
              this.listType.equals(other.getListType()))) &&
            ((this.prefixWord==null && other.getPrefixWord()==null) || 
             (this.prefixWord!=null &&
              this.prefixWord.equals(other.getPrefixWord()))) &&
            ((this.listContent==null && other.getListContent()==null) || 
             (this.listContent!=null &&
              this.listContent.equals(other.getListContent())));
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
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getListItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getListType() != null) {
            _hashCode += getListType().hashCode();
        }
        if (getPrefixWord() != null) {
            _hashCode += getPrefixWord().hashCode();
        }
        if (getListContent() != null) {
            _hashCode += getListContent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(List.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">list"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("listType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "list-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("prefixWord");
        attrField.setXmlName(new javax.xml.namespace.QName("", "prefix-word"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("listContent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "list-content"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">label"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">title"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "list-item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "list-item"));
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
