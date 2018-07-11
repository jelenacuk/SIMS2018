package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.KolicinaSastojka;
import dataClasses.Komentar;
import dataClasses.Recept;
import dataClasses.Sastojak;

public class UnosReceptaModel {
	
	
	private ArrayList<KolicinaSastojka> potrebniSastojci;
	ArrayList<KolicinaSastojka> opcioniSastojci;
	private ArrayList<Aparat> potrebniAparati, opcioniAparati;
	
	
	public UnosReceptaModel() {
		potrebniSastojci = new ArrayList<KolicinaSastojka>();
		potrebniAparati = new ArrayList<Aparat>();
		opcioniSastojci = new ArrayList<KolicinaSastojka>();
		potrebniAparati = new ArrayList<Aparat>();
	}
	
	
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
		
		recept.setNeophodniAparati(potrebniAparati);
		recept.setOpcioniAparati(opcioniAparati);
		recept.setNeophodniSastojci(potrebniSastojci);
		recept.setOpcioniSastojci(opcioniSastojci);
		
		Aplikacija.aplikacija.dodajRecept(recept);
		
	}
	
	public void addPotrebanSastojak(KolicinaSastojka s) {
		potrebniSastojci.add(s);
	}
	
	public void removePotrebanSastojak(KolicinaSastojka s) {
		potrebniSastojci.remove(s);
	}
	
	public void addPotrebanAparat(Aparat a) {
		potrebniAparati.add(a);
	}
	
	public void removePotrebanAparat(Aparat a) {
		potrebniAparati.remove(a);
	}


	public ArrayList<KolicinaSastojka> getPotrebniSastojci() {
		return potrebniSastojci;
	}


	public void setPotrebniSastojci(ArrayList<KolicinaSastojka> potrebniSastojci) {
		this.potrebniSastojci = potrebniSastojci;
	}


	public ArrayList<Aparat> getPotrebniAparati() {
		return potrebniAparati;
	}


	public void setPotrebniAparati(ArrayList<Aparat> potrebniAparati) {
		this.potrebniAparati = potrebniAparati;
	}

}
