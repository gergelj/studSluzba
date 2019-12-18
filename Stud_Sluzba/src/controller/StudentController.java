package controller;

import java.util.List;

import gui.MojCentralni;
import klase.BazaPredmeta;
import klase.BazaStudenta;
import klase.Student;

public class StudentController {

	private static StudentController instance = null;
	
	private StudentController() {}
	
	public static StudentController getInstance() {
		if(instance==null)
			instance = new StudentController();
		return instance;
	}
	
	public boolean dodajStudenta(String ime, String prezime,String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Student.Status status, double prosek) {

		if(BazaStudenta.getInstance().lookup_student(brojindeksa)==null) {
			BazaStudenta.getInstance().dodajStudenta(ime, prezime, datumrodj, adresa, telefon, email, brojindeksa, datumupisa, trenutnagodina, status, prosek);
			MojCentralni.getInstance().azurirajPrikaz();
			return true;
		}
		else {
			return false;
		}
	}
	
	public Student nadjiStudenta(int row) {
		return BazaStudenta.getInstance().getRow(row);
	}
	
	public boolean izmeniStudenta(String ime, String prezime,String datumrodj, String adresa, String telefon, String email, String brojindeksa, String datumupisa, int trenutnagodina, Student.Status status, double prosek, int id) {

		Student tmp = BazaStudenta.getInstance().lookup_student(brojindeksa);
		if(tmp==null) {
			BazaStudenta.getInstance().izmeniStudenta(ime, prezime, datumrodj, adresa, telefon, email, brojindeksa, datumupisa, trenutnagodina, status, prosek, id);
			MojCentralni.getInstance().azurirajPrikaz();
			return true;
		}
		else {
			if(tmp.getId()==id) {
				BazaStudenta.getInstance().izmeniStudenta(ime, prezime, datumrodj, adresa, telefon, email, brojindeksa, datumupisa, trenutnagodina, status, prosek, id);
				MojCentralni.getInstance().azurirajPrikaz();
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void izbrisiStudenta(int row) {
		if(row >= 0) {
			Student st = this.nadjiStudenta(row);
			BazaStudenta.getInstance().izbrisiStudenta(st.getId());
			MojCentralni.getInstance().azurirajPrikaz();
			
			//kada obrisem studenta, on mora da nestane sa svih spiskova svih predmeta
			BazaPredmeta.getInstance().deleteAllInstanceOfStudent(st);
			MojCentralni.getInstance().azurirajPrikazPredmet();
		}
	}
	
	public List<Student> getStudenti() {
		return BazaStudenta.getInstance().getStudenti();
	}
}
