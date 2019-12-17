package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import gui.SubjectPanel;
import klase.Proveri;

public class PredmetListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		JTextField tx = (JTextField) e.getComponent();
		if(tx.getForeground() == Color.RED)
		{
			tx.setForeground(Color.BLACK);
			tx.setText("");
		}
		
		String txt = tx.getText();
		String name = tx.getName();
		
		boolean uslov = (!Proveri.isSifraPredmeta(txt) && name.equalsIgnoreCase("sifra predmeta")
				|| (!Proveri.isImePredmeta(txt) && name.equalsIgnoreCase("naziv predmeta")));
		
		
		if(uslov)
			SubjectPanel.br++;
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField tx = (JTextField) e.getComponent();
		
		String txt = tx.getText();
		String name = tx.getName();
		
		boolean uslov = (!Proveri.isSifraPredmeta(txt) && name.equalsIgnoreCase("sifra predmeta")
				|| (!Proveri.isImePredmeta(txt) && name.equalsIgnoreCase("naziv predmeta")));
		
		if(uslov)
		{
			SubjectPanel.br--;
			tx.setForeground(Color.RED);
		}
		
		if(SubjectPanel.br == 0)
		{
			SubjectPanel.ok_btn.setEnabled(true);
		}
		else
		{
			SubjectPanel.ok_btn.setEnabled(false);
		}
		
		if(tx.getText().equals(""))
			tx.setText("Obavezno polje");
	}
     
	
}
