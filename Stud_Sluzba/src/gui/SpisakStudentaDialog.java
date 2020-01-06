package gui;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.PredmetController;
import klase.Predmet;
import klase.StringResources;
import klase.Student;

public class SpisakStudentaDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 186250787181658443L;

	private JButton cancel_btn, remove_btn;
	private JList<Student> lista;
	private Predmet selectedPredmet;
	
	public SpisakStudentaDialog(int selectedPredmetRow) {
		super(MainFrame.getInstance(), StringResources.SUBJECT_STUDENT_LIST, true);
		setSize(400, 500);
		setLocationRelativeTo(MainFrame.getInstance());

		this.selectedPredmet = PredmetController.getInstance().nadjiPredmet(selectedPredmetRow);

		this.setPanel();
		
		cancel_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		
		remove_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(lista.getModel().getSize() == 0 || lista.getSelectedIndex()==-1 || lista.getSelectedIndex() >= lista.getModel().getSize()) { //ako nije selektovan nijedan student
					return;
				}
				Student s = lista.getSelectedValue();
				if(s!=null) {
					PredmetController.getInstance().unlinkStudentPredmet(s, selectedPredmet);
					//azuriranje prikaza u JList
					AbstractListModelSpisak mod = (AbstractListModelSpisak) lista.getModel();
					mod.azuriraj(lista.getSelectedIndex());
				}
			}
			
		});
		
	}
	
	private void setPanel() {

		cancel_btn = new JButton(StringResources.CANCEL);
		remove_btn = new JButton(StringResources.REMOVE);
		JPanel btns = new JPanel();
		btns.add(cancel_btn);
		btns.add(remove_btn);
		
		this.setLayout(new BorderLayout());
		add(btns, BorderLayout.SOUTH);
		
		ScrollPane scroll = new ScrollPane();
		
		lista = new JList<Student>();
		lista.setModel(new AbstractListModelSpisak(selectedPredmet));
		scroll.add(lista);
		
		add(scroll, BorderLayout.CENTER);

	}
	
	public class AbstractListModelSpisak extends AbstractListModel<Student> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5594587808821419302L;
		
		private List<Student> studenti;
		
		public AbstractListModelSpisak(Predmet p) {
			studenti = new ArrayList<Student>(p.getmListaStudenata().values());
		}
		
		@Override
		public int getSize() {
			return studenti.size();
		}

		@Override
		public Student getElementAt(int index) {
			return studenti.get(index);
		}
		
		public void azuriraj(int index) {
			studenti.remove(index);
			fireContentsChanged(this, 0, studenti.size()-1);
		}

	}
}
