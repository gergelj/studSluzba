package controller;

import java.time.LocalDate;

import gui.MojCentralni;
import klase.BazaProfesora;
import klase.Profesor;

public class ProfesorController {
	private static ProfesorController instance = null;
	
	private ProfesorController() {}
	
	public static ProfesorController getInstance() {
		if(instance==null)
			instance = new ProfesorController();
		return instance;
	}
	
	public boolean dodajProfesora(String mIme, String mPrezime, String mDatumRodjenja, String mAdresaStanovanja, String mTelefon,String mEmail, String mAdresaKancelarije, String mBrojLK, String mTitula, String mZvanje,int id) {
		if(BazaProfesora.getInstance().lookup_profesor(mBrojLK)==null) {
			BazaProfesora.getInstance().dodajProfesor(mIme, mPrezime, mDatumRodjenja, mAdresaStanovanja, mTelefon, mEmail, mAdresaKancelarije, mBrojLK, mTitula, mZvanje);
			//TODO:MojCentralni.getInstance().azurirajPrikazProfesora();
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
			//TODO:MojCentralni.getInstance().azurirajPrikazProfesora();
			return true;
		}
		else {
			if(tmp.getId()==id) {
				BazaProfesora.getInstance().izmeniProfesora(mIme, mPrezime, mDatumRodjenja, mAdresaStanovanja, mTelefon, mEmail, mAdresaKancelarije, mBrojLK, mTitula, mZvanje, id);
				//TODO:MojCentralni.getInstance().azurirajPrikazProfesora();
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void izbrisiStudenta(int row) {
		//TODO obrisi studenta
	}
	
	public void sort(int column, boolean ascending) {
		//TODO sortiranje studenta
	}
	
}
