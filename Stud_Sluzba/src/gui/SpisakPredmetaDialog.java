package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.ProfesorController;
import klase.Predmet;
import klase.Profesor;

public class SpisakPredmetaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1340147516593767107L;
	
	private JList<Predmet> lista;
	
	public class AbstractListModelSpisak extends AbstractListModel<Predmet>
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = -1477659537463415943L;

		
		private List<Predmet> predmeti;
		private Profesor p;
		
		public AbstractListModelSpisak(Profesor p) {
			this.p = p;
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
	}
	
	public SpisakPredmetaDialog()
	{
		super(MainFrame.getInstance(),"Subjects for selected Professor",true);
		setSize(400,500);
		setLocationRelativeTo(MainFrame.getInstance());
		
		add(addPanel());
	}
	
	private JPanel addPanel()
	{
		JPanel ret = new JPanel();
		ScrollPane scroll = new ScrollPane();
		scroll.setPreferredSize(new Dimension(400,400));
		
		lista = new JList<Predmet>();
		//TODO: lista.setModel(new AbstractListModelSpisak(p));
		scroll.add(lista);
		
		ret.add(scroll,BorderLayout.CENTER);
		return ret;
	}
}
