package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableRowSorter;

import controller.DatabaseController;
import controller.LanguageController;
import klase.StringResources;

public class MainFrame extends JFrame{

	//labela za vreme i datum
	JLabel mDateTime;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8026416994513756565L;

	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance==null)
			instance = new MainFrame();
		return instance;
	}
	private MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth*3 / 4, screenHeight*3 / 4);
		setTitle(StringResources.APPLICATION_NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//SET APPLICATION CLASS NAME - umesto "gui-Main" da pise nesto drugo
/*
		java.lang.reflect.Field awtAppClassNameField;
		try {
			awtAppClassNameField = kit.getClass().getDeclaredField("awtAppClassName");
			awtAppClassNameField.setAccessible(true);
			awtAppClassNameField.set(kit, StringResources.APPLICATION_CLASS_NAME);
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
*/
			
		this.setJMenuBar(MojMenuBar.getInstance());
		this.add(MojToolbar.getInstance(), BorderLayout.NORTH);
		
		//TODO napraviti status bar u kom pise Studentska sluzba i datum i trenutno vreme
		
		mDateTime = new JLabel();
		JPanel statusBar = new JPanel();
		statusBar.setBackground(Color.LIGHT_GRAY);
		//statusBar.setPreferredSize(new Dimension(100,30));
		statusBar.setLayout(new BorderLayout());
		statusBar.add(new JLabel(StringResources.APPLICATION_NAME), BorderLayout.WEST);
		statusBar.add(mDateTime, BorderLayout.EAST);
		
		add(statusBar,BorderLayout.SOUTH);

		
		//TODO napraviti centralni deo glavnog prozora koji ima 3 taba
		//tabovi = MojCentralni.getInstance();
		this.add(MojCentralni.getInstance(),BorderLayout.CENTER);
		MojCentralni.getInstance().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				switch(MojCentralni.getInstance().getSelectedIndex()) {
				case 0: {
					MojToolbar.getInstance().setButtonsVisible(false);
					//resetovanje filtrirane tabele
					@SuppressWarnings("unchecked")
					TableRowSorter<AbstractTableModelStudenti> studentSorter = (TableRowSorter<AbstractTableModelStudenti>) StudentiJTable.getInstance().getRowSorter();
					studentSorter.setRowFilter(null);
				}
				
				}
				if(MojCentralni.getInstance().getSelectedIndex()==2) {
					MojToolbar.getInstance().setButtonsVisible(true);
				}
				else {
					MojToolbar.getInstance().setButtonsVisible(false);
				}
				
				
			}
			
		});
		
		//thread za vreme i datum
		Thread t = new DatumThread(MainFrame.this);
		t.start();
		
		//Dijalog za zatvaranje aplikacije
		//Parametar je WindowAdapter jer u njemu su vec implementirane prazne metode WindowListener-a, tako da ne moramo implementirati sve metode listenera
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				JFrame frame = (JFrame) e.getComponent();
				int code = JOptionPane.showConfirmDialog(frame, StringResources.CLOSE_CONFIRMATION_MESSAGE,
						StringResources.CLOSE_WINDOW_TITLE, JOptionPane.YES_NO_OPTION);
				if (code != JOptionPane.YES_OPTION) {
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} else {
					LanguageController.getInstance().saveLanguage();
					DatabaseController.save();
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
			}
			
		});
		
		setIconImage(new ImageIcon("images/icon.png").getImage());
		
		DatabaseController.load();

	}
}
