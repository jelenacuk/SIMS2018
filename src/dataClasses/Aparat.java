package dataClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Aparat {

	private int idAparata;
	private String naziv;
	private String opis;
	private static ArrayList<Aparat> aparati;

	// test
	public Aparat() {
	}

	public Aparat(int id, String naziv, String opis) {

		super();
		this.idAparata = id;
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
		if (obj instanceof Aparat) {
			Aparat a = (Aparat) obj;
			if (a.getIdAparata() == this.getIdAparata() && a.getNaziv() == this.getNaziv()
					&& a.getOpis() == this.getOpis()) {
				return true;
			}
		}
		return false;
	}

	public int getIdAparata() {
		return idAparata;
	}

	public void setIdAparata(int idAparata) {
		this.idAparata = idAparata;
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

	public static void ucitaj(String nazivFajla) throws IOException {
		aparati = new ArrayList<>();
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ((line = bf.readLine()) != null) {
			String[] podaci = line.split("\\|");
			int id = Integer.parseInt(podaci[0]);
			String naziv = podaci[1];
			String opis = podaci[2];
			Aparat aparat = new Aparat(id, naziv, opis);

			aparati.add(aparat);
		}
		bf.close();
	}

	public static void upisiAparate(String nazivFajla) throws IOException {
		PrintWriter upisiAparat = new PrintWriter(new FileWriter(nazivFajla));

		for (Aparat ap : Aplikacija.aplikacija.getAparati()) {
			String strZaUpis = ap.getIdAparata() + "|" + ap.getNaziv() + "|" + ap.getOpis();
			upisiAparat.println(strZaUpis);
		}
		upisiAparat.close();

	}

	public static ArrayList<Aparat> getAparati() {
		return aparati;
	}

}
