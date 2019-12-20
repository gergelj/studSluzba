package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.ProfesoriJTable;
import klase.BazaProfesora;

public class ProfesorSorterListener implements MouseListener {

	private int currentColumn = -1;
	private boolean isAscending = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int col = ProfesoriJTable.getInstance().getTableHeader().columnAtPoint(e.getPoint());
		if(col==BazaProfesora.getInstance().getColumnCount())
			return;	//ne treba sortirati kolonu dugmica
		if(currentColumn==col) {
			isAscending = !isAscending;
			if(isAscending) {
				ProfesoriJTable.getInstance().getColumnModel().getColumn(col).setHeaderValue(BazaProfesora.getInstance().getColumnName(col) + " ▲");
			}
			else {
				ProfesoriJTable.getInstance().getColumnModel().getColumn(col).setHeaderValue(BazaProfesora.getInstance().getColumnName(col) + " ▼");
			}
		}
		else {
			isAscending = true;
			ProfesoriJTable.getInstance().getColumnModel().getColumn(col).setHeaderValue(BazaProfesora.getInstance().getColumnName(col) + " ▲");
			if(currentColumn!=-1)
				ProfesoriJTable.getInstance().getColumnModel().getColumn(this.currentColumn).setHeaderValue(BazaProfesora.getInstance().getColumnName(this.currentColumn));
		}
		
		ProfesoriJTable.getInstance().getTableHeader().repaint();
		this.currentColumn = col;
		//System.out.println("Column: " + col + ", isAscending: " + isAscending);
		ProfesorController.getInstance().sort(col, isAscending);
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
