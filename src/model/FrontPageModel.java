package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import dataClasses.Aparat;
import dataClasses.Recept;
import dataClasses.Sastojak;
import utility.Sorter;

public class FrontPageModel extends Observable {
	private ArrayList<Sastojak> selektovaniSastojci;
	private ArrayList<Aparat> selektovaniAparati;
	private ArrayList<Recept> receptiPoVremenu;
	private ArrayList<Recept> receptiPoPopularnosti;

	public FrontPageModel() {
		selektovaniSastojci = new ArrayList<>();
		selektovaniAparati = new ArrayList<>();
	}

	public ArrayList<Recept> sortirajReceptPoVremenu(ArrayList<Recept> lista) {
		Collections.sort(lista, new Sorter("datumObjave", -1));
		return lista;
	}

	public ArrayList<Recept> sortirajReceptPoPopularnosti(ArrayList<Recept> lista) {
		Collections.sort(lista, new Sorter("brojLajkova", -1));
		return lista;
	}

	public ArrayList<Sastojak> getSelektovaniSastojci() {
		return selektovaniSastojci;
	}

	public void setSelektovaniSastojci(ArrayList<Sastojak> selektovaniSastojci) {
		this.selektovaniSastojci = selektovaniSastojci;
	}

	public ArrayList<Aparat> getSelektovaniAparati() {
		return selektovaniAparati;
	}

	public void setSelektovaniAparati(ArrayList<Aparat> selektovaniAparati) {
		this.selektovaniAparati = selektovaniAparati;
	}

	public void addSelektovanSastojak(Sastojak sastojak) {
		selektovaniSastojci.add(sastojak);
	}

	public void addSelektovanAparat(Aparat aparat) {
		selektovaniAparati.add(aparat);
	}

	public void removeSelektovanSastojak(Sastojak sastojak) {
		selektovaniSastojci.remove(sastojak);
	}

	public void removeSelektovanAparat(Aparat aparat) {
		selektovaniAparati.remove(aparat);
	}

	public ArrayList<Recept> getReceptiPoVremenu() {
		return receptiPoVremenu;
	}

	public void setReceptiPoVremenu(ArrayList<Recept> receptiPoVremenu) {
		this.receptiPoVremenu = receptiPoVremenu;
	}

	public ArrayList<Recept> getReceptiPoPopularnosti() {
		return receptiPoPopularnosti;
	}

	public void setReceptiPoPopularnosti(ArrayList<Recept> receptiPoPopularnosti) {
		this.receptiPoPopularnosti = receptiPoPopularnosti;
	}

}
