package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import klase.Predmet;

public class SubjectPanel extends JPanel implements FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8542726682573525716L;
	
	private JTextField sif_txt, naz_txt;
	private JLabel sif_lbl,naz_lbl,sem_lbl,god_lbl;	
	private JComboBox<String> god_list;
	private JComboBox<String> sem_list;
	private int mode, broj;
	private Predmet predmet;
	private JButton cnl_btn,ok_btn;
		
	
	public SubjectPanel(int mode)
	{
		this.mode = mode;
		setLayout(new BorderLayout());
		JPanel btns = new JPanel();
		this.cnl_btn = new JButton("Cancel");
		this.ok_btn = new JButton("Add");
		btns.add(cnl_btn);
		btns.add(ok_btn);
		add(btns,BorderLayout.SOUTH);
		
		JPanel in_field = new JPanel();
		in_field.setLayout(new BoxLayout(in_field, BoxLayout.Y_AXIS));
			
		
		in_field.add(add_panel(sif_lbl,this.sif_txt,"Sifra predmeta *",0));
		in_field.add(add_panel(naz_lbl,this.naz_txt,"Naziv predmeta *",0));
		in_field.add(add_panel(god_lbl,null,"Godina *",1));
		in_field.add(add_panel(sem_lbl,null,"Semestar *",2));
		
		
		
		add(in_field,BorderLayout.NORTH);
		
		if(mode == AddDialog.ADD_MODE)
		{
			ok_btn.setEnabled(false);
			this.broj=-2;
		}
		else
		{
			ok_btn.setEnabled(true);
			this.broj=0;
			predmet = PredmetController.getInstance().nadjiPredmet(MojCentralni.getInstance().getTablPredmeti().getSelectedRow());
			
			sif_txt.setText(predmet.getmSifraPredmeta());
			naz_txt.setText(predmet.getmNazivPredmeta());
		}
		
		listeners();
		
		
	}
	
	private void listeners()
	{
		cnl_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO zatvoriti dijalog
				
			}
		});
		
		sif_txt.addFocusListener(this);
		naz_txt.addFocusListener(this);
		
		ok_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int tmp_god = god_list.getSelectedIndex()+1;
				int tmp_sem = sem_list.getSelectedIndex()+1;
				
				if(mode==AddDialog.ADD_MODE)
					if(!PredmetController.getInstance().dodajPredmet(sif_txt.getText(),naz_txt.getText(),tmp_god,tmp_sem))
					{
						ok_btn.setEnabled(false);
						sif_txt.setForeground(Color.RED);
						sif_txt.setText(sif_txt.getText()+" - vec postoji sifra predmeta");
						broj--;
					}
				else 
					if(!PredmetController.getInstance().izmeniPredmet(sif_txt.getText(),naz_txt.getText(),tmp_god,tmp_sem,predmet.getId()))
					{
						ok_btn.setEnabled(false);
						sif_txt.setForeground(Color.RED);
						sif_txt.setText(sif_txt.getText()+" - vec postoji sifra predmeta");
						broj--;
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
			txt = new JTextField();
			txt.setPreferredSize(txt_dimension);
			pomocni.add(txt);
		}
		else
		{
			Vector<String> vec = new Vector<String>();
			if(broj == 1)
			{
				vec.add("I (prva)");
				vec.add("II (druga)");
				vec.add("III (treća)");
				vec.add("IV (četvrta)");
				sem_list = new JComboBox<String>(vec);
				sem_list.setPreferredSize(txt_dimension);
				pomocni.add(sem_list);
				
			}
			else if(broj == 2)
			{
				vec.add("I (prvi)");
				vec.add("II (drugi)");
				vec.add("III (treći)");
				vec.add("IV (četvrti)");
				vec.add("V (peti)");
				vec.add("VI (sesti)");
				vec.add("VII (sedmi)");
				vec.add("VII (osmi)");
				sem_list = new JComboBox<String>(vec);
				sem_list.setPreferredSize(txt_dimension);
				pomocni.add(sem_list);
			}
		}
		return pomocni;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		System.out.println("GAINED");
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		System.out.println("LOST");
		
	}
}
