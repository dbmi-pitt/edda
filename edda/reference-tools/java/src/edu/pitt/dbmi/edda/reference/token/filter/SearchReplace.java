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

public class SearchReplace implements Filter, ActionListener, DropTargetListener {
	private List<String> search = Collections.EMPTY_LIST, replace = Collections.EMPTY_LIST;
	private JPanel panel;
	private JList replaceList;
	
	public String getName() {
		return "Search and Replace";
	}
	
	public String toString(){
		return getName();
	}

	public String getDescription() {
		return "Search for occurences of a specified regular expression and replace it with specified string. " +
				"Replacing something with an empty string, deletes it. You can also use back references to " +
				"match groups. Ex: /(\\d)-(\\d)/\\1 \\2/";
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
			replaceList.setDragEnabled(true);
			new DropTarget(replaceList,this);
			JButton ba = new JButton("+");
			ba.addActionListener(this);
			ba.setActionCommand("add");
			JButton br = new JButton("-");
			br.addActionListener(this);
			br.setActionCommand("rem");
			
			p2.add(new JLabel("Search / Replace "),c); c.gridx++;
			p2.add(Box.createRigidArea(new Dimension(50,20)),c);c.gridx++;
			p2.add(ba,c);c.gridx++;
			p2.add(br,c);c.gridx++;
			c.gridx = 0; c.gridy++;c.gridwidth=4;
			JScrollPane s = new JScrollPane(replaceList);
			s.setMinimumSize(new Dimension(200,100));
			p2.add(s,c);c.gridy++;

			p.add(p2);		
			panel = p;
		}
		return panel;
	}

	public void setTokenSeparator(String s) {
		search = new ArrayList<String>();
		replace = new ArrayList<String>();
		if(replaceList != null){
			for(int i=0;i<replaceList.getModel().getSize();i++){
				String str = ""+replaceList.getModel().getElementAt(i);
				Matcher mt = Pattern.compile(" / (.*) / (.*) / ").matcher(str);
				if(mt.matches()){
					search.add(mt.group(1));
					replace.add(mt.group(2));
				}
			}
		}
	}
	
	private String [] parse(String str){
		Matcher mt = Pattern.compile(" / (.*) / (.*) / ").matcher(str);
		if(mt.matches()){
			String [] r = new String [2];
			r[0] = mt.group(1);
			r[1] = mt.group(2);
			return r;
		}
		return null;
	}

	public String process(String str) {
		for(int i=0;i<search.size();i++){
			str = str.replaceAll(search.get(i),replace.get(i));
		}
		return str;
	}

	private String promptUser(Object value){
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EmptyBorder(10,10,10,10)));
		JTextField searchField = new JTextField(20);
		JTextField replaceField = new JTextField(20);
		p.add(new JLabel("Search"));
		p.add(searchField);
		p.add(new JLabel("Replace"));
		p.add(replaceField);
		
		// load value
		if(value != null){
			String [] v = parse(value.toString());
			if(v != null){
				searchField.setText(v[0]);
				replaceField.setText(v[1]);
			}
		}
		
		int r = JOptionPane.showConfirmDialog(panel,p,"Search/Replace",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		if(r == JOptionPane.OK_OPTION){
			return " / "+searchField.getText()+" / "+replaceField.getText()+" / ";
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
