package gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MojCentralni extends JTabbedPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PredmetiJTable tabelaPredmeta;
	private StudentiJTable tabelaStudenta;
	//TODO: private ProfesoriJTable tabelaProfesora;
	
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
        tabelaStudenta.setAutoCreateRowSorter(true);
        
        tabelaPredmeta = new PredmetiJTable();
        JScrollPane scrollPanePredmeti = new JScrollPane(tabelaPredmeta);
        tabelaPredmeta.setAutoCreateRowSorter(true);
        
        addTab("Students" ,null, scrollPaneStudenti,"Tab with Students");
        setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent prof_tab = makeTextPanel("Professors");
        addTab("Professors", null, prof_tab, "Tab with Professors");
        setMnemonicAt(1, KeyEvent.VK_2);
         
        addTab("Subjects", null, scrollPanePredmeti, "Tab with Subjects");
        setMnemonicAt(2, KeyEvent.VK_3);
        
        //sluzi da ukljuci promenu taba pomocu strelica kada je prozor aplikacije previse uzak
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        this.azurirajPrikaz();
        this.azurirajPrikazPredmet();
    }
     
	public void azurirajPrikaz() {
		AbstractTableModelStudenti model_stud = (AbstractTableModelStudenti) tabelaStudenta.getModel();
        model_stud.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPredmet()
	{
		AbstractTableModePredmet model_predmet = (AbstractTableModePredmet) tabelaPredmeta.getModel();
		model_predmet.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazProfesora() {
		//TODO: AbstractTableModePredmet model_profesor = (AbstractTableModePredmet) tabelaProfesora.getModel();
		//model_profesor.fireTableDataChanged();
		validate();
	}
	
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    public PredmetiJTable getTablPredmeti()
    {
    	return this.tabelaPredmeta;
    }
    
    public StudentiJTable getTabelaStudenata() {
    	return this.tabelaStudenta;
    }
    
    /*
     * public ProfesoriJTable getTabelaProfesora() {
    	return this.tabelaProfesora;
    }*/

}
