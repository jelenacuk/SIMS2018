package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	}

	public ArrayList<Kategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(ArrayList<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}
	
	

}
