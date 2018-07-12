package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dataClasses.Aplikacija;
import dataClasses.Kategorija;


public class KategorijaServis {
	
	ArrayList<Kategorija> kategorije;
	
	public KategorijaServis() {
		kategorije = new ArrayList<Kategorija>();
	}
	
	public void ucitaj(String nazivFajla) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ( (line = bf.readLine()) != null ) {
			String[] podaci = line.split("\\|");
			int id = Integer.parseInt(podaci[0]);
			String naziv = podaci[1];
			Kategorija kategorija = new Kategorija(id,naziv);
			
			kategorije.add(kategorija);
		}
		bf.close();
	}
	
	public static void upisiKategorije(String nazivFajla) throws IOException {
		PrintWriter upisiKategoriju = new PrintWriter(new FileWriter(nazivFajla));
		for(Kategorija kat : Aplikacija.aplikacija.getKategorije()) {
			String strZaUpis = kat.getIdKategorije() + "|" + kat.getNaziv();
			
			upisiKategoriju.println(strZaUpis);
		}
		upisiKategoriju.close();
	}

	public ArrayList<Kategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(ArrayList<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}
	
	

}
