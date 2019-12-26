package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import gui.StudentPanel;
import klase.Proveri;
import klase.StringResources;

public class StudentListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		JTextField tx = (JTextField) e.getComponent();
		if(tx.getForeground()==Color.RED) {
			tx.setForeground(Color.BLACK);
			tx.setText("");
		}
		
		String tekst = tx.getText();
		String name = tx.getName();
		boolean uslov = (!Proveri.isIme(tekst) && (name.equals("ime")||name.equals("prezime")))
				|| (!Proveri.isDatum(tekst) && (name.equals("datrodj")||name.equals("datupis")))
				|| (!Proveri.isAdresa(tekst) && name.equals("adresa"))
				|| (!Proveri.isTelefon(tekst) && name.equals("telefon"))
				|| (!Proveri.isEmail(tekst) && name.equals("email"))
				|| (!Proveri.isBrojIndeksa(tekst) && name.equals("indeks"))
				|| (!Proveri.isProsek(tekst) && name.equals("prosek"));
		
		if(uslov)
			StudentPanel.broj++;

	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField tx = (JTextField) e.getComponent();
		
		String tekst = tx.getText();
		String name = tx.getName();
		boolean uslov = (!Proveri.isIme(tekst) && (name.equals("ime")||name.equals("prezime")))
				|| (!Proveri.isDatum(tekst) && (name.equals("datrodj")||name.equals("datupis")))
				|| (!Proveri.isAdresa(tekst) && name.equals("adresa"))
				|| (!Proveri.isTelefon(tekst) && name.equals("telefon"))
				|| (!Proveri.isEmail(tekst) && name.equals("email"))
				|| (!Proveri.isBrojIndeksa(tekst) && name.equals("indeks"))
				|| (!Proveri.isProsek(tekst) && name.equals("prosek"));
		
		if(uslov) {
			StudentPanel.broj--;
			tx.setForeground(Color.RED);
		}
		
		if(StudentPanel.broj==0) {
			StudentPanel.ok_btn.setEnabled(true);
		}
		else {
			StudentPanel.ok_btn.setEnabled(false);
		}
		
		if(tx.getText().equals("")) {
			tx.setText(StringResources.REQUIRED_FIELD);
		}

	}

}
