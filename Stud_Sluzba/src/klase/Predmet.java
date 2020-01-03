package klase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Predmet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 206583722328438418L;
	private String mSifraPredmeta;
	private String mNazivPredmeta;
	private int mSemestarPredmeta;
	private int mGodinaIzvodjenja;
	private Profesor mProfesor;
	private int id;
	private HashMap<Integer, Student> mListaStudenata; //mozda hashmap bude trebao
	private List<Integer> listaStudenata;
	
	public Predmet()
	{
		this.mListaStudenata = new HashMap<Integer, Student>();
		this.listaStudenata = new ArrayList<Integer>();
	}
	
	public Predmet(String sifraPredmeta,String nazivPredmeta,int semestarPredmeta,int godinaIzvodjenja, int id)
	{
		this.mSifraPredmeta=sifraPredmeta;
		this.mNazivPredmeta=nazivPredmeta;
		this.mSemestarPredmeta=semestarPredmeta;
		this.mGodinaIzvodjenja=godinaIzvodjenja;
		this.id = id;
		this.mListaStudenata = new HashMap<Integer, Student>();
		this.listaStudenata = new ArrayList<Integer>();
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
	public List<Integer> getListaStudenata(){
		return this.listaStudenata;
	}
	
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
		this.listaStudenata.add(s.getId());
	}
	
	public void removeStudent(Student s) {
		for(int i=0; i<this.listaStudenata.size(); i++)
			if(listaStudenata.get(i) == s.getId()) {
				listaStudenata.remove(i);
				return;
			}
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
