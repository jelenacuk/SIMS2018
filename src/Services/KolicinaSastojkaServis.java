package Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dataClasses.KolicinaSastojka;
import dataClasses.Sastojak;

public class KolicinaSastojkaServis {
	
	ArrayList<KolicinaSastojka> kolicineSastojaka;
	
	
	public KolicinaSastojkaServis() {
		kolicineSastojaka = new ArrayList<KolicinaSastojka>();
	}
	
	
	public void ucitaj(String nazivFajla, ArrayList<Sastojak> sastojci) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ( (line = bf.readLine()) != null ) {
			String[] podaci = line.split("\\|");
			int id = Integer.parseInt(podaci[0]);
			String kolicina = podaci[1];
			Sastojak sastojak = nadjiSastojak(sastojci, Integer.parseInt(podaci[2]));
			KolicinaSastojka ks = new KolicinaSastojka(id,kolicina,sastojak);
			kolicineSastojaka.add(ks);
			
		}
		bf.close();
		
	}
	
	
	public Sastojak nadjiSastojak(ArrayList<Sastojak> sastojci, int id) {
		Sastojak sastojak = null;
		for (int i = 0; i < sastojci.size(); i++) {
			if ( sastojci.get(i).getIdSastojka() == id ) {
				sastojak = sastojci.get(i);
				break;
			}
		}
		return sastojak;
	}


	public ArrayList<KolicinaSastojka> getKolicineSastojaka() {
		return kolicineSastojaka;
	}


	public void setKolicineSastojaka(ArrayList<KolicinaSastojka> kolicineSastojaka) {
		this.kolicineSastojaka = kolicineSastojaka;
	}

}
