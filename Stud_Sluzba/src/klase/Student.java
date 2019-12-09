package klase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Student {

	private int id;
	public enum Status {B, S};
	private String ime, prezime;
	private LocalDate datumRodjenja, datumUpisa;
	private String adresa, telefon, email;
	private String brojIndeksa;
	private int trenutnaGodina;
	private Status status;
	private double prosek;
	private ArrayList<Predmet> spisakPredmeta; //mozda HashMap je bolji izbor ovde, videcemo
	
	public Student() {
		this.spisakPredmeta = new ArrayList<Predmet>();
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc) {
		this.spisakPredmeta = new ArrayList<Predmet>();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = LocalDate.parse(datumrodj, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.brojIndeksa = brojindeksa;
		this.datumUpisa = LocalDate.parse(datumupisa, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.status = status;
		this.trenutnaGodina = trenutnagodina;
		this.prosek = prosek;
		this.id = internikljuc;
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc, ArrayList<Predmet> spisakpredmeta) {
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = LocalDate.parse(datumrodj, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.brojIndeksa = brojindeksa;
		this.datumUpisa = LocalDate.parse(datumupisa, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.status = status;
		this.trenutnaGodina = trenutnagodina;
		this.prosek = prosek;
		this.spisakPredmeta = spisakpredmeta;
		this.id = internikljuc;
	}

	@Override
	public String toString() {
		//npr.
		return "Student:\n" + "Ime: " + ime + "\nPrezime: " + prezime + "\nDatum rodjenja: " + datumRodjenja + "\nStatus: " +  status;
	}

	public int getId() {
		return this.id;
	}
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public String getDatumRodjenja(int i) {
		return this.datumRodjenja.format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
	}
	
	public String getDatumUpisa(int i) {
		return this.datumUpisa.format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = LocalDate.parse(datumRodjenja, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
	}

	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	
	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = LocalDate.parse(datumUpisa, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}

	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	
}
