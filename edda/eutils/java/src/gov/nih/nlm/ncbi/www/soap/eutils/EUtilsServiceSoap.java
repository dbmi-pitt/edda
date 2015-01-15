/**
 * EUtilsServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.nih.nlm.ncbi.www.soap.eutils;

public interface EUtilsServiceSoap extends java.rmi.Remote {
    public gov.nih.nlm.ncbi.www.soap.eutils.egquery.Result run_eGquery(gov.nih.nlm.ncbi.www.soap.eutils.egquery.EGqueryRequest request) throws java.rmi.RemoteException;
    public gov.nih.nlm.ncbi.www.soap.eutils.einfo.EInfoResult run_eInfo(gov.nih.nlm.ncbi.www.soap.eutils.einfo.EInfoRequest request) throws java.rmi.RemoteException;
    public gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchResult run_eSearch(gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchRequest request) throws java.rmi.RemoteException;
    public gov.nih.nlm.ncbi.www.soap.eutils.esummary.ESummaryResult run_eSummary(gov.nih.nlm.ncbi.www.soap.eutils.esummary.ESummaryRequest request) throws java.rmi.RemoteException;
    public gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkResult run_eLink(gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkRequest request) throws java.rmi.RemoteException;
    public gov.nih.nlm.ncbi.www.soap.eutils.espell.ESpellResult run_eSpell(gov.nih.nlm.ncbi.www.soap.eutils.espell.ESpellRequest request) throws java.rmi.RemoteException;
    public gov.nih.nlm.ncbi.www.soap.eutils.epost.EPostResult run_ePost(gov.nih.nlm.ncbi.www.soap.eutils.epost.EPostRequest request) throws java.rmi.RemoteException;
}
