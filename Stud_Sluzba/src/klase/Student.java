package klase;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import controller.LanguageController;

public class Student extends Osoba implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7797006099152643143L;

	public enum Status {B, S};
	private LocalDate datumUpisa; 
	private BrojIndeksa brojIndeksa;
	private int trenutnaGodina;
	private Status status;
	private double prosek;
	private HashMap<Integer, Predmet> listaPredmeta;
	
	public Student() {
		super();
		this.listaPredmeta = new HashMap<Integer, Predmet>();
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc) {
		super(internikljuc, ime, prezime, datumrodj, adresa, telefon, email);
		this.listaPredmeta = new HashMap<Integer, Predmet>();
		this.brojIndeksa = new BrojIndeksa(brojindeksa); // = brojIndeksa;
		this.datumUpisa = LocalDate.parse(datumupisa, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
		this.status = status;
		this.trenutnaGodina = trenutnagodina;
		this.prosek = prosek;
	}
	
	public Student(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Status status, double prosek, int internikljuc, HashMap<Integer, Predmet> listaPredmeta) {
		super(internikljuc, ime, prezime, datumrodj, adresa, telefon, email);
		this.brojIndeksa = new BrojIndeksa(brojindeksa); //= brojindeksa;
		this.datumUpisa = LocalDate.parse(datumupisa, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
		this.status = status;
		this.trenutnaGodina = trenutnagodina;
		this.prosek = prosek;
		this.listaPredmeta = listaPredmeta;
	}

	public String format() {
		String datumR = null;
		String datumU = null;
		
		switch(LanguageController.getInstance().getLanguage()) {
		case(0):{
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.SERBIAN_DATEFORMAT));
			datumU = datumUpisa.format(DateTimeFormatter.ofPattern(StringResources.SERBIAN_DATEFORMAT));
		} break;
		case(1):{
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.HUNGARIAN_DATEFORMAT));
			datumU = datumUpisa.format(DateTimeFormatter.ofPattern(StringResources.HUNGARIAN_DATEFORMAT));
		} break;
		case(2):{
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.ENGLISH_DATEFORMAT));
			datumU = datumUpisa.format(DateTimeFormatter.ofPattern(StringResources.ENGLISH_DATEFORMAT));
		} break;
		case(3):{
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.GERMAN_DATEFORMAT));
			datumU = datumUpisa.format(DateTimeFormatter.ofPattern(StringResources.GERMAN_DATEFORMAT));
		}break;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String returnValue = ime + "|" + prezime + "|" + datumR + "|" + adresa + "|" + telefon + "|" + email + "|" + brojIndeksa + "|" + datumU + "|" + trenutnaGodina + "|" + status + "|" + prosek + "|" + id + "|";
		stringBuilder.append(returnValue);

		if(listaPredmeta.isEmpty()) {
			stringBuilder.append("-1");
		}
		else {
			for (Integer id : listaPredmeta.keySet()) {
				stringBuilder.append(id + ",");
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1); // delete last ','
		}

		return stringBuilder.toString();
	}

	@Override
	public String toString() {
		return String.format("%-12.12s %s %s", this.brojIndeksa, super.getIme(), super.getPrezime());
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
		return brojIndeksa.toString(); //return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa.setBrojIndeksa(brojIndeksa); //this.brojIndeksa = brojIndeksa.toLowerCase();
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

	public HashMap<Integer, Predmet> getListaPredmeta(){
		return this.listaPredmeta;
	}
	
	public void setListaPredmeta(HashMap<Integer, Predmet> predmeti) {
		this.listaPredmeta = predmeti;
	}
	
	public void addPredmet(Predmet p) {
		this.listaPredmeta.put(p.getId(), p);
	}
	
	public void removePredmet(Predmet p) {
		this.listaPredmeta.remove(p.getId());
	}
	
	public String getLongReport() {
		
		String student = 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_INDEX_NUM, brojIndeksa) + 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_NAME, ime) + 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_SURNAME, prezime) + 
				String.format("%12.12s: \t %s\n\n", StringResources.COLUMN_DATE_OF_BIRTH, getDatumRodjenja(0)) + 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_ADDRESS, adresa) + 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_TELEPHONE, telefon) + 
				String.format("%12.12s: \t %s\n\n", StringResources.COLUMN_EMAIL, email) + 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_REGISTRATION_DATE , getDatumUpisa(0)) + 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_YEAR, trenutnaGodina) + 
				String.format("%12.12s: \t %s\n", StringResources.COLUMN_STATUS, (status==Student.Status.B ? StringResources.STATUS_B : StringResources.STATUS_S)) + 
				String.format("%12.12s: \t %s\n\n", StringResources.COLUMN_AVERAGE_GRADE, prosek);
		
		StringBuilder studentRep = new StringBuilder();
		studentRep.append(student);
		
		if(listaPredmeta.isEmpty()) {
			studentRep.append(StringResources.NO_SUBJECT_STUDENT);
		}
		else {
			studentRep.append(StringResources.COLUMN_SUBJECTS + ":\n\n" + Predmet.getFormattedHeader() + "\n\n");
			
			for(Predmet p : listaPredmeta.values())
				studentRep.append(p.getShortReport() + "\n");
		}
		
		return studentRep.toString();
	}
	
	public static String getFormattedHeader() {
		return String.format("%-20.20s %-30.30s %-30.30s", StringResources.COLUMN_INDEX_NUM, StringResources.COLUMN_NAME, StringResources.COLUMN_SURNAME);
	}
	
	public String getShortReport() {
		return String.format("%-20.20s %-30.30s %-30.30s", brojIndeksa, ime, prezime);
	}
	
	public BrojIndeksa getBrojIndeksa(int i) {
		return this.brojIndeksa;
	}
}
