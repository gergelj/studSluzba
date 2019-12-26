package gui;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.StudentController;
import klase.Predmet;
import klase.StringResources;
import klase.Student;

public class SpisakPredmetaStudentaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030735362088938614L;

	private JList<Predmet> lista;
	private Student selectedStudent;
	
	public class AbstractListModelSpisak extends AbstractListModel<Predmet>
	{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 392969592275746323L;
		
		private List<Predmet> predmeti;
		
		
		public AbstractListModelSpisak(Student s) {
			this.predmeti = StudentController.getInstance().getListOfSubjects(s);
		}
		
		@Override
		public Predmet getElementAt(int arg0) {
			return this.predmeti.get(arg0);
		}

		@Override
		public int getSize() {
			return this.predmeti.size();
		}
		
		public void azuriraj(int index)
		{
			predmeti.remove(index);
			fireContentsChanged(this, 0, predmeti.size()-1);
		}
	}
	
	public SpisakPredmetaStudentaDialog(int selectedStudentRow)
	{
		super(MainFrame.getInstance(),StringResources.STUDENT_SUBJECT_LIST,true);
		setSize(400,500);
		setLocationRelativeTo(MainFrame.getInstance());
		
		this.selectedStudent = StudentController.getInstance().nadjiStudenta(selectedStudentRow);
		add(addPanel());
	}
	
	private JPanel addPanel()
	{
		JPanel ret = new JPanel();
		
		ScrollPane scroll = new ScrollPane();
		scroll.setPreferredSize(new Dimension(400,400));
		
		lista = new JList<Predmet>();
		lista.setModel(new AbstractListModelSpisak(selectedStudent));
		scroll.add(lista);
		
		ret.add(scroll);
		return ret;
	}
	
}
