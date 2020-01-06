package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import listeneri.AddListener;
import listeneri.DeleteListener;
import listeneri.SaveToDatabaseListener;
import klase.StringResources;

public class MojMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1107467685534769718L;

	private static MojMenuBar instance = null;
	
	public static MojMenuBar getInstance() {
		if(instance==null)
			instance = new MojMenuBar();
		return instance;
	}
	
	private MojMenuBar() {

		JMenu file = new JMenu(StringResources.MENU_FILE);
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenu edit = new JMenu(StringResources.MENU_EDIT);
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenu help = new JMenu(StringResources.MENU_HELP);
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem new_mi = new JMenuItem(StringResources.MENU_NEW, new ImageIcon("images/add-22.png"));
		new_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));		//CTRL+N
		new_mi.addActionListener(new AddListener(AddDialog.ADD_MODE));
		
		JMenuItem report_mi = new JMenuItem(StringResources.MENU_REPORT, new ImageIcon("images/report-22.png"));
		report_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));	 	//CTRL+R
		report_mi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MojCentralni.getInstance().getSelectedIndex()) {
				case 0:
					if(StudentiJTable.getInstance().getSelectedRow() == -1)
						return;
					break;
				case 1:
					if(ProfesoriJTable.getInstance().getSelectedRow() == -1)
						return;
					break;
				case 2:
					if(PredmetiJTable.getInstance().getSelectedRow() == -1)
						return;
					break;
				}
				
				ReportDialog d = new ReportDialog(MojCentralni.getInstance().getSelectedIndex());
				d.setVisible(true);
			}
		});
		
		JMenuItem save_mi = new JMenuItem(StringResources.MENU_SAVE_DB, new ImageIcon("images/save-22.png"));
		save_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));		//CTRL+S
		save_mi.addActionListener(new SaveToDatabaseListener());
		
		JMenuItem close_mi = new JMenuItem(StringResources.MENU_CLOSE, new ImageIcon("images/close-22.png"));
		close_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));		//ALT+F4
		close_mi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), StringResources.CLOSE_CONFIRMATION_MESSAGE,
						StringResources.CLOSE_WINDOW_TITLE, JOptionPane.YES_NO_OPTION);
				if (code != JOptionPane.YES_OPTION) {
					MainFrame.getInstance().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} else {
					// TODO sacuvaj bazu objekata, da li ovde?...
					MainFrame.getInstance().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				}
			}
		});
		
		//TODO: MenuBar "Edit" Izmena postojeceg entiteta
		JMenuItem edit_mi = new JMenuItem(StringResources.MENU_EDIT, new ImageIcon("images/edit-22.png"));
		edit_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));		//CTRL+E
		edit_mi.addActionListener(new AddListener(AddDialog.EDIT_MODE));
		
		//TODO: MenuBar "Delete" Brisanje postejećeg entiteta
		JMenuItem delete_mi = new JMenuItem(StringResources.MENU_DELETE, new ImageIcon("images/trash-22.png"));
		delete_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));		//CTRL+D
		delete_mi.addActionListener(new DeleteListener());
		
		JMenuItem language_mi = new JMenuItem(StringResources.MENU_LANGUAGE, new ImageIcon("images/language-22.png"));
		language_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		language_mi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LanguageDialog d = new LanguageDialog();
				d.setVisible(true);
				
			}
			
		});
		
		//TODO: MenuBar "Help" Ova sekcija treba da sadrži detaljan opis o načinu korišćenja aplikacije.
		//Potrebno je objasniti kako se svaka od dolenavedenih funkcionalnosti može sprovesti u
		//delo i to u vidu niza korisničkih akcija. Takođe, potrebno je navesti prečice
		//(akceleratore) koje naprednim korisnicima mogu olakšati rad.
		JMenuItem help_mi = new JMenuItem(StringResources.MENU_HELP, new ImageIcon("images/help-22.png"));
		help_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));		//CTRL+H
		help_mi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDialog d = new HelpDialog();
				d.setVisible(true);
			}
			
		});
		
		//TODO MenuBar "About" Prikaz verzije aplikacije, kao i kratak opis iste.
		// Nakon toga treba da sledi sažeta biografija svakog autora.
		JMenuItem about_mi = new JMenuItem(StringResources.ABOUT, new ImageIcon("images/about-22.png"));
		about_mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));		//CTRL+A
		about_mi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog ad = new AboutDialog(MainFrame.getInstance());
				ad.setVisible(true);
			}
			
		});
		
		file.add(new_mi);
		file.add(report_mi);
		file.add(save_mi);
		file.add(close_mi);
		
		edit.add(edit_mi);
		edit.add(delete_mi);
		
		help.add(help_mi);
		help.add(language_mi);
		help.add(about_mi);
		
		add(file);
		add(edit);
		add(help);
		
	}
}
