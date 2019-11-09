package controller;

public class StudentController {

	private StudentController instance = null;;
	
	private StudentController() {}
	
	public StudentController getInstance() {
		if(instance==null)
			instance = new StudentController();
		return instance;
	}
	
	public void dodajStudenta() {
		//TODO dodaj studenta
	}
	
	public void izmeniStudenta(int row) {
		//TODO izmena studenta
	}
	
	public void izbrisiStudenta(int row) {
		//TODO obrisi studenta
	}
	
	public void sort(int column, boolean ascending) {
		//TODO sortiranje studenta
	}
}
