package klase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BazaProfesora implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4986906173029686936L;

	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance()
	{
		if(instance == null)
			instance = new BazaProfesora();
		return instance;
	}
	
	public static void setInstance(BazaProfesora db) {
		instance = db;
	}
	
	private int generator;
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private BazaProfesora()
	{
		generator = 0;
		this.profesori = new ArrayList<Profesor>();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add(StringResources.COLUMN_NAME);
		this.kolone.add(StringResources.COLUMN_SURNAME);
		this.kolone.add(StringResources.COLUMN_DATE_OF_BIRTH);
		this.kolone.add(StringResources.COLUMN_ADDRESS);
		this.kolone.add(StringResources.COLUMN_TELEPHONE);
		this.kolone.add(StringResources.COLUMN_EMAIL);
		this.kolone.add(StringResources.COLUMN_OFFICE_ADDRESS);
		this.kolone.add(StringResources.COLUMN_PROFESSOR_ID_NUM);
		this.kolone.add(StringResources.COLUMN_TITLE);
		this.kolone.add(StringResources.COLUMN_DEGREE);
		
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
		switch(index) {
		case 0: return StringResources.COLUMN_NAME;
		case 1: return StringResources.COLUMN_SURNAME;
		case 2: return StringResources.COLUMN_DATE_OF_BIRTH;
		case 3: return StringResources.COLUMN_ADDRESS;
		case 4: return StringResources.COLUMN_TELEPHONE;
		case 5: return StringResources.COLUMN_EMAIL;
		case 6: return StringResources.COLUMN_OFFICE_ADDRESS;
		case 7: return StringResources.COLUMN_PROFESSOR_ID_NUM;
		case 8: return StringResources.COLUMN_TITLE;
		case 9: return StringResources.COLUMN_DEGREE;
		}
		return null;
	}
	
	public Profesor getRow(int rowInd)
	{
		return this.profesori.get(rowInd);
	}
	
	public Object getValueAt(int row,int col)
	{
		Profesor profa = this.profesori.get(row);
		switch(col)
		{
		case 0:
			return profa.getmIme();
		case 1:
			return profa.getmPrezime();
		case 2:
			return profa.getmDatumRodjenja();
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
	
}
