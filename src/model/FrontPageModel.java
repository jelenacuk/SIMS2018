package model;


import java.util.ArrayList;
import java.util.Observable;

import dataClasses.Aparat;
import dataClasses.Sastojak;

public class FrontPageModel extends Observable {
	private ArrayList<Sastojak> selektovaniSastojci;
	private ArrayList<Aparat> selektovaniAparati;
	public FrontPageModel()
	{
		selektovaniSastojci = new ArrayList<>();
		selektovaniAparati = new ArrayList<>();
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

}
