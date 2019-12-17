package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MojCentralni;
import gui.StudentiJTable;
import klase.BazaStudenta;

public class DeleteListener implements ActionListener {

	private int selectedTab;
	
	public DeleteListener() {
		
	}
	
	public DeleteListener(int selectedTab) {
		this.selectedTab = selectedTab;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(this.selectedTab) {
		case 0: {
			//TODO obrisi studenta
			//Student st = StudentController.getInstance().
			//BazaStudenta.getInstance().izbrisiStudenta();
		}
		case 1: {
			//TODO obrisi profesora
		}
		case 2: {
			//TODO obrisi predmeta
		}
		}

	}

}
