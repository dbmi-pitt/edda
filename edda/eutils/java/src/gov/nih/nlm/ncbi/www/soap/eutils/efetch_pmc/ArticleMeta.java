/**
 * ArticleMeta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc;

public class ArticleMeta  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] articleId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleCategories articleCategories;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup titleGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup contribGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes authorNotes;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubDate[] pubDate;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId[] volumeId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId[] issueId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle[] issueTitle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Product product;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial supplementaryMaterial;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History history;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightYear copyrightYear;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] license;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SelfUri[] selfUri;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle[] relatedArticle;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] _abstract;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransAbstract[] transAbstract;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] kwdGroup;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractNum[] contractNum;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractSponsor[] contractSponsor;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantNum[] grantNum;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantSponsor[] grantSponsor;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Conference[] conference;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Counts counts;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CustomMeta[] customMetaWrap;

    public ArticleMeta() {
    }

    public ArticleMeta(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] articleId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleCategories articleCategories,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup titleGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup contribGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes authorNotes,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubDate[] pubDate,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId[] volumeId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId[] issueId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle[] issueTitle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Product product,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial supplementaryMaterial,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History history,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightYear copyrightYear,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] license,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SelfUri[] selfUri,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle[] relatedArticle,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] _abstract,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransAbstract[] transAbstract,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] kwdGroup,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractNum[] contractNum,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractSponsor[] contractSponsor,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantNum[] grantNum,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantSponsor[] grantSponsor,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Conference[] conference,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Counts counts,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CustomMeta[] customMetaWrap) {
           this.articleId = articleId;
           this.articleCategories = articleCategories;
           this.titleGroup = titleGroup;
           this.contribGroup = contribGroup;
           this.aff = aff;
           this.x = x;
           this.authorNotes = authorNotes;
           this.pubDate = pubDate;
           this.volume = volume;
           this.volumeId = volumeId;
           this.issue = issue;
           this.issueId = issueId;
           this.issueTitle = issueTitle;
           this.supplement = supplement;
           this.fpage = fpage;
           this.lpage = lpage;
           this.pageRange = pageRange;
           this.elocationId = elocationId;
           this.email = email;
           this.extLink = extLink;
           this.uri = uri;
           this.product = product;
           this.supplementaryMaterial = supplementaryMaterial;
           this.history = history;
           this.copyrightStatement = copyrightStatement;
           this.copyrightYear = copyrightYear;
           this.license = license;
           this.permissions = permissions;
           this.selfUri = selfUri;
           this.relatedArticle = relatedArticle;
           this._abstract = _abstract;
           this.transAbstract = transAbstract;
           this.kwdGroup = kwdGroup;
           this.contractNum = contractNum;
           this.contractSponsor = contractSponsor;
           this.grantNum = grantNum;
           this.grantSponsor = grantSponsor;
           this.conference = conference;
           this.counts = counts;
           this.customMetaWrap = customMetaWrap;
    }


    /**
     * Gets the articleId value for this ArticleMeta.
     * 
     * @return articleId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] getArticleId() {
        return articleId;
    }


    /**
     * Sets the articleId value for this ArticleMeta.
     * 
     * @param articleId
     */
    public void setArticleId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId[] articleId) {
        this.articleId = articleId;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId getArticleId(int i) {
        return this.articleId[i];
    }

    public void setArticleId(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleId _value) {
        this.articleId[i] = _value;
    }


    /**
     * Gets the articleCategories value for this ArticleMeta.
     * 
     * @return articleCategories
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleCategories getArticleCategories() {
        return articleCategories;
    }


    /**
     * Sets the articleCategories value for this ArticleMeta.
     * 
     * @param articleCategories
     */
    public void setArticleCategories(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ArticleCategories articleCategories) {
        this.articleCategories = articleCategories;
    }


    /**
     * Gets the titleGroup value for this ArticleMeta.
     * 
     * @return titleGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup getTitleGroup() {
        return titleGroup;
    }


    /**
     * Sets the titleGroup value for this ArticleMeta.
     * 
     * @param titleGroup
     */
    public void setTitleGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TitleGroup titleGroup) {
        this.titleGroup = titleGroup;
    }


    /**
     * Gets the contribGroup value for this ArticleMeta.
     * 
     * @return contribGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup getContribGroup() {
        return contribGroup;
    }


    /**
     * Sets the contribGroup value for this ArticleMeta.
     * 
     * @param contribGroup
     */
    public void setContribGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContribGroup contribGroup) {
        this.contribGroup = contribGroup;
    }


    /**
     * Gets the aff value for this ArticleMeta.
     * 
     * @return aff
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff getAff() {
        return aff;
    }


    /**
     * Sets the aff value for this ArticleMeta.
     * 
     * @param aff
     */
    public void setAff(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Aff aff) {
        this.aff = aff;
    }


    /**
     * Gets the x value for this ArticleMeta.
     * 
     * @return x
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X getX() {
        return x;
    }


    /**
     * Sets the x value for this ArticleMeta.
     * 
     * @param x
     */
    public void setX(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.X x) {
        this.x = x;
    }


    /**
     * Gets the authorNotes value for this ArticleMeta.
     * 
     * @return authorNotes
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes getAuthorNotes() {
        return authorNotes;
    }


    /**
     * Sets the authorNotes value for this ArticleMeta.
     * 
     * @param authorNotes
     */
    public void setAuthorNotes(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.AuthorNotes authorNotes) {
        this.authorNotes = authorNotes;
    }


    /**
     * Gets the pubDate value for this ArticleMeta.
     * 
     * @return pubDate
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubDate[] getPubDate() {
        return pubDate;
    }


    /**
     * Sets the pubDate value for this ArticleMeta.
     * 
     * @param pubDate
     */
    public void setPubDate(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubDate[] pubDate) {
        this.pubDate = pubDate;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubDate getPubDate(int i) {
        return this.pubDate[i];
    }

    public void setPubDate(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PubDate _value) {
        this.pubDate[i] = _value;
    }


    /**
     * Gets the volume value for this ArticleMeta.
     * 
     * @return volume
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume getVolume() {
        return volume;
    }


    /**
     * Sets the volume value for this ArticleMeta.
     * 
     * @param volume
     */
    public void setVolume(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Volume volume) {
        this.volume = volume;
    }


    /**
     * Gets the volumeId value for this ArticleMeta.
     * 
     * @return volumeId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId[] getVolumeId() {
        return volumeId;
    }


    /**
     * Sets the volumeId value for this ArticleMeta.
     * 
     * @param volumeId
     */
    public void setVolumeId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId[] volumeId) {
        this.volumeId = volumeId;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId getVolumeId(int i) {
        return this.volumeId[i];
    }

    public void setVolumeId(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.VolumeId _value) {
        this.volumeId[i] = _value;
    }


    /**
     * Gets the issue value for this ArticleMeta.
     * 
     * @return issue
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue getIssue() {
        return issue;
    }


    /**
     * Sets the issue value for this ArticleMeta.
     * 
     * @param issue
     */
    public void setIssue(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Issue issue) {
        this.issue = issue;
    }


    /**
     * Gets the issueId value for this ArticleMeta.
     * 
     * @return issueId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId[] getIssueId() {
        return issueId;
    }


    /**
     * Sets the issueId value for this ArticleMeta.
     * 
     * @param issueId
     */
    public void setIssueId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId[] issueId) {
        this.issueId = issueId;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId getIssueId(int i) {
        return this.issueId[i];
    }

    public void setIssueId(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueId _value) {
        this.issueId[i] = _value;
    }


    /**
     * Gets the issueTitle value for this ArticleMeta.
     * 
     * @return issueTitle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle[] getIssueTitle() {
        return issueTitle;
    }


    /**
     * Sets the issueTitle value for this ArticleMeta.
     * 
     * @param issueTitle
     */
    public void setIssueTitle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle[] issueTitle) {
        this.issueTitle = issueTitle;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle getIssueTitle(int i) {
        return this.issueTitle[i];
    }

    public void setIssueTitle(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.IssueTitle _value) {
        this.issueTitle[i] = _value;
    }


    /**
     * Gets the supplement value for this ArticleMeta.
     * 
     * @return supplement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement getSupplement() {
        return supplement;
    }


    /**
     * Sets the supplement value for this ArticleMeta.
     * 
     * @param supplement
     */
    public void setSupplement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Supplement supplement) {
        this.supplement = supplement;
    }


    /**
     * Gets the fpage value for this ArticleMeta.
     * 
     * @return fpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage getFpage() {
        return fpage;
    }


    /**
     * Sets the fpage value for this ArticleMeta.
     * 
     * @param fpage
     */
    public void setFpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Fpage fpage) {
        this.fpage = fpage;
    }


    /**
     * Gets the lpage value for this ArticleMeta.
     * 
     * @return lpage
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage getLpage() {
        return lpage;
    }


    /**
     * Sets the lpage value for this ArticleMeta.
     * 
     * @param lpage
     */
    public void setLpage(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Lpage lpage) {
        this.lpage = lpage;
    }


    /**
     * Gets the pageRange value for this ArticleMeta.
     * 
     * @return pageRange
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange getPageRange() {
        return pageRange;
    }


    /**
     * Sets the pageRange value for this ArticleMeta.
     * 
     * @param pageRange
     */
    public void setPageRange(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.PageRange pageRange) {
        this.pageRange = pageRange;
    }


    /**
     * Gets the elocationId value for this ArticleMeta.
     * 
     * @return elocationId
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId getElocationId() {
        return elocationId;
    }


    /**
     * Sets the elocationId value for this ArticleMeta.
     * 
     * @param elocationId
     */
    public void setElocationId(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ElocationId elocationId) {
        this.elocationId = elocationId;
    }


    /**
     * Gets the email value for this ArticleMeta.
     * 
     * @return email
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ArticleMeta.
     * 
     * @param email
     */
    public void setEmail(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Email email) {
        this.email = email;
    }


    /**
     * Gets the extLink value for this ArticleMeta.
     * 
     * @return extLink
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink getExtLink() {
        return extLink;
    }


    /**
     * Sets the extLink value for this ArticleMeta.
     * 
     * @param extLink
     */
    public void setExtLink(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ExtLink extLink) {
        this.extLink = extLink;
    }


    /**
     * Gets the uri value for this ArticleMeta.
     * 
     * @return uri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri getUri() {
        return uri;
    }


    /**
     * Sets the uri value for this ArticleMeta.
     * 
     * @param uri
     */
    public void setUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Uri uri) {
        this.uri = uri;
    }


    /**
     * Gets the product value for this ArticleMeta.
     * 
     * @return product
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Product getProduct() {
        return product;
    }


    /**
     * Sets the product value for this ArticleMeta.
     * 
     * @param product
     */
    public void setProduct(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Product product) {
        this.product = product;
    }


    /**
     * Gets the supplementaryMaterial value for this ArticleMeta.
     * 
     * @return supplementaryMaterial
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial getSupplementaryMaterial() {
        return supplementaryMaterial;
    }


    /**
     * Sets the supplementaryMaterial value for this ArticleMeta.
     * 
     * @param supplementaryMaterial
     */
    public void setSupplementaryMaterial(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SupplementaryMaterial supplementaryMaterial) {
        this.supplementaryMaterial = supplementaryMaterial;
    }


    /**
     * Gets the history value for this ArticleMeta.
     * 
     * @return history
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History getHistory() {
        return history;
    }


    /**
     * Sets the history value for this ArticleMeta.
     * 
     * @param history
     */
    public void setHistory(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.History history) {
        this.history = history;
    }


    /**
     * Gets the copyrightStatement value for this ArticleMeta.
     * 
     * @return copyrightStatement
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement getCopyrightStatement() {
        return copyrightStatement;
    }


    /**
     * Sets the copyrightStatement value for this ArticleMeta.
     * 
     * @param copyrightStatement
     */
    public void setCopyrightStatement(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightStatement copyrightStatement) {
        this.copyrightStatement = copyrightStatement;
    }


    /**
     * Gets the copyrightYear value for this ArticleMeta.
     * 
     * @return copyrightYear
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightYear getCopyrightYear() {
        return copyrightYear;
    }


    /**
     * Sets the copyrightYear value for this ArticleMeta.
     * 
     * @param copyrightYear
     */
    public void setCopyrightYear(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CopyrightYear copyrightYear) {
        this.copyrightYear = copyrightYear;
    }


    /**
     * Gets the license value for this ArticleMeta.
     * 
     * @return license
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] getLicense() {
        return license;
    }


    /**
     * Sets the license value for this ArticleMeta.
     * 
     * @param license
     */
    public void setLicense(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.P[] license) {
        this.license = license;
    }


    /**
     * Gets the permissions value for this ArticleMeta.
     * 
     * @return permissions
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this ArticleMeta.
     * 
     * @param permissions
     */
    public void setPermissions(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Permissions permissions) {
        this.permissions = permissions;
    }


    /**
     * Gets the selfUri value for this ArticleMeta.
     * 
     * @return selfUri
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SelfUri[] getSelfUri() {
        return selfUri;
    }


    /**
     * Sets the selfUri value for this ArticleMeta.
     * 
     * @param selfUri
     */
    public void setSelfUri(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SelfUri[] selfUri) {
        this.selfUri = selfUri;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SelfUri getSelfUri(int i) {
        return this.selfUri[i];
    }

    public void setSelfUri(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SelfUri _value) {
        this.selfUri[i] = _value;
    }


    /**
     * Gets the relatedArticle value for this ArticleMeta.
     * 
     * @return relatedArticle
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.RelatedArticle[] getRelatedArticle() {
        return relatedArticle;
    }


    /**
     * Sets the relatedArticle value for this ArticleMeta.
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
     * Gets the _abstract value for this ArticleMeta.
     * 
     * @return _abstract
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] get_abstract() {
        return _abstract;
    }


    /**
     * Sets the _abstract value for this ArticleMeta.
     * 
     * @param _abstract
     */
    public void set_abstract(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract[] _abstract) {
        this._abstract = _abstract;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract get_abstract(int i) {
        return this._abstract[i];
    }

    public void set_abstract(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc._abstract _value) {
        this._abstract[i] = _value;
    }


    /**
     * Gets the transAbstract value for this ArticleMeta.
     * 
     * @return transAbstract
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransAbstract[] getTransAbstract() {
        return transAbstract;
    }


    /**
     * Sets the transAbstract value for this ArticleMeta.
     * 
     * @param transAbstract
     */
    public void setTransAbstract(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransAbstract[] transAbstract) {
        this.transAbstract = transAbstract;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransAbstract getTransAbstract(int i) {
        return this.transAbstract[i];
    }

    public void setTransAbstract(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.TransAbstract _value) {
        this.transAbstract[i] = _value;
    }


    /**
     * Gets the kwdGroup value for this ArticleMeta.
     * 
     * @return kwdGroup
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] getKwdGroup() {
        return kwdGroup;
    }


    /**
     * Sets the kwdGroup value for this ArticleMeta.
     * 
     * @param kwdGroup
     */
    public void setKwdGroup(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup[] kwdGroup) {
        this.kwdGroup = kwdGroup;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup getKwdGroup(int i) {
        return this.kwdGroup[i];
    }

    public void setKwdGroup(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.KwdGroup _value) {
        this.kwdGroup[i] = _value;
    }


    /**
     * Gets the contractNum value for this ArticleMeta.
     * 
     * @return contractNum
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractNum[] getContractNum() {
        return contractNum;
    }


    /**
     * Sets the contractNum value for this ArticleMeta.
     * 
     * @param contractNum
     */
    public void setContractNum(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractNum[] contractNum) {
        this.contractNum = contractNum;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractNum getContractNum(int i) {
        return this.contractNum[i];
    }

    public void setContractNum(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractNum _value) {
        this.contractNum[i] = _value;
    }


    /**
     * Gets the contractSponsor value for this ArticleMeta.
     * 
     * @return contractSponsor
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractSponsor[] getContractSponsor() {
        return contractSponsor;
    }


    /**
     * Sets the contractSponsor value for this ArticleMeta.
     * 
     * @param contractSponsor
     */
    public void setContractSponsor(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractSponsor[] contractSponsor) {
        this.contractSponsor = contractSponsor;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractSponsor getContractSponsor(int i) {
        return this.contractSponsor[i];
    }

    public void setContractSponsor(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.ContractSponsor _value) {
        this.contractSponsor[i] = _value;
    }


    /**
     * Gets the grantNum value for this ArticleMeta.
     * 
     * @return grantNum
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantNum[] getGrantNum() {
        return grantNum;
    }


    /**
     * Sets the grantNum value for this ArticleMeta.
     * 
     * @param grantNum
     */
    public void setGrantNum(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantNum[] grantNum) {
        this.grantNum = grantNum;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantNum getGrantNum(int i) {
        return this.grantNum[i];
    }

    public void setGrantNum(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantNum _value) {
        this.grantNum[i] = _value;
    }


    /**
     * Gets the grantSponsor value for this ArticleMeta.
     * 
     * @return grantSponsor
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantSponsor[] getGrantSponsor() {
        return grantSponsor;
    }


    /**
     * Sets the grantSponsor value for this ArticleMeta.
     * 
     * @param grantSponsor
     */
    public void setGrantSponsor(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantSponsor[] grantSponsor) {
        this.grantSponsor = grantSponsor;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantSponsor getGrantSponsor(int i) {
        return this.grantSponsor[i];
    }

    public void setGrantSponsor(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.GrantSponsor _value) {
        this.grantSponsor[i] = _value;
    }


    /**
     * Gets the conference value for this ArticleMeta.
     * 
     * @return conference
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Conference[] getConference() {
        return conference;
    }


    /**
     * Sets the conference value for this ArticleMeta.
     * 
     * @param conference
     */
    public void setConference(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Conference[] conference) {
        this.conference = conference;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Conference getConference(int i) {
        return this.conference[i];
    }

    public void setConference(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Conference _value) {
        this.conference[i] = _value;
    }


    /**
     * Gets the counts value for this ArticleMeta.
     * 
     * @return counts
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Counts getCounts() {
        return counts;
    }


    /**
     * Sets the counts value for this ArticleMeta.
     * 
     * @param counts
     */
    public void setCounts(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.Counts counts) {
        this.counts = counts;
    }


    /**
     * Gets the customMetaWrap value for this ArticleMeta.
     * 
     * @return customMetaWrap
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CustomMeta[] getCustomMetaWrap() {
        return customMetaWrap;
    }


    /**
     * Sets the customMetaWrap value for this ArticleMeta.
     * 
     * @param customMetaWrap
     */
    public void setCustomMetaWrap(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.CustomMeta[] customMetaWrap) {
        this.customMetaWrap = customMetaWrap;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArticleMeta)) return false;
        ArticleMeta other = (ArticleMeta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.articleId==null && other.getArticleId()==null) || 
             (this.articleId!=null &&
              java.util.Arrays.equals(this.articleId, other.getArticleId()))) &&
            ((this.articleCategories==null && other.getArticleCategories()==null) || 
             (this.articleCategories!=null &&
              this.articleCategories.equals(other.getArticleCategories()))) &&
            ((this.titleGroup==null && other.getTitleGroup()==null) || 
             (this.titleGroup!=null &&
              this.titleGroup.equals(other.getTitleGroup()))) &&
            ((this.contribGroup==null && other.getContribGroup()==null) || 
             (this.contribGroup!=null &&
              this.contribGroup.equals(other.getContribGroup()))) &&
            ((this.aff==null && other.getAff()==null) || 
             (this.aff!=null &&
              this.aff.equals(other.getAff()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this.authorNotes==null && other.getAuthorNotes()==null) || 
             (this.authorNotes!=null &&
              this.authorNotes.equals(other.getAuthorNotes()))) &&
            ((this.pubDate==null && other.getPubDate()==null) || 
             (this.pubDate!=null &&
              java.util.Arrays.equals(this.pubDate, other.getPubDate()))) &&
            ((this.volume==null && other.getVolume()==null) || 
             (this.volume!=null &&
              this.volume.equals(other.getVolume()))) &&
            ((this.volumeId==null && other.getVolumeId()==null) || 
             (this.volumeId!=null &&
              java.util.Arrays.equals(this.volumeId, other.getVolumeId()))) &&
            ((this.issue==null && other.getIssue()==null) || 
             (this.issue!=null &&
              this.issue.equals(other.getIssue()))) &&
            ((this.issueId==null && other.getIssueId()==null) || 
             (this.issueId!=null &&
              java.util.Arrays.equals(this.issueId, other.getIssueId()))) &&
            ((this.issueTitle==null && other.getIssueTitle()==null) || 
             (this.issueTitle!=null &&
              java.util.Arrays.equals(this.issueTitle, other.getIssueTitle()))) &&
            ((this.supplement==null && other.getSupplement()==null) || 
             (this.supplement!=null &&
              this.supplement.equals(other.getSupplement()))) &&
            ((this.fpage==null && other.getFpage()==null) || 
             (this.fpage!=null &&
              this.fpage.equals(other.getFpage()))) &&
            ((this.lpage==null && other.getLpage()==null) || 
             (this.lpage!=null &&
              this.lpage.equals(other.getLpage()))) &&
            ((this.pageRange==null && other.getPageRange()==null) || 
             (this.pageRange!=null &&
              this.pageRange.equals(other.getPageRange()))) &&
            ((this.elocationId==null && other.getElocationId()==null) || 
             (this.elocationId!=null &&
              this.elocationId.equals(other.getElocationId()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.extLink==null && other.getExtLink()==null) || 
             (this.extLink!=null &&
              this.extLink.equals(other.getExtLink()))) &&
            ((this.uri==null && other.getUri()==null) || 
             (this.uri!=null &&
              this.uri.equals(other.getUri()))) &&
            ((this.product==null && other.getProduct()==null) || 
             (this.product!=null &&
              this.product.equals(other.getProduct()))) &&
            ((this.supplementaryMaterial==null && other.getSupplementaryMaterial()==null) || 
             (this.supplementaryMaterial!=null &&
              this.supplementaryMaterial.equals(other.getSupplementaryMaterial()))) &&
            ((this.history==null && other.getHistory()==null) || 
             (this.history!=null &&
              this.history.equals(other.getHistory()))) &&
            ((this.copyrightStatement==null && other.getCopyrightStatement()==null) || 
             (this.copyrightStatement!=null &&
              this.copyrightStatement.equals(other.getCopyrightStatement()))) &&
            ((this.copyrightYear==null && other.getCopyrightYear()==null) || 
             (this.copyrightYear!=null &&
              this.copyrightYear.equals(other.getCopyrightYear()))) &&
            ((this.license==null && other.getLicense()==null) || 
             (this.license!=null &&
              java.util.Arrays.equals(this.license, other.getLicense()))) &&
            ((this.permissions==null && other.getPermissions()==null) || 
             (this.permissions!=null &&
              this.permissions.equals(other.getPermissions()))) &&
            ((this.selfUri==null && other.getSelfUri()==null) || 
             (this.selfUri!=null &&
              java.util.Arrays.equals(this.selfUri, other.getSelfUri()))) &&
            ((this.relatedArticle==null && other.getRelatedArticle()==null) || 
             (this.relatedArticle!=null &&
              java.util.Arrays.equals(this.relatedArticle, other.getRelatedArticle()))) &&
            ((this._abstract==null && other.get_abstract()==null) || 
             (this._abstract!=null &&
              java.util.Arrays.equals(this._abstract, other.get_abstract()))) &&
            ((this.transAbstract==null && other.getTransAbstract()==null) || 
             (this.transAbstract!=null &&
              java.util.Arrays.equals(this.transAbstract, other.getTransAbstract()))) &&
            ((this.kwdGroup==null && other.getKwdGroup()==null) || 
             (this.kwdGroup!=null &&
              java.util.Arrays.equals(this.kwdGroup, other.getKwdGroup()))) &&
            ((this.contractNum==null && other.getContractNum()==null) || 
             (this.contractNum!=null &&
              java.util.Arrays.equals(this.contractNum, other.getContractNum()))) &&
            ((this.contractSponsor==null && other.getContractSponsor()==null) || 
             (this.contractSponsor!=null &&
              java.util.Arrays.equals(this.contractSponsor, other.getContractSponsor()))) &&
            ((this.grantNum==null && other.getGrantNum()==null) || 
             (this.grantNum!=null &&
              java.util.Arrays.equals(this.grantNum, other.getGrantNum()))) &&
            ((this.grantSponsor==null && other.getGrantSponsor()==null) || 
             (this.grantSponsor!=null &&
              java.util.Arrays.equals(this.grantSponsor, other.getGrantSponsor()))) &&
            ((this.conference==null && other.getConference()==null) || 
             (this.conference!=null &&
              java.util.Arrays.equals(this.conference, other.getConference()))) &&
            ((this.counts==null && other.getCounts()==null) || 
             (this.counts!=null &&
              this.counts.equals(other.getCounts()))) &&
            ((this.customMetaWrap==null && other.getCustomMetaWrap()==null) || 
             (this.customMetaWrap!=null &&
              java.util.Arrays.equals(this.customMetaWrap, other.getCustomMetaWrap())));
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
        if (getArticleId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArticleId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArticleId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArticleCategories() != null) {
            _hashCode += getArticleCategories().hashCode();
        }
        if (getTitleGroup() != null) {
            _hashCode += getTitleGroup().hashCode();
        }
        if (getContribGroup() != null) {
            _hashCode += getContribGroup().hashCode();
        }
        if (getAff() != null) {
            _hashCode += getAff().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (getAuthorNotes() != null) {
            _hashCode += getAuthorNotes().hashCode();
        }
        if (getPubDate() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPubDate());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPubDate(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVolume() != null) {
            _hashCode += getVolume().hashCode();
        }
        if (getVolumeId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVolumeId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVolumeId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIssue() != null) {
            _hashCode += getIssue().hashCode();
        }
        if (getIssueId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIssueId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIssueId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIssueTitle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIssueTitle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIssueTitle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSupplement() != null) {
            _hashCode += getSupplement().hashCode();
        }
        if (getFpage() != null) {
            _hashCode += getFpage().hashCode();
        }
        if (getLpage() != null) {
            _hashCode += getLpage().hashCode();
        }
        if (getPageRange() != null) {
            _hashCode += getPageRange().hashCode();
        }
        if (getElocationId() != null) {
            _hashCode += getElocationId().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getExtLink() != null) {
            _hashCode += getExtLink().hashCode();
        }
        if (getUri() != null) {
            _hashCode += getUri().hashCode();
        }
        if (getProduct() != null) {
            _hashCode += getProduct().hashCode();
        }
        if (getSupplementaryMaterial() != null) {
            _hashCode += getSupplementaryMaterial().hashCode();
        }
        if (getHistory() != null) {
            _hashCode += getHistory().hashCode();
        }
        if (getCopyrightStatement() != null) {
            _hashCode += getCopyrightStatement().hashCode();
        }
        if (getCopyrightYear() != null) {
            _hashCode += getCopyrightYear().hashCode();
        }
        if (getLicense() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLicense());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLicense(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPermissions() != null) {
            _hashCode += getPermissions().hashCode();
        }
        if (getSelfUri() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSelfUri());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSelfUri(), i);
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
        if (get_abstract() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_abstract());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_abstract(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTransAbstract() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTransAbstract());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTransAbstract(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getKwdGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKwdGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKwdGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContractNum() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContractNum());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContractNum(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContractSponsor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContractSponsor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContractSponsor(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGrantNum() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrantNum());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrantNum(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGrantSponsor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrantSponsor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrantSponsor(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConference() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConference());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConference(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCounts() != null) {
            _hashCode += getCounts().hashCode();
        }
        if (getCustomMetaWrap() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomMetaWrap());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomMetaWrap(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArticleMeta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-meta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article-id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleCategories");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "article-categories"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">article-categories"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titleGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "title-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">title-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contribGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contrib-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">contrib-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aff");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "aff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">aff"));
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
        elemField.setFieldName("authorNotes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "author-notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">author-notes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "pub-date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "pub-date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "volume-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issue-id"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issueTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issue-title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "issue-title"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supplement");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "supplement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">supplement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fpage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "fpage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">fpage"));
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
        elemField.setFieldName("pageRange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "page-range"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">page-range"));
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
        elemField.setFieldName("product");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "product"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">product"));
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
        elemField.setFieldName("history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "history"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">history"));
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
        elemField.setFieldName("copyrightYear");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "copyright-year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">copyright-year"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("license");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "license"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">license"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selfUri");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "self-uri"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "self-uri"));
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
        elemField.setFieldName("_abstract");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "abstract"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "abstract"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transAbstract");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "trans-abstract"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "trans-abstract"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kwdGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "kwd-group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "kwd-group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contract-num"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contract-num"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractSponsor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contract-sponsor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "contract-sponsor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grantNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "grant-num"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "grant-num"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grantSponsor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "grant-sponsor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "grant-sponsor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "conference"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("counts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "counts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">counts"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customMetaWrap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", "custom-meta-wrap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pmc", ">custom-meta-wrap"));
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
