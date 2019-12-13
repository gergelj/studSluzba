package klase;

import java.util.ArrayList;

public class Predmet {
	private String mSifraPredmeta;
	private String mNazivPredmeta;
	private int mSemestarPredmeta;
	private int mGodinaIzvodjenja;
	private Profesor mProfesor;
	private int id;
	private ArrayList<Student> mListaStudenata; //mozda hashmap bude trebao
	
	public Predmet()
	{
		this.mListaStudenata = new ArrayList<Student>();
	}
	
	public Predmet(String sifraPredmeta,String nazivPredmeta,int semestarPredmeta,int godinaIzvodjenja, int id)
	{
		this.mSifraPredmeta=sifraPredmeta;
		this.mNazivPredmeta=nazivPredmeta;
		this.mSemestarPredmeta=semestarPredmeta;
		this.mGodinaIzvodjenja=godinaIzvodjenja;
		this.id = id;
	}
	
	public Predmet(String sifraPredmeta,String nazivPredmeta,int semestarPredmeta,int godinaIzvodjenja,Profesor profesor,int id,ArrayList<Student> listaStudenata)
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
	public ArrayList<Student> getmListaStudenata() {
		return mListaStudenata;
	}
	public void setmListaStudenata(ArrayList<Student> mListaStudenata) {
		this.mListaStudenata = mListaStudenata;
	}	
	
	public int getId()
	{
		return this.id;
	}
}
