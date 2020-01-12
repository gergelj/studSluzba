package klase;

import controller.LanguageController;

public class StringResources {

	public static final String APPLICATION_NAME = "Studentska služba";
	public static final String APPLICATION_CLASS_NAME = "StudSluzba";
	public static final String VERSION = "0.2 alpha";
	
	public static final String SERBIAN = "SRPSKI";
	public static final String HUNGARIAN = "MAGYAR";
	public static final String ENGLISH = "ENGLISH";
	public static final String GERMAN = "DEUTSCH";
	public static final String SERBIAN_DATEFORMAT = "dd.MM.yyyy.";
	public static final String HUNGARIAN_DATEFORMAT = "yyyy.MM.dd.";
	public static final String ENGLISH_DATEFORMAT = "dd.MM.yyyy.";
	public static final String GERMAN_DATEFORMAT = "dd.MM.yyyy.";
	
	public static String DATEFORMAT = "dd.MM.yyyy.";
	public static String DATETIMEFORMAT = "HH:mm:ss   " + StringResources.DATEFORMAT;
	
	public static String CONFIRM_DELETE_STUDENT = "Da li biste stvarno želeli da obrišete studenta?";
	public static String DELETE_STUDENT_TITLE = "Brisanje studenta";
	public static String CONFIRM_DELETE_PROFESSOR = "Da li biste stvarno želeli da obrišete profesora?";
	public static String DELETE_PROFESSOR_TITLE = "Brisanje profesora";
	public static String CONFIRM_DELETE_SUBJECT = "Da li biste stvarno želeli da obrišete predmet?";
	public static String DELETE_SUBJECT_TITLE = "Brisanje predmeta";
	
	public static String REQUIRED_FIELD = "Obavezno polje";
	
	public static String STATUS_B = "budžet";
	public static String STATUS_S = "samofinansiranje";
	
	public static String ABOUT = "O aplikaciji";
	
	public static String STUDENTS = "Studenti";
	public static String PROFESSORS = "Profesori";
	public static String SUBJECTS = "Predmeti";
	
	public static String ADD_STUDENT = "Dodaj studenta";
	public static String EDIT_STUDENT = "Izmeni studenta";
	public static String ADD_SUBJECT = "Dodaj predmet";
	public static String EDIT_SUBJECT = "Izmeni predmet";
	public static String ADD_PROFESSOR = "Dodaj profesora";
	public static String EDIT_PROFESSOR = "Izmeni profesora";
	
	public static String ASSIGN_PROFESSOR_TO_SUBJECT = "Dodaj profesora na predmet";
	public static String DELETE_PROFESSOR_FROM_SUBJECT = "Obrisi profesora sa predmeta";
	public static String ASSSIGN_PROFESSOR_TO = "Dodaj profesora na predmet: "; // + name of Subject
	public static String ADD_STUDENT_TO_SUBJECT = "Dodaj studenta na predmet";
	public static String ADD_STUDENT_TO = "Dodaj studenta na predmet: "; // + name of Subject
	
	public static String NOTIFICATION = "Obaveštenje";
	public static String YES = "Da";
	public static String NO = "Ne";
	public static String CANCEL = "Odustani";
	public static String OK = "OK";
	public static String ADD = "Dodaj";
	public static String EDIT = "Izmeni";
	public static String DELETE = "Obriši";
	public static String SAVE_TO_DB = "Sačuvaj u bazu podataka";
	public static String RESET_SORT = "Isključi sortiranje";
	public static String REMOVE = "Ukloni";
	
	public static String CLOSE_CONFIRMATION_MESSAGE = "Da li ste sigurni da zatvorite aplikaciju?";
	public static String CLOSE_WINDOW_TITLE = "Zatvaranje";
	
	public static String MENU_FILE = "Fajl";
	public static String MENU_EDIT = "Izmena";
	public static String MENU_HELP = "Pomoć";
	public static String MENU_NEW = "Novi";
	public static String MENU_REPORT = "Izveštaj";
	public static String MENU_SAVE_DB = "Sačuvaj u bazu podataka";
	public static String MENU_CLOSE = "Zatvori";
	public static String MENU_DELETE = "Obriši";
	public static String MENU_LANGUAGE = "Jezik";
	public static String SEARCH = "Pretraga";
	public static String SEARCH_EXAMPLE = "ime: Pera ; prezime: Peric ; indeks: " + BrojIndeksa.example();
	
	//PANEL LABELS
	public static String LABEL_NAME = "Ime *";
	public static String LABEL_SURNAME = "Prezime *";
	public static String LABEL_DATE_OF_BIRTH = "Datum rodjenja *";
	public static String LABEL_ADDRESS = "Adresa stanovanja *";
	public static String LABEL_TELEPHONE = "Kontakt telefon *";
	public static String LABEL_EMAIL = "Email *";
	public static String LABEL_OFFICE_ADDRESS = "Adresa kancelarije *";
	public static String LABEL_ID_NUM = "Broj lične karte *";
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
	public static String LABEL_SUBJECT_ID = "Šifra predmeta *";
	public static String LABEL_SUBJECT_TITLE = "Naziv predmeta *";
	public static String LABEL_YEAR = "Godina *";
	public static String LABEL_SEMESTER = "Semestar *";
	
	public static String EXAMPLE_NAME = "npr. Imenko";
	public static String EXAMPLE_SURNAME = "npr. Prezimić";
	public static String EXAMPLE_DATE = "npr. 22.05.2019.";
	public static String EXAMPLE_ADDRESS = "npr. Novi Sad";
	public static String EXAMPLE_TELEPHONE = "npr. 061234567";
	public static String EXAMPLE_EMAIL = "npr. imenko@uns.ac.rs";
	public static String EXAMPLE_INDEX_NUM = "npr. " + BrojIndeksa.example();
	public static String EXAMPLE_GRADE = "6.00 - 10.00";
	
	public static String PROFESSOR_ALREADY_ON_SUBJECT = "Profesor je već dodat na predmet.";
	public static String PROFESSOR_ID_NUM_EXISTS = " - već postoji broj lične karte";
	public static String INDEX_NUM_EXISTS = " - postoji već indeks";
	public static String INDEX_NUM_DOESNT_EXIST = " - ne postoji indeks";
	public static String INDEX_ON_SUBJECT = " - student je već na predmetu";
	public static String SUBJECT_ID_EXISTS = " - već postoji šifra predmeta";
	public static String NOT_SAME_YEAR = " - nije ista godina kao predmet";
	public static String WRONG_FORMAT = " - loš format " + BrojIndeksa.format();
	public static String INDEX_INPUT = "Upišite indeks:";
	public static String INDEX_INPUT_MESSAGE = "Upišite indeks";
	
	public static String PROFESSOR_SUBJECT_LIST = "Predmeti profesora";
	public static String STUDENT_SUBJECT_LIST = "Predmeti studenta";
	public static String SUBJECT_STUDENT_LIST = "Studenti na predmetu";
	
	public static String TAB_TITLE_STUDENTS = "Studenti";
	public static String TAB_TITLE_PROFESSORS = "Profesori";
	public static String TAB_TITLE_SUBJECTS = "Predmeti";
	
	public static String COLUMN_SUBJECT_ID = "ŠIFRA PREDMETA";
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
	public static String COLUMN_STUDENTS = "STUDENTI";
	public static String COLUMN_SUBJECTS = "PREDMETI";
	
	public static String NO_PROFESSOR = "Profesor nije dodat";
	public static String RESTART_NEEDED = "Potrebno je pokrenuti aplikaciju ponovo da biste videli promene.";
	
	public static String STUDENT_REPORT = "Izveštaj za studenta";
	public static String PROFESSOR_REPORT = "Izveštaj za profesora";
	public static String SUBJECT_REPORT = "Izveštaj za predmeta";
	public static String NO_SUBJECT_STUDENT = "Student ne sluša nijedan predmet.";
	public static String NO_SUBJECT_PROFESSOR = "Profesor ne predaje nijedan predmet.";
	public static String NO_STUDENTS = "Ne postoji student na predmetu.";
	
	public static void loadResources() {
		switch(LanguageController.getInstance().getLanguage()) {
		case 0: break;
		case 1: loadHU();
				break;
		case 2: loadEn();
				break;
		case 3: loadDe();
				break;
		}
	}
	
	private static void loadDe() {
		CONFIRM_DELETE_STUDENT = "Möchten Sie Studenten löschen?";
		DELETE_STUDENT_TITLE = "Studenten löschen";
		CONFIRM_DELETE_PROFESSOR = "Möchten Sie Professor löschen?";
		DELETE_PROFESSOR_TITLE = "Professor löschen";
		CONFIRM_DELETE_SUBJECT = "Möchten Sie den Kurs löschen?";
		DELETE_SUBJECT_TITLE = "Betreff löschen";
		
		REQUIRED_FIELD = "Dieses Feld wird benötigt";
		
		STATUS_B = "budget";
		STATUS_S = "selbstfinanzierung";
		
		ABOUT = "Über die Bewerbung";
		
		STUDENTS = "Studenten";
		PROFESSORS = "Professoren";
		SUBJECTS = "Kurse";
		
		ADD_STUDENT = "Schüler hinzufügen";
		EDIT_STUDENT = "Studenten bearbeiten";
		ADD_SUBJECT = "Kurs hinzufügen";
		EDIT_SUBJECT = "Kurs bearbeiten";
		ADD_PROFESSOR = "Professor hinzufügen";
		EDIT_PROFESSOR = "Professor bearbeiten";
		
		ASSIGN_PROFESSOR_TO_SUBJECT = "Ordnen Sie dem Kurs einen Professor zu";
		DELETE_PROFESSOR_FROM_SUBJECT = "Löschen Sie den Professor aus den Fach";
		ASSSIGN_PROFESSOR_TO = "Ordnen Sie dem Kurs einen Professor zu: "; // + name of Subject
		ADD_STUDENT_TO_SUBJECT = "Ordnen Sie dem Kurs einen Studenten zu";
		ADD_STUDENT_TO = "Ordnen Sie dem Kurs einen Studenten zu: "; // + name of Subject
		
		NOTIFICATION = "Benachrichtigung";
		YES = "Ja";
		NO = "Nein";
		CANCEL = "Absagen";
		OK = "OK";
		ADD = "Hinzufügen";
		EDIT = "Bearbeiten";
		DELETE = "Löschen";
		SAVE_TO_DB = "In Datenbank speichern";
		RESET_SORT = "Reheinfolge zurücksetzen";
		REMOVE = "Entfernen";
		
		CLOSE_CONFIRMATION_MESSAGE = "Möchten Sie die Anwendung schließen?";
		CLOSE_WINDOW_TITLE = "Andwendung schließen";
		
		MENU_FILE = "Datei";
		MENU_EDIT = "Bearbeiten";
		MENU_HELP = "Hilfe";
		MENU_NEW = "Neu";
		MENU_REPORT = "Bericht";
		MENU_SAVE_DB = "In Datenbank speichern";
		MENU_CLOSE = "Schließen";
		MENU_DELETE = "Löschen";
		MENU_LANGUAGE = "Sprache";
		SEARCH = "Suche";
		SEARCH_EXAMPLE = "Name: Pera ; Nachname: Peric ; Index: " + BrojIndeksa.example();
		
		//PANEL LABELS
		LABEL_NAME = "Name *";
		LABEL_SURNAME = "Nachname *";
		LABEL_DATE_OF_BIRTH = "Geburtsdatum *";
		LABEL_ADDRESS = "Wohnadresse *";
		LABEL_TELEPHONE = "Kontakt-Telefon *";
		LABEL_EMAIL = "E-mail *";
		LABEL_OFFICE_ADDRESS = "Büro Adresse *";
		LABEL_ID_NUM = "ID-Nummer *";
		LABEL_DEGREE = "Rang *";
		LABEL_TITLE = "Titel *";
		LABEL_INDEX_NUM = "Indexnummer *";
		LABEL_REGISTRATION_DATE = "Zp. des Inkrafttretens *";
		LABEL_AVERAGE_GRADE = "Notendurchschnitt *";
		LABEL_CURRENT_YEAR = "Studienjahr *";
		LABEL_FIRST_YEAR = "I (estes)";
		LABEL_SECOND_YEAR = "II (zweites)";
		LABEL_THIRD_YEAR = "III (drittes)";
		LABEL_FOURTH_YEAR = "IV (viertes)";
		LABEL_FIRST_SEMESTER = "I (ester)";
		LABEL_SECOND_SEMESTER = "II (zweiter)";
		LABEL_THIRD_SEMESTER = "III (dritter)";
		LABEL_FOURTH_SEMESTER = "IV (vierter)";
		LABEL_FIFTH_SEMESTER = "V (fünfter)";
		LABEL_SIXTH_SEMESTER = "VI (sechster)";
		LABEL_SEVENTH_SEMESTER = "VII (siebter)";
		LABEL_EIGHTH_SEMESTER = "VII (achter)";
		LABEL_SUBJECT_ID = "Kurs-Code *";
		LABEL_SUBJECT_TITLE = "Kurs Name *";
		LABEL_YEAR = "Jahr *";
		LABEL_SEMESTER = "Semester *";
		
		EXAMPLE_NAME = "z.B. Imenko";
		EXAMPLE_SURNAME = "z.B. Prezimić";
		EXAMPLE_DATE = "z.B. 22.05.2019.";
		EXAMPLE_ADDRESS = "z.B. Novi Sad";
		EXAMPLE_TELEPHONE = "z.B. 061234567";
		EXAMPLE_EMAIL = "z.B. imenko@uns.ac.rs";
		EXAMPLE_INDEX_NUM = "z.B. " + BrojIndeksa.example();
		EXAMPLE_GRADE = "6.00 - 10.00";
		
		PROFESSOR_ALREADY_ON_SUBJECT = "Professor ist dem Kurs schon zugeordnet.";
		PROFESSOR_ID_NUM_EXISTS = " - ID-nummer existiert bereits";
		INDEX_NUM_EXISTS = " - Indexnummer existiert bereits";
		INDEX_NUM_DOESNT_EXIST = " - Indexnummer existiert nicht";
		INDEX_ON_SUBJECT = " - Student ist dem Kurs schon zugeordnet";
		SUBJECT_ID_EXISTS = " - Kurs-Code existiert bereits";
		NOT_SAME_YEAR = " - nicht das gleiche Jahr wie der Kurs";
		WRONG_FORMAT = " - falsches Format " + BrojIndeksa.format();
		INDEX_INPUT = "Geben Sie die Indexnummer ein:";
		INDEX_INPUT_MESSAGE = "Geben Sie die Indexnummer ein";
		
		PROFESSOR_SUBJECT_LIST = "Kurse des Professors";
		STUDENT_SUBJECT_LIST = "Kurse des Students";
		SUBJECT_STUDENT_LIST = "Studenten im Kurs.";
		
		TAB_TITLE_STUDENTS = "Studenten";
		TAB_TITLE_PROFESSORS = "Professoren";
		TAB_TITLE_SUBJECTS = "Kurse";
		
		COLUMN_SUBJECT_ID = "KURS-CODE";
		COLUMN_SUBJECT_TITLE = "KURSBEZEICHNUNG";
		COLUMN_YEAR = "JAHR";
		COLUMN_SEMESTER = "SEMESTER"; 
		COLUMN_PROFESSOR = "PROFESSOR";
		COLUMN_NAME = "NAME";
		COLUMN_SURNAME = "NACHNAME";
		COLUMN_DATE_OF_BIRTH = "GEBURTSDATUM";
		COLUMN_ADDRESS = "ADRESSE";
		COLUMN_TELEPHONE = "TELEFON";
		COLUMN_EMAIL = "E-MAIL";
		COLUMN_OFFICE_ADDRESS = "B. ADRESSE";
		COLUMN_PROFESSOR_ID_NUM = "ID-NUM.";
		COLUMN_TITLE = "RANG";
		COLUMN_DEGREE = "TITEL";
		COLUMN_INDEX_NUM = "INDEX";
		COLUMN_REGISTRATION_DATE = "Zp.DES INKRAFTTETENS ";
		COLUMN_STATUS = "STATUS";
		COLUMN_AVERAGE_GRADE = "NOTENDURCHSCHNITT";
		COLUMN_STUDENTS = "STUDENTEN";
		COLUMN_SUBJECTS = "KURSE";
		
		NO_PROFESSOR = "Professor nicht zugeordnet";
		RESTART_NEEDED = "Starten Sie die Anwendung neu, um die Änderungen anzuzeigen";
		
		STUDENT_REPORT = "Bericht über Studenten";
		PROFESSOR_REPORT = "Bericht über Professoren";
		SUBJECT_REPORT = "Bericht über Kurse";
		NO_SUBJECT_STUDENT = "Student ist keinem Kurs zugeordnet.";
		NO_SUBJECT_PROFESSOR = "Professor ist keinem Kurs zugeordnet.";
		NO_STUDENTS = "Kurs kein Student zugeordnet.";
		
	}

	private static void loadEn() {
		CONFIRM_DELETE_STUDENT = "Do you really want to delete Student?";
		DELETE_STUDENT_TITLE = "Deleting Student";
		CONFIRM_DELETE_PROFESSOR = "Do you really want to delete Professor?";
		DELETE_PROFESSOR_TITLE = "Deleting Professor";
		CONFIRM_DELETE_SUBJECT = "Do you really want to delete Subject?";
		DELETE_SUBJECT_TITLE = "Deleting Subject";
		
		REQUIRED_FIELD = "This field is requierd";
		
		STATUS_B = "budget";
		STATUS_S = "self-financing";
		
		ABOUT = "About application";
		
		STUDENTS = "Students";
		PROFESSORS = "Professors";
		SUBJECTS = "Subjects";
		
		ADD_STUDENT = "Add Student";
		EDIT_STUDENT = "Edit studenta";
		ADD_SUBJECT = "Add Subject";
		EDIT_SUBJECT = "Edit Subject";
		ADD_PROFESSOR = "Add Professor";
		EDIT_PROFESSOR = "Edit Professor";
		
		ASSIGN_PROFESSOR_TO_SUBJECT = "Assign a professor to the Subject";
		DELETE_PROFESSOR_FROM_SUBJECT = "Delete Professor from the Subject";
		ASSSIGN_PROFESSOR_TO = "Assign a Professor to the Subject: "; // + name of Subject
		ADD_STUDENT_TO_SUBJECT = "Assign a Student to the Subject";
		ADD_STUDENT_TO = "Assign a Studenta to the Subject: "; // + name of Subject
		
		NOTIFICATION = "Notification";
		YES = "Yes";
		NO = "No";
		CANCEL = "Cancel";
		OK = "OK";
		ADD = "Add";
		EDIT = "Edit";
		DELETE = "Delete";
		SAVE_TO_DB = "Save to Data Base";
		RESET_SORT = "Reset Sort";
		REMOVE = "Remove";
		
		CLOSE_CONFIRMATION_MESSAGE = "Do you really want to close application?";
		CLOSE_WINDOW_TITLE = "Close";
		
		MENU_FILE = "File";
		MENU_EDIT = "Edit";
		MENU_HELP = "Help";
		MENU_NEW = "New";
		MENU_REPORT = "Report";
		MENU_SAVE_DB = "Save to Data Base";
		MENU_CLOSE = "Close";
		MENU_DELETE = "Delete";
		MENU_LANGUAGE = "Language";
		SEARCH = "Search";
		SEARCH_EXAMPLE = "name: Pera ; surname: Peric ; index: " + BrojIndeksa.example();
		
		//PANEL LABELS
		LABEL_NAME = "Name *";
		LABEL_SURNAME = "Surname *";
		LABEL_DATE_OF_BIRTH = "Date of Birth *";
		LABEL_ADDRESS = "Residental Address *";
		LABEL_TELEPHONE = "Contact Phone *";
		LABEL_EMAIL = "E-mail *";
		LABEL_OFFICE_ADDRESS = "Office Address *";
		LABEL_ID_NUM = "ID Number *";
		LABEL_DEGREE = "Rank *";
		LABEL_TITLE = "Title *";
		LABEL_INDEX_NUM = "Index Number *";
		LABEL_REGISTRATION_DATE = "Date of Entry *";
		LABEL_AVERAGE_GRADE = "GPA *";
		LABEL_CURRENT_YEAR = "Year of Study *";
		LABEL_FIRST_YEAR = "I (first)";
		LABEL_SECOND_YEAR = "II (second)";
		LABEL_THIRD_YEAR = "III (third)";
		LABEL_FOURTH_YEAR = "IV (fourth)";
		LABEL_FIRST_SEMESTER = "I (first)";
		LABEL_SECOND_SEMESTER = "II (second)";
		LABEL_THIRD_SEMESTER = "III (third)";
		LABEL_FOURTH_SEMESTER = "IV (fourth)";
		LABEL_FIFTH_SEMESTER = "V (fifth)";
		LABEL_SIXTH_SEMESTER = "VI (sixth)";
		LABEL_SEVENTH_SEMESTER = "VII (seventh)";
		LABEL_EIGHTH_SEMESTER = "VII (eighth)";
		LABEL_SUBJECT_ID = "Subject Code *";
		LABEL_SUBJECT_TITLE = "Subject Name *";
		LABEL_YEAR = "Year *";
		LABEL_SEMESTER = "Semester *";
		
		EXAMPLE_NAME = "e.g. Imenko";
		EXAMPLE_SURNAME = "e.g. Prezimić";
		EXAMPLE_DATE = "e.g. 22.05.2019.";
		EXAMPLE_ADDRESS = "e.g. Novi Sad";
		EXAMPLE_TELEPHONE = "e.g. 061234567";
		EXAMPLE_EMAIL = "e.g. imenko@uns.ac.rs";
		EXAMPLE_INDEX_NUM = "e.g. " + BrojIndeksa.example();
		EXAMPLE_GRADE = "6.00 - 10.00";
		
		PROFESSOR_ALREADY_ON_SUBJECT = "Professor is already added to the subject.";
		PROFESSOR_ID_NUM_EXISTS = " - ID number already exist";
		INDEX_NUM_EXISTS = " - index number already exist";
		INDEX_NUM_DOESNT_EXIST = " - index number does not exist";
		INDEX_ON_SUBJECT = " - student is already added";
		SUBJECT_ID_EXISTS = " - subject code already exist";
		NOT_SAME_YEAR = " - not same year as the subject";
		WRONG_FORMAT = " - false format " + BrojIndeksa.format();
		INDEX_INPUT = "Type index number:";
		INDEX_INPUT_MESSAGE = "Type index number";
		
		PROFESSOR_SUBJECT_LIST = "Subjects of Professor";
		STUDENT_SUBJECT_LIST = "Subjects of Student";
		SUBJECT_STUDENT_LIST = "Students on Subject";
		
		TAB_TITLE_STUDENTS = "Students";
		TAB_TITLE_PROFESSORS = "Professors";
		TAB_TITLE_SUBJECTS = "Subjects";
		
		COLUMN_SUBJECT_ID = "SUBJECT CODE";
		COLUMN_SUBJECT_TITLE = "SUBJECT NAME";
		COLUMN_YEAR = "YEAR";
		COLUMN_SEMESTER = "SEMESTER"; 
		COLUMN_PROFESSOR = "PROFESSOR";
		COLUMN_NAME = "NAME";
		COLUMN_SURNAME = "SURNAME";
		COLUMN_DATE_OF_BIRTH = "DATE OF BIRTH";
		COLUMN_ADDRESS = "ADDRESS";
		COLUMN_TELEPHONE = "PHONE";
		COLUMN_EMAIL = "E-MAIL";
		COLUMN_OFFICE_ADDRESS = "OFF. ADDRESS";
		COLUMN_PROFESSOR_ID_NUM = "ID NUM.";
		COLUMN_TITLE = "RANK";
		COLUMN_DEGREE = "TITLE";
		COLUMN_INDEX_NUM = "INDEX";
		COLUMN_REGISTRATION_DATE = "DATE OF ENTRY";
		COLUMN_STATUS = "STATUS";
		COLUMN_AVERAGE_GRADE = "GPA";
		COLUMN_STUDENTS = "STUDENTS";
		COLUMN_SUBJECTS = "SUBJECTS";
		
		NO_PROFESSOR = "Professor not assigned";
		RESTART_NEEDED = "Restart the applicaction to see changes";
		
		STUDENT_REPORT = "Student report";
		PROFESSOR_REPORT = "Professor report";
		SUBJECT_REPORT = "Subject report";
		NO_SUBJECT_STUDENT = "No subject for selected student.";
		NO_SUBJECT_PROFESSOR = "Professor has no subjects.";
		NO_STUDENTS = "No students on subject.";
		
	}

	private static void loadHU() {
		DATEFORMAT = "yyyy.MM.dd.";
		DATETIMEFORMAT = "HH:mm:ss   " + StringResources.DATEFORMAT;
		
		CONFIRM_DELETE_STUDENT = "Ki szeretné törölni a hallgatót?";
		DELETE_STUDENT_TITLE = "Hallgató törlése";
		CONFIRM_DELETE_PROFESSOR = "Ki szeretné törölni a professzort?";
		DELETE_PROFESSOR_TITLE = "Professzor törlése";
		CONFIRM_DELETE_SUBJECT = "Ki szeretné törölni a tantárgyat?";
		DELETE_SUBJECT_TITLE = "Tantárgy törlése";
		
		REQUIRED_FIELD = "Kötelező mező";
		
		STATUS_B = "állami költséges";
		STATUS_S = "önköltséges";
		
		ABOUT = "Az aplikációról";
		
		STUDENTS = "Hallgatók";
		PROFESSORS = "Professzorok";
		SUBJECTS = "Tantárgyak";
		
		ADD_STUDENT = "Hallgató hozzáadása";
		EDIT_STUDENT = "Hallgató szerkesztése";
		ADD_SUBJECT = "Tantárgy hozzáadása";
		EDIT_SUBJECT = "Tantárgy szerkesztése";
		ADD_PROFESSOR = "Professzor hozzáadása";
		EDIT_PROFESSOR = "Professzor szerkesztése";
		
		ASSIGN_PROFESSOR_TO_SUBJECT = "Professzor hozzáadása a tantárgyhoz";
		DELETE_PROFESSOR_FROM_SUBJECT = "Törölje a professzort a tárgyból";
		ASSSIGN_PROFESSOR_TO = "Professzor hozzáadása ehhez a tantárgyhoz: "; // + name of Subject
		ADD_STUDENT_TO_SUBJECT = "Hallgató hozzáadása a tantárgyhoz";
		ADD_STUDENT_TO = "Hallgató hozzáadása ehhez a tantárgyhoz: "; // + name of Subject
		
		NOTIFICATION = "Értesítés";
		YES = "Igen";
		NO = "Nem";
		CANCEL = "Vissza";
		OK = "OK";
		ADD = "Hozzáad";
		EDIT = "Szerkesztés";
		DELETE = "Törlés";
		SAVE_TO_DB = "Mentés az adatbázisba";
		RESET_SORT = "Rendezés visszaállítása";
		REMOVE = "Eltávolítás";
		
		CLOSE_CONFIRMATION_MESSAGE = "Biztosan be akarja zárni az aplikációt?";
		CLOSE_WINDOW_TITLE = "Bezárás";
		
		MENU_FILE = "Fájl";
		MENU_EDIT = "Szerkesztés";
		MENU_HELP = "Segítség";
		MENU_NEW = "Új";
		MENU_REPORT = "Összegzés";
		MENU_SAVE_DB = "Mentés az adatbázisba";
		MENU_CLOSE = "Bezárás";
		MENU_DELETE = "Törlés";
		MENU_LANGUAGE = "Nyelv";
		SEARCH = "Keresés";
		SEARCH_EXAMPLE = "ime: Pera ; prezime: Peric ; indeks: " + BrojIndeksa.example();
		
		//PANEL LABELS
		LABEL_NAME = "Név *";
		LABEL_SURNAME = "Vezetéknév *";
		LABEL_DATE_OF_BIRTH = "Születési dátum *";
		LABEL_ADDRESS = "Lakhely *";
		LABEL_TELEPHONE = "Telefonszám *";
		LABEL_EMAIL = "Email *";
		LABEL_OFFICE_ADDRESS = "Iroda címe *";
		LABEL_ID_NUM = "Személyi szám *";
		LABEL_DEGREE = "Elnevezés *";
		LABEL_TITLE = "Titulus *";
		LABEL_INDEX_NUM = "Index szám *";
		LABEL_REGISTRATION_DATE = "Beíratkozás dátuma *";
		LABEL_AVERAGE_GRADE = "Átlagosztályzat *";
		LABEL_CURRENT_YEAR = "Évfolyam *";
		LABEL_FIRST_YEAR = "I (első)";
		LABEL_SECOND_YEAR = "II (második)";
		LABEL_THIRD_YEAR = "III (harmadik)";
		LABEL_FOURTH_YEAR = "IV (negyedik)";
		LABEL_FIRST_SEMESTER = "I (első)";
		LABEL_SECOND_SEMESTER = "II (második)";
		LABEL_THIRD_SEMESTER = "III (harmadik)";
		LABEL_FOURTH_SEMESTER = "IV (negyedik)";
		LABEL_FIFTH_SEMESTER = "V (ötödik)";
		LABEL_SIXTH_SEMESTER = "VI (hatodik)";
		LABEL_SEVENTH_SEMESTER = "VII (hetedik)";
		LABEL_EIGHTH_SEMESTER = "VII (nyolcadik)";
		LABEL_SUBJECT_ID = "Kód *";
		LABEL_SUBJECT_TITLE = "Név *";
		LABEL_YEAR = "Évfolyam *";
		LABEL_SEMESTER = "Szemeszter *";
		
		EXAMPLE_NAME = "pl. Név";
		EXAMPLE_SURNAME = "pl. Vezetéknév";
		EXAMPLE_DATE = "pl. 2019.12.20.";
		EXAMPLE_ADDRESS = "pl. Novi Sad";
		EXAMPLE_TELEPHONE = "pl. 061234567";
		EXAMPLE_EMAIL = "pl. nev@uns.ac.rs";
		EXAMPLE_INDEX_NUM = "pl. " + BrojIndeksa.example();
		EXAMPLE_GRADE = "6.00 - 10.00";
		
		PROFESSOR_ALREADY_ON_SUBJECT = "Ez a professzor már előad a tantárgyon.";
		PROFESSOR_ID_NUM_EXISTS = " - már létezik ilyen személyiszám";
		INDEX_NUM_EXISTS = " - már létezik ilyen index szám";
		INDEX_NUM_DOESNT_EXIST = " - nem létezik az index szám";
		INDEX_ON_SUBJECT = " - a hallgató már felvette a tárgyat";
		SUBJECT_ID_EXISTS = " - már létezik ilyen tantárgy kódja";
		NOT_SAME_YEAR = " - nem egyforma évfolyam";
		WRONG_FORMAT = " - rossz formátum " + BrojIndeksa.format();
		INDEX_INPUT = "Vigyen be indexszámot:";
		INDEX_INPUT_MESSAGE = "Vigyen be indexszámot";
		
		PROFESSOR_SUBJECT_LIST = "Professzor tantárgyai";
		STUDENT_SUBJECT_LIST = "Hallgató tantárgyai";
		SUBJECT_STUDENT_LIST = "A tantárgyat felvették";
		
		TAB_TITLE_STUDENTS = "Hallgatók";
		TAB_TITLE_PROFESSORS = "Professzorok";
		TAB_TITLE_SUBJECTS = "Tantárgyak";
		
		COLUMN_SUBJECT_ID = "KÓD";
		COLUMN_SUBJECT_TITLE = "NÉV";
		COLUMN_YEAR = "ÉVFOLYAM";
		COLUMN_SEMESTER = "SZEMESZTER"; 
		COLUMN_PROFESSOR = "PROFESSZOR";
		COLUMN_NAME = "NÉV";
		COLUMN_SURNAME = "VEZETÉKNÉV";
		COLUMN_DATE_OF_BIRTH = "SZÜL. DÁTUM";
		COLUMN_ADDRESS = "LAKCÍM";
		COLUMN_TELEPHONE = "TELEFON";
		COLUMN_EMAIL = "E-MAIL";
		COLUMN_OFFICE_ADDRESS = "IRODA CÍM";
		COLUMN_PROFESSOR_ID_NUM = "SZEMÉLYI SZÁM";
		COLUMN_TITLE = "TITULUS";
		COLUMN_DEGREE = "MEGNEVEZÉS";
		COLUMN_INDEX_NUM = "INDEX";
		COLUMN_REGISTRATION_DATE = "BEÍRAT. DÁTUM";
		COLUMN_STATUS = "STÁTUSZ";
		COLUMN_AVERAGE_GRADE = "ÁTLAG";
		COLUMN_STUDENTS = "HALLGATÓK";
		COLUMN_SUBJECTS = "TANTÁRGYAK";
		
		NO_PROFESSOR = "Nincs professzor";
		RESTART_NEEDED = "A változások életbelépéséhez újraindítás szükséges.";
		
		STUDENT_REPORT = "Hallgató összegzés";
		PROFESSOR_REPORT = "Professzor összegzés";
		SUBJECT_REPORT = "Tantárgy összegzés";
		NO_SUBJECT_STUDENT = "A hallgató nem vett fel egy tantágyat sem.";
		NO_SUBJECT_PROFESSOR = "A professzor egy tantárgyat sem ad elő.";
		NO_STUDENTS = "Nincs hallgató a tantárgyon.";
	}
}
