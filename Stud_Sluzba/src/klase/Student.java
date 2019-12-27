package klase;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Student extends Osoba implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7797006099152643143L;

	public enum Status {B, S};
	private LocalDate datumUpisa; 
	private String brojIndeksa;
	private int trenutnaGodina;
	private Status status;
	private double prosek;
	private HashMap<Integer, Predmet> spisakPredmeta;
	
	public Student() {
		super();
		this.spisakPredmeta = new HashMap<Integer, Predmet>();
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc) {
		super(internikljuc, ime, prezime, datumrodj, adresa, telefon, email);
		this.spisakPredmeta = new HashMap<Integer, Predmet>();
		this.brojIndeksa = brojindeksa;
		this.datumUpisa = LocalDate.parse(datumupisa, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
		this.status = status;
		this.trenutnaGodina = trenutnagodina;
		this.prosek = prosek;
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc, HashMap<Integer, Predmet> spisakpredmeta) {
		super(internikljuc, ime, prezime, datumrodj, adresa, telefon, email);
		this.brojIndeksa = brojindeksa;
		this.datumUpisa = LocalDate.parse(datumupisa, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
		this.status = status;
		this.trenutnaGodina = trenutnagodina;
		this.prosek = prosek;
		this.spisakPredmeta = spisakpredmeta;
	}

	@Override
	public String toString() {
		//treba kod prikaza studenata u JListu kada dodamo na predmet
		return this.brojIndeksa + " " + super.getIme() + " " + super.getPrezime() + ", " + this.trenutnaGodina + StringResources.NTH_YEAR;
	}

	public String getDatumUpisa(int i) {
		return this.datumUpisa.format(DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
	}

	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	
	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = LocalDate.parse(datumUpisa, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa.toLowerCase();
	}
	
	public void setStatus(String status) {
		this.status = status.equalsIgnoreCase("b") ? Status.B : Status.S;
	}

	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}

	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}
	
	public void setGodina(String godina) {
		this.trenutnaGodina = Integer.parseInt(godina);
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
	
	public void setProsek(String prosek) {
		this.prosek = Double.parseDouble(prosek);
	}

	public HashMap<Integer, Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(HashMap<Integer, Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	
	public void addPredmet(Predmet p) {
		this.spisakPredmeta.put(p.getId(), p);
	}
	
	public void removePredmet(Predmet p) {
		this.spisakPredmeta.remove(p.getId());
	}
	
}
