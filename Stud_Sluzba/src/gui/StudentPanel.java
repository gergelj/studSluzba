package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.StudentController;
import listeneri.StudentListener;
import klase.StringResources;
import klase.Student;

public class StudentPanel extends JPanel /*implements FocusListener*/ {

	private JTextField ime_txt, prezime_txt, datrodj_txt, adresa_txt, telefon_txt, email_txt, brindeksa_txt, datupis_txt, prosek_txt;
	private JLabel ime_lbl, prezime_lbl, datrodj_lbl, adresa_lbl, telefon_lbl, email_lbl, brindeksa_lbl, datupis_lbl, prosek_lbl, godstudija_lbl;
	//private JPanel ime_pan, prezime_pan, datrodj_pan, adresa_pan, telefon_pan, email_pan, brindeksa_pan, datupis_pan, prosek_pan;
	private JPanel godstudija_pan, finansiranje_pan;
	private JComboBox<String> godstudija_list;
	private ButtonGroup finansiranje_grp;
	private JButton cancel_btn;
	public static JButton ok_btn;
	private JRadioButtonMenuItem finansiranje_b, finansiranje_s;
	private int mode;
	private Student st;
	public static int broj;
	private AddDialog dialog;
	/**
	 * 
	 */
	private static final long serialVersionUID = 535374820696793027L;

	public StudentPanel(int mode, AddDialog d) {
		this.mode = mode;
		this.dialog = d;
		
		ime_txt = new JTextField();
		prezime_txt = new JTextField();
		datrodj_txt = new JTextField();
		adresa_txt = new JTextField();
		telefon_txt = new JTextField();
		email_txt = new JTextField();
		brindeksa_txt = new JTextField();
		datupis_txt = new JTextField();
		prosek_txt = new JTextField();
		
		// setovanje imena za kasnije u listenerima
		ime_txt.setName("ime");
		prezime_txt.setName("prezime");
		datrodj_txt.setName("datrodj");
		adresa_txt.setName("adresa");
		telefon_txt.setName("telefon");
		email_txt.setName("email");
		brindeksa_txt.setName("indeks");
		datupis_txt.setName("datupis");
		prosek_txt.setName("prosek");

		// podesavanje panela
		setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		cancel_btn = new JButton(StringResources.CANCEL);
		ok_btn = new JButton(StringResources.ADD);
		buttons.add(cancel_btn);
		buttons.add(ok_btn);
		add(buttons, BorderLayout.SOUTH);
		
		JPanel inputpolja = new JPanel();
		inputpolja.setLayout(new BoxLayout(inputpolja, BoxLayout.Y_AXIS));
		Dimension dim_lbl = new Dimension(150, 20);
		Dimension dim_txt = new Dimension(200, 20);
		
		inputpolja.add(noviPanel(ime_lbl, StringResources.LABEL_NAME, ime_txt));	
		inputpolja.add(noviPanel(prezime_lbl, StringResources.LABEL_SURNAME, prezime_txt));
		inputpolja.add(noviPanel(datrodj_lbl, StringResources.LABEL_DATE_OF_BIRTH, datrodj_txt));
		inputpolja.add(noviPanel(adresa_lbl, StringResources.LABEL_ADDRESS, adresa_txt));
		inputpolja.add(noviPanel(telefon_lbl, StringResources.LABEL_TELEPHONE, telefon_txt));
		inputpolja.add(noviPanel(email_lbl, StringResources.LABEL_EMAIL, email_txt));
		inputpolja.add(noviPanel(brindeksa_lbl, StringResources.LABEL_INDEX_NUM, brindeksa_txt));
		inputpolja.add(noviPanel(datupis_lbl, StringResources.LABEL_REGISTRATION_DATE, datupis_txt));
		inputpolja.add(noviPanel(prosek_lbl, StringResources.LABEL_AVERAGE_GRADE, prosek_txt));

		godstudija_pan = new JPanel();
		godstudija_lbl = new JLabel(StringResources.LABEL_CURRENT_YEAR);
		godstudija_lbl.setPreferredSize(dim_lbl);
		godstudija_pan.add(godstudija_lbl);
		Vector<String> v = new Vector<String>();
		v.add(StringResources.LABEL_FIRST_YEAR);
		v.add(StringResources.LABEL_SECOND_YEAR);
		v.add(StringResources.LABEL_THIRD_YEAR);
		v.add(StringResources.LABEL_FOURTH_YEAR);
		godstudija_list = new JComboBox<String>(v);
		godstudija_list.setPreferredSize(dim_txt);
		godstudija_pan.add(godstudija_list);
		inputpolja.add(godstudija_pan);
		
		finansiranje_pan = new JPanel();
		finansiranje_pan.setLayout(new BoxLayout(finansiranje_pan, BoxLayout.Y_AXIS));
		finansiranje_grp = new ButtonGroup();
		finansiranje_b = new JRadioButtonMenuItem(StringResources.STATUS_B);
		finansiranje_b.setSelected(true);
		finansiranje_s = new JRadioButtonMenuItem(StringResources.STATUS_S);
		finansiranje_grp.add(finansiranje_b);
		finansiranje_grp.add(finansiranje_s);
		
		finansiranje_pan.add(finansiranje_b);
		finansiranje_pan.add(finansiranje_s);
		inputpolja.add(finansiranje_pan);
		
		JScrollPane sp = new JScrollPane(inputpolja);
		this.add(sp, BorderLayout.CENTER);
		
		if(mode == AddDialog.ADD_MODE) {
			// onemogucenje da se doda prazan student
			StudentPanel.ok_btn.setEnabled(false);
			// Student ima 9 stavki (text field)
			StudentPanel.broj = -9;
		}
		else {
			StudentPanel.ok_btn.setText(StringResources.EDIT);
			StudentPanel.ok_btn.setEnabled(true);
			StudentPanel.broj = 0;
			this.st = StudentController.getInstance().nadjiStudenta(StudentiJTable.getInstance().getSelectedRow());
		
			ime_txt.setText(st.getIme());
			prezime_txt.setText(st.getPrezime());
			datrodj_txt.setText(st.getDatumRodjenja(1));
			datupis_txt.setText(st.getDatumUpisa(1));
			adresa_txt.setText(st.getAdresa());
			telefon_txt.setText(st.getTelefon());
			email_txt.setText(st.getEmail());
			brindeksa_txt.setText(st.getBrojIndeksa());
			prosek_txt.setText(String.valueOf(st.getProsek()));
			
			godstudija_list.setSelectedIndex(st.getTrenutnaGodina()-1);
			
			if(st.getStatus() == Student.Status.B)
				finansiranje_b.setSelected(true);
			else
				finansiranje_s.setSelected(true);
		}
		
		// prikljucivanje listenera
		listeners();
		
		// tooltip za text polja
		ime_txt.setToolTipText(StringResources.EXAMPLE_NAME);
		prezime_txt.setToolTipText(StringResources.EXAMPLE_SURNAME);
		datrodj_txt.setToolTipText(StringResources.EXAMPLE_DATE);
		datupis_txt.setToolTipText(StringResources.EXAMPLE_DATE);
		adresa_txt.setToolTipText(StringResources.EXAMPLE_ADDRESS);
		telefon_txt.setToolTipText(StringResources.EXAMPLE_TELEPHONE);
		email_txt.setToolTipText(StringResources.EXAMPLE_EMAIL);
		brindeksa_txt.setToolTipText(StringResources.EXAMPLE_INDEX_NUM);
		prosek_txt.setToolTipText(StringResources.EXAMPLE_GRADE);
		
	}
	
	private JPanel noviPanel(JLabel lbl, String name, JTextField txt) {
		JPanel pan = new JPanel();
		lbl = new JLabel(name);
		lbl.setPreferredSize(new Dimension(150, 20));
		txt.setPreferredSize(new Dimension(200, 20));
		pan.add(lbl);
		pan.add(txt);
		return pan;
	}
	
	private void listeners() {
		cancel_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				
			}
		});
		
		ime_txt.addFocusListener(new StudentListener());
		prezime_txt.addFocusListener(new StudentListener());
		datrodj_txt.addFocusListener(new StudentListener());
		datupis_txt.addFocusListener(new StudentListener());
		adresa_txt.addFocusListener(new StudentListener());
		telefon_txt.addFocusListener(new StudentListener());
		email_txt.addFocusListener(new StudentListener());
		brindeksa_txt.addFocusListener(new StudentListener());
		prosek_txt.addFocusListener(new StudentListener());
		
		ok_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int trenutnagodina = godstudija_list.getSelectedIndex() + 1;
				Student.Status status = finansiranje_b.isSelected() ? Student.Status.B : Student.Status.S;
				double prosek = Double.valueOf(prosek_txt.getText());
				
				if(mode==AddDialog.ADD_MODE) {
					if(!StudentController.getInstance().dodajStudenta(ime_txt.getText(), prezime_txt.getText(), datrodj_txt.getText(), adresa_txt.getText(), telefon_txt.getText(), email_txt.getText(), brindeksa_txt.getText().toLowerCase(), datupis_txt.getText(), trenutnagodina, status, prosek)){
						ok_btn.setEnabled(false);
						brindeksa_txt.setForeground(Color.RED);
						brindeksa_txt.setText(brindeksa_txt.getText() + StringResources.INDEX_NUM_EXISTS);
						broj--;
					}
					else {
						dialog.setVisible(false);
					}
				}
				else { //EDIT mode
					if(!StudentController.getInstance().izmeniStudenta(ime_txt.getText(), prezime_txt.getText(), datrodj_txt.getText(), adresa_txt.getText(), telefon_txt.getText(), email_txt.getText(), brindeksa_txt.getText().toLowerCase(), datupis_txt.getText(), trenutnagodina, status, prosek, st.getId())){
						ok_btn.setEnabled(false);
						brindeksa_txt.setForeground(Color.RED);
						brindeksa_txt.setText(brindeksa_txt.getText() + StringResources.INDEX_NUM_EXISTS);
						broj--;
					}
					else {
						dialog.setVisible(false);
					}
				}
				
			}
			
		});
		
	}
	
}
