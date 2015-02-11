/**
 * EUtilsServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils;

public class EUtilsPmcServiceSoapStub extends org.apache.axis.client.Stub implements gov.nih.nlm.ncbi.www.soap.eutils.EUtilsPmcServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[1];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("run_eFetch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "eFetchRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">eFetchRequest"), gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">eFetchResult"));
        oper.setReturnClass(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "eFetchResult"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

    }

    public EUtilsPmcServiceSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public EUtilsPmcServiceSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public EUtilsPmcServiceSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
        addBindings2();
        addBindings3();
        addBindings4();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>article>dtd-version");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleDtdVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>boxed-text>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedTextPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>chem-struct-wrapper>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapperPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>col>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>col>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>colgroup>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColgroupAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>colgroup>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ColgroupValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>contrib>corresp");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribCorresp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>contrib>deceased");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribDeceased.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>contrib>equal-contrib");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribEqualContrib.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>fig-group>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroupPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>fig>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>graphic>alt-version");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GraphicAltVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>graphic>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GraphicPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>media>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MediaPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>name>name-style");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NameNameStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>preformat>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PreformatPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>sub>arrange");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArrange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>sup>arrange");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupArrange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>supplementary-material>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterialPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>table-wrap-group>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroupPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>table-wrap>position");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>table>frame");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableFrame.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>table>rules");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableRules.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>tbody>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TbodyAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>tbody>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TbodyValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>td>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TdAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>td>scope");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TdScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>td>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TdValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>tex-math>notation");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMathNotation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>tfoot>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TfootAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>tfoot>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TfootValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>th>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ThAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>th>scope");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ThScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>th>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ThValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>thead>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TheadAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>thead>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TheadValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>tr>align");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TrAlign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>tr>valign");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TrValign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">abbrev");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">abbrev-journal-title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AbbrevJournalTitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">abstract");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">access-date");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ack");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">addr-line");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AddrLine.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">address");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Address.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">aff");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">alt-text");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltText.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">alt-title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AltTitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">annotation");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "p");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">anonymous");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Anonymous.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">app");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.App.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">app-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AppGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">array");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Array.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Article.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-categories");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleCategories.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-id");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-meta");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleMeta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">attrib");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">author-comment");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorComment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">author-notes");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">back");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Back.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">bio");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">body");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Body.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">bold");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">boxed-text");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedText.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">break");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._break.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">caption");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Caption.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">chem-struct");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">chem-struct-wrapper");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapper.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">citation");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Citation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">col");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Col.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">colgroup");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Col[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "col");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">collab");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">comment");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-acronym");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfAcronym.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-date");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-loc");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-name");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-num");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfNum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-sponsor");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-theme");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfTheme.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conference");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Conference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contract-num");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractNum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contract-sponsor");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractSponsor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contrib");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Contrib.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contrib-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">copyright-holder");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightHolder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">copyright-statement");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">copyright-year");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightYear.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">corresp");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Corresp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">country");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Country.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">counts");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Counts.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">custom-meta");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CustomMeta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">custom-meta-wrap");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CustomMeta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "custom-meta");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">date");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Date.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">day");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">def");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "p");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">def-head");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefHead.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">def-item");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">def-list");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">degrees");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Degrees.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">disp-formula");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispFormula.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">disp-quote");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">edition");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">eFetchRequest");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">eFetchResult");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">elocation-id");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">email");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">equation-count");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EquationCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">etal");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ext-link");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fax");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fax.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fig");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fig-count");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fig-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">floats-wrap");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FloatsWrap.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fn");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fn-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FnGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">font");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fpage");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">front");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Front.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">front-stub");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FrontStub.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">given-names");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GivenNames.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">gloss-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GlossGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">glossary");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Glossary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">glyph-data");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GlyphData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">glyph-ref");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GlyphRef.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">gov");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Gov.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">grant-num");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantNum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">grant-sponsor");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantSponsor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">graphic");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">history");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">hr");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">inline-formula");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">inline-graphic");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">inline-supplementary-material");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">institution");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Institution.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">isbn");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Isbn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issn");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issue");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issue-id");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issue-title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">italic");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">journal-id");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.JournalId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">journal-meta");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.JournalMeta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">journal-subtitle");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.JournalSubtitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">journal-title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.JournalTitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">kwd");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Kwd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">kwd-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">label");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">license");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "p");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">list");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">list-item");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ListItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">long-desc");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.LongDesc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">lpage");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">media");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">meta-name");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">meta-value");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MetaValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">milestone-end");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">milestone-start");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">monospace");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">month");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">name");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">named-content");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">nlm-citation");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NlmCitation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">note");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Note.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">notes");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Notes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">object-id");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">on-behalf-of");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OnBehalfOf.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">overline");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">overline-end");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">overline-start");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">p");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">page-count");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">page-range");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">patent");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">permissions");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">person-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">phone");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Phone.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">prefix");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Prefix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">preformat");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">price");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Price.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">private-char");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">product");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Product.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">pub-date");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">pub-id");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Publisher.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher-loc");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher-name");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ref");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ref.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ref-count");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RefCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ref-list");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RefList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">related-article");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">response");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">role");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sans-serif");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sc");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">season");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings2() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sec");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sec.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sec-meta");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SecMeta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">self-uri");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SelfUri.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">series");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">series-text");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SeriesText.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">series-title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SeriesTitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sig");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sig-block");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SigBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">size");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Size.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">source");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">speaker");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speaker.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">speech");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">statement");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">std");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Std.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">strike");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">string-date");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">string-name");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sub");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sub-article");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubArticle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">subj-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SubjGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">subject");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Subject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">subtitle");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Subtitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">suffix");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Suffix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sup");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">supplement");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">supplementary-material");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">surname");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Surname.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">table");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Table.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">table-count");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">table-wrap");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrap.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">table-wrap-foot");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapFoot.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">table-wrap-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">target");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">tbody");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Tr[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "tr");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">td");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Td.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">term");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Term.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">term-head");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TermHead.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">tex-math");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">tfoot");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Tr[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "tr");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">th");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Th.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">thead");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Tr[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "tr");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">time-stamp");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">title-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">tr");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Tr.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">trans-abstract");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransAbstract.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">trans-source");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">trans-subtitle");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSubtitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">trans-title");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">underline");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">underline-end");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">underline-start");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">uri");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">verse-group");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">verse-line");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseLine.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">volume");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">volume-id");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">word-count");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.WordCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">x");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">xref");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">year");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "any");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Any.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "IdListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "Id");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "pmc-articlesetType");
            cachedSerQNames.add(qName);
            cls = gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Article[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">alignmentscope");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">base");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.PositiveInteger.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">closure");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Closure.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">columnalign");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">display");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Display.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">edge");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Edge.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">form");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Form.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">frame");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Frame.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">groupalign");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Groupalign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">linebreak");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Linebreak.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">linethickness");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Linethickness.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">lspace");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Lspace.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">mathsize");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Mathsize.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">mathvariant");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Mathvariant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">maxsize");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Maxsize.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">minsize");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Minsize.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">notation");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Notation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">occurrence");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Occurrence.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">order");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Order.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">overflow");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Overflow.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">rowalign");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">rspace");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Rspace.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">side");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Side.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Type.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">width");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Width.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "annotation-xml.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.AnnotationXmlType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "annotation.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.AnnotationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "apply.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ApplyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "Arith.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ArithType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "bvar.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.BvarType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "card.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.CardType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "cartesianproduct.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.CartesianproductType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "centering");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Centering.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "ci.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.CiType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "cn.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.CnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "condition.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings3() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "Constant.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ConstantType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "csymbol.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.CsymbolType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "curl.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.CurlType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "declare.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.DeclareType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "degree.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.DegreeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "determinant.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.DeterminantType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "diff.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.DiffType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "divergence.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.DivergenceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "domainofapplication.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.DomainofapplicationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "Elementary-functions.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ElementaryFunctionsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "Functions.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.FunctionsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "grad.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.GradType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "in.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.InType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "infinity");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Infinity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "int.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.IntType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "intersect.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.IntersectType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "interval.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.IntervalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "inverse.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.InverseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "lambda.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.LambdaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "laplacian.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.LaplacianType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-optional-unit");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "limit.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.LimitType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "list.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ListType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "logbase.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.LogbaseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "Logic.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.LogicType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "lowlimit.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.LowlimitType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "maction.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MactionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "maligngroup.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MaligngroupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "malignmark.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MalignmarkType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "math.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MathType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "matrix.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MatrixType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "matrixrow.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MatrixrowType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mean.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MeanType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "median.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MedianType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "menclose.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MencloseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "merror.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MerrorType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mfenced.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MfencedType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mfrac.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MfracType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mglyph.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MglyphType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mi.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MiType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mlabeledtr.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MlabeledtrType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mmultiscripts.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MmultiscriptsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mn.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mo.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mode.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ModeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "moment.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MomentType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "momentabout.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MomentaboutType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mover.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MoverType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mpadded-space");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mpadded-width-space");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mpadded.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MpaddedType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mphantom.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MphantomType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mprescripts.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MprescriptsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mroot.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MrootType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mrow.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MrowType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "ms.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mspace.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MspaceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "msqrt.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MsqrtType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mstyle.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MstyleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "msub.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MsubType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "msubsup.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MsubsupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "msup.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MsupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mtable.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MtableType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mtd.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MtdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mtext.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MtextType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mtr.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MtrType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "munder.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MunderType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "munderover.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.MunderoverType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "named-space");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.NamedSpace.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "none.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.NoneType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "notin.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.NotinType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "notprsubset.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.NotprsubsetType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "notsubset.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.NotsubsetType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "otherwise.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.OtherwiseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "outerproduct.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.OuterproductType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "partialdiff.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.PartialdiffType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "piece.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.PieceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "piecewise.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.PiecewiseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "prsubset.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.PrsubsetType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "Relations.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.RelationsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "RGB-color");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "scalarproduct.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.ScalarproductType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "sdev.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SdevType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "selector.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SelectorType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "semantics.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SemanticsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "sep.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SepType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "set.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SetType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "setdiff.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SetdiffType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "simple-size");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SimpleSize.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "subset.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.SubsetType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "tendsto.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.TendstoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "thickness");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.Thickness.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "transpose.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.TransposeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "union.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.UnionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "uplimit.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.UplimitType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "variance.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.VarianceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "vector.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.VectorType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "vectorproduct.type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1998.Math.MathML.VectorproductType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">actuate");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1999.xlink.Actuate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }
    private void addBindings4() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">show");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1999.xlink.Show.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", ">type");
            cachedSerQNames.add(qName);
            cls = org.w3.www._1999.xlink.Type.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResult run_eFetch(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchRequest inpp) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("efetch");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "run_eFetch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inpp});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResult) org.apache.axis.utils.JavaUtils.convert(_resp, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
