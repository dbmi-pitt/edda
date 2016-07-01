package edu.pitt.dbmi.edda.reference.token.filter;

import java.awt.Dimension;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class MedlineFilter implements Filter, ActionListener, DropTargetListener {
	private List<String> search = Collections.EMPTY_LIST, replace = Collections.EMPTY_LIST, tag = Collections.EMPTY_LIST;
	private final String MEDLINE_LINE = "([A-Z]{2})\\s+-\\s+(.*)";
	private final Pattern med_line  = Pattern.compile(MEDLINE_LINE);
	private final Pattern end_note_line  = Pattern.compile("([A-Za-z ]+)\\:\\s+(.*)");
	private JPanel panel;
	private JList replaceList;
	
	
	public String getName() {
		return "Tag Filter";
	}
	
	public String toString(){
		return getName();
	}

	public String getDescription() {
		return "Strip RIS Tags if present and optionally modify data in specified RIS sections, by utilising search and replace mechanism.";
	}

	public JComponent getPanel() {
		if(panel == null){
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
			p.add(new JLabel("<html><h2>"+getName()+"</h2><table width=300 bgcolor=\"#FFF380\"><tr><td>"+
			getDescription()+"</td></tr></table></html>"));
			
			JPanel p2 = new JPanel();
			p2.setBorder(new EmptyBorder(5,5,5,5));
			p2.setLayout(new GridBagLayout());
			// init constraints
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(1,1,1,1);
			c.fill = GridBagConstraints.BOTH;
			c.gridy = 0;
			c.gridx = 0;
			c.anchor = GridBagConstraints.CENTER;
			
			replaceList = new JList(new DefaultListModel());
			replaceList.setVisibleRowCount(5);
			replaceList.setDragEnabled(true);
			new DropTarget(replaceList,this);
			replaceList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2){
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								DefaultListModel model = (DefaultListModel) replaceList.getModel();
								Object o = promptUser(replaceList.getSelectedValue());
								if(o != null){
									model.setElementAt(o,replaceList.getSelectedIndex());
									replaceList.validate();
									replaceList.repaint();
								}
							}
						});
						
					}
				}
			});
			JButton ba = new JButton("+");
			ba.addActionListener(this);
			ba.setActionCommand("add");
			JButton br = new JButton("-");
			br.addActionListener(this);
			br.setActionCommand("rem");
			
			p2.add(new JLabel("MedLine Search / Replace "),c); c.gridx++;
			p2.add(ba,c);c.gridx++;
			p2.add(br,c);c.gridx++;
			c.gridx = 0; c.gridy++;c.gridwidth=3;
			p2.add(new JScrollPane(replaceList),c);c.gridy++;

			p.add(p2);		
			panel = p;
		}
		return panel;
	}

	public void setTokenSeparator(String s) {
		tag = new ArrayList<String>();
		search = new ArrayList<String>();
		replace = new ArrayList<String>();
		if(replaceList != null){
			for(int i=0;i<replaceList.getModel().getSize();i++){
				String str = ""+replaceList.getModel().getElementAt(i);
				Matcher mt = Pattern.compile("(.*) / (.*) / (.*) / ").matcher(str);
				if(mt.matches()){
					tag.add(mt.group(1));
					search.add(mt.group(2));
					replace.add(mt.group(3));
				}
			}
		}
	}
	
	private String [] parse(String str){
		Matcher mt = Pattern.compile("(.*) / (.*) / (.*) / ").matcher(str);
		if(mt.matches()){
			String [] r = new String [3];
			r[0] = mt.group(1);
			r[1] = mt.group(2);
			r[2] = mt.group(3);
			return r;
		}
		return null;
	}
	

	public String process(String line) {
		// remove Medline Tag
		Matcher m = med_line.matcher(line);
		if(m.matches()){
			// strip tag
			String tg = m.group(1);
			line = m.group(2);
			// do optional search and replace
			for(int i=0;i<tag.size();i++){
				if(tag.get(i).equals(tg)){
					line = line.replaceAll(search.get(i),replace.get(i));
				}
			}
		}else{
			m = end_note_line.matcher(line);
			if(m.matches()){
				// strip tag
				String tg = m.group(1);
				line = m.group(2);
				// do optional search and replace
				for(int i=0;i<tag.size();i++){
					if(tag.get(i).equals(tg)){
						line = line.replaceAll(search.get(i),replace.get(i));
					}
				}
			}
		}
		return line;
	}

	private String promptUser(Object value){
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EmptyBorder(10,10,10,10)));
		JTextField searchField = new JTextField(20);
		JTextField replaceField = new JTextField(20);
		JTextField medlineTag = new JTextField(20);
		p.add(new JLabel("MedLine Tag"));
		p.add(medlineTag);
		p.add(new JLabel("Search"));
		p.add(searchField);
		p.add(new JLabel("Replace"));
		p.add(replaceField);
		
		// load value
		if(value != null){
			String [] v = parse(value.toString());
			if(v != null){
				medlineTag.setText(v[0]);
				searchField.setText(v[1]);
				replaceField.setText(v[2]);
			}
		}
		
		int r = JOptionPane.showConfirmDialog(panel,p,"Search/Replace",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		if(r == JOptionPane.OK_OPTION){
			return medlineTag.getText()+" / "+searchField.getText()+" / "+replaceField.getText()+" / ";
		}
		
		return null;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("add".equals(cmd)){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					DefaultListModel model = (DefaultListModel) replaceList.getModel();
					Object o = promptUser(null);
					if(o != null){
						model.addElement(o);
						replaceList.validate();
						replaceList.repaint();
					}
				}
			});
		}else if("rem".equals(cmd)){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					DefaultListModel model = (DefaultListModel) replaceList.getModel();
					for(Object o: Arrays.asList(replaceList.getSelectedValues())){
						model.removeElement(o);
					}
					replaceList.validate();
					replaceList.repaint();
				}
			});
		}
	}
	
	public Properties save(){
		Properties p = new Properties();
		if(panel != null){
			for(int i=0;i<replaceList.getModel().getSize();i++){
				String str = ""+replaceList.getModel().getElementAt(i);
				p.setProperty("filter."+getClass().getSimpleName()+"."+(i+1),""+str);
			}
		}
		return p;
	}
	public void load(Properties p){
		if(panel != null){
			final Map<Integer,String> list = new TreeMap<Integer,String>();
			for(Object key : p.keySet()){
				String prop = (String) key;
				if(prop.startsWith("filter."+getClass().getSimpleName())){
					int x = 0;
					try{
						x = Integer.parseInt(prop.substring(("filter."+getClass().getSimpleName()+".").length()));
					}catch(Exception ex){}
					list.put(x,p.getProperty(prop));
				}
			}
			SwingUtilities.invokeLater(new Runnable(){
				public void run() {
					DefaultListModel model = (DefaultListModel) replaceList.getModel();
					model.removeAllElements();
					for(Integer o: list.keySet()){
						model.addElement(list.get(o));
					}
					replaceList.validate();
					replaceList.repaint();
				}
			});
		}
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
        		if(indx > -1){
        			try{
        				String data = ""+dtde.getTransferable().getTransferData(DataFlavor.stringFlavor);
        				// check if it is a concept itself that is being dragged
        				final String source = (String) list.getSelectedValue();
        				if(source != null && source.equals(data)){
        					SwingUtilities.invokeLater(new Runnable(){
        						public void run(){
        							DefaultListModel model = (DefaultListModel) list.getModel();
                					model.removeElement(source);
                					model.insertElementAt(source,indx);
                					list.revalidate();
                					list.repaint();
        						}
        					});
        				}
        			}catch(Exception ex){
        				ex.printStackTrace();
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
}
