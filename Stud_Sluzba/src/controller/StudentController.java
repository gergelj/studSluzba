package controller;

import gui.MojCentralni;
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
		//TODO dodaj studenta
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
		//TODO izmena studenta
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
			Student st = BazaStudenta.getInstance().getStudentAt(row);
			BazaStudenta.getInstance().izbrisiStudenta(st.getId());
			MojCentralni.getInstance().azurirajPrikaz();
		}
	}
	
	public void sort(int column, boolean ascending) {
		//TODO sortiranje studenta
	}
}
