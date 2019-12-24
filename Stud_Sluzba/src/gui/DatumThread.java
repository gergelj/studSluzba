package gui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatumThread extends Thread {

	private MainFrame mf;
	
	public DatumThread(MainFrame mf) {
		this.mf = mf;
	}
	//private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm   dd.MM.yyyy.");
	@Override
	public void run() {
		while (true) {
			//osvezava ispis svakog minuta
			mf.mDateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss   dd.MM.yyyy.")));
			
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
