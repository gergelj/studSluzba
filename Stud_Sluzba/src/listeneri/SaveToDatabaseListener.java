package listeneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.DatabaseController;

public class SaveToDatabaseListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DatabaseController.save();
	}

}
