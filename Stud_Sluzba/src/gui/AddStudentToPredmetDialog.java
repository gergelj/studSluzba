package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.PredmetController;
import controller.StudentController;
import klase.Predmet;
import klase.Student;

public class AddStudentToPredmetDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 186250787181658443L;

	private JButton cancel_btn, add_btn;
	private JList<Student> lista;
	private Predmet selectedPredmet;
	
	public class AbstractListModelStudenti extends AbstractListModel<Student> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5594587808821419302L;
		
		private List<Student> studenti;
		
		public AbstractListModelStudenti() {
			this.studenti = StudentController.getInstance().getStudenti();
		}
		
		@Override
		public int getSize() {
			return this.studenti.size();
		}

		@Override
		public Student getElementAt(int index) {
			return this.studenti.get(index);
		}

	}
	
	public AddStudentToPredmetDialog(int selectedPredmetRow) {
		super(MainFrame.getInstance(), "Add Student to Subject", true);
		setSize(400, 500);
		setLocationRelativeTo(MainFrame.getInstance());
		this.selectedPredmet = PredmetController.getInstance().nadjiPredmet(selectedPredmetRow);
		this.setTitle("Add Student to " + this.selectedPredmet.getmNazivPredmeta());
		add(addPanel());
		
		cancel_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO zatvoriti dijalog
				
			}
			
		});
		
		add_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = lista.getSelectedValue();
				Predmet p = selectedPredmet;
				
				if(s.getTrenutnaGodina()!=p.getmGodinaIzvodjenja()) {
					//TODO:
					System.out.println("Nisu ista godina");
				}
				else {
					PredmetController.getInstance().linkStudentPredmet(s, p);
					System.out.println("Dodao sam studenta na predmet");
				}
				
			}
			
		});
		
	}
	
	private JPanel addPanel() {
		JPanel ret = new JPanel();
		cancel_btn = new JButton("Cancel");
		add_btn = new JButton("Add");
		JPanel btns = new JPanel();
		btns.add(cancel_btn);
		btns.add(add_btn);
		
		ret.add(btns, BorderLayout.SOUTH);
		
		ScrollPane scroll = new ScrollPane();
		scroll.setPreferredSize(new Dimension(400,400));
		
		lista = new JList<Student>();
		lista.setModel(new AbstractListModelStudenti());
		scroll.add(lista);
		
		ret.add(scroll, BorderLayout.NORTH);
		return ret;
	}
}
