package edu.pitt.dbmi.edda.reference;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
		createDirectoryPanel("Input Dicisions File (.csv)",inputDecisions,panel,c);
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
		return frame;
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
					boolean isEndNote = true;
					progress.setIndeterminate(true);
					progress.setString("Reading Input References ..");
					
					List<Reference> includeReferences , excludeReferences;
					/*if(isEndNote){
						includeReferences = Utils.readEndNoteReferences(new File(inputRefrencesInclude.getText()));
						for(Reference r : includeReferences)
							r.setIncluded(true);
						excludeReferences = Utils.readEndNoteReferences(new File(inputReferencesExclude.getText()));
					}else{
						includeReferences = Utils.readMedlineReferences(new File(inputRefrencesInclude.getText()));
						for(Reference r : includeReferences)
							r.setIncluded(true);
						excludeReferences = Utils.readMedlineReferences(new File(inputReferencesExclude.getText()));
					}*/
					
					List<Reference> inputReferences = new ArrayList<Reference>();
					/*inputReferences.addAll(includeReferences);
					inputReferences.addAll(excludeReferences);*/
					
					// now generate a proper output
					File dir = new File(outputDir.getText());
					dir.mkdirs();
					
			
					// create debug files
					
					// go over each reference
					progress.setIndeterminate(false);
					progress.setString("Generating Output ...");
					progress.setMinimum(0);
					progress.setMaximum(inputReferences.size());
					
					for(Reference ref : inputReferences){
						
						progress.setValue(0);
					}
					
					
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
	
	public void showDialog(){
		getDialog().setVisible(true);
	}
	
	public JFrame getDialog(){
		if(frame == null)
			frame = createUI();
		return frame;
	}
	
	public void setProjectDirectory(File projectDirectory) {
		// TODO Auto-generated method stub
		
	}

	
	
	public static void main(String[] args) {
		standAlone = true;
		new ReferenceExporter().showDialog();

	}

	
}
