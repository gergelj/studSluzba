package gui;

import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import klase.StringResources;

public class MojCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1416501917183429425L;
	public static final int STUDENT_RENDERER = 0;
	public static final int PROFESSOR_RENDERER = 1;
	public static final int SUBJECT_RENDERER = 2;
	private int mode;
	
	public MojCellRenderer() {super();}
	
	public MojCellRenderer(int mode) {
		super();
		this.mode = mode;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
		super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );
		
		if(table.getModel().getColumnClass(column) == LocalDate.class) { // ako je kolona za datum, prikazi datum u odredjeni formati
			String strDate = ((LocalDate) value).format(DateTimeFormatter.ofPattern(StringResources.DATEFORMAT));
			this.setText(strDate);
			this.setToolTipText(strDate);
		}
		else {
			this.setToolTipText(value.toString());
		}

		switch(mode) {
		case MojCellRenderer.STUDENT_RENDERER:{
			if(column == 8 || column == 10)
				this.setHorizontalAlignment(SwingConstants.CENTER);
			else 
				this.setHorizontalAlignment(SwingConstants.LEFT);
		} break;
		case MojCellRenderer.PROFESSOR_RENDERER: break;
		case MojCellRenderer.SUBJECT_RENDERER:{
			if(column == 2 || column == 3)
				this.setHorizontalAlignment(SwingConstants.CENTER);
			else
				this.setHorizontalAlignment(SwingConstants.LEFT);
		}
		}
		
		return this;
	}
	
}
