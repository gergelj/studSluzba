package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorController;
import controller.ProfessorListener;
import klase.Profesor;

public class ProfessorPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6806021761828967430L;
	
	private JTextField ime_txt, prz_txt, datrodj_txt,adr_txt, tel_txt, email_txt, adrKanc_txt, brlk_txt,titula_txt,zvanje_txt;
	private JLabel ime_lbl,prz_lbl, datrodj_lbl, adr_lbl, tel_lbl, email_lbl, adrKanc_lbl, brlk_lbl, titula_lbl, zvanje_lbl;
	private int mode;
	public static int br;
	private Profesor profesor;
	public static JButton cnl_btn, ok_btn;
	
	public ProfessorPanel(int mode)
	{
		this.mode = mode;
		setLayout(new BorderLayout());
		
		JPanel btns = new JPanel();
		ok_btn = new JButton("Add");
		cnl_btn = new JButton("Cancel");
		btns.add(cnl_btn);
		btns.add(ok_btn);
		add(btns,BorderLayout.SOUTH);
		
		JPanel in_field = new JPanel();
		in_field.setLayout(new BoxLayout(in_field, BoxLayout.Y_AXIS));
		
		ime_txt = new JTextField();
		ime_txt.setName("ime");
		prz_txt = new JTextField();
		prz_txt.setName("prezime");
		datrodj_txt = new JTextField();
		datrodj_txt.setName("dat rodj");
		adr_txt = new JTextField();
		adr_txt.setName("adresa");
		tel_txt = new JTextField();
		tel_txt.setName("telefon");
		email_txt = new JTextField();
		email_txt.setName("email");
		adrKanc_txt = new JTextField();
		adrKanc_txt.setName("adresa kanc");
		brlk_txt = new JTextField();
		brlk_txt.setName("brlk");
		titula_txt = new JTextField();
		titula_txt.setName("titula");
		zvanje_txt = new JTextField();
		zvanje_txt.setName("zvanje");
		
		in_field.add(add_panel(ime_lbl,this.ime_txt,"Ime *"));
		in_field.add(add_panel(prz_lbl,this.prz_txt,"Prezime *"));
		in_field.add(add_panel(datrodj_lbl,this.datrodj_txt,"Datum rodjenja *"));
		in_field.add(add_panel(adr_lbl,this.adr_txt,"Adresa stanovanja *"));
		in_field.add(add_panel(tel_lbl,this.tel_txt,"Kontakt telefon *"));
		in_field.add(add_panel(email_lbl,this.email_txt,"Email *"));
		in_field.add(add_panel(adrKanc_lbl,this.adrKanc_txt,"Adresa kancelarije *"));
		in_field.add(add_panel(brlk_lbl,this.brlk_txt,"Broj licne karte *"));
		in_field.add(add_panel(titula_lbl,this.titula_txt,"Titula *"));
		in_field.add(add_panel(zvanje_lbl,this.zvanje_txt,"Zvanje *"));
		in_field.add(Box.createVerticalGlue());
		add(in_field,BorderLayout.NORTH);
	
		if(mode == AddDialog.ADD_MODE)
		{
			ok_btn.setEnabled(false);
			ProfessorPanel.br=-10;
		}
		else
		{
			ok_btn.setEnabled(true);
			ProfessorPanel.br=0;
			//TODO: profesor = ProfesorController.getInstance().nadjiProfesora(MojCentralni.getInstance().getTabelaProfesora().getSelectedRow());
			
			ime_txt.setText(profesor.getmIme());
			prz_txt.setText(profesor.getmPrezime());
			datrodj_txt.setText(profesor.getmDatumRodjenja(0));
			adr_txt.setText(profesor.getmAdresaStanovanja());
			tel_txt.setText(profesor.getmTelefon());
			email_txt.setText(profesor.getmEmail());
			adrKanc_txt.setText(profesor.getmAdresaKancelarije());
			brlk_txt.setText(profesor.getmBrojLK());
			titula_txt.setText(profesor.getmTitula());
			zvanje_txt.setText(profesor.getmZvanje());
		}
		
		listeners();
	}
	
	private void listeners()
	{
		cnl_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ime_txt.addFocusListener(new ProfessorListener());
		prz_txt.addFocusListener(new ProfessorListener());
		datrodj_txt.addFocusListener(new ProfessorListener());
		adr_txt.addFocusListener(new ProfessorListener());
		tel_txt.addFocusListener(new ProfessorListener());
		email_txt.addFocusListener(new ProfessorListener());
		adrKanc_txt.addFocusListener(new ProfessorListener());
		brlk_txt.addFocusListener(new ProfessorListener());
		titula_txt.addFocusListener(new ProfessorListener());
		zvanje_txt.addFocusListener(new ProfessorListener());
		
		ok_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
            if(mode == AddDialog.ADD_MODE)
            {
            	if(!ProfesorController.getInstance().dodajProfesora(ime_txt.getText(), prz_txt.getText(), datrodj_txt.getText(), adr_txt.getText(), tel_txt.getText(), email_txt.getText(), adrKanc_txt.getText(), brlk_txt.getText(), titula_txt.getText(), zvanje_txt.getText(), profesor.getId()))
            	{
            		ok_btn.setEnabled(false);
            		brlk_txt.setForeground(Color.RED);
            		brlk_txt.setText(brlk_txt.getText()+" -vec postoji broj licne karte");
            		br--;
            	}
            }
            else
            {
            	if(!ProfesorController.getInstance().izmeniProfesora(ime_txt.getText(), prz_txt.getText(), datrodj_txt.getText(), adr_txt.getText(), tel_txt.getText(), email_txt.getText(), adrKanc_txt.getText(), brlk_txt.getText(), titula_txt.getText(), zvanje_txt.getText(), profesor.getId()))
            	{
            		ok_btn.setEnabled(false);
            		brlk_txt.setForeground(Color.RED);
            		brlk_txt.setText(brlk_txt.getText()+" -vec postoji broj licne karte");
            		br--;
            	}
            }
            		
			}
		});
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
