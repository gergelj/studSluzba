package controller;

import gui.MojCentralni;
import klase.BazaPredmeta;
import klase.Predmet;

public class PredmetController {
	private static PredmetController instance = null;
	
	private PredmetController() {}
	
	public static PredmetController getInstance()
	{
		if(instance == null)
			instance = new PredmetController();
		return instance;
	}
	
	public boolean dodajPredmet(String sif,String naz,int god,int sem)
	{
		if(BazaPredmeta.getInstance().lookup_predmet(sif)==null)
		{
		    BazaPredmeta.getInstance().dodajPredmet(sif, naz, sem, god);
		    MojCentralni.getInstance().azurirajPrikaz();
		    return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean izmeniPredmet(String sif,String naz,int god,int sem,int id)
	{
		Predmet tmp = BazaPredmeta.getInstance().lookup_predmet(sif);
		if(tmp==null)
		{
			BazaPredmeta.getInstance().IzmeniPredmet(sif, naz, sem, god, id);
			MojCentralni.getInstance().azurirajPrikaz();
			return true;
		}
		else
		{
			return false;
		}
	}

	public Predmet nadjiPredmet(int row) {
		return BazaPredmeta.getInstance().getRow(row);
	}
}
