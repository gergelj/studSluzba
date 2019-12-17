package gui;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import klase.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel {

	public static String kolonaDugme = "PREDMETI";
			
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= BazaProfesora.getInstance().getColumnCount();
	}
	
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount() + 1;
	}

	@Override
	public String getColumnName(int column) {
		if (column >= BazaProfesora.getInstance().getColumnCount()) {
			return kolonaDugme;
		}
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
	// da bismo mogli prikazati dugme
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return String.class;
		case 10:
			return JButton.class;
		default:
			return null;
		}
	}
		
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < BazaProfesora.getInstance().getColumnCount())
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == BazaProfesora.getInstance().getColumnCount()+1) {
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
