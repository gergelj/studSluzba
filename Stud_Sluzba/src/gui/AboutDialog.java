package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import klase.StringResources;

public class AboutDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4147155878851661385L;
	
	private JButton vucaj_btn;
	
	public AboutDialog() {}
	public AboutDialog(Frame parent) {
		super(parent, StringResources.ABOUT, false);
		setSize(550, 500);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		
		JPanel vucaj = new JPanel();
		vucaj.setLayout(new BorderLayout());
		vucaj.add(new JLabel(new ImageIcon("images/vucaj-200.png")),BorderLayout.EAST);
		//vucaj.add(new JLabel("<html><b> Aleksa Vucaj, 21</b></html>"), BorderLayout.NORTH);
		
		JPanel vucaj_txt = new JPanel();
		String text = "<html><b>Aleksa Vučaj, 21</b>"+
					  "<p><b>Aleksa Vučaj</b> je išao u školu 'Žarko Zrenjanin' </p>"+
					  "<p> u Novom Sadu. Gimnaziju 'Isidora Sekulić' </p>"+
					  "<p> završava 2017 i iste godine upisuje fakultet. </p>"+
					  "<p> Trenutno je student treće godine</p>"+
					  "<p> Fakulteta tehničkih nauka u Novom Sadu. </p>"+
					  "<p> <br><br><br><br><br><br>Kontakt mail: vucajaleksa@uns.ac.rs</p></html>";
		vucaj_txt.add(new JLabel(text));
		
		vucaj.add(vucaj_txt,BorderLayout.WEST);
		
		JPanel kis = new JPanel();
		kis.setLayout(new BorderLayout());
		kis.add(new JLabel(new ImageIcon("images/kis-200.png")),BorderLayout.WEST);
		//kis.add(new JLabel("<html><b>Gergelj Kiš, 21</b></html>"),BorderLayout.NORTH);
		
		JPanel gergo_txt = new JPanel();
		String text2 = "<html><b>Gergelj Kiš, 21</b>"+
				  "<p><b>Gergelj Kiš</b> je išao u školu 'Ivo Andrić' </p>"+
				  "<p> u Budisavi. ETŠ 'Mihajlo Pupin' u Novom Sadu </p>"+
				  "<p> završava 2017 i iste godine upisuje fakultet. </p>"+
				  "<p> Trenutno je student treće godine</p>"+
				  "<p> Fakulteta tehničkih nauka u Novom Sadu. </p>"+
				  "<p> <br><br><br><br><br><br>Kontakt mail: gergo@uns.ac.rs</p></html>";
		gergo_txt.add(new JLabel(text2));
		
		kis.add(gergo_txt,BorderLayout.EAST);
		
		panel.add(vucaj, BorderLayout.NORTH);
		panel.add(kis, BorderLayout.SOUTH);
		add(panel);
		
	}
}
