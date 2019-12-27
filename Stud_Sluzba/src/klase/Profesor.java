package klase;

import java.io.Serializable;
import java.util.HashMap;

public class Profesor extends Osoba implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4271025937883311154L;
	
	private String adresaKancelarije;
	private String brojLK; //ima 13 cifara
	private String titula;
	private String zvanje;
	private HashMap<Integer, Predmet> listaPredmeta;
	
	public Profesor()
	{
		super();
		this.listaPredmeta = new HashMap<Integer, Predmet>();
	}
	
/*	public Profesor(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String telefon,String email, String adresaKancelarije, String brojLK, String titula, String zvanje,int id,HashMap<Integer, Predmet> listaPredmeta) {
		super(id, ime, prezime, );
		this.mIme = mIme;
		this.mPrezime = mPrezime;
		this.mDatumRodjenja = mDatumRodjenja;
		this.mAdresaStanovanja = mAdresaStanovanja;
		this.mTelefon = mTelefon;
		this.mEmail = mEmail;
		this.mAdresaKancelarije = mAdresaKancelarije;
		this.mBrojLK = mBrojLK;
		this.mTitula = mTitula;
		this.mZvanje = mZvanje;
		this.mListaPredmeta = mListaPredmeta;
		this.id = id;
	}
	
	public Profesor(String mIme, String mPrezime, LocalDate mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje,int id) {
		super();
		this.mIme = mIme;
		this.mPrezime = mPrezime;
		this.mDatumRodjenja = mDatumRodjenja;
		this.mAdresaStanovanja = mAdresaStanovanja;
		this.mTelefon = mTelefon;
		this.mEmail = mEmail;
		this.mAdresaKancelarije = mAdresaKancelarije;
		this.mBrojLK = mBrojLK;
		this.mTitula = mTitula;
		this.mZvanje = mZvanje;
		this.id = id;
		this.mListaPredmeta = new HashMap<Integer, Predmet>();
	}*/
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String telefon,String email, String adresaKancelarije, String brojLK, String titula, String zvanje,int id) {
		super(id, ime, prezime, datumRodjenja, adresaStanovanja, telefon, email);
		this.adresaKancelarije = adresaKancelarije;
		this.brojLK = brojLK;
		this.titula = titula;
		this.zvanje = zvanje;
		this.listaPredmeta = new HashMap<Integer, Predmet>();
	}


	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public String getBrojLK() {
		return brojLK;
	}
	public void setBrojLK(String brojLK) {
		this.brojLK = brojLK;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public HashMap<Integer, Predmet> getListaPredmeta() {
		return listaPredmeta;
	}
	public void setListaPredmeta(HashMap<Integer, Predmet> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}	
	
	public void addPredmet(Predmet p)
	{
		this.listaPredmeta.put(p.getId(), p);
	}
	
	public void removePredmet(Predmet p)
	{
		this.listaPredmeta.remove(p.getId());
	}
	
	@Override
	public String toString() {
		//treba kod prikaza profesora u JListu kada dodamo na predmet
		return this.brojLK + " " + super.getImeiPrezime();
	}
}
