package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import klase.BazaPredmeta;
import klase.BazaProfesora;
import klase.BazaStudenta;
import klase.Predmet;
import klase.Profesor;
import klase.Student;

public class DatabaseController {
	
	private static BufferedWriter studentWriter;
	private static BufferedReader studentReader;
	private static File studentTextFile = new File("resources/student");
	
	private static BufferedWriter profesorWriter;
	private static BufferedReader profesorReader;
	private static File profesorTextFile = new File("resources/profesor");
	
	private static BufferedWriter predmetWriter;
	private static BufferedReader predmetReader;
	private static File predmetTextFile = new File("resources/predmet");
	
	private DatabaseController() {
		
	}
	
	public static void save() {
			
		try {
			
			profesorWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(profesorTextFile)));
			for(Profesor p : BazaProfesora.getInstance().getProfesori())
				profesorWriter.write(p.format() + "\n");
			
			studentWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(studentTextFile)));
			for(Student s : BazaStudenta.getInstance().getStudenti())
				studentWriter.write(s.format() + "\n");
			
			predmetWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(predmetTextFile)));
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti())
				predmetWriter.write(p.format() + "\n");
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				studentWriter.close();
				profesorWriter.close();
				predmetWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void load() {
		DatabaseController.loadStudenti();
		DatabaseController.loadProfesori();
		DatabaseController.loadPredmeti();
		DatabaseController.join();
	}
	
	private static void join() {
		for(Predmet predmet : BazaPredmeta.getInstance().getPredmeti()) {
			for(int idStudenta : predmet.getmListaStudenata().keySet()) {
				Student s = BazaStudenta.getInstance().getStudentById(idStudenta);
				predmet.getmListaStudenata().put(idStudenta, s);
				s.getListaPredmeta().put(predmet.getId(), predmet);
			}
		}
		
		for(Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
			for(int idPredmeta : profesor.getListaPredmeta().keySet()) {
				Predmet predmet = BazaPredmeta.getInstance().getPredmetById(idPredmeta);
				predmet.setmProfesor(profesor);
				profesor.getListaPredmeta().put(idPredmeta, predmet);
			}
		}
	}
	
	private static void loadPredmeti() {
		try {
			predmetReader = new BufferedReader(new InputStreamReader(new FileInputStream(predmetTextFile)));
			String line = null;
			List<Predmet> predmeti = new ArrayList<Predmet>();
			int maxId = 0;
			while((line=predmetReader.readLine()) != null) {
				if(line.equals("\n"))
					break;
				
				String fields[] = line.split("\\|");
				int id = Integer.parseInt(fields[4]);
				if(id>maxId)
					maxId = id;
				Predmet p = new Predmet(fields[0].trim(), fields[1].trim(), Integer.parseInt(fields[2].trim()), Integer.parseInt(fields[3].trim()), id);
				
				int profesorId = Integer.parseInt(fields[5].trim());
				if(profesorId == -1) {
					p.setmProfesor(null);
				}
				
				String spisakStudenata[] = fields[6].split(",");
				
				if(spisakStudenata[0].equals("-1")) {
					predmeti.add(p);
					continue;
				}
				
				for(String idStudenta : spisakStudenata) {
					p.getmListaStudenata().put(Integer.parseInt(idStudenta), null);
				}
				
				predmeti.add(p);
			}
			
			BazaPredmeta.getInstance().setPredmeti(predmeti);
			BazaPredmeta.getInstance().setCurrentGenerator(maxId);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				predmetReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void loadStudenti() {
		try {
			studentReader = new BufferedReader(new InputStreamReader(new FileInputStream(studentTextFile)));
			String line = null;
			List<Student> studenti = new ArrayList<Student>();
			int maxId = 0;
			while((line=studentReader.readLine()) != null) {
				if(line.equals("\n"))
					break;
				
				String fields[] = line.split("\\|");
				int id = Integer.parseInt(fields[11]);
				if(id>maxId)
					maxId = id;
				Student s = new Student(fields[0].trim(), fields[1].trim(), fields[2].trim(), fields[3].trim(), fields[4].trim(), fields[5].trim(), fields[6].trim(), fields[7].trim(), Integer.parseInt(fields[8].trim()), fields[9].trim().equals("B") ? Student.Status.B : Student.Status.S, Double.parseDouble(fields[10].trim()), id);
				
				String spisakPredmetaStudenta[] = fields[12].split(",");
				
				if(spisakPredmetaStudenta[0].equals("-1")) {
					studenti.add(s);
					continue;
				}
				
				for(String idPredmetaStudenta : spisakPredmetaStudenta) {
					s.getListaPredmeta().put(Integer.parseInt(idPredmetaStudenta), null);
				}
				
				studenti.add(s);
			}
			
			BazaStudenta.getInstance().setStudenti(studenti);
			BazaStudenta.getInstance().setCurrentGenerator(maxId);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				studentReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void loadProfesori() {
		try {
			profesorReader = new BufferedReader(new InputStreamReader(new FileInputStream(profesorTextFile)));
			String line = null;
			List<Profesor> profesori = new ArrayList<Profesor>();
			int maxId = 0;
			while((line=profesorReader.readLine()) != null) {
				if(line.equals("\n"))
					break;
				
				String fields[] = line.split("\\|");
				int id = Integer.parseInt(fields[10]);
				if(id>maxId)
					maxId = id;
				Profesor p = new Profesor(fields[0].trim(), fields[1].trim(), fields[2].trim(), fields[3].trim(), fields[4].trim(), fields[5].trim(), fields[6].trim(), fields[7].trim(), fields[8].trim(), fields[9].trim(), id);
				
				String spisakPredmetaProfesora[] = fields[11].split(",");
				
				if(spisakPredmetaProfesora[0].equals("-1")) {
					profesori.add(p);
					continue;
				}
				
				for(String idPredmetaProfesora : spisakPredmetaProfesora) {
					p.getListaPredmeta().put(Integer.parseInt(idPredmetaProfesora), null);
				}
				
				profesori.add(p);
			}
			
			BazaProfesora.getInstance().setProfesori(profesori);
			BazaProfesora.getInstance().setCurrentGenerator(maxId);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				profesorReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
