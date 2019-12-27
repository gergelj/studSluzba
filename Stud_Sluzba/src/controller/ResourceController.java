package controller;

public class ResourceController {

	private static ResourceController instance = null;
	
	private ResourceController() {
		
	}
	
	public ResourceController getInstance() {
		if(instance == null)
			instance = new ResourceController();
		return instance;
	}
	
	
	
}
