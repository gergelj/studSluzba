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
import klase.Predmet;
import klase.Student;

public class SpisakStudentaDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 186250787181658443L;

	private JButton cancel_btn, remove_btn;
	private JList<Student> lista;
	private Predmet selectedPredmet;
	
	public class AbstractListModelSpisak extends AbstractListModel<Student> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5594587808821419302L;
		
		private List<Student> studenti;
		private Predmet p;
		
		public AbstractListModelSpisak(Predmet p) {
			this.p = p;
			this.studenti = PredmetController.getInstance().getListOfStudents(p);
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
	
	public SpisakStudentaDialog(int selectedPredmetRow) {
		super(MainFrame.getInstance(), "Remove Student from Subject", true);
		setSize(400, 500);
		setLocationRelativeTo(MainFrame.getInstance());

		this.selectedPredmet = PredmetController.getInstance().nadjiPredmet(selectedPredmetRow);
		this.setTitle("Remove Student from " + this.selectedPredmet.getmNazivPredmeta());
		add(addPanel());
		
		cancel_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO zatvoriti dijalog
				
			}
			
		});
		
		remove_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = lista.getSelectedValue();
				if(s!=null) {
					Predmet p = PredmetController.getInstance().nadjiPredmet(selectedPredmetRow);
					PredmetController.getInstance().unlinkStudentPredmet(s, p);
				}
				
				//TODO: refreshovati JList komponentu (ili zatvoriti dijalog) IPAK ZATVORITI DIJALOG
				
			}
			
		});
		
	}
	
	private JPanel addPanel() {
		JPanel ret = new JPanel();
		cancel_btn = new JButton("Cancel");
		remove_btn = new JButton("Remove");
		JPanel btns = new JPanel();
		btns.add(cancel_btn);
		btns.add(remove_btn);
		
		ret.add(btns, BorderLayout.SOUTH);
		
		ScrollPane scroll = new ScrollPane();
		scroll.setPreferredSize(new Dimension(400,400));
		
		lista = new JList<Student>();
		lista.setModel(new AbstractListModelSpisak(selectedPredmet));
		scroll.add(lista);
		
		ret.add(scroll, BorderLayout.NORTH);
		return ret;
	}
}