package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LanguageController {

	private static LanguageController instance = null;
	
	private int language;
	/* 0 - srpski
	 * 1 - madjarski
	 * 2 - engleski
	 * 3 - nemacki
	 */
	private File f = new File("resources/language");
	private DataInputStream dis;
	private DataOutputStream dos;
	
	private LanguageController() {
		
	}
	
	public static LanguageController getInstance() {
		if(instance == null)
			instance = new LanguageController();
		return instance;
	}
	
	public void loadLanguage() {
		try {
			dis = new DataInputStream(new FileInputStream(f));
			this.language = dis.readInt();
		} catch (FileNotFoundException e) {
			this.language = 0;
		} catch (IOException e) {
			this.language = 0;
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
			}
		}
	}
	
	public int getLanguage() {
		return this.language;
	}
	
	public void setLanguage(int lang) {
		this.language = lang;
	}
	
	public void saveLanguage() {
		try {
			dos = new DataOutputStream(new FileOutputStream(f));
			dos.writeInt(this.language);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
			}
		}
	}
	
}
