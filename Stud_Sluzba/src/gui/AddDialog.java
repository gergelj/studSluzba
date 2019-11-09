package gui;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class AddDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7134229283974792783L;

	public AddDialog(Frame parent, int tabSelected) {
		super(parent, "", true);
		setSize(250, 250);
		setLocationRelativeTo(parent);
		
		switch(tabSelected) {
			case 0: //studenti
			{
				this.setTitle("Add Student");
				this.add(getStudentPanel());
			} break;
			case 1: //profesori
			{
				this.setTitle("Add Professor");
				this.add(getProfesorPanel());
			} break;
			case 2: //predmeti
			{
				this.setTitle("Add Subject");
				this.add(getPredmetPanel());
			}break;
		}
	}
	
	private JPanel getStudentPanel() {
		JPanel panel = new JPanel();
		//TODO add student panel
		return panel;
	}
	
	private JPanel getPredmetPanel() {
		JPanel panel = new JPanel();
		//TODO add predmet panel
		return panel;
	}
	
	private JPanel getProfesorPanel() {
		JPanel panel = new JPanel();
		//TODO add profesor panel
		return panel;
	}
}
