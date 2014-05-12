package edu.pitt.dbmi.edda.reference.token.filter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.pitt.dbmi.edda.reference.filer.model.Utils;
import edu.pitt.text.tools.TextTools;

public class SizeFilter implements Filter {
	private String s = " ";
	private JPanel panel;
	private JTextField minSize, maxSize;
	private int min = 3, max = 100;
	
	public String getName() {
		return "Token Size Filter";
	}

	public String getDescription() {
		return "Filter based on token size. Allow tokens that are greater or equal then minimum and less or equal then maximum.";
	}
	
	public String toString(){
		return getName();
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
			c.fill = GridBagConstraints.NONE;
			c.gridy = 0;
			c.gridx = 0;
			c.anchor = GridBagConstraints.WEST;
			
			minSize = new JTextField(5);
			minSize.setHorizontalAlignment(JTextField.CENTER);
			minSize.setDocument(new Utils.IntegerDocument(0));
			minSize.setText(""+min);
			maxSize = new JTextField(5);
			maxSize.setHorizontalAlignment(JTextField.CENTER);
			maxSize.setDocument(new Utils.IntegerDocument(0));
			maxSize.setText(""+max);
			
			p2.add(new JLabel("Minimum Token Size"),c);c.gridx++;
			p2.add(minSize,c);c.gridy++;c.gridx = 0;
			p2.add(new JLabel("Maximum Token Size"),c);c.gridx++;
			p2.add(maxSize,c);c.gridy++;c.gridx = 0;
			p.add(p2);
			panel = p;
		}
		return panel;
	}

	public void setTokenSeparator(String s) {
		this.s = s;
		if(panel != null){
			min = Integer.parseInt(minSize.getText());
			max = Integer.parseInt(maxSize.getText());
		}
	}

	public String process(String line) {
		StringBuffer ln = new StringBuffer();
		for(String word: line.split(s)){
			String sword = clean(word);
			if(sword.length() >= min && sword.length() <= max)
				ln.append(word+s);
		}
		return ln.toString();
	}
	
	private String clean(String word){
		if(word.contains("|")){
			return word.substring(0,word.indexOf('|'));
		}	
		return word;
	}
	
	public Properties save(){
		Properties p = new Properties();
		if(panel != null){
			p.setProperty("filter."+getClass().getSimpleName()+".min",""+minSize.getText());
			p.setProperty("filter."+getClass().getSimpleName()+".max",""+maxSize.getText());
		}
		return p;
	}
	public void load(Properties p){
		if(panel != null){
			String val = p.getProperty("filter."+getClass().getSimpleName()+".min");
			if(val != null)
				minSize.setText(val);
			val = p.getProperty("filter."+getClass().getSimpleName()+".max");
			if(val != null)
				maxSize.setText(val);
			
		}
	}

}
