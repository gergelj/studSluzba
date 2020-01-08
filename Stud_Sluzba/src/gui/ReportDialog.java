package gui;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import klase.Predmet;
import klase.Profesor;
import klase.StringResources;
import klase.Student;

public class ReportDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -366035763581778253L;

	public ReportDialog(int selectedTab) {
		super(MainFrame.getInstance(), "", false);
		setSize(600, 500);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JEditorPane textPane = new JEditorPane();
		textPane.setEditable(false);
		JScrollPane scroll = new JScrollPane(textPane);
		this.add(scroll);
		
		switch(selectedTab) {
		case 0:{
			Student s = null;
			int row = StudentiJTable.getInstance().getSelectedRow();
			if(row != -1)
				s = StudentController.getInstance().nadjiStudenta(row);
			else
				return;
			
			this.setTitle(StringResources.STUDENT_REPORT + " - " + s.getBrojIndeksa());
			textPane.setText(s.getLongReport());
			
		}
			break;
		case 1:{
			this.setTitle(StringResources.PROFESSOR_REPORT);
			
			Profesor p = null;
			int row = ProfesoriJTable.getInstance().getSelectedRow();
			if(row != -1)
				p = ProfesorController.getInstance().nadjiProfesora(row);
			else
				return;
			
			textPane.setText(p.getLongReport());
		}
			break;
		case 2:{
			this.setTitle(StringResources.SUBJECT_REPORT);
			
			Predmet p = null;
			int row = PredmetiJTable.getInstance().getSelectedRow();
			if(row != -1)
				p = PredmetController.getInstance().nadjiPredmet(row);
			else
				return;
			
			textPane.setText(p.getLongReport());
		}
			break;
		}
	}
}
