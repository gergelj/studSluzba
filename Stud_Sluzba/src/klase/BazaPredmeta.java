package klase;

import java.awt.List;
import java.util.ArrayList;

public class BazaPredmeta {
	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance()
	{
		if(instance == null)
			instance = new BazaPredmeta();
		return instance;
	}
	
	private int generator;
	
	private ArrayList<Predmet> predmeti;
	private ArrayList<String>  kolone;
	
	private BazaPredmeta()
	{
		generator = 0;
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
		this.kolone.add("Profesor");
	}
	
	public String getValueAt(int red,int kolona)
	{
		Predmet predmet = this.predmeti.get(red);
		switch (kolona) {
		case 0:
			return predmet.getmSifraPredmeta();
		case 1:
			return predmet.getmNazivPredmeta();
		case 2: 
			return Integer.toString(predmet.getmGodinaIzvodjenja());
		case 3:
			return Integer.toString(predmet.getmSemestarPredmeta());
		/*case 4:
			return null*/
		default:
			return null;
		}
	}
	
	//public void addPredmet(String sifra, String naziv, Int god, Int semestar)
	
	public String getImeKolone(int index)
	{
		return this.kolone.get(index);
	}
	
	public Predmet getRed(int index_red)
	{
		return this.predmeti.get(index_red);
	}
	
	public ArrayList<Predmet> getPredmeti()
	{
		return predmeti;
	}
	
	public void setPredmeti(ArrayList<Predmet> predmeti) 
	{
		this.predmeti=predmeti;
	}
	
	private int generateId()
	{
		return generator++;
	}
	
	public int getBrojKolona()
	{
		return 5;
	}
	
}
