package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import controller.LanguageController;
import klase.StringResources;

public class LanguageDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5533900334344594123L;

	@SuppressWarnings("unchecked")
	public LanguageDialog() {
		super(MainFrame.getInstance(), StringResources.MENU_LANGUAGE, false);
		int width = (StringResources.RESTART_NEEDED.length()*8 < 300) ? 300 : StringResources.RESTART_NEEDED.length()*8 ;
		setSize(width, 200);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JLabel note = new JLabel(StringResources.RESTART_NEEDED);
		note.setForeground(Color.GRAY);
		JButton ok_btn = new JButton(StringResources.OK);
		ok_btn.setMargin(new Insets(0,0,0,0));
		@SuppressWarnings("rawtypes")
		JComboBox<?> combo = new JComboBox(new MyComboBoxModel());
		combo.setRenderer(new ComboBoxRenderer());
		
		this.setLayout(null);
		this.setResizable(false);
		this.add(combo);
		this.add(note);
		this.add(ok_btn);
		combo.setBounds(20, 20, this.getSize().width-40, 40);
		note.setBounds(20, 80, this.getSize().width, 20);
		ok_btn.setBounds(this.getSize().width/2 -25, 120, 50, 30);
		
		ok_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LanguageController.getInstance().setLanguage(combo.getSelectedIndex());
				setVisible(false);
			}
			
		});
	}
	
	public class MyComboBoxModel extends AbstractListModel implements ComboBoxModel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 3769149698165809241L;

		private List<LanguageComponent> jezici = new ArrayList<LanguageComponent>();
		private LanguageComponent selection;
		
		public MyComboBoxModel() {
			jezici.add(new LanguageComponent("serbian", StringResources.SERBIAN));
			jezici.add(new LanguageComponent("hungarian", StringResources.HUNGARIAN));
			jezici.add(new LanguageComponent("english", StringResources.ENGLISH));
			jezici.add(new LanguageComponent("german", StringResources.GERMAN));
			
			this.selection = jezici.get(LanguageController.getInstance().getLanguage());
		}
		
		@Override
		public void setSelectedItem(Object anItem) {
			this.selection = (LanguageComponent) anItem;
		}

		@Override
		public Object getSelectedItem() {
			return this.selection;
		}

		@Override
		public int getSize() {
			return jezici.size();
		}

		@Override
		public Object getElementAt(int index) {
			return jezici.get(index);
		}
		
	}
	
	public class LanguageComponent {
		
		private ImageIcon icon;
		private String name;
		
		public LanguageComponent(String iconName, String name) {
			this.name = name;
			icon = new ImageIcon("images/" + iconName + ".png");
		}
		
		public ImageIcon getIcon() {
			return this.icon;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private class ComboBoxRenderer extends JLabel implements ListCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2007052443261819922L;

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {

			LanguageComponent cc = (LanguageComponent) value;
			//if (cc == null)
				//cc = (ComputerComponent) list.getModel().getElementAt(0);
			setIcon(cc.getIcon());
			setText(cc.getName());

			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			
			return this;
		}
	}
}
