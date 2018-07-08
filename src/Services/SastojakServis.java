package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import dataClasses.Sastojak;

public class SastojakServis {
	
	ArrayList<Sastojak> sastojci;
	
	
	public SastojakServis() {
		sastojci = new ArrayList<Sastojak>();
	}
	

	public void ucitaj(String nazivFajla) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ( (line = bf.readLine()) != null ) {
			String[] podaci = line.split("\\|");
			int id = Integer.parseInt(podaci[0]);
			String naziv = podaci[1];
			String opis = podaci[2];
			Sastojak sastojak = new Sastojak(id,naziv, opis);
			
			sastojci.add(sastojak);
		}
		bf.close();
	}
	
	public ArrayList<Sastojak> getSastojci() {
		return sastojci;
	}


	public void setSastojci(ArrayList<Sastojak> sastojci) {
		this.sastojci = sastojci;
	}


}
