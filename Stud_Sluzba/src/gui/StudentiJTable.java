package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import controller.StudentController;
import klase.BazaStudenta;

public class StudentiJTable extends JTable {

	private static final long serialVersionUID = 8900651367165240112L;

	private static StudentiJTable instance = null;
	
	public static StudentiJTable getInstance() {
		if(instance==null)
			instance = new StudentiJTable();
		return instance;
	}
	
	private StudentiJTable() {
		this.setRowSelectionAllowed(true);
		//this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti(StudentController.NORMAL_MODE));
		new ButtonColumnStudenti(this, BazaStudenta.getInstance().getColumnCount());
		this.getTableHeader().setReorderingAllowed(false);
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