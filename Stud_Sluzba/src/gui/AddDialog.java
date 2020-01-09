package gui;


import java.awt.Frame;
import javax.swing.JDialog;

import klase.StringResources;

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
		
		this.setResizable(false);
		
		switch(tabSelected) {
			case 0: //studenti
			{
				if(mode == AddDialog.ADD_MODE)
					this.setTitle(StringResources.ADD_STUDENT);
				else
					this.setTitle(StringResources.EDIT_STUDENT);
				this.add(new StudentPanel(mode, this));
			} break;
			case 1: //profesori
			{
				if(mode == AddDialog.ADD_MODE)
					this.setTitle(StringResources.ADD_PROFESSOR);
				else
					this.setTitle(StringResources.EDIT_PROFESSOR);
				this.add(new ProfessorPanel(mode, this));

			} break;
			case 2: //predmeti
			{
				if(mode == AddDialog.ADD_MODE)
					this.setTitle(StringResources.ADD_SUBJECT);
				else
					this.setTitle(StringResources.EDIT_SUBJECT);
				this.add(new SubjectPanel(mode, this));
			}break;
		}
	}
}
