package edu.pitt.dbmi.edda.reference.filer;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import edu.pitt.dbmi.edda.reference.filer.model.CochraneReference;
import edu.pitt.dbmi.edda.reference.filer.model.EndNoteReference;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;




/**
 * this class is a front-end for reference filer app
 * @author tseytlin
 *
 */

public class ReferenceFiler2 {
	private static File lastFile;
	private JFrame frame;
	private JTextField inputRefrencesInclude,inputReferencesExclude,outputDir,outputPrefix;
	private JProgressBar progress;
	private JButton bt;
	
	public ReferenceFiler2(){
		createUI();
	}
	
	private void createUI(){
		frame = new JFrame("Reference Filer 2");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// init parameter text
		inputRefrencesInclude = new JTextField(25);
		inputReferencesExclude = new JTextField(25);
		outputPrefix = new JTextField(25);
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
		
		createDirectoryPanel("Input EndNote Reference File (include)",inputRefrencesInclude,panel,c);
		createDirectoryPanel("Input EndNote Reference File (exclude)",inputReferencesExclude,panel,c);
		createDirectoryPanel("Output Directory",outputDir,panel,c);
		createDirectoryPanel("Output Prefix",outputPrefix,panel,c,false);
		
		progress = new JProgressBar();
		progress.setStringPainted(true);
		progress.setMinimum(0);
		
		bt = new JButton("Run Reference Filer");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRun();
			}
		});
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.getContentPane().add(bt,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
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
					JFileChooser chooser = new JFileChooser(lastFile);
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
					List<Reference> inputReferences = readInputReferences(new File(inputRefrencesInclude.getText()));
					for(Reference r : inputReferences)
						r.setIncluded(true);
					inputReferences.addAll(readInputReferences(new File(inputReferencesExclude.getText())));
					
					
					// now generate a proper output
					File dir = new File(outputDir.getText());
					dir.mkdirs();
					
					// create dirs
					File testData = new File(dir,"TEST_data");
					testData.mkdir();
					File trainData = new File(dir,"TRAIN_data");
					trainData.mkdir();
					String prefix = outputPrefix.getText().trim();
	
					// create debug files
					File debugFile = new File(dir,prefix.toLowerCase()+"-reference-list.csv");
					BufferedWriter writer = new BufferedWriter(new FileWriter(debugFile));
					writer.write("IDENTIFIER,AUTHORS,TITLE,INCLUDED,TRAIN/TEST\n");
					
					
					
					// go over each reference
					int offset = 1;
					progress.setIndeterminate(false);
					progress.setString("Generating Output ...");
					progress.setMinimum(0);
					progress.setMaximum(inputReferences.size());
					
					for(Reference ref : inputReferences){
						
						// there is 2:1 assignment that article is in training set
						// right now it is random that doesn't work well for small datasets
						boolean trainDataset = (Math.random()*10) > 3.3333333333333333333333;
						
						//is article included in review
						// only use first two categories
						boolean isIncluded   = ref.isIncluded();
						
						progress.setValue(offset);
						String name = prefix+offset++;
						
						// get parent directory
						File d = (trainDataset)?trainData:testData;
						writeRefernce(ref,"FULL",isIncluded,d,name);
						writeRefernce(ref,"TA",isIncluded,d,name);
						writeRefernce(ref,"TI",isIncluded,d,name);
						
						// save debug entry
						writer.write(name+",\""+ref.getAuthors()+"\",\""+ref.getTitle()+"\","+isIncluded+","+((trainDataset)?"TRAIN":"TEST")+"\n");
						
						
					}
					
					writer.close();
					
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
	
	/**
	 * write each reference based on format
	 * @param ref
	 * @param string
	 * @param isIncluded
	 * @param d
	 */
		
	private void writeRefernce(Reference ref, String format, boolean isIncluded, File dir, String name) {
		// figure out folder and file
		String suffix = dir.getName().substring(0,dir.getName().indexOf("_")).toLowerCase();
		File folder = new File(dir,format+"_"+((isIncluded)?"Y":"N")+"_"+suffix);
		if(!folder.exists())
			folder.mkdirs();
		File file  = new File(folder,name+"_"+format+".txt");
		
		// save file
		ref.write(file,format);
	}

	private Map<String,List<Reference>> readFilterReferences(File file) {
		Map<String,List<Reference>> filterMap = new LinkedHashMap<String, List<Reference>>();
	
		
		// lets read in an XML file generated from PDF
		try {
			Document doc = Utils.parseXML(new FileInputStream(file));
		
			// lets find approprate section 
			for(Element e: Utils.getElementsByTagName(Utils.getElementByTagName(doc.getDocumentElement(),"Part"),"Sect")){
				// find ACKNOWLEDGEMENTS section 
				Element acknowledgements = Utils.getElementByTagName(e,"H5");
				if(acknowledgements != null && "ACKNOWLEDGEMENTS".equals(acknowledgements.getTextContent().trim())){
					// YEAHAA we got there!!!!
					String title = null;
					List<Reference> list = null; 
					StringBuffer buffer = new StringBuffer();
					for(Element sect: Utils.getElementsByTagName(e,"Sect",true)){
						for(Element child: Utils.getChildElements(sect)){
							if("H5".equals(child.getTagName())){
								// we got us a section heading
								title = child.getTextContent().trim();
								list  = new ArrayList<Reference>();
								filterMap.put(title,list);
							}else if("H6".equals(child.getTagName())){
								// we can ignore those
							}else if("P".equals(child.getTagName()) && list != null){
								// we got a reference, hopefully
								String text = child.getTextContent().trim();
								
								// append to buffer
								// this is done cause some references are spanned across multiple P tags
								buffer.append(text);
								
								// if record ends with period then we have a complete record
								if(text.endsWith(".")){
									list.add(new CochraneReference(buffer.toString()));
									// reset buffer for new record
									buffer = new StringBuffer();
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filterMap;
	}

	private List<Reference> readInputReferences(File file) {
		List<Reference> list = new ArrayList<Reference>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuffer buffer = new StringBuffer();
			//boolean referenceStart = false;
			for(String line = reader.readLine();line != null; line = reader.readLine()){
				line = line.replaceAll("\uFEFF","").trim();
				if(line.length() == 0)
					continue;
				
				// break references apart by finding an author tag
				if(line.startsWith("AU  ")){
					// write out the old buffer
					if(buffer.length() > 0)
						list.add(new EndNoteReference(buffer.toString()));
					
					// start working on new reference
					buffer = new StringBuffer();
					//referenceStart = true;
				// some $#*&^@ entries might have no author
				}else if(line.startsWith("TI  ")){
					// now if buffer already contains a title, then it is a second entry
					Pattern pt = Pattern.compile("^TI  .*$",Pattern.MULTILINE);
					Matcher mt = pt.matcher(buffer.toString());
					if(mt.find()){
						// write out the old buffer
						if(buffer.length() > 0)
							list.add(new EndNoteReference(buffer.toString()));
						
						// start working on new reference
						buffer = new StringBuffer();
						//referenceStart = true;
					}
				}
				
				//if(referenceStart)
				buffer.append(line+"\n");
				
				//System.out.println(line);
				
			}
			
			// write out the last record
			if(buffer.length() > 0)
				list.add(new EndNoteReference(buffer.toString()));
			
			// close
			reader.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ReferenceFiler2();

	}

}
