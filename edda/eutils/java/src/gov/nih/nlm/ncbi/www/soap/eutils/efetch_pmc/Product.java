/**
 * Product.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class Product  implements java.io.Serializable, org.apache.axis.encoding.MixedContentType {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial inlineSupplementaryMaterial;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font font;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr hr;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._break _break;

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

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath;

    private org.w3.www._1998.Math.MathML.MathType math;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev abbrev;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd milestoneEnd;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart milestoneStart;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent namedContent;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Price price;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate accessDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] annotation;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle articleTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment comment;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate confDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc confLoc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName confName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor confSponsor;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Date date;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition edition;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Gov gov;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Institution institution;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Isbn isbn;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issn issn;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId issueId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle issueTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId objectId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount pageCount;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent patent;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup personGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId pubId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role role;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series series;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source source;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Std std;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringDate stringDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp timeStamp;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource transSource;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle transTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId volumeId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target target;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Size size;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub sub;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup sup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private org.apache.axis.message.MessageElement [] _any;  // attribute

    private java.lang.String id;  // attribute

    private java.lang.Object productType;  // attribute

    private org.w3.www._1999.xlink.Type type;  // attribute

    private java.lang.Object href;  // attribute

    private java.lang.Object role2;  // attribute

    private java.lang.Object title;  // attribute

    private org.w3.www._1999.xlink.Show show;  // attribute

    private org.w3.www._1999.xlink.Actuate actuate;  // attribute

    public Product() {
    }

    public Product(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial inlineSupplementaryMaterial,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font font,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr hr,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._break _break,
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
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath,
           org.w3.www._1998.Math.MathML.MathType math,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev abbrev,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd milestoneEnd,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart milestoneStart,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent namedContent,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Price price,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate accessDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] annotation,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle articleTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment comment,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate confDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc confLoc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName confName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor confSponsor,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Date date,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition edition,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Gov gov,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Institution institution,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Isbn isbn,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issn issn,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId issueId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle issueTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId objectId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount pageCount,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent patent,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup personGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId pubId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role role,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series series,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source source,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Std std,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringDate stringDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp timeStamp,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource transSource,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle transTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId volumeId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target target,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Size size,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub sub,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup sup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           org.apache.axis.message.MessageElement [] _any,
           java.lang.String id,
           java.lang.Object productType,
           org.w3.www._1999.xlink.Type type,
           java.lang.Object href,
           java.lang.Object role2,
           java.lang.Object title,
           org.w3.www._1999.xlink.Show show,
           org.w3.www._1999.xlink.Actuate actuate) {
           this.inlineSupplementaryMaterial = inlineSupplementaryMaterial;
           this.relatedArticle = relatedArticle;
           this.font = font;
           this.hr = hr;
           this._break = _break;
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
           this.label = label;
           this.texMath = texMath;
           this.math = math;
           this.abbrev = abbrev;
           this.milestoneEnd = milestoneEnd;
           this.milestoneStart = milestoneStart;
           this.namedContent = namedContent;
           this.price = price;
           this.accessDate = accessDate;
           this.annotation = annotation;
           this.articleTitle = articleTitle;
           this.collab = collab;
           this.comment = comment;
           this.confDate = confDate;
           this.confLoc = confLoc;
           this.confName = confName;
           this.confSponsor = confSponsor;
           this.date = date;
           this.day = day;
           this.edition = edition;
           this.email = email;
           this.elocationId = elocationId;
           this.etal = etal;
           this.extLink = extLink;
           this.fpage = fpage;
           this.gov = gov;
           this.institution = institution;
           this.isbn = isbn;
           this.issn = issn;
           this.issue = issue;
           this.issueId = issueId;
           this.issueTitle = issueTitle;
           this.lpage = lpage;
           this.month = month;
           this.name = name;
           this.objectId = objectId;
           this.pageCount = pageCount;
           this.pageRange = pageRange;
           this.patent = patent;
           this.personGroup = personGroup;
           this.pubId = pubId;
           this.publisherLoc = publisherLoc;
           this.publisherName = publisherName;
           this.role = role;
           this.season = season;
           this.series = series;
           this.source = source;
           this.std = std;
           this.stringDate = stringDate;
           this.stringName = stringName;
           this.supplement = supplement;
           this.timeStamp = timeStamp;
           this.transSource = transSource;
           this.transTitle = transTitle;
           this.uri = uri;
           this.volume = volume;
           this.volumeId = volumeId;
           this.year = year;
           this.fn = fn;
           this.target = target;
           this.xref = xref;
           this.size = size;
           this.sub = sub;
           this.sup = sup;
           this.x = x;
           this._any = _any;
           this.id = id;
           this.productType = productType;
           this.type = type;
           this.href = href;
           this.role2 = role2;
           this.title = title;
           this.show = show;
           this.actuate = actuate;
    }


    /**
     * Gets the inlineSupplementaryMaterial value for this Product.
     * 
     * @return inlineSupplementaryMaterial
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial getInlineSupplementaryMaterial() {
        return inlineSupplementaryMaterial;
    }


    /**
     * Sets the inlineSupplementaryMaterial value for this Product.
     * 
     * @param inlineSupplementaryMaterial
     */
    public void setInlineSupplementaryMaterial(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineSupplementaryMaterial inlineSupplementaryMaterial) {
        this.inlineSupplementaryMaterial = inlineSupplementaryMaterial;
    }


    /**
     * Gets the relatedArticle value for this Product.
     * 
     * @return relatedArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle getRelatedArticle() {
        return relatedArticle;
    }


    /**
     * Sets the relatedArticle value for this Product.
     * 
     * @param relatedArticle
     */
    public void setRelatedArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle relatedArticle) {
        this.relatedArticle = relatedArticle;
    }


    /**
     * Gets the font value for this Product.
     * 
     * @return font
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font getFont() {
        return font;
    }


    /**
     * Sets the font value for this Product.
     * 
     * @param font
     */
    public void setFont(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Font font) {
        this.font = font;
    }


    /**
     * Gets the hr value for this Product.
     * 
     * @return hr
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr getHr() {
        return hr;
    }


    /**
     * Sets the hr value for this Product.
     * 
     * @param hr
     */
    public void setHr(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Hr hr) {
        this.hr = hr;
    }


    /**
     * Gets the _break value for this Product.
     * 
     * @return _break
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._break get_break() {
        return _break;
    }


    /**
     * Sets the _break value for this Product.
     * 
     * @param _break
     */
    public void set_break(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._break _break) {
        this._break = _break;
    }


    /**
     * Gets the bold value for this Product.
     * 
     * @return bold
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold getBold() {
        return bold;
    }


    /**
     * Sets the bold value for this Product.
     * 
     * @param bold
     */
    public void setBold(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Bold bold) {
        this.bold = bold;
    }


    /**
     * Gets the italic value for this Product.
     * 
     * @return italic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic getItalic() {
        return italic;
    }


    /**
     * Sets the italic value for this Product.
     * 
     * @param italic
     */
    public void setItalic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Italic italic) {
        this.italic = italic;
    }


    /**
     * Gets the monospace value for this Product.
     * 
     * @return monospace
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace getMonospace() {
        return monospace;
    }


    /**
     * Sets the monospace value for this Product.
     * 
     * @param monospace
     */
    public void setMonospace(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Monospace monospace) {
        this.monospace = monospace;
    }


    /**
     * Gets the overline value for this Product.
     * 
     * @return overline
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline getOverline() {
        return overline;
    }


    /**
     * Sets the overline value for this Product.
     * 
     * @param overline
     */
    public void setOverline(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Overline overline) {
        this.overline = overline;
    }


    /**
     * Gets the overlineStart value for this Product.
     * 
     * @return overlineStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart getOverlineStart() {
        return overlineStart;
    }


    /**
     * Sets the overlineStart value for this Product.
     * 
     * @param overlineStart
     */
    public void setOverlineStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineStart overlineStart) {
        this.overlineStart = overlineStart;
    }


    /**
     * Gets the overlineEnd value for this Product.
     * 
     * @return overlineEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd getOverlineEnd() {
        return overlineEnd;
    }


    /**
     * Sets the overlineEnd value for this Product.
     * 
     * @param overlineEnd
     */
    public void setOverlineEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.OverlineEnd overlineEnd) {
        this.overlineEnd = overlineEnd;
    }


    /**
     * Gets the sansSerif value for this Product.
     * 
     * @return sansSerif
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif getSansSerif() {
        return sansSerif;
    }


    /**
     * Sets the sansSerif value for this Product.
     * 
     * @param sansSerif
     */
    public void setSansSerif(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SansSerif sansSerif) {
        this.sansSerif = sansSerif;
    }


    /**
     * Gets the sc value for this Product.
     * 
     * @return sc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc getSc() {
        return sc;
    }


    /**
     * Sets the sc value for this Product.
     * 
     * @param sc
     */
    public void setSc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sc sc) {
        this.sc = sc;
    }


    /**
     * Gets the strike value for this Product.
     * 
     * @return strike
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike getStrike() {
        return strike;
    }


    /**
     * Sets the strike value for this Product.
     * 
     * @param strike
     */
    public void setStrike(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Strike strike) {
        this.strike = strike;
    }


    /**
     * Gets the underline value for this Product.
     * 
     * @return underline
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline getUnderline() {
        return underline;
    }


    /**
     * Sets the underline value for this Product.
     * 
     * @param underline
     */
    public void setUnderline(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Underline underline) {
        this.underline = underline;
    }


    /**
     * Gets the underlineStart value for this Product.
     * 
     * @return underlineStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart getUnderlineStart() {
        return underlineStart;
    }


    /**
     * Sets the underlineStart value for this Product.
     * 
     * @param underlineStart
     */
    public void setUnderlineStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineStart underlineStart) {
        this.underlineStart = underlineStart;
    }


    /**
     * Gets the underlineEnd value for this Product.
     * 
     * @return underlineEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd getUnderlineEnd() {
        return underlineEnd;
    }


    /**
     * Sets the underlineEnd value for this Product.
     * 
     * @param underlineEnd
     */
    public void setUnderlineEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.UnderlineEnd underlineEnd) {
        this.underlineEnd = underlineEnd;
    }


    /**
     * Gets the inlineGraphic value for this Product.
     * 
     * @return inlineGraphic
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic getInlineGraphic() {
        return inlineGraphic;
    }


    /**
     * Sets the inlineGraphic value for this Product.
     * 
     * @param inlineGraphic
     */
    public void setInlineGraphic(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineGraphic inlineGraphic) {
        this.inlineGraphic = inlineGraphic;
    }


    /**
     * Gets the privateChar value for this Product.
     * 
     * @return privateChar
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar getPrivateChar() {
        return privateChar;
    }


    /**
     * Sets the privateChar value for this Product.
     * 
     * @param privateChar
     */
    public void setPrivateChar(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PrivateChar privateChar) {
        this.privateChar = privateChar;
    }


    /**
     * Gets the inlineFormula value for this Product.
     * 
     * @return inlineFormula
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula getInlineFormula() {
        return inlineFormula;
    }


    /**
     * Sets the inlineFormula value for this Product.
     * 
     * @param inlineFormula
     */
    public void setInlineFormula(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.InlineFormula inlineFormula) {
        this.inlineFormula = inlineFormula;
    }


    /**
     * Gets the label value for this Product.
     * 
     * @return label
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label getLabel() {
        return label;
    }


    /**
     * Sets the label value for this Product.
     * 
     * @param label
     */
    public void setLabel(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Label label) {
        this.label = label;
    }


    /**
     * Gets the texMath value for this Product.
     * 
     * @return texMath
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath getTexMath() {
        return texMath;
    }


    /**
     * Sets the texMath value for this Product.
     * 
     * @param texMath
     */
    public void setTexMath(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TexMath texMath) {
        this.texMath = texMath;
    }


    /**
     * Gets the math value for this Product.
     * 
     * @return math
     */
    public org.w3.www._1998.Math.MathML.MathType getMath() {
        return math;
    }


    /**
     * Sets the math value for this Product.
     * 
     * @param math
     */
    public void setMath(org.w3.www._1998.Math.MathML.MathType math) {
        this.math = math;
    }


    /**
     * Gets the abbrev value for this Product.
     * 
     * @return abbrev
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev getAbbrev() {
        return abbrev;
    }


    /**
     * Sets the abbrev value for this Product.
     * 
     * @param abbrev
     */
    public void setAbbrev(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Abbrev abbrev) {
        this.abbrev = abbrev;
    }


    /**
     * Gets the milestoneEnd value for this Product.
     * 
     * @return milestoneEnd
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd getMilestoneEnd() {
        return milestoneEnd;
    }


    /**
     * Sets the milestoneEnd value for this Product.
     * 
     * @param milestoneEnd
     */
    public void setMilestoneEnd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneEnd milestoneEnd) {
        this.milestoneEnd = milestoneEnd;
    }


    /**
     * Gets the milestoneStart value for this Product.
     * 
     * @return milestoneStart
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart getMilestoneStart() {
        return milestoneStart;
    }


    /**
     * Sets the milestoneStart value for this Product.
     * 
     * @param milestoneStart
     */
    public void setMilestoneStart(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.MilestoneStart milestoneStart) {
        this.milestoneStart = milestoneStart;
    }


    /**
     * Gets the namedContent value for this Product.
     * 
     * @return namedContent
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent getNamedContent() {
        return namedContent;
    }


    /**
     * Sets the namedContent value for this Product.
     * 
     * @param namedContent
     */
    public void setNamedContent(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.NamedContent namedContent) {
        this.namedContent = namedContent;
    }


    /**
     * Gets the price value for this Product.
     * 
     * @return price
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Price getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Product.
     * 
     * @param price
     */
    public void setPrice(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Price price) {
        this.price = price;
    }


    /**
     * Gets the accessDate value for this Product.
     * 
     * @return accessDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate getAccessDate() {
        return accessDate;
    }


    /**
     * Sets the accessDate value for this Product.
     * 
     * @param accessDate
     */
    public void setAccessDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate accessDate) {
        this.accessDate = accessDate;
    }


    /**
     * Gets the annotation value for this Product.
     * 
     * @return annotation
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] getAnnotation() {
        return annotation;
    }


    /**
     * Sets the annotation value for this Product.
     * 
     * @param annotation
     */
    public void setAnnotation(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] annotation) {
        this.annotation = annotation;
    }


    /**
     * Gets the articleTitle value for this Product.
     * 
     * @return articleTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle getArticleTitle() {
        return articleTitle;
    }


    /**
     * Sets the articleTitle value for this Product.
     * 
     * @param articleTitle
     */
    public void setArticleTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle articleTitle) {
        this.articleTitle = articleTitle;
    }


    /**
     * Gets the collab value for this Product.
     * 
     * @return collab
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab getCollab() {
        return collab;
    }


    /**
     * Sets the collab value for this Product.
     * 
     * @param collab
     */
    public void setCollab(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab) {
        this.collab = collab;
    }


    /**
     * Gets the comment value for this Product.
     * 
     * @return comment
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this Product.
     * 
     * @param comment
     */
    public void setComment(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment comment) {
        this.comment = comment;
    }


    /**
     * Gets the confDate value for this Product.
     * 
     * @return confDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate getConfDate() {
        return confDate;
    }


    /**
     * Sets the confDate value for this Product.
     * 
     * @param confDate
     */
    public void setConfDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate confDate) {
        this.confDate = confDate;
    }


    /**
     * Gets the confLoc value for this Product.
     * 
     * @return confLoc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc getConfLoc() {
        return confLoc;
    }


    /**
     * Sets the confLoc value for this Product.
     * 
     * @param confLoc
     */
    public void setConfLoc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc confLoc) {
        this.confLoc = confLoc;
    }


    /**
     * Gets the confName value for this Product.
     * 
     * @return confName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName getConfName() {
        return confName;
    }


    /**
     * Sets the confName value for this Product.
     * 
     * @param confName
     */
    public void setConfName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName confName) {
        this.confName = confName;
    }


    /**
     * Gets the confSponsor value for this Product.
     * 
     * @return confSponsor
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor getConfSponsor() {
        return confSponsor;
    }


    /**
     * Sets the confSponsor value for this Product.
     * 
     * @param confSponsor
     */
    public void setConfSponsor(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfSponsor confSponsor) {
        this.confSponsor = confSponsor;
    }


    /**
     * Gets the date value for this Product.
     * 
     * @return date
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Date getDate() {
        return date;
    }


    /**
     * Sets the date value for this Product.
     * 
     * @param date
     */
    public void setDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Date date) {
        this.date = date;
    }


    /**
     * Gets the day value for this Product.
     * 
     * @return day
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day getDay() {
        return day;
    }


    /**
     * Sets the day value for this Product.
     * 
     * @param day
     */
    public void setDay(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day) {
        this.day = day;
    }


    /**
     * Gets the edition value for this Product.
     * 
     * @return edition
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition getEdition() {
        return edition;
    }


    /**
     * Sets the edition value for this Product.
     * 
     * @param edition
     */
    public void setEdition(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition edition) {
        this.edition = edition;
    }


    /**
     * Gets the email value for this Product.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Product.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email) {
        this.email = email;
    }


    /**
     * Gets the elocationId value for this Product.
     * 
     * @return elocationId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId getElocationId() {
        return elocationId;
    }


    /**
     * Sets the elocationId value for this Product.
     * 
     * @param elocationId
     */
    public void setElocationId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId) {
        this.elocationId = elocationId;
    }


    /**
     * Gets the etal value for this Product.
     * 
     * @return etal
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal getEtal() {
        return etal;
    }


    /**
     * Sets the etal value for this Product.
     * 
     * @param etal
     */
    public void setEtal(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Etal etal) {
        this.etal = etal;
    }


    /**
     * Gets the extLink value for this Product.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this Product.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink) {
        this.extLink = extLink;
    }


    /**
     * Gets the fpage value for this Product.
     * 
     * @return fpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage getFpage() {
        return fpage;
    }


    /**
     * Sets the fpage value for this Product.
     * 
     * @param fpage
     */
    public void setFpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage) {
        this.fpage = fpage;
    }


    /**
     * Gets the gov value for this Product.
     * 
     * @return gov
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Gov getGov() {
        return gov;
    }


    /**
     * Sets the gov value for this Product.
     * 
     * @param gov
     */
    public void setGov(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Gov gov) {
        this.gov = gov;
    }


    /**
     * Gets the institution value for this Product.
     * 
     * @return institution
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Institution getInstitution() {
        return institution;
    }


    /**
     * Sets the institution value for this Product.
     * 
     * @param institution
     */
    public void setInstitution(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Institution institution) {
        this.institution = institution;
    }


    /**
     * Gets the isbn value for this Product.
     * 
     * @return isbn
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Isbn getIsbn() {
        return isbn;
    }


    /**
     * Sets the isbn value for this Product.
     * 
     * @param isbn
     */
    public void setIsbn(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Isbn isbn) {
        this.isbn = isbn;
    }


    /**
     * Gets the issn value for this Product.
     * 
     * @return issn
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issn getIssn() {
        return issn;
    }


    /**
     * Sets the issn value for this Product.
     * 
     * @param issn
     */
    public void setIssn(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issn issn) {
        this.issn = issn;
    }


    /**
     * Gets the issue value for this Product.
     * 
     * @return issue
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue getIssue() {
        return issue;
    }


    /**
     * Sets the issue value for this Product.
     * 
     * @param issue
     */
    public void setIssue(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue) {
        this.issue = issue;
    }


    /**
     * Gets the issueId value for this Product.
     * 
     * @return issueId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId getIssueId() {
        return issueId;
    }


    /**
     * Sets the issueId value for this Product.
     * 
     * @param issueId
     */
    public void setIssueId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId issueId) {
        this.issueId = issueId;
    }


    /**
     * Gets the issueTitle value for this Product.
     * 
     * @return issueTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle getIssueTitle() {
        return issueTitle;
    }


    /**
     * Sets the issueTitle value for this Product.
     * 
     * @param issueTitle
     */
    public void setIssueTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle issueTitle) {
        this.issueTitle = issueTitle;
    }


    /**
     * Gets the lpage value for this Product.
     * 
     * @return lpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage getLpage() {
        return lpage;
    }


    /**
     * Sets the lpage value for this Product.
     * 
     * @param lpage
     */
    public void setLpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage) {
        this.lpage = lpage;
    }


    /**
     * Gets the month value for this Product.
     * 
     * @return month
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month getMonth() {
        return month;
    }


    /**
     * Sets the month value for this Product.
     * 
     * @param month
     */
    public void setMonth(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month) {
        this.month = month;
    }


    /**
     * Gets the name value for this Product.
     * 
     * @return name
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name getName() {
        return name;
    }


    /**
     * Sets the name value for this Product.
     * 
     * @param name
     */
    public void setName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Name name) {
        this.name = name;
    }


    /**
     * Gets the objectId value for this Product.
     * 
     * @return objectId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this Product.
     * 
     * @param objectId
     */
    public void setObjectId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ObjectId objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the pageCount value for this Product.
     * 
     * @return pageCount
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount getPageCount() {
        return pageCount;
    }


    /**
     * Sets the pageCount value for this Product.
     * 
     * @param pageCount
     */
    public void setPageCount(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount pageCount) {
        this.pageCount = pageCount;
    }


    /**
     * Gets the pageRange value for this Product.
     * 
     * @return pageRange
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange getPageRange() {
        return pageRange;
    }


    /**
     * Sets the pageRange value for this Product.
     * 
     * @param pageRange
     */
    public void setPageRange(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange) {
        this.pageRange = pageRange;
    }


    /**
     * Gets the patent value for this Product.
     * 
     * @return patent
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent getPatent() {
        return patent;
    }


    /**
     * Sets the patent value for this Product.
     * 
     * @param patent
     */
    public void setPatent(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent patent) {
        this.patent = patent;
    }


    /**
     * Gets the personGroup value for this Product.
     * 
     * @return personGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup getPersonGroup() {
        return personGroup;
    }


    /**
     * Sets the personGroup value for this Product.
     * 
     * @param personGroup
     */
    public void setPersonGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup personGroup) {
        this.personGroup = personGroup;
    }


    /**
     * Gets the pubId value for this Product.
     * 
     * @return pubId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this Product.
     * 
     * @param pubId
     */
    public void setPubId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId pubId) {
        this.pubId = pubId;
    }


    /**
     * Gets the publisherLoc value for this Product.
     * 
     * @return publisherLoc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc getPublisherLoc() {
        return publisherLoc;
    }


    /**
     * Sets the publisherLoc value for this Product.
     * 
     * @param publisherLoc
     */
    public void setPublisherLoc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc) {
        this.publisherLoc = publisherLoc;
    }


    /**
     * Gets the publisherName value for this Product.
     * 
     * @return publisherName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName getPublisherName() {
        return publisherName;
    }


    /**
     * Sets the publisherName value for this Product.
     * 
     * @param publisherName
     */
    public void setPublisherName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName) {
        this.publisherName = publisherName;
    }


    /**
     * Gets the role value for this Product.
     * 
     * @return role
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role getRole() {
        return role;
    }


    /**
     * Sets the role value for this Product.
     * 
     * @param role
     */
    public void setRole(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Role role) {
        this.role = role;
    }


    /**
     * Gets the season value for this Product.
     * 
     * @return season
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season getSeason() {
        return season;
    }


    /**
     * Sets the season value for this Product.
     * 
     * @param season
     */
    public void setSeason(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season) {
        this.season = season;
    }


    /**
     * Gets the series value for this Product.
     * 
     * @return series
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series getSeries() {
        return series;
    }


    /**
     * Sets the series value for this Product.
     * 
     * @param series
     */
    public void setSeries(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series series) {
        this.series = series;
    }


    /**
     * Gets the source value for this Product.
     * 
     * @return source
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source getSource() {
        return source;
    }


    /**
     * Sets the source value for this Product.
     * 
     * @param source
     */
    public void setSource(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source source) {
        this.source = source;
    }


    /**
     * Gets the std value for this Product.
     * 
     * @return std
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Std getStd() {
        return std;
    }


    /**
     * Sets the std value for this Product.
     * 
     * @param std
     */
    public void setStd(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Std std) {
        this.std = std;
    }


    /**
     * Gets the stringDate value for this Product.
     * 
     * @return stringDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringDate getStringDate() {
        return stringDate;
    }


    /**
     * Sets the stringDate value for this Product.
     * 
     * @param stringDate
     */
    public void setStringDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringDate stringDate) {
        this.stringDate = stringDate;
    }


    /**
     * Gets the stringName value for this Product.
     * 
     * @return stringName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName getStringName() {
        return stringName;
    }


    /**
     * Sets the stringName value for this Product.
     * 
     * @param stringName
     */
    public void setStringName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.StringName stringName) {
        this.stringName = stringName;
    }


    /**
     * Gets the supplement value for this Product.
     * 
     * @return supplement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement getSupplement() {
        return supplement;
    }


    /**
     * Sets the supplement value for this Product.
     * 
     * @param supplement
     */
    public void setSupplement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement) {
        this.supplement = supplement;
    }


    /**
     * Gets the timeStamp value for this Product.
     * 
     * @return timeStamp
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this Product.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the transSource value for this Product.
     * 
     * @return transSource
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource getTransSource() {
        return transSource;
    }


    /**
     * Sets the transSource value for this Product.
     * 
     * @param transSource
     */
    public void setTransSource(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource transSource) {
        this.transSource = transSource;
    }


    /**
     * Gets the transTitle value for this Product.
     * 
     * @return transTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle getTransTitle() {
        return transTitle;
    }


    /**
     * Sets the transTitle value for this Product.
     * 
     * @param transTitle
     */
    public void setTransTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle transTitle) {
        this.transTitle = transTitle;
    }


    /**
     * Gets the uri value for this Product.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this Product.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri) {
        this.uri = uri;
    }


    /**
     * Gets the volume value for this Product.
     * 
     * @return volume
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume getVolume() {
        return volume;
    }


    /**
     * Sets the volume value for this Product.
     * 
     * @param volume
     */
    public void setVolume(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume) {
        this.volume = volume;
    }


    /**
     * Gets the volumeId value for this Product.
     * 
     * @return volumeId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId getVolumeId() {
        return volumeId;
    }


    /**
     * Sets the volumeId value for this Product.
     * 
     * @param volumeId
     */
    public void setVolumeId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId volumeId) {
        this.volumeId = volumeId;
    }


    /**
     * Gets the year value for this Product.
     * 
     * @return year
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year getYear() {
        return year;
    }


    /**
     * Sets the year value for this Product.
     * 
     * @param year
     */
    public void setYear(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year) {
        this.year = year;
    }


    /**
     * Gets the fn value for this Product.
     * 
     * @return fn
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn getFn() {
        return fn;
    }


    /**
     * Sets the fn value for this Product.
     * 
     * @param fn
     */
    public void setFn(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fn fn) {
        this.fn = fn;
    }


    /**
     * Gets the target value for this Product.
     * 
     * @return target
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target getTarget() {
        return target;
    }


    /**
     * Sets the target value for this Product.
     * 
     * @param target
     */
    public void setTarget(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Target target) {
        this.target = target;
    }


    /**
     * Gets the xref value for this Product.
     * 
     * @return xref
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this Product.
     * 
     * @param xref
     */
    public void setXref(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Xref xref) {
        this.xref = xref;
    }


    /**
     * Gets the size value for this Product.
     * 
     * @return size
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Size getSize() {
        return size;
    }


    /**
     * Sets the size value for this Product.
     * 
     * @param size
     */
    public void setSize(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Size size) {
        this.size = size;
    }


    /**
     * Gets the sub value for this Product.
     * 
     * @return sub
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub getSub() {
        return sub;
    }


    /**
     * Sets the sub value for this Product.
     * 
     * @param sub
     */
    public void setSub(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sub sub) {
        this.sub = sub;
    }


    /**
     * Gets the sup value for this Product.
     * 
     * @return sup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup getSup() {
        return sup;
    }


    /**
     * Sets the sup value for this Product.
     * 
     * @param sup
     */
    public void setSup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Sup sup) {
        this.sup = sup;
    }


    /**
     * Gets the x value for this Product.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this Product.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the _any value for this Product.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this Product.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the id value for this Product.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Product.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the productType value for this Product.
     * 
     * @return productType
     */
    public java.lang.Object getProductType() {
        return productType;
    }


    /**
     * Sets the productType value for this Product.
     * 
     * @param productType
     */
    public void setProductType(java.lang.Object productType) {
        this.productType = productType;
    }


    /**
     * Gets the type value for this Product.
     * 
     * @return type
     */
    public org.w3.www._1999.xlink.Type getType() {
        return type;
    }


    /**
     * Sets the type value for this Product.
     * 
     * @param type
     */
    public void setType(org.w3.www._1999.xlink.Type type) {
        this.type = type;
    }


    /**
     * Gets the href value for this Product.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this Product.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }


    /**
     * Gets the role2 value for this Product.
     * 
     * @return role2
     */
    public java.lang.Object getRole2() {
        return role2;
    }


    /**
     * Sets the role2 value for this Product.
     * 
     * @param role2
     */
    public void setRole2(java.lang.Object role2) {
        this.role2 = role2;
    }


    /**
     * Gets the title value for this Product.
     * 
     * @return title
     */
    public java.lang.Object getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Product.
     * 
     * @param title
     */
    public void setTitle(java.lang.Object title) {
        this.title = title;
    }


    /**
     * Gets the show value for this Product.
     * 
     * @return show
     */
    public org.w3.www._1999.xlink.Show getShow() {
        return show;
    }


    /**
     * Sets the show value for this Product.
     * 
     * @param show
     */
    public void setShow(org.w3.www._1999.xlink.Show show) {
        this.show = show;
    }


    /**
     * Gets the actuate value for this Product.
     * 
     * @return actuate
     */
    public org.w3.www._1999.xlink.Actuate getActuate() {
        return actuate;
    }


    /**
     * Sets the actuate value for this Product.
     * 
     * @param actuate
     */
    public void setActuate(org.w3.www._1999.xlink.Actuate actuate) {
        this.actuate = actuate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
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
            ((this._break==null && other.get_break()==null) || 
             (this._break!=null &&
              this._break.equals(other.get_break()))) &&
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
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
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
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            ((this.accessDate==null && other.getAccessDate()==null) || 
             (this.accessDate!=null &&
              this.accessDate.equals(other.getAccessDate()))) &&
            ((this.annotation==null && other.getAnnotation()==null) || 
             (this.annotation!=null &&
              java.util.Arrays.equals(this.annotation, other.getAnnotation()))) &&
            ((this.articleTitle==null && other.getArticleTitle()==null) || 
             (this.articleTitle!=null &&
              this.articleTitle.equals(other.getArticleTitle()))) &&
            ((this.collab==null && other.getCollab()==null) || 
             (this.collab!=null &&
              this.collab.equals(other.getCollab()))) &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            ((this.confDate==null && other.getConfDate()==null) || 
             (this.confDate!=null &&
              this.confDate.equals(other.getConfDate()))) &&
            ((this.confLoc==null && other.getConfLoc()==null) || 
             (this.confLoc!=null &&
              this.confLoc.equals(other.getConfLoc()))) &&
            ((this.confName==null && other.getConfName()==null) || 
             (this.confName!=null &&
              this.confName.equals(other.getConfName()))) &&
            ((this.confSponsor==null && other.getConfSponsor()==null) || 
             (this.confSponsor!=null &&
              this.confSponsor.equals(other.getConfSponsor()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            ((this.edition==null && other.getEdition()==null) || 
             (this.edition!=null &&
              this.edition.equals(other.getEdition()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.elocationId==null && other.getElocationId()==null) || 
             (this.elocationId!=null &&
              this.elocationId.equals(other.getElocationId()))) &&
            ((this.etal==null && other.getEtal()==null) || 
             (this.etal!=null &&
              this.etal.equals(other.getEtal()))) &&
            ((this.extLink==null && other.getExtLink()==null) || 
             (this.extLink!=null &&
              this.extLink.equals(other.getExtLink()))) &&
            ((this.fpage==null && other.getFpage()==null) || 
             (this.fpage!=null &&
              this.fpage.equals(other.getFpage()))) &&
            ((this.gov==null && other.getGov()==null) || 
             (this.gov!=null &&
              this.gov.equals(other.getGov()))) &&
            ((this.institution==null && other.getInstitution()==null) || 
             (this.institution!=null &&
              this.institution.equals(other.getInstitution()))) &&
            ((this.isbn==null && other.getIsbn()==null) || 
             (this.isbn!=null &&
              this.isbn.equals(other.getIsbn()))) &&
            ((this.issn==null && other.getIssn()==null) || 
             (this.issn!=null &&
              this.issn.equals(other.getIssn()))) &&
            ((this.issue==null && other.getIssue()==null) || 
             (this.issue!=null &&
              this.issue.equals(other.getIssue()))) &&
            ((this.issueId==null && other.getIssueId()==null) || 
             (this.issueId!=null &&
              this.issueId.equals(other.getIssueId()))) &&
            ((this.issueTitle==null && other.getIssueTitle()==null) || 
             (this.issueTitle!=null &&
              this.issueTitle.equals(other.getIssueTitle()))) &&
            ((this.lpage==null && other.getLpage()==null) || 
             (this.lpage!=null &&
              this.lpage.equals(other.getLpage()))) &&
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.objectId==null && other.getObjectId()==null) || 
             (this.objectId!=null &&
              this.objectId.equals(other.getObjectId()))) &&
            ((this.pageCount==null && other.getPageCount()==null) || 
             (this.pageCount!=null &&
              this.pageCount.equals(other.getPageCount()))) &&
            ((this.pageRange==null && other.getPageRange()==null) || 
             (this.pageRange!=null &&
              this.pageRange.equals(other.getPageRange()))) &&
            ((this.patent==null && other.getPatent()==null) || 
             (this.patent!=null &&
              this.patent.equals(other.getPatent()))) &&
            ((this.personGroup==null && other.getPersonGroup()==null) || 
             (this.personGroup!=null &&
              this.personGroup.equals(other.getPersonGroup()))) &&
            ((this.pubId==null && other.getPubId()==null) || 
             (this.pubId!=null &&
              this.pubId.equals(other.getPubId()))) &&
            ((this.publisherLoc==null && other.getPublisherLoc()==null) || 
             (this.publisherLoc!=null &&
              this.publisherLoc.equals(other.getPublisherLoc()))) &&
            ((this.publisherName==null && other.getPublisherName()==null) || 
             (this.publisherName!=null &&
              this.publisherName.equals(other.getPublisherName()))) &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.season==null && other.getSeason()==null) || 
             (this.season!=null &&
              this.season.equals(other.getSeason()))) &&
            ((this.series==null && other.getSeries()==null) || 
             (this.series!=null &&
              this.series.equals(other.getSeries()))) &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource()))) &&
            ((this.std==null && other.getStd()==null) || 
             (this.std!=null &&
              this.std.equals(other.getStd()))) &&
            ((this.stringDate==null && other.getStringDate()==null) || 
             (this.stringDate!=null &&
              this.stringDate.equals(other.getStringDate()))) &&
            ((this.stringName==null && other.getStringName()==null) || 
             (this.stringName!=null &&
              this.stringName.equals(other.getStringName()))) &&
            ((this.supplement==null && other.getSupplement()==null) || 
             (this.supplement!=null &&
              this.supplement.equals(other.getSupplement()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            ((this.transSource==null && other.getTransSource()==null) || 
             (this.transSource!=null &&
              this.transSource.equals(other.getTransSource()))) &&
            ((this.transTitle==null && other.getTransTitle()==null) || 
             (this.transTitle!=null &&
              this.transTitle.equals(other.getTransTitle()))) &&
            ((this.uri==null && other.getUri()==null) || 
             (this.uri!=null &&
              this.uri.equals(other.getUri()))) &&
            ((this.volume==null && other.getVolume()==null) || 
             (this.volume!=null &&
              this.volume.equals(other.getVolume()))) &&
            ((this.volumeId==null && other.getVolumeId()==null) || 
             (this.volumeId!=null &&
              this.volumeId.equals(other.getVolumeId()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear()))) &&
            ((this.fn==null && other.getFn()==null) || 
             (this.fn!=null &&
              this.fn.equals(other.getFn()))) &&
            ((this.target==null && other.getTarget()==null) || 
             (this.target!=null &&
              this.target.equals(other.getTarget()))) &&
            ((this.xref==null && other.getXref()==null) || 
             (this.xref!=null &&
              this.xref.equals(other.getXref()))) &&
            ((this.size==null && other.getSize()==null) || 
             (this.size!=null &&
              this.size.equals(other.getSize()))) &&
            ((this.sub==null && other.getSub()==null) || 
             (this.sub!=null &&
              this.sub.equals(other.getSub()))) &&
            ((this.sup==null && other.getSup()==null) || 
             (this.sup!=null &&
              this.sup.equals(other.getSup()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.productType==null && other.getProductType()==null) || 
             (this.productType!=null &&
              this.productType.equals(other.getProductType()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.href==null && other.getHref()==null) || 
             (this.href!=null &&
              this.href.equals(other.getHref()))) &&
            ((this.role2==null && other.getRole2()==null) || 
             (this.role2!=null &&
              this.role2.equals(other.getRole2()))) &&
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
        if (get_break() != null) {
            _hashCode += get_break().hashCode();
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
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
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
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        if (getAccessDate() != null) {
            _hashCode += getAccessDate().hashCode();
        }
        if (getAnnotation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnnotation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnnotation(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArticleTitle() != null) {
            _hashCode += getArticleTitle().hashCode();
        }
        if (getCollab() != null) {
            _hashCode += getCollab().hashCode();
        }
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        if (getConfDate() != null) {
            _hashCode += getConfDate().hashCode();
        }
        if (getConfLoc() != null) {
            _hashCode += getConfLoc().hashCode();
        }
        if (getConfName() != null) {
            _hashCode += getConfName().hashCode();
        }
        if (getConfSponsor() != null) {
            _hashCode += getConfSponsor().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getEdition() != null) {
            _hashCode += getEdition().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getElocationId() != null) {
            _hashCode += getElocationId().hashCode();
        }
        if (getEtal() != null) {
            _hashCode += getEtal().hashCode();
        }
        if (getExtLink() != null) {
            _hashCode += getExtLink().hashCode();
        }
        if (getFpage() != null) {
            _hashCode += getFpage().hashCode();
        }
        if (getGov() != null) {
            _hashCode += getGov().hashCode();
        }
        if (getInstitution() != null) {
            _hashCode += getInstitution().hashCode();
        }
        if (getIsbn() != null) {
            _hashCode += getIsbn().hashCode();
        }
        if (getIssn() != null) {
            _hashCode += getIssn().hashCode();
        }
        if (getIssue() != null) {
            _hashCode += getIssue().hashCode();
        }
        if (getIssueId() != null) {
            _hashCode += getIssueId().hashCode();
        }
        if (getIssueTitle() != null) {
            _hashCode += getIssueTitle().hashCode();
        }
        if (getLpage() != null) {
            _hashCode += getLpage().hashCode();
        }
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getObjectId() != null) {
            _hashCode += getObjectId().hashCode();
        }
        if (getPageCount() != null) {
            _hashCode += getPageCount().hashCode();
        }
        if (getPageRange() != null) {
            _hashCode += getPageRange().hashCode();
        }
        if (getPatent() != null) {
            _hashCode += getPatent().hashCode();
        }
        if (getPersonGroup() != null) {
            _hashCode += getPersonGroup().hashCode();
        }
        if (getPubId() != null) {
            _hashCode += getPubId().hashCode();
        }
        if (getPublisherLoc() != null) {
            _hashCode += getPublisherLoc().hashCode();
        }
        if (getPublisherName() != null) {
            _hashCode += getPublisherName().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getSeason() != null) {
            _hashCode += getSeason().hashCode();
        }
        if (getSeries() != null) {
            _hashCode += getSeries().hashCode();
        }
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        if (getStd() != null) {
            _hashCode += getStd().hashCode();
        }
        if (getStringDate() != null) {
            _hashCode += getStringDate().hashCode();
        }
        if (getStringName() != null) {
            _hashCode += getStringName().hashCode();
        }
        if (getSupplement() != null) {
            _hashCode += getSupplement().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getTransSource() != null) {
            _hashCode += getTransSource().hashCode();
        }
        if (getTransTitle() != null) {
            _hashCode += getTransTitle().hashCode();
        }
        if (getUri() != null) {
            _hashCode += getUri().hashCode();
        }
        if (getVolume() != null) {
            _hashCode += getVolume().hashCode();
        }
        if (getVolumeId() != null) {
            _hashCode += getVolumeId().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
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
        if (getSize() != null) {
            _hashCode += getSize().hashCode();
        }
        if (getSub() != null) {
            _hashCode += getSub().hashCode();
        }
        if (getSup() != null) {
            _hashCode += getSup().hashCode();
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getProductType() != null) {
            _hashCode += getProductType().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getHref() != null) {
            _hashCode += getHref().hashCode();
        }
        if (getRole2() != null) {
            _hashCode += getRole2().hashCode();
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
        new org.apache.axis.description.TypeDesc(Product.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">product"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("productType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "product-type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
        elemField.setFieldName("_break");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "break"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">break"));
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
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">label"));
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
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">price"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "access-date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">access-date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "annotation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">annotation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article-title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-title"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "collab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">collab"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">comment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confLoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-loc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-loc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-name"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confSponsor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conf-sponsor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">conf-sponsor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">day"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "edition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">edition"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">email"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elocationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "elocation-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">elocation-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "etal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">etal"));
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
        elemField.setFieldName("fpage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fpage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fpage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gov");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "gov"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">gov"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institution");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "institution"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">institution"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isbn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "isbn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">isbn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issueId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issue-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issue-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issueTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issue-title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issue-title"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lpage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "lpage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">lpage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">month"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">name"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "object-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">object-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "page-count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">page-count"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageRange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "page-range"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">page-range"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "patent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">patent"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "person-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">person-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "pub-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">pub-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherLoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "publisher-loc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher-loc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "publisher-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">publisher-name"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">role"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("season");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "season"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">season"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("series");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "series"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">series"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">source"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("std");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "std"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">std"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "string-date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">string-date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "string-name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">string-name"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supplement");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "supplement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">supplement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "time-stamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">time-stamp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "trans-source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">trans-source"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "trans-title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">trans-title"));
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
        elemField.setFieldName("volume");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "volume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">volume"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volumeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "volume-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">volume-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">year"));
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
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">size"));
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
