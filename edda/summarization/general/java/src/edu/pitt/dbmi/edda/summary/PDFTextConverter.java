package edu.pitt.dbmi.edda.summary;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;

import java.io.*;
import java.util.*;


public class PDFTextConverter extends PDFTextStripper {
	//private static Map<String,Integer> fontMap = new HashMap<String,Integer>();
	//private static List<String> validFonts = new ArrayList<String>();
	private PDDocument pdf;
	private List<String> text;
	private List<TextSpan> spans;
	private TextSpan last;
	
	public PDFTextConverter(File pdfFile) throws IOException {
		super();
		pdf = PDDocument.load(pdfFile);
	}
	
	public void dispose() throws IOException{
		pdf.close();
	}
	
	/**
	 * text span
	 * @author tseytlin
	 *
	 */
	public class TextSpan {
	private String fontName,fontLabel,sizeLabel;
		private double fontSize;
		private StringBuffer text = new StringBuffer();
		public TextSpan(TextPosition p){
			append(p);
			fontName = p.getFont().getFontDescriptor().getFontName();
			fontSize = p.getFontSizeInPt();
		}
		public boolean isSameAs(TextPosition p){
			return fontSize == p.getFontSizeInPt() && fontName.equals(p.getFont().getFontDescriptor().getFontName());
		}
		public void append(TextPosition p){
			text.append(p.getCharacter());
		}
		public String toString(){
			return getText()+" | "+getFontInfo();
		}
		public String getText(){
			return text.toString();
		}
		public String getFontInfo(){
			return fontName+" ("+fontSize+") ["+fontLabel+":"+sizeLabel+"]";
		}
		public String getFontName(){
			return fontName;
		}
		public double getFontSize(){
			return fontSize;
		}
		public int getLength(){
			return text.length();
		}
		public String getFontLabel() {
			return fontLabel;
		}
		public void setFontLabel(String fontLabel) {
			this.fontLabel = fontLabel;
		}
		public String getSizeLabel() {
			return sizeLabel;
		}
		public void setSizeLabel(String sizeLabel) {
			this.sizeLabel = sizeLabel;
		}
		
	}
	
	public List<String> getTextLines(){
		if(text == null)
			try {
				text = convertPDF();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return text;
	}
	
	public String getText(){
		StringBuffer b = new StringBuffer();
		for(String l: getTextLines())
			b.append(l+"\n");
		return b.toString();
	}
	
	public List<TextSpan> getTextSpans(){
		return spans;
	}
	
	
	private List<String> convertPDF() throws IOException {
		spans = new ArrayList<TextSpan>();
		last = null;
		
		StringWriter writer = new StringWriter();
		writeText(pdf,writer);
		
		if(last != null)
			spans.add(last);
		
		analyzeSpans();
		return Arrays.asList(writer.toString().split("\n"));
	}
	
	private void analyzeSpans(){
		Map<String,Integer> fontMap = new HashMap<String,Integer>();
		Map<Double,Integer> sizeMap = new HashMap<Double,Integer>();
		// gather stats
		for(TextSpan t: getTextSpans()){
			fontMap.put(t.getFontName(),(fontMap.containsKey(t.getFontName())?fontMap.get(t.getFontName()):0)+t.getLength());
			sizeMap.put(t.getFontSize(),(sizeMap.containsKey(t.getFontSize())?sizeMap.get(t.getFontSize()):0)+t.getLength());
		}
		// now add labels to spans for common/different - font name and small/normal/large font sizes
		String commonFont = null;
		int n = 0;
		for(String nm: fontMap.keySet()){
			if(fontMap.get(nm) > n){
				n = fontMap.get(nm);
				commonFont = nm;
			}
		}
		double commonSize = 0;
		n = 0;
		for(double size: sizeMap.keySet()){
			if(sizeMap.get(size) > n){
				commonSize = size;
				n = sizeMap.get(size);
			}
		}
		
		// label spans
		for(TextSpan t: getTextSpans()){
			if(t.getFontName().equals(commonFont))
				t.setFontLabel("common");
			else
				t.setFontLabel("different");
			
			if(t.getFontSize() == commonSize)
				t.setSizeLabel("normal");
			else if (t.getFontSize() < commonSize)
				t.setSizeLabel("small");
			else
				t.setSizeLabel("large");
		}
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String f = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/Galacto_Enriched_March20-with-PDFs.Data/PDF/0011088760/Patterson-1978-[Comparison of radio.pdf";
		PDFTextConverter conv = new PDFTextConverter(new File(f));
		for(String l: conv.getTextLines()){
			System.out.println(l);
		}
		System.out.println("---");
		for(TextSpan t: conv.getTextSpans()){
			System.out.println(t);
		}
		
		
	}

	protected void processTextPosition(TextPosition text) {
		super.processTextPosition(text);
		if(last == null){
			last = new TextSpan(text);
		}else if(last.isSameAs(text)){
			last.append(text);
		}else{
			spans.add(last);
			last = new TextSpan(text);
		}
	}
}
