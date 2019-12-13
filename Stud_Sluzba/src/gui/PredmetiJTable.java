package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import klase.BazaPredmeta;

public class PredmetiJTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2820887020930754622L;

	public PredmetiJTable()
	{
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModePredmet());
		new ButtonColumnStudenti(this, BazaPredmeta.getInstance().getColumnCount());		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
