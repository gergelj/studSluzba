package klase;

import java.util.ArrayList;
import java.util.List;

public class BazaStudenta {

	private static BazaStudenta instance = null;

	public static BazaStudenta getInstance() {
		if (instance == null) {
			instance = new BazaStudenta();
		}
		return instance;
	}

	private int generator;

	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudenta() {
		generator = 0;
	
		initStudenti();

		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DAT. RODJ.");
		this.kolone.add("ADRESA");
		this.kolone.add("TELEFON");
		this.kolone.add("E-MAIL");
		this.kolone.add("DAT. UPISA");
		this.kolone.add("GODINA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		

	}

	private void initStudenti() {
		this.studenti = new ArrayList<Student>();
		//TODO: import from file
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> igraci) {
		this.studenti = igraci;
	}

	private int generateId() {
		return ++generator;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getDatumRodjenja().toString();
		case 4:
			return student.getAdresa();
		case 5:
			return student.getTelefon();
		case 6:
			return student.getEmail();
		case 7:
			return student.getDatumUpisa().toString();
		case 8:
			return String.valueOf(student.getTrenutnaGodina());
		case 9:
			return student.getStatus()==Student.Status.B ? "budzet" : "samofinansiranje";
		case 10:
			return String.valueOf(student.getProsek());
		default:
			return null;
		}
	}

	public void dodajStudenta(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Student.Status status, double prosek) {
		this.studenti.add(new Student(ime, prezime, datumrodj, adresa, telefon, email, brojindeksa, datumupisa, trenutnagodina, status, prosek, generateId()));
	}

	public void izbrisiStudenta(int id) {
		for (Student i : studenti) {
			if (i.getId()==id) {
				studenti.remove(i);
				break;
			}
		}
	}

	public void izmeniStudenta(String ime, String prezime, String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Student.Status status, double prosek, int id) {
		//TODO: izmeni Studenta
		for (Student i : studenti) {
			if (i.getId()==id) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatumRodjenja(datumrodj);
				i.setAdresa(adresa);
				i.setTelefon(telefon);
				i.setEmail(email);
				i.setDatumUpisa(datumupisa);
				i.setTrenutnaGodina(trenutnagodina);
				i.setStatus(status);
				i.setProsek(prosek);
				i.setBrojIndeksa(brojindeksa);
				
				
				break;
			}
		}
	}
	
	public Student lookup_student(String indeks) {
		for(Student st : studenti) {
			if(st.getBrojIndeksa().equals(indeks))
				return st;
		}
		return null;
	}

}
