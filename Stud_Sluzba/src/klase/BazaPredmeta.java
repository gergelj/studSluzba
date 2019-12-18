package klase;


import java.util.ArrayList;
import java.util.List;


public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance()
	{
		if(instance == null)
			instance = new BazaPredmeta();
		return instance;
	}
	private int generator;
	
	private List<Predmet> predmeti;
	private List<String> kolone;

	
	private BazaPredmeta()
	{
		generator = 0;
		initPredmeti();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("GODINA");
		this.kolone.add("SEMESTAR");
		this.kolone.add("PROFESOR");
	}
	
	//TODO: treba implementirati da se ucita sacuvana baza iz fajla
	private void initPredmeti()
	{
		this.predmeti = new ArrayList<Predmet>();
	}
	
	private int generateId()
	{
		return ++generator;
	}
	
	public List<Predmet> getPredmeti()
	{
		return predmeti;
	}
	
	public void setPredmeti(List<Predmet> predmeti)
	{
		this.predmeti = predmeti;
	}
	
	public int getColumnCount()
	{
		return kolone.size();
	}
	
	public String getColumnName(int i)
	{
		return this.kolone.get(i);
	}
	
	public Predmet getRow(int i)
	{
		return this.predmeti.get(i);
	}
	
	public String getValueAt(int row, int column)
	{
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getmSifraPredmeta();
		case 1:
			return predmet.getmNazivPredmeta();
		case 2:
			return String.valueOf(predmet.getmGodinaIzvodjenja());
		case 3:
			return String.valueOf(predmet.getmSemestarPredmeta());
		case 4:
		{
			if(predmet.getmProfesor()==null)
				return "Profesor nije dodat";
			else
				return predmet.getmProfesor().getImeiPrezime();
		}
	    default:
	    	return null;
		}
	}
	
	public void dodajPredmet(String sifraPredmeta,String nazivPredmeta,int semestarPredmeta,int godinaIzvodjenja)
	{
		this.predmeti.add(new Predmet(sifraPredmeta,nazivPredmeta,semestarPredmeta,godinaIzvodjenja, generateId()));
	}
	
	public void izbrisiPredmet(int id)
	{
		for(Predmet i: predmeti)
		{
			if(i.getId() == id)
			{
				predmeti.remove(i);
				break;
			}
		}
	}
	
	public void IzmeniPredmet(String sifraPredmeta,String nazivPredmeta,int semestarPredmeta,int godinaIzvodjenja,int id)
	{
		for(Predmet i: predmeti)
		{
			if(i.getId() == id) {
				i.setmSifraPredmeta(sifraPredmeta);
				i.setmNazivPredmeta(nazivPredmeta);
				i.setmSemestarPredmeta(semestarPredmeta);
				i.setmGodinaIzvodjenja(godinaIzvodjenja);
				
				break;
			}
		}
	}
	
	public Predmet lookup_predmet(String sifraPredmeta)
	{
		for(Predmet i: predmeti)
		{
			if(i.getmSifraPredmeta().equals(sifraPredmeta))
				return i;
		}
		return null;
	}
	
	public void deleteAllInstanceOfStudent(Student s) {
		for(Predmet p : predmeti) {
			p.getmListaStudenata().remove(s.getId());
		}
	}
	
	public void deleteAllInstanceOfProfessor(Profesor pf) {
		for(Predmet p : predmeti) {
			if(p.getmProfesor().getId() == pf.getId()) {
				p.setmProfesor(null);
			}
		}
	}
}
