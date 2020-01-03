package klase;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class BazaPredmeta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8812210980693909776L;

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance()
	{
		if(instance == null)
			instance = new BazaPredmeta();
		return instance;
	}
	
	public static void setInstance(BazaPredmeta db) {
		instance = db;
	}
	
	private int generator;
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private BazaPredmeta()
	{
		generator = 0;
		this.predmeti = new ArrayList<Predmet>();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add(StringResources.COLUMN_SUBJECT_ID);
		this.kolone.add(StringResources.COLUMN_SUBJECT_TITLE);
		this.kolone.add(StringResources.COLUMN_YEAR);
		this.kolone.add(StringResources.COLUMN_SEMESTER);
		this.kolone.add(StringResources.COLUMN_PROFESSOR);
		

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
		switch(i) {
		case(0): return StringResources.COLUMN_SUBJECT_ID;
		case(1): return StringResources.COLUMN_SUBJECT_TITLE;
		case(2): return StringResources.COLUMN_YEAR;
		case(3): return StringResources.COLUMN_SEMESTER;
		case(4): return StringResources.COLUMN_PROFESSOR;
		}
		return null;
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
				return StringResources.NO_PROFESSOR;
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
		for(Predmet p : this.predmeti) {
			//TODO: remove student from every subject
			
			
		}
		
		
		/*
		for(Predmet p : s.getSpisakPredmeta().values()) {
			p.getmListaStudenata().remove(s.getId());
		}
		*/
	}
	
	public void deleteAllInstanceOfProfessor(Profesor pf) {
		for(Predmet p : pf.getListaPredmeta().values()) {
			p.setmProfesor(null);
		}
	}
	
	public Predmet getPredmetById(int id) {
		for(Predmet p : predmeti) {
			if(id == p.getId())
				return p;
		}
		return null;
	}
}
