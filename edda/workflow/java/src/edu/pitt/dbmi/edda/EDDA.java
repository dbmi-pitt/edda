package edu.pitt.dbmi.edda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import edu.pitt.dbmi.edda.reference.ReferenceExporter;
import edu.pitt.dbmi.edda.reference.filer.ReferenceFiler;
import edu.pitt.dbmi.edda.reference.token.TextPreProcessor;

/**
 * This is the main application that tries to link multiple components
 * @author tseytlin
 *
 */
public class EDDA implements ActionListener {
	private static EDDA instance;
	private JFrame frame;
	private ReferenceFiler referenceFiler;
	private ReferenceExporter referenceExporter;
	private TextPreProcessor textPreProcessor;
	private JLabel name, status;
	private File projectDirectory;
	
	private EDDA(){}
	
	
	
	/**
	 * create and return main application window
	 * @return
	 */
	private JFrame getApplicationWindow() {
		if(frame == null){
			frame = new JFrame("EDDA");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setJMenuBar(createMenuBar());
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(-1,1,5,5));
			panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EmptyBorder(10, 10, 10, 10)));
			
			JButton bt = new JButton("Import References..");
			bt.addActionListener(this);
			bt.setActionCommand("import");
			panel.add(bt);
			
			bt = new JButton("Reference Statistics..");
			bt.addActionListener(this);
			bt.setActionCommand("stats");
			panel.add(bt);
			
			bt = new JButton("Tokenize References..");
			bt.addActionListener(this);
			bt.setActionCommand("tokenize");
			panel.add(bt);
			
			bt = new JButton("PICO+ Viewer ..");
			bt.addActionListener(this);
			bt.setActionCommand("pico");
			//panel.add(bt);
			
			bt = new JButton("Cluster References..");
			bt.addActionListener(this);
			bt.setActionCommand("cluster");
			//panel.add(bt);
			
			bt = new JButton("Export References..");
			bt.addActionListener(this);
			bt.setActionCommand("export");
			panel.add(bt);
			
			name = new JLabel(" ");
			name.setFont(name.getFont().deriveFont(Font.BOLD,20));
			name.setHorizontalTextPosition(JTextField.CENTER);
			name.setForeground(new Color(0,128,0));
			
			status = new JLabel(" ");
			
			
			
			JPanel main = new JPanel();
			main.setLayout(new BorderLayout());
			main.add(name,BorderLayout.NORTH);
			main.add(panel,BorderLayout.CENTER);
			main.add(status, BorderLayout.SOUTH);
			
			frame.setContentPane(main);
			frame.pack();
			
		}
		return frame;
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		
		JMenuItem open = new JMenuItem("Open Project");
		open.setActionCommand("open");
		open.addActionListener(this);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setActionCommand("exit");
		exit.addActionListener(this);
		
		
		file.add(open);
		file.addSeparator();
		file.add(exit);
		menubar.add(file);
		return menubar;
	}



	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("import".equals(cmd)){
			if(referenceFiler == null)
				referenceFiler = new ReferenceFiler();
			referenceFiler.showDialog();
			referenceFiler.setProjectDirectory(getProjectDirectory());
		}else if("export".equals(cmd)){
			if(referenceExporter == null)
				referenceExporter = new ReferenceExporter();
			referenceExporter.showDialog();
			referenceExporter.setProjectDirectory(getProjectDirectory());
		}else if("tokenize".equals(cmd)){
			if(textPreProcessor == null)
				textPreProcessor = new TextPreProcessor();
			textPreProcessor.showDialog();
			textPreProcessor.setProjectDirectory(getProjectDirectory());
		}else if("pico".equals(cmd)){
			
		}else if("cluster".equals(cmd)){
			
		}else if("exit".equals(cmd)){
			System.exit(0);
		}else if("open".equals(cmd)){
			doOpenProject();
		}
		
	}
	
	private void doOpenProject() {
		JFileChooser chooser = new JFileChooser(projectDirectory);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int r = chooser.showOpenDialog(frame);
		if(JFileChooser.APPROVE_OPTION == r){
			setProjectDirectory(chooser.getSelectedFile());
		}
	}



	public File getProjectDirectory() {
		return projectDirectory;
	}



	public void setProjectDirectory(File projectDirectory) {
		this.projectDirectory = projectDirectory;
		
		name.setText(projectDirectory.getName());
		status.setText(projectDirectory.getAbsolutePath());
		status.setToolTipText(status.getText());
		
		setupProjectDirectory(projectDirectory);
	}

	private void setupProjectDirectory(File dir){
		if(!dir.exists())
			dir.mkdirs();
	}
	
	

	public static EDDA getInstance(){
		if(instance == null)
			instance = new EDDA();
		return instance;
	}
	public static void main(String[] args) {
		EDDA.getInstance().getApplicationWindow().setVisible(true);
	}



	
}
