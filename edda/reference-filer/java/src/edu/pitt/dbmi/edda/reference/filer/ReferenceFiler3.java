package edu.pitt.dbmi.edda.reference.filer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;


/**
 * this class is a front-end for reference filer app
 * @author tseytlin
 *
 */

public class ReferenceFiler3 {
	private final String ICON_PLUS="/icons/Plus16.gif",ICON_MINUS="/icons/Minus16.gif";
	private static File lastFile;
	private JFrame frame;
	private JTextField inputRefrencesInclude,inputReferencesExclude,outputDir,outputPrefix;
	private JTextField [] dataLabel,dataRatio;
	private JProgressBar progress;
	private JButton bt;
	private JList sections;
	private JPanel advanced;
	private List<String> SECTIONS = Arrays.asList("author (AU)","title (TI)","abstract (AB)","keywords (MH)","publication (SO)","entire reference (FULL)");
	
	
	public ReferenceFiler3(){
		createUI();
	}
	
	private void createUI(){
		frame = new JFrame("Reference Filer 3");
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
				if(isOK())
					doRun();
			}
		});
		
		// create fields and setup defaults
		dataLabel = new JTextField [3];
		dataRatio = new JTextField [3];
		for(int i=0;i<dataLabel.length;i++){
			dataLabel[i] = new JTextField(6);
			dataLabel[i].setHorizontalAlignment(JTextField.CENTER);
			dataRatio[i] = new JTextField(4);
			dataRatio[i].setHorizontalAlignment(JTextField.CENTER);
			dataRatio[i].setDocument(new Utils.IntegerDocument());
		}
		
		// create panel for splitting the data
		JPanel sp = new JPanel();
		sp.setBorder(new LineBorder(Color.gray));
		sp.setLayout(new BoxLayout(sp,BoxLayout.Y_AXIS));
		sp.add(createDataSplitPanel(dataLabel[0],dataRatio[0],"TRAIN","66"));
		sp.add(createDataSplitPanel(dataLabel[1],dataRatio[1],"TEST","34"));
		sp.add(createDataSplitPanel(dataLabel[2],dataRatio[2],"DEV","0"));
		
		panel.add(new JLabel("Output Data Split Ratios"),c);
		c.gridx++;
		panel.add(sp,c);
		c.gridy++;
		JButton adv = new JButton("Advanced Output Options ");
		adv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdvanced();
			}
		});
	
		panel.add(adv,c);
		
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.getContentPane().add(bt,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private boolean isOK(){
		double x = 0;
		for(int i=0;i<dataRatio.length;i++){
			x+=Double.parseDouble(dataRatio[i].getText());
		}
		if(Math.round(x*1000) != 100000.0){
			JOptionPane.showMessageDialog(frame,"The output data split ratios do not add up to 100%","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
	private String doAdd(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JComboBox box = new JComboBox(SECTIONS.toArray());
		box.setPreferredSize(new Dimension(200,45));
		JTextField weight = new JTextField(5);
		weight.setDocument(new Utils.IntegerDocument());
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		box.setBorder(new TitledBorder("Section"));
		p.setBorder(new TitledBorder("Weight"));
		p.add(weight);
		panel.add(box);
		panel.add(p);
		int r = JOptionPane.showConfirmDialog(frame,panel,"Add Sections",
				JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		if(r == JOptionPane.OK_OPTION){
			return box.getSelectedItem()+":"+weight.getText();
		}
		return null;
	}
	
	/**
	 * do advanced
	 */
	private void doAdvanced() {
		if(advanced == null){
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			
			sections = new JList(new DefaultListModel());
			ActionListener l = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if("add".equals(e.getActionCommand())){
						SwingUtilities.invokeLater(new Runnable(){
							public void run(){
								String a = doAdd();
								if(a != null){
									((DefaultListModel)sections.getModel()).addElement(a);
									sections.validate();
									sections.repaint();
								}
							}
						});
					}else if("rem".equals(e.getActionCommand())){
						SwingUtilities.invokeLater(new Runnable(){
							public void run(){
								if(sections.getSelectedIndex() > -1){
									((DefaultListModel)sections.getModel()).remove(sections.getSelectedIndex());
									sections.validate();
									sections.repaint();
								}
							}
						});
					}
					
				}
			};
			
			JButton plus = new JButton(new ImageIcon(getClass().getResource(ICON_PLUS)));
			plus.addActionListener(l);
			plus.setActionCommand("add");
			JButton minus = new JButton(new ImageIcon(getClass().getResource(ICON_MINUS)));
			minus.addActionListener(l);
			minus.setActionCommand("rem");
			
			JToolBar toolbar = new JToolBar();
			toolbar.setFloatable(false);
			toolbar.setBackground(Color.white);
			toolbar.add(plus,this);
			toolbar.add(minus,this);
			toolbar.addSeparator();
			toolbar.add(new JLabel("Sections"));
			
			panel.add(toolbar,BorderLayout.NORTH);
			panel.add(new JScrollPane(sections),BorderLayout.CENTER);
			advanced = panel;
		}
		
		JOptionPane.showMessageDialog(frame,advanced,"Advanced Output Options",JOptionPane.PLAIN_MESSAGE);
	}

	
	private JPanel createDataSplitPanel(JTextField t1,JTextField t2,String l1, String l2){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		t1.setText(l1);
		t2.setText(l2);
		p.add(new JLabel(" Output Dataset "));
		p.add(t1);
		p.add(new JLabel(" = "));
		p.add(t2);
		p.add(new JLabel(" % "));
		return p;
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
					Set<String> sec = new HashSet<String>();
					// get custom sections
					if(sections != null){
						for(int i=0;i<sections.getModel().getSize();i++){
							String str = ""+sections.getModel().getElementAt(i);
							Pattern pt = Pattern.compile(".* \\(([A-Z]+)\\):(\\d*)");
							Matcher mt = pt.matcher(str);
							if(mt.matches()){
								int x = 1;
								try{
									x = Integer.parseInt(mt.group(2));
								}catch(NumberFormatException ex){}
								sec.add(mt.group(1)+":"+x);
							}
						}
					}
						
					// get inputs
					progress.setIndeterminate(true);
					progress.setString("Reading Input References ..");
					List<Reference> includeReferences = Utils.readMedlineReferences(new File(inputRefrencesInclude.getText()));
					for(Reference r : includeReferences)
						r.setIncluded(true);
					List<Reference> excludeReferences = Utils.readMedlineReferences(new File(inputReferencesExclude.getText()));
					
					List<Reference> inputReferences = new ArrayList<Reference>();
					inputReferences.addAll(includeReferences);
					inputReferences.addAll(excludeReferences);
					
					// now generate a proper output
					File dir = new File(outputDir.getText());
					dir.mkdirs();
					
					// create dirs
					//File testData = new File(dir,"TEST_data");
					//testData.mkdir();
					//File trainData = new File(dir,"TRAIN_data");
					//trainData.mkdir();
					String prefix = outputPrefix.getText().trim();
	
					// create debug files
					File debugFile = new File(dir,prefix.toLowerCase()+"-reference-list.csv");
					BufferedWriter writer = new BufferedWriter(new FileWriter(debugFile));
					writer.write("IDENTIFIER,AUTHORS,TITLE,INCLUDED,TRAIN/TEST\n");
					
					// prefixes
					String [] dataL = new String [dataLabel.length];
					double []  dataR = new double [dataLabel.length];
					for(int i=0;i<dataL.length;i++){
						dataL[i] = dataLabel[i].getText();
						dataR[i] = Double.parseDouble(dataRatio[i].getText())/100.0;
					}
					Utils.DataSplitter spliter1 = new Utils.DataSplitter(dataL,dataR,includeReferences.size());
					Utils.DataSplitter spliter2 = new Utils.DataSplitter(dataL,dataR,excludeReferences.size());
					
					// go over each reference
					int offset = 1;
					progress.setIndeterminate(false);
					progress.setString("Generating Output ...");
					progress.setMinimum(0);
					progress.setMaximum(inputReferences.size());
					
					for(Reference ref : inputReferences){
						
						// select right prefix based on allocation ratios
						String dirPrefix = (ref.isIncluded())?spliter1.getLabel():spliter2.getLabel();
							
						//is article included in review
						// only use first two categories
						boolean isIncluded   = ref.isIncluded();
						
						progress.setValue(offset);
						String name = prefix+offset++;
						
						// get parent directory
						//File d = null;//(trainDataset)?trainData:testData;
						File d = new File(dir,dirPrefix+"_data");
						if(!d.exists())	
							d.mkdirs();
						
						writeRefernce(ref,"FULL",isIncluded,d,name);
						writeRefernce(ref,"TA",isIncluded,d,name);
						writeRefernce(ref,"TI",isIncluded,d,name);
						if(!sec.isEmpty())
							writeRefernce(ref,sec.toString(), isIncluded, d, name);
						
						// save debug entry
						writer.write(name+",\""+ref.getAuthors()+"\",\""+ref.getTitle()+"\","+isIncluded+","+dirPrefix+"\n");
						
						
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
		String fname = format;
		if(format.startsWith("[") && format.endsWith("]")){
			fname = format.replaceAll("[^A-Z]","");
		}
		// figure out folder and file
		String suffix = dir.getName().substring(0,dir.getName().indexOf("_")).toLowerCase();
		File folder = new File(dir,fname+"_"+((isIncluded)?"Y":"N")+"_"+suffix);
		if(!folder.exists())
			folder.mkdirs();
		File file  = new File(folder,name+"_"+fname+".txt");
		
		// save file
		ref.write(file,format);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ReferenceFiler3();

	}

}
