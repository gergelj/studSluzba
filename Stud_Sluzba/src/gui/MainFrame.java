package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
		
	}
}
