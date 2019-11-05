package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MojMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1107467685534769718L;

	public MojMenuBar() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		//TODO: MenuBar "New" Dodavanje novog entiteta u sistem
		JMenuItem new_mi = new JMenuItem("New", new ImageIcon("images/add-22.png"));
		new_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));		//CTRL+N
		
		//TODO: MenuBar "Close" Zatvaranje aplikacije
		JMenuItem close_mi = new JMenuItem("Close", new ImageIcon("images/close-22.png"));
		close_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));		//ALT+F4
		
		//TODO: MenuBar "Edit" Izmena postojeceg entiteta
		JMenuItem edit_mi = new JMenuItem("Edit", new ImageIcon("images/edit-22.png"));
		edit_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));		//CTRL+E
		
		//TODO: MenuBar "Delete" Brisanje postejećeg entiteta
		JMenuItem delete_mi = new JMenuItem("Delete", new ImageIcon("images/trash-22.png"));
		delete_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));		//CTRL+D
		
		//TODO: MenuBar "Help" Ova sekcija treba da sadrži detaljan opis o načinu korišćenja aplikacije.
		//Potrebno je objasniti kako se svaka od dolenavedenih funkcionalnosti može sprovesti u
		//delo i to u vidu niza korisničkih akcija. Takođe, potrebno je navesti prečice
		//(akceleratore) koje naprednim korisnicima mogu olakšati rad.
		JMenuItem help_mi = new JMenuItem("Help", new ImageIcon("images/help-22.png"));
		help_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));		//CTRL+H
		
		//TODO MenuBar "About" Prikaz verzije aplikacije, kao i kratak opis iste.
		// Nakon toga treba da sledi sažeta biografija svakog autora.
		JMenuItem about_mi = new JMenuItem("About", new ImageIcon("images/about-22.png"));
		about_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));		//CTRL+A
		
		file.add(new_mi);
		file.add(close_mi);
		
		edit.add(edit_mi);
		edit.add(delete_mi);
		
		help.add(help_mi);
		help.add(about_mi);
		
		add(file);
		add(edit);
		add(help);
		
	}
}
