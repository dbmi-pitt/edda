/**
 * BoxedText.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class BoxedText  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId[] objectId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SecMeta secMeta;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Array array;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedText boxedText;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct chemStruct;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapper chemStructWrapper;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fig fig;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroup figGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic graphic;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media media;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat preformat;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial supplementaryMaterial;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrap tableWrap;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroup tableWrapGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispFormula dispFormula;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P p;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList defList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List list;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath;

    private org.w3.www._1998.Math.MathML.MathType math;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack ack;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote dispQuote;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech speech;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement statement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sec[] sec;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Notes notes;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FnGroup fnGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Glossary glossary;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RefList refList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions;

    private java.lang.String id;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedTextPosition position;  // attribute

    private java.lang.Object contentType;  // attribute

    public BoxedText() {
    }

    public BoxedText(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId[] objectId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SecMeta secMeta,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Array array,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedText boxedText,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct chemStruct,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapper chemStructWrapper,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fig fig,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroup figGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic graphic,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media media,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat preformat,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial supplementaryMaterial,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrap tableWrap,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroup tableWrapGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispFormula dispFormula,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P p,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList defList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List list,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath,
           org.w3.www._1998.Math.MathML.MathType math,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack ack,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote dispQuote,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech speech,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement statement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sec[] sec,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Notes notes,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FnGroup fnGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Glossary glossary,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RefList refList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions,
           java.lang.String id,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedTextPosition position,
           java.lang.Object contentType) {
           this.objectId = objectId;
           this.secMeta = secMeta;
           this.label = label;
           this.title = title;
           this.array = array;
           this.boxedText = boxedText;
           this.chemStruct = chemStruct;
           this.chemStructWrapper = chemStructWrapper;
           this.fig = fig;
           this.figGroup = figGroup;
           this.graphic = graphic;
           this.media = media;
           this.preformat = preformat;
           this.supplementaryMaterial = supplementaryMaterial;
           this.tableWrap = tableWrap;
           this.tableWrapGroup = tableWrapGroup;
           this.dispFormula = dispFormula;
           this.p = p;
           this.defList = defList;
           this.list = list;
           this.texMath = texMath;
           this.math = math;
           this.relatedArticle = relatedArticle;
           this.ack = ack;
           this.dispQuote = dispQuote;
           this.speech = speech;
           this.statement = statement;
           this.verseGroup = verseGroup;
           this.x = x;
           this.sec = sec;
           this.notes = notes;
           this.fnGroup = fnGroup;
           this.glossary = glossary;
           this.refList = refList;
           this.attrib = attrib;
           this.copyrightStatement = copyrightStatement;
           this.permissions = permissions;
           this.id = id;
           this.position = position;
           this.contentType = contentType;
    }


    /**
     * Gets the objectId value for this BoxedText.
     * 
     * @return objectId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId[] getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this BoxedText.
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
     * Gets the secMeta value for this BoxedText.
     * 
     * @return secMeta
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SecMeta getSecMeta() {
        return secMeta;
    }


    /**
     * Sets the secMeta value for this BoxedText.
     * 
     * @param secMeta
     */
    public void setSecMeta(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SecMeta secMeta) {
        this.secMeta = secMeta;
    }


    /**
     * Gets the label value for this BoxedText.
     * 
     * @return label
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label getLabel() {
        return label;
    }


    /**
     * Sets the label value for this BoxedText.
     * 
     * @param label
     */
    public void setLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label) {
        this.label = label;
    }


    /**
     * Gets the title value for this BoxedText.
     * 
     * @return title
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title getTitle() {
        return title;
    }


    /**
     * Sets the title value for this BoxedText.
     * 
     * @param title
     */
    public void setTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Title title) {
        this.title = title;
    }


    /**
     * Gets the array value for this BoxedText.
     * 
     * @return array
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Array getArray() {
        return array;
    }


    /**
     * Sets the array value for this BoxedText.
     * 
     * @param array
     */
    public void setArray(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Array array) {
        this.array = array;
    }


    /**
     * Gets the boxedText value for this BoxedText.
     * 
     * @return boxedText
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedText getBoxedText() {
        return boxedText;
    }


    /**
     * Sets the boxedText value for this BoxedText.
     * 
     * @param boxedText
     */
    public void setBoxedText(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedText boxedText) {
        this.boxedText = boxedText;
    }


    /**
     * Gets the chemStruct value for this BoxedText.
     * 
     * @return chemStruct
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct getChemStruct() {
        return chemStruct;
    }


    /**
     * Sets the chemStruct value for this BoxedText.
     * 
     * @param chemStruct
     */
    public void setChemStruct(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct chemStruct) {
        this.chemStruct = chemStruct;
    }


    /**
     * Gets the chemStructWrapper value for this BoxedText.
     * 
     * @return chemStructWrapper
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapper getChemStructWrapper() {
        return chemStructWrapper;
    }


    /**
     * Sets the chemStructWrapper value for this BoxedText.
     * 
     * @param chemStructWrapper
     */
    public void setChemStructWrapper(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapper chemStructWrapper) {
        this.chemStructWrapper = chemStructWrapper;
    }


    /**
     * Gets the fig value for this BoxedText.
     * 
     * @return fig
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fig getFig() {
        return fig;
    }


    /**
     * Sets the fig value for this BoxedText.
     * 
     * @param fig
     */
    public void setFig(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fig fig) {
        this.fig = fig;
    }


    /**
     * Gets the figGroup value for this BoxedText.
     * 
     * @return figGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroup getFigGroup() {
        return figGroup;
    }


    /**
     * Sets the figGroup value for this BoxedText.
     * 
     * @param figGroup
     */
    public void setFigGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroup figGroup) {
        this.figGroup = figGroup;
    }


    /**
     * Gets the graphic value for this BoxedText.
     * 
     * @return graphic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic getGraphic() {
        return graphic;
    }


    /**
     * Sets the graphic value for this BoxedText.
     * 
     * @param graphic
     */
    public void setGraphic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic graphic) {
        this.graphic = graphic;
    }


    /**
     * Gets the media value for this BoxedText.
     * 
     * @return media
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media getMedia() {
        return media;
    }


    /**
     * Sets the media value for this BoxedText.
     * 
     * @param media
     */
    public void setMedia(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media media) {
        this.media = media;
    }


    /**
     * Gets the preformat value for this BoxedText.
     * 
     * @return preformat
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat getPreformat() {
        return preformat;
    }


    /**
     * Sets the preformat value for this BoxedText.
     * 
     * @param preformat
     */
    public void setPreformat(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat preformat) {
        this.preformat = preformat;
    }


    /**
     * Gets the supplementaryMaterial value for this BoxedText.
     * 
     * @return supplementaryMaterial
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial getSupplementaryMaterial() {
        return supplementaryMaterial;
    }


    /**
     * Sets the supplementaryMaterial value for this BoxedText.
     * 
     * @param supplementaryMaterial
     */
    public void setSupplementaryMaterial(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial supplementaryMaterial) {
        this.supplementaryMaterial = supplementaryMaterial;
    }


    /**
     * Gets the tableWrap value for this BoxedText.
     * 
     * @return tableWrap
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrap getTableWrap() {
        return tableWrap;
    }


    /**
     * Sets the tableWrap value for this BoxedText.
     * 
     * @param tableWrap
     */
    public void setTableWrap(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrap tableWrap) {
        this.tableWrap = tableWrap;
    }


    /**
     * Gets the tableWrapGroup value for this BoxedText.
     * 
     * @return tableWrapGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroup getTableWrapGroup() {
        return tableWrapGroup;
    }


    /**
     * Sets the tableWrapGroup value for this BoxedText.
     * 
     * @param tableWrapGroup
     */
    public void setTableWrapGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroup tableWrapGroup) {
        this.tableWrapGroup = tableWrapGroup;
    }


    /**
     * Gets the dispFormula value for this BoxedText.
     * 
     * @return dispFormula
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispFormula getDispFormula() {
        return dispFormula;
    }


    /**
     * Sets the dispFormula value for this BoxedText.
     * 
     * @param dispFormula
     */
    public void setDispFormula(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispFormula dispFormula) {
        this.dispFormula = dispFormula;
    }


    /**
     * Gets the p value for this BoxedText.
     * 
     * @return p
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P getP() {
        return p;
    }


    /**
     * Sets the p value for this BoxedText.
     * 
     * @param p
     */
    public void setP(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P p) {
        this.p = p;
    }


    /**
     * Gets the defList value for this BoxedText.
     * 
     * @return defList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList getDefList() {
        return defList;
    }


    /**
     * Sets the defList value for this BoxedText.
     * 
     * @param defList
     */
    public void setDefList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList defList) {
        this.defList = defList;
    }


    /**
     * Gets the list value for this BoxedText.
     * 
     * @return list
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List getList() {
        return list;
    }


    /**
     * Sets the list value for this BoxedText.
     * 
     * @param list
     */
    public void setList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List list) {
        this.list = list;
    }


    /**
     * Gets the texMath value for this BoxedText.
     * 
     * @return texMath
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath getTexMath() {
        return texMath;
    }


    /**
     * Sets the texMath value for this BoxedText.
     * 
     * @param texMath
     */
    public void setTexMath(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath) {
        this.texMath = texMath;
    }


    /**
     * Gets the math value for this BoxedText.
     * 
     * @return math
     */
    public org.w3.www._1998.Math.MathML.MathType getMath() {
        return math;
    }


    /**
     * Sets the math value for this BoxedText.
     * 
     * @param math
     */
    public void setMath(org.w3.www._1998.Math.MathML.MathType math) {
        this.math = math;
    }


    /**
     * Gets the relatedArticle value for this BoxedText.
     * 
     * @return relatedArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle getRelatedArticle() {
        return relatedArticle;
    }


    /**
     * Sets the relatedArticle value for this BoxedText.
     * 
     * @param relatedArticle
     */
    public void setRelatedArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle) {
        this.relatedArticle = relatedArticle;
    }


    /**
     * Gets the ack value for this BoxedText.
     * 
     * @return ack
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack getAck() {
        return ack;
    }


    /**
     * Sets the ack value for this BoxedText.
     * 
     * @param ack
     */
    public void setAck(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack ack) {
        this.ack = ack;
    }


    /**
     * Gets the dispQuote value for this BoxedText.
     * 
     * @return dispQuote
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote getDispQuote() {
        return dispQuote;
    }


    /**
     * Sets the dispQuote value for this BoxedText.
     * 
     * @param dispQuote
     */
    public void setDispQuote(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote dispQuote) {
        this.dispQuote = dispQuote;
    }


    /**
     * Gets the speech value for this BoxedText.
     * 
     * @return speech
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech getSpeech() {
        return speech;
    }


    /**
     * Sets the speech value for this BoxedText.
     * 
     * @param speech
     */
    public void setSpeech(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech speech) {
        this.speech = speech;
    }


    /**
     * Gets the statement value for this BoxedText.
     * 
     * @return statement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement getStatement() {
        return statement;
    }


    /**
     * Sets the statement value for this BoxedText.
     * 
     * @param statement
     */
    public void setStatement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement statement) {
        this.statement = statement;
    }


    /**
     * Gets the verseGroup value for this BoxedText.
     * 
     * @return verseGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup getVerseGroup() {
        return verseGroup;
    }


    /**
     * Sets the verseGroup value for this BoxedText.
     * 
     * @param verseGroup
     */
    public void setVerseGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup) {
        this.verseGroup = verseGroup;
    }


    /**
     * Gets the x value for this BoxedText.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this BoxedText.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the sec value for this BoxedText.
     * 
     * @return sec
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sec[] getSec() {
        return sec;
    }


    /**
     * Sets the sec value for this BoxedText.
     * 
     * @param sec
     */
    public void setSec(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sec[] sec) {
        this.sec = sec;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sec getSec(int i) {
        return this.sec[i];
    }

    public void setSec(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sec _value) {
        this.sec[i] = _value;
    }


    /**
     * Gets the notes value for this BoxedText.
     * 
     * @return notes
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Notes getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this BoxedText.
     * 
     * @param notes
     */
    public void setNotes(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Notes notes) {
        this.notes = notes;
    }


    /**
     * Gets the fnGroup value for this BoxedText.
     * 
     * @return fnGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FnGroup getFnGroup() {
        return fnGroup;
    }


    /**
     * Sets the fnGroup value for this BoxedText.
     * 
     * @param fnGroup
     */
    public void setFnGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FnGroup fnGroup) {
        this.fnGroup = fnGroup;
    }


    /**
     * Gets the glossary value for this BoxedText.
     * 
     * @return glossary
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Glossary getGlossary() {
        return glossary;
    }


    /**
     * Sets the glossary value for this BoxedText.
     * 
     * @param glossary
     */
    public void setGlossary(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Glossary glossary) {
        this.glossary = glossary;
    }


    /**
     * Gets the refList value for this BoxedText.
     * 
     * @return refList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RefList getRefList() {
        return refList;
    }


    /**
     * Sets the refList value for this BoxedText.
     * 
     * @param refList
     */
    public void setRefList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RefList refList) {
        this.refList = refList;
    }


    /**
     * Gets the attrib value for this BoxedText.
     * 
     * @return attrib
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib getAttrib() {
        return attrib;
    }


    /**
     * Sets the attrib value for this BoxedText.
     * 
     * @param attrib
     */
    public void setAttrib(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Attrib attrib) {
        this.attrib = attrib;
    }


    /**
     * Gets the copyrightStatement value for this BoxedText.
     * 
     * @return copyrightStatement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement getCopyrightStatement() {
        return copyrightStatement;
    }


    /**
     * Sets the copyrightStatement value for this BoxedText.
     * 
     * @param copyrightStatement
     */
    public void setCopyrightStatement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement) {
        this.copyrightStatement = copyrightStatement;
    }


    /**
     * Gets the permissions value for this BoxedText.
     * 
     * @return permissions
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this BoxedText.
     * 
     * @param permissions
     */
    public void setPermissions(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
        this.permissions = permissions;
    }


    /**
     * Gets the id value for this BoxedText.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this BoxedText.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the position value for this BoxedText.
     * 
     * @return position
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedTextPosition getPosition() {
        return position;
    }


    /**
     * Sets the position value for this BoxedText.
     * 
     * @param position
     */
    public void setPosition(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedTextPosition position) {
        this.position = position;
    }


    /**
     * Gets the contentType value for this BoxedText.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this BoxedText.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BoxedText)) return false;
        BoxedText other = (BoxedText) obj;
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
            ((this.secMeta==null && other.getSecMeta()==null) || 
             (this.secMeta!=null &&
              this.secMeta.equals(other.getSecMeta()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.array==null && other.getArray()==null) || 
             (this.array!=null &&
              this.array.equals(other.getArray()))) &&
            ((this.boxedText==null && other.getBoxedText()==null) || 
             (this.boxedText!=null &&
              this.boxedText.equals(other.getBoxedText()))) &&
            ((this.chemStruct==null && other.getChemStruct()==null) || 
             (this.chemStruct!=null &&
              this.chemStruct.equals(other.getChemStruct()))) &&
            ((this.chemStructWrapper==null && other.getChemStructWrapper()==null) || 
             (this.chemStructWrapper!=null &&
              this.chemStructWrapper.equals(other.getChemStructWrapper()))) &&
            ((this.fig==null && other.getFig()==null) || 
             (this.fig!=null &&
              this.fig.equals(other.getFig()))) &&
            ((this.figGroup==null && other.getFigGroup()==null) || 
             (this.figGroup!=null &&
              this.figGroup.equals(other.getFigGroup()))) &&
            ((this.graphic==null && other.getGraphic()==null) || 
             (this.graphic!=null &&
              this.graphic.equals(other.getGraphic()))) &&
            ((this.media==null && other.getMedia()==null) || 
             (this.media!=null &&
              this.media.equals(other.getMedia()))) &&
            ((this.preformat==null && other.getPreformat()==null) || 
             (this.preformat!=null &&
              this.preformat.equals(other.getPreformat()))) &&
            ((this.supplementaryMaterial==null && other.getSupplementaryMaterial()==null) || 
             (this.supplementaryMaterial!=null &&
              this.supplementaryMaterial.equals(other.getSupplementaryMaterial()))) &&
            ((this.tableWrap==null && other.getTableWrap()==null) || 
             (this.tableWrap!=null &&
              this.tableWrap.equals(other.getTableWrap()))) &&
            ((this.tableWrapGroup==null && other.getTableWrapGroup()==null) || 
             (this.tableWrapGroup!=null &&
              this.tableWrapGroup.equals(other.getTableWrapGroup()))) &&
            ((this.dispFormula==null && other.getDispFormula()==null) || 
             (this.dispFormula!=null &&
              this.dispFormula.equals(other.getDispFormula()))) &&
            ((this.p==null && other.getP()==null) || 
             (this.p!=null &&
              this.p.equals(other.getP()))) &&
            ((this.defList==null && other.getDefList()==null) || 
             (this.defList!=null &&
              this.defList.equals(other.getDefList()))) &&
            ((this.list==null && other.getList()==null) || 
             (this.list!=null &&
              this.list.equals(other.getList()))) &&
            ((this.texMath==null && other.getTexMath()==null) || 
             (this.texMath!=null &&
              this.texMath.equals(other.getTexMath()))) &&
            ((this.math==null && other.getMath()==null) || 
             (this.math!=null &&
              this.math.equals(other.getMath()))) &&
            ((this.relatedArticle==null && other.getRelatedArticle()==null) || 
             (this.relatedArticle!=null &&
              this.relatedArticle.equals(other.getRelatedArticle()))) &&
            ((this.ack==null && other.getAck()==null) || 
             (this.ack!=null &&
              this.ack.equals(other.getAck()))) &&
            ((this.dispQuote==null && other.getDispQuote()==null) || 
             (this.dispQuote!=null &&
              this.dispQuote.equals(other.getDispQuote()))) &&
            ((this.speech==null && other.getSpeech()==null) || 
             (this.speech!=null &&
              this.speech.equals(other.getSpeech()))) &&
            ((this.statement==null && other.getStatement()==null) || 
             (this.statement!=null &&
              this.statement.equals(other.getStatement()))) &&
            ((this.verseGroup==null && other.getVerseGroup()==null) || 
             (this.verseGroup!=null &&
              this.verseGroup.equals(other.getVerseGroup()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this.sec==null && other.getSec()==null) || 
             (this.sec!=null &&
              java.util.Arrays.equals(this.sec, other.getSec()))) &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            ((this.fnGroup==null && other.getFnGroup()==null) || 
             (this.fnGroup!=null &&
              this.fnGroup.equals(other.getFnGroup()))) &&
            ((this.glossary==null && other.getGlossary()==null) || 
             (this.glossary!=null &&
              this.glossary.equals(other.getGlossary()))) &&
            ((this.refList==null && other.getRefList()==null) || 
             (this.refList!=null &&
              this.refList.equals(other.getRefList()))) &&
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
        if (getSecMeta() != null) {
            _hashCode += getSecMeta().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getArray() != null) {
            _hashCode += getArray().hashCode();
        }
        if (getBoxedText() != null) {
            _hashCode += getBoxedText().hashCode();
        }
        if (getChemStruct() != null) {
            _hashCode += getChemStruct().hashCode();
        }
        if (getChemStructWrapper() != null) {
            _hashCode += getChemStructWrapper().hashCode();
        }
        if (getFig() != null) {
            _hashCode += getFig().hashCode();
        }
        if (getFigGroup() != null) {
            _hashCode += getFigGroup().hashCode();
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
        if (getSupplementaryMaterial() != null) {
            _hashCode += getSupplementaryMaterial().hashCode();
        }
        if (getTableWrap() != null) {
            _hashCode += getTableWrap().hashCode();
        }
        if (getTableWrapGroup() != null) {
            _hashCode += getTableWrapGroup().hashCode();
        }
        if (getDispFormula() != null) {
            _hashCode += getDispFormula().hashCode();
        }
        if (getP() != null) {
            _hashCode += getP().hashCode();
        }
        if (getDefList() != null) {
            _hashCode += getDefList().hashCode();
        }
        if (getList() != null) {
            _hashCode += getList().hashCode();
        }
        if (getTexMath() != null) {
            _hashCode += getTexMath().hashCode();
        }
        if (getMath() != null) {
            _hashCode += getMath().hashCode();
        }
        if (getRelatedArticle() != null) {
            _hashCode += getRelatedArticle().hashCode();
        }
        if (getAck() != null) {
            _hashCode += getAck().hashCode();
        }
        if (getDispQuote() != null) {
            _hashCode += getDispQuote().hashCode();
        }
        if (getSpeech() != null) {
            _hashCode += getSpeech().hashCode();
        }
        if (getStatement() != null) {
            _hashCode += getStatement().hashCode();
        }
        if (getVerseGroup() != null) {
            _hashCode += getVerseGroup().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (getSec() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSec());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSec(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        if (getFnGroup() != null) {
            _hashCode += getFnGroup().hashCode();
        }
        if (getGlossary() != null) {
            _hashCode += getGlossary().hashCode();
        }
        if (getRefList() != null) {
            _hashCode += getRefList().hashCode();
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
        new org.apache.axis.description.TypeDesc(BoxedText.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">boxed-text"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("position");
        attrField.setXmlName(new javax.xml.namespace.QName("", "position"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">>boxed-text>position"));
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
        elemField.setFieldName("secMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sec-meta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sec-meta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("array");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "array"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">array"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxedText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "boxed-text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">boxed-text"));
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
        elemField.setFieldName("chemStructWrapper");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "chem-struct-wrapper"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">chem-struct-wrapper"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fig");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fig"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("figGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fig-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fig-group"));
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
        elemField.setFieldName("supplementaryMaterial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "supplementary-material"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">supplementary-material"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableWrap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "table-wrap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">table-wrap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableWrapGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "table-wrap-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">table-wrap-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispFormula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "disp-formula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">disp-formula"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "p"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">p"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "def-list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">def-list"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">list"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("texMath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "tex-math"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">tex-math"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("math");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "math"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "math.type"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedArticle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "related-article"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">related-article"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ack");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "ack"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ack"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispQuote");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "disp-quote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">disp-quote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("speech");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "speech"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">speech"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statement");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "statement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">statement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verseGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "verse-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">verse-group"));
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
        elemField.setFieldName("sec");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">notes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fnGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fn-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fn-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("glossary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "glossary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">glossary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "ref-list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">ref-list"));
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
