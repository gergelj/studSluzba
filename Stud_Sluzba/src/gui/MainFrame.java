package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Time;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.Timer;

import javax.swing.Box;
import javax.swing.BoxLayout;
//import javax.swing.Box;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	//labela za vreme i datum
	JLabel mDateTime;
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
		
		mDateTime = new JLabel();
		JPanel statusBar = new JPanel();
		statusBar.setBackground(Color.LIGHT_GRAY);
		//statusBar.setPreferredSize(new Dimension(100,30));
		statusBar.setLayout(new BorderLayout());
		statusBar.add(new JLabel("Studentska služba"), BorderLayout.WEST);
		statusBar.add(mDateTime, BorderLayout.EAST);
		
		add(statusBar,BorderLayout.SOUTH);
		
		//TODO napraviti centralni deo glavnog prozora koji ima 3 taba
		
		this.add(new MojCentralni(),BorderLayout.CENTER);
		
		
		//thread za vreme i datum
		Thread t = new DatumThread(MainFrame.this);
		t.start();
		
	}
}
