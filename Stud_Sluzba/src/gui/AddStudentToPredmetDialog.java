package gui;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.StudentController;
import klase.Predmet;
import klase.Proveri;
import klase.StringResources;
import klase.Student;

public class AddStudentToPredmetDialog extends JDialog {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7925418924221482466L;
	
	private JTextField input;
	private JButton add_btn;
	private JLabel message;
	
	public AddStudentToPredmetDialog(Predmet selectedPredmet) {
		super(MainFrame.getInstance(), StringResources.ADD_STUDENT_TO_SUBJECT, true);
		setSize(300, 150);
		setLocationRelativeTo(MainFrame.getInstance());
		
		this.setLayout(null);
		this.setResizable(false);
		
		message = new JLabel(StringResources.INDEX_INPUT);
		message.setBounds(20, 15, 280, 20);
		this.add(message);
		
		input = new JTextField();
		input.setBounds(20, 35, 260, 25);
		this.add(input);
		
		add_btn = new JButton(StringResources.ADD);
		add_btn.setBounds(120, 75, 60, 25);
		add_btn.setMargin(new Insets(0,0,0,0));
		this.add(add_btn);
		
		add_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String query = input.getText();
				
				if(query.equals(""))
					return;
				else if(Proveri.isBrojIndeksa(query)) {
					Student s = StudentController.getInstance().getStudentByBrojIndeksa(query);
					if(s==null) {
						input.setForeground(Color.RED);
						input.setText(input.getText() + StringResources.INDEX_NUM_DOESNT_EXIST);
					}
					else {
						if(selectedPredmet.getmGodinaIzvodjenja()!=s.getTrenutnaGodina()) {
							input.setForeground(Color.RED);
							input.setText(input.getText() + StringResources.NOT_SAME_YEAR);
						}
						else {
							PredmetController.getInstance().linkStudentPredmet(s, selectedPredmet);
							setVisible(false);
						}
					}
				}
				else {
					input.setForeground(Color.RED);
					input.setText(input.getText() + StringResources.WRONG_FORMAT);
				}
				
			}
			
		});
		
		input.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField t = (JTextField) e.getComponent();
				if(t.getForeground() == Color.RED) {
					t.setForeground(Color.BLACK);
					t.setText("");
				}
			}
			
		});
	}
	
}
