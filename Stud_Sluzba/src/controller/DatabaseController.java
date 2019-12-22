package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import klase.BazaPredmeta;
import klase.BazaProfesora;
import klase.BazaStudenta;

public class DatabaseController {

	private static File studentDBFile = new File("resources/student.db");
	private static File predmetDBFile = new File("resources/predmet.db");
	private static File profesorDBFile = new File("resources/profesor.db");
	
	private static ObjectOutputStream outStreamStudent, outStreamPredmet, outStreamProfesor;
	private static ObjectInputStream inStreamStudent, inStreamPredmet, inStreamProfesor;
	
	private DatabaseController() {
		
	}
	
	public static void save() {
				
		try {
			outStreamStudent = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(studentDBFile)));
			outStreamPredmet = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(predmetDBFile)));
			outStreamProfesor = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(profesorDBFile)));
			outStreamStudent.writeObject(BazaStudenta.getInstance());
			outStreamPredmet.writeObject(BazaPredmeta.getInstance());
			outStreamProfesor.writeObject(BazaProfesora.getInstance());
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				outStreamStudent.close();
				outStreamPredmet.close();
				outStreamProfesor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void load() {
		
		try {
			inStreamStudent = new ObjectInputStream(new BufferedInputStream(new FileInputStream(studentDBFile)));
			inStreamPredmet = new ObjectInputStream(new BufferedInputStream(new FileInputStream(predmetDBFile)));
			inStreamProfesor = new ObjectInputStream(new BufferedInputStream(new FileInputStream(profesorDBFile)));
			BazaStudenta.setInstance((BazaStudenta) inStreamStudent.readObject());
			BazaPredmeta.setInstance((BazaPredmeta) inStreamPredmet.readObject());
			BazaProfesora.setInstance((BazaProfesora) inStreamProfesor.readObject());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				inStreamStudent.close();
				inStreamPredmet.close();
				inStreamProfesor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
