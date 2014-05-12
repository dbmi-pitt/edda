package edu.pitt.dbmi.edda.summarization.examples;

public class ExampleParagraphs {
	
	public static String getExampleOne() {
		StringBuffer sb = new StringBuffer();
		sb.append("See the dog run.  Spot runs fast.\nJohn and Jane watched Spot run.");
		return sb.toString();
	}
	
	public static String getExampleTwo() {
		StringBuffer sb = new StringBuffer();
		sb.append("The induction of immediate-early (IE) response genes, such as egr-1,\n");
		sb.append("  c-fos, and c-jun, occurs rapidly after the activation of T\n");
		sb.append("  lymphocytes.");
		return sb.toString();
	}
	
	public static String getExampleThree() {
		StringBuffer sb = new StringBuffer();
		sb.append("The process of activation involves calcium mobilization,\n");
		sb.append("  activation of protein kinase C (PKC), and phosphorylation of tyrosine\n");
		sb.append("  kinases.\n");
		return sb.toString();
	}
	
	public static String getExampleFour() {
		StringBuffer sb = new StringBuffer();
		sb.append("p21(ras), a guanine nucleotide binding factor, mediates\n");
		sb.append("  T-cell signal transduction through PKC-dependent and PKC-independent\n");
		sb.append("  pathways.");
		return sb.toString();
	}
	
	public static String getExampleFive() {
		StringBuffer sb = new StringBuffer();
		sb.append("The involvement of p21(ras) in the regulation of\n");
		sb.append("  calcium-dependent signals has been suggested through analysis of its\n");
		sb.append("  role in the activation of NF-AT.");
		return sb.toString();
	}
	
	public static String getExampleSix() {
		StringBuffer sb = new StringBuffer();
		sb.append("We have investigated the inductions\n");
		sb.append("  of the IE genes in response to calcium signals in Jurkat cells (in\n");
		sb.append("  the presence of activated p21(ras)) and their correlated\n");
		sb.append("  consequences.");
		return sb.toString();
	}

}
