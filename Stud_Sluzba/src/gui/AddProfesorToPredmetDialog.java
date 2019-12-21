package gui;

import java.awt.BorderLayout;
import java.awt.Component;
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
import gui.SpisakPredmetaDialog.AbstractListModelSpisak;
import klase.Predmet;
import klase.Profesor;
import klase.Student;

public class AddProfesorToPredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4860311942771508391L;
	
	private JButton cnl_btn, add_btn;
	private JList<Profesor> profesori;
	private Predmet selectedPredmet;
	
	public class AbstractListModelProfesori extends AbstractListModel<Profesor>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 5551859414551823540L;
		
		private List<Profesor> profesori;
		
		public AbstractListModelProfesori() {
			this.profesori = ProfesorController.getInstance().getProfesori();
		}
		
		@Override
		public Profesor getElementAt(int ind) {
			return this.profesori.get(ind);
		}

		@Override
		public int getSize() {
			return this.profesori.size();
		}

		public void azuriraj(int selectedIndex) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public AddProfesorToPredmetDialog(int selPredRow)
	{
		super(MainFrame.getInstance(),"Assign Professor to Subject",true);
		setSize(400,300);
		setLocationRelativeTo(MainFrame.getInstance());
		this.selectedPredmet = PredmetController.getInstance().nadjiPredmet(selPredRow);
		this.setTitle("Assign Professor to "+this.selectedPredmet.getmNazivPredmeta());
		add(addPanel());
		
		cnl_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profesor p = profesori.getSelectedValue();
				Predmet pr = selectedPredmet;
				
				PredmetController.getInstance().linkProfesorPredmet(p,pr);
				System.out.println("Dodat profesor na predmet");
			    AbstractListModelProfesori mod = (AbstractListModelProfesori) profesori.getModel();
			    mod.azuriraj(profesori.getSelectedIndex());
			}
		});
	}

	private Component addPanel() {
		JPanel pom = new JPanel();
		cnl_btn = new JButton("Cancel");
		add_btn = new JButton("Add");
		JPanel btns = new JPanel();
		btns.add(cnl_btn);
		btns.add(add_btn);
		
		pom.add(btns, BorderLayout.SOUTH);
		
		ScrollPane scroll = new ScrollPane();
		scroll.setPreferredSize(new Dimension(400,400));
		
		profesori = new JList<Profesor>();
		profesori.setModel(new AbstractListModelProfesori());
		scroll.add(profesori);
		
		pom.add(scroll,BorderLayout.NORTH);
		return pom;
	}
}
