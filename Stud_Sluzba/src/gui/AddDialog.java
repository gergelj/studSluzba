package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AddDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7134229283974792783L;

	public AddDialog(Frame parent, int tabSelected) {
		super(parent, "", true);
		setSize(400, 500);
		setLocationRelativeTo(parent);
		
		switch(tabSelected) {
			case 0: //studenti
			{
				this.setTitle("Add Student");
				this.add(new StudentPanel());
			} break;
			case 1: //profesori
			{
				this.setTitle("Add Professor");
				this.add(new ProfessorPanel());

			} break;
			case 2: //predmeti
			{
				this.setTitle("Add Subject");
				this.add(new SubjectPanel());
			}break;
		}
	}
}
