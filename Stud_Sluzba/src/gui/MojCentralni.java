package gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.TableModel;

import controller.StudentSorterListener;

public class MojCentralni extends JTabbedPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PredmetiJTable tabelaPredmeta;
	private StudentiJTable tabelaStudenta;
	private ProfesoriJTable tabelaProfesora;
	
	private static MojCentralni instance = null;
	
	public static MojCentralni getInstance() {
		if(instance==null)
			instance = new MojCentralni();
		return instance;
	}
	
	private MojCentralni()
	{	
		tabelaStudenta = StudentiJTable.getInstance();
        JScrollPane scrollPaneStudenti = new JScrollPane(tabelaStudenta);
        tabelaStudenta.getTableHeader().addMouseListener(new StudentSorterListener());
        
        tabelaPredmeta = PredmetiJTable.getInstance();
        JScrollPane scrollPanePredmeti = new JScrollPane(tabelaPredmeta);
        //tabelaStudenta.getTableHeader().addMouseListener(new StudentSorterListener());
        
        tabelaProfesora = ProfesoriJTable.getInstance();
        JScrollPane scrollPaneProfesori = new JScrollPane(tabelaProfesora);
        tabelaProfesora.setAutoCreateRowSorter(true);
        
        
        addTab("Students" ,null, scrollPaneStudenti);
        setMnemonicAt(0, KeyEvent.VK_1);
         
        addTab("Professors", null, scrollPaneProfesori);
        setMnemonicAt(1, KeyEvent.VK_2);
         
        addTab("Subjects", null, scrollPanePredmeti);
        setMnemonicAt(2, KeyEvent.VK_3);
        
        //sluzi da ukljuci promenu taba pomocu strelica kada je prozor aplikacije previse uzak
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        this.azurirajPrikaz();
        this.azurirajPrikazPredmet();
        this.azurirajPrikazProfesora();
    }
     
	public void azurirajPrikaz() {
		AbstractTableModelStudenti model_stud = (AbstractTableModelStudenti) tabelaStudenta.getModel();
        model_stud.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPredmet()
	{
		AbstractTableModelPredmet model_predmet = (AbstractTableModelPredmet) tabelaPredmeta.getModel();
		model_predmet.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazProfesora() {
		AbstractTableModelProfesori model_profesor = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		model_profesor.fireTableDataChanged();
		validate();
	}
    
    public PredmetiJTable getTablPredmeti()
    {
    	return this.tabelaPredmeta;
    }
    
    public StudentiJTable getTabelaStudenata() {
    	return this.tabelaStudenta;
    }
    

    public ProfesoriJTable getTabelaProfesora() {
    	return this.tabelaProfesora;
    }

}
