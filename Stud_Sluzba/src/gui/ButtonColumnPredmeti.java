package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import klase.StringResources;

public class ButtonColumnPredmeti extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6351449162498276288L;
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditorActive = false;
	
	public ButtonColumnPredmeti(JTable table, int column)
	{
		this.table=table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton(StringResources.STUDENTS);
		this.editorButton = new JButton(StringResources.STUDENTS);
		
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fireEditingStopped();
				SpisakStudentaDialog d = new SpisakStudentaDialog(table.getSelectedRow());
				d.setVisible(true);
				
			}
		});
		this.isEditorActive = false;
	}
	
	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
		
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JPanel pan = new JPanel();
		pan.add(this.editorButton);
		return pan;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean gasFocus, int row,
			int column) {
		JPanel pan = new JPanel();
		pan.add(this.renderButton);
		return pan;
	}
 
}
