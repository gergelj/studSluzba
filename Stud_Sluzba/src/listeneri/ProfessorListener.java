package listeneri;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import gui.ProfessorPanel;
import klase.Proveri;
import klase.StringResources;

public class ProfessorListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {

		JTextField tx = (JTextField) e.getComponent();
		if(tx.getForeground()==Color.RED) 
		{
			tx.setForeground(Color.BLACK);
			tx.setText("");
		}
		
		String tekst = tx.getText();
		String name = tx.getName();
		
		boolean uslov = (!Proveri.isIme(tekst) && (name.equals("ime")||name.equals("prezime")))
				      ||(!Proveri.isDatum(tekst) && name.equals("dat rodj"))
				      ||(!Proveri.isAdresa(tekst) && (name.equals("adresa")||name.equals("adresa kanc")))
				      ||(!Proveri.isTelefon(tekst) && name.equals("telefon"))
				      ||(!Proveri.isEmail(tekst) && name.equals("email"))
				      ||(!Proveri.isBrojLK(tekst) && name.equals("brlk"))
				      ||(!Proveri.isTitulaOrZvanje(tekst) && (name.equals("titula")||name.equals("zvanje")));
		if(uslov) {
			ProfessorPanel.br++;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField tx = (JTextField) e.getComponent();
		
		String tekst = tx.getText();
		String name = tx.getName();
		boolean uslov = (!Proveri.isIme(tekst) && (name.equals("ime")||name.equals("prezime")))
			      ||(!Proveri.isDatum(tekst) && name.equals("dat rodj"))
			      ||(!Proveri.isAdresa(tekst) && (name.equals("adresa")||name.equals("adresa kanc")))
			      ||(!Proveri.isTelefon(tekst) && name.equals("telefon"))
			      ||(!Proveri.isEmail(tekst) && name.equals("email"))
			      ||(!Proveri.isBrojLK(tekst) && name.equals("brlk"))
			      ||(!Proveri.isTitulaOrZvanje(tekst) && (name.equals("titula")||name.equals("zvanje")));

		if(uslov)
		{
			ProfessorPanel.br--;
			tx.setForeground(Color.RED);
		}
		
		if(ProfessorPanel.br == 0)
		{
			ProfessorPanel.ok_btn.setEnabled(true);
		}
		else
		{
			ProfessorPanel.ok_btn.setEnabled(false);
		}
		
		if(tx.getText().equals(""))
			tx.setText(StringResources.REQUIRED_FIELD);
		
	}

}
