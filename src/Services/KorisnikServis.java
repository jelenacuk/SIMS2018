package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import dataClasses.Aparat;
import dataClasses.KolicinaSastojka;
import dataClasses.Korisnik;
import dataClasses.Recept;
import dataClasses.TitulaKorisnika;
import dataClasses.VrstaKorisnika;

public class KorisnikServis {
	private HashMap<String, Korisnik> korisnici;

	public KorisnikServis() {
		korisnici = new HashMap<>();
	}
	
	//Metoda za ucitavanje postojecih korisnika iz fajla.
	//Metoda ucitava podatke, liniju po liniju i za svaku liniju pravi novog korisnika.
	public void ucitajKorisnike(String nazivFajla,HashMap<Integer, Recept> recepti, ArrayList<Aparat> aparati) throws IOException {
		String trenutnaLinija;
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		while ((trenutnaLinija = bf.readLine()) != null) {
			String[] sL = trenutnaLinija.split("\\|");
			
			//Instanciranje ucitanog korisnika.
			Korisnik ucitaniKorisnik = new Korisnik(sL[0], sL[1], Integer.parseInt(sL[2]), VrstaKorisnika.REGULARAN,
					TitulaKorisnika.NOVAJLIJA, new ArrayList<Recept>(), new ArrayList<KolicinaSastojka>(),
					new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Aparat>());
			//Provera tacne vrste korisnika.
			switch(sL[3]) {
			case "REGULARAN":
				ucitaniKorisnik.setVrstaKorisnika(VrstaKorisnika.REGULARAN);
				break;
			case "ADMIN":
				ucitaniKorisnik.setVrstaKorisnika(VrstaKorisnika.ADMIN);
				break;
			}
			
			//Provera tacne titule korisnika.
			switch (sL[4]) {
			case "NOVAJLIJA":
				ucitaniKorisnik.setTitula(TitulaKorisnika.NOVAJLIJA);
				break;

			case "ISKUSNIKUVAR":
				ucitaniKorisnik.setTitula(TitulaKorisnika.ISKUSNIKUVAR);
				break;
			
			case "VELEMAJSTOR":
				ucitaniKorisnik.setTitula(TitulaKorisnika.VELEMAJSTOR);
			}
			
			//Fali kolicina sastojaka! TO DO!!!
			
			//Ucitavanje recepata korisnika (preko id-a recepta).
			String[] sLRecepti = sL[5].split("\\;");
			for(int i = 0; i < sLRecepti.length;i++) {
				Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLRecepti[i]));
				ucitaniKorisnik.getRecepti().add(ucitaniRecept);
			}
			
			//Ucitavanje lajkovanih recepata (preko id-a recepta).
			String[] sLLajkovani = sL[7].split("\\;");
			for(int i = 0; i < sLLajkovani.length;i++) {
				Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLLajkovani[i]));
				ucitaniKorisnik.getLajkovaniRecepti().add(ucitaniRecept);
			}
			
			//Ucitavanje dislajkovanih recepata (preko id-a recepta).
			String[] sLDis = sL[8].split("\\;");
			for(int i = 0; i < sLDis.length;i++) {
				Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLDis[i]));
				ucitaniKorisnik.getDislajkovaniRecepti().add(ucitaniRecept);
			}
			
			//Ucitavanje aparata (preko naziva aparata).
			String[] sLAparati = sL[9].split("\\;");
			for(int i = 0; i < sLAparati.length;i++) {
				Aparat ucitaniAparat = pronadjiAparat(aparati, sLAparati[i]);
				ucitaniKorisnik.getAparati().add(ucitaniAparat);
			}
			
			korisnici.put(sL[0], ucitaniKorisnik);

		}
	}
	
	private Recept pronadjiRecept(HashMap<Integer,Recept> recepti, int id) {
		Recept pronadjeniRecept = null;
		pronadjeniRecept = recepti.get(id);
		
		return pronadjeniRecept;
	}
	
	private Aparat pronadjiAparat(ArrayList<Aparat> aparati,String naziv) {
		Aparat pronadjeniAparat = null;
		for(Aparat ap : aparati) {
			if(ap.getNaziv().equals(naziv)) {
				pronadjeniAparat = ap;
			}
		}
		
		return pronadjeniAparat;
	}

	public HashMap<String, Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(HashMap<String, Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

}
