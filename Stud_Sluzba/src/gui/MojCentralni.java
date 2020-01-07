package gui;

import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
        //StudentiJTable.getInstance().setAutoCreateRowSorter(true);
        StudentiJTable.getInstance().setRowSorter(new TableRowSorter<TableModel>(StudentiJTable.getInstance().getModel()));
        
        JScrollPane scrollPanePredmeti = new JScrollPane(PredmetiJTable.getInstance());
        //PredmetiJTable.getInstance().setAutoCreateRowSorter(true);
        PredmetiJTable.getInstance().setRowSorter(new TableRowSorter<TableModel>(PredmetiJTable.getInstance().getModel()));
        
        
        JScrollPane scrollPaneProfesori = new JScrollPane(ProfesoriJTable.getInstance());
        //ProfesoriJTable.getInstance().setAutoCreateRowSorter(true);
        ProfesoriJTable.getInstance().setRowSorter(new TableRowSorter<TableModel>(ProfesoriJTable.getInstance().getModel()));
        
        
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
    /*
    public PredmetiJTable getTablPredmeti()
    {
    	return this.tabelaPredmeta;
    }
    
    public StudentiJTable getTabelaStudenata() {
    	return this.tabelaStudenta;
    }
    

    public ProfesoriJTable getTabelaProfesora() {
    	return this.tabelaProfesora;
    }*/

}
