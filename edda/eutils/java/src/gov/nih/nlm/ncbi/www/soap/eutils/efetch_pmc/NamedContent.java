/**
 * NamedContent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class NamedContent  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial inlineSupplementaryMaterial;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font font;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr hr;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold bold;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic italic;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace monospace;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline overline;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart overlineStart;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd overlineEnd;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif sansSerif;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc sc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike strike;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline underline;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart underlineStart;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd underlineEnd;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic inlineGraphic;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar privateChar;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula inlineFormula;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath;

    private org.w3.www._1998.Math.MathML.MathType math;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev abbrev;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd milestoneEnd;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart milestoneStart;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent namedContent;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target target;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub sub;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup sup;

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

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList defList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List list;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack ack;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote dispQuote;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech speech;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement statement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private java.lang.Object contentType;  // attribute

    private java.lang.String id;  // attribute

    private org.w3.www._1999.xlink.Type type;  // attribute

    private java.lang.Object href;  // attribute

    private java.lang.Object role;  // attribute

    private java.lang.Object title;  // attribute

    private org.w3.www._1999.xlink.Show show;  // attribute

    private org.w3.www._1999.xlink.Actuate actuate;  // attribute

    public NamedContent() {
    }

    public NamedContent(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial inlineSupplementaryMaterial,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font font,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr hr,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold bold,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic italic,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace monospace,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline overline,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart overlineStart,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd overlineEnd,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif sansSerif,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc sc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike strike,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline underline,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart underlineStart,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd underlineEnd,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic inlineGraphic,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar privateChar,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula inlineFormula,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath,
           org.w3.www._1998.Math.MathML.MathType math,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev abbrev,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd milestoneEnd,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart milestoneStart,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent namedContent,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target target,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub sub,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup sup,
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
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList defList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List list,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack ack,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote dispQuote,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech speech,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement statement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           org.apache.axis.message.MessageElement [] _any,
           java.lang.Object contentType,
           java.lang.String id,
           org.w3.www._1999.xlink.Type type,
           java.lang.Object href,
           java.lang.Object role,
           java.lang.Object title,
           org.w3.www._1999.xlink.Show show,
           org.w3.www._1999.xlink.Actuate actuate) {
           this.email = email;
           this.extLink = extLink;
           this.uri = uri;
           this.inlineSupplementaryMaterial = inlineSupplementaryMaterial;
           this.relatedArticle = relatedArticle;
           this.font = font;
           this.hr = hr;
           this.bold = bold;
           this.italic = italic;
           this.monospace = monospace;
           this.overline = overline;
           this.overlineStart = overlineStart;
           this.overlineEnd = overlineEnd;
           this.sansSerif = sansSerif;
           this.sc = sc;
           this.strike = strike;
           this.underline = underline;
           this.underlineStart = underlineStart;
           this.underlineEnd = underlineEnd;
           this.inlineGraphic = inlineGraphic;
           this.privateChar = privateChar;
           this.inlineFormula = inlineFormula;
           this.texMath = texMath;
           this.math = math;
           this.abbrev = abbrev;
           this.milestoneEnd = milestoneEnd;
           this.milestoneStart = milestoneStart;
           this.namedContent = namedContent;
           this.fn = fn;
           this.target = target;
           this.xref = xref;
           this.sub = sub;
           this.sup = sup;
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
           this.defList = defList;
           this.list = list;
           this.ack = ack;
           this.dispQuote = dispQuote;
           this.speech = speech;
           this.statement = statement;
           this.verseGroup = verseGroup;
           this.x = x;
           this._any = _any;
           this.contentType = contentType;
           this.id = id;
           this.type = type;
           this.href = href;
           this.role = role;
           this.title = title;
           this.show = show;
           this.actuate = actuate;
    }


    /**
     * Gets the email value for this NamedContent.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail() {
        return email;
    }


    /**
     * Sets the email value for this NamedContent.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email) {
        this.email = email;
    }


    /**
     * Gets the extLink value for this NamedContent.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this NamedContent.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink) {
        this.extLink = extLink;
    }


    /**
     * Gets the uri value for this NamedContent.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this NamedContent.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri) {
        this.uri = uri;
    }


    /**
     * Gets the inlineSupplementaryMaterial value for this NamedContent.
     * 
     * @return inlineSupplementaryMaterial
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial getInlineSupplementaryMaterial() {
        return inlineSupplementaryMaterial;
    }


    /**
     * Sets the inlineSupplementaryMaterial value for this NamedContent.
     * 
     * @param inlineSupplementaryMaterial
     */
    public void setInlineSupplementaryMaterial(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial inlineSupplementaryMaterial) {
        this.inlineSupplementaryMaterial = inlineSupplementaryMaterial;
    }


    /**
     * Gets the relatedArticle value for this NamedContent.
     * 
     * @return relatedArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle getRelatedArticle() {
        return relatedArticle;
    }


    /**
     * Sets the relatedArticle value for this NamedContent.
     * 
     * @param relatedArticle
     */
    public void setRelatedArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle) {
        this.relatedArticle = relatedArticle;
    }


    /**
     * Gets the font value for this NamedContent.
     * 
     * @return font
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font getFont() {
        return font;
    }


    /**
     * Sets the font value for this NamedContent.
     * 
     * @param font
     */
    public void setFont(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font font) {
        this.font = font;
    }


    /**
     * Gets the hr value for this NamedContent.
     * 
     * @return hr
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr getHr() {
        return hr;
    }


    /**
     * Sets the hr value for this NamedContent.
     * 
     * @param hr
     */
    public void setHr(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr hr) {
        this.hr = hr;
    }


    /**
     * Gets the bold value for this NamedContent.
     * 
     * @return bold
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold getBold() {
        return bold;
    }


    /**
     * Sets the bold value for this NamedContent.
     * 
     * @param bold
     */
    public void setBold(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold bold) {
        this.bold = bold;
    }


    /**
     * Gets the italic value for this NamedContent.
     * 
     * @return italic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic getItalic() {
        return italic;
    }


    /**
     * Sets the italic value for this NamedContent.
     * 
     * @param italic
     */
    public void setItalic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic italic) {
        this.italic = italic;
    }


    /**
     * Gets the monospace value for this NamedContent.
     * 
     * @return monospace
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace getMonospace() {
        return monospace;
    }


    /**
     * Sets the monospace value for this NamedContent.
     * 
     * @param monospace
     */
    public void setMonospace(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace monospace) {
        this.monospace = monospace;
    }


    /**
     * Gets the overline value for this NamedContent.
     * 
     * @return overline
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline getOverline() {
        return overline;
    }


    /**
     * Sets the overline value for this NamedContent.
     * 
     * @param overline
     */
    public void setOverline(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline overline) {
        this.overline = overline;
    }


    /**
     * Gets the overlineStart value for this NamedContent.
     * 
     * @return overlineStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart getOverlineStart() {
        return overlineStart;
    }


    /**
     * Sets the overlineStart value for this NamedContent.
     * 
     * @param overlineStart
     */
    public void setOverlineStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart overlineStart) {
        this.overlineStart = overlineStart;
    }


    /**
     * Gets the overlineEnd value for this NamedContent.
     * 
     * @return overlineEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd getOverlineEnd() {
        return overlineEnd;
    }


    /**
     * Sets the overlineEnd value for this NamedContent.
     * 
     * @param overlineEnd
     */
    public void setOverlineEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd overlineEnd) {
        this.overlineEnd = overlineEnd;
    }


    /**
     * Gets the sansSerif value for this NamedContent.
     * 
     * @return sansSerif
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif getSansSerif() {
        return sansSerif;
    }


    /**
     * Sets the sansSerif value for this NamedContent.
     * 
     * @param sansSerif
     */
    public void setSansSerif(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif sansSerif) {
        this.sansSerif = sansSerif;
    }


    /**
     * Gets the sc value for this NamedContent.
     * 
     * @return sc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc getSc() {
        return sc;
    }


    /**
     * Sets the sc value for this NamedContent.
     * 
     * @param sc
     */
    public void setSc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc sc) {
        this.sc = sc;
    }


    /**
     * Gets the strike value for this NamedContent.
     * 
     * @return strike
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike getStrike() {
        return strike;
    }


    /**
     * Sets the strike value for this NamedContent.
     * 
     * @param strike
     */
    public void setStrike(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike strike) {
        this.strike = strike;
    }


    /**
     * Gets the underline value for this NamedContent.
     * 
     * @return underline
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline getUnderline() {
        return underline;
    }


    /**
     * Sets the underline value for this NamedContent.
     * 
     * @param underline
     */
    public void setUnderline(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline underline) {
        this.underline = underline;
    }


    /**
     * Gets the underlineStart value for this NamedContent.
     * 
     * @return underlineStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart getUnderlineStart() {
        return underlineStart;
    }


    /**
     * Sets the underlineStart value for this NamedContent.
     * 
     * @param underlineStart
     */
    public void setUnderlineStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart underlineStart) {
        this.underlineStart = underlineStart;
    }


    /**
     * Gets the underlineEnd value for this NamedContent.
     * 
     * @return underlineEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd getUnderlineEnd() {
        return underlineEnd;
    }


    /**
     * Sets the underlineEnd value for this NamedContent.
     * 
     * @param underlineEnd
     */
    public void setUnderlineEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd underlineEnd) {
        this.underlineEnd = underlineEnd;
    }


    /**
     * Gets the inlineGraphic value for this NamedContent.
     * 
     * @return inlineGraphic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic getInlineGraphic() {
        return inlineGraphic;
    }


    /**
     * Sets the inlineGraphic value for this NamedContent.
     * 
     * @param inlineGraphic
     */
    public void setInlineGraphic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic inlineGraphic) {
        this.inlineGraphic = inlineGraphic;
    }


    /**
     * Gets the privateChar value for this NamedContent.
     * 
     * @return privateChar
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar getPrivateChar() {
        return privateChar;
    }


    /**
     * Sets the privateChar value for this NamedContent.
     * 
     * @param privateChar
     */
    public void setPrivateChar(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar privateChar) {
        this.privateChar = privateChar;
    }


    /**
     * Gets the inlineFormula value for this NamedContent.
     * 
     * @return inlineFormula
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula getInlineFormula() {
        return inlineFormula;
    }


    /**
     * Sets the inlineFormula value for this NamedContent.
     * 
     * @param inlineFormula
     */
    public void setInlineFormula(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula inlineFormula) {
        this.inlineFormula = inlineFormula;
    }


    /**
     * Gets the texMath value for this NamedContent.
     * 
     * @return texMath
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath getTexMath() {
        return texMath;
    }


    /**
     * Sets the texMath value for this NamedContent.
     * 
     * @param texMath
     */
    public void setTexMath(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath) {
        this.texMath = texMath;
    }


    /**
     * Gets the math value for this NamedContent.
     * 
     * @return math
     */
    public org.w3.www._1998.Math.MathML.MathType getMath() {
        return math;
    }


    /**
     * Sets the math value for this NamedContent.
     * 
     * @param math
     */
    public void setMath(org.w3.www._1998.Math.MathML.MathType math) {
        this.math = math;
    }


    /**
     * Gets the abbrev value for this NamedContent.
     * 
     * @return abbrev
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev getAbbrev() {
        return abbrev;
    }


    /**
     * Sets the abbrev value for this NamedContent.
     * 
     * @param abbrev
     */
    public void setAbbrev(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev abbrev) {
        this.abbrev = abbrev;
    }


    /**
     * Gets the milestoneEnd value for this NamedContent.
     * 
     * @return milestoneEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd getMilestoneEnd() {
        return milestoneEnd;
    }


    /**
     * Sets the milestoneEnd value for this NamedContent.
     * 
     * @param milestoneEnd
     */
    public void setMilestoneEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd milestoneEnd) {
        this.milestoneEnd = milestoneEnd;
    }


    /**
     * Gets the milestoneStart value for this NamedContent.
     * 
     * @return milestoneStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart getMilestoneStart() {
        return milestoneStart;
    }


    /**
     * Sets the milestoneStart value for this NamedContent.
     * 
     * @param milestoneStart
     */
    public void setMilestoneStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart milestoneStart) {
        this.milestoneStart = milestoneStart;
    }


    /**
     * Gets the namedContent value for this NamedContent.
     * 
     * @return namedContent
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent getNamedContent() {
        return namedContent;
    }


    /**
     * Sets the namedContent value for this NamedContent.
     * 
     * @param namedContent
     */
    public void setNamedContent(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent namedContent) {
        this.namedContent = namedContent;
    }


    /**
     * Gets the fn value for this NamedContent.
     * 
     * @return fn
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn getFn() {
        return fn;
    }


    /**
     * Sets the fn value for this NamedContent.
     * 
     * @param fn
     */
    public void setFn(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn) {
        this.fn = fn;
    }


    /**
     * Gets the target value for this NamedContent.
     * 
     * @return target
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target getTarget() {
        return target;
    }


    /**
     * Sets the target value for this NamedContent.
     * 
     * @param target
     */
    public void setTarget(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target target) {
        this.target = target;
    }


    /**
     * Gets the xref value for this NamedContent.
     * 
     * @return xref
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this NamedContent.
     * 
     * @param xref
     */
    public void setXref(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref) {
        this.xref = xref;
    }


    /**
     * Gets the sub value for this NamedContent.
     * 
     * @return sub
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub getSub() {
        return sub;
    }


    /**
     * Sets the sub value for this NamedContent.
     * 
     * @param sub
     */
    public void setSub(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub sub) {
        this.sub = sub;
    }


    /**
     * Gets the sup value for this NamedContent.
     * 
     * @return sup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup getSup() {
        return sup;
    }


    /**
     * Sets the sup value for this NamedContent.
     * 
     * @param sup
     */
    public void setSup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup sup) {
        this.sup = sup;
    }


    /**
     * Gets the array value for this NamedContent.
     * 
     * @return array
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Array getArray() {
        return array;
    }


    /**
     * Sets the array value for this NamedContent.
     * 
     * @param array
     */
    public void setArray(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Array array) {
        this.array = array;
    }


    /**
     * Gets the boxedText value for this NamedContent.
     * 
     * @return boxedText
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedText getBoxedText() {
        return boxedText;
    }


    /**
     * Sets the boxedText value for this NamedContent.
     * 
     * @param boxedText
     */
    public void setBoxedText(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.BoxedText boxedText) {
        this.boxedText = boxedText;
    }


    /**
     * Gets the chemStruct value for this NamedContent.
     * 
     * @return chemStruct
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct getChemStruct() {
        return chemStruct;
    }


    /**
     * Sets the chemStruct value for this NamedContent.
     * 
     * @param chemStruct
     */
    public void setChemStruct(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStruct chemStruct) {
        this.chemStruct = chemStruct;
    }


    /**
     * Gets the chemStructWrapper value for this NamedContent.
     * 
     * @return chemStructWrapper
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapper getChemStructWrapper() {
        return chemStructWrapper;
    }


    /**
     * Sets the chemStructWrapper value for this NamedContent.
     * 
     * @param chemStructWrapper
     */
    public void setChemStructWrapper(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ChemStructWrapper chemStructWrapper) {
        this.chemStructWrapper = chemStructWrapper;
    }


    /**
     * Gets the fig value for this NamedContent.
     * 
     * @return fig
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fig getFig() {
        return fig;
    }


    /**
     * Sets the fig value for this NamedContent.
     * 
     * @param fig
     */
    public void setFig(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fig fig) {
        this.fig = fig;
    }


    /**
     * Gets the figGroup value for this NamedContent.
     * 
     * @return figGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroup getFigGroup() {
        return figGroup;
    }


    /**
     * Sets the figGroup value for this NamedContent.
     * 
     * @param figGroup
     */
    public void setFigGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.FigGroup figGroup) {
        this.figGroup = figGroup;
    }


    /**
     * Gets the graphic value for this NamedContent.
     * 
     * @return graphic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic getGraphic() {
        return graphic;
    }


    /**
     * Sets the graphic value for this NamedContent.
     * 
     * @param graphic
     */
    public void setGraphic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Graphic graphic) {
        this.graphic = graphic;
    }


    /**
     * Gets the media value for this NamedContent.
     * 
     * @return media
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media getMedia() {
        return media;
    }


    /**
     * Sets the media value for this NamedContent.
     * 
     * @param media
     */
    public void setMedia(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Media media) {
        this.media = media;
    }


    /**
     * Gets the preformat value for this NamedContent.
     * 
     * @return preformat
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat getPreformat() {
        return preformat;
    }


    /**
     * Sets the preformat value for this NamedContent.
     * 
     * @param preformat
     */
    public void setPreformat(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Preformat preformat) {
        this.preformat = preformat;
    }


    /**
     * Gets the supplementaryMaterial value for this NamedContent.
     * 
     * @return supplementaryMaterial
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial getSupplementaryMaterial() {
        return supplementaryMaterial;
    }


    /**
     * Sets the supplementaryMaterial value for this NamedContent.
     * 
     * @param supplementaryMaterial
     */
    public void setSupplementaryMaterial(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial supplementaryMaterial) {
        this.supplementaryMaterial = supplementaryMaterial;
    }


    /**
     * Gets the tableWrap value for this NamedContent.
     * 
     * @return tableWrap
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrap getTableWrap() {
        return tableWrap;
    }


    /**
     * Sets the tableWrap value for this NamedContent.
     * 
     * @param tableWrap
     */
    public void setTableWrap(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrap tableWrap) {
        this.tableWrap = tableWrap;
    }


    /**
     * Gets the tableWrapGroup value for this NamedContent.
     * 
     * @return tableWrapGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroup getTableWrapGroup() {
        return tableWrapGroup;
    }


    /**
     * Sets the tableWrapGroup value for this NamedContent.
     * 
     * @param tableWrapGroup
     */
    public void setTableWrapGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TableWrapGroup tableWrapGroup) {
        this.tableWrapGroup = tableWrapGroup;
    }


    /**
     * Gets the dispFormula value for this NamedContent.
     * 
     * @return dispFormula
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispFormula getDispFormula() {
        return dispFormula;
    }


    /**
     * Sets the dispFormula value for this NamedContent.
     * 
     * @param dispFormula
     */
    public void setDispFormula(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispFormula dispFormula) {
        this.dispFormula = dispFormula;
    }


    /**
     * Gets the defList value for this NamedContent.
     * 
     * @return defList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList getDefList() {
        return defList;
    }


    /**
     * Sets the defList value for this NamedContent.
     * 
     * @param defList
     */
    public void setDefList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DefList defList) {
        this.defList = defList;
    }


    /**
     * Gets the list value for this NamedContent.
     * 
     * @return list
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List getList() {
        return list;
    }


    /**
     * Sets the list value for this NamedContent.
     * 
     * @param list
     */
    public void setList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.List list) {
        this.list = list;
    }


    /**
     * Gets the ack value for this NamedContent.
     * 
     * @return ack
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack getAck() {
        return ack;
    }


    /**
     * Sets the ack value for this NamedContent.
     * 
     * @param ack
     */
    public void setAck(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Ack ack) {
        this.ack = ack;
    }


    /**
     * Gets the dispQuote value for this NamedContent.
     * 
     * @return dispQuote
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote getDispQuote() {
        return dispQuote;
    }


    /**
     * Sets the dispQuote value for this NamedContent.
     * 
     * @param dispQuote
     */
    public void setDispQuote(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.DispQuote dispQuote) {
        this.dispQuote = dispQuote;
    }


    /**
     * Gets the speech value for this NamedContent.
     * 
     * @return speech
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech getSpeech() {
        return speech;
    }


    /**
     * Sets the speech value for this NamedContent.
     * 
     * @param speech
     */
    public void setSpeech(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Speech speech) {
        this.speech = speech;
    }


    /**
     * Gets the statement value for this NamedContent.
     * 
     * @return statement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement getStatement() {
        return statement;
    }


    /**
     * Sets the statement value for this NamedContent.
     * 
     * @param statement
     */
    public void setStatement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Statement statement) {
        this.statement = statement;
    }


    /**
     * Gets the verseGroup value for this NamedContent.
     * 
     * @return verseGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup getVerseGroup() {
        return verseGroup;
    }


    /**
     * Sets the verseGroup value for this NamedContent.
     * 
     * @param verseGroup
     */
    public void setVerseGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VerseGroup verseGroup) {
        this.verseGroup = verseGroup;
    }


    /**
     * Gets the x value for this NamedContent.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this NamedContent.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the _any value for this NamedContent.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this NamedContent.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the contentType value for this NamedContent.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this NamedContent.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }


    /**
     * Gets the id value for this NamedContent.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this NamedContent.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the type value for this NamedContent.
     * 
     * @return type
     */
    public org.w3.www._1999.xlink.Type getType() {
        return type;
    }


    /**
     * Sets the type value for this NamedContent.
     * 
     * @param type
     */
    public void setType(org.w3.www._1999.xlink.Type type) {
        this.type = type;
    }


    /**
     * Gets the href value for this NamedContent.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this NamedContent.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }


    /**
     * Gets the role value for this NamedContent.
     * 
     * @return role
     */
    public java.lang.Object getRole() {
        return role;
    }


    /**
     * Sets the role value for this NamedContent.
     * 
     * @param role
     */
    public void setRole(java.lang.Object role) {
        this.role = role;
    }


    /**
     * Gets the title value for this NamedContent.
     * 
     * @return title
     */
    public java.lang.Object getTitle() {
        return title;
    }


    /**
     * Sets the title value for this NamedContent.
     * 
     * @param title
     */
    public void setTitle(java.lang.Object title) {
        this.title = title;
    }


    /**
     * Gets the show value for this NamedContent.
     * 
     * @return show
     */
    public org.w3.www._1999.xlink.Show getShow() {
        return show;
    }


    /**
     * Sets the show value for this NamedContent.
     * 
     * @param show
     */
    public void setShow(org.w3.www._1999.xlink.Show show) {
        this.show = show;
    }


    /**
     * Gets the actuate value for this NamedContent.
     * 
     * @return actuate
     */
    public org.w3.www._1999.xlink.Actuate getActuate() {
        return actuate;
    }


    /**
     * Sets the actuate value for this NamedContent.
     * 
     * @param actuate
     */
    public void setActuate(org.w3.www._1999.xlink.Actuate actuate) {
        this.actuate = actuate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NamedContent)) return false;
        NamedContent other = (NamedContent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.extLink==null && other.getExtLink()==null) || 
             (this.extLink!=null &&
              this.extLink.equals(other.getExtLink()))) &&
            ((this.uri==null && other.getUri()==null) || 
             (this.uri!=null &&
              this.uri.equals(other.getUri()))) &&
            ((this.inlineSupplementaryMaterial==null && other.getInlineSupplementaryMaterial()==null) || 
             (this.inlineSupplementaryMaterial!=null &&
              this.inlineSupplementaryMaterial.equals(other.getInlineSupplementaryMaterial()))) &&
            ((this.relatedArticle==null && other.getRelatedArticle()==null) || 
             (this.relatedArticle!=null &&
              this.relatedArticle.equals(other.getRelatedArticle()))) &&
            ((this.font==null && other.getFont()==null) || 
             (this.font!=null &&
              this.font.equals(other.getFont()))) &&
            ((this.hr==null && other.getHr()==null) || 
             (this.hr!=null &&
              this.hr.equals(other.getHr()))) &&
            ((this.bold==null && other.getBold()==null) || 
             (this.bold!=null &&
              this.bold.equals(other.getBold()))) &&
            ((this.italic==null && other.getItalic()==null) || 
             (this.italic!=null &&
              this.italic.equals(other.getItalic()))) &&
            ((this.monospace==null && other.getMonospace()==null) || 
             (this.monospace!=null &&
              this.monospace.equals(other.getMonospace()))) &&
            ((this.overline==null && other.getOverline()==null) || 
             (this.overline!=null &&
              this.overline.equals(other.getOverline()))) &&
            ((this.overlineStart==null && other.getOverlineStart()==null) || 
             (this.overlineStart!=null &&
              this.overlineStart.equals(other.getOverlineStart()))) &&
            ((this.overlineEnd==null && other.getOverlineEnd()==null) || 
             (this.overlineEnd!=null &&
              this.overlineEnd.equals(other.getOverlineEnd()))) &&
            ((this.sansSerif==null && other.getSansSerif()==null) || 
             (this.sansSerif!=null &&
              this.sansSerif.equals(other.getSansSerif()))) &&
            ((this.sc==null && other.getSc()==null) || 
             (this.sc!=null &&
              this.sc.equals(other.getSc()))) &&
            ((this.strike==null && other.getStrike()==null) || 
             (this.strike!=null &&
              this.strike.equals(other.getStrike()))) &&
            ((this.underline==null && other.getUnderline()==null) || 
             (this.underline!=null &&
              this.underline.equals(other.getUnderline()))) &&
            ((this.underlineStart==null && other.getUnderlineStart()==null) || 
             (this.underlineStart!=null &&
              this.underlineStart.equals(other.getUnderlineStart()))) &&
            ((this.underlineEnd==null && other.getUnderlineEnd()==null) || 
             (this.underlineEnd!=null &&
              this.underlineEnd.equals(other.getUnderlineEnd()))) &&
            ((this.inlineGraphic==null && other.getInlineGraphic()==null) || 
             (this.inlineGraphic!=null &&
              this.inlineGraphic.equals(other.getInlineGraphic()))) &&
            ((this.privateChar==null && other.getPrivateChar()==null) || 
             (this.privateChar!=null &&
              this.privateChar.equals(other.getPrivateChar()))) &&
            ((this.inlineFormula==null && other.getInlineFormula()==null) || 
             (this.inlineFormula!=null &&
              this.inlineFormula.equals(other.getInlineFormula()))) &&
            ((this.texMath==null && other.getTexMath()==null) || 
             (this.texMath!=null &&
              this.texMath.equals(other.getTexMath()))) &&
            ((this.math==null && other.getMath()==null) || 
             (this.math!=null &&
              this.math.equals(other.getMath()))) &&
            ((this.abbrev==null && other.getAbbrev()==null) || 
             (this.abbrev!=null &&
              this.abbrev.equals(other.getAbbrev()))) &&
            ((this.milestoneEnd==null && other.getMilestoneEnd()==null) || 
             (this.milestoneEnd!=null &&
              this.milestoneEnd.equals(other.getMilestoneEnd()))) &&
            ((this.milestoneStart==null && other.getMilestoneStart()==null) || 
             (this.milestoneStart!=null &&
              this.milestoneStart.equals(other.getMilestoneStart()))) &&
            ((this.namedContent==null && other.getNamedContent()==null) || 
             (this.namedContent!=null &&
              this.namedContent.equals(other.getNamedContent()))) &&
            ((this.fn==null && other.getFn()==null) || 
             (this.fn!=null &&
              this.fn.equals(other.getFn()))) &&
            ((this.target==null && other.getTarget()==null) || 
             (this.target!=null &&
              this.target.equals(other.getTarget()))) &&
            ((this.xref==null && other.getXref()==null) || 
             (this.xref!=null &&
              this.xref.equals(other.getXref()))) &&
            ((this.sub==null && other.getSub()==null) || 
             (this.sub!=null &&
              this.sub.equals(other.getSub()))) &&
            ((this.sup==null && other.getSup()==null) || 
             (this.sup!=null &&
              this.sup.equals(other.getSup()))) &&
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
            ((this.defList==null && other.getDefList()==null) || 
             (this.defList!=null &&
              this.defList.equals(other.getDefList()))) &&
            ((this.list==null && other.getList()==null) || 
             (this.list!=null &&
              this.list.equals(other.getList()))) &&
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
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.contentType==null && other.getContentType()==null) || 
             (this.contentType!=null &&
              this.contentType.equals(other.getContentType()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.href==null && other.getHref()==null) || 
             (this.href!=null &&
              this.href.equals(other.getHref()))) &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getExtLink() != null) {
            _hashCode += getExtLink().hashCode();
        }
        if (getUri() != null) {
            _hashCode += getUri().hashCode();
        }
        if (getInlineSupplementaryMaterial() != null) {
            _hashCode += getInlineSupplementaryMaterial().hashCode();
        }
        if (getRelatedArticle() != null) {
            _hashCode += getRelatedArticle().hashCode();
        }
        if (getFont() != null) {
            _hashCode += getFont().hashCode();
        }
        if (getHr() != null) {
            _hashCode += getHr().hashCode();
        }
        if (getBold() != null) {
            _hashCode += getBold().hashCode();
        }
        if (getItalic() != null) {
            _hashCode += getItalic().hashCode();
        }
        if (getMonospace() != null) {
            _hashCode += getMonospace().hashCode();
        }
        if (getOverline() != null) {
            _hashCode += getOverline().hashCode();
        }
        if (getOverlineStart() != null) {
            _hashCode += getOverlineStart().hashCode();
        }
        if (getOverlineEnd() != null) {
            _hashCode += getOverlineEnd().hashCode();
        }
        if (getSansSerif() != null) {
            _hashCode += getSansSerif().hashCode();
        }
        if (getSc() != null) {
            _hashCode += getSc().hashCode();
        }
        if (getStrike() != null) {
            _hashCode += getStrike().hashCode();
        }
        if (getUnderline() != null) {
            _hashCode += getUnderline().hashCode();
        }
        if (getUnderlineStart() != null) {
            _hashCode += getUnderlineStart().hashCode();
        }
        if (getUnderlineEnd() != null) {
            _hashCode += getUnderlineEnd().hashCode();
        }
        if (getInlineGraphic() != null) {
            _hashCode += getInlineGraphic().hashCode();
        }
        if (getPrivateChar() != null) {
            _hashCode += getPrivateChar().hashCode();
        }
        if (getInlineFormula() != null) {
            _hashCode += getInlineFormula().hashCode();
        }
        if (getTexMath() != null) {
            _hashCode += getTexMath().hashCode();
        }
        if (getMath() != null) {
            _hashCode += getMath().hashCode();
        }
        if (getAbbrev() != null) {
            _hashCode += getAbbrev().hashCode();
        }
        if (getMilestoneEnd() != null) {
            _hashCode += getMilestoneEnd().hashCode();
        }
        if (getMilestoneStart() != null) {
            _hashCode += getMilestoneStart().hashCode();
        }
        if (getNamedContent() != null) {
            _hashCode += getNamedContent().hashCode();
        }
        if (getFn() != null) {
            _hashCode += getFn().hashCode();
        }
        if (getTarget() != null) {
            _hashCode += getTarget().hashCode();
        }
        if (getXref() != null) {
            _hashCode += getXref().hashCode();
        }
        if (getSub() != null) {
            _hashCode += getSub().hashCode();
        }
        if (getSup() != null) {
            _hashCode += getSup().hashCode();
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
        if (getDefList() != null) {
            _hashCode += getDefList().hashCode();
        }
        if (getList() != null) {
            _hashCode += getList().hashCode();
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
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getHref() != null) {
            _hashCode += getHref().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
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
        new org.apache.axis.description.TypeDesc(NamedContent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">named-content"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">email"));
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
        elemField.setFieldName("uri");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "uri"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">uri"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineSupplementaryMaterial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-supplementary-material"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">inline-supplementary-material"));
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
        elemField.setFieldName("font");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "font"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">font"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "hr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">hr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bold");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "bold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">bold"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("italic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "italic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">italic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monospace");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "monospace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">monospace"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overline");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">overline"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overlineStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline-start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">overline-start"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overlineEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline-end"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">overline-end"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sansSerif");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sans-serif"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sans-serif"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strike");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "strike"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">strike"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underline");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">underline"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underlineStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline-start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">underline-start"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underlineEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline-end"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">underline-end"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineGraphic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-graphic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">inline-graphic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("privateChar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "private-char"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">private-char"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineFormula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-formula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">inline-formula"));
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
        elemField.setFieldName("abbrev");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "abbrev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">abbrev"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("milestoneEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "milestone-end"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">milestone-end"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("milestoneStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "milestone-start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">milestone-start"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("namedContent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "named-content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">named-content"));
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
        elemField.setFieldName("target");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "target"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">target"));
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
        elemField.setFieldName("sub");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">sup"));
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
