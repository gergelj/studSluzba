package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Timer;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8026416994513756565L;

	public MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth*3 / 4, screenHeight*3 / 4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.setJMenuBar(new MojMenuBar());
		this.add(new MojToolbar(), BorderLayout.NORTH);
		
		//TODO napraviti status bar u kom pise Studentska sluzba i datum i trenutno vreme
		
		
		
		JPanel statusBar = new JPanel();
		statusBar.setBackground(Color.LIGHT_GRAY);
		statusBar.setPreferredSize(new Dimension(100,30));
		statusBar.add(new JLabel("Studentska služba"));
		statusBar.add(new JLabel(new SimpleDateFormat("dd.MM.yyyy. hh:mm:ss").format(new GregorianCalendar().getTime())));
		add(statusBar,BorderLayout.SOUTH);
	}
}
