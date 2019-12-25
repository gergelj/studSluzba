package gui;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DateCellRenderer extends DefaultTableCellRenderer{

		/**
	 * 
	 */
	private static final long serialVersionUID = 5753619888587406145L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
		super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );
		
		String strDate = ((LocalDate) value).format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.setText(strDate);
	
		return this;
	}
}
