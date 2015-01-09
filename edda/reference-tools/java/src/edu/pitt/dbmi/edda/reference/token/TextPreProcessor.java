package edu.pitt.dbmi.edda.reference.token;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.JTextComponent;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;
import edu.pitt.dbmi.edda.reference.token.filter.*;


public class TextPreProcessor implements ListSelectionListener, ActionListener, DropTargetListener {
	private JFrame frame;
	private JTextField inputText,outputField,tokenSeparator,pruneMin;
	private JCheckBox createTopicOutput,pruneTokens;
	private JList availableFilterList,selectedFilterList;
	private JPanel optionPanel,buttonPanel;
	private JProgressBar progress;
	private Map<String,Integer> topicFileId;
	private Map<String,Map<String,Integer>> wordFrequenceTables;
	private Set<String> docWords;
	private boolean wordFrequencesBuilt;
	private String topicModelOutputName = "TopicModelInput.csv";
	private String tokenSep;
	private Map<String,Filter> filterMap;
	private int pruneMn;
	private static File dir;
	
	/**
	 * get list of input folders
	 * @param input
	 * @param files
	 * @return
	 */
	private List<File> getInputFiles(File dir, List<File> files){
		if(dir.isDirectory()){
			for(File f: dir.listFiles()){
				if(f.isDirectory())
					getInputFiles(f,files);
				else if(f.getName().toLowerCase().endsWith(".txt"))
					files.add(f);
			}
		}else{
			JOptionPane.showMessageDialog(frame,"No such directory "+dir.getAbsolutePath(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		return files;
	}
	
	
	private BufferedWriter getTopicWriter(File outputDir,File input, String splitDir) throws Exception{
		// if option is selected AND we have FULL text
		if(createTopicOutput.isSelected() && input.getParentFile().getName().startsWith("FULL")){
			// initialize rapid writer
			File out = new File(outputDir+File.separator+splitDir+File.separator+topicModelOutputName);
			String cat = input.getParentFile().getName().contains("_Y_")?"include":"exclude";
			
			// figure out id
			int id = 1;
			if(topicFileId.containsKey(out.getAbsolutePath())){
				id = topicFileId.get(out.getAbsolutePath())+1;
			}
			topicFileId.put(out.getAbsolutePath(),id);
			
			// write out header
			BufferedWriter writer = new BufferedWriter(new FileWriter(out,id > 1));
			writer.write(id+", "+input.getName()+","+cat+", ");
			return writer;
		}
		return null;
	}
	
	
	/**
	 * do actual work with whatever is in reference list
	 */
	public void process(File inputDirectory, File outputDirectory, File input) throws Exception{
		String suff = input.getAbsolutePath().substring(inputDirectory.getAbsolutePath().length());
		File output = new File(outputDirectory.getAbsoluteFile()+File.separator+suff);
		if(!output.getParentFile().exists())
			output.getParentFile().mkdirs();
		String splitDir = (suff.indexOf(File.separatorChar,1) > -1)?suff.substring(1,suff.indexOf(File.separatorChar,1)):"";
		
		// figure out whether we are in save mode or frequence gathering mode
		boolean save = (wordFrequenceTables == null || wordFrequencesBuilt);
		
		// init writers
		BufferedWriter writer = null, topicWriter = null;;
		if(save){
			topicWriter = getTopicWriter(outputDirectory,input,splitDir);
			writer = new BufferedWriter(new FileWriter(output));
		}else{
			docWords = new HashSet<String>();
		}
		
		// append suffix for splitDir
		/*if(input.getName().indexOf("_") > -1)
			splitDir = splitDir+input.getName().substring(input.getName().lastIndexOf('_'));*/
		if(input.getParentFile().getName().indexOf("_") > -1)
			splitDir = splitDir+input.getParentFile().getName().substring(0,input.getParentFile().getName().indexOf('_'));
		
		// process document
		BufferedReader reader = new BufferedReader(new FileReader(input));
		for(String line = reader.readLine();line != null; line = reader.readLine()){
			String l = tokenizeLine(line,splitDir);
			if(save && l.length() > 0){
				writer.write(l+"\n");
				if(topicWriter != null)
					topicWriter.write(l+tokenSep);
			}
		}
		reader.close();
		
		// save or count
		if(save){
			writer.close();
			if(topicWriter != null){
				topicWriter.write("\n");
				topicWriter.close();
			}
		}else{
			// merge doc wods count with frequence table
			Map<String,Integer> wordFrequenceTable = wordFrequenceTables.get(splitDir);
			if(wordFrequenceTable == null){
				wordFrequenceTable = new HashMap<String, Integer>();
				wordFrequenceTables.put(splitDir,wordFrequenceTable);
			}
			for(String tok: docWords){
				if(wordFrequenceTable.containsKey(tok)){
					wordFrequenceTable.put(tok,wordFrequenceTable.get(tok)+1);
				}else{
					wordFrequenceTable.put(tok,1);
				}
			}
		}
		
	}
	
	
	/**
	 * use varies techniqes to tokenize a line of test
	 * @param line
	 * @return
	 */
	private String tokenizeLine(String line,String splitDir){
		// new filtering
		/*
		Pattern med_line  = Pattern.compile(MEDLINE_LINE);
		
		// remove Medline Tag
		Matcher m = med_line.matcher(line);
		if(m.matches()){
			String tg = m.group(1);
			line = m.group(2);
			// skip source tag
			if("SO".equals(tg))
				line = "";
		}
		
		// consolidate hyphens em and en dashes
		line = line.replaceAll("[\u2013\u2014]","-");
		
		// split numbers seperated by hyphens
		line = line.replaceAll("(\\d+)\\-(\\d+)","\1 \2");
		
		// split into tokens by characters that are NOT kosher
		line = line.replaceAll(TOKEN_PATTERN," ");
		
		// remove angle brackets cause they mess up XML
		line = line.replaceAll("<","_less_then_").replaceAll(">","_greater_then_");
		
		// lower case line
		line = line.toLowerCase();
	
		// filter tokens 
		StringBuffer b = new StringBuffer();
		for(String w: line.split("\\s+")){
			if(w.length() > 1)
				b.append(w+" ");
		}
		line = b.toString().trim();
		*/
		
		// original tokanization
		// split by non letters
		/*
		StringBuffer ln = new StringBuffer();
		for(String word: line.split("[^a-zA-Z]+")){
			// lower case
			word = word.toLowerCase();
			
			// is stop word
			if(stopWords.contains(word))
				word = "";
			
			// filter by size
			if(word.length() < 3)
				word = "";
			
			// porter stem
			word = TextTools.stem(word);
						
			ln.append(word+" ");
		}
		line = ln.toString().replaceAll("\\s+"," ").trim();
		*/
		
		
		// process pipeline
		for(int i=0;i<selectedFilterList.getModel().getSize();i++){
			line = ((Filter)selectedFilterList.getModel().getElementAt(i)).process(line);
		}
		// preocess frequences
		return processFrequences(line,splitDir);
	}
	
	/**
	 * filter words by frequence
	 * @param line
	 * @return
	 */
	private String processFrequences(String line,String splitDir){
		// if we are doing frequencey table
		if(wordFrequenceTables != null){
			StringBuffer b = new StringBuffer();
			// split line into tokens
			for(String token: line.split(tokenSep)){
				// if frequence table is built, then prune
				if(wordFrequencesBuilt){
					if(wordFrequenceTables.get(splitDir).get(token) >= pruneMn)
						b.append(token+tokenSep);
				//else save to add to table
				}else{
					docWords.add(token);
				}
			}
			line = b.toString().trim();
		}
		return line;
	}
	
	
		
	/**
	 * load filters
	 */
	private void loadFilters() {
		DefaultListModel model = (DefaultListModel) availableFilterList.getModel();
		model.addElement(new Tokenizer());
		model.addElement(new StopWordFilter());
		model.addElement(new ChangeCase());
		model.addElement(new SizeFilter());
		model.addElement(new StemmerFilter());
		model.addElement(new SearchReplace());
		model.addElement(new MedlineFilter());
		model.addElement(new POSTagger());

		
		filterMap = new HashMap<String,Filter>();
		for(int i=0;i<model.getSize();i++){
			Filter f = (Filter) model.getElementAt(i);
			filterMap.put(f.getName(),(Filter)model.getElementAt(i));
		}
	}

	
	
	/**
	 * display UI dialog
	 */
	private void showDialog(){
		if(frame == null){
			frame = new JFrame("Text Pre-Processor");
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
			
			inputText = new JTextField(25);
			inputText.setBorder(new LineBorder(Color.gray));
			outputField = new JTextField(25);
			
			createDirectoryPanel("Input (Reference Filer Directory)",inputText,panel,c);
			createDirectoryPanel("Output (Target Directory)",outputField,panel,c);
			
			
			// add options
			JPanel options = new JPanel();
			options.setLayout(new BoxLayout(options,BoxLayout.Y_AXIS));
			//options.setBorder(new TitledBorder("Filters"));
			options.setBorder(new EmptyBorder(10,10,10,10));
			
			
			// add filter panel
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
			
			availableFilterList = new JList(new DefaultListModel());
			availableFilterList.addListSelectionListener(this);
			availableFilterList.setDragEnabled(true);
			new DropTarget(availableFilterList,this);
			JScrollPane s1  = new JScrollPane(availableFilterList);
			s1.setBorder(new TitledBorder("Available Pre Processing Filters"));
			s1.setPreferredSize(new Dimension(250,150));
			
			selectedFilterList = new JList(new DefaultListModel());
			selectedFilterList.addListSelectionListener(this);
			selectedFilterList.setDragEnabled(true);
			new DropTarget(selectedFilterList,this);
			JScrollPane s2  = new JScrollPane(selectedFilterList);
			s2.setBorder(new TitledBorder("Pre Processing Pipeline"));
			s2.setPreferredSize(new Dimension(250,150));
			
			JPanel b = new JPanel();
			b.setLayout(new BoxLayout(b,BoxLayout.Y_AXIS));
			
			JButton add = new JButton(">");
			add.setToolTipText("Add Selected Filters to Pre Processing Pipeline");
			add.addActionListener(this);
			add.setActionCommand("add");
			b.add(add);
			
			JButton rem = new JButton("<");
			add.setToolTipText("Remove Selected Filters from Pre Processing Pipeline");
			rem.addActionListener(this);
			rem.setActionCommand("rem");
			b.add(rem);
			
			
			p.add(s1);
			p.add(b);
			p.add(s2);
				
			optionPanel = new JPanel();
			optionPanel.setLayout(new BorderLayout());
			optionPanel.setPreferredSize(new Dimension(500,150));
			optionPanel.setBorder(new TitledBorder("Filter Properties"));
			
			
			createTopicOutput = new JCheckBox("Save a combined spreadsheet (.csv) file to the output directory");
			tokenSeparator = new JTextField(3);
			tokenSeparator.setHorizontalAlignment(JTextField.CENTER);
			tokenSeparator.setText(" ");
			
			pruneTokens = new JCheckBox("Prune tokens that occur in less then N documents");
			pruneMin = new JTextField(3);
			pruneMin.setHorizontalAlignment(JTextField.CENTER);
			pruneMin.setDocument(new Utils.IntegerDocument(0));
			
			JPanel pn = new JPanel();
			pn.setBorder(new EmptyBorder(0,15,0,0));
			pn.setLayout(new FlowLayout(FlowLayout.LEFT));
			pn.add(new JLabel("Token separator character (default is space character) "),BorderLayout.WEST);
			pn.add(tokenSeparator,BorderLayout.EAST);
			
			JPanel pp = new JPanel();
			pp.setLayout(new FlowLayout(FlowLayout.LEFT));
			pp.setBorder(new EmptyBorder(0,-5,0,0));
			pp.add(pruneTokens,BorderLayout.WEST);
			pp.add(pruneMin,BorderLayout.EAST);
			
			options.add(p);
			options.add(optionPanel);
			options.add(createTopicOutput);
			//options.add(pp);
			options.add(pn);
			
			for(int i=0;i<options.getComponentCount();i++)
				((JComponent)options.getComponent(i)).setAlignmentX(JComponent.LEFT_ALIGNMENT);
			
			c.gridwidth = 3;
			panel.add(options,c);
			
			progress = new JProgressBar();
			progress.setStringPainted(true);
			progress.setMinimum(0);
			
			JButton bt = new JButton("Run Text Pre Processor");
			bt.addActionListener(this);
			bt.setActionCommand("run");
			
			JButton load = new JButton("Load");
			load.addActionListener(this);
			load.setActionCommand("load");
			JButton save = new JButton("Save");
			save.addActionListener(this);
			save.setActionCommand("save");
			
			JPanel bp = new JPanel();
			bp.setLayout(new BorderLayout());
			bp.setBorder(new EmptyBorder(0,30,0,30));
			bp.add(bt,BorderLayout.CENTER);
			
			buttonPanel = new JPanel();
			buttonPanel.setLayout(new BorderLayout());
			buttonPanel.setBorder(new EmptyBorder(10,20,10,20));
			buttonPanel.add(load,BorderLayout.WEST);
			buttonPanel.add(bp,BorderLayout.CENTER);
			buttonPanel.add(save,BorderLayout.EAST);
			
			loadFilters();
			
			frame.getContentPane().add(panel,BorderLayout.CENTER);
			frame.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
			frame.pack();
			
			
		
		}
		frame.setVisible(true);
	}
	
	public void valueChanged(ListSelectionEvent e) {
		final JList list = (JList) e.getSource();
		if(!e.getValueIsAdjusting()){
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					Object o = list.getSelectedValue();
					if(o instanceof Filter){
						optionPanel.removeAll();
						optionPanel.add(((Filter)o).getPanel());
						optionPanel.revalidate();
						optionPanel.repaint();
					}
				}
			});
		}
	}
	
	private void doAdd(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				for(Object o: Arrays.asList(availableFilterList.getSelectedValues())){
					((DefaultListModel)selectedFilterList.getModel()).addElement(o);
					((DefaultListModel)availableFilterList.getModel()).removeElement(o);
					selectedFilterList.revalidate();
					availableFilterList.revalidate();
					optionPanel.removeAll();
					optionPanel.revalidate();
					optionPanel.repaint();
				}
			}
		});
	}
	
	private void doRem(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				for(Object o: Arrays.asList(selectedFilterList.getSelectedValues())){
					((DefaultListModel)selectedFilterList.getModel()).removeElement(o);
					((DefaultListModel)availableFilterList.getModel()).addElement(o);
					selectedFilterList.revalidate();
					availableFilterList.revalidate();
					optionPanel.removeAll();
					optionPanel.revalidate();
					optionPanel.repaint();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("add".equals(cmd)){
			doAdd();
		}else if("rem".equals(cmd)){
			doRem();
		}else if("run".equals(cmd)){
			doRun();
		}else if("save".equals(cmd)){
			doSave();
		}else if("load".equals(cmd)){
			doLoad();
		}
	}
	
	

	private void doLoad() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setFileFilter(new FileFilter() {
			public String getDescription() {
				return "Parameter File (.parameters)";
			}
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().endsWith(".parameters");
			}
		});
		chooser.setMultiSelectionEnabled(false);
		int r = chooser.showOpenDialog(JOptionPane.getFrameForComponent(frame));
		if(JFileChooser.APPROVE_OPTION == r){
			try {
				load(chooser.getSelectedFile());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Could not load file: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
		}
	}


	private void load(File f) throws Exception {
		final Properties props = new Properties();
		
		// load from file
		FileInputStream is = new FileInputStream(f);
		props.load(is);
		is.close();
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				inputText.setText(props.getProperty("input.text",""));
				outputField.setText(props.getProperty("output.text",""));
				//pruneMin.setText(props.getProperty("prune.text",""));
				tokenSeparator.setText(props.getProperty("separator.text",""));
				//pruneTokens.setSelected(Boolean.parseBoolean(props.getProperty("prune.tokens","false")));
				createTopicOutput.setSelected(Boolean.parseBoolean(props.getProperty("topic.model.output","false")));
				
				for(Filter filter: filterMap.values()){
					filter.getPanel();
					filter.load(props);
				}
				
				((DefaultListModel)selectedFilterList.getModel()).removeAllElements();
				String selectedFilters = props.getProperty("selected.filters","");
				for(String ft : selectedFilters.split(",")){
					ft = ft.trim();
					if(ft.length() > 0){
						((DefaultListModel)selectedFilterList.getModel()).addElement(filterMap.get(ft));
						((DefaultListModel)availableFilterList.getModel()).removeElement(filterMap.get(ft));
					}
				}
				selectedFilterList.validate();
				selectedFilterList.repaint();
			}
		});
		
	}


	private void doSave() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setFileFilter(new FileFilter() {
			public String getDescription() {
				return "Parameter File (.parameters)";
			}
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().endsWith(".parameters");
			}
		});
		int r = chooser.showSaveDialog(JOptionPane.getFrameForComponent(frame));
		if(JFileChooser.APPROVE_OPTION == r){
			try {
				save(chooser.getSelectedFile());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Could not save file: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
		}
		
	}


	private void save(File f) throws Exception{
		Properties props = new Properties();
		props.setProperty("input.text",inputText.getText());
		props.setProperty("output.text",outputField.getText());
		//props.setProperty("prune.text",pruneMin.getText());
		props.setProperty("separator.text",tokenSeparator.getText());
		//props.setProperty("prune.tokens",""+pruneTokens.isSelected());
		props.setProperty("topic.model.output",""+createTopicOutput.isSelected());

		for(Filter filter: filterMap.values()){
			props.putAll(filter.save());
		}
		
		StringBuffer selected=new StringBuffer();
		for(int i=0;i<selectedFilterList.getModel().getSize();i++)
			selected.append(selectedFilterList.getModel().getElementAt(i)+", ");
		props.setProperty("selected.filters",selected.toString());
		
		
		// save
		if(!f.getName().endsWith(".parameters"))
			f = new File(f.getAbsolutePath()+".parameters");
		
		FileOutputStream os = new FileOutputStream(f);
		props.store(os,"Text PreProcessor Parameter Set on "+(new Date()));
		os.close();
	}


	/**
	 * do the actual split
	 */
	private void doRun(){
		// place progress bar
		frame.getContentPane().remove(buttonPanel);
		frame.getContentPane().add(progress,BorderLayout.SOUTH);
		frame.getContentPane().validate();
		
		(new Thread(new Runnable(){
			public void run(){
				try{
					//load inputs
					File inputDir = new File(inputText.getText());
					File outputDir = new File(outputField.getText());
					if(!outputDir.exists())
						outputDir.mkdirs();
					final List<File> inputFiles = getInputFiles(inputDir,new ArrayList<File>());
					if(inputFiles.isEmpty())
						return;
					
					// reset token character
					tokenSep = tokenSeparator.getText();
					for(int i=0;i<selectedFilterList.getModel().getSize();i++){
						((Filter)selectedFilterList.getModel().getElementAt(i)).setTokenSeparator(tokenSep);
					}
					
					// init frequence table
					if(pruneTokens.isSelected() && pruneMin.getText().length() > 0){
						wordFrequenceTables = new HashMap<String,Map<String, Integer>>();
						pruneMn = Integer.parseInt(pruneMin.getText());
						wordFrequencesBuilt = false;
					}else
						wordFrequenceTables = null;
					
					// init id table
					topicFileId = new HashMap<String, Integer>();
					
					// do a two pass thing
					for(int h=0;h<((wordFrequenceTables != null)?2:1);h++){
						SwingUtilities.invokeLater(new Runnable(){
							public void run(){
								progress.setString("Processing Input References ..");
								progress.setMinimum(0);
								progress.setValue(0);
								progress.setMaximum(inputFiles.size());
								progress.setIndeterminate(false);
							}
						});
						
						// process
						for(int i=0;i<inputFiles.size();i++){
							process(inputDir,outputDir,inputFiles.get(i));
							final int st = i;
							SwingUtilities.invokeLater(new Runnable(){
								public void run(){
									progress.setValue(st+1);
								}
							});
						}
						wordFrequencesBuilt = true;
					}
					
					// save parameters
					save(new File(outputDir,"tokanization.parameters"));
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(frame,"Encountered a problem "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						frame.getContentPane().remove(progress);
						frame.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
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
			p.add(createBrowseButton(textField),c);
		}
		c.gridx = 0;
		c.gridy++;
	}
	
	public static JButton createBrowseButton(JTextComponent text){
		final JTextComponent textField = text;
		JButton bt = new JButton("Browse");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(dir);
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setMultiSelectionEnabled(true);
				int r = chooser.showOpenDialog(JOptionPane.getFrameForComponent(textField));
				if(JFileChooser.APPROVE_OPTION == r){
					for(File f : chooser.getSelectedFiles()){
						if(textField instanceof JTextArea){
							String nm = "";
							if(textField.getText().length() > 0)
								nm = textField.getText()+"\n";
							
							textField.setText(nm+f.getAbsolutePath());
						}else	
							textField.setText(f.getAbsolutePath());
						dir = f.getParentFile();
					}
				}
			}
		});
		return bt;
	}
	
	/**
	 * drag-n-drop support, this is when drop occures
	 * @param dtde
	 */
	public void drop(DropTargetDropEvent dtde){
      	Point loc = dtde.getLocation();
        if(dtde.getSource() instanceof DropTarget){
        	DropTarget droptarget = (DropTarget) dtde.getSource();
        	if(droptarget.getComponent() instanceof JList){
        		final JList list = (JList) droptarget.getComponent();
        		final int indx = list.locationToIndex(loc);
        		boolean organize = false;
        		if(indx > -1){
        			try{
        				String data = ""+dtde.getTransferable().getTransferData(DataFlavor.stringFlavor);
        				// check if it is a concept itself that is being dragged
        				final Filter source = (Filter) list.getSelectedValue();
        				if(source != null && source.getName().equals(data)){
        					SwingUtilities.invokeLater(new Runnable(){
        						public void run(){
        							DefaultListModel model = (DefaultListModel) list.getModel();
                					model.removeElement(source);
                					model.insertElementAt(source,indx);
                					list.revalidate();
                					list.repaint();
        						}
        					});
        					
        					organize = true;
        				}
        			}catch(Exception ex){
        				ex.printStackTrace();
        			}
        		}
        		if(!organize){
	        		if(list == availableFilterList){
	    				doRem();
	    			}else if(list == selectedFilterList){
	    				doAdd();
	    			}
        		}
        	}
        }
    }
	// don't need those methods for now
    public void dragEnter(DropTargetDragEvent dtde) {}
    public void dragExit(DropTargetEvent dte) {}
    public void dragOver(DropTargetDragEvent dtde) {}
    public void dropActionChanged(DropTargetDragEvent dtde) {}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextPreProcessor emt = new TextPreProcessor();
		emt.showDialog();

	}

}
