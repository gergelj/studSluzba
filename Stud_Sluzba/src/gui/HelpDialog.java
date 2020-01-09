package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import klase.StringResources;
import klase.DocsFile;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6243786012852231728L;
	private JEditorPane htmlPane;
	private JTree tree;
	public DefaultMutableTreeNode top;
	
	public HelpDialog() {
		super(MainFrame.getInstance(), StringResources.APPLICATION_NAME + " v " + StringResources.VERSION, false);
		setSize(1100, 600);
		setLocationRelativeTo(MainFrame.getInstance());

		// PANEL sa Tree view
		top = new DefaultMutableTreeNode(new DocsFile("Help", "<h2>Izaberite stavku iz levog panela.</h2>"));
		// Kreiramo JTree se single selection
		tree = new JTree(top);
		kreirajStablo(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.expandPath(new TreePath(top.getPath()));
		// Nakacimo lisener na selekciju
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();
				if (node == null)
					return;
				Object nodeObject = node.getUserObject();
				DocsFile p = (DocsFile) nodeObject;
				htmlPane.setText(p.getContent());
			}
		});

		// Kreiramo Scroll Panel sa ovim stablom
		JScrollPane treeView = new JScrollPane(tree);
		// Kreiramo HTML viewer
		htmlPane = new JEditorPane();
		htmlPane.setContentType("text/html");
		htmlPane.setEditable(false);
		JScrollPane htmlView = new JScrollPane(htmlPane);
		
		htmlPane.setText(((DocsFile)top.getUserObject()).getContent());
		// Kreiramo spliter
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setTopComponent(treeView);
		splitPane.setBottomComponent(htmlView);
		Dimension minimumSize = new Dimension(100, 50);
		htmlView.setMinimumSize(minimumSize);
		treeView.setMinimumSize(minimumSize);
		splitPane.setDividerLocation(250);
		
		splitPane.setPreferredSize(new Dimension(500, 300));
		// Dodamo spliter
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
				
	}
	
	private void kreirajStablo(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode cvor = null;

		cvor = new DefaultMutableTreeNode(new DocsFile("General", this.getMainHTML()));
		top.add(cvor);
		
		cvor.add(new DefaultMutableTreeNode(new DocsFile("Prečice", this.getShortcutsHTML())));

		/**** DODAVANJE ****/
		
		DefaultMutableTreeNode dodavanje = new DefaultMutableTreeNode(
				new DocsFile("Dodavanje",
						"<h1>Dodavanje</h1><p>Otvorite folder 'Dodavanje' za specifičnu funkcionalnost.</p>"));
		top.add(dodavanje);
		
		DefaultMutableTreeNode dodavanjeStud = new DefaultMutableTreeNode(
				new DocsFile("Dodavanje studenta", this.getDodavanjeStudentaHTML()));

		dodavanje.add(dodavanjeStud);
		
		DefaultMutableTreeNode dodavanjeStudNaPredm = new DefaultMutableTreeNode(
				new DocsFile("Dodavanje studenta na predmet", this.getDodavanjeStudentaNaPredmetHTML()));

		dodavanjeStud.add(dodavanjeStudNaPredm);
		
		DefaultMutableTreeNode dodavanjeProf = new DefaultMutableTreeNode(
				new DocsFile("Dodavanje profesora", this.getDodavanjeProfesoraHTML()));

		dodavanje.add(dodavanjeProf);
		
		DefaultMutableTreeNode dodavanjeProfNaPredm = new DefaultMutableTreeNode(
				new DocsFile("Dodavanje profesora na predmet", this.getDodavanjeProfesoraNaPredmetHTML()));

		dodavanjeProf.add(dodavanjeProfNaPredm);
		
		DefaultMutableTreeNode dodavanjePredm = new DefaultMutableTreeNode(
				new DocsFile("Dodavanje predmeta", this.getDodavanjePredmetaHTML()));

		dodavanje.add(dodavanjePredm);
		
		/**** IZMENA ****/
		
		DefaultMutableTreeNode izmena = new DefaultMutableTreeNode(
				new DocsFile("Izmena",
						"<h1>Izmena</h1><p>Otvorite folder 'Izmena' za specifičnu funkcionalnost.</p>"));
		top.add(izmena);
		
		DefaultMutableTreeNode izmenaStud = new DefaultMutableTreeNode(
				new DocsFile("Izmena studenta", this.getIzmenaStudentaHTML()));

		izmena.add(izmenaStud);
		
		DefaultMutableTreeNode izmenaProf = new DefaultMutableTreeNode(
				new DocsFile("Izmena profesora", this.getIzmenaProfesoraHTML()));

		izmena.add(izmenaProf);
		
		DefaultMutableTreeNode izmenaPredm = new DefaultMutableTreeNode(
				new DocsFile("Izmena predmeta", this.getIzmenaPredmetaHTML()));

		izmena.add(izmenaPredm);

		/**** BRISANJE ****/
		
		DefaultMutableTreeNode brisanje = new DefaultMutableTreeNode(
				new DocsFile("Brisanje",
						"<h1>Brisanje</h1><p>Otvorite folder 'Brisanje' za specifičnu funkcionalnost.</p>"));
		top.add(brisanje);
		
		DefaultMutableTreeNode brisanjeStud = new DefaultMutableTreeNode(
				new DocsFile("Brisanje studenta", this.getBrisanjeStudentaHTML()));

		brisanje.add(brisanjeStud);
		
		DefaultMutableTreeNode brisanjeProf = new DefaultMutableTreeNode(
				new DocsFile("Brisanje profesora", this.getBrisanjeProfesoraHTML()));

		brisanje.add(brisanjeProf);
		
		DefaultMutableTreeNode brisanjePredm = new DefaultMutableTreeNode(
				new DocsFile("Brisanje predmeta", this.getBrisanjePredmetaHTML()));

		brisanje.add(brisanjePredm);
		
		/**** PRETRAGA ****/
		
		DefaultMutableTreeNode pretraga = new DefaultMutableTreeNode(
				new DocsFile("Pretraga", this.getPretragaHTML()));
		top.add(pretraga);
		
		/**** SORTIRANJE ****/
		
		DefaultMutableTreeNode sortiranje = new DefaultMutableTreeNode(
				new DocsFile("Sortiranje", this.getSortiranjeHTML()));
		top.add(sortiranje);
		
		top.add(new DefaultMutableTreeNode(new DocsFile("Ostalo", this.getOtherHTML())));
	
		
	}

	public void selectNode(DefaultMutableTreeNode item) {
		TreeNode[] path = item.getPath();
		TreePath tp = new TreePath(path);
		tree.addSelectionPath(tp);
	}
	
	/******************** HTML ***********************/
	
	private String getMainHTML() {
		URL img_url0 = null;
		URL img_url1 = null;
		URL img_url2 = null;
		URL img_url3 = null;
		URL img_url4 = null;
		URL img_url5 = null;
		URL img_url6 = null;
		URL img_url7 = null;
		URL img_url8 = null;
		URL img_url9 = null;
		
		try {
			img_url0 = new File("images/doc/general.png").toURI().toURL();
			img_url1 = new File("images/add-22.png").toURI().toURL();
			img_url2 = new File("images/edit-22.png").toURI().toURL();
			img_url3 = new File("images/trash-22.png").toURI().toURL();
			img_url4 = new File("images/save-22.png").toURI().toURL();
			img_url5 = new File("images/unsort-22.png").toURI().toURL();
			img_url6 = new File("images/add-student-22.png").toURI().toURL();
			img_url7 = new File("images/professor-22.png").toURI().toURL();
			img_url8 = new File("images/search-22.png").toURI().toURL();
			img_url9 = new File("images/professorx.png").toURI().toURL();
			
		} catch (MalformedURLException e) {}
		
		return "<h1>Studentska služba</h1>" + 
				"<img src=\"" + img_url0.toString() + "\" alt=\"GENERAL\"/>" + 
				"<h2>Menubar</h2>" + 
				"<p>Opcije za manipulisanje podacima i aplikacijom.</p>" + 
				"<p>Fajl &gt; Novi - pogledajte dokumentaciju za <em>Dodavanje</em></p>" + 
				"<p>Fajl &gt; Izveštaj - pogledajte dokumentaciju <em>Ostalo</em></p>" + 
				"<p>Fajl &gt; Sačuvaj u bazu - pogledajte dokumentaciju <em>Ostalo</em></p>" + 
				"<p>Fajl &gt; Zatvori - zatvaranje aplikacije</p>" + 
				"<br>" + 
				"<p>Izmena &gt; Izmena - pogledajte dokumentaciju <em>Izmena</em></p>" + 
				"<p>Izmena &gt; Obriši - pogledajte dokumentacije za <em>Brisanje</em></p>" + 
				"<br>" + 
				"<p>Pomoć &gt; Pomoć - dokumentacija</p>" + 
				"<p>Pomoć &gt; Jezik - pogledajte dokumentaciju <em>Ostalo</em></p>" + 
				"<p>Pomoć &gt; O aplikaciji - podaci o autorima aplikacije</p>" + 
				"<h2>Toolbar</h2>" + 
				"<p><img src=\"" + img_url1.toString() + "\" alt=\"ADD\" height=\"22\" width=\"22\" /> Dodaj - pogledajte dokumentaciju za <em>Dodavanje</em></p>" + 
				"<p><img src=\"" + img_url2.toString() + "\" alt=\"EDIT\" height=\"22\" width=\"22\" /> Izmena - pogledajte dokumentaciju <em>Izmena</em></p>" + 
				"<p><img src=\"" + img_url3.toString() + "\" alt=\"DELETE\" height=\"22\" width=\"22\" /> Obriši - pogledajte dokumentacije za <em>Brisanje</em></p>" + 
				"<p><img src=\"" + img_url4.toString() + "\" alt=\"SAVE\" height=\"22\" width=\"22\" /> Sačuvaj u bazu - pogledajte dokumentaciju <em>Ostalo</em></p>" + 
				"<p><img src=\"" + img_url5.toString() + "\" alt=\"UNSORT\" height=\"22\" width=\"22\" /> Vratiti originalni redosled u tabeli - pogledajte dokumentaciju <em>Sortiranje</em></p>" + 
				"<p><img src=\"" + img_url6.toString() + "\" alt=\"ADD_STUDENT\" height=\"22\" width=\"22\" /> Dodavanje studenta na predmet (vidljiv samo za predmete) - pogledajte dokumentaciju <em>Dodavanje studenta na predmet</em></p>" + 
				"<p><img src=\"" + img_url7.toString() + "\" alt=\"ADD_PROFESSOR\" height=\"22\" width=\"22\" /> Dodavanje profesora na predmet (vidljiv samo za predmete) - pogledajte dokumentaciju <em>Dodavanje profesora na predmet</em></p>" + 
				"<p><img src=\"" + img_url9.toString() + "\" alt=\"DELETE_PROFESSOR\" height=\"22\" width=\"22\" /> Brisanje profesora sa predmeta (vidljiv samo za predmete) - pogledajte dokumentaciju <em>Brisanje profesora</em></p>" + 
				"<p><img src=\"" + img_url8.toString() + "\" alt=\"SEARCH\" height=\"22\" width=\"22\" /> Pretraga - pogledajte dokumentaciju <em>Pretraga</em></p>" + 
				"<h2>Tabovi i tabele</h2>" + 
				"<p>Prikaz studenata, profesora ili predmeta u zavisnosti koji tab je odabran.</p>" + 
				"<h2>Status bar</h2>" + 
				"<p>U donjem levom uglu prikaz naziva aplikacije, u desnom uglu trenutni datum i vreme.</p>";
	}
	
	private String getShortcutsHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		URL img_url3 = null;
		URL img_url4 = null;
		URL img_url5 = null;
		URL img_url6 = null;
		URL img_url7 = null;
		URL img_url8 = null;
		URL img_url9 = null;
		
		try {
			img_url1 = new File("images/add-22.png").toURI().toURL();
			img_url2 = new File("images/edit-22.png").toURI().toURL();
			img_url3 = new File("images/trash-22.png").toURI().toURL();
			img_url4 = new File("images/close-22.png").toURI().toURL();
			img_url5 = new File("images/help-22.png").toURI().toURL();
			img_url6 = new File("images/about-22.png").toURI().toURL();
			img_url7 = new File("images/language-22.png").toURI().toURL();
			img_url8 = new File("images/report-22.png").toURI().toURL();
			img_url9 = new File("images/save-22.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return "<h1>Prečice</h1>" + 
				"<p><img src=\"" + img_url1.toString() + "\" height=\"22\" width=\"22\" /> Dodaj novi - Ctrl+N</p>" + 
				"<p><img src=\"" + img_url2.toString() + "\" height=\"22\" width=\"22\" /> Izmena - Ctrl+E</p>" + 
				"<p><img src=\"" + img_url3.toString() + "\" height=\"22\" width=\"22\" /> Brisanje - Ctrl+D</p>" + 
				"<br>" + 
				"<p><img src=\"" + img_url4.toString() + "\" height=\"22\" width=\"22\" /> Zatvori aplikaciju - Alt+F4</p>" + 
				"<p><img src=\"" + img_url5.toString() + "\" height=\"22\" width=\"22\" /> Pomoćna dokumentacija - Ctrl+H</p>" + 
				"<p><img src=\"" + img_url6.toString() + "\" height=\"22\" width=\"22\" /> O aplikaciji - Ctrl+A</p>" + 
				"<br>" + 
				"<p><img src=\"" + img_url7.toString() + "\" height=\"22\" width=\"22\" /> Promeni jezik - Ctrl+L</p>" + 
				"<p><img src=\"" + img_url8.toString() + "\" height=\"22\" width=\"22\" /> Napravi izveštaj - Ctrl+R</p>" + 
				"<p><img src=\"" + img_url9.toString() + "\" height=\"22\" width=\"22\" /> Sačuvaj u bazu - Ctrl+S</p>" + 
				"<br>" + 
				"<h3>Promena tabova</h3>" + 
				"<p>Alt+1 za student tabelu</p>" + 
				"<p>Alt+2 za profesor tabelu</p>" + 
				"<p>Alt+3 za predmet tabelu</p>";
	}
	
	private String getOtherHTML() {
		
		URL img_url1 = null;
		URL img_url2 = null;
		URL img_url3 = null;
		URL img_url4 = null;
		
		try {
			img_url1 = new File("images/save-22.png").toURI().toURL();
			img_url2 = new File("images/doc/jezik.png").toURI().toURL();
			img_url3 = new File("images/report-22.png").toURI().toURL();
			img_url4 = new File("images/language-22.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return "<h1>Ostalo</h1>" + 
				"<h2>Baza podataka</h2>" + 
				"<p>Aplikacija automatski sačuva stanje svih tabela prilikom zatvaranja i učita ih prilikom pokretanja. Klikom na dugme <img src=\"" + img_url1.toString() + "\" alt=\"SAVE\" height=\"22\" width=\"22\" /> korisnik može da sačuva tabele bez zatvaranja aplikacije.</p>" + 
				"<h2>Podešavanje jezika</h2>" + 
				"<p>Pomoć &gt; <img src=\"" + img_url4.toString() + "\" alt=\"JEZIK\"/> Jezik</p>" + 
				"<img src=\"" + img_url2.toString() + "\" alt=\"JEZIK\"/>" + 
				"<h2>Izveštaji</h2>" + 
				"<p>Ako želite da otvorite izveštaj o jednom studentu, profesoru ili predmetu, prvo izaberite željenu stavku i kliknite na Fajl &gt; <img src=\"" + img_url3.toString() + "\" height=\"22\" width=\"22\" /> Izveštaj.</p>";
	}
	
	private String getDodavanjeStudentaHTML() {
		
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/add-22.png").toURI().toURL();
			img_url2 = new File("images/doc/input_student.png").toURI().toURL();
		} catch (MalformedURLException e) {}

		return	"<h1>Dodavanje studenta</h1>" + 
				"<p>Nakon odabira student taba, pritisnuti dugme <img src=\"" + img_url1.toString() +"\" alt=\"DODAJ\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za dodavanje studenta:</p>" +
				"<img src=\"" + img_url2.toString() +"\" alt=\"STUDENT INPUT\"/>" +
				"<p>Sva polja moraju biti validno popunjena, u suprotnom nije moguće uneti Studenta.</p>" + 
				"<p><font color=\"red\">Student sa istim brojem indeksa se ne može uneti dvaput.</font> </p>" + 
				"<hr />" + 
				"<h3>Pravilno popunjena polja</h3>" +
				"<p><strong>ime</strong> - bilo koje ime</p>" + 
				"<p><strong>prezime</strong> - bilo koje prezime</p>" + 
				"<p><strong>datum rodjenja</strong> - formata \"dd.MM.yyyy.\" gde su \"dd\" dani, \"MM\" mesec, \"yyyy\" godina</p>" + 
				"<p><strong>adresa</strong> - bilo koja adresa</p>" + 
				"<p><strong>telefon</strong> - broj telefona</p>" + 
				"<p><strong>e-mail</strong> - mora da sadrži znak \"@\"</p>" + 
				"<p><strong>broj indeksa</strong> - formata \"aa-X-yyyy\", gde je \"aa\" dva slova, X je jednocifreni/ dvocifreni ili trocifreni broj</p>" + 
				"<p><strong>datum upisa</strong> - formata \"dd.MM.yyyy.\" gde su \"dd\" dani, \"MM\" mesec, \"yyyy\" godina</p>" + 
				"<p><strong>prosek</strong> - broj između 6 i 10 (zaokružen na dve decimale)</p>";
	}
	
	private String getDodavanjeStudentaNaPredmetHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/add-student-22.png").toURI().toURL();
			img_url2 = new File("images/doc/input_student_to_predmet.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return	"<h1>Dodavanje studenta na predmet</h1>" +
				"<p>U Predmet tab-u izaberite na koji Predmet želite da dodate Studenta, zatim pritisnuti dugme <img src=\""+ img_url1.toString() +"\" alt=\"DODAJ\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za dodavanje studenta na predmet:</p>" + 
				"<img src=\""+ img_url2.toString() +"\" alt=\"STUDENTI INPUT\"/>" + 
				"<p><font color=\"red\">Trenutna godina studenta i godina kada se predmet predaje moraju da budu iste.</font> </p>" + 
				"<p>Spisak dodatih studenata na Predmet se može prikazati klikom na dugme u tabeli predmeta.</p>" + 
				"<p>Takodje spisak Predmeta svakog studenta se može prikazati klikom na dugme u tabeli studenta.</p>";
	}
	
	private String getDodavanjeProfesoraHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/add-22.png").toURI().toURL();
			img_url2 = new File("images/doc/input_profesor.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Dodavanje profesora</h1>" + 
				"<p>Nakon odabira profesor taba, pritisnuti dugme <img src=\""+ img_url1.toString() +"\" alt=\"DODAJ\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za dodavanje profesora:</p>" + 
				"<img src=\""+ img_url2.toString() +"\" alt=\"PROFESOR INPUT\"/>" + 
				"<p>Sva polja moraju biti validno popunjena, u suprotnom nije moguće uneti Profesora.</p>" + 
				"<p><font color=\"red\">Profesor sa istim brojem LK se ne može uneti dvaput.</font> </p>" + 
				"<hr />" +
				"<h3>Pravilno popunjena polja</h3>" + 
				"<p><strong>ime</strong> - bilo koje ime</p>" + 
				"<p><strong>prezime</strong> - bilo koje prezime</p>" + 
				"<p><strong>datum rodjenja</strong> - formata \"dd.MM.yyyy.\" gde su \"dd\" dani, \"MM\" mesec, \"yyyy\" godina</p>" + 
				"<p><strong>adresa</strong> - bilo koja adresa</p>" + 
				"<p><strong>telefon</strong> - broj telefona</p>" + 
				"<p><strong>e-mail</strong> - mora da sadrži znak \"@\"</p>" + 
				"<p><strong>adresa kancelarije</strong> - bilo koja adresa</p>" + 
				"<p><strong>broj LK</strong> - jedan ili više cifara</p>" + 
				"<p><strong>titula</strong> - bilo šta</p>" + 
				"<p><strong>zvanje</strong> - bilo šta</p>";
	}
	
	private String getDodavanjeProfesoraNaPredmetHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/professor-22.png").toURI().toURL();
			img_url2 = new File("images/doc/input_profesor_to_predmet.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Dodavanje profesora na predmet</h1>" + 
				"<p>U Predmet tab-u izaberite na koji Predmet želite da dodate Profesora, zatim pritisnuti dugme <img src=\""+ img_url1.toString() +"\" alt=\"DODAJ\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za dodavanje studenta na predmet:</p>" +
				"<img src=\""+ img_url2.toString() +"\" alt=\"PROFESORI INPUT\"/>" + 
				"<p><font color=\"red\">Na spisku se nalaze svi profesori, a odjednom samo jedan profesor može da predaje na Predmetu.</font> </p>";
	}
	
	private String getDodavanjePredmetaHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/add-22.png").toURI().toURL();
			img_url2 = new File("images/doc/input_predmet.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Dodavanje predmeta</h1>" +
				"<p>Nakon odabira predmet taba, pritisnuti dugme <img src=\""+ img_url1.toString() +"\" alt=\"DODAJ\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za dodavanje predmeta:</p>" + 
				"<img src=\""+ img_url2.toString() +"\" alt=\"PREDMET INPUT\"/>" +
				"<p>Sva polja moraju biti validno popunjena, u suprotnom nije moguće uneti Predmeta.</p>" + 
				"<p><font color=\"red\">Predmet sa istom šifrom se ne može uneti dvaput.</font> </p>" + 
				"<hr />" + 
				"<h3>Pravilno popunjena polja</h3>" +
				"<p><strong>šifra</strong> - jedinstvena šifra predmeta</p>" + 
				"<p><strong>naziv</strong> - naziv predmeta</p>";
	}
	
	private String getIzmenaStudentaHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/edit-22.png").toURI().toURL();
			img_url2 = new File("images/doc/edit_student.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Izmena studenta</h1>" +
				"<p>U Student tab-u izaberite Studenta koji želite da menjate, pritisnuti dugme <img src=\""+ img_url1.toString() +"\" alt=\"DODAJ\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za izmenu studenta:</p>" +
				"<img src=\""+ img_url2.toString() +"\" alt=\"STUDENT EDIT\"/>" +
				"<p>Sva polja moraju biti validno popunjena. Pogledaj <em>Dodavanje studenta</em></p>";
	}
	
	private String getIzmenaProfesoraHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/edit-22.png").toURI().toURL();
			img_url2 = new File("images/doc/edit_profesor.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Izmena profesora</h1><p>U Profesor tab-u izaberite Profesora koji želite da menjate, zatim treba pritisnuti dugme <img src=\""+ img_url1.toString() +"\" alt=\"IZMENI\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za izmenu profesora:</p>" + 
				"<img src=\""+ img_url2.toString() +"\" alt=\"PROFESOR EDIT\"/>" + 
				"<p>Sva polja moraju biti validno popunjena. Pogledati <em>Dodavanje profesora</em>.</p>";
	}
	
	private String getIzmenaPredmetaHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/edit-22.png").toURI().toURL();
			img_url2 = new File("images/doc/edit_predmet.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Izmena predmeta</h1>" +
				"<p>U Predmet tab-u izaberite Predmet koji želite da menjate, zatim treba pritisnuti dugme <img src=\""+ img_url1.toString() +"\" alt=\"EDIT\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Otvara se novi dijalog za izmenu predmeta:</p>" + 
				"<img src=\""+ img_url2.toString() +"\" alt=\"PREDMET EDIT\"/>" +
				"<p>Sva polja moraju biti validno popunjena. Pogledaj <em>Dodavanje predmeta</em></p>";
	}
	
	private String getBrisanjeStudentaHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		
		try {
			img_url1 = new File("images/trash-22.png").toURI().toURL();
			img_url2 = new File("images/doc/delete_student_from_predmet.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Brisanje studenta</h1>" + 
				"<p>Selektujte studenta koji želite da obrišete i pritisnite dugme <img src=\"" + img_url1.toString() +"\" alt=\"BRISI\" height=\"22\" width=\"22\" /></p>" + 
				"<h3>Brisanje studenta sa predmeta</h3>" +
				"<p>Pređite na tabelu predmeta i klikom na dugme lista studenata odgovarajućeg predmeta otvoriće se spisak studenata:</p>" + 
				"<img src=\"" + img_url2.toString() + "\" alt=\"STUDENT DELETE\"/>" + 
				"<p>Klikom na dugme Obriši će se ukloniti student sa predmeta.</p>";
	}
	
	private String getBrisanjeProfesoraHTML() {
		URL img_url1 = null;
		URL img_url2 = null;
		URL img_url3 = null;
		try {
			img_url1 = new File("images/trash-22.png").toURI().toURL();
			img_url2 = new File("images/doc/delete_professor_from_predmet.png").toURI().toURL();
			img_url3 = new File("images/professorx.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return "<h1>Brisanje profesora</h1>" + 
				"<p>Selektujte profesora koji želite da obrišete i pritisnite dugme <img src=\"" + img_url1.toString() + "\" alt=\"BRISI\" height=\"22\" width=\"22\" /></p>" + 
				"<h3>Brisanje profesora sa predmeta</h3>" + 
				"<p>Ovo možete uraditi na dva načina:</p>" + 
				"<p>Prvi način: Otvorite spisak predmeta profesora i klikom na UKLONI će se obrisati profesor sa odabranog predmeta.</p>" + 
				"<img src=\"" + img_url2.toString() + "\" alt=\"PROFESSOR DELETE\"/>" + 
				"<p>Drugi način: Izaberite željeni predmet sa kojeg želite da obrišete profesora i kliknite na dugme <img src=\"" + img_url3.toString() + "\" alt=\"DELETE\"/></p>" + 
				"";
	}
	
	private String getBrisanjePredmetaHTML() {
		URL img_url1 = null;

		try {
			img_url1 = new File("images/trash-22.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Brisanje predmeta</h1>" +
				"<p>Selektujte predmet koji želite da obrišete i pritisnite dugme <img src=\""+ img_url1.toString() +"\" alt=\"BRISI\" height=\"22\" width=\"22\" /></p>";
	}

	private String getPretragaHTML() {
		URL img_url1 = null;

		try {
			img_url1 = new File("images/search-22.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Pretraga</h1>" +  
				"<p>Moguće je pretražiti bazu podataka, tako što se pozicionirate na odgovarajuću tabelu i u gornjem desnom uglu ukucate vaš upit i pritisnete dugme <img src=\""+ img_url1.toString() +"\" alt=\"SEARCH\" height=\"22\" width=\"22\" /></p>" + 
				"<p>Formiranje upita se vrši na sledeći način: naziv_obelezja : vrednost</p>" + 
				"<p>Ako biste želeli da pronađete studente sa imenom Marija, vaš upit bi izgledao ovako:</p>" + 
				"<strong>ime: Marija</strong>" + 
				"<p>Takođe možete kombinovati vašu pretragu. Ako biste hteli da pronađete sve studente koji su na budžetu na trećoj godini i žive u Novom Sadu, upišite sledeće:</p>" + 
				"<strong>adresa: Novi Sad ; status: b ; godina: 3</strong>" + 
				"<p>Za prikazivanje cele baze unesite prazan upit ili pređite na drugi tab pa se vratite.</p>" +
				"<hr />" + 
				"<h2>Nazivi obeležja za studente</h2>" + 
				"<p><strong>indeks</strong> - broj indeksa studenta</p>" + 
				"<p><strong>ime</strong> - ime studenta</p>" + 
				"<p><strong>prezime</strong> - prezime studenta</p>" + 
				"<p><strong>datumr</strong> - datum rođenja studenta</p>" + 
				"<p><strong>adresa</strong> - adresa studenta</p>" + 
				"<p><strong>telefon</strong> - telefon studenta</p>" + 
				"<p><strong>email</strong> - email studenta</p>" + 
				"<p><strong>datumu</strong> - datum upisa studenta</p>" + 
				"<p><strong>godina</strong> - trenutna godina studenta (1, 2, 3 ili 4)</p>" + 
				"<p><strong>status</strong> - status studenta: <strong>b</strong> za budžet, <strong>s</strong> za samofinansiranje</p>" + 
				"<p><strong>prosek</strong> - prosek studenta</p><br>" + 
				"<em>Pogledajte stranicu Dodavanje studenta kako se pravilno popunjavaju polja da bi vaša pretraga bila uspešna.</em>" + 
				"<h2>Nazivi obeležja za profesore</h2>" + 
				"<p><strong>ime</strong> - ime profesora</p>" + 
				"<p><strong>prezime</strong> - prezime profesora</p>" + 
				"<p><strong>datumr</strong> - datum rođenja profesora</p>" + 
				"<p><strong>adresa</strong> - adresa stanovanja</p>" + 
				"<p><strong>telefon</strong> - telefon profesora</p>" + 
				"<p><strong>email</strong> - email profesora</p>" + 
				"<p><strong>kancelarija</strong> - adresa kancelarije profesora</p>" + 
				"<p><strong>brojlk</strong> - broj lične karte profesora</p>" + 
				"<p><strong>titula</strong> - titula profesora</p>" + 
				"<p><strong>zvanje</strong> - zvanje profesora</p><br>" + 
				"<em>Pogledajte stranicu Dodavanje profesora kako se pravilno popunjavaju polja da bi vaša pretraga bila uspešna.</em>" + 
				"<h2>Nazivi obeležja za predmete</h2>" + 
				"<p><strong>sifra</strong> - jedinstvena šifra predmeta</p>" + 
				"<p><strong>naziv</strong> - naziv predmeta</p>" + 
				"<p><strong>godina</strong> - godina predmeta (1, 2, 3 ili 4)</p>" + 
				"<p><strong>semestar</strong> - semestar predmeta (1, 2, 3, 4, 5, 6, 7 ili 8)</p><br>" + 
				"<em>Pogledajte stranicu Dodavanje predmeta kako se pravilno popunjavaju polja da bi vaša pretraga bila uspešna.</em>";
	}
	
	private String getSortiranjeHTML() {
		URL img_url1 = null;

		try {
			img_url1 = new File("images/unsort-22.png").toURI().toURL();
		} catch (MalformedURLException e) {}
		
		return  "<h1>Sortiranje</h1>" + 
				"<p>Ako biste želeli da sortirate studenta, profesora ili predmeta po nekoj koloni, samo kliknite na ime određene kolone.</p>" + 
				"<p>Klikom opet na tu kolonu se menja smer sortiranja (rastući/opadajući smer).</p>" + 
				"<p>Klikom na dugme <img src=\""+ img_url1.toString() +"\" alt=\"UNSORT\" height=\"22\" width=\"22\" /> se vraća originalni redosled.</p>";
	}

}
