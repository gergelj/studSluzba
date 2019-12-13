package klase;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor {
	private String mIme;
	private String mPrezime;
	private LocalDate mDatumRodjenja;
	private String mAdresaStanovanja;
	private String mTelefon;
	private String mEmail;
	private String mAdresaKancelarije;
	private String mBrojLK; //ima 13 cifara
	private String mTitula;
	private String mZvanje;
	private ArrayList<Predmet> mListaPredmeta; //na kojima predaje
	
	public Profesor()
	{
		this.mListaPredmeta = new ArrayList<Predmet>();
	}
	
	
	
	public Profesor(String mIme, String mPrezime, LocalDate mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje,ArrayList<Predmet> mListaPredmeta) {
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
		this.mListaPredmeta = mListaPredmeta;
	}

	//verovatno ce trebaati kasnije tokom pravljenja
	public String getmIme() {
		return mIme;
	}
	public void setmIme(String mIme) {
		this.mIme = mIme;
	}
	public String getmPrezime() {
		return mPrezime;
	}
	public void setmPrezime(String mPrezime) {
		this.mPrezime = mPrezime;
	}
	public LocalDate getmDatumRodjenja() {
		return mDatumRodjenja;
	}
	public void setmDatumRodjenja(LocalDate mDatumRodjenja) {
		this.mDatumRodjenja = mDatumRodjenja;
	}
	public String getmAdresaStanovanja() {
		return mAdresaStanovanja;
	}
	public void setmAdresaStanovanja(String mAdresaStanovanja) {
		this.mAdresaStanovanja = mAdresaStanovanja;
	}
	public String getmTelefon() {
		return mTelefon;
	}
	public void setmTelefon(String mTelefon) {
		this.mTelefon = mTelefon;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmAdresaKancelarije() {
		return mAdresaKancelarije;
	}
	public void setmAdresaKancelarije(String mAdresaKancelarije) {
		this.mAdresaKancelarije = mAdresaKancelarije;
	}
	public String getmBrojLK() {
		return mBrojLK;
	}
	public void setmBrojLK(String mBrojLK) {
		this.mBrojLK = mBrojLK;
	}
	public String getmTitula() {
		return mTitula;
	}
	public void setmTitula(String mTitula) {
		this.mTitula = mTitula;
	}
	public String getmZvanje() {
		return mZvanje;
	}
	public void setmZvanje(String mZvanje) {
		this.mZvanje = mZvanje;
	}
	public ArrayList<Predmet> getmListaPredmeta() {
		return mListaPredmeta;
	}
	public void setmListaPredmeta(ArrayList<Predmet> mListaPredmeta) {
		this.mListaPredmeta = mListaPredmeta;
	}	
	
	public String getImeiPrezime()
	{
		return mIme+" "+mPrezime;
	}
}
