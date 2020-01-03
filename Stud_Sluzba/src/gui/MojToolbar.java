package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;

import listeneri.AddListener;
import listeneri.DeleteListener;
import controller.PredmetController;
import listeneri.SaveToDatabaseListener;
import listeneri.SearchListener;
import klase.StringResources;

public class MojToolbar extends JToolBar {

	//parent frame
	//private MainFrame frame;
	private JButton add_btn, edit_btn, delete_btn, save_btn, unsort_btn, add_student_btn, professor_btn;
	private JTextField search_txtF;
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
		
		add_btn = new JButton();
		add_btn.setToolTipText(StringResources.ADD);
		add_btn.setIcon(new ImageIcon("images/add-22.png"));
		add(add_btn);
		add_btn.addActionListener(new AddListener(AddDialog.ADD_MODE));
		
		edit_btn = new JButton();
		edit_btn.setToolTipText(StringResources.EDIT);
		edit_btn.setIcon(new ImageIcon("images/edit-22.png"));
		add(edit_btn);
		edit_btn.addActionListener(new AddListener(AddDialog.EDIT_MODE));
		
		delete_btn = new JButton();
		delete_btn.setToolTipText(StringResources.DELETE);
		delete_btn.setIcon(new ImageIcon("images/trash-22.png"));
		add(delete_btn);
		delete_btn.addActionListener(new DeleteListener());
		
		save_btn = new JButton();
		save_btn.setToolTipText(StringResources.SAVE_TO_DB);
		save_btn.setIcon(new ImageIcon("images/save-22.png"));
		add(save_btn);
		save_btn.addActionListener(new SaveToDatabaseListener());
		
		unsort_btn = new JButton();
		unsort_btn.setToolTipText(StringResources.RESET_SORT);
		unsort_btn.setIcon(new ImageIcon("images/unsort-22.png"));
		add(unsort_btn);
		unsort_btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MojCentralni.getInstance().getSelectedIndex();
				switch(selectedTab) {
				case 0: {RowSorter<?> rs = StudentiJTable.getInstance().getRowSorter();
						rs.setSortKeys(null);}
				break;
				case 1: {
					RowSorter<?> rs = ProfesoriJTable.getInstance().getRowSorter();
					rs.setSortKeys(null);} break;
				case 2:
					{
					RowSorter<?> rs = PredmetiJTable.getInstance().getRowSorter();
					rs.setSortKeys(null);
					}
					break;
				}
			}
			
		});
		
		add_student_btn = new JButton();
		add_student_btn.setToolTipText(StringResources.ADD_STUDENT_TO_SUBJECT);
		add_student_btn.setIcon(new ImageIcon("images/add-student-22.png"));
		add(add_student_btn);
		add_student_btn.setVisible(false);
		add_student_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedPredmetRow = MojCentralni.getInstance().getTablPredmeti().getSelectedRow();
				if(selectedPredmetRow != -1) {
					AddStudentToPredmetDialog dial = new AddStudentToPredmetDialog(PredmetController.getInstance().nadjiPredmet(selectedPredmetRow));
					dial.setVisible(true);
				}
			}
			
		});
		
		professor_btn = new JButton();
		professor_btn.setToolTipText(StringResources.ASSIGN_PROFESSOR_TO_SUBJECT);
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
		
		add(Box.createHorizontalGlue());
		
		search_txtF = new JTextField(50);
		search_txtF.setMaximumSize(new Dimension(350, 30));
		search_txtF.setToolTipText(StringResources.SEARCH_EXAMPLE);
		add(search_txtF);
		search_txtF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JTextField comp = (JTextField) e.getComponent();
				comp.setForeground(Color.BLACK);
			}
		});
		
		JButton search_btn = new JButton();
		search_btn.setToolTipText(StringResources.SEARCH);
		search_btn.setIcon(new ImageIcon("images/search-22.png"));
		add(search_btn);
		search_btn.addActionListener(new SearchListener());
		
		setFloatable(false);
	}
	
	public void setButtonsVisible(boolean b) {
		add_student_btn.setVisible(b);
		professor_btn.setVisible(b);
	}

	public String getQuery() {
		return this.search_txtF.getText();
	}
	
	public void searchError() {
		this.search_txtF.setForeground(Color.RED);
	}

}
