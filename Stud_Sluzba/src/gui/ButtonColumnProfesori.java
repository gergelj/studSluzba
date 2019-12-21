package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonColumnProfesori extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -108748213939675169L;
	// dugme koje se iscrtava
	private JButton renderButton;
	// dugme koje obradjuje akciju
	private JButton editorButton;
	// referenca na tabelu
	private JTable table;
	// da li je aktivno editovanje celije tabele
	// (da li se obradjuju dogadjaji pritiska misa)
	private boolean isEditorActive = false;
	
	public ButtonColumnProfesori(JTable table, int column) {
		// povezivanje sa tabelom
		this.table = table;
		// nacin iscrtavanje celije
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		// nacin editovanja celije
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		// dugme koje ce biti iscrtavanp
		this.renderButton = new JButton("...");
		this.editorButton = new JButton("...");

		this.editorButton.addActionListener(new ActionListener() {
			// mozemo odavde pozvati nas kontroler da se nesto smisleno odradi
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				//TODO: ispis liste predmeta za odabranog studenta
				//JOptionPane.showMessageDialog(table, "Selektovan je profesor u redu: " + table.getSelectedRow());
				SpisakPredmetaDialog dial = new SpisakPredmetaDialog(table.getSelectedRow());
				dial.setVisible(true);
			}
		});

		this.isEditorActive = false;
	}
	
	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JPanel pan = new JPanel();
		pan.add(this.editorButton);
		return pan;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JPanel pan = new JPanel();
		pan.add(this.renderButton);
		return pan;
	}

}
