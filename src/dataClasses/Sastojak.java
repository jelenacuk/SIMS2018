package dataClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Sastojak {

	private int idSastojka;
	private String naziv;
	private String opis;
	private static ArrayList<Sastojak> sastojci = new ArrayList<>();

	public Sastojak(int id, String naziv, String opis) {
		super();
		this.idSastojka = id;
		this.naziv = naziv;
		this.opis = opis;
	}

	@Override
	public String toString() {
		String line = "Naziv: " + naziv + ". " + opis + "\n";
		return line;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sastojak) {
			Sastojak s = (Sastojak) obj;
			if (s.getIdSastojka() == this.getIdSastojka() && s.getNaziv() == this.getNaziv()
					&& s.getOpis() == this.getOpis()) {
				return true;
			}
		}
		return false;
	}

	public int getIdSastojka() {
		return idSastojka;
	}

	public void setIdSastojka(int idSastojka) {
		this.idSastojka = idSastojka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public static ArrayList<Sastojak> ucitaj(String nazivFajla) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ((line = bf.readLine()) != null) {
			String[] podaci = line.split("\\|");
			int id = Integer.parseInt(podaci[0]);
			String naziv = podaci[1];
			String opis = podaci[2];
			Sastojak sastojak = new Sastojak(id, naziv, opis);

			sastojci.add(sastojak);
		}
		bf.close();
		return sastojci;
	}

	public static void upisiSastojke(String nazivFajla) throws IOException {
		PrintWriter upisiSastojak = new PrintWriter(new FileWriter(nazivFajla));

		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {
			String strZaUpis = sastojak.getIdSastojka() + "|" + sastojak.getNaziv() + "|" + sastojak.getOpis();

			upisiSastojak.println(strZaUpis);
		}
		upisiSastojak.close();
	}

	public static ArrayList<Sastojak> getSastojci() {
		return sastojci;
	}

	public static void setSastojci(ArrayList<Sastojak> sast) {
		sastojci = sast;
	}

}
