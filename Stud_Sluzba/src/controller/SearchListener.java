package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import gui.MojCentralni;
import gui.MojToolbar;
import klase.Fields;
import klase.Proveri;
import klase.Student;

public class SearchListener implements ActionListener {

	private Student studentQuery;
	private List<String> searchList;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		studentQuery = new Student();
		searchList = new ArrayList<String>();
		
		String query = MojToolbar.getInstance().getQuery();
		
		int selectedTab = MojCentralni.getInstance().getSelectedIndex();
		
		switch(selectedTab) {
		case 0: //studenti
		{
			if(query.equals("")) {
				StudentController.getInstance().clearSearch();
				return;
			}
			
			String subQuery[] = query.split(";");
			
			for(int i = 0; i<subQuery.length; i++) {
				String params[] = subQuery[i].split(":");
				if(params.length != 2) {
					MojToolbar.getInstance().searchError();
					return;
				}
				
				String paramName = params[0].trim();
				String paramVal = params[1].trim();
				
				if(!setStudentQuery(paramName, paramVal)) {
					MojToolbar.getInstance().searchError();
					return;
				}
			}
			
			//search...
			StudentController.getInstance().search(searchList, studentQuery);
			
		}
			break;
		case 1: //profesori
		{
			//TODO: Search profesors
		}
			break;
		case 2: //predmeti
		{
			//TODO: Search subjects
		}
			break;
		}

	}
	
	private boolean setStudentQuery(String name, String val) {
		
		if(name.equalsIgnoreCase(Fields.INDEKS))
			if(Proveri.isBrojIndeksa(val)) {
				this.studentQuery.setBrojIndeksa(val);
				this.searchList.add(Fields.INDEKS);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.IME)) 
			if(Proveri.isIme(val)) {
				this.studentQuery.setIme(val);
				this.searchList.add(Fields.IME);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.PREZIME))
			if(Proveri.isIme(val)) {
				this.studentQuery.setPrezime(val);
				this.searchList.add(Fields.PREZIME);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.DATRODJ))
			if(Proveri.isDatum(val)) {
				this.studentQuery.setDatumRodjenja(val);
				this.searchList.add(Fields.DATRODJ);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.ADRESA))
			if(Proveri.isAdresa(val)) {
				this.studentQuery.setAdresa(val);
				this.searchList.add(Fields.ADRESA);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.TELEFON))
			if(Proveri.isTelefon(val)) {
				this.studentQuery.setTelefon(val);
				this.searchList.add(Fields.TELEFON);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.EMAIL))
			if(Proveri.isEmail(val)) {
				this.studentQuery.setEmail(val);
				this.searchList.add(Fields.EMAIL);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.DATUPIS))
			if(Proveri.isDatum(val)) {
				this.studentQuery.setDatumUpisa(val);
				this.searchList.add(Fields.DATUPIS);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.STATUS))
			if(Proveri.isStatus(val)) {
				this.studentQuery.setStatus(val);
				this.searchList.add(Fields.STATUS);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.GODINA))
			if(Proveri.isGodina(val)) {
				this.studentQuery.setGodina(val);
				this.searchList.add(Fields.GODINA);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.PROSEK))
			if(Proveri.isProsek(val)) {
				this.studentQuery.setProsek(val);
				this.searchList.add(Fields.PROSEK);
				return true;
			}
			else
				return false;
		
		return false;
	}

}
