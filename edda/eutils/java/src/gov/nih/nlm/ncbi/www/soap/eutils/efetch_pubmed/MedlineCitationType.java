/**
 * MedlineCitationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed;

public class MedlineCitationType  implements java.io.Serializable {
    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCreatedType dateCreated;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCompletedType dateCompleted;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType dateRevised;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleType article;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineJournalInfoType medlineJournalInfo;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ChemicalType[] chemicalList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SupplMeshNameType[] supplMeshList;

    private java.lang.String[] citationSubset;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsType[] commentsCorrectionsList;

    private java.lang.String[] geneSymbolList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MeshHeadingType[] meshHeadingList;

    private java.lang.String numberOfReferences;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PersonalNameSubjectType[] personalNameSubjectList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherIDType[] otherID;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractType[] otherAbstract;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] keywordList;

    private java.lang.String[] spaceFlightMission;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorType[] investigatorList;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GeneralNoteType[] generalNote;

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeOwner owner;  // attribute

    private gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeStatus status;  // attribute

    private java.lang.String versionID;  // attribute

    private java.lang.String versionDate;  // attribute

    public MedlineCitationType() {
    }

    public MedlineCitationType(
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCreatedType dateCreated,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCompletedType dateCompleted,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType dateRevised,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleType article,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineJournalInfoType medlineJournalInfo,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ChemicalType[] chemicalList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SupplMeshNameType[] supplMeshList,
           java.lang.String[] citationSubset,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsType[] commentsCorrectionsList,
           java.lang.String[] geneSymbolList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MeshHeadingType[] meshHeadingList,
           java.lang.String numberOfReferences,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PersonalNameSubjectType[] personalNameSubjectList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherIDType[] otherID,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractType[] otherAbstract,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] keywordList,
           java.lang.String[] spaceFlightMission,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorType[] investigatorList,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GeneralNoteType[] generalNote,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeOwner owner,
           gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeStatus status,
           java.lang.String versionID,
           java.lang.String versionDate) {
           this.PMID = PMID;
           this.dateCreated = dateCreated;
           this.dateCompleted = dateCompleted;
           this.dateRevised = dateRevised;
           this.article = article;
           this.medlineJournalInfo = medlineJournalInfo;
           this.chemicalList = chemicalList;
           this.supplMeshList = supplMeshList;
           this.citationSubset = citationSubset;
           this.commentsCorrectionsList = commentsCorrectionsList;
           this.geneSymbolList = geneSymbolList;
           this.meshHeadingList = meshHeadingList;
           this.numberOfReferences = numberOfReferences;
           this.personalNameSubjectList = personalNameSubjectList;
           this.otherID = otherID;
           this.otherAbstract = otherAbstract;
           this.keywordList = keywordList;
           this.spaceFlightMission = spaceFlightMission;
           this.investigatorList = investigatorList;
           this.generalNote = generalNote;
           this.owner = owner;
           this.status = status;
           this.versionID = versionID;
           this.versionDate = versionDate;
    }


    /**
     * Gets the PMID value for this MedlineCitationType.
     * 
     * @return PMID
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType getPMID() {
        return PMID;
    }


    /**
     * Sets the PMID value for this MedlineCitationType.
     * 
     * @param PMID
     */
    public void setPMID(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PMIDType PMID) {
        this.PMID = PMID;
    }


    /**
     * Gets the dateCreated value for this MedlineCitationType.
     * 
     * @return dateCreated
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCreatedType getDateCreated() {
        return dateCreated;
    }


    /**
     * Sets the dateCreated value for this MedlineCitationType.
     * 
     * @param dateCreated
     */
    public void setDateCreated(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCreatedType dateCreated) {
        this.dateCreated = dateCreated;
    }


    /**
     * Gets the dateCompleted value for this MedlineCitationType.
     * 
     * @return dateCompleted
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCompletedType getDateCompleted() {
        return dateCompleted;
    }


    /**
     * Sets the dateCompleted value for this MedlineCitationType.
     * 
     * @param dateCompleted
     */
    public void setDateCompleted(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateCompletedType dateCompleted) {
        this.dateCompleted = dateCompleted;
    }


    /**
     * Gets the dateRevised value for this MedlineCitationType.
     * 
     * @return dateRevised
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType getDateRevised() {
        return dateRevised;
    }


    /**
     * Sets the dateRevised value for this MedlineCitationType.
     * 
     * @param dateRevised
     */
    public void setDateRevised(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.DateRevisedType dateRevised) {
        this.dateRevised = dateRevised;
    }


    /**
     * Gets the article value for this MedlineCitationType.
     * 
     * @return article
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleType getArticle() {
        return article;
    }


    /**
     * Sets the article value for this MedlineCitationType.
     * 
     * @param article
     */
    public void setArticle(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ArticleType article) {
        this.article = article;
    }


    /**
     * Gets the medlineJournalInfo value for this MedlineCitationType.
     * 
     * @return medlineJournalInfo
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineJournalInfoType getMedlineJournalInfo() {
        return medlineJournalInfo;
    }


    /**
     * Sets the medlineJournalInfo value for this MedlineCitationType.
     * 
     * @param medlineJournalInfo
     */
    public void setMedlineJournalInfo(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineJournalInfoType medlineJournalInfo) {
        this.medlineJournalInfo = medlineJournalInfo;
    }


    /**
     * Gets the chemicalList value for this MedlineCitationType.
     * 
     * @return chemicalList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ChemicalType[] getChemicalList() {
        return chemicalList;
    }


    /**
     * Sets the chemicalList value for this MedlineCitationType.
     * 
     * @param chemicalList
     */
    public void setChemicalList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.ChemicalType[] chemicalList) {
        this.chemicalList = chemicalList;
    }


    /**
     * Gets the supplMeshList value for this MedlineCitationType.
     * 
     * @return supplMeshList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SupplMeshNameType[] getSupplMeshList() {
        return supplMeshList;
    }


    /**
     * Sets the supplMeshList value for this MedlineCitationType.
     * 
     * @param supplMeshList
     */
    public void setSupplMeshList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.SupplMeshNameType[] supplMeshList) {
        this.supplMeshList = supplMeshList;
    }


    /**
     * Gets the citationSubset value for this MedlineCitationType.
     * 
     * @return citationSubset
     */
    public java.lang.String[] getCitationSubset() {
        return citationSubset;
    }


    /**
     * Sets the citationSubset value for this MedlineCitationType.
     * 
     * @param citationSubset
     */
    public void setCitationSubset(java.lang.String[] citationSubset) {
        this.citationSubset = citationSubset;
    }

    public java.lang.String getCitationSubset(int i) {
        return this.citationSubset[i];
    }

    public void setCitationSubset(int i, java.lang.String _value) {
        this.citationSubset[i] = _value;
    }


    /**
     * Gets the commentsCorrectionsList value for this MedlineCitationType.
     * 
     * @return commentsCorrectionsList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsType[] getCommentsCorrectionsList() {
        return commentsCorrectionsList;
    }


    /**
     * Sets the commentsCorrectionsList value for this MedlineCitationType.
     * 
     * @param commentsCorrectionsList
     */
    public void setCommentsCorrectionsList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.CommentsCorrectionsType[] commentsCorrectionsList) {
        this.commentsCorrectionsList = commentsCorrectionsList;
    }


    /**
     * Gets the geneSymbolList value for this MedlineCitationType.
     * 
     * @return geneSymbolList
     */
    public java.lang.String[] getGeneSymbolList() {
        return geneSymbolList;
    }


    /**
     * Sets the geneSymbolList value for this MedlineCitationType.
     * 
     * @param geneSymbolList
     */
    public void setGeneSymbolList(java.lang.String[] geneSymbolList) {
        this.geneSymbolList = geneSymbolList;
    }


    /**
     * Gets the meshHeadingList value for this MedlineCitationType.
     * 
     * @return meshHeadingList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MeshHeadingType[] getMeshHeadingList() {
        return meshHeadingList;
    }


    /**
     * Sets the meshHeadingList value for this MedlineCitationType.
     * 
     * @param meshHeadingList
     */
    public void setMeshHeadingList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MeshHeadingType[] meshHeadingList) {
        this.meshHeadingList = meshHeadingList;
    }


    /**
     * Gets the numberOfReferences value for this MedlineCitationType.
     * 
     * @return numberOfReferences
     */
    public java.lang.String getNumberOfReferences() {
        return numberOfReferences;
    }


    /**
     * Sets the numberOfReferences value for this MedlineCitationType.
     * 
     * @param numberOfReferences
     */
    public void setNumberOfReferences(java.lang.String numberOfReferences) {
        this.numberOfReferences = numberOfReferences;
    }


    /**
     * Gets the personalNameSubjectList value for this MedlineCitationType.
     * 
     * @return personalNameSubjectList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PersonalNameSubjectType[] getPersonalNameSubjectList() {
        return personalNameSubjectList;
    }


    /**
     * Sets the personalNameSubjectList value for this MedlineCitationType.
     * 
     * @param personalNameSubjectList
     */
    public void setPersonalNameSubjectList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.PersonalNameSubjectType[] personalNameSubjectList) {
        this.personalNameSubjectList = personalNameSubjectList;
    }


    /**
     * Gets the otherID value for this MedlineCitationType.
     * 
     * @return otherID
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherIDType[] getOtherID() {
        return otherID;
    }


    /**
     * Sets the otherID value for this MedlineCitationType.
     * 
     * @param otherID
     */
    public void setOtherID(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherIDType[] otherID) {
        this.otherID = otherID;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherIDType getOtherID(int i) {
        return this.otherID[i];
    }

    public void setOtherID(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherIDType _value) {
        this.otherID[i] = _value;
    }


    /**
     * Gets the otherAbstract value for this MedlineCitationType.
     * 
     * @return otherAbstract
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractType[] getOtherAbstract() {
        return otherAbstract;
    }


    /**
     * Sets the otherAbstract value for this MedlineCitationType.
     * 
     * @param otherAbstract
     */
    public void setOtherAbstract(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractType[] otherAbstract) {
        this.otherAbstract = otherAbstract;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractType getOtherAbstract(int i) {
        return this.otherAbstract[i];
    }

    public void setOtherAbstract(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.OtherAbstractType _value) {
        this.otherAbstract[i] = _value;
    }


    /**
     * Gets the keywordList value for this MedlineCitationType.
     * 
     * @return keywordList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] getKeywordList() {
        return keywordList;
    }


    /**
     * Sets the keywordList value for this MedlineCitationType.
     * 
     * @param keywordList
     */
    public void setKeywordList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[][] keywordList) {
        this.keywordList = keywordList;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[] getKeywordList(int i) {
        return this.keywordList[i];
    }

    public void setKeywordList(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.KeywordType[] _value) {
        this.keywordList[i] = _value;
    }


    /**
     * Gets the spaceFlightMission value for this MedlineCitationType.
     * 
     * @return spaceFlightMission
     */
    public java.lang.String[] getSpaceFlightMission() {
        return spaceFlightMission;
    }


    /**
     * Sets the spaceFlightMission value for this MedlineCitationType.
     * 
     * @param spaceFlightMission
     */
    public void setSpaceFlightMission(java.lang.String[] spaceFlightMission) {
        this.spaceFlightMission = spaceFlightMission;
    }

    public java.lang.String getSpaceFlightMission(int i) {
        return this.spaceFlightMission[i];
    }

    public void setSpaceFlightMission(int i, java.lang.String _value) {
        this.spaceFlightMission[i] = _value;
    }


    /**
     * Gets the investigatorList value for this MedlineCitationType.
     * 
     * @return investigatorList
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorType[] getInvestigatorList() {
        return investigatorList;
    }


    /**
     * Sets the investigatorList value for this MedlineCitationType.
     * 
     * @param investigatorList
     */
    public void setInvestigatorList(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.InvestigatorType[] investigatorList) {
        this.investigatorList = investigatorList;
    }


    /**
     * Gets the generalNote value for this MedlineCitationType.
     * 
     * @return generalNote
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GeneralNoteType[] getGeneralNote() {
        return generalNote;
    }


    /**
     * Sets the generalNote value for this MedlineCitationType.
     * 
     * @param generalNote
     */
    public void setGeneralNote(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GeneralNoteType[] generalNote) {
        this.generalNote = generalNote;
    }

    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GeneralNoteType getGeneralNote(int i) {
        return this.generalNote[i];
    }

    public void setGeneralNote(int i, gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.GeneralNoteType _value) {
        this.generalNote[i] = _value;
    }


    /**
     * Gets the owner value for this MedlineCitationType.
     * 
     * @return owner
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeOwner getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this MedlineCitationType.
     * 
     * @param owner
     */
    public void setOwner(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeOwner owner) {
        this.owner = owner;
    }


    /**
     * Gets the status value for this MedlineCitationType.
     * 
     * @return status
     */
    public gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this MedlineCitationType.
     * 
     * @param status
     */
    public void setStatus(gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.MedlineCitationTypeStatus status) {
        this.status = status;
    }


    /**
     * Gets the versionID value for this MedlineCitationType.
     * 
     * @return versionID
     */
    public java.lang.String getVersionID() {
        return versionID;
    }


    /**
     * Sets the versionID value for this MedlineCitationType.
     * 
     * @param versionID
     */
    public void setVersionID(java.lang.String versionID) {
        this.versionID = versionID;
    }


    /**
     * Gets the versionDate value for this MedlineCitationType.
     * 
     * @return versionDate
     */
    public java.lang.String getVersionDate() {
        return versionDate;
    }


    /**
     * Sets the versionDate value for this MedlineCitationType.
     * 
     * @param versionDate
     */
    public void setVersionDate(java.lang.String versionDate) {
        this.versionDate = versionDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MedlineCitationType)) return false;
        MedlineCitationType other = (MedlineCitationType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PMID==null && other.getPMID()==null) || 
             (this.PMID!=null &&
              this.PMID.equals(other.getPMID()))) &&
            ((this.dateCreated==null && other.getDateCreated()==null) || 
             (this.dateCreated!=null &&
              this.dateCreated.equals(other.getDateCreated()))) &&
            ((this.dateCompleted==null && other.getDateCompleted()==null) || 
             (this.dateCompleted!=null &&
              this.dateCompleted.equals(other.getDateCompleted()))) &&
            ((this.dateRevised==null && other.getDateRevised()==null) || 
             (this.dateRevised!=null &&
              this.dateRevised.equals(other.getDateRevised()))) &&
            ((this.article==null && other.getArticle()==null) || 
             (this.article!=null &&
              this.article.equals(other.getArticle()))) &&
            ((this.medlineJournalInfo==null && other.getMedlineJournalInfo()==null) || 
             (this.medlineJournalInfo!=null &&
              this.medlineJournalInfo.equals(other.getMedlineJournalInfo()))) &&
            ((this.chemicalList==null && other.getChemicalList()==null) || 
             (this.chemicalList!=null &&
              java.util.Arrays.equals(this.chemicalList, other.getChemicalList()))) &&
            ((this.supplMeshList==null && other.getSupplMeshList()==null) || 
             (this.supplMeshList!=null &&
              java.util.Arrays.equals(this.supplMeshList, other.getSupplMeshList()))) &&
            ((this.citationSubset==null && other.getCitationSubset()==null) || 
             (this.citationSubset!=null &&
              java.util.Arrays.equals(this.citationSubset, other.getCitationSubset()))) &&
            ((this.commentsCorrectionsList==null && other.getCommentsCorrectionsList()==null) || 
             (this.commentsCorrectionsList!=null &&
              java.util.Arrays.equals(this.commentsCorrectionsList, other.getCommentsCorrectionsList()))) &&
            ((this.geneSymbolList==null && other.getGeneSymbolList()==null) || 
             (this.geneSymbolList!=null &&
              java.util.Arrays.equals(this.geneSymbolList, other.getGeneSymbolList()))) &&
            ((this.meshHeadingList==null && other.getMeshHeadingList()==null) || 
             (this.meshHeadingList!=null &&
              java.util.Arrays.equals(this.meshHeadingList, other.getMeshHeadingList()))) &&
            ((this.numberOfReferences==null && other.getNumberOfReferences()==null) || 
             (this.numberOfReferences!=null &&
              this.numberOfReferences.equals(other.getNumberOfReferences()))) &&
            ((this.personalNameSubjectList==null && other.getPersonalNameSubjectList()==null) || 
             (this.personalNameSubjectList!=null &&
              java.util.Arrays.equals(this.personalNameSubjectList, other.getPersonalNameSubjectList()))) &&
            ((this.otherID==null && other.getOtherID()==null) || 
             (this.otherID!=null &&
              java.util.Arrays.equals(this.otherID, other.getOtherID()))) &&
            ((this.otherAbstract==null && other.getOtherAbstract()==null) || 
             (this.otherAbstract!=null &&
              java.util.Arrays.equals(this.otherAbstract, other.getOtherAbstract()))) &&
            ((this.keywordList==null && other.getKeywordList()==null) || 
             (this.keywordList!=null &&
              java.util.Arrays.equals(this.keywordList, other.getKeywordList()))) &&
            ((this.spaceFlightMission==null && other.getSpaceFlightMission()==null) || 
             (this.spaceFlightMission!=null &&
              java.util.Arrays.equals(this.spaceFlightMission, other.getSpaceFlightMission()))) &&
            ((this.investigatorList==null && other.getInvestigatorList()==null) || 
             (this.investigatorList!=null &&
              java.util.Arrays.equals(this.investigatorList, other.getInvestigatorList()))) &&
            ((this.generalNote==null && other.getGeneralNote()==null) || 
             (this.generalNote!=null &&
              java.util.Arrays.equals(this.generalNote, other.getGeneralNote()))) &&
            ((this.owner==null && other.getOwner()==null) || 
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.versionID==null && other.getVersionID()==null) || 
             (this.versionID!=null &&
              this.versionID.equals(other.getVersionID()))) &&
            ((this.versionDate==null && other.getVersionDate()==null) || 
             (this.versionDate!=null &&
              this.versionDate.equals(other.getVersionDate())));
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
        if (getPMID() != null) {
            _hashCode += getPMID().hashCode();
        }
        if (getDateCreated() != null) {
            _hashCode += getDateCreated().hashCode();
        }
        if (getDateCompleted() != null) {
            _hashCode += getDateCompleted().hashCode();
        }
        if (getDateRevised() != null) {
            _hashCode += getDateRevised().hashCode();
        }
        if (getArticle() != null) {
            _hashCode += getArticle().hashCode();
        }
        if (getMedlineJournalInfo() != null) {
            _hashCode += getMedlineJournalInfo().hashCode();
        }
        if (getChemicalList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChemicalList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChemicalList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSupplMeshList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSupplMeshList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSupplMeshList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCitationSubset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCitationSubset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCitationSubset(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCommentsCorrectionsList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCommentsCorrectionsList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCommentsCorrectionsList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGeneSymbolList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGeneSymbolList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGeneSymbolList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMeshHeadingList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMeshHeadingList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMeshHeadingList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumberOfReferences() != null) {
            _hashCode += getNumberOfReferences().hashCode();
        }
        if (getPersonalNameSubjectList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPersonalNameSubjectList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPersonalNameSubjectList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOtherID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOtherID());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOtherID(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOtherAbstract() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOtherAbstract());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOtherAbstract(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getKeywordList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywordList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywordList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSpaceFlightMission() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSpaceFlightMission());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSpaceFlightMission(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInvestigatorList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInvestigatorList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInvestigatorList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGeneralNote() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGeneralNote());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGeneralNote(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getVersionID() != null) {
            _hashCode += getVersionID().hashCode();
        }
        if (getVersionDate() != null) {
            _hashCode += getVersionDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MedlineCitationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "MedlineCitationType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("owner");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Owner"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">MedlineCitationType>Owner"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", ">MedlineCitationType>Status"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("versionID");
        attrField.setXmlName(new javax.xml.namespace.QName("", "VersionID"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("versionDate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "VersionDate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PMID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PMID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PMIDType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateCreated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateCreated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateCreatedType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateCompleted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateCompleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateCompletedType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateRevised");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateRevised"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "DateRevisedType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("article");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Article"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ArticleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medlineJournalInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "MedlineJournalInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "MedlineJournalInfoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chemicalList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ChemicalList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "ChemicalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Chemical"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supplMeshList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SupplMeshList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SupplMeshNameType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SupplMeshName"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citationSubset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CitationSubset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CitationSubset"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentsCorrectionsList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CommentsCorrectionsList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CommentsCorrectionsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "CommentsCorrections"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geneSymbolList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GeneSymbolList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GeneSymbol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("meshHeadingList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "MeshHeadingList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "MeshHeadingType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "MeshHeading"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfReferences");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "NumberOfReferences"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personalNameSubjectList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PersonalNameSubjectList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PersonalNameSubjectType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "PersonalNameSubject"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "OtherID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "OtherIDType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherAbstract");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "OtherAbstract"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "OtherAbstractType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "KeywordList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "KeywordListType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spaceFlightMission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SpaceFlightMission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "SpaceFlightMission"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("investigatorList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "InvestigatorList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "InvestigatorType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "Investigator"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generalNote");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GeneralNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/efetch_pubmed", "GeneralNoteType"));
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
