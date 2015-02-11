/**
 * SubArticle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class SubArticle  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Front front;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FrontStub frontStub;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Body body;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Back back;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FloatsWrap floatsWrap;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArticle[] subArticle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Response[] response;

    private java.lang.Object articleType;  // attribute

    private java.lang.String id;  // attribute

    public SubArticle() {
    }

    public SubArticle(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Front front,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FrontStub frontStub,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Body body,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Back back,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FloatsWrap floatsWrap,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArticle[] subArticle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Response[] response,
           java.lang.Object articleType,
           java.lang.String id) {
           this.front = front;
           this.frontStub = frontStub;
           this.body = body;
           this.back = back;
           this.floatsWrap = floatsWrap;
           this.subArticle = subArticle;
           this.response = response;
           this.articleType = articleType;
           this.id = id;
    }


    /**
     * Gets the front value for this SubArticle.
     * 
     * @return front
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Front getFront() {
        return front;
    }


    /**
     * Sets the front value for this SubArticle.
     * 
     * @param front
     */
    public void setFront(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Front front) {
        this.front = front;
    }


    /**
     * Gets the frontStub value for this SubArticle.
     * 
     * @return frontStub
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FrontStub getFrontStub() {
        return frontStub;
    }


    /**
     * Sets the frontStub value for this SubArticle.
     * 
     * @param frontStub
     */
    public void setFrontStub(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FrontStub frontStub) {
        this.frontStub = frontStub;
    }


    /**
     * Gets the body value for this SubArticle.
     * 
     * @return body
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Body getBody() {
        return body;
    }


    /**
     * Sets the body value for this SubArticle.
     * 
     * @param body
     */
    public void setBody(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Body body) {
        this.body = body;
    }


    /**
     * Gets the back value for this SubArticle.
     * 
     * @return back
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Back getBack() {
        return back;
    }


    /**
     * Sets the back value for this SubArticle.
     * 
     * @param back
     */
    public void setBack(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Back back) {
        this.back = back;
    }


    /**
     * Gets the floatsWrap value for this SubArticle.
     * 
     * @return floatsWrap
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FloatsWrap getFloatsWrap() {
        return floatsWrap;
    }


    /**
     * Sets the floatsWrap value for this SubArticle.
     * 
     * @param floatsWrap
     */
    public void setFloatsWrap(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FloatsWrap floatsWrap) {
        this.floatsWrap = floatsWrap;
    }


    /**
     * Gets the subArticle value for this SubArticle.
     * 
     * @return subArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArticle[] getSubArticle() {
        return subArticle;
    }


    /**
     * Sets the subArticle value for this SubArticle.
     * 
     * @param subArticle
     */
    public void setSubArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArticle[] subArticle) {
        this.subArticle = subArticle;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArticle getSubArticle(int i) {
        return this.subArticle[i];
    }

    public void setSubArticle(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArticle _value) {
        this.subArticle[i] = _value;
    }


    /**
     * Gets the response value for this SubArticle.
     * 
     * @return response
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Response[] getResponse() {
        return response;
    }


    /**
     * Sets the response value for this SubArticle.
     * 
     * @param response
     */
    public void setResponse(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Response[] response) {
        this.response = response;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Response getResponse(int i) {
        return this.response[i];
    }

    public void setResponse(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Response _value) {
        this.response[i] = _value;
    }


    /**
     * Gets the articleType value for this SubArticle.
     * 
     * @return articleType
     */
    public java.lang.Object getArticleType() {
        return articleType;
    }


    /**
     * Sets the articleType value for this SubArticle.
     * 
     * @param articleType
     */
    public void setArticleType(java.lang.Object articleType) {
        this.articleType = articleType;
    }


    /**
     * Gets the id value for this SubArticle.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this SubArticle.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubArticle)) return false;
        SubArticle other = (SubArticle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.front==null && other.getFront()==null) || 
             (this.front!=null &&
              this.front.equals(other.getFront()))) &&
            ((this.frontStub==null && other.getFrontStub()==null) || 
             (this.frontStub!=null &&
              this.frontStub.equals(other.getFrontStub()))) &&
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody()))) &&
            ((this.back==null && other.getBack()==null) || 
             (this.back!=null &&
              this.back.equals(other.getBack()))) &&
            ((this.floatsWrap==null && other.getFloatsWrap()==null) || 
             (this.floatsWrap!=null &&
              this.floatsWrap.equals(other.getFloatsWrap()))) &&
            ((this.subArticle==null && other.getSubArticle()==null) || 
             (this.subArticle!=null &&
              java.util.Arrays.equals(this.subArticle, other.getSubArticle()))) &&
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              java.util.Arrays.equals(this.response, other.getResponse()))) &&
            ((this.articleType==null && other.getArticleType()==null) || 
             (this.articleType!=null &&
              this.articleType.equals(other.getArticleType()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId())));
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
        if (getFront() != null) {
            _hashCode += getFront().hashCode();
        }
        if (getFrontStub() != null) {
            _hashCode += getFrontStub().hashCode();
        }
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getBack() != null) {
            _hashCode += getBack().hashCode();
        }
        if (getFloatsWrap() != null) {
            _hashCode += getFloatsWrap().hashCode();
        }
        if (getSubArticle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubArticle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubArticle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResponse() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResponse());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResponse(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArticleType() != null) {
            _hashCode += getArticleType().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubArticle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sub-article"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("articleType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "article-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("front");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "front"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">front"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frontStub");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "front-stub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">front-stub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "body"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">body"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("back");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "back"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">back"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("floatsWrap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "floats-wrap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">floats-wrap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subArticle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sub-article"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sub-article"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "response"));
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
