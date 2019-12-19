package klase;

import java.util.HashMap;

public class Predmet {
	private String mSifraPredmeta;
	private String mNazivPredmeta;
	private int mSemestarPredmeta;
	private int mGodinaIzvodjenja;
	private Profesor mProfesor;
	private int id;
	private HashMap<Integer, Student> mListaStudenata; //mozda hashmap bude trebao
	
	public Predmet()
	{
		this.mListaStudenata = new HashMap<Integer, Student>();
	}
	
	public Predmet(String sifraPredmeta,String nazivPredmeta,int semestarPredmeta,int godinaIzvodjenja, int id)
	{
		this.mSifraPredmeta=sifraPredmeta;
		this.mNazivPredmeta=nazivPredmeta;
		this.mSemestarPredmeta=semestarPredmeta;
		this.mGodinaIzvodjenja=godinaIzvodjenja;
		this.id = id;
		this.mListaStudenata = new HashMap<Integer, Student>();
	}
	
	public Predmet(String sifraPredmeta,String nazivPredmeta,int semestarPredmeta,int godinaIzvodjenja,Profesor profesor,int id,HashMap<Integer, Student> listaStudenata)
	{
		this.mSifraPredmeta=sifraPredmeta;
		this.mNazivPredmeta=nazivPredmeta;
		this.mSemestarPredmeta=semestarPredmeta;
		this.mGodinaIzvodjenja=godinaIzvodjenja;
		this.mProfesor=profesor;
		this.id=id;
		this.mListaStudenata=listaStudenata; //koji pohadjaju predmet
	}
	//verovatno ce trebati u nekom trenutku
	public String getmSifraPredmeta() {
		return mSifraPredmeta;
	}
	public void setmSifraPredmeta(String mSifraPredmeta) {
		this.mSifraPredmeta = mSifraPredmeta;
	}
	public String getmNazivPredmeta() {
		return mNazivPredmeta;
	}
	public void setmNazivPredmeta(String mNazivPredmeta) {
		this.mNazivPredmeta = mNazivPredmeta;
	}
	public int getmSemestarPredmeta() {
		return mSemestarPredmeta;
	}
	public void setmSemestarPredmeta(int mSemestarPredmeta) {
		this.mSemestarPredmeta = mSemestarPredmeta;
	}
	public int getmGodinaIzvodjenja() {
		return mGodinaIzvodjenja;
	}
	public void setmGodinaIzvodjenja(int mGodinaIzvodjenja) {
		this.mGodinaIzvodjenja = mGodinaIzvodjenja;
	}
	public Profesor getmProfesor() {
		return mProfesor;
	}
	public void setmProfesor(Profesor mProfesor) {
		this.mProfesor = mProfesor;
	}
	public HashMap<Integer, Student> getmListaStudenata() {
		return mListaStudenata;
	}
	public void setmListaStudenata(HashMap<Integer, Student> mListaStudenata) {
		this.mListaStudenata = mListaStudenata;
	}	
	
	public int getId()
	{
		return this.id;
	}
	
	public void addStudent(Student s) {
		this.mListaStudenata.put(s.getId(), s);
	}
	
	public void removeStudent(Student s) {
		this.mListaStudenata.remove(s.getId());
	}
	
	public void addProfesor(Profesor p)
	{
		this.mProfesor=p;
	}
	
	public void removeProfesor()
	{
		this.mProfesor=null;
	}
	
	@Override
	public String toString() {
		return mSifraPredmeta + " - " + mNazivPredmeta;
	}
}
