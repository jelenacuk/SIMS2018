package Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dataClasses.Aparat;
import dataClasses.Aplikacija;

public class AparatServis {

	private ArrayList<Aparat> aparati;

	public AparatServis() {
		this.aparati = new ArrayList<Aparat>();
	}
	
	public void ucitaj(String nazivFajla) throws IOException {
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

	public ArrayList<Aparat> getAparati() {
		return aparati;
	}

	public void setAparati(ArrayList<Aparat> aparati) {
		this.aparati = aparati;
	}

}
