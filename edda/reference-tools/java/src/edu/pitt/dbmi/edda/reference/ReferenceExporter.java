package edu.pitt.dbmi.edda.reference;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import edu.pitt.dbmi.edda.EDDA;
import edu.pitt.dbmi.edda.reference.filer.ReferenceFiler;
import edu.pitt.dbmi.edda.reference.filer.model.EndNoteReference;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;

public class ReferenceExporter {
	public static boolean standAlone = false;
	private JFrame frame;
	private JTextField inputReferences,inputDecisions,outputDir;
	private JButton bt;
	private JProgressBar progress;
	private File lastFile;
	
	
	private JFrame createUI(){
		frame = new JFrame("Reference Exporter");
		frame.getContentPane().setLayout(new BorderLayout());
		if(standAlone)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// init parameter text
		inputReferences = new JTextField(25);
		inputDecisions = new JTextField(25);
		outputDir = new JTextField(25);
		
		// init panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(new CompoundBorder(new EmptyBorder(10,10,20,10),new BevelBorder(BevelBorder.RAISED)));
		// init constraints
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		c.gridx = 0;
		
		createDirectoryPanel("Input Reference Directory",inputReferences,panel,c);
		createDirectoryPanel("Input Dicisions File",inputDecisions,panel,c);
		createDirectoryPanel("Output Directory",outputDir,panel,c);

		
		progress = new JProgressBar();
		progress.setStringPainted(true);
		progress.setMinimum(0);
		
		bt = new JButton("Export Decisions");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRun();
			}
		});
		
	
		
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.getContentPane().add(bt,BorderLayout.SOUTH);
		
		frame.pack();
		
		setupDefaults();
		return frame;
	}
	private void setupDefaults(){
		// setup defaults
		if(EDDA.getInstance().getProjectDirectory() != null){
			setProjectDirectory(EDDA.getInstance().getProjectDirectory());
		}
	}
	
	/**
	 * container for references from decision file
	 * @author tseytlin
	 */
	private class OutputReference implements Comparable<OutputReference> {
		public Reference reference;
		public String name, label, predictedLabel;
		
		public String toString(){
			return label+"\t"+predictedLabel+"\t"+name+"\t"+reference.getTitle();
		}
		public int getRecordNumber(){
			Matcher m = Pattern.compile("\\d+").matcher(name);
			if(m.find())
				return Integer.parseInt(m.group());
			return 0;
		}
		public int compareTo(OutputReference o) {
			return getRecordNumber() - o.getRecordNumber();
		}
	}
	
	/**
	 * read decision file and 
	 * @param diceisionFile
	 * @param referenceDirectory
	 * @return
	 * @throws IOException 
	 */
	private List<OutputReference> readDecisionFile(File diceisionFile, File referenceDirectory) throws IOException{
		final String S = "\t";
		int n = 0;
		List<OutputReference> list = new ArrayList<ReferenceExporter.OutputReference>();
		BufferedReader r = new BufferedReader(new FileReader(diceisionFile));
		for(String l=r.readLine();l != null; l = r.readLine()){
			String [] p = l.split(S);
			if(p.length > 2){
				progress.setValue(n++);
				String file  = p[0].trim();
				String label = p[1].trim();
				String predLabel = p[2].trim();
				
				// find reference
				File refFile = findFile(referenceDirectory,file);
				if(refFile != null){
					OutputReference ref = new OutputReference();
					ref.reference =  readReference(refFile);
					ref.name = file;
					ref.label = label;
					ref.predictedLabel = predLabel;
					
					list.add(ref);
				}
				
			}
		}
		r.close();
		
		return list;
	}
	
	
	private Reference readReference(File refFile){
		for(Reference r: Utils.readEndNoteReferences(refFile)){
			return r;
		}
		return null;
	}
	
	
	private List<File> getDirs(File dir, List<File> dirs){
		dirs.add(dir);
		for(File f: dir.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		})){
			getDirs(f, dirs);
		}
		return dirs;
	}
	
	
	private File findFile(File referenceDirectory, String file) {
		List<File> dirs = getDirs(referenceDirectory,new ArrayList<File>());
		for(File d: dirs){
			File f = new File(d,file);
			if(f.exists())
				return f;
		}
		
		return null;
	}


	private int getLineCount(File diceisionFile) throws IOException {
		int n = 0;
		BufferedReader r = new BufferedReader(new FileReader(diceisionFile));
		for(String l=r.readLine();l != null; l = r.readLine()){
			n++;
		}
		r.close();
		return n;
	}

	/**
	 * do the actual split
	 */
	private void doRun(){
		// place progress bar
		frame.getContentPane().remove(bt);
		frame.getContentPane().add(progress,BorderLayout.SOUTH);
		frame.getContentPane().validate();
		
		(new Thread(new Runnable(){
			public void run(){
				try{
						
					// get inputs
					progress.setIndeterminate(true);
					progress.setString("Reading Input References ..");
					
					File diceisionFile = new File(inputDecisions.getText());
					File referenceDirectory = new File(inputReferences.getText());
					
					
					
					// go over each reference
					progress.setIndeterminate(false);
					progress.setString("Reading References ...");
					progress.setMinimum(0);
					progress.setMaximum(getLineCount(diceisionFile));
					
					
					List<OutputReference> inputReferences = readDecisionFile(diceisionFile, referenceDirectory);
					Collections.sort(inputReferences);
					
					// now generate a proper output
					File dir = new File(outputDir.getText());
					dir.mkdirs();
					
					File excelFile = new File(dir,"Output References.xlsx");
				
					// write to excel
					progress.setString("Saving to Excel ...");
					progress.setIndeterminate(true);
					exportToExcel(inputReferences, excelFile);
					progress.setIndeterminate(false);
					
					// write to RIS
					progress.setString("Saving as RIS ...");
					progress.setIndeterminate(true);
					exportToRIS(inputReferences, new File(dir,"RIS"));
					progress.setIndeterminate(false);
					
					
					progress.setString("done");
				}catch(Exception ex){
					JOptionPane.showMessageDialog(frame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
				JOptionPane.showMessageDialog(frame,"All Done","Done",JOptionPane.INFORMATION_MESSAGE);
				
				frame.getContentPane().remove(progress);
				frame.getContentPane().add(bt,BorderLayout.SOUTH);
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
			}

		})).start();
		
		
	}
	
	private void exportToRIS(List<OutputReference> list, File exportDir) throws IOException {
		// create directory if needed
		exportDir.mkdirs();
		// remove existing files there
		for(File f: exportDir.listFiles()){
			f.delete();
		}
		
		// go over references
		for(OutputReference ref: list){
			String fileName = "REAL_"+ref.label+"+PRED_"+ref.predictedLabel+".ris";
			ref.reference.write(new BufferedWriter(new FileWriter(new File(exportDir,fileName),true)));
		}
	}
	
	private void exportToExcel(List<OutputReference> list, File exportFile) throws IOException {
		SXSSFWorkbook wb =  new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
              
		// dynamically create sheets
		Map<String,Sheet> sheets = new LinkedHashMap<String,Sheet>();
		Map<String,Integer> sheetOffsets = new LinkedHashMap<String, Integer>();
		Map<String,Integer> counts = new HashMap<String, Integer>();
		
		// go over references
		for(OutputReference reference: list){
			String sheetName = "real "+reference.label+" + pred "+reference.predictedLabel;
			
			// count it
			int n = counts.containsKey(sheetName)?counts.get(sheetName):0;
			counts.put(sheetName,n+1);
			
			// get sheet to write this reference to
			Sheet sh = sheets.get(sheetName);
			Integer rowNum = sheetOffsets.get(sheetName);
			
			// create new worksheet
			if(sh == null){
				sh = wb.createSheet(sheetName);
				sheets.put(sheetName,sh);
				sheetOffsets.put(sheetName,0);
				
				// create header row
				Row row = sh.createRow(0);
				row.createCell(0).setCellValue("Record Number");
				row.createCell(1).setCellValue("Actual Label");
				row.createCell(2).setCellValue("Predicted Label");
				row.createCell(3).setCellValue("Reference Title");
				
				// new row number
				rowNum = new Integer(1);
			}
			
			
			// create row
			Row row = sh.createRow(rowNum.intValue());
			
			// increment
			sheetOffsets.put(sheetName,rowNum.intValue()+1);

			// write out cells
			row.createCell(0).setCellValue(reference.getRecordNumber());
			row.createCell(1).setCellValue(reference.label);
			row.createCell(2).setCellValue(reference.predictedLabel);
			row.createCell(3).setCellValue(reference.reference.getTitle());
    	}
		
		// create stats woksheet
		Sheet sh = wb.createSheet("stats");
		
		Row r =	sh.createRow(0);
		r.createCell(1).setCellValue("pred include");
		r.createCell(2).setCellValue("pred exclude");
		
		r =	sh.createRow(1);
		r.createCell(0).setCellValue("real include");
		r.createCell(1).setCellValue(counts.get("real include + pred include"));
		r.createCell(2).setCellValue(counts.get("real include + pred exclude"));

		r =	sh.createRow(2);
		r.createCell(0).setCellValue("real exclude");
		r.createCell(1).setCellValue(counts.get("real exclude + pred include"));
		r.createCell(2).setCellValue(counts.get("real exclude + pred exclude"));
		
		
		//write out the Excel file
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(exportFile);
			wb.write(out);
		    out.close();
		} catch (IOException e) {
			throw new IOException("Unable to write worksheet",e);
		}finally{
			if(out != null)
				out.close();
			
			// dispose of workbook
			wb.close();
			wb.dispose();
		}

  }
	
	
	
	/**
	 * create directory panel
	 * @param title
	 * @param field
	 * @return
	 */

	private void createDirectoryPanel(String title, JTextField  field,JPanel p, GridBagConstraints c){
		createDirectoryPanel(title, field, p, c,true);
	}
	/**
	 * create directory panel
	 * @param title
	 * @param field
	 * @return
	 */

	private void createDirectoryPanel(String title, JTextField  field,JPanel p, GridBagConstraints c, boolean browse){
		final JTextField textField = field;
		
		p.add(new JLabel(title),c);
		c.gridx++;
		p.add(field,c);
		c.gridx++;
		if(browse){
			JButton bt = new JButton("Browse");
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File f = new File(textField.getText());
					if(!f.exists())
						f = lastFile;
					JFileChooser chooser = new JFileChooser(f);
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					int r = chooser.showOpenDialog(frame);
					if(JFileChooser.APPROVE_OPTION == r){
						lastFile = chooser.getSelectedFile();
						textField.setText(lastFile.getAbsolutePath());
					}
				}
			});
			p.add(bt,c);
		}
		c.gridx = 0;
		c.gridy++;
	}
	
	public void showDialog(){
		getDialog().setVisible(true);
	}
	
	public JFrame getDialog(){
		if(frame == null)
			frame = createUI();
		return frame;
	}
	
	public void setProjectDirectory(File dir) {
		if(dir == null)
			return;
		final File projectDir = dir;
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				inputReferences.setText(new File(projectDir,"Input"+File.separator+"100_2xTitles").getAbsolutePath());
				inputDecisions.setText(new File(projectDir,"Output").getAbsolutePath());
				outputDir.setText(new File(projectDir,"Output").getAbsolutePath());
			}
		});
		
	}

	
	
	public static void main(String[] args) {
		standAlone = true;
		new ReferenceExporter().showDialog();

	}

	
}
