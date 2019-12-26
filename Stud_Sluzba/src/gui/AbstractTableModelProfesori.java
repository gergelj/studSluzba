package gui;

import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import klase.BazaProfesora;
import klase.StringResources;

public class AbstractTableModelProfesori extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3528524555303776280L;
	
	public static String kolonaDugme = StringResources.SUBJECTS;
			
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
		case 1: return String.class;
		case 2: return LocalDate.class;
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
