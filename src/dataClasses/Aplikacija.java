package dataClasses;

import java.util.ArrayList;
import java.util.Date;

import model.UnosReceptaModel;

public class Aplikacija {
	
	public static Aplikacija aplikacija;
	
	private ArrayList<Sastojak> sastojci;
	private ArrayList<Recept> recepti;
	private ArrayList<Kategorija> kategorije;
	private ArrayList<Aparat> aparati;
	private ArrayList<Korisnik> korisnici;
	private Korisnik trenutniKorisnik;
	
	
	public Aplikacija() {
		
	}

	public Aplikacija(ArrayList<Sastojak> sastojci, ArrayList<Recept> recepti, ArrayList<Kategorija> kategorije,
			ArrayList<Aparat> aparati, ArrayList<Korisnik> korisnici, Korisnik trenutniKorisnik) {
		if (aplikacija == null)
		{
			aplikacija = this;
		}
		this.sastojci = sastojci;
		this.recepti = recepti;
		this.kategorije = kategorije;
		this.aparati = aparati;
		this.korisnici = korisnici;
		this.trenutniKorisnik = trenutniKorisnik;
	}

	public void dodajRecept(Recept noviRecept) {
		recepti.add(noviRecept);
		trenutniKorisnik.getRecepti().add(noviRecept);
		
	   }
	   
	   public void izbrisiRecept() {
	      // TODO: implement
	   }
	   
	   public void izmeniRecept() {
	      // TODO: implement
	   }
	   
	   public void registracija() {
	      // TODO: implement
	   }
	   
	   public void logIn() {
	      // TODO: implement
	   }
	   
	   public void logOut() {
	      // TODO: implement
	   }
	   
	   public void ostaviKomentar() {
	      // TODO: implement
	   }
	   
	   public void izmeniKomentar() {
	      // TODO: implement
	   }
	   
	   public void obrisiKomentar() {
	      // TODO: implement
	   }

	public ArrayList<Sastojak> getSastojci() {
		return sastojci;
	}

	public void setSastojci(ArrayList<Sastojak> sastojci) {
		this.sastojci = sastojci;
	}

	public ArrayList<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}

	public ArrayList<Kategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(ArrayList<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}

	public ArrayList<Aparat> getAparati() {
		return aparati;
	}

	public void setAparati(ArrayList<Aparat> aparati) {
		this.aparati = aparati;
	}

	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public Korisnik getTrenutniKorisnik() {
		return trenutniKorisnik;
	}

	public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
		this.trenutniKorisnik = trenutniKorisnik;
	}
	   
}
