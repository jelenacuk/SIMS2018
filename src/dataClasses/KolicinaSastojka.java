package dataClasses;

import java.util.ArrayList;

public class KolicinaSastojka {
	private int kolicina;
	private Sastojak sastojak;
	private ArrayList<KolicinaSastojka> alternativniSastojci;
	public KolicinaSastojka(int kolicina, Sastojak sastojak) {
		super();
		this.kolicina = kolicina;
		this.sastojak = sastojak;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public Sastojak getSastojak() {
		return sastojak;
	}
	public void setSastojak(Sastojak sastojak) {
		this.sastojak = sastojak;
	}
	public ArrayList<KolicinaSastojka> getAlternativniSastojci() {
		return alternativniSastojci;
	}
	public void setAlternativniSastojci(ArrayList<KolicinaSastojka> alternativniSastojci) {
		this.alternativniSastojci = alternativniSastojci;
	}
	public void dodajAltSastojak(KolicinaSastojka kolSastojka) {
		this.alternativniSastojci.add(kolSastojka);
	}
	public void obrisiAltSastojak(KolicinaSastojka kolSastojka) {
		this.alternativniSastojci.remove(kolSastojka);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof KolicinaSastojka)
		{
			KolicinaSastojka ks = (KolicinaSastojka) obj;
			if (ks.getSastojak() == this.getSastojak() && ks.getKolicina() == this.getKolicina())
			{
				return true;
			}
		}
		return false;
	}
}
