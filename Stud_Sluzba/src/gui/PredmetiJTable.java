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

	private static PredmetiJTable instance = null;
	
	public static PredmetiJTable getInstance() {
		if(instance==null)
			instance = new PredmetiJTable();
		return instance;
	}
	
	private PredmetiJTable()
	{
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmet());
		new ButtonColumnPredmeti(this, BazaPredmeta.getInstance().getColumnCount());
		MojCellRenderer renderer = new MojCellRenderer(MojCellRenderer.SUBJECT_RENDERER);
		
		for(int i = 0; i<BazaPredmeta.getInstance().getColumnCount(); i++)
			this.getColumnModel().getColumn(i).setCellRenderer(renderer);
		
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowHeight(35);
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
