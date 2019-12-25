package controller;

import java.util.ArrayList;
import java.util.List;

import gui.AbstractTableModelStudenti;
import gui.MojCentralni;
import gui.StudentiJTable;
import klase.BazaPredmeta;
import klase.BazaStudenta;
import klase.Fields;
import klase.Predmet;
import klase.Proveri;
import klase.Student;

public class StudentController {
	
	public static final int NORMAL_MODE = 0;
	public static final int SEARCH_MODE = 1;

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
	
	public void sort(int column, boolean isAscending) {
		BazaStudenta.getInstance().sort(column, isAscending);
		MojCentralni.getInstance().azurirajPrikaz();
	}
	
	public void unsort() {
		for(int i = 0; i<BazaStudenta.getInstance().getColumnCount(); i++) {
			StudentiJTable.getInstance().getColumnModel().getColumn(i).setHeaderValue(BazaStudenta.getInstance().getColumnName(i));
		}
		StudentiJTable.getInstance().getTableHeader().repaint();
		BazaStudenta.getInstance().unsort();
		MojCentralni.getInstance().azurirajPrikaz();
	}

	public List<Predmet> getListOfSubjects(Student s) {
		List<Predmet> pred = new ArrayList<Predmet>();
		
		for(Predmet predmet: s.getSpisakPredmeta().values() )
		{
			pred.add(predmet);
		}
		
		return pred;
	}
	
	public void search(List<String> searchList, Student studentExample) {
		List<Student> searchResult = new ArrayList<Student>();
		
		searchInitial(searchList.get(0), studentExample, BazaStudenta.getInstance().getStudenti(), searchResult);
		
		for(int i = 1; i<searchList.size(); i++) {
			searchSpecific(searchList.get(i), studentExample, searchResult);
		}
		
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) StudentiJTable.getInstance().getModel();
		model.search(SEARCH_MODE, searchResult);
		
		MojCentralni.getInstance().azurirajPrikaz();
		
		
	}
	
	private void searchInitial(String searchBy, Student studentExample, List<Student> source, List<Student> destination) {
		if(searchBy.equalsIgnoreCase(Fields.INDEKS)) {
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getBrojIndeksa() == studentExample.getBrojIndeksa())
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.IME)) 
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getIme().equals(studentExample.getIme()))
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.PREZIME))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getPrezime().equals(studentExample.getPrezime()))
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.DATRODJ))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getDatumRodjenja().compareTo(studentExample.getDatumRodjenja()) == 0)
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.ADRESA))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getAdresa().equals(studentExample.getAdresa()))
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.TELEFON))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getTelefon().equals(studentExample.getTelefon()))
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.EMAIL))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getEmail().equals(studentExample.getEmail()))
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.DATUPIS))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getDatumUpisa().compareTo(studentExample.getDatumUpisa()) == 0)
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.STATUS))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getStatus() == studentExample.getStatus())
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.GODINA))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getTrenutnaGodina() == studentExample.getTrenutnaGodina())
					destination.add(source.get(i));
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.PROSEK))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getProsek() == studentExample.getProsek())
					destination.add(source.get(i));
			}
		}
		
	}

	private void searchSpecific(String searchBy, Student studentExample, List<Student> source) {
		if(searchBy.equalsIgnoreCase(Fields.INDEKS)) {
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getBrojIndeksa() != studentExample.getBrojIndeksa()) {
					source.remove(i);
					i--;
				}
				
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.IME)) 
		{
			for(int i = 0; i<source.size(); i++) {
				if(!source.get(i).getIme().equals(studentExample.getIme())) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.PREZIME))
		{
			for(int i = 0; i<source.size(); i++) {
				if(!source.get(i).getPrezime().equals(studentExample.getPrezime())) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.DATRODJ))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getDatumRodjenja().compareTo(studentExample.getDatumRodjenja()) != 0) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.ADRESA))
		{
			for(int i = 0; i<source.size(); i++) {
				if(!source.get(i).getAdresa().equals(studentExample.getAdresa())) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.TELEFON))
		{
			for(int i = 0; i<source.size(); i++) {
				if(!source.get(i).getTelefon().equals(studentExample.getTelefon())) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.EMAIL))
		{
			for(int i = 0; i<source.size(); i++) {
				if(!source.get(i).getEmail().equals(studentExample.getEmail())) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.DATUPIS))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getDatumUpisa().compareTo(studentExample.getDatumUpisa()) != 0) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.STATUS))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getStatus() != studentExample.getStatus()) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.GODINA))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getTrenutnaGodina() != studentExample.getTrenutnaGodina()) {
					source.remove(i);
					i--;
				}
			}
		}
		else if(searchBy.equalsIgnoreCase(Fields.PROSEK))
		{
			for(int i = 0; i<source.size(); i++) {
				if(source.get(i).getProsek() != studentExample.getProsek()) {
					source.remove(i);
					i--;
				}
			}
		}
		
	}

	
	public void clearSearch() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) StudentiJTable.getInstance().getModel();
		model.search(NORMAL_MODE, null);
		
		MojCentralni.getInstance().azurirajPrikaz();
		
	}
}
