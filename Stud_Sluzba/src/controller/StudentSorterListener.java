package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.StudentiJTable;

public class StudentSorterListener implements MouseListener {

	private int currentColumn = -1;
	private boolean isAscending = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int col = StudentiJTable.getInstance().getTableHeader().columnAtPoint(e.getPoint());
		//isAscending = col==currentColumn ? false : true;
		if(currentColumn==col) {
			isAscending = !isAscending;
		}
		else {
			isAscending = true;
		}
		
		currentColumn = col;
		System.out.println("Column: " + col + ", isAscending: " + isAscending);
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
