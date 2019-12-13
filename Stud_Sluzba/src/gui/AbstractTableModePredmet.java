package gui;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import klase.BazaPredmeta;

public class AbstractTableModePredmet extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6705633657400709595L;
	
	public static String kolonaDugme = "STUDENTI";
	
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount()+1;
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowInd, int colInd) {
		if(colInd<BazaPredmeta.getInstance().getColumnCount())
			return BazaPredmeta.getInstance().getValueAt(rowInd, colInd);
		else if(colInd == BazaPredmeta.getInstance().getColumnCount()+1)
		{
			JButton btn = new JButton(""+rowInd);
			return btn;
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >=BazaPredmeta.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column)
	{
		if(column >=BazaPredmeta.getInstance().getColumnCount())
			return kolonaDugme;
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	@Override
	public Class<?> getColumnClass(int colInd)
	{
		switch(colInd) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return JButton.class;
		default:
			return null;
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowInd,int colInd)
	{
		super.setValueAt(aValue, rowInd, colInd);
	}
	
}
