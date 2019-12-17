package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AddDialog extends JDialog {

	public static final int ADD_MODE = 1;
	public static final int EDIT_MODE = 2;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7134229283974792783L;

	public AddDialog(Frame parent, int tabSelected, int mode) {
		super(parent, "", true);
		setSize(400, 500);
		setLocationRelativeTo(parent);
		
		switch(tabSelected) {
			case 0: //studenti
			{
				if(mode == AddDialog.ADD_MODE)
					this.setTitle("Add Student");
				else
					this.setTitle("Edit Student");
				this.add(new StudentPanel(mode));
			} break;
			case 1: //profesori
			{
				if(mode == AddDialog.ADD_MODE)
					this.setTitle("Add Professor");
				else
					this.setTitle("Edit Professor");
				this.add(new ProfessorPanel(mode));

			} break;
			case 2: //predmeti
			{
				if(mode == AddDialog.ADD_MODE)
					this.setTitle("Add Subject");
				else
					this.setTitle("Edit Subject");
				this.add(new SubjectPanel(mode));
			}break;
		}
	}
}
