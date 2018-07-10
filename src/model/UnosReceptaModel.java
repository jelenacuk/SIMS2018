package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import dataClasses.Aplikacija;
import dataClasses.Komentar;
import dataClasses.Recept;

public class UnosReceptaModel {
	
	
	public void unos(String naziv, String tekst) {
		Recept recept = new Recept();
		recept.setIdRecepta(Aplikacija.aplikacija.getRecepti().size());
		recept.setBrDislajkova(0);
		recept.setBrDislajkova(0);
		recept.setDatumObjave(new Date());
		recept.setKomentari(new ArrayList<Komentar>());
		recept.setNaziv(naziv);
		recept.setTekst(tekst);
		recept.setOpis("");
		recept.setSuspendovan(false);
		Aplikacija.aplikacija.dodajRecept(recept);
		
	}

}
