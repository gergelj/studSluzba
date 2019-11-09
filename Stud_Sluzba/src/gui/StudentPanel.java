package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class StudentPanel extends JPanel {

	private JTextField ime_txt, prezime_txt, datrodj_txt, adresa_txt, telefon_txt, email_txt, brindeksa_txt, datupis_txt, prosek_txt;
	private JLabel ime_lbl, prezime_lbl, datrodj_lbl, adresa_lbl, telefon_lbl, email_lbl, brindeksa_lbl, datupis_lbl, prosek_lbl, godstudija_lbl;
	private JPanel ime_pan, prezime_pan, datrodj_pan, adresa_pan, telefon_pan, email_pan, brindeksa_pan, datupis_pan, prosek_pan, godstudija_pan, finansiranje_pan;
	private JComboBox<String> godstudija_list;
	private ButtonGroup finansiranje_grp;
	/**
	 * 
	 */
	private static final long serialVersionUID = 535374820696793027L;

	public StudentPanel() {
		setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		JButton cancel_btn = new JButton("Cancel");
		JButton ok_btn = new JButton("Add");
		buttons.add(cancel_btn);
		buttons.add(ok_btn);
		add(buttons, BorderLayout.SOUTH);
		
		JPanel inputpolja = new JPanel();
		inputpolja.setLayout(new BoxLayout(inputpolja, BoxLayout.Y_AXIS));
		Dimension dim_lbl = new Dimension(150, 20);
		Dimension dim_txt = new Dimension(200, 20);
		
		ime_pan = new JPanel();
		ime_lbl = new JLabel("Ime *");
		ime_lbl.setPreferredSize(dim_lbl);
		ime_txt = new JTextField();
		ime_txt.setPreferredSize(dim_txt);
		ime_pan.add(ime_lbl);
		ime_pan.add(ime_txt);
		inputpolja.add(ime_pan);

		prezime_pan = new JPanel();
		prezime_lbl = new JLabel("Prezme *");
		prezime_lbl.setPreferredSize(dim_lbl);
		prezime_txt = new JTextField();
		prezime_txt.setPreferredSize(dim_txt);
		prezime_pan.add(prezime_lbl);
		prezime_pan.add(prezime_txt);
		inputpolja.add(prezime_pan);

		datrodj_pan = new JPanel();
		datrodj_lbl = new JLabel("Datum rođenja *");
		datrodj_lbl.setPreferredSize(dim_lbl);
		datrodj_txt = new JTextField();
		datrodj_txt.setPreferredSize(dim_txt);
		datrodj_pan.add(datrodj_lbl);
		datrodj_pan.add(datrodj_txt);
		inputpolja.add(datrodj_pan);

		adresa_pan = new JPanel();
		adresa_lbl = new JLabel("Adresa *");
		adresa_lbl.setPreferredSize(dim_lbl);
		adresa_txt = new JTextField();
		adresa_txt.setPreferredSize(dim_txt);
		adresa_pan.add(adresa_lbl);
		adresa_pan.add(adresa_txt);
		inputpolja.add(adresa_pan);

		telefon_pan = new JPanel();
		telefon_lbl = new JLabel("Telefon *");
		telefon_lbl.setPreferredSize(dim_lbl);
		telefon_txt = new JTextField();
		telefon_txt.setPreferredSize(dim_txt);
		telefon_pan.add(telefon_lbl);
		telefon_pan.add(telefon_txt);
		inputpolja.add(telefon_pan);

		email_pan = new JPanel();
		email_lbl = new JLabel("E-mail *");
		email_lbl.setPreferredSize(dim_lbl);
		email_txt = new JTextField();
		email_txt.setPreferredSize(dim_txt);
		email_pan.add(email_lbl);
		email_pan.add(email_txt);
		inputpolja.add(email_pan);

		brindeksa_pan = new JPanel();
		brindeksa_lbl = new JLabel("Broj indeksa *");
		brindeksa_lbl.setPreferredSize(dim_lbl);
		brindeksa_txt = new JTextField();
		brindeksa_txt.setPreferredSize(dim_txt);
		brindeksa_pan.add(brindeksa_lbl);
		brindeksa_pan.add(brindeksa_txt);
		inputpolja.add(brindeksa_pan);

		datupis_pan = new JPanel();
		datupis_lbl = new JLabel("Datum upisa *");
		datupis_lbl.setPreferredSize(dim_lbl);
		datupis_txt = new JTextField();
		datupis_txt.setPreferredSize(dim_txt);
		datupis_pan.add(datupis_lbl);
		datupis_pan.add(datupis_txt);
		inputpolja.add(datupis_pan);

		prosek_pan = new JPanel();
		prosek_lbl = new JLabel("Prosek *");
		prosek_lbl.setPreferredSize(dim_lbl);
		prosek_txt = new JTextField();
		prosek_txt.setPreferredSize(dim_txt);
		prosek_pan.add(prosek_lbl);
		prosek_pan.add(prosek_txt);
		inputpolja.add(prosek_pan);

		godstudija_pan = new JPanel();
		godstudija_lbl = new JLabel("Godina studija *");
		godstudija_lbl.setPreferredSize(dim_lbl);
		godstudija_pan.add(godstudija_lbl);
		Vector<String> v = new Vector<String>();
		v.add("I (prva)");
		v.add("II (druga)");
		v.add("III (treća)");
		v.add("IV (četvrta)");
		godstudija_list = new JComboBox<String>(v);
		godstudija_list.setPreferredSize(dim_txt);
		godstudija_pan.add(godstudija_list);
		inputpolja.add(godstudija_pan);
		
		finansiranje_pan = new JPanel();
		finansiranje_pan.setLayout(new BoxLayout(finansiranje_pan, BoxLayout.Y_AXIS));
		finansiranje_grp = new ButtonGroup();
		JRadioButtonMenuItem finansiranje_b = new JRadioButtonMenuItem("Budžet");
		finansiranje_b.setSelected(true);
		JRadioButtonMenuItem finansiranje_s = new JRadioButtonMenuItem("Samofinansiranje");
		finansiranje_grp.add(finansiranje_b);
		finansiranje_grp.add(finansiranje_s);
		
		finansiranje_pan.add(finansiranje_b);
		finansiranje_pan.add(finansiranje_s);
		inputpolja.add(finansiranje_pan);
		
		add(inputpolja, BorderLayout.CENTER);
		
		listeners();
	}
	
	private void listeners() {
		
		
		
		
		
		
	}
}
