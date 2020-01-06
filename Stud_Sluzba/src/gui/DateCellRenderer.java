package gui;

import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import klase.StringResources;

public class DateCellRenderer extends DefaultTableCellRenderer{

		/**
	 * 
	 */
	private static final long serialVersionUID = 5753619888587406145L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
		super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );
		
		String strDate = ((LocalDate) value).format(DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
		this.setText(strDate);
	
		return this;
	}
}
