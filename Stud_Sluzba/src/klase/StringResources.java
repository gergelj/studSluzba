package klase;

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
	
	public static final String ADD_STUDENT = "Add Student";
	public static final String EDIT_STUDENT = "Edit Student";
	public static final String ADD_SUBJECT = "Add Subject";
	public static final String EDIT_SUBJECT = "Edit Subject";
	public static final String ADD_PROFESSOR = "Add Professor";
	public static final String EDIT_PROFESSOR = "Edit Professor";
	
	public static String ASSIGN_PROFESSOR_TO_SUBJECT = "Assign Professor to Subject";
	public static String ASSSIGN_PROFESSOR_TO = "Assign Professor to "; // + name of Subject
	public static String ADD_STUDENT_TO_SUBJECT = "Add Student to Subject";
	public static String ADD_STUDENT_TO = "Add Student to "; // + name of Subject
	
	public static String CANCEL = "Cancel";
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

}
