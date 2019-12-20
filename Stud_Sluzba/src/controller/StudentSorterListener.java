package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.StudentiJTable;
import klase.BazaStudenta;

public class StudentSorterListener implements MouseListener {

	private int currentColumn = -1;
	private boolean isAscending = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int col = StudentiJTable.getInstance().getTableHeader().columnAtPoint(e.getPoint());
		if(col==BazaStudenta.getInstance().getColumnCount())
			return;	//ne treba sortirati kolonu dugmica
		if(currentColumn==col) {
			isAscending = !isAscending;
			if(isAscending) {
				StudentiJTable.getInstance().getColumnModel().getColumn(col).setHeaderValue(BazaStudenta.getInstance().getColumnName(col) + " ▲");
			}
			else {
				StudentiJTable.getInstance().getColumnModel().getColumn(col).setHeaderValue(BazaStudenta.getInstance().getColumnName(col) + " ▼");
			}
		}
		else {
			isAscending = true;
			StudentiJTable.getInstance().getColumnModel().getColumn(col).setHeaderValue(BazaStudenta.getInstance().getColumnName(col) + " ▲");
			if(currentColumn!=-1)
				StudentiJTable.getInstance().getColumnModel().getColumn(this.currentColumn).setHeaderValue(BazaStudenta.getInstance().getColumnName(this.currentColumn));
		}
		
		StudentiJTable.getInstance().getTableHeader().repaint();
		currentColumn = col;
		//System.out.println("Column: " + col + ", isAscending: " + isAscending);
		StudentController.getInstance().sort(col, isAscending);
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

}
