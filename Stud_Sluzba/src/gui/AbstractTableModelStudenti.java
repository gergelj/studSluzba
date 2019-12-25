package gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import controller.StudentController;
import klase.BazaStudenta;
import klase.Student;

public class AbstractTableModelStudenti extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;

	public static String kolonaDugme = "PREDMETI";
	private int mode;
	private List<Student> searchResult;

	public AbstractTableModelStudenti() {
		super();
	}
	
	public AbstractTableModelStudenti(int mode) {
		super();
		this.mode = mode;
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= BazaStudenta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		if(mode==StudentController.NORMAL_MODE)
			return BazaStudenta.getInstance().getStudenti().size();
		else
			return searchResult.size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenta.getInstance().getColumnCount() + 1;
	}

	@Override
	public String getColumnName(int column) {
		if (column >= BazaStudenta.getInstance().getColumnCount()) {
			return kolonaDugme;
		}
		return BazaStudenta.getInstance().getColumnName(column);
	}

	// da bismo mogli prikazati dugme
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2: return String.class;
		case 3: return LocalDate.class;
		case 4:
		case 5:
		case 6: return String.class;
		case 7: return LocalDate.class;
		case 8:
		case 9:
		case 10:
			return String.class;
		case 11:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(mode == StudentController.NORMAL_MODE) {
			if (columnIndex < BazaStudenta.getInstance().getColumnCount())
				return BazaStudenta.getInstance().getValueAt(rowIndex, columnIndex);
			else if (columnIndex == BazaStudenta.getInstance().getColumnCount()+1) {
				JButton btn = new JButton("" + rowIndex);
				return btn;
			}
		}
		else {
			if (columnIndex < BazaStudenta.getInstance().getColumnCount()) {
				
				Student student = this.searchResult.get(rowIndex);
				switch(columnIndex) {
				case 0: return student.getBrojIndeksa();
				case 1: return student.getIme();
				case 2: return student.getPrezime();
				case 3: return student.getDatumRodjenja();
				case 4: return student.getAdresa();
				case 5: return student.getTelefon();
				case 6: return student.getEmail();
				case 7: return student.getDatumUpisa();
				case 8: return String.valueOf(student.getTrenutnaGodina());
				case 9: return student.getStatus()==Student.Status.B ? "budzet" : "samofinansiranje";
				case 10: return String.valueOf(student.getProsek());
				}
				
				
			}
			else if (columnIndex == BazaStudenta.getInstance().getColumnCount()+1) {
				JButton btn = new JButton("" + rowIndex);
				return btn;
			}
		}
				
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	public void search(int mode, Iterable<Student> result) {
		this.mode = mode;
		this.searchResult = (List<Student>) result;
	}
	
	public int getMode() {
		return this.mode;
	}
	
}
