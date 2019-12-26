package gui;

import javax.swing.JDialog;

import klase.StringResources;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6243786012852231728L;
	
	public HelpDialog() {
		super(MainFrame.getInstance(), StringResources.APPLICATION_NAME + " v " + StringResources.VERSION, false);
		setSize(400, 500);
		setLocationRelativeTo(MainFrame.getInstance());
	}

}
