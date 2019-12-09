package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AddDialog;
import gui.MainFrame;
import gui.MojCentralni;

public class AddListener implements ActionListener {

	private int mode;
	
	public AddListener(int mode) {
		this.mode = mode;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AddDialog d = new AddDialog(MainFrame.getInstance(), MojCentralni.getInstance().getSelectedIndex(), mode);
		d.setVisible(true);
	}
}
