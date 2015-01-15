/**
 * ConfName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class ConfName  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email[] email;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink[] extLink;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri[] uri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial[] inlineSupplementaryMaterial;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle[] relatedArticle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font[] font;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr[] hr;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold[] bold;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic[] italic;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace[] monospace;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline[] overline;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart[] overlineStart;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd[] overlineEnd;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif[] sansSerif;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc[] sc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike[] strike;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline[] underline;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart[] underlineStart;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd[] underlineEnd;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic[] inlineGraphic;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar[] privateChar;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula[] inlineFormula;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath[] texMath;

    private org.w3.www._1998.Math.MathML.MathType[] math;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev[] abbrev;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd[] milestoneEnd;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart[] milestoneStart;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent[] namedContent;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn[] fn;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target[] target;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref[] xref;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub[] sub;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup[] sup;

    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private java.lang.Object contentType;  // attribute

    public ConfName() {
    }

    public ConfName(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email[] email,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink[] extLink,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri[] uri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial[] inlineSupplementaryMaterial,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle[] relatedArticle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font[] font,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr[] hr,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold[] bold,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic[] italic,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace[] monospace,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline[] overline,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart[] overlineStart,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd[] overlineEnd,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif[] sansSerif,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc[] sc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike[] strike,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline[] underline,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart[] underlineStart,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd[] underlineEnd,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic[] inlineGraphic,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar[] privateChar,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula[] inlineFormula,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath[] texMath,
           org.w3.www._1998.Math.MathML.MathType[] math,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev[] abbrev,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd[] milestoneEnd,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart[] milestoneStart,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent[] namedContent,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn[] fn,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target[] target,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref[] xref,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub[] sub,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup[] sup,
           org.apache.axis.message.MessageElement [] _any,
           java.lang.Object contentType) {
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
           this._any = _any;
           this.contentType = contentType;
    }


    /**
     * Gets the email value for this ConfName.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email[] getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ConfName.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email[] email) {
        this.email = email;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail(int i) {
        return this.email[i];
    }

    public void setEmail(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email _value) {
        this.email[i] = _value;
    }


    /**
     * Gets the extLink value for this ConfName.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink[] getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this ConfName.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink[] extLink) {
        this.extLink = extLink;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink(int i) {
        return this.extLink[i];
    }

    public void setExtLink(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink _value) {
        this.extLink[i] = _value;
    }


    /**
     * Gets the uri value for this ConfName.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri[] getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this ConfName.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri[] uri) {
        this.uri = uri;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri(int i) {
        return this.uri[i];
    }

    public void setUri(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri _value) {
        this.uri[i] = _value;
    }


    /**
     * Gets the inlineSupplementaryMaterial value for this ConfName.
     * 
     * @return inlineSupplementaryMaterial
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial[] getInlineSupplementaryMaterial() {
        return inlineSupplementaryMaterial;
    }


    /**
     * Sets the inlineSupplementaryMaterial value for this ConfName.
     * 
     * @param inlineSupplementaryMaterial
     */
    public void setInlineSupplementaryMaterial(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial[] inlineSupplementaryMaterial) {
        this.inlineSupplementaryMaterial = inlineSupplementaryMaterial;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial getInlineSupplementaryMaterial(int i) {
        return this.inlineSupplementaryMaterial[i];
    }

    public void setInlineSupplementaryMaterial(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial _value) {
        this.inlineSupplementaryMaterial[i] = _value;
    }


    /**
     * Gets the relatedArticle value for this ConfName.
     * 
     * @return relatedArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle[] getRelatedArticle() {
        return relatedArticle;
    }


    /**
     * Sets the relatedArticle value for this ConfName.
     * 
     * @param relatedArticle
     */
    public void setRelatedArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle[] relatedArticle) {
        this.relatedArticle = relatedArticle;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle getRelatedArticle(int i) {
        return this.relatedArticle[i];
    }

    public void setRelatedArticle(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle _value) {
        this.relatedArticle[i] = _value;
    }


    /**
     * Gets the font value for this ConfName.
     * 
     * @return font
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font[] getFont() {
        return font;
    }


    /**
     * Sets the font value for this ConfName.
     * 
     * @param font
     */
    public void setFont(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font[] font) {
        this.font = font;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font getFont(int i) {
        return this.font[i];
    }

    public void setFont(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font _value) {
        this.font[i] = _value;
    }


    /**
     * Gets the hr value for this ConfName.
     * 
     * @return hr
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr[] getHr() {
        return hr;
    }


    /**
     * Sets the hr value for this ConfName.
     * 
     * @param hr
     */
    public void setHr(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr[] hr) {
        this.hr = hr;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr getHr(int i) {
        return this.hr[i];
    }

    public void setHr(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr _value) {
        this.hr[i] = _value;
    }


    /**
     * Gets the bold value for this ConfName.
     * 
     * @return bold
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold[] getBold() {
        return bold;
    }


    /**
     * Sets the bold value for this ConfName.
     * 
     * @param bold
     */
    public void setBold(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold[] bold) {
        this.bold = bold;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold getBold(int i) {
        return this.bold[i];
    }

    public void setBold(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold _value) {
        this.bold[i] = _value;
    }


    /**
     * Gets the italic value for this ConfName.
     * 
     * @return italic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic[] getItalic() {
        return italic;
    }


    /**
     * Sets the italic value for this ConfName.
     * 
     * @param italic
     */
    public void setItalic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic[] italic) {
        this.italic = italic;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic getItalic(int i) {
        return this.italic[i];
    }

    public void setItalic(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic _value) {
        this.italic[i] = _value;
    }


    /**
     * Gets the monospace value for this ConfName.
     * 
     * @return monospace
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace[] getMonospace() {
        return monospace;
    }


    /**
     * Sets the monospace value for this ConfName.
     * 
     * @param monospace
     */
    public void setMonospace(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace[] monospace) {
        this.monospace = monospace;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace getMonospace(int i) {
        return this.monospace[i];
    }

    public void setMonospace(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace _value) {
        this.monospace[i] = _value;
    }


    /**
     * Gets the overline value for this ConfName.
     * 
     * @return overline
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline[] getOverline() {
        return overline;
    }


    /**
     * Sets the overline value for this ConfName.
     * 
     * @param overline
     */
    public void setOverline(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline[] overline) {
        this.overline = overline;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline getOverline(int i) {
        return this.overline[i];
    }

    public void setOverline(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline _value) {
        this.overline[i] = _value;
    }


    /**
     * Gets the overlineStart value for this ConfName.
     * 
     * @return overlineStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart[] getOverlineStart() {
        return overlineStart;
    }


    /**
     * Sets the overlineStart value for this ConfName.
     * 
     * @param overlineStart
     */
    public void setOverlineStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart[] overlineStart) {
        this.overlineStart = overlineStart;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart getOverlineStart(int i) {
        return this.overlineStart[i];
    }

    public void setOverlineStart(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart _value) {
        this.overlineStart[i] = _value;
    }


    /**
     * Gets the overlineEnd value for this ConfName.
     * 
     * @return overlineEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd[] getOverlineEnd() {
        return overlineEnd;
    }


    /**
     * Sets the overlineEnd value for this ConfName.
     * 
     * @param overlineEnd
     */
    public void setOverlineEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd[] overlineEnd) {
        this.overlineEnd = overlineEnd;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd getOverlineEnd(int i) {
        return this.overlineEnd[i];
    }

    public void setOverlineEnd(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd _value) {
        this.overlineEnd[i] = _value;
    }


    /**
     * Gets the sansSerif value for this ConfName.
     * 
     * @return sansSerif
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif[] getSansSerif() {
        return sansSerif;
    }


    /**
     * Sets the sansSerif value for this ConfName.
     * 
     * @param sansSerif
     */
    public void setSansSerif(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif[] sansSerif) {
        this.sansSerif = sansSerif;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif getSansSerif(int i) {
        return this.sansSerif[i];
    }

    public void setSansSerif(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif _value) {
        this.sansSerif[i] = _value;
    }


    /**
     * Gets the sc value for this ConfName.
     * 
     * @return sc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc[] getSc() {
        return sc;
    }


    /**
     * Sets the sc value for this ConfName.
     * 
     * @param sc
     */
    public void setSc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc[] sc) {
        this.sc = sc;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc getSc(int i) {
        return this.sc[i];
    }

    public void setSc(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc _value) {
        this.sc[i] = _value;
    }


    /**
     * Gets the strike value for this ConfName.
     * 
     * @return strike
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike[] getStrike() {
        return strike;
    }


    /**
     * Sets the strike value for this ConfName.
     * 
     * @param strike
     */
    public void setStrike(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike[] strike) {
        this.strike = strike;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike getStrike(int i) {
        return this.strike[i];
    }

    public void setStrike(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike _value) {
        this.strike[i] = _value;
    }


    /**
     * Gets the underline value for this ConfName.
     * 
     * @return underline
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline[] getUnderline() {
        return underline;
    }


    /**
     * Sets the underline value for this ConfName.
     * 
     * @param underline
     */
    public void setUnderline(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline[] underline) {
        this.underline = underline;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline getUnderline(int i) {
        return this.underline[i];
    }

    public void setUnderline(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline _value) {
        this.underline[i] = _value;
    }


    /**
     * Gets the underlineStart value for this ConfName.
     * 
     * @return underlineStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart[] getUnderlineStart() {
        return underlineStart;
    }


    /**
     * Sets the underlineStart value for this ConfName.
     * 
     * @param underlineStart
     */
    public void setUnderlineStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart[] underlineStart) {
        this.underlineStart = underlineStart;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart getUnderlineStart(int i) {
        return this.underlineStart[i];
    }

    public void setUnderlineStart(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart _value) {
        this.underlineStart[i] = _value;
    }


    /**
     * Gets the underlineEnd value for this ConfName.
     * 
     * @return underlineEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd[] getUnderlineEnd() {
        return underlineEnd;
    }


    /**
     * Sets the underlineEnd value for this ConfName.
     * 
     * @param underlineEnd
     */
    public void setUnderlineEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd[] underlineEnd) {
        this.underlineEnd = underlineEnd;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd getUnderlineEnd(int i) {
        return this.underlineEnd[i];
    }

    public void setUnderlineEnd(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd _value) {
        this.underlineEnd[i] = _value;
    }


    /**
     * Gets the inlineGraphic value for this ConfName.
     * 
     * @return inlineGraphic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic[] getInlineGraphic() {
        return inlineGraphic;
    }


    /**
     * Sets the inlineGraphic value for this ConfName.
     * 
     * @param inlineGraphic
     */
    public void setInlineGraphic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic[] inlineGraphic) {
        this.inlineGraphic = inlineGraphic;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic getInlineGraphic(int i) {
        return this.inlineGraphic[i];
    }

    public void setInlineGraphic(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic _value) {
        this.inlineGraphic[i] = _value;
    }


    /**
     * Gets the privateChar value for this ConfName.
     * 
     * @return privateChar
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar[] getPrivateChar() {
        return privateChar;
    }


    /**
     * Sets the privateChar value for this ConfName.
     * 
     * @param privateChar
     */
    public void setPrivateChar(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar[] privateChar) {
        this.privateChar = privateChar;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar getPrivateChar(int i) {
        return this.privateChar[i];
    }

    public void setPrivateChar(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar _value) {
        this.privateChar[i] = _value;
    }


    /**
     * Gets the inlineFormula value for this ConfName.
     * 
     * @return inlineFormula
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula[] getInlineFormula() {
        return inlineFormula;
    }


    /**
     * Sets the inlineFormula value for this ConfName.
     * 
     * @param inlineFormula
     */
    public void setInlineFormula(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula[] inlineFormula) {
        this.inlineFormula = inlineFormula;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula getInlineFormula(int i) {
        return this.inlineFormula[i];
    }

    public void setInlineFormula(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula _value) {
        this.inlineFormula[i] = _value;
    }


    /**
     * Gets the texMath value for this ConfName.
     * 
     * @return texMath
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath[] getTexMath() {
        return texMath;
    }


    /**
     * Sets the texMath value for this ConfName.
     * 
     * @param texMath
     */
    public void setTexMath(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath[] texMath) {
        this.texMath = texMath;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath getTexMath(int i) {
        return this.texMath[i];
    }

    public void setTexMath(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath _value) {
        this.texMath[i] = _value;
    }


    /**
     * Gets the math value for this ConfName.
     * 
     * @return math
     */
    public org.w3.www._1998.Math.MathML.MathType[] getMath() {
        return math;
    }


    /**
     * Sets the math value for this ConfName.
     * 
     * @param math
     */
    public void setMath(org.w3.www._1998.Math.MathML.MathType[] math) {
        this.math = math;
    }

    public org.w3.www._1998.Math.MathML.MathType getMath(int i) {
        return this.math[i];
    }

    public void setMath(int i, org.w3.www._1998.Math.MathML.MathType _value) {
        this.math[i] = _value;
    }


    /**
     * Gets the abbrev value for this ConfName.
     * 
     * @return abbrev
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev[] getAbbrev() {
        return abbrev;
    }


    /**
     * Sets the abbrev value for this ConfName.
     * 
     * @param abbrev
     */
    public void setAbbrev(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev[] abbrev) {
        this.abbrev = abbrev;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev getAbbrev(int i) {
        return this.abbrev[i];
    }

    public void setAbbrev(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev _value) {
        this.abbrev[i] = _value;
    }


    /**
     * Gets the milestoneEnd value for this ConfName.
     * 
     * @return milestoneEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd[] getMilestoneEnd() {
        return milestoneEnd;
    }


    /**
     * Sets the milestoneEnd value for this ConfName.
     * 
     * @param milestoneEnd
     */
    public void setMilestoneEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd[] milestoneEnd) {
        this.milestoneEnd = milestoneEnd;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd getMilestoneEnd(int i) {
        return this.milestoneEnd[i];
    }

    public void setMilestoneEnd(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd _value) {
        this.milestoneEnd[i] = _value;
    }


    /**
     * Gets the milestoneStart value for this ConfName.
     * 
     * @return milestoneStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart[] getMilestoneStart() {
        return milestoneStart;
    }


    /**
     * Sets the milestoneStart value for this ConfName.
     * 
     * @param milestoneStart
     */
    public void setMilestoneStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart[] milestoneStart) {
        this.milestoneStart = milestoneStart;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart getMilestoneStart(int i) {
        return this.milestoneStart[i];
    }

    public void setMilestoneStart(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart _value) {
        this.milestoneStart[i] = _value;
    }


    /**
     * Gets the namedContent value for this ConfName.
     * 
     * @return namedContent
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent[] getNamedContent() {
        return namedContent;
    }


    /**
     * Sets the namedContent value for this ConfName.
     * 
     * @param namedContent
     */
    public void setNamedContent(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent[] namedContent) {
        this.namedContent = namedContent;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent getNamedContent(int i) {
        return this.namedContent[i];
    }

    public void setNamedContent(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent _value) {
        this.namedContent[i] = _value;
    }


    /**
     * Gets the fn value for this ConfName.
     * 
     * @return fn
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn[] getFn() {
        return fn;
    }


    /**
     * Sets the fn value for this ConfName.
     * 
     * @param fn
     */
    public void setFn(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn[] fn) {
        this.fn = fn;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn getFn(int i) {
        return this.fn[i];
    }

    public void setFn(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn _value) {
        this.fn[i] = _value;
    }


    /**
     * Gets the target value for this ConfName.
     * 
     * @return target
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target[] getTarget() {
        return target;
    }


    /**
     * Sets the target value for this ConfName.
     * 
     * @param target
     */
    public void setTarget(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target[] target) {
        this.target = target;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target getTarget(int i) {
        return this.target[i];
    }

    public void setTarget(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target _value) {
        this.target[i] = _value;
    }


    /**
     * Gets the xref value for this ConfName.
     * 
     * @return xref
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref[] getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this ConfName.
     * 
     * @param xref
     */
    public void setXref(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref[] xref) {
        this.xref = xref;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref getXref(int i) {
        return this.xref[i];
    }

    public void setXref(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref _value) {
        this.xref[i] = _value;
    }


    /**
     * Gets the sub value for this ConfName.
     * 
     * @return sub
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub[] getSub() {
        return sub;
    }


    /**
     * Sets the sub value for this ConfName.
     * 
     * @param sub
     */
    public void setSub(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub[] sub) {
        this.sub = sub;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub getSub(int i) {
        return this.sub[i];
    }

    public void setSub(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub _value) {
        this.sub[i] = _value;
    }


    /**
     * Gets the sup value for this ConfName.
     * 
     * @return sup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup[] getSup() {
        return sup;
    }


    /**
     * Sets the sup value for this ConfName.
     * 
     * @param sup
     */
    public void setSup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup[] sup) {
        this.sup = sup;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup getSup(int i) {
        return this.sup[i];
    }

    public void setSup(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup _value) {
        this.sup[i] = _value;
    }


    /**
     * Gets the _any value for this ConfName.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this ConfName.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the contentType value for this ConfName.
     * 
     * @return contentType
     */
    public java.lang.Object getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this ConfName.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.Object contentType) {
        this.contentType = contentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfName)) return false;
        ConfName other = (ConfName) obj;
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
              java.util.Arrays.equals(this.email, other.getEmail()))) &&
            ((this.extLink==null && other.getExtLink()==null) || 
             (this.extLink!=null &&
              java.util.Arrays.equals(this.extLink, other.getExtLink()))) &&
            ((this.uri==null && other.getUri()==null) || 
             (this.uri!=null &&
              java.util.Arrays.equals(this.uri, other.getUri()))) &&
            ((this.inlineSupplementaryMaterial==null && other.getInlineSupplementaryMaterial()==null) || 
             (this.inlineSupplementaryMaterial!=null &&
              java.util.Arrays.equals(this.inlineSupplementaryMaterial, other.getInlineSupplementaryMaterial()))) &&
            ((this.relatedArticle==null && other.getRelatedArticle()==null) || 
             (this.relatedArticle!=null &&
              java.util.Arrays.equals(this.relatedArticle, other.getRelatedArticle()))) &&
            ((this.font==null && other.getFont()==null) || 
             (this.font!=null &&
              java.util.Arrays.equals(this.font, other.getFont()))) &&
            ((this.hr==null && other.getHr()==null) || 
             (this.hr!=null &&
              java.util.Arrays.equals(this.hr, other.getHr()))) &&
            ((this.bold==null && other.getBold()==null) || 
             (this.bold!=null &&
              java.util.Arrays.equals(this.bold, other.getBold()))) &&
            ((this.italic==null && other.getItalic()==null) || 
             (this.italic!=null &&
              java.util.Arrays.equals(this.italic, other.getItalic()))) &&
            ((this.monospace==null && other.getMonospace()==null) || 
             (this.monospace!=null &&
              java.util.Arrays.equals(this.monospace, other.getMonospace()))) &&
            ((this.overline==null && other.getOverline()==null) || 
             (this.overline!=null &&
              java.util.Arrays.equals(this.overline, other.getOverline()))) &&
            ((this.overlineStart==null && other.getOverlineStart()==null) || 
             (this.overlineStart!=null &&
              java.util.Arrays.equals(this.overlineStart, other.getOverlineStart()))) &&
            ((this.overlineEnd==null && other.getOverlineEnd()==null) || 
             (this.overlineEnd!=null &&
              java.util.Arrays.equals(this.overlineEnd, other.getOverlineEnd()))) &&
            ((this.sansSerif==null && other.getSansSerif()==null) || 
             (this.sansSerif!=null &&
              java.util.Arrays.equals(this.sansSerif, other.getSansSerif()))) &&
            ((this.sc==null && other.getSc()==null) || 
             (this.sc!=null &&
              java.util.Arrays.equals(this.sc, other.getSc()))) &&
            ((this.strike==null && other.getStrike()==null) || 
             (this.strike!=null &&
              java.util.Arrays.equals(this.strike, other.getStrike()))) &&
            ((this.underline==null && other.getUnderline()==null) || 
             (this.underline!=null &&
              java.util.Arrays.equals(this.underline, other.getUnderline()))) &&
            ((this.underlineStart==null && other.getUnderlineStart()==null) || 
             (this.underlineStart!=null &&
              java.util.Arrays.equals(this.underlineStart, other.getUnderlineStart()))) &&
            ((this.underlineEnd==null && other.getUnderlineEnd()==null) || 
             (this.underlineEnd!=null &&
              java.util.Arrays.equals(this.underlineEnd, other.getUnderlineEnd()))) &&
            ((this.inlineGraphic==null && other.getInlineGraphic()==null) || 
             (this.inlineGraphic!=null &&
              java.util.Arrays.equals(this.inlineGraphic, other.getInlineGraphic()))) &&
            ((this.privateChar==null && other.getPrivateChar()==null) || 
             (this.privateChar!=null &&
              java.util.Arrays.equals(this.privateChar, other.getPrivateChar()))) &&
            ((this.inlineFormula==null && other.getInlineFormula()==null) || 
             (this.inlineFormula!=null &&
              java.util.Arrays.equals(this.inlineFormula, other.getInlineFormula()))) &&
            ((this.texMath==null && other.getTexMath()==null) || 
             (this.texMath!=null &&
              java.util.Arrays.equals(this.texMath, other.getTexMath()))) &&
            ((this.math==null && other.getMath()==null) || 
             (this.math!=null &&
              java.util.Arrays.equals(this.math, other.getMath()))) &&
            ((this.abbrev==null && other.getAbbrev()==null) || 
             (this.abbrev!=null &&
              java.util.Arrays.equals(this.abbrev, other.getAbbrev()))) &&
            ((this.milestoneEnd==null && other.getMilestoneEnd()==null) || 
             (this.milestoneEnd!=null &&
              java.util.Arrays.equals(this.milestoneEnd, other.getMilestoneEnd()))) &&
            ((this.milestoneStart==null && other.getMilestoneStart()==null) || 
             (this.milestoneStart!=null &&
              java.util.Arrays.equals(this.milestoneStart, other.getMilestoneStart()))) &&
            ((this.namedContent==null && other.getNamedContent()==null) || 
             (this.namedContent!=null &&
              java.util.Arrays.equals(this.namedContent, other.getNamedContent()))) &&
            ((this.fn==null && other.getFn()==null) || 
             (this.fn!=null &&
              java.util.Arrays.equals(this.fn, other.getFn()))) &&
            ((this.target==null && other.getTarget()==null) || 
             (this.target!=null &&
              java.util.Arrays.equals(this.target, other.getTarget()))) &&
            ((this.xref==null && other.getXref()==null) || 
             (this.xref!=null &&
              java.util.Arrays.equals(this.xref, other.getXref()))) &&
            ((this.sub==null && other.getSub()==null) || 
             (this.sub!=null &&
              java.util.Arrays.equals(this.sub, other.getSub()))) &&
            ((this.sup==null && other.getSup()==null) || 
             (this.sup!=null &&
              java.util.Arrays.equals(this.sup, other.getSup()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
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
        if (getEmail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEmail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEmail(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtLink() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExtLink());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExtLink(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUri() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUri());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUri(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInlineSupplementaryMaterial() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInlineSupplementaryMaterial());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInlineSupplementaryMaterial(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRelatedArticle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRelatedArticle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRelatedArticle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFont() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFont());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFont(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBold() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBold());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBold(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getItalic() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItalic());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItalic(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMonospace() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMonospace());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMonospace(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOverline() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOverline());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOverline(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOverlineStart() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOverlineStart());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOverlineStart(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOverlineEnd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOverlineEnd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOverlineEnd(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSansSerif() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSansSerif());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSansSerif(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSc() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSc());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSc(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStrike() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStrike());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStrike(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUnderline() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnderline());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnderline(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUnderlineStart() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnderlineStart());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnderlineStart(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUnderlineEnd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnderlineEnd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnderlineEnd(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInlineGraphic() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInlineGraphic());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInlineGraphic(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrivateChar() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrivateChar());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrivateChar(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInlineFormula() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInlineFormula());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInlineFormula(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTexMath() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTexMath());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTexMath(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMath() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMath());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMath(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAbbrev() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAbbrev());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAbbrev(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMilestoneEnd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMilestoneEnd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMilestoneEnd(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMilestoneStart() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMilestoneStart());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMilestoneStart(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNamedContent() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNamedContent());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNamedContent(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFn(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTarget() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTarget());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTarget(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getXref() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getXref());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getXref(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSub() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSub());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSub(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-name"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("contentType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "content-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "email"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extLink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "ext-link"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "ext-link"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uri");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "uri"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "uri"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineSupplementaryMaterial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-supplementary-material"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-supplementary-material"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedArticle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "related-article"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "related-article"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("font");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "font"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "font"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "hr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "hr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bold");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "bold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "bold"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("italic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "italic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "italic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monospace");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "monospace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "monospace"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overline");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overlineStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline-start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline-start"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overlineEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline-end"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "overline-end"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sansSerif");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sans-serif"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sans-serif"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strike");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "strike"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "strike"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underline");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underlineStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline-start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline-start"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underlineEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline-end"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "underline-end"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineGraphic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-graphic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-graphic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("privateChar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "private-char"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "private-char"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineFormula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-formula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "inline-formula"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("texMath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "tex-math"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "tex-math"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("math");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "math"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "math"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abbrev");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "abbrev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "abbrev"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("milestoneEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "milestone-end"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "milestone-end"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("milestoneStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "milestone-start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "milestone-start"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("namedContent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "named-content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "named-content"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("target");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "target"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "target"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "xref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "xref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sub");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "sup"));
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
