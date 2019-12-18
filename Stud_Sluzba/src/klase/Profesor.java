package klase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Profesor {
	private int id;
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
	private HashMap<Integer, Predmet> mListaPredmeta; //na kojima predaje
	
	public Profesor()
	{
		this.mListaPredmeta = new HashMap<Integer, Predmet>();
	}
	
	
	
	public Profesor(String mIme, String mPrezime, LocalDate mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje,int id,HashMap<Integer, Predmet> mListaPredmeta) {
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
	}
	public Profesor(String mIme, String mPrezime, String mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje,int id) {
		super();
		this.mIme = mIme;
		this.mPrezime = mPrezime;
		this.mDatumRodjenja = LocalDate.parse(mDatumRodjenja, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.mAdresaStanovanja = mAdresaStanovanja;
		this.mTelefon = mTelefon;
		this.mEmail = mEmail;
		this.mAdresaKancelarije = mAdresaKancelarije;
		this.mBrojLK = mBrojLK;
		this.mTitula = mTitula;
		this.mZvanje = mZvanje;
		this.id = id;
		this.mListaPredmeta = new HashMap<Integer, Predmet>();
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
	
	public String getmDatumRodjenja(int i)
	{
		return this.mDatumRodjenja.format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")); 
	}
	public void setmDatumRodjenja(LocalDate mDatumRodjenja) {
		this.mDatumRodjenja = mDatumRodjenja;
	}
	
	public void setmDatumRodjenja(String mDatumRodjenja)
	{
		this.mDatumRodjenja = LocalDate.parse(mDatumRodjenja, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
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
	public HashMap<Integer, Predmet> getmListaPredmeta() {
		return mListaPredmeta;
	}
	public void setmListaPredmeta(HashMap<Integer, Predmet> mListaPredmeta) {
		this.mListaPredmeta = mListaPredmeta;
	}	
	
	public String getImeiPrezime()
	{
		return mIme+" "+mPrezime;
	}
	
	public int getId()
	{
		return this.id;
	}
}
