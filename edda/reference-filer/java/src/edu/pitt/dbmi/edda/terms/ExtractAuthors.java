package edu.pitt.dbmi.edda.terms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import edu.pitt.dbmi.edda.reference.filer.model.EndNoteReference;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;
import edu.pitt.text.tools.TextTools;

public class ExtractAuthors {
	private final int INFREQUENT_TERM_NUMBER = 1;
	private final String PREFIX= "[it] ";
	private List<Reference> referenceList;
	private int includeDocSize,excludeDocSize;
	private Map<String,Integer> includeTerms,excludeTerms;
	private JFrame frame;
	private JTextArea inputText;
	private JTextField outputField,numberOfDifferentiatingTerms;
	private JCheckBox removeInfrequentTerms, findDifferentiatingTerms,outputTerms;
	private JProgressBar progress;
	private JButton bt;
	private File lastFile;
	
	/**
	 * get reference list
	 * @return
	 */
	public List<Reference> getReferenceList(){
		if(referenceList == null){
			referenceList = new ArrayList<Reference>();
		}
		return referenceList;
	}
	
	/**
	 * load in a list of references
	 * @param file
	 */
	public void load(File file){
		if(file.isDirectory()){
			for(File f: file.listFiles()){
				List<Reference> list = Utils.readMedlineReferences(f);
				if(file.getName().toLowerCase().contains("_y_")){
					for(Reference r: list)
						r.setIncluded(true);
				}
				getReferenceList().addAll(list);
			}
		}else{
			List<Reference> list = Utils.readMedlineReferences(file);
			if(file.getName().toLowerCase().contains("yes") || file.getName().toLowerCase().contains("include")){
				for(Reference r: list)
					r.setIncluded(true);
			}
			getReferenceList().addAll(list);
		}
	}
	
	/**
	 * do actual work with whatever is in reference list
	 */
	public void process(){
		// go over references
		includeTerms = new HashMap<String,Integer>();
		excludeTerms = new HashMap<String,Integer>();
		
		int i=0;
		for(Reference r: getReferenceList()){
			if(r instanceof EndNoteReference){
				Map<String,Integer> terms = (r.isIncluded())?includeTerms:excludeTerms;
				
				// keep tally of number of documents in each category
				if(r.isIncluded())
					includeDocSize ++;
				else
					excludeDocSize ++;
				
				for(String key: new HashSet<String>(Utils.getAuthors(r))){
					if(terms.containsKey(key))
						terms.put(key,terms.get(key)+1);
					else
						terms.put(key,1);
				}
				if(progress != null){
					progress.setValue(++i);
				}
			}
		}
		//System.out.println("Total terms: "+includeTerms.size());
	}
	
	/**
	 * get a set of terms 
	 * @return
	 */
	public Map<String,Double> getTerms(){
		// if we need to find discriminative terms then we
		// need to seperate them, else we need to merge them
		if(findDifferentiatingTerms.isSelected()){
			// brand new map to return
			Map<Double,Set<String>> deltaTerms = new TreeMap<Double,Set<String>>(new Comparator<Double>(){
				public int compare(Double o1, Double o2){
					return (int)(10000*o2.doubleValue()) - (int)(10000*o1.doubleValue());
				}
			});
			
			//get all of the keys
			Set<String> keys = new HashSet<String>();
			keys.addAll(includeTerms.keySet());
			keys.addAll(excludeTerms.keySet());
			
			// go over all keywords
			for(String key: keys){
				double incFreq = 0;
				double excFreq = 0;
				
				if(includeTerms.containsKey(key))
					incFreq = includeTerms.get(key);
				if(excludeTerms.containsKey(key))
					excFreq = excludeTerms.get(key);
				
				double delta = Math.abs(incFreq/includeDocSize - excFreq/excludeDocSize);
				if(!deltaTerms.containsKey(delta))
					deltaTerms.put(delta,new HashSet<String>());
				deltaTerms.get(delta).add(key);
				//System.out.println(key+" = "+delta);
			}
			// now pick the top most hitters
			Map<String,Double> terms = new TreeMap<String,Double>();
			int n = Integer.parseInt(numberOfDifferentiatingTerms.getText());
			int i = 0;
			for(Double d: deltaTerms.keySet()){
				for(String key : deltaTerms.get(d)){
					terms.put(key,d);
					i++;
				}
				if(i >=  n)
					break;
			}
			return terms;
		}else{
			// merge terms
			Map<String,Double> terms = new TreeMap<String, Double>();
			for(String t: excludeTerms.keySet())
				terms.put(t,new Double(excludeTerms.get(t)));
			for(String t: includeTerms.keySet()){
				double o = 0;
				if(terms.containsKey(t))
					o = terms.get(t);
				terms.put(t,o+includeTerms.get(t));
			}
		
			// if need to remove infrequent terms, then ..
			if(removeInfrequentTerms.isSelected()){
				for(String t: new HashSet<String>(terms.keySet())){
					if(terms.get(t) <= INFREQUENT_TERM_NUMBER)
						terms.remove(t);
				}
			}
			
			return terms;
		}
	}
	
	
	/**
	 * save output XML file
	 * @param f
	 * @throws Exception
	 */
	public void save(File f,String format) throws Exception{
		Map<String,Double> terms = getTerms();
		if("xml".equalsIgnoreCase(format)){
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write("<?xml version=\"1.0\"?>\n");
			writer.write("<regexes>\n");
			for(String e: terms.keySet()){
				writer.write("\t<regex>\n");
				writer.write("\t\t<name>"+PREFIX+TextTools.escapeHTML(e)+"</name>\n");
				if(outputTerms.isSelected())
					writer.write("\t\t<value>"+TextTools.escapeHTML(e)+"</value>\n");
				else
					writer.write("\t\t<value>"+TextTools.escapeHTML(e.replaceAll("[\\*\\[\\]\\(\\)\\{\\}\\^\\$\\+\\?\\|]",".").replaceAll(" +","\\\\s+"))+"</value>\n");
				writer.write("\t</regex>\n");
			}
			writer.write("</regexes>\n");
			writer.close();
		}else{
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			for(String e: terms.keySet()){
				writer.write(e+" : "+terms.get(e)+"\n");
			}
			writer.close();
		}
	}
	
	
	/**
	 * display UI dialog
	 */
	private void showDialog(){
		if(frame == null){
			frame = new JFrame("Extract Authors");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// init panel
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			panel.setBorder(new CompoundBorder(new EmptyBorder(10,10,20,10),new BevelBorder(BevelBorder.RAISED)));
			// init constraints
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(5,5,5,5);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridy = 0;
			c.gridx = 0;
			c.anchor = GridBagConstraints.NORTH;
			
			inputText = new JTextArea(3,25);
			inputText.setBorder(new LineBorder(Color.gray));
			outputField = new JTextField(25);
			
			createDirectoryPanel("Input EndNote Reference File",inputText,panel,c);
			createDirectoryPanel("Output File",outputField,panel,c);
			
			// add options
			JPanel options = new JPanel();
			options.setLayout(new BoxLayout(options,BoxLayout.Y_AXIS));
			options.setBorder(new TitledBorder("Options"));
			
		
			removeInfrequentTerms = new JCheckBox("Remove infrequent terms (if term occurs only once)");
			findDifferentiatingTerms = new JCheckBox("Extract only the most discriminative terms");
			//findDifferentiatingTerms.setToolTipText("");
			numberOfDifferentiatingTerms = new JTextField(6);
			numberOfDifferentiatingTerms.setHorizontalAlignment(JTextField.CENTER);
			numberOfDifferentiatingTerms.setDocument(new Utils.IntegerDocument(0));
			numberOfDifferentiatingTerms.setText("100");
			outputTerms = new JCheckBox("Save terms in the output XML file as exact strings, NOT regular expressions");
			
			JPanel p = new JPanel();
			p.setLayout(new BorderLayout());
			p.add(findDifferentiatingTerms,BorderLayout.CENTER);
			p.add(numberOfDifferentiatingTerms,BorderLayout.EAST);
			p.setMaximumSize(new Dimension(420,findDifferentiatingTerms.getPreferredSize().height));
			
			
			options.add(removeInfrequentTerms);
			options.add(p);
			options.add(outputTerms);
			
			for(int i=0;i<options.getComponentCount();i++)
				((JComponent)options.getComponent(i)).setAlignmentX(JComponent.LEFT_ALIGNMENT);
			
			c.gridwidth = 3;
			panel.add(options,c);
			
			progress = new JProgressBar();
			progress.setStringPainted(true);
			progress.setMinimum(0);
			
			bt = new JButton("Run Author Extractor");
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					doRun();
				}
			});
			
			
			frame.getContentPane().add(panel,BorderLayout.CENTER);
			frame.getContentPane().add(bt,BorderLayout.SOUTH);
			frame.pack();
		}
		frame.setVisible(true);
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
					// setup options
					getReferenceList().clear();
					
					//load inputs
					for(String f : inputText.getText().split("\n")){
						final String name = f;
						SwingUtilities.invokeLater(new Runnable(){
							public void run(){
								progress.setIndeterminate(true);
								progress.setString("Reading Input References "+name+" ...");
							}
						});
						load(new File(f));
					}
					SwingUtilities.invokeLater(new Runnable(){
						public void run(){
							progress.setString("Processing Input References ..");
							progress.setMinimum(0);
							progress.setValue(0);
							progress.setMaximum(getReferenceList().size());
							progress.setIndeterminate(false);
						}
					});
					// process
					process();
					
					// save 
					File out = new File(outputField.getText());
					SwingUtilities.invokeLater(new Runnable(){
						public void run(){
							progress.setString("Saving Keywords ..");
							progress.setIndeterminate(true);
						}
					});
					save((out.isDirectory())?new File(out,"Authors.xml"):new File(out.getAbsolutePath()+".xml"),"XML");
					save((out.isDirectory())?new File(out,"Authors.txt"):new File(out.getAbsolutePath()+".txt"),"TXT");
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(frame,"Encountered a problem "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						frame.getContentPane().remove(progress);
						frame.getContentPane().add(bt,BorderLayout.SOUTH);
						frame.pack();
						frame.repaint();
						
					}
				});
				
				JOptionPane.showMessageDialog(frame,"All Done!");
				
			}
		})).start();
	}
	
	/**
	 * create directory panel
	 * @param title
	 * @param field
	 * @return
	 */

	private void createDirectoryPanel(String title, JTextComponent  field,JPanel p, GridBagConstraints c){
		createDirectoryPanel(title, field, p, c,true);
	}
	/**
	 * create directory panel
	 * @param title
	 * @param field
	 * @return
	 */

	private void createDirectoryPanel(String title, JTextComponent  field,JPanel p, GridBagConstraints c, boolean browse){
		final JTextComponent textField = field;
		
		p.add(new JLabel(title),c);
		c.gridx++;
		if(field instanceof JTextArea)
			p.add(new JScrollPane(field),c);
		else
			p.add(field,c);
		c.gridx++;
		if(browse){
			JButton bt = new JButton("Browse");
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser(lastFile);
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					chooser.setMultiSelectionEnabled(true);
					int r = chooser.showOpenDialog(frame);
					if(JFileChooser.APPROVE_OPTION == r){
						for(File f : chooser.getSelectedFiles()){
							lastFile = f;
							if(textField instanceof JTextArea){
								String nm = "";
								if(textField.getText().length() > 0)
									nm = textField.getText()+"\n";
								
								textField.setText(nm+lastFile.getAbsolutePath());
							}else	
								textField.setText(lastFile.getAbsolutePath());
						}
					}
				}
			});
			p.add(bt,c);
		}
		c.gridx = 0;
		c.gridy++;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//String in1 = "/home/tseytlin/Download/Sample_EmtreeInAbstract.txt";
		//String in2 = "/home/tseytlin/Work/systematic-reviews/data/AMELO_YES_Feb2412.txt";
		//String in4 = "/home/tseytlin/Work/systematic-reviews/data/AMELO_NO_Feb2412.txt";
		/*
		String in4 = "/home/tseytlin/Work/systematic-reviews/data/FLU_YES_REV.txt";
		String in5 = "/home/tseytlin/Work/systematic-reviews/data/FLU_NO_REV.txt";
		String out1 = "/home/tseytlin/Keywords.xml";
		String out2 = "/home/tseytlin/Keywords.txt";
		*/
		ExtractAuthors emt = new ExtractAuthors();
		emt.showDialog();
		//emt.load(new File(in1));
//		emt.load(new File(in2));
//		emt.load(new File(in3));
		/*
		emt.load(new File(in4));
		emt.load(new File(in5));
		emt.process();
		emt.save(new File(out1),"XML");
		emt.save(new File(out2),"TXT");
		
		*/
	}

}
