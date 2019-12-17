package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.MainFrame;
import gui.MojCentralni;
import gui.PredmetiJTable;
import gui.ProfesoriJTable;
import gui.StudentiJTable;
import klase.BazaStudenta;
import klase.Student;

public class DeleteListener implements ActionListener {
	
	public DeleteListener() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedTab = MojCentralni.getInstance().getSelectedIndex();
		
		if((selectedTab==0 && StudentiJTable.getInstance().getSelectedRow()!=-1)||(selectedTab==1 && ProfesoriJTable.getInstance().getSelectedRow()!=-1)||(selectedTab==2 && PredmetiJTable.getInstance().getSelectedRow()!=-1)) {
			String message = null;
			String title = null;
			
			switch(selectedTab) {
			case 0: {
				message = "Da li biste stvarno zeleli da obrisete studenta?";
				title = "Delete Student";
			} break;
			case 1: {
				message = "Da li biste stvarno zeleli da obrisete profesora?";
				title = "Delete Profesor";
			} break;
			case 2: {
				message = "Da li biste stvarno zeleli da obrisete predmet?";
				title = "Delete Predmet";
			} break;
			}
			
			int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), message, title, JOptionPane.YES_NO_OPTION);
			if (code == JOptionPane.YES_OPTION) {
				switch(selectedTab) {
				case 0: {
					StudentController.getInstance().izbrisiStudenta(StudentiJTable.getInstance().getSelectedRow());
				} break;
				case 1: {
					ProfesorController.getInstance().izbrisiProfesora(ProfesoriJTable.getInstance().getSelectedRow());
				} break;
				case 2: {
					PredmetController.getInstance().izbrisiPredmet(PredmetiJTable.getInstance().getSelectedRow());
				} break;
				}
			}
		}

	}

}
