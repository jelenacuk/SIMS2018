package model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import Services.Main;
import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Kategorija;
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
		recept.setKategorija(Aplikacija.aplikacija.getKategorije().get(0));
		recept.setKorisnik(Aplikacija.aplikacija.getTrenutniKorisnik());
		Aplikacija.aplikacija.getTrenutniKorisnik().getRecepti().add(recept);
		recept.setNeophodniAparati(potrebniAparati);
		recept.setOpcioniAparati(opcioniAparati);
		recept.setNeophodniSastojci(potrebniSastojci);
		recept.setOpcioniSastojci(opcioniSastojci);

		Aplikacija.aplikacija.dodajRecept(recept);
		try {
			Main.upisiPodatke();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addPotrebanSastojak(KolicinaSastojka s) {
		potrebniSastojci.add(s);
		System.out.println(potrebniSastojci.size());
	}

	public void removePotrebanSastojak(Sastojak s) {
		for (KolicinaSastojka kolicinaSastojka : potrebniSastojci) {
			if (kolicinaSastojka.getSastojak() == s) {
				potrebniSastojci.remove(kolicinaSastojka);
				break;
			}
		}
		System.out.println(potrebniSastojci.size());
	}

	public void addPotrebanAparat(Aparat a) {
		potrebniAparati.add(a);
		System.out.println(potrebniAparati.size());
		Aplikacija.aplikacija.getAparati().add(a);

	}

	public void removePotrebanAparat(Aparat a) {
		potrebniAparati.remove(a);
		System.out.println(potrebniAparati.size());

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
