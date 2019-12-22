package gui;

import java.awt.Component;
import java.awt.Dimension;
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

public class ButtonColumnStudenti extends AbstractCellEditor
		implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 1343768131059619058L;

	// dugme koje se iscrtava
	private JButton renderButton;
	// dugme koje obradjuje akciju
	private JButton editorButton;
	// referenca na tabelu
	private JTable table;
	// da li je aktivno editovanje celije tabele
	// (da li se obradjuju dogadjaji pritiska misa)
	private boolean isEditorActive = false;

	public ButtonColumnStudenti(JTable table, int column) {
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
				SpisakPredmetaStudentaDialog d = new SpisakPredmetaStudentaDialog(table.getSelectedRow());
				d.setVisible(true);
			}
		});

		this.isEditorActive = false;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// U ovom primeru, sva dugmad ce imati isti ispis,
		// za promenu ispisa mozemo koristi vrednost parametra value
		JPanel pan = new JPanel();
		pan.add(this.renderButton);
		return pan;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// Drugom dugmetu se prosledjuje klik misa
		JPanel pan = new JPanel();
		pan.add(this.editorButton);
		return pan;
	}

	@Override
	public Object getCellEditorValue() {
		// u sustini ne radimo nikakvu izmenu, pa nam ova vrednosti nije preterano bitna
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
		// ekplicitno navodimo da je editovanje celije je zavrseno
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

}
