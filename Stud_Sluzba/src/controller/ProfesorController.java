package controller;


import java.util.ArrayList;
import java.util.List;

import gui.MojCentralni;
import gui.ProfesoriJTable;
import klase.BazaPredmeta;
import klase.BazaProfesora;
import klase.Predmet;
import klase.Profesor;

public class ProfesorController {
	private static ProfesorController instance = null;
	
	private ProfesorController() {}
	
	public static ProfesorController getInstance() {
		if(instance==null)
			instance = new ProfesorController();
		return instance;
	}
	
	public boolean dodajProfesora(String mIme, String mPrezime, String mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje) {
		if(BazaProfesora.getInstance().lookup_profesor(mBrojLK)==null) {
			BazaProfesora.getInstance().dodajProfesor(mIme, mPrezime, mDatumRodjenja, mAdresaStanovanja, mTelefon, mEmail, mAdresaKancelarije, mBrojLK, mTitula, mZvanje);
			MojCentralni.getInstance().azurirajPrikazProfesora();
			return true;
		}
		else {
			return false;
		}
	}
	
	public Profesor nadjiProfesora(int row) {
		return BazaProfesora.getInstance().getRow(row);
	}
	
	public boolean izmeniProfesora(String mIme, String mPrezime, String mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje,int id)
	{
		Profesor tmp = BazaProfesora.getInstance().lookup_profesor(mBrojLK);
		if(tmp==null) {
			BazaProfesora.getInstance().izmeniProfesora(mIme, mPrezime, mDatumRodjenja, mAdresaStanovanja, mTelefon, mEmail, mAdresaKancelarije, mBrojLK, mTitula, mZvanje, id);
			MojCentralni.getInstance().azurirajPrikazProfesora();
			return true;
		}
		else {
			if(tmp.getId()==id) {
				BazaProfesora.getInstance().izmeniProfesora(mIme, mPrezime, mDatumRodjenja, mAdresaStanovanja, mTelefon, mEmail, mAdresaKancelarije, mBrojLK, mTitula, mZvanje, id);
				MojCentralni.getInstance().azurirajPrikazProfesora();
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void izbrisiProfesora(int row) {
		if(row>=0) {
			Profesor pf = this.nadjiProfesora(row);
			BazaProfesora.getInstance().izbrisiProfesor(pf.getId());
			MojCentralni.getInstance().azurirajPrikazProfesora();
			
			//kada obrisem profesora, on mora da nestane kod svakog predmeta
			BazaPredmeta.getInstance().deleteAllInstanceOfProfessor(pf);
			MojCentralni.getInstance().azurirajPrikazPredmet();
		}
	}
	
	
	public List<Profesor> getProfesori()
	{
		return BazaProfesora.getInstance().getProfesori();
	}
	
	public List<Predmet> getListOfSubjects(Profesor p)
	{
		List<Predmet> pred = new ArrayList<Predmet>();
		
		for(Predmet predmet: p.getmListaPredmeta().values() )
		{
			pred.add(predmet);
		}
		
		return pred;
	}
	
	public void sort(int column, boolean isAscending) {
		BazaProfesora.getInstance().sort(column, isAscending);
		MojCentralni.getInstance().azurirajPrikazProfesora();
	}
	
	public void unsort() {
		for(int i=0; i<BazaProfesora.getInstance().getColumnCount(); i++) {
			ProfesoriJTable.getInstance().getColumnModel().getColumn(i).setHeaderValue(BazaProfesora.getInstance().getColumnName(i));
		}
		ProfesoriJTable.getInstance().getTableHeader().repaint();
		BazaProfesora.getInstance().unsort();
		MojCentralni.getInstance().azurirajPrikazProfesora();
	}
}
