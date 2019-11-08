package klase;

// klasa za proveru polja za student/profesor/predmet
public class Proveri {

	public static void main(String[] args) {
		String s[] = {"ra-6-2017", "RA-6-2017", "", "df-41-2019", "32-41-5214", "abc"};
		String s2 = null;
		
		for(int i=0; i<s.length; ++i) {
			if(isBrojIndeksa(s[i])) {
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
		return datum!=null && datum.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}\\.");
	}
	
	public static boolean isTelefon(String telefon) {
		return telefon!=null && telefon.matches("[+][0-9]{7,15}");
	}
	
	public static boolean isBrojIndeksa(String indeks) {
		return indeks!=null && indeks.matches("[a-zA-Z]{2}\\-[0-9]{1,3}\\-[0-9]{4}");
	}
}
