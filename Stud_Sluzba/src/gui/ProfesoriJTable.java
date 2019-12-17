package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import klase.BazaProfesora;

public class ProfesoriJTable extends JTable {
	private static ProfesoriJTable instance = null;
	
	public static ProfesoriJTable getInstance() {
		if(instance==null)
			instance = new ProfesoriJTable();
		return instance;
	}
	
	private ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		//this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
		new ButtonColumnProfesori(this, BazaProfesora.getInstance().getColumnCount());
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
