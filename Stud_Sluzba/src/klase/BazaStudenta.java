package klase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class BazaStudenta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7453226705286577358L;

	private static BazaStudenta instance = null;

	public static BazaStudenta getInstance() {
		if (instance == null) {
			instance = new BazaStudenta();
		}
		return instance;
	}
	
	public static void setInstance(BazaStudenta db) {
		instance = db;
	}

	private int generator;

	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenta() {
		generator = 0;
		this.studenti = new ArrayList<Student>();

		this.kolone = new ArrayList<String>();
		this.kolone.add(StringResources.COLUMN_INDEX_NUM);
		this.kolone.add(StringResources.COLUMN_NAME);
		this.kolone.add(StringResources.COLUMN_SURNAME);
		this.kolone.add(StringResources.COLUMN_DATE_OF_BIRTH);
		this.kolone.add(StringResources.COLUMN_ADDRESS);
		this.kolone.add(StringResources.COLUMN_TELEPHONE);
		this.kolone.add(StringResources.COLUMN_EMAIL);
		this.kolone.add(StringResources.COLUMN_REGISTRATION_DATE);
		this.kolone.add(StringResources.COLUMN_YEAR);
		this.kolone.add(StringResources.COLUMN_STATUS);
		this.kolone.add(StringResources.COLUMN_AVERAGE_GRADE);

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
	
	public void setCurrentGenerator(int id) {
		this.generator = id;
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

	public Object getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa(0); // tipa BrojIndeksa
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getDatumRodjenja();
		case 4:
			return student.getAdresa();
		case 5:
			return student.getTelefon();
		case 6:
			return student.getEmail();
		case 7:
			return student.getDatumUpisa();
		case 8:
			return String.valueOf(student.getTrenutnaGodina());
		case 9:
			return student.getStatus()==Student.Status.B ? StringResources.STATUS_B : StringResources.STATUS_S;
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
/*
	public void updatePredmetiZaStudenta(Student s) {
		for(Predmet p : s.getSpisakPredmeta().values()) {
			p.getmListaStudenata().put(s.getId(), s);
		}
	}
*/
	public Student lookup_student(String indeks) {
		for(Student st : studenti) {
			if(st.getBrojIndeksa().equals(indeks))
				return st;
		}
		return null;
	}

	public void deleteAllInstancesOfSubject(Predmet p) {
		for(Student s : studenti) 
			s.getListaPredmeta().remove(p.getId());
	}

	public Student getStudentByBrojIndeksa(String indeks) {
		for(Student s : studenti) {
			if(indeks.equalsIgnoreCase(s.getBrojIndeksa()))
				return s;
		}
		return null;
	}
	
	public Student getStudentById(int id) {
		for(Student s : studenti) {
			if(id == s.getId())
				return s;
		}
		return null;
	}

}
