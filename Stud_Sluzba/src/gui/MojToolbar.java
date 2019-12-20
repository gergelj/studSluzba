package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.AddListener;
import controller.DeleteListener;
import controller.SaveToDatabaseListener;
import controller.StudentController;

public class MojToolbar extends JToolBar {

	//parent frame
	//private MainFrame frame;
	private JButton add_btn, edit_btn, delete_btn, save_btn, unsort_btn, add_student_btn, professor_btn;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6293715549294891243L;
	
	private static MojToolbar instance = null;
	
	public static MojToolbar getInstance() {
		if(instance==null)
			instance = new MojToolbar();
		return instance;
	}
	
	private MojToolbar() {
		super(SwingConstants.HORIZONTAL);
		//this.frame = mf;
		
		add_btn = new JButton();
		add_btn.setToolTipText("Add");
		add_btn.setIcon(new ImageIcon("images/add-22.png"));
		add(add_btn);
		add_btn.addActionListener(new AddListener(AddDialog.ADD_MODE));
		
		edit_btn = new JButton();
		edit_btn.setToolTipText("Edit");
		edit_btn.setIcon(new ImageIcon("images/edit-22.png"));
		add(edit_btn);
		edit_btn.addActionListener(new AddListener(AddDialog.EDIT_MODE));
		
		delete_btn = new JButton();
		delete_btn.setToolTipText("Delete");
		delete_btn.setIcon(new ImageIcon("images/trash-22.png"));
		add(delete_btn);
		delete_btn.addActionListener(new DeleteListener());
		
		save_btn = new JButton();
		save_btn.setToolTipText("Save to Database");
		save_btn.setIcon(new ImageIcon("images/save-22.png"));
		add(save_btn);
		save_btn.addActionListener(new SaveToDatabaseListener());
		
		unsort_btn = new JButton();
		unsort_btn.setToolTipText("Reset sorting");
		unsort_btn.setIcon(new ImageIcon("images/unsort-22.png"));
		add(unsort_btn);
		unsort_btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController.getInstance().unsort();
			}
			
		});
		
		add_student_btn = new JButton();
		add_student_btn.setToolTipText("Dodaj studenta na predmet");
		add_student_btn.setIcon(new ImageIcon("images/add-student-22.png"));
		add(add_student_btn);
		add_student_btn.setVisible(false);
		add_student_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedPredmetRow = MojCentralni.getInstance().getTablPredmeti().getSelectedRow();
				if(selectedPredmetRow != -1) {
					AddStudentToPredmetDialog dial = new AddStudentToPredmetDialog(selectedPredmetRow);
					dial.setVisible(true);
				}
			}
			
		});
		
		professor_btn = new JButton();
		professor_btn.setToolTipText("Promeni profesora na predmetu");
		professor_btn.setIcon(new ImageIcon("images/professor-22.png"));
		add(professor_btn);
		professor_btn.setVisible(false);
		professor_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedPredmetRow = MojCentralni.getInstance().getTablPredmeti().getSelectedRow();
				if(selectedPredmetRow != -1)
				{
					AddProfesorToPredmetDialog dial = new AddProfesorToPredmetDialog(selectedPredmetRow);
					dial.setVisible(true);
				}
				
			}
		});
		
		//TODO add search text field
		
		add(Box.createHorizontalGlue());
		
		JTextField search_txtF = new JTextField(50);
		search_txtF.setMaximumSize(search_txtF.getPreferredSize());
		search_txtF.setToolTipText("Enter text");
		add(search_txtF);
		
		JButton search_btn = new JButton();
		search_btn.setToolTipText("Search");
		search_btn.setIcon(new ImageIcon("images/search-22.png"));
		add(search_btn);
		
		setFloatable(false);
	}
	
	public void setButtonsVisible(boolean b) {
		add_student_btn.setVisible(b);
		professor_btn.setVisible(b);
	}

}
