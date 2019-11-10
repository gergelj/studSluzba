package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubjectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8542726682573525716L;
	
	private JTextField sif_txt, naz_txt;
	private JLabel sif_lbl,naz_lbl,sem_lbl,god_lbl;	
	private JComboBox<String> list;	
	public SubjectPanel()
	{
		setLayout(new BorderLayout());
		JPanel btns = new JPanel();
		JButton cnl_btn = new JButton("Cancel");
		JButton ok_btn = new JButton("Add");
		btns.add(cnl_btn);
		btns.add(ok_btn);
		add(btns,BorderLayout.SOUTH);
		
		JPanel in_field = new JPanel();
		in_field.setLayout(new BoxLayout(in_field, BoxLayout.Y_AXIS));
		
		in_field.add(add_panel(sif_lbl,sif_txt,"Sifra predmeta *",0));
		in_field.add(add_panel(naz_lbl,naz_txt,"Naziv predmeta *",0));
		in_field.add(add_panel(god_lbl,null,"Godina *",1));
		in_field.add(add_panel(sem_lbl,null,"Semestar *",2));
		
		
		
		add(in_field,BorderLayout.NORTH);
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
			}
			list = new JComboBox<String>(vec);
			list.setPreferredSize(txt_dimension);
			pomocni.add(list);
		}
		return pomocni;
	}
}
