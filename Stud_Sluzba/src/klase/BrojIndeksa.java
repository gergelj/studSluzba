package klase;

import java.util.Comparator;

public class BrojIndeksa {
	
	private String smer;
	private int broj;
	private int godina;
	
	public BrojIndeksa() {
		
	}
	
	public BrojIndeksa(String indeks) {
		String parts[] = indeks.split("-");
		this.smer = parts[0];
		this.broj = Integer.parseInt(parts[1]);
		this.godina = Integer.parseInt(parts[2]);
	}
	
	@Override
	public String toString() {
		return smer + "-" + broj + "-" + godina;
	}
	
	public static String pattern() {
		// Jako bitno kod provere formata
		return "[a-zA-Z]{2}\\-[0-9]{1,3}\\-[0-9]{4}";
	}
	
	public static String format() {
		return "(ab-xxx-yyyy)";
	}
	
	public static String example() {
		return "ra-16-2018";
	}
	
	public void setBrojIndeksa(String indeks) {
		String parts[] = indeks.split("\\-");
		this.smer = parts[0];
		this.broj = Integer.parseInt(parts[1]);
		this.godina = Integer.parseInt(parts[2]);
	}
	
	public String getSmer() {
		return this.smer;
	}
	
	public int getBroj() {
		return this.broj;
	}
	
	public int getGodina() {
		return this.godina;
	}
	
	public static class BrojIndeksaComparator implements Comparator<BrojIndeksa> {

		@Override
		public int compare(BrojIndeksa i1, BrojIndeksa i2) {
			if(i1.getSmer().compareTo(i2.getSmer()) != 0) {		// prvo proveravam slova (smer)
				return i1.getSmer().compareTo(i2.getSmer());	// nije isti smer, vracam taj redosled
			}
			else {												// ako su smerovi isti ...
				if(i1.getGodina()>i2.getGodina())				// ... proveravam godinu
					return 1;
				else if(i1.getGodina()<i2.getGodina())
					return -1;
				else {											// ako su i godine iste ...
					if(i1.getBroj()>i2.getBroj())				// ... proveravam redni broj
						return 1;
					else if(i1.getBroj()<i2.getBroj())
						return -1;
					else
						return 0;								// ako su i redni brojevi isti (sto je u nasem slucaju nemoguce), vratim da su jednaki
				}
			}
		}

	}

}
