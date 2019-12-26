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
import controller.ProfesorController;
import klase.Predmet;
import klase.Profesor;
import klase.StringResources;

public class SpisakPredmetaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1340147516593767107L;
	
	private JButton remove_btn;
	private JList<Predmet> lista;
	private Profesor selectedProf;
	
	public class AbstractListModelSpisak extends AbstractListModel<Predmet>
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = -1477659537463415943L;

		
		private List<Predmet> predmeti;
		
		
		public AbstractListModelSpisak(Profesor p) {
			this.predmeti = ProfesorController.getInstance().getListOfSubjects(p);
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
	
	public SpisakPredmetaDialog(int selectedProfRow)
	{
		super(MainFrame.getInstance(),StringResources.PROFESSOR_SUBJECT_LIST,true);
		setSize(400,500);
		setLocationRelativeTo(MainFrame.getInstance());
		
		this.selectedProf = ProfesorController.getInstance().nadjiProfesora(selectedProfRow);
		add(addPanel());
		
		remove_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Predmet p = lista.getSelectedValue();
				if(p != null)
				{
					Profesor prof = ProfesorController.getInstance().nadjiProfesora(selectedProfRow);
					PredmetController.getInstance().unlinkProfesorPredmet(prof, p);
					MojCentralni.getInstance().azurirajPrikazPredmet();
					setVisible(false);
				}
				
			}
		});
	}
	
	private JPanel addPanel()
	{
		JPanel ret = new JPanel();
		
		remove_btn = new JButton(StringResources.REMOVE);
		JPanel btns = new JPanel();
		btns.add(remove_btn);
		
		ret.add(btns, BorderLayout.SOUTH);
		
		ScrollPane scroll = new ScrollPane();
		scroll.setPreferredSize(new Dimension(400,400));
		
		lista = new JList<Predmet>();
		lista.setModel(new AbstractListModelSpisak(selectedProf));
		scroll.add(lista);
		
		ret.add(scroll,BorderLayout.CENTER);
		return ret;
	}
}
