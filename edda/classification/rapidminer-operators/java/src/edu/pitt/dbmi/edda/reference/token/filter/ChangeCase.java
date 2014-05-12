package edu.pitt.dbmi.edda.reference.token.filter;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;



public class ChangeCase implements Filter {
	private JComboBox selectCase;
	private JPanel panel;
	
	public String getName() {
		return "Change Character Case";
	}

	public String toString(){
		return getName();
	}
	
	public String getDescription() {
		return "Converts case of all characters to either <b>upper case</b> or <b>lower case</b> (default).";
	}

	public JComponent getPanel() {
		if(panel  == null){
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
			p.add(new JLabel("<html><h2>"+getName()+"</h2><table width=300 bgcolor=\"#FFF380\"><tr><td>"+
			getDescription()+"</td></tr></table></html>"));
			
			JPanel p2 = new JPanel();
			//p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
			p2.setBorder(new EmptyBorder(5,5,5,5));
			p2.setLayout(new GridBagLayout());
			// init constraints
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(5,5,5,5);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridy = 0;
			c.gridx = 0;
			c.anchor = GridBagConstraints.NORTH;
			
			
			selectCase = new JComboBox(new String [] {"lowercase","UPPERCASE"});
			//selectCase.setMaximumSize(new Dimension(500,20));
			p2.add(new JLabel("Select Case"),c);c.gridy++;
			p2.add(selectCase,c);
			p.add(p2);
			panel = p;
		}
		return panel;
	}
	
	public Properties save(){
		Properties p = new Properties();
		if(panel != null)
			p.setProperty("filter."+getClass().getSimpleName(),""+selectCase.getSelectedItem());
		return p;
	}
	public void load(Properties p){
		String val = p.getProperty("filter."+getClass().getSimpleName());
		if(panel != null && val != null){
			selectCase.setSelectedItem(val);
		}
	}
	
	public void setTokenSeparator(String s) {}

	public String process(String str) {
		if(selectCase != null && selectCase.getSelectedIndex() == 1)
			return str.toUpperCase();
		return str.toLowerCase();
	}

}
