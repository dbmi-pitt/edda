/**
 * NlmCitation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class NlmCitation  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup personGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle articleTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle transTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source source;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent patent;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource transSource;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp timeStamp;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate accessDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition edition;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName confName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate confDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc confLoc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount pageCount;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series series;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment[] comment;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId[] pubId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] annotation;

    private java.lang.Object citationType;  // attribute

    private java.lang.String id;  // attribute

    private org.w3.www._1999.xlink.Type type;  // attribute

    private java.lang.Object href;  // attribute

    private java.lang.Object role;  // attribute

    private java.lang.Object title;  // attribute

    private org.w3.www._1999.xlink.Show show;  // attribute

    private org.w3.www._1999.xlink.Actuate actuate;  // attribute

    public NlmCitation() {
    }

    public NlmCitation(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup personGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle articleTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle transTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source source,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent patent,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource transSource,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp timeStamp,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate accessDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition edition,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName confName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate confDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc confLoc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount pageCount,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series series,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment[] comment,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId[] pubId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] annotation,
           java.lang.Object citationType,
           java.lang.String id,
           org.w3.www._1999.xlink.Type type,
           java.lang.Object href,
           java.lang.Object role,
           java.lang.Object title,
           org.w3.www._1999.xlink.Show show,
           org.w3.www._1999.xlink.Actuate actuate) {
           this.personGroup = personGroup;
           this.collab = collab;
           this.articleTitle = articleTitle;
           this.transTitle = transTitle;
           this.source = source;
           this.patent = patent;
           this.transSource = transSource;
           this.year = year;
           this.month = month;
           this.day = day;
           this.timeStamp = timeStamp;
           this.season = season;
           this.accessDate = accessDate;
           this.volume = volume;
           this.edition = edition;
           this.confName = confName;
           this.confDate = confDate;
           this.confLoc = confLoc;
           this.issue = issue;
           this.supplement = supplement;
           this.publisherLoc = publisherLoc;
           this.publisherName = publisherName;
           this.fpage = fpage;
           this.lpage = lpage;
           this.pageCount = pageCount;
           this.series = series;
           this.comment = comment;
           this.pubId = pubId;
           this.annotation = annotation;
           this.citationType = citationType;
           this.id = id;
           this.type = type;
           this.href = href;
           this.role = role;
           this.title = title;
           this.show = show;
           this.actuate = actuate;
    }


    /**
     * Gets the personGroup value for this NlmCitation.
     * 
     * @return personGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup getPersonGroup() {
        return personGroup;
    }


    /**
     * Sets the personGroup value for this NlmCitation.
     * 
     * @param personGroup
     */
    public void setPersonGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PersonGroup personGroup) {
        this.personGroup = personGroup;
    }


    /**
     * Gets the collab value for this NlmCitation.
     * 
     * @return collab
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab getCollab() {
        return collab;
    }


    /**
     * Sets the collab value for this NlmCitation.
     * 
     * @param collab
     */
    public void setCollab(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Collab collab) {
        this.collab = collab;
    }


    /**
     * Gets the articleTitle value for this NlmCitation.
     * 
     * @return articleTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle getArticleTitle() {
        return articleTitle;
    }


    /**
     * Sets the articleTitle value for this NlmCitation.
     * 
     * @param articleTitle
     */
    public void setArticleTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleTitle articleTitle) {
        this.articleTitle = articleTitle;
    }


    /**
     * Gets the transTitle value for this NlmCitation.
     * 
     * @return transTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle getTransTitle() {
        return transTitle;
    }


    /**
     * Sets the transTitle value for this NlmCitation.
     * 
     * @param transTitle
     */
    public void setTransTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransTitle transTitle) {
        this.transTitle = transTitle;
    }


    /**
     * Gets the source value for this NlmCitation.
     * 
     * @return source
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source getSource() {
        return source;
    }


    /**
     * Sets the source value for this NlmCitation.
     * 
     * @param source
     */
    public void setSource(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Source source) {
        this.source = source;
    }


    /**
     * Gets the patent value for this NlmCitation.
     * 
     * @return patent
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent getPatent() {
        return patent;
    }


    /**
     * Sets the patent value for this NlmCitation.
     * 
     * @param patent
     */
    public void setPatent(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Patent patent) {
        this.patent = patent;
    }


    /**
     * Gets the transSource value for this NlmCitation.
     * 
     * @return transSource
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource getTransSource() {
        return transSource;
    }


    /**
     * Sets the transSource value for this NlmCitation.
     * 
     * @param transSource
     */
    public void setTransSource(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransSource transSource) {
        this.transSource = transSource;
    }


    /**
     * Gets the year value for this NlmCitation.
     * 
     * @return year
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year getYear() {
        return year;
    }


    /**
     * Sets the year value for this NlmCitation.
     * 
     * @param year
     */
    public void setYear(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Year year) {
        this.year = year;
    }


    /**
     * Gets the month value for this NlmCitation.
     * 
     * @return month
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month getMonth() {
        return month;
    }


    /**
     * Sets the month value for this NlmCitation.
     * 
     * @param month
     */
    public void setMonth(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Month month) {
        this.month = month;
    }


    /**
     * Gets the day value for this NlmCitation.
     * 
     * @return day
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day getDay() {
        return day;
    }


    /**
     * Sets the day value for this NlmCitation.
     * 
     * @param day
     */
    public void setDay(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Day day) {
        this.day = day;
    }


    /**
     * Gets the timeStamp value for this NlmCitation.
     * 
     * @return timeStamp
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this NlmCitation.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TimeStamp timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the season value for this NlmCitation.
     * 
     * @return season
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season getSeason() {
        return season;
    }


    /**
     * Sets the season value for this NlmCitation.
     * 
     * @param season
     */
    public void setSeason(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Season season) {
        this.season = season;
    }


    /**
     * Gets the accessDate value for this NlmCitation.
     * 
     * @return accessDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate getAccessDate() {
        return accessDate;
    }


    /**
     * Sets the accessDate value for this NlmCitation.
     * 
     * @param accessDate
     */
    public void setAccessDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AccessDate accessDate) {
        this.accessDate = accessDate;
    }


    /**
     * Gets the volume value for this NlmCitation.
     * 
     * @return volume
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume getVolume() {
        return volume;
    }


    /**
     * Sets the volume value for this NlmCitation.
     * 
     * @param volume
     */
    public void setVolume(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume) {
        this.volume = volume;
    }


    /**
     * Gets the edition value for this NlmCitation.
     * 
     * @return edition
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition getEdition() {
        return edition;
    }


    /**
     * Sets the edition value for this NlmCitation.
     * 
     * @param edition
     */
    public void setEdition(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Edition edition) {
        this.edition = edition;
    }


    /**
     * Gets the confName value for this NlmCitation.
     * 
     * @return confName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName getConfName() {
        return confName;
    }


    /**
     * Sets the confName value for this NlmCitation.
     * 
     * @param confName
     */
    public void setConfName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfName confName) {
        this.confName = confName;
    }


    /**
     * Gets the confDate value for this NlmCitation.
     * 
     * @return confDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate getConfDate() {
        return confDate;
    }


    /**
     * Sets the confDate value for this NlmCitation.
     * 
     * @param confDate
     */
    public void setConfDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfDate confDate) {
        this.confDate = confDate;
    }


    /**
     * Gets the confLoc value for this NlmCitation.
     * 
     * @return confLoc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc getConfLoc() {
        return confLoc;
    }


    /**
     * Sets the confLoc value for this NlmCitation.
     * 
     * @param confLoc
     */
    public void setConfLoc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ConfLoc confLoc) {
        this.confLoc = confLoc;
    }


    /**
     * Gets the issue value for this NlmCitation.
     * 
     * @return issue
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue getIssue() {
        return issue;
    }


    /**
     * Sets the issue value for this NlmCitation.
     * 
     * @param issue
     */
    public void setIssue(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue) {
        this.issue = issue;
    }


    /**
     * Gets the supplement value for this NlmCitation.
     * 
     * @return supplement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement getSupplement() {
        return supplement;
    }


    /**
     * Sets the supplement value for this NlmCitation.
     * 
     * @param supplement
     */
    public void setSupplement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement) {
        this.supplement = supplement;
    }


    /**
     * Gets the publisherLoc value for this NlmCitation.
     * 
     * @return publisherLoc
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc getPublisherLoc() {
        return publisherLoc;
    }


    /**
     * Sets the publisherLoc value for this NlmCitation.
     * 
     * @param publisherLoc
     */
    public void setPublisherLoc(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherLoc publisherLoc) {
        this.publisherLoc = publisherLoc;
    }


    /**
     * Gets the publisherName value for this NlmCitation.
     * 
     * @return publisherName
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName getPublisherName() {
        return publisherName;
    }


    /**
     * Sets the publisherName value for this NlmCitation.
     * 
     * @param publisherName
     */
    public void setPublisherName(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PublisherName publisherName) {
        this.publisherName = publisherName;
    }


    /**
     * Gets the fpage value for this NlmCitation.
     * 
     * @return fpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage getFpage() {
        return fpage;
    }


    /**
     * Sets the fpage value for this NlmCitation.
     * 
     * @param fpage
     */
    public void setFpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage) {
        this.fpage = fpage;
    }


    /**
     * Gets the lpage value for this NlmCitation.
     * 
     * @return lpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage getLpage() {
        return lpage;
    }


    /**
     * Sets the lpage value for this NlmCitation.
     * 
     * @param lpage
     */
    public void setLpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage) {
        this.lpage = lpage;
    }


    /**
     * Gets the pageCount value for this NlmCitation.
     * 
     * @return pageCount
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount getPageCount() {
        return pageCount;
    }


    /**
     * Sets the pageCount value for this NlmCitation.
     * 
     * @param pageCount
     */
    public void setPageCount(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageCount pageCount) {
        this.pageCount = pageCount;
    }


    /**
     * Gets the series value for this NlmCitation.
     * 
     * @return series
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series getSeries() {
        return series;
    }


    /**
     * Sets the series value for this NlmCitation.
     * 
     * @param series
     */
    public void setSeries(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Series series) {
        this.series = series;
    }


    /**
     * Gets the comment value for this NlmCitation.
     * 
     * @return comment
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment[] getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this NlmCitation.
     * 
     * @param comment
     */
    public void setComment(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment[] comment) {
        this.comment = comment;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment getComment(int i) {
        return this.comment[i];
    }

    public void setComment(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Comment _value) {
        this.comment[i] = _value;
    }


    /**
     * Gets the pubId value for this NlmCitation.
     * 
     * @return pubId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId[] getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this NlmCitation.
     * 
     * @param pubId
     */
    public void setPubId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId[] pubId) {
        this.pubId = pubId;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId getPubId(int i) {
        return this.pubId[i];
    }

    public void setPubId(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubId _value) {
        this.pubId[i] = _value;
    }


    /**
     * Gets the annotation value for this NlmCitation.
     * 
     * @return annotation
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] getAnnotation() {
        return annotation;
    }


    /**
     * Sets the annotation value for this NlmCitation.
     * 
     * @param annotation
     */
    public void setAnnotation(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] annotation) {
        this.annotation = annotation;
    }


    /**
     * Gets the citationType value for this NlmCitation.
     * 
     * @return citationType
     */
    public java.lang.Object getCitationType() {
        return citationType;
    }


    /**
     * Sets the citationType value for this NlmCitation.
     * 
     * @param citationType
     */
    public void setCitationType(java.lang.Object citationType) {
        this.citationType = citationType;
    }


    /**
     * Gets the id value for this NlmCitation.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this NlmCitation.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the type value for this NlmCitation.
     * 
     * @return type
     */
    public org.w3.www._1999.xlink.Type getType() {
        return type;
    }


    /**
     * Sets the type value for this NlmCitation.
     * 
     * @param type
     */
    public void setType(org.w3.www._1999.xlink.Type type) {
        this.type = type;
    }


    /**
     * Gets the href value for this NlmCitation.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this NlmCitation.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }


    /**
     * Gets the role value for this NlmCitation.
     * 
     * @return role
     */
    public java.lang.Object getRole() {
        return role;
    }


    /**
     * Sets the role value for this NlmCitation.
     * 
     * @param role
     */
    public void setRole(java.lang.Object role) {
        this.role = role;
    }


    /**
     * Gets the title value for this NlmCitation.
     * 
     * @return title
     */
    public java.lang.Object getTitle() {
        return title;
    }


    /**
     * Sets the title value for this NlmCitation.
     * 
     * @param title
     */
    public void setTitle(java.lang.Object title) {
        this.title = title;
    }


    /**
     * Gets the show value for this NlmCitation.
     * 
     * @return show
     */
    public org.w3.www._1999.xlink.Show getShow() {
        return show;
    }


    /**
     * Sets the show value for this NlmCitation.
     * 
     * @param show
     */
    public void setShow(org.w3.www._1999.xlink.Show show) {
        this.show = show;
    }


    /**
     * Gets the actuate value for this NlmCitation.
     * 
     * @return actuate
     */
    public org.w3.www._1999.xlink.Actuate getActuate() {
        return actuate;
    }


    /**
     * Sets the actuate value for this NlmCitation.
     * 
     * @param actuate
     */
    public void setActuate(org.w3.www._1999.xlink.Actuate actuate) {
        this.actuate = actuate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NlmCitation)) return false;
        NlmCitation other = (NlmCitation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.personGroup==null && other.getPersonGroup()==null) || 
             (this.personGroup!=null &&
              this.personGroup.equals(other.getPersonGroup()))) &&
            ((this.collab==null && other.getCollab()==null) || 
             (this.collab!=null &&
              this.collab.equals(other.getCollab()))) &&
            ((this.articleTitle==null && other.getArticleTitle()==null) || 
             (this.articleTitle!=null &&
              this.articleTitle.equals(other.getArticleTitle()))) &&
            ((this.transTitle==null && other.getTransTitle()==null) || 
             (this.transTitle!=null &&
              this.transTitle.equals(other.getTransTitle()))) &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource()))) &&
            ((this.patent==null && other.getPatent()==null) || 
             (this.patent!=null &&
              this.patent.equals(other.getPatent()))) &&
            ((this.transSource==null && other.getTransSource()==null) || 
             (this.transSource!=null &&
              this.transSource.equals(other.getTransSource()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear()))) &&
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            ((this.season==null && other.getSeason()==null) || 
             (this.season!=null &&
              this.season.equals(other.getSeason()))) &&
            ((this.accessDate==null && other.getAccessDate()==null) || 
             (this.accessDate!=null &&
              this.accessDate.equals(other.getAccessDate()))) &&
            ((this.volume==null && other.getVolume()==null) || 
             (this.volume!=null &&
              this.volume.equals(other.getVolume()))) &&
            ((this.edition==null && other.getEdition()==null) || 
             (this.edition!=null &&
              this.edition.equals(other.getEdition()))) &&
            ((this.confName==null && other.getConfName()==null) || 
             (this.confName!=null &&
              this.confName.equals(other.getConfName()))) &&
            ((this.confDate==null && other.getConfDate()==null) || 
             (this.confDate!=null &&
              this.confDate.equals(other.getConfDate()))) &&
            ((this.confLoc==null && other.getConfLoc()==null) || 
             (this.confLoc!=null &&
              this.confLoc.equals(other.getConfLoc()))) &&
            ((this.issue==null && other.getIssue()==null) || 
             (this.issue!=null &&
              this.issue.equals(other.getIssue()))) &&
            ((this.supplement==null && other.getSupplement()==null) || 
             (this.supplement!=null &&
              this.supplement.equals(other.getSupplement()))) &&
            ((this.publisherLoc==null && other.getPublisherLoc()==null) || 
             (this.publisherLoc!=null &&
              this.publisherLoc.equals(other.getPublisherLoc()))) &&
            ((this.publisherName==null && other.getPublisherName()==null) || 
             (this.publisherName!=null &&
              this.publisherName.equals(other.getPublisherName()))) &&
            ((this.fpage==null && other.getFpage()==null) || 
             (this.fpage!=null &&
              this.fpage.equals(other.getFpage()))) &&
            ((this.lpage==null && other.getLpage()==null) || 
             (this.lpage!=null &&
              this.lpage.equals(other.getLpage()))) &&
            ((this.pageCount==null && other.getPageCount()==null) || 
             (this.pageCount!=null &&
              this.pageCount.equals(other.getPageCount()))) &&
            ((this.series==null && other.getSeries()==null) || 
             (this.series!=null &&
              this.series.equals(other.getSeries()))) &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              java.util.Arrays.equals(this.comment, other.getComment()))) &&
            ((this.pubId==null && other.getPubId()==null) || 
             (this.pubId!=null &&
              java.util.Arrays.equals(this.pubId, other.getPubId()))) &&
            ((this.annotation==null && other.getAnnotation()==null) || 
             (this.annotation!=null &&
              java.util.Arrays.equals(this.annotation, other.getAnnotation()))) &&
            ((this.citationType==null && other.getCitationType()==null) || 
             (this.citationType!=null &&
              this.citationType.equals(other.getCitationType()))) &&
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
        if (getPersonGroup() != null) {
            _hashCode += getPersonGroup().hashCode();
        }
        if (getCollab() != null) {
            _hashCode += getCollab().hashCode();
        }
        if (getArticleTitle() != null) {
            _hashCode += getArticleTitle().hashCode();
        }
        if (getTransTitle() != null) {
            _hashCode += getTransTitle().hashCode();
        }
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        if (getPatent() != null) {
            _hashCode += getPatent().hashCode();
        }
        if (getTransSource() != null) {
            _hashCode += getTransSource().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
        }
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getSeason() != null) {
            _hashCode += getSeason().hashCode();
        }
        if (getAccessDate() != null) {
            _hashCode += getAccessDate().hashCode();
        }
        if (getVolume() != null) {
            _hashCode += getVolume().hashCode();
        }
        if (getEdition() != null) {
            _hashCode += getEdition().hashCode();
        }
        if (getConfName() != null) {
            _hashCode += getConfName().hashCode();
        }
        if (getConfDate() != null) {
            _hashCode += getConfDate().hashCode();
        }
        if (getConfLoc() != null) {
            _hashCode += getConfLoc().hashCode();
        }
        if (getIssue() != null) {
            _hashCode += getIssue().hashCode();
        }
        if (getSupplement() != null) {
            _hashCode += getSupplement().hashCode();
        }
        if (getPublisherLoc() != null) {
            _hashCode += getPublisherLoc().hashCode();
        }
        if (getPublisherName() != null) {
            _hashCode += getPublisherName().hashCode();
        }
        if (getFpage() != null) {
            _hashCode += getFpage().hashCode();
        }
        if (getLpage() != null) {
            _hashCode += getLpage().hashCode();
        }
        if (getPageCount() != null) {
            _hashCode += getPageCount().hashCode();
        }
        if (getSeries() != null) {
            _hashCode += getSeries().hashCode();
        }
        if (getComment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPubId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPubId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPubId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getCitationType() != null) {
            _hashCode += getCitationType().hashCode();
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
        new org.apache.axis.description.TypeDesc(NlmCitation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">nlm-citation"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("citationType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "citation-type"));
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
        elemField.setFieldName("personGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "person-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">person-group"));
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
        elemField.setFieldName("articleTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article-title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-title"));
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
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">source"));
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
        elemField.setFieldName("transSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "trans-source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">trans-source"));
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
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">month"));
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
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "time-stamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">time-stamp"));
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
        elemField.setFieldName("accessDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "access-date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">access-date"));
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
        elemField.setFieldName("edition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "edition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">edition"));
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
        elemField.setFieldName("issue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">issue"));
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
        elemField.setFieldName("fpage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fpage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fpage"));
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
        elemField.setFieldName("pageCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "page-count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">page-count"));
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
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "comment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "pub-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "pub-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "annotation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">annotation"));
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
