package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import klase.StringResources;

public class AboutDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4147155878851661385L;

	public AboutDialog() {}
	public AboutDialog(Frame parent) {
		super(parent, StringResources.ABOUT, false);
		setSize(400, 500);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		
		JPanel vucaj = new JPanel();
		vucaj.setLayout(new BoxLayout(vucaj, BoxLayout.X_AXIS));
		vucaj.add(new JLabel(new ImageIcon("images/vucaj-200.png")));
		vucaj.add(new JLabel("Aleksa Vučaj, 21"));

		JPanel kis = new JPanel();
		kis.setLayout(new BoxLayout(kis, BoxLayout.X_AXIS));
		kis.add(new JLabel(new ImageIcon("images/kis-200.png")));
		kis.add(new JLabel("Gergelj Kiš, 21"));
		
		panel.add(vucaj, BorderLayout.NORTH);
		panel.add(kis, BorderLayout.SOUTH);
		add(panel);
		
	}
}
