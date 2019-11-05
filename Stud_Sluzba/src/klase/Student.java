package klase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Student {

	private String mIme, mPrezime;
	private LocalDate mDatumRodjenja, mDatumUpisa;
	private String mAdresa, mTelefon, mEmail;
	private String mBrojIndeksa;
	private int mTrenutnaGodina;
	private Status mStatus;
	private double mProsek;
	private ArrayList<Predmet> mSpisakPredmeta; //mozda HashMap je bolji izbor ovde, videcemo
	
	public Student() {
		this.mSpisakPredmeta = new ArrayList<Predmet>();
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, ArrayList<Predmet> spisakpredmeta) {
		this.mIme = ime;
		this.mPrezime = prezime;
		this.mDatumRodjenja = LocalDate.parse(datumrodj, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.mAdresa = adresa;
		this.mTelefon = telefon;
		this.mEmail = email;
		this.mBrojIndeksa = brojindeksa;
		this.mDatumUpisa = LocalDate.parse(datumupisa, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.mStatus = status;
		this.mTrenutnaGodina = trenutnagodina;
		this.mProsek = prosek;
		this.mSpisakPredmeta = spisakpredmeta;
	}

	@Override
	public String toString() {
		//npr.
		return "Student:\n" + "Ime: " + mIme + "\nPrezime: " + mPrezime + "\nDatum rodjenja: " + mDatumRodjenja + "\nStatus: " +  mStatus;
	}
	
}
