package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

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
	
	private JTextField sif_pred, naz_pred;
	private JLabel sif_lbl,naz_lbl,sem_lbl,god_lbl;	
	private JComboBox<String> god_list;
	private JComboBox<String> sem_list;
	
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
