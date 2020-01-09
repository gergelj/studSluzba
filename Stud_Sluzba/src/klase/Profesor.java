package klase;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import controller.LanguageController;

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
	
	public String format() {
		String datumR = null;
		
		switch(LanguageController.getInstance().getLanguage()) {
		case(0):
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.SERBIAN_DATEFORMAT));
			break;
		case(1):
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.HUNGARIAN_DATEFORMAT));
			break;
		case(2):
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.ENGLISH_DATEFORMAT));
			break;
		case(3):
			datumR = datumRodjenja.format(DateTimeFormatter.ofPattern(StringResources.GERMAN_DATEFORMAT));
			break;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String returnValue = ime + "|" + prezime + "|" + datumR + "|" + adresa + "|" + telefon + "|" + email + "|" + adresaKancelarije + "|" + brojLK + "|" + titula + "|" + zvanje + "|" + id + "|";
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
		return this.brojLK + " " + super.getImeiPrezime();
	}
	
	public String getLongReport() {
		
		String profesor = 
				String.format("%12.12s:\t%s\n", StringResources.COLUMN_PROFESSOR_ID_NUM, brojLK) +
				String.format("%12.12s:\t%s\n", StringResources.COLUMN_NAME, ime) +
				String.format("%12.12s:\t%s\n", StringResources.COLUMN_SURNAME, prezime) +
				String.format("%12.12s:\t%s\n\n", StringResources.COLUMN_DATE_OF_BIRTH, getDatumRodjenja(0)) +
				String.format("%12.12s:\t%s\n", StringResources.COLUMN_ADDRESS, adresa) +
				String.format("%12.12s:\t%s\n", StringResources.COLUMN_TELEPHONE, telefon) +
				String.format("%12.12s:\t%s\n\n", StringResources.COLUMN_EMAIL, email) +
				String.format("%12.12s:\t%s\n", StringResources.COLUMN_OFFICE_ADDRESS, adresaKancelarije) +
				String.format("%12.12s:\t%s\n", StringResources.COLUMN_TITLE, titula) +
				String.format("%12.12s:\t%s\n\n", StringResources.COLUMN_DEGREE, zvanje);
				
		StringBuilder profesorRep = new StringBuilder();
		profesorRep.append(profesor);
		
		if(listaPredmeta.isEmpty()) {
			profesorRep.append(StringResources.NO_SUBJECT_PROFESSOR);
		}
		else {
			profesorRep.append(StringResources.COLUMN_SUBJECTS + ":\n\n" + Predmet.getFormattedHeader() + "\n\n");
			
			for(Predmet p : listaPredmeta.values())
				profesorRep.append(p.getShortReport() + "\n");
		}
		
		return profesorRep.toString();
	}
	
	public String getShortReport() {
		return String.format("\t%12.12s:\t%s\n", StringResources.COLUMN_PROFESSOR_ID_NUM, brojLK) +
				String.format("\t%12.12s:\t%s\n", StringResources.COLUMN_NAME, ime) +
				String.format("\t%12.12s:\t%s\n", StringResources.COLUMN_SURNAME, prezime) +
				String.format("\t%12.12s:\t%s\n\n", StringResources.COLUMN_DATE_OF_BIRTH, getDatumRodjenja(0)) +
				String.format("\t%12.12s:\t%s\n", StringResources.COLUMN_ADDRESS, adresa) +
				String.format("\t%12.12s:\t%s\n", StringResources.COLUMN_TELEPHONE, telefon) +
				String.format("\t%12.12s:\t%s\n\n", StringResources.COLUMN_EMAIL, email) +
				String.format("\t%12.12s:\t%s\n", StringResources.COLUMN_OFFICE_ADDRESS, adresaKancelarije) +
				String.format("\t%12.12s:\t%s\n", StringResources.COLUMN_TITLE, titula) +
				String.format("\t%12.12s:\t%s\n\n", StringResources.COLUMN_DEGREE, zvanje);
	}
	
	
}
