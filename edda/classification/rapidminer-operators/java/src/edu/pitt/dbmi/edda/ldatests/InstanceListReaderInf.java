package edu.pitt.dbmi.edda.ldatests;

//
//Each line has three fields, separated by commas. 
//This is a standard Mallet format. For more information, see the importing data guide.
//The first field is a name for the document. The second field could contain a document label, as in a classification task, 
//but for this example we won't use that field. It is therefore set to a meaningless placeholder value. 
//The third field contains the full text of the document, with no newline characters.
//

public interface InstanceListReaderInf {
	public void readInstances() throws LdaException;
	public TargetCacher getTargetCacher();
	public void setIncludingClassifications(boolean isIncludingClassifications);
	public void setTargetLabelFilter(String targetLableFilter);
}
