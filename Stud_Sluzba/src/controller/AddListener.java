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
		
		int selectedTab = MojCentralni.getInstance().getSelectedIndex();
		
		switch(selectedTab) {
		case 0:
			if(MojCentralni.getInstance().getTabelaStudenata().getSelectedRow()!=-1 || mode==AddDialog.ADD_MODE) { //ako smo selektovali
				AddDialog d = new AddDialog(MainFrame.getInstance(), selectedTab, mode);
				d.setVisible(true);
			}
			break;
		case 1:
			if(MojCentralni.getInstance().getTabelaStudenata().getSelectedRow()!=-1 || mode==AddDialog.ADD_MODE) { //TODO getTabelaProfesora
				AddDialog d = new AddDialog(MainFrame.getInstance(), selectedTab, mode);
				d.setVisible(true);
			}
			break;
		case 2:
			if(MojCentralni.getInstance().getTablPredmeti().getSelectedRow()!=-1 || mode==AddDialog.ADD_MODE) {
				AddDialog d = new AddDialog(MainFrame.getInstance(), selectedTab, mode);
				d.setVisible(true);
			}
		}
		
		
	}
}
