package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ColumnHeaderStudenti implements TableCellRenderer, TableCellEditor, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7033493579720146702L;
	
	JLabel lbl;
	JButton btn;
	JPanel pan;
	
	public ColumnHeaderStudenti() {
		pan = new JPanel();
		lbl = new JLabel("PROBA");
		btn = new JButton();
		btn.setIcon(new ImageIcon("images/sort-16.png"));
		btn.setPreferredSize(new Dimension(20,20));
		pan.add(lbl);
		pan.add(btn);
		btn.addActionListener(this);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		switch(column) {
		case 0:{
			lbl.setText("INDEKS");
			btn.setName("indeks");
		} break;
		case 1:{
			lbl.setText("IME");
			btn.setName("ime");
		} break;
		case 2:{
			lbl.setText("PREZIME");
			btn.setName("prezime");
		} break;
		case 3:{
			lbl.setText("DAT. RODJ");
		} break;
		case 4:{
			lbl.setText("ADRESA");
		} break;
		case 5:{
			lbl.setText("TELEFON");
		} break;
		case 6:{
			lbl.setText("E-MAIL");
		} break;
		case 7:{
			lbl.setText("DAT. UPISA");
		} break;
		case 8:{
			lbl.setText("GODINA");
		} break;
		case 9:{
			lbl.setText("STATUS");
		} break;
		case 10:{
			lbl.setText("PROSEK");
		} break;
		case 11:{
			lbl.setText("PREDMETI");
			//btn.setVisible(false);
		} break;
		}
		return pan;
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

		return pan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		System.out.println("Usao u listener");
		if(b.getName().equals("ime"))
			System.out.println("Sort ime");
		else if (b.getName().equals("indeks"))
			System.out.println("Sort indeks");
		else if(b.getName().equals("prezime"))
			System.out.println("Sort prezime");
		
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

}
