package gui;

import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import klase.BazaPredmeta;
import klase.BazaProfesora;
import klase.BazaStudenta;
import klase.StringResources;

public class MojCentralni extends JTabbedPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private PredmetiJTable tabelaPredmeta;
	//private StudentiJTable tabelaStudenta;
	//private ProfesoriJTable tabelaProfesora;
	
	private static MojCentralni instance = null;
	
	public static MojCentralni getInstance() {
		if(instance==null)
			instance = new MojCentralni();
		return instance;
	}
	
	private MojCentralni()
	{	
        JScrollPane scrollPaneStudenti = new JScrollPane(StudentiJTable.getInstance());
        TableRowSorter<TableModel> studentSorter = new TableRowSorter<TableModel>(StudentiJTable.getInstance().getModel());
		studentSorter.setSortable(BazaStudenta.getInstance().getColumnCount(), false);
		StudentiJTable.getInstance().setRowSorter(studentSorter);
        
        JScrollPane scrollPanePredmeti = new JScrollPane(PredmetiJTable.getInstance());
        TableRowSorter<TableModel> predmetSorter = new TableRowSorter<TableModel>(PredmetiJTable.getInstance().getModel());
        predmetSorter.setSortable(BazaPredmeta.getInstance().getColumnCount(), false);
        PredmetiJTable.getInstance().setRowSorter(predmetSorter);
        
        JScrollPane scrollPaneProfesori = new JScrollPane(ProfesoriJTable.getInstance());
        TableRowSorter<TableModel> profesorSorter = new TableRowSorter<TableModel>(ProfesoriJTable.getInstance().getModel());
        profesorSorter.setSortable(BazaProfesora.getInstance().getColumnCount(), false);
        ProfesoriJTable.getInstance().setRowSorter(profesorSorter);
        
        addTab(StringResources.TAB_TITLE_STUDENTS ,null, scrollPaneStudenti);
        setMnemonicAt(0, KeyEvent.VK_1);
         
        addTab(StringResources.TAB_TITLE_PROFESSORS, null, scrollPaneProfesori);
        setMnemonicAt(1, KeyEvent.VK_2);
         
        addTab(StringResources.TAB_TITLE_SUBJECTS, null, scrollPanePredmeti);
        setMnemonicAt(2, KeyEvent.VK_3);
        
        //sluzi da ukljuci promenu taba pomocu strelica kada je prozor aplikacije previse uzak
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        this.azurirajPrikaz();
        this.azurirajPrikazPredmet();
        this.azurirajPrikazProfesora();
    }
     
	public void azurirajPrikaz() {
		AbstractTableModelStudenti model_stud = (AbstractTableModelStudenti) StudentiJTable.getInstance().getModel();
        model_stud.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPredmet()
	{
		AbstractTableModelPredmet model_predmet = (AbstractTableModelPredmet) PredmetiJTable.getInstance().getModel();
		model_predmet.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazProfesora() {
		AbstractTableModelProfesori model_profesor = (AbstractTableModelProfesori) ProfesoriJTable.getInstance().getModel();
		model_profesor.fireTableDataChanged();
		validate();
	}

}
