package klase;

import controller.LanguageController;

public class StringResources {

	public static final String APPLICATION_NAME = "Studentska služba";
	public static final String APPLICATION_CLASS_NAME = "StudSluzba";
	public static final String VERSION = "0.1 alpha";
	
	public static final String SERBIAN = "SRPSKI";
	public static final String HUNGARIAN = "MAGYAR";
	public static final String ENGLISH = "ENGLISH";
	public static final String GERMAN = "DEUTSCH";
	
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
	public static String ASSSIGN_PROFESSOR_TO = "Dodaj profesora na predmet: "; // + name of Subject
	public static String ADD_STUDENT_TO_SUBJECT = "Dodaj studenta na predmet";
	public static String ADD_STUDENT_TO = "Dodaj studenta na predmet: "; // + name of Subject
	
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
	public static String MENU_SAVE_DB = "Sačuvaj u bazu podataka";
	public static String MENU_CLOSE = "Zatvori";
	public static String MENU_DELETE = "Obriši";
	public static String MENU_LANGUAGE = "Jezik";
	public static String SEARCH = "Pretraga";
	public static String SEARCH_EXAMPLE = "ime: Pera ; prezime: Peric ; indeks: ra-100-2019...";
	
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
	public static String EXAMPLE_INDEX_NUM = "npr. ra-16-2016";
	public static String EXAMPLE_GRADE = "6.00 - 10.00";
	
	public static String PROFESSOR_ID_NUM_EXISTS = " - već postoji broj lične karte";
	public static String INDEX_NUM_EXISTS = " - postoji već indeks";
	public static String INDEX_NUM_DOESNT_EXIST = " - ne postoji indeks";
	public static String SUBJECT_ID_EXISTS = " - već postoji šifra predmeta";
	public static String NOT_SAME_YEAR = " - nije ista godina kao predmet";
	public static String WRONG_FORMAT = " - loš format (ab-xx-yyyy)";
	public static String INDEX_INPUT = "Upišite indeks:";
	
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
	
	public static void loadResources() {
		switch(LanguageController.getInstance().getLanguage()) {
		case 0: break;
		case 1: loadHU();
		}
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
		ASSSIGN_PROFESSOR_TO = "Professzor hozzáadása ehhez a tantárgyhoz: "; // + name of Subject
		ADD_STUDENT_TO_SUBJECT = "Hallgató hozzáadása a tantárgyhoz";
		ADD_STUDENT_TO = "Hallgató hozzáadása ehhez a tantárgyhoz: "; // + name of Subject
		
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
		MENU_SAVE_DB = "Mentés az adatbázisba";
		MENU_CLOSE = "Bezárás";
		MENU_DELETE = "Törlés";
		MENU_LANGUAGE = "Nyelv";
		SEARCH = "Keresés";
		SEARCH_EXAMPLE = "ime: Pera ; prezime: Peric ; indeks: ra-100-2019...";
		
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
		EXAMPLE_INDEX_NUM = "pl. ra-16-2016";
		EXAMPLE_GRADE = "6.00 - 10.00";
		
		PROFESSOR_ID_NUM_EXISTS = " - már létezik ilyen személyiszám";
		INDEX_NUM_EXISTS = " - már létezik ilyen index szám";
		INDEX_NUM_DOESNT_EXIST = " - nem létezik az index szám";
		SUBJECT_ID_EXISTS = " - már létezik ilyen tantárgy kódja";
		NOT_SAME_YEAR = " - nem egyforma évfolyam";
		WRONG_FORMAT = " - rossz formátum (ab-xx-yyyy)";
		INDEX_INPUT = "Vigyen be indexszámot:";
		
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
	}
}
