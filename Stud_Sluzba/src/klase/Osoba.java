package klase;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Osoba implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6430628550835861435L;
	
	protected int id;
	protected String ime, prezime;
	protected LocalDate datumRodjenja;
	protected String adresa, telefon, email;
	
	public Osoba() {}
	
	public Osoba(int id, String ime, String prezime, String datumRodjenja, String adresa, String telefon,
			String email) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = LocalDate.parse(datumRodjenja, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public String getImeiPrezime()
	{
		return ime + " " + prezime;
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
		return this.datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = LocalDate.parse(datumRodjenja, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
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
}
