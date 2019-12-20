package klase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BazaProfesora {
	
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance()
	{
		if(instance == null)
			instance = new BazaProfesora();
		return instance;
	}
	
	private int generator;
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private BazaProfesora()
	{
		generator = 0;
		initProfesori();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DAT. RODJ.");
		this.kolone.add("ADRESA");
		this.kolone.add("TELEFON");
		this.kolone.add("E-MAIL");
		this.kolone.add("ADR. KANC.");
		this.kolone.add("BR. LK.");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
		
	}
	
	private void initProfesori()
	{
		this.profesori = new ArrayList<Profesor>();
		
		profesori.add(new Profesor("Nebojsa", "Ralevic", "05.12.1900.", "Novi Sad", "0147852369", "nebojsa@ralevic.com", "Kula-625", "0123456", "phD", "redovni profesor", generateId()));
		profesori.add(new Profesor("Milan", "Rapaic", "18.04.1980.", "Ruma", "15874965230", "milan@rapaic.rs", "K125", "4578963", "phD", "profesor", generateId()));
	}
	
	public List<Profesor> getProfesori()
	{
		return profesori;
	}
	
	private int generateId()
	{
		return ++generator;
	}
	
	public int getColumnCount()
	{
		return kolone.size();
	}
	
	public String getColumnName(int index)
	{
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowInd)
	{
		return this.profesori.get(rowInd);
	}
	
	public String getValueAt(int row,int col)
	{
		Profesor profa = this.profesori.get(row);
		switch(col)
		{
		case 0:
			return profa.getmIme();
		case 1:
			return profa.getmPrezime();
		case 2:
			return profa.getmDatumRodjenja(0);
		case 3:
			return profa.getmAdresaStanovanja();
		case 4:
			return profa.getmTelefon();
		case 5:
			return profa.getmEmail();
		case 6: 
			return profa.getmAdresaKancelarije();
		case 7:
			return profa.getmBrojLK();
		case 8:
			return profa.getmTitula();
		case 9:
			return profa.getmZvanje();
		default:
			return null;	
		}
	}
	
	public void dodajProfesor(String mIme, String mPrezime, String mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje)
	{
		this.profesori.add(new Profesor(mIme, mPrezime, mDatumRodjenja, mAdresaStanovanja,  mTelefon, mEmail, mAdresaKancelarije, mBrojLK, mTitula, mZvanje,generateId()));
	}
	
	public void izbrisiProfesor(int id)
	{
		for(Profesor i: profesori)
			if(i.getId() == id)
			{
				profesori.remove(i);
				break;
			}
	}
	
	public void izmeniProfesora(String mIme, String mPrezime, String mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje,int id)
	{
		for(Profesor i: profesori)
		{
			if(i.getId()==id)
			{
				i.setmIme(mIme);
				i.setmPrezime(mPrezime);
				i.setmDatumRodjenja(mDatumRodjenja);
				i.setmAdresaStanovanja(mAdresaStanovanja);
				i.setmTelefon(mTelefon);
				i.setmEmail(mEmail);
				i.setmAdresaKancelarije(mAdresaKancelarije);
				i.setmBrojLK(mBrojLK);
				i.setmTitula(mTitula);
				i.setmZvanje(mZvanje);
				
				break;
			}
		}
	}
	
	public Profesor lookup_profesor(String brlk)
	{
		for(Profesor i: profesori)
			if(i.getmBrojLK().equals(brlk))
				return i;
		return null;
	}
	
	public void deleteAllInstancesOfSubject(Predmet p) {
		for(Profesor pf : profesori) {
			pf.getmListaPredmeta().remove(p.getId());
		}
	}
	
	public void sort(int column, boolean isAscending) {
		if(isAscending)
			Collections.sort(this.getProfesori(), Profesor.compareBy(column));
		else
			Collections.sort(this.getProfesori(), Profesor.compareBy(column).reversed());
	}
	
	public void unsort() {
		Collections.sort(this.getProfesori(), Profesor.compareById());
	}
	
}
