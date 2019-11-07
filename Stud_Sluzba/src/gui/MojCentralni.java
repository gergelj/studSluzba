package gui;

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
        JComponent stud_tab = makeTextPanel("Students");
        addTab("Students" ,null, stud_tab,"Tab with Students");
        setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent prof_tab = makeTextPanel("Professors");
        addTab("Professors", null, prof_tab, "Tab with Professors");
        setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent subj_tab = makeTextPanel("Subjects");
        addTab("Subjects", null, subj_tab, "Tab with Subjects");
        setMnemonicAt(2, KeyEvent.VK_3);
        
        //sluzi da ukljuci promenu taba pomocu strelica kada je prozor aplikacije previse uzak
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
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
