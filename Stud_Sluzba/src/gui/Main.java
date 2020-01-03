package gui;

import controller.LanguageController;
import klase.StringResources;

public class Main {
	
	public static void main(String[] args) {
		
		LanguageController.getInstance().loadLanguage();
		StringResources.loadResources();
		//glavni prozor
		MainFrame.getInstance().setVisible(true);
		
		
	}

}
