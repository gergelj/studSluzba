package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfessorPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6806021761828967430L;
	
	private JTextField ime_txt, prz_txt, datrodj_txt,adr_txt, tel_txt, email_txt, adrKanc_txt, brlk_txt,titula_txt,zvanje_txt;
	private JLabel ime_lbl,prz_lbl, datrodj_lbl, adr_lbl, tel_lbl, email_lbl, adrKanc_lbl, brlk_lbl, titula_lbl, zvanje_lbl;
		
	public ProfessorPanel()
	{
		setLayout(new BorderLayout());
		
		JPanel btns = new JPanel();
		JButton add_btn = new JButton("Add");
		JButton cnl_btn = new JButton("Cancel");
		btns.add(cnl_btn);
		btns.add(add_btn);
		add(btns,BorderLayout.SOUTH);
		
		JPanel in_field = new JPanel();
		in_field.setLayout(new BoxLayout(in_field, BoxLayout.Y_AXIS));
		
		in_field.add(add_panel(ime_lbl,ime_txt,"Ime *"));
		in_field.add(add_panel(prz_lbl,prz_txt,"Prezime *"));
		in_field.add(add_panel(datrodj_lbl,datrodj_txt,"Datum rodjenja *"));
		in_field.add(add_panel(adr_lbl,adr_txt,"Adresa stanovanja *"));
		in_field.add(add_panel(tel_lbl,tel_txt,"Kontakt telefon *"));
		in_field.add(add_panel(email_lbl,email_txt,"Email *"));
		in_field.add(add_panel(adrKanc_lbl,adrKanc_txt,"Adresa kancelarije *"));
		in_field.add(add_panel(brlk_lbl,brlk_txt,"Broj licne karte *"));
		in_field.add(add_panel(titula_lbl,titula_txt,"Titula *"));
		in_field.add(add_panel(zvanje_lbl,zvanje_txt,"Zvanje *"));
		in_field.add(Box.createVerticalGlue());
		add(in_field,BorderLayout.NORTH);
	
		
		listeners();
	}
	
	private void listeners()
	{
		
	}
	
	private JPanel add_panel(JLabel labela,JTextField txt,String ime_labele)
	{
		JPanel pomocni = new JPanel();
		Dimension lbl_dimension = new Dimension(150,20);
		Dimension txt_dimension = new Dimension(200,20);
		labela = new JLabel(ime_labele);
		labela.setPreferredSize(lbl_dimension);
		txt = new JTextField();
		txt.setPreferredSize(txt_dimension);
		pomocni.add(labela);
		pomocni.add(txt);
		return pomocni;
	}
}
