package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AddDialog;
import gui.MainFrame;

public class AddListener implements ActionListener {

	private MainFrame frame;
	public AddListener() {}
	public AddListener(MainFrame mf) {
		this.frame = mf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		AddDialog d = new AddDialog(frame, frame.getTabovi().getSelectedIndex());
		d.setVisible(true);
	}

}
