package gui;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MojToolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6293715549294891243L;
	
	public MojToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		JButton add_btn = new JButton();
		add_btn.setToolTipText("Add");
		add_btn.setIcon(new ImageIcon("images/add-22.png"));
		add(add_btn);
		
		JButton edit_btn = new JButton();
		edit_btn.setToolTipText("Edit");
		edit_btn.setIcon(new ImageIcon("images/edit-22.png"));
		add(edit_btn);
		
		JButton delete_btn = new JButton();
		delete_btn.setToolTipText("Delete");
		delete_btn.setIcon(new ImageIcon("images/trash-22.png"));
		add(delete_btn);
		
		//TODO add search text field
		
		
		add(Box.createHorizontalGlue());
		
		JTextField search_txtF = new JTextField(50);
		search_txtF.setMaximumSize(search_txtF.getPreferredSize());
		search_txtF.setToolTipText("Enter text");
		add(search_txtF);
		
		JButton search_btn = new JButton();
		search_btn.setToolTipText("Search");
		search_btn.setIcon(new ImageIcon("images/search-22.png"));
		add(search_btn);
		
		setFloatable(false);
	}

}
