package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import gui.AbstractTableModelStudenti;
import gui.MojCentralni;
import gui.MojToolbar;
import gui.StudentiJTable;
import klase.Fields;
import klase.Proveri;
import klase.StringResources;

public class SearchListener implements ActionListener {
	
	private TableRowSorter<AbstractTableModelStudenti> studentSorter;
	private List<RowFilter<Object,Object>> rowFilters;
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		studentSorter = (TableRowSorter<AbstractTableModelStudenti>) StudentiJTable.getInstance().getRowSorter();
		rowFilters = new ArrayList<RowFilter<Object,Object>>();
		
		String query = MojToolbar.getInstance().getQuery();
		
		int selectedTab = MojCentralni.getInstance().getSelectedIndex();
		
		switch(selectedTab) {
		case 0: //studenti
		{
			if(query.equals("")) {
				studentSorter.setRowFilter(null);
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
				
				if(!setStudentQueryFilter(paramName, paramVal)) {
					MojToolbar.getInstance().searchError();
					return;
				}
			}
			
			//search...
			studentSorter.setRowFilter(RowFilter.andFilter(rowFilters));
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
	
	private boolean setStudentQueryFilter(String name, String val) {
		
		String regex = "(?i)^" + Pattern.quote(val) + "$";
		
		if(name.equalsIgnoreCase(Fields.INDEKS))
			if(Proveri.isBrojIndeksa(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 0));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.IME)) 
			if(Proveri.isIme(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 1));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.PREZIME))
			if(Proveri.isIme(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 2));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.DATRODJ))
			if(Proveri.isDatum(val)) {
				//datum koji sam uneo
				LocalDate local = LocalDate.parse(val, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));

				//nijedan ugradjeni filter ne koristi LocalDate zato treba napraviti svoj filter
				RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
				      public boolean include(Entry<?, ?> entry) {
				        LocalDate localD = (LocalDate) entry.getValue(3); //dobavlja datum iz 3. kolone
				        return local.compareTo(localD) == 0;	//filtrira datum ako su jednaki
				      }
				    };
				
				this.rowFilters.add(filter);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.ADRESA))
			if(Proveri.isAdresa(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 4));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.TELEFON))
			if(Proveri.isTelefon(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 5));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.EMAIL))
			if(Proveri.isEmail(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 6));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.DATUPIS))
			if(Proveri.isDatum(val)) {
				//datum koji sam uneo
				LocalDate local = LocalDate.parse(val, DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));

				//nijedan ugradjeni filter ne koristi LocalDate zato treba napraviti svoj filter
				RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
				      public boolean include(Entry<?, ?> entry) {
				        LocalDate localD = (LocalDate) entry.getValue(7); //dobavlja datum iz 7. kolone
				        return local.compareTo(localD) == 0;	//filtrira datum ako su jednaki
				      }
				};
				
				this.rowFilters.add(filter);
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.GODINA))
			if(Proveri.isGodina(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 8));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.STATUS))
			if(Proveri.isStatus(val)) {
				regex = "(?i)^" + Pattern.quote(val.equalsIgnoreCase("b") ? StringResources.STATUS_B : StringResources.STATUS_S) + "$";
				this.rowFilters.add(RowFilter.regexFilter(regex, 9));
				return true;
			}
			else
				return false;
		else if(name.equalsIgnoreCase(Fields.PROSEK))
			if(Proveri.isProsek(val)) {
				this.rowFilters.add(RowFilter.regexFilter(regex, 10));
				return true;
			}
			else
				return false;
		
		return false;
	}

}
