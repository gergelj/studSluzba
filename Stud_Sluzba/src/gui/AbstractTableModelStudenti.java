package gui;

import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import klase.BazaStudenta;

public class AbstractTableModelStudenti extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;

	public static String kolonaDugme = "PREDMETI";

	public AbstractTableModelStudenti() {
		super();
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= BazaStudenta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaStudenta.getInstance().getStudenti().size();
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
			if (columnIndex < BazaStudenta.getInstance().getColumnCount())
				return BazaStudenta.getInstance().getValueAt(rowIndex, columnIndex);
			else if (columnIndex == BazaStudenta.getInstance().getColumnCount()+1) {
				JButton btn = new JButton("" + rowIndex);
				return btn;
			}	
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
}
