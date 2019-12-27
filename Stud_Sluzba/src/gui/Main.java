package gui;

import controller.LanguageController;

public class Main {
	
	public static void main(String[] args) {
		
		LanguageController.getInstance().loadLanguage();
		
		//glavni prozor
		MainFrame.getInstance().setVisible(true);
		
		
	}

}
