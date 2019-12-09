package klase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// klasa za proveru polja za student/profesor/predmet
public class Proveri {

	public static void main(String[] args) {
		String s[] = {"nesto@nesto.com", "@", "", "@2019", "41-5214@", "abc"};
		
		for(int i=0; i<s.length; ++i) {
			if(isEmail(s[i])) {
				System.out.println("'" + s[i] + "' je indeks.\n");
			}
			else {
				System.out.println("'" + s[i] + "' nije indeks.\n");
			}
		}
	}
	
	public static boolean isIme(String ime) {
		return ime!=null && ime.matches("[a-zA-Z -]+");
	}
	
	public static boolean isDatum(String datum) {
		try {
            LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
        } catch (DateTimeParseException e) {
            return false;
        }
		return true;
		//return datum!=null && datum.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}\\.");
	}
	
	public static boolean isTelefon(String telefon) {
		return telefon!=null && telefon.matches("[+]?[0-9]{7,15}");
	}
	
	public static boolean isBrojIndeksa(String indeks) {
		return indeks!=null && indeks.matches("[a-zA-Z]{2}\\-[0-9]{1,3}\\-[0-9]{4}");
	}
	
	public static boolean isEmail(String email) {
		return email!=null && email.matches(".+@.+");
	}
	
	public static boolean isBrojLK(String lk) {
		return lk!=null && lk.matches("[0-9]+");
	}
	
	public static boolean isSifraPredmeta(String sfr) {
		return sfr!=null && sfr.matches("[a-zA-Z0-9]+");
	}
	
	public static boolean isAdresa(String adr) {
		return adr!=null && !adr.equals("");
	}
	
	public static boolean isProsek(String pros) {

		if(pros.matches("[0-9]{1,2}(\\.[0-9]{1,2})?")) {
			double d = Double.valueOf(pros);
			if (d<6 || d>10)
				return false;
			else
				return true;
		}
		return false;
	}
	
}
