package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MojCentralni extends JTabbedPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MojCentralni()
	{	
		
		JTabbedPane tabs = new JTabbedPane();
        
        JComponent stud_tab = makeTextPanel("Students");
        tabs.addTab("Students" ,null, stud_tab,"Tab with Students");
        tabs.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent prof_tab = makeTextPanel("Professors");
        tabs.addTab("Professors", null, prof_tab, "Tab with Professors");
        tabs.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent subj_tab = makeTextPanel("Subjects");
        tabs.addTab("Subjects", null, subj_tab, "Tab with Subjects");
        tabs.setMnemonicAt(2, KeyEvent.VK_3);
        
        tabs.setBackground(Color.LIGHT_GRAY);
        
        add(tabs);
        
        //sluzi da ukljuci promenu taba pomocu strelica kada je prozor aplikacije previse uzak
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
