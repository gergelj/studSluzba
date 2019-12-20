package klase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

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
	private HashMap<Integer, Predmet> spisakPredmeta; //mozda HashMap je bolji izbor ovde, videcemo
	public static List<Comparator<Student>> compare;
	
	public Student() {
		this.spisakPredmeta = new HashMap<Integer, Predmet>();
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc) {
		this.spisakPredmeta = new HashMap<Integer, Predmet>();
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
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc, HashMap<Integer, Predmet> spisakpredmeta) {
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
	
	static {
		Student.compare = new ArrayList<Comparator<Student>>();
		
		compare.add((Student s1, Student s2) -> s1.getBrojIndeksa().compareTo(s2.getBrojIndeksa()));
		compare.add((Student s1, Student s2) -> s1.getIme().compareTo(s2.getIme()));
		compare.add((Student s1, Student s2) -> s1.getPrezime().compareTo(s2.getPrezime()));
		compare.add((Student s1, Student s2) -> s1.getDatumRodjenja().compareTo(s2.getDatumRodjenja()));
		compare.add((Student s1, Student s2) -> s1.getAdresa().compareTo(s2.getAdresa()));
		compare.add((Student s1, Student s2) -> s1.getTelefon().compareTo(s2.getTelefon()));
		compare.add((Student s1, Student s2) -> s1.getEmail().compareTo(s2.getEmail()));
		compare.add((Student s1, Student s2) -> s1.getDatumUpisa().compareTo(s2.getDatumUpisa()));
		compare.add((Student s1, Student s2) -> ((Integer)s1.getTrenutnaGodina()).compareTo(s2.getTrenutnaGodina()));
		compare.add((Student s1, Student s2) -> s1.getStatus().compareTo(s2.getStatus()));
		compare.add((Student s1, Student s2) -> ((Double)s1.getProsek()).compareTo(s2.getProsek()));
		//compare.add((Student s1, Student s2) -> ((Integer)s1.getId()).compareTo(s2.getId()));
	}
	
	public static Comparator<Student> compareBy(int index){
		return Student.compare.get(index);
	}
	
	public static Comparator<Student> compareById(){
		return (Student s1, Student s2) -> ((Integer)s1.getId()).compareTo(s2.getId());
	}

	@Override
	public String toString() {
		//treba kod prikaza studenata u JListu kada dodamo na predmet
		return this.brojIndeksa + " " + this.ime + " " + this.prezime + ", " + this.trenutnaGodina + ". godina";
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
