package gui;

import java.io.IOException;

import Services.SastojakServis;
import dataClasses.Aplikacija;
import dataClasses.Sastojak;

public class MyApp {
	public static void main(String[] args) {
		Aplikacija app = new Aplikacija();
		SastojakServis sasServ = new SastojakServis();
		try {
			app.setSastojci(sasServ.ucitaj("C:\\Users\\Mile\\git\\SIMS2018\\src\\Files\\sastojci.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);	
	}
}
