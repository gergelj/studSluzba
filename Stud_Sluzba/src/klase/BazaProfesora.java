package klase;

public class BazaProfesora {
	
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance()
	{
		if(instance == null)
			instance = new BazaProfesora();
		return instance;
	}
}
