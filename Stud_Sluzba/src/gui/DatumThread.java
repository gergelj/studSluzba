package gui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatumThread extends Thread {

	MainFrame mf;
	
	public DatumThread(MainFrame mf) {
		this.mf = mf;
	}
	
	@Override
	public void run() {
		while (true) {
			//osvezava ispis svakog minuta
			mf.mDateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm   dd.MM.yyyy.")));
			try {
				Thread.currentThread();
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
