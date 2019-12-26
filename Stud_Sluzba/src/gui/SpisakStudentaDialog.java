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
	
	public class AbstractListModelSpisak extends AbstractListModel<Student> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5594587808821419302L;
		
		private List<Student> studenti;
		
		public AbstractListModelSpisak(Predmet p) {
			studenti = PredmetController.getInstance().getListOfStudentsOnSubject(p);
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
	
	public SpisakStudentaDialog(int selectedPredmetRow) {
		super(MainFrame.getInstance(), StringResources.SUBJECT_STUDENT_LIST, true);
		setSize(400, 500);
		setLocationRelativeTo(MainFrame.getInstance());

		this.selectedPredmet = PredmetController.getInstance().nadjiPredmet(selectedPredmetRow);
		add(addPanel());
		
		cancel_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		
		remove_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(lista.getModel().getSize() == 0 || lista.getSelectedIndex()==-1 || lista.getSelectedIndex() >= lista.getModel().getSize()) {
					return;
				}
				Student s = lista.getSelectedValue();
				if(s!=null) {
					Predmet p = PredmetController.getInstance().nadjiPredmet(selectedPredmetRow);
					PredmetController.getInstance().unlinkStudentPredmet(s, p);
					//azuriranje prikaza u JList
					AbstractListModelSpisak mod = (AbstractListModelSpisak) lista.getModel();
					mod.azuriraj(lista.getSelectedIndex());
				}
			}
			
		});
		
	}
	
	private JPanel addPanel() {
		JPanel ret = new JPanel();
		cancel_btn = new JButton(StringResources.CANCEL);
		remove_btn = new JButton(StringResources.REMOVE);
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
