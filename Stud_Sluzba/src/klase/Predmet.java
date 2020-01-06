package klase;

import java.io.Serializable;
import java.util.HashMap;

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
	
	public String format() {
		StringBuilder stringBuilder = new StringBuilder();
		String returnValue = mSifraPredmeta + "|" + mNazivPredmeta + "|" + mSemestarPredmeta + "|" + mGodinaIzvodjenja + "|" + id + "|" + (mProfesor==null ? "-1" : mProfesor.getId()) + "|";
		stringBuilder.append(returnValue);

		if(mListaStudenata.isEmpty()) {
			stringBuilder.append("-1");
		}
		else {
			for (Integer id : mListaStudenata.keySet()) {
				stringBuilder.append(id + ",");
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1); // delete last ','
		}

		return stringBuilder.toString();
	}
	
	public static String getFormattedHeader() {
		return String.format("%-20.20s %-30.30s %-15.15s %-15.15s", StringResources.COLUMN_SUBJECT_ID, StringResources.COLUMN_SUBJECT_TITLE, StringResources.COLUMN_SEMESTER, StringResources.COLUMN_YEAR);
	}
	
	public String getShortReport() {
		return String.format("%-20.20s %-30.30s %-15d %-15d", mSifraPredmeta, mNazivPredmeta, mSemestarPredmeta, mGodinaIzvodjenja);
	}
	
	public String getLongReport() {
		
		String predmet = StringResources.COLUMN_SUBJECT_ID + ":\t" + mSifraPredmeta + "\n" + 
						StringResources.COLUMN_SUBJECT_TITLE + ":\t" + mNazivPredmeta + "\n\n" +
						StringResources.COLUMN_SEMESTER + ":\t" + mSemestarPredmeta + "\n" +
						StringResources.COLUMN_YEAR + ":\t" + mGodinaIzvodjenja + "\n\n" +
						StringResources.COLUMN_PROFESSOR + ":\n";
		StringBuilder predmetRep = new StringBuilder();
		predmetRep.append(predmet);
		
		if(mProfesor == null)
			predmetRep.append(StringResources.NO_PROFESSOR + "\n\n");
		else
			predmetRep.append(mProfesor.getShortReport());
		
		if(mListaStudenata.isEmpty()) {
			predmetRep.append(StringResources.NO_STUDENTS);
		}
		else {
			predmetRep.append("\n" + StringResources.COLUMN_STUDENTS + "\n\n" + Student.getFormattedHeader() + "\n\n");
			
			for(Student s : mListaStudenata.values())
				predmetRep.append(s.getShortReport() + "\n");
		}
		
		return predmetRep.toString();
	}
}
