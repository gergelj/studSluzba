package klase;

import java.util.HashMap;

public class StringResources {

	public static final String APPLICATION_NAME = "Studentska služba";
	public static final String APPLICATION_CLASS_NAME = "StudSluzba";
	public static final String VERSION = "0.1 alpha";
	
	public static String DATEFORMAT = "dd.MM.yyyy.";
	public static String DATETIMEFORMAT = "HH:mm:ss   " + StringResources.DATEFORMAT;
	
	public static String CONFIRM_DELETE_STUDENT = "Da li biste stvarno zeleli da obrisete studenta?";
	public static String DELETE_STUDENT_TITLE = "Delete Student";
	public static String CONFIRM_DELETE_PROFESSOR = "Da li biste stvarno zeleli da obrisete profesora?";
	public static String DELETE_PROFESSOR_TITLE = "Delete Professor";
	public static String CONFIRM_DELETE_SUBJECT = "Da li biste stvarno zeleli da predmet?";
	public static String DELETE_SUBJECT_TITLE = "Delete Subject";
	
	public static String REQUIRED_FIELD = "Obavezno polje";
	
	public static String STATUS_B = "budzet";
	public static String STATUS_S = "samofinansiranje";
	
	public static String ABOUT = "About";
	
	public static String STUDENTS = "Studenti";
	public static String PROFESSORS = "Profesori";
	public static String SUBJECTS = "Predmeti";
	
	public static String ADD_STUDENT = "Add Student";
	public static String EDIT_STUDENT = "Edit Student";
	public static String ADD_SUBJECT = "Add Subject";
	public static String EDIT_SUBJECT = "Edit Subject";
	public static String ADD_PROFESSOR = "Add Professor";
	public static String EDIT_PROFESSOR = "Edit Professor";
	
	public static String ASSIGN_PROFESSOR_TO_SUBJECT = "Assign Professor to Subject";
	public static String ASSSIGN_PROFESSOR_TO = "Assign Professor to "; // + name of Subject
	public static String ADD_STUDENT_TO_SUBJECT = "Add Student to Subject";
	public static String ADD_STUDENT_TO = "Add Student to "; // + name of Subject
	
	public static String CANCEL = "Cancel";
	public static String OK = "OK";
	public static String ADD = "Add";
	public static String EDIT = "Edit";
	public static String DELETE = "Delete";
	public static String SAVE_TO_DB = "Save to Database";
	public static String RESET_SORT = "Reset sorting";
	public static String REMOVE = "Remove";
	
	public static String CLOSE_CONFIRMATION_MESSAGE = "Are you sure you want to close the program?";
	public static String CLOSE_WINDOW_TITLE = "Close Window";
	
	public static String MENU_FILE = "File";
	public static String MENU_EDIT = "Edit";
	public static String MENU_HELP = "Help";
	public static String MENU_NEW = "New";
	public static String MENU_SAVE_DB = "Save to Database";
	public static String MENU_CLOSE = "Close";
	public static String MENU_DELETE = "Delete";
	public static String MENU_LANGUAGE = "Jezik";
	public static String SEARCH = "Search";
	public static String SEARCH_EXAMPLE = "ime: Pera | prezime: Peric | indeks: ra-100-2019...";
	
	//PANEL LABELS
	public static String LABEL_NAME = "Ime *";
	public static String LABEL_SURNAME = "Prezime *";
	public static String LABEL_DATE_OF_BIRTH = "Datum rodjenja *";
	public static String LABEL_ADDRESS = "Adresa stanovanja *";
	public static String LABEL_TELEPHONE = "Kontakt telefon *";
	public static String LABEL_EMAIL = "Email *";
	public static String LABEL_OFFICE_ADDRESS = "Adresa kancelarije *";
	public static String LABEL_ID_NUM = "Broj licne karte *";
	public static String LABEL_DEGREE = "Zvanje *";
	public static String LABEL_TITLE = "Titula *";
	public static String LABEL_INDEX_NUM = "Broj indeksa *";
	public static String LABEL_REGISTRATION_DATE = "Datum upisa *";
	public static String LABEL_AVERAGE_GRADE = "Prosek *";
	public static String LABEL_CURRENT_YEAR = "Godina studija *";
	public static String LABEL_FIRST_YEAR = "I (prva)";
	public static String LABEL_SECOND_YEAR = "II (druga)";
	public static String LABEL_THIRD_YEAR = "III (treća)";
	public static String LABEL_FOURTH_YEAR = "IV (četvrta)";
	public static String LABEL_FIRST_SEMESTER = "I (prvi)";
	public static String LABEL_SECOND_SEMESTER = "II (drugi)";
	public static String LABEL_THIRD_SEMESTER = "III (treći)";
	public static String LABEL_FOURTH_SEMESTER = "IV (četvrti)";
	public static String LABEL_FIFTH_SEMESTER = "V (peti)";
	public static String LABEL_SIXTH_SEMESTER = "VI (sesti)";
	public static String LABEL_SEVENTH_SEMESTER = "VII (sedmi)";
	public static String LABEL_EIGHTH_SEMESTER = "VII (osmi)";
	public static String LABEL_SUBJECT_ID = "Sifra predmeta *";
	public static String LABEL_SUBJECT_TITLE = "Naziv predmeta *";
	public static String LABEL_YEAR = "Godina *";
	public static String LABEL_SEMESTER = "Semestar *";
	
	public static String EXAMPLE_NAME = "npr. Imenko";
	public static String EXAMPLE_SURNAME = "npr. Prezimić";
	public static String EXAMPLE_DATE = "npr. 22.05.2019.";
	public static String EXAMPLE_ADDRESS = "npr. 21000 Novi Sad";
	public static String EXAMPLE_TELEPHONE = "npr. 061234567";
	public static String EXAMPLE_EMAIL = "npr. imenko@uns.ac.rs";
	public static String EXAMPLE_INDEX_NUM = "npr. ra-16-2016";
	public static String EXAMPLE_GRADE = "6.00 - 10.00";
	
	public static String PROFESSOR_ID_NUM_EXISTS = " -vec postoji broj licne karte";
	public static String INDEX_NUM_EXISTS = " - postoji vec indeks";
	public static String SUBJECT_ID_EXISTS = " - vec postoji sifra predmeta";
	
	public static String PROFESSOR_SUBJECT_LIST = "Subjects for selected Professor";
	public static String STUDENT_SUBJECT_LIST = "Subjects for selected Student";
	public static String SUBJECT_STUDENT_LIST = "Students for selected Subject";
	
	public static String TAB_TITLE_STUDENTS = "Students";
	public static String TAB_TITLE_PROFESSORS = "Professors";
	public static String TAB_TITLE_SUBJECTS = "Subjects";
	
	public static String COLUMN_SUBJECT_ID = "SIFRA PREDMETA";
	public static String COLUMN_SUBJECT_TITLE = "NAZIV PREDMETA";
	public static String COLUMN_YEAR = "GODINA";
	public static String COLUMN_SEMESTER = "SEMESTAR"; 
	public static String COLUMN_PROFESSOR = "PROFESOR";
	public static String COLUMN_NAME = "IME";
	public static String COLUMN_SURNAME = "PREZIME";
	public static String COLUMN_DATE_OF_BIRTH = "DAT. RODJ.";
	public static String COLUMN_ADDRESS = "ADRESA";
	public static String COLUMN_TELEPHONE = "TELEFON";
	public static String COLUMN_EMAIL = "E-MAIL";
	public static String COLUMN_OFFICE_ADDRESS = "ADR. KANC.";
	public static String COLUMN_PROFESSOR_ID_NUM = "BR. LK.";
	public static String COLUMN_TITLE = "TITULA";
	public static String COLUMN_DEGREE = "ZVANJE";
	public static String COLUMN_INDEX_NUM = "INDEKS";
	public static String COLUMN_REGISTRATION_DATE = "DAT. UPISA";
	public static String COLUMN_STATUS = "STATUS";
	public static String COLUMN_AVERAGE_GRADE = "PROSEK";
	
	public static String NO_PROFESSOR = "Profesor nije dodat";
	public static String NTH_YEAR = ". godina"; //prethodi ga cifra za godinu: 3. godina, 2. godina
	public static String RESTART_NEEDED = "Restart needed for the changes to take effect";
	
	public static final String SERBIAN = "SRPSKI";
	public static final String HUNGARIAN = "MAGYAR";
	public static final String ENGLISH = "ENGLISH";
	public static final String GERMAN = "DEUTSCH";
	
	/*****    NEMOJ OVO DOLE GLEDATI *********/
	/***** TESTING AREA *****/
	
	public static String allKeys[] = {
						"APPLICATION_NAME,",
						"APPLICATION_CLASS_NAME",
						"VERSION",
						"DATEFORMAT",
						"DATETIMEFORMAT",
						"CONFIRM_DELETE_STUDENT",
						"DELETE_STUDENT_TITLE",
						"CONFIRM_DELETE_PROFESSOR",
						"DELETE_PROFESSOR_TITLE",
						"CONFIRM_DELETE_SUBJECT",
						"DELETE_SUBJECT_TITLE",
						"REQUIRED_FIELD",
						"STATUS_B",
						"STATUS_S",
						"ABOUT",
						"STUDENTS",
						"PROFESSORS",
						"SUBJECTS",
						"ADD_STUDENT",
						"EDIT_STUDENT",
						"ADD_SUBJECT",
						"EDIT_SUBJECT",
						"ADD_PROFESSOR",
						"EDIT_PROFESSOR",
						"ASSIGN_PROFESSOR_TO_SUBJECT",
						"ASSSIGN_PROFESSOR_TO",
						"ADD_STUDENT_TO_SUBJECT",
						"ADD_STUDENT_TO",
						"CANCEL",
						"OK",
						"ADD",
						"EDIT",
						"DELETE",
						"SAVE_TO_DB",
						"RESET_SORT",
						"REMOVE",
						"CLOSE_CONFIRMATION_MESSAGE",
						"CLOSE_WINDOW_TITLE",
						"MENU_FILE",
						"MENU_EDIT",
						"MENU_HELP",
						"MENU_NEW",
						"MENU_SAVE_DB",
						"MENU_CLOSE",
						"MENU_DELETE",
						"MENU_LANGUAGE",
						"SEARCH",
						"SEARCH_EXAMPLE",
						"LABEL_NAME",
						"LABEL_SURNAME",
						"LABEL_DATE_OF_BIRTH",
						"LABEL_ADDRESS",
						"LABEL_TELEPHONE",
						"LABEL_EMAIL",
						"LABEL_OFFICE_ADDRESS",
						"LABEL_ID_NUM",
						"LABEL_DEGREE",
						"LABEL_TITLE",
						"LABEL_INDEX_NUM",
						"LABEL_REGISTRATION_DATE",
						"LABEL_AVERAGE_GRADE",
						"LABEL_CURRENT_YEAR",
						"LABEL_FIRST_YEAR",
						"LABEL_SECOND_YEAR",
						"LABEL_THIRD_YEAR",
						"LABEL_FOURTH_YEAR",
						"LABEL_FIRST_SEMESTER",
						"LABEL_SECOND_SEMESTER",
						"LABEL_THIRD_SEMESTER",
						"LABEL_FOURTH_SEMESTER",
						"LABEL_FIFTH_SEMESTER",
						"LABEL_SIXTH_SEMESTER",
						"LABEL_SEVENTH_SEMESTER",
						"LABEL_EIGHTH_SEMESTER",
						"LABEL_SUBJECT_ID",
						"LABEL_SUBJECT_TITLE",
						"LABEL_YEAR",
						"LABEL_SEMESTER",
						"EXAMPLE_NAME",
						"EXAMPLE_SURNAME",
						"EXAMPLE_DATE",
						"EXAMPLE_ADDRESS",
						"EXAMPLE_TELEPHONE",
						"EXAMPLE_EMAIL",
						"EXAMPLE_INDEX_NUM",
						"EXAMPLE_GRADE",
						"PROFESSOR_ID_NUM_EXISTS",
						"INDEX_NUM_EXISTS",
						"SUBJECT_ID_EXISTS",
						"PROFESSOR_SUBJECT_LIST",
						"STUDENT_SUBJECT_LIST",
						"SUBJECT_STUDENT_LIST",
						"TAB_TITLE_STUDENTS",
						"TAB_TITLE_PROFESSORS",
						"TAB_TITLE_SUBJECTS",
						"COLUMN_SUBJECT_ID",
						"COLUMN_SUBJECT_TITLE",
						"COLUMN_YEAR",
						"COLUMN_SEMESTER",
						"COLUMN_PROFESSOR",
						"COLUMN_NAME",
						"COLUMN_SURNAME",
						"COLUMN_DATE_OF_BIRTH",
						"COLUMN_ADDRESS",
						"COLUMN_TELEPHONE",
						"COLUMN_EMAIL",
						"COLUMN_OFFICE_ADDRESS",
						"COLUMN_PROFESSOR_ID_NUM",
						"COLUMN_TITLE",
						"COLUMN_DEGREE",
						"COLUMN_INDEX_NUM",
						"COLUMN_REGISTRATION_DATE",
						"COLUMN_STATUS",
						"COLUMN_AVERAGE_GRADE",
						"NO_PROFESSOR",
						"NTH_YEAR",
						"RESTART_NEEDED",
						"SERBIAN",
						"HUNGARIAN",
						"ENGLISH",
						"GERMAN"
					};
	
	public static HashMap<String,String> srpski = new HashMap<String,String>();
	public static HashMap<String,String> res = new HashMap<String,String>();
	
	static {
		/* Inicijalizacija srpskog recnika (fallback dictionary)
		srpski.put("APPLICATION_NAME,", );
		srpski.put("APPLICATION_CLASS_NAME", );
		srpski.put("VERSION", );
		srpski.put("DATEFORMAT", );
		srpski.put("DATETIMEFORMAT", );
		srpski.put("CONFIRM_DELETE_STUDENT", );
		srpski.put("DELETE_STUDENT_TITLE", );
		srpski.put("CONFIRM_DELETE_PROFESSOR", );
		srpski.put("DELETE_PROFESSOR_TITLE", );
		srpski.put("CONFIRM_DELETE_SUBJECT", );
		srpski.put("DELETE_SUBJECT_TITLE", );
		srpski.put("REQUIRED_FIELD", );
		srpski.put("STATUS_B", );
		srpski.put("STATUS_S", );
		srpski.put("ABOUT", );
		srpski.put("STUDENTS", );
		srpski.put("PROFESSORS", );
		srpski.put("SUBJECTS", );
		srpski.put("ADD_STUDENT", );
		srpski.put("EDIT_STUDENT", );
		srpski.put("ADD_SUBJECT", );
		srpski.put("EDIT_SUBJECT", );
		srpski.put("ADD_PROFESSOR", );
		srpski.put("EDIT_PROFESSOR", );
		srpski.put("ASSIGN_PROFESSOR_TO_SUBJECT", );
		srpski.put("ASSSIGN_PROFESSOR_TO", );
		srpski.put("ADD_STUDENT_TO_SUBJECT", );
		srpski.put("ADD_STUDENT_TO", );
		srpski.put("CANCEL", );
		srpski.put("OK", );
		srpski.put("ADD", );
		srpski.put("EDIT", );
		srpski.put("DELETE", );
		srpski.put("SAVE_TO_DB", );
		srpski.put("RESET_SORT", );
		srpski.put("REMOVE", );
		srpski.put("CLOSE_CONFIRMATION_MESSAGE", );
		srpski.put("CLOSE_WINDOW_TITLE", );
		srpski.put("MENU_FILE", );
		srpski.put("MENU_EDIT", );
		srpski.put("MENU_HELP", );
		srpski.put("MENU_NEW", );
		srpski.put("MENU_SAVE_DB", );
		srpski.put("MENU_CLOSE", );
		srpski.put("MENU_DELETE", );
		srpski.put("MENU_LANGUAGE", );
		srpski.put("SEARCH", );
		srpski.put("SEARCH_EXAMPLE", );
		srpski.put("LABEL_NAME", );
		srpski.put("LABEL_SURNAME", );
		srpski.put("LABEL_DATE_OF_BIRTH", );
		srpski.put("LABEL_ADDRESS", );
		srpski.put("LABEL_TELEPHONE", );
		srpski.put("LABEL_EMAIL", );
		srpski.put("LABEL_OFFICE_ADDRESS", );
		srpski.put("LABEL_ID_NUM", );
		srpski.put("LABEL_DEGREE", );
		srpski.put("LABEL_TITLE", );
		srpski.put("LABEL_INDEX_NUM", );
		srpski.put("LABEL_REGISTRATION_DATE", );
		srpski.put("LABEL_AVERAGE_GRADE", );
		srpski.put("LABEL_CURRENT_YEAR", );
		srpski.put("LABEL_FIRST_YEAR", );
		srpski.put("LABEL_SECOND_YEAR", );
		srpski.put("LABEL_THIRD_YEAR", );
		srpski.put("LABEL_FOURTH_YEAR", );
		srpski.put("LABEL_FIRST_SEMESTER", );
		srpski.put("LABEL_SECOND_SEMESTER", );
		srpski.put("LABEL_THIRD_SEMESTER", );
		srpski.put("LABEL_FOURTH_SEMESTER", );
		srpski.put("LABEL_FIFTH_SEMESTER", );
		srpski.put("LABEL_SIXTH_SEMESTER", );
		srpski.put("LABEL_SEVENTH_SEMESTER", );
		srpski.put("LABEL_EIGHTH_SEMESTER", );
		srpski.put("LABEL_SUBJECT_ID", );
		srpski.put("LABEL_SUBJECT_TITLE", );
		srpski.put("LABEL_YEAR", );
		srpski.put("LABEL_SEMESTER", );
		srpski.put("EXAMPLE_NAME", );
		srpski.put("EXAMPLE_SURNAME", );
		srpski.put("EXAMPLE_DATE", );
		srpski.put("EXAMPLE_ADDRESS", );
		srpski.put("EXAMPLE_TELEPHONE", );
		srpski.put("EXAMPLE_EMAIL", );
		srpski.put("EXAMPLE_INDEX_NUM", );
		srpski.put("EXAMPLE_GRADE", );
		srpski.put("PROFESSOR_ID_NUM_EXISTS", );
		srpski.put("INDEX_NUM_EXISTS", );
		srpski.put("SUBJECT_ID_EXISTS", );
		srpski.put("PROFESSOR_SUBJECT_LIST", );
		srpski.put("STUDENT_SUBJECT_LIST", );
		srpski.put("SUBJECT_STUDENT_LIST", );
		srpski.put("TAB_TITLE_STUDENTS", );
		srpski.put("TAB_TITLE_PROFESSORS", );
		srpski.put("TAB_TITLE_SUBJECTS", );
		srpski.put("COLUMN_SUBJECT_ID", );
		srpski.put("COLUMN_SUBJECT_TITLE", );
		srpski.put("COLUMN_YEAR", );
		srpski.put("COLUMN_SEMESTER", );
		srpski.put("COLUMN_PROFESSOR", );
		srpski.put("COLUMN_NAME", );
		srpski.put("COLUMN_SURNAME", );
		srpski.put("COLUMN_DATE_OF_BIRTH", );
		srpski.put("COLUMN_ADDRESS", );
		srpski.put("COLUMN_TELEPHONE", );
		srpski.put("COLUMN_EMAIL", );
		srpski.put("COLUMN_OFFICE_ADDRESS", );
		srpski.put("COLUMN_PROFESSOR_ID_NUM", );
		srpski.put("COLUMN_TITLE", );
		srpski.put("COLUMN_DEGREE", );
		srpski.put("COLUMN_INDEX_NUM", );
		srpski.put("COLUMN_REGISTRATION_DATE", );
		srpski.put("COLUMN_STATUS", );
		srpski.put("COLUMN_AVERAGE_GRADE", );
		srpski.put("NO_PROFESSOR", );
		srpski.put("NTH_YEAR", );
		srpski.put("RESTART_NEEDED", );
		srpski.put("SERBIAN", );
		srpski.put("HUNGARIAN", );
		srpski.put("ENGLISH", );
		srpski.put("GERMAN", );
		*/
	}
	
	public static void loadResources() {
		
	}
}
