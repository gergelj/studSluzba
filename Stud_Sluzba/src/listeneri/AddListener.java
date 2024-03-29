package listeneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AddDialog;
import gui.MainFrame;
import gui.MojCentralni;
import gui.PredmetiJTable;
import gui.ProfesoriJTable;
import gui.StudentiJTable;

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
			if(StudentiJTable.getInstance().getSelectedRow()!=-1 || mode==AddDialog.ADD_MODE) { //ako smo selektovali
				AddDialog d = new AddDialog(MainFrame.getInstance(), selectedTab, mode);
				d.setVisible(true);
			}
			break;
		case 1:
			if(ProfesoriJTable.getInstance().getSelectedRow()!=-1 || mode==AddDialog.ADD_MODE) {
				AddDialog d = new AddDialog(MainFrame.getInstance(), selectedTab, mode);
				d.setVisible(true);
			}
			break;
		case 2:
			if(PredmetiJTable.getInstance().getSelectedRow()!=-1 || mode==AddDialog.ADD_MODE) {
				AddDialog d = new AddDialog(MainFrame.getInstance(), selectedTab, mode);
				d.setVisible(true);
			}
		}
		
		
	}
}
