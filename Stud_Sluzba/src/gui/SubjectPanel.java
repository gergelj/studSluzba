package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.PredmetListener;
import klase.Predmet;

public class SubjectPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8542726682573525716L;
	
	private JTextField sif_txt, naz_txt;
	private JLabel sif_lbl,naz_lbl,sem_lbl,god_lbl;	
	private JComboBox<String> god_list;
	private JComboBox<String> sem_list;
	private int mode;
	public static int br;
	private Predmet predmet;
	public static JButton cnl_btn,ok_btn;
	private AddDialog dialog;
	
	public SubjectPanel(int mode, AddDialog dialog)
	{
		this.mode = mode;
		this.dialog = dialog;
		setLayout(new BorderLayout());
		JPanel btns = new JPanel();
		SubjectPanel.cnl_btn = new JButton("Cancel");
		SubjectPanel.ok_btn = new JButton("Add");
		btns.add(cnl_btn);
		btns.add(ok_btn);
		add(btns,BorderLayout.SOUTH);
		
		JPanel in_field = new JPanel();
		in_field.setLayout(new BoxLayout(in_field, BoxLayout.Y_AXIS));
			
		sif_txt = new JTextField();
		sif_txt.setName("sifra predmeta");
		
		naz_txt = new JTextField();
		naz_txt.setName("naziv predmeta");
		
		
		
		Vector<String> vec = new Vector<String>();
		
		vec.add("I (prva)");
		vec.add("II (druga)");
		vec.add("III (treća)");
		vec.add("IV (četvrta)");
		
		Vector<String> vec2 = new Vector<String>();
		
		vec2.add("I (prvi)");
		vec2.add("II (drugi)");
		vec2.add("III (treći)");
		vec2.add("IV (četvrti)");
		vec2.add("V (peti)");
		vec2.add("VI (sesti)");
		vec2.add("VII (sedmi)");
		vec2.add("VII (osmi)");
		
		sem_list = new JComboBox<String>(vec2);
		god_list = new JComboBox<String>(vec);
		
		in_field.add(add_panel(sif_lbl,this.sif_txt,"Sifra predmeta *",0));
		in_field.add(add_panel(naz_lbl,this.naz_txt,"Naziv predmeta *",0));
		in_field.add(add_panel(god_lbl,null,"Godina *",1));
		in_field.add(add_panel(sem_lbl,null,"Semestar *",2));
		
		
		
		add(in_field,BorderLayout.NORTH);
		
		if(mode == AddDialog.ADD_MODE)
		{
			ok_btn.setEnabled(false);
			SubjectPanel.br=-2;
		}
		else
		{
			ok_btn.setText("Edit");
			ok_btn.setEnabled(true);
			SubjectPanel.br=0;
			predmet = PredmetController.getInstance().nadjiPredmet(MojCentralni.getInstance().getTablPredmeti().getSelectedRow());
			
			sif_txt.setText(predmet.getmSifraPredmeta());
			naz_txt.setText(predmet.getmNazivPredmeta());
			god_list.setSelectedIndex(predmet.getmGodinaIzvodjenja()-1);
			sem_list.setSelectedIndex(predmet.getmSemestarPredmeta()-1);
		}
		
		listeners();
		
		
	}
	
	private void listeners()
	{
		cnl_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				
			}
		});
		
		sif_txt.addFocusListener(new PredmetListener());
		naz_txt.addFocusListener(new PredmetListener());
		
		ok_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int tmp_god = god_list.getSelectedIndex()+1;
				int tmp_sem = sem_list.getSelectedIndex()+1;
				
				if(mode == AddDialog.ADD_MODE) {
					if(!PredmetController.getInstance().dodajPredmet(sif_txt.getText().toLowerCase(),naz_txt.getText(),tmp_god,tmp_sem))
					{
						ok_btn.setEnabled(false);
						sif_txt.setForeground(Color.RED);
						sif_txt.setText(sif_txt.getText()+" - vec postoji sifra predmeta");
						br--;
					}
					else
					{
						dialog.setVisible(false);
					}
				}
				else {
					if(!PredmetController.getInstance().izmeniPredmet(sif_txt.getText().toLowerCase(),naz_txt.getText(),tmp_god,tmp_sem,predmet.getId()))
					{
						ok_btn.setEnabled(false);
						sif_txt.setForeground(Color.RED);
						sif_txt.setText(sif_txt.getText()+" - vec postoji sifra predmeta");
						br--;
					}
					else
					{
						dialog.setVisible(false);
					}
				}
			}
		});
	}
	
	private JPanel add_panel(JLabel labela,JTextField txt,String ime_labele,int broj)
	{
		JPanel pomocni = new JPanel();
		Dimension lbl_dimension = new Dimension(150,20);
		Dimension txt_dimension = new Dimension(200,20);
		labela = new JLabel(ime_labele);
		labela.setPreferredSize(lbl_dimension);
		pomocni.add(labela);
		if(broj==0)
		{
			txt.setPreferredSize(txt_dimension);
			pomocni.add(txt);
		}
		else
		{
			
			if(broj == 1)
			{
				god_list.setPreferredSize(txt_dimension);
				pomocni.add(god_list);	
			}
			else if(broj == 2)
			{
				sem_list.setPreferredSize(txt_dimension);
				pomocni.add(sem_list);
			}
		}
		return pomocni;
	}

}
