package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

	// Metoda za ucitavanje postojecih korisnika iz fajla.
	// Metoda ucitava podatke, liniju po liniju i za svaku liniju pravi novog
	// korisnika.
	public void ucitajKorisnike(String nazivFajla, HashMap<Integer, Recept> recepti,
			ArrayList<KolicinaSastojka> sastojci, ArrayList<Aparat> aparati) throws IOException {
		String trenutnaLinija;
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		while ((trenutnaLinija = bf.readLine()) != null) {
			String[] sL = trenutnaLinija.split("\\|");
			// Instanciranje ucitanog korisnika.
			Korisnik ucitaniKorisnik = new Korisnik(sL[0], sL[1], Integer.parseInt(sL[2]), VrstaKorisnika.REGULARAN,
					TitulaKorisnika.NOVAJLIJA, new ArrayList<Recept>(), new ArrayList<KolicinaSastojka>(),
					new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Aparat>());
			// Provera tacne vrste korisnika.
			switch (sL[3]) {
			case "REGULARAN":
				ucitaniKorisnik.setVrstaKorisnika(VrstaKorisnika.REGULARAN);
				break;
			case "ADMIN":
				ucitaniKorisnik.setVrstaKorisnika(VrstaKorisnika.ADMIN);
				break;
			}

			// Provera tacne titule korisnika.
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

			// Ucitavanje recepata korisnika (preko id-a recepta).
			String[] sLRecepti = sL[5].split("\\;");
			for (int i = 0; i < sLRecepti.length; i++) {
				if (sLRecepti[i].equals("")) {
					break;
				}
				Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLRecepti[i]));
				ucitaniKorisnik.getRecepti().add(ucitaniRecept);

			}

			// Ucitavanje kolicineSastojaka.
			String[] sLSastojci = sL[6].split("\\;");
			for (int i = 0; i < sLSastojci.length; i++) {
				if (sLSastojci[i].equals("")) {
					break;
				}
				KolicinaSastojka ks = pronadjiKolicinuSastojka(sastojci, Integer.parseInt(sLSastojci[i]));
				ucitaniKorisnik.getKolicinaSastojaka().add(ks);
			}

			// Ucitavanje lajkovanih recepata (preko id-a recepta).
			String[] sLLajkovani = sL[7].split("\\;");
			for (int i = 0; i < sLLajkovani.length; i++) {
				if (sLLajkovani[i].equals("")) {
					break;
				}
				Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLLajkovani[i]));
				ucitaniKorisnik.getLajkovaniRecepti().add(ucitaniRecept);
			}

			// Ucitavanje dislajkovanih recepata (preko id-a recepta).
			String[] sLDis = sL[8].split("\\;");
			for (int i = 0; i < sLDis.length; i++) {
				if (sLDis[i].equals("")) {
					break;
				}
				Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLDis[i]));
				ucitaniKorisnik.getDislajkovaniRecepti().add(ucitaniRecept);
			}

			// Ucitavanje aparata (preko naziva aparata).
			String[] sLAparati = sL[9].split("\\;");
			for (int i = 0; i < sLAparati.length; i++) {
				if (sLAparati[i].equals("")) {
					break;
				}

				Aparat ucitaniAparat = pronadjiAparat(aparati, sLAparati[i]);
				ucitaniKorisnik.getAparati().add(ucitaniAparat);
			}

			korisnici.put(sL[0], ucitaniKorisnik);

		}
		bf.close();
	}

	public void upisiKorisnike(String nazivFajla) throws IOException {
		PrintWriter upisiKorisnika = new PrintWriter(new FileWriter(nazivFajla));

		for (Map.Entry<String, Korisnik> entry : this.korisnici.entrySet()) {
			Korisnik kor = entry.getValue();
			String strZaUpis = kor.getUsername() + "|" + kor.getPassword() + "|" + kor.getBrojacLajkova() + "|"
					+ kor.getVrstaKorisnika().toString() + "|" + kor.getTitula().toString() + "|";

			// Upis Id-a korisnikovih recepata.
			String strIdRecepata = "";
			for (int i = 0; i < kor.getRecepti().size(); i++) {
				if (i > 0) {
					strIdRecepata += ";";
				}
				strIdRecepata += kor.getRecepti().get(i).getIdRecepta();
			}
			strIdRecepata += "|";
			strZaUpis += strIdRecepata;

			// Upis Id-a korisnikovih sastojaka(Kolicine sastojaka).
			String strIdKolicineSastojaka = "";
			for (int i = 0; i < kor.getKolicinaSastojaka().size(); i++) {
				if (i > 0) {
					strIdKolicineSastojaka += ";";
				}
				strIdKolicineSastojaka += kor.getKolicinaSastojaka().get(i).getIdKolicineSastojaka();
			}
			strIdKolicineSastojaka += "|";
			strZaUpis += strIdKolicineSastojaka;

			// Upis Id-a korisnikovih lajkovanih recepata.
			String strIdLajkovanihRec = "";
			for (int i = 0; i < kor.getLajkovaniRecepti().size(); i++) {
				if (i > 0) {
					strIdLajkovanihRec += ";";
				}
				strIdLajkovanihRec += kor.getLajkovaniRecepti().get(i).getIdRecepta();
			}
			strIdLajkovanihRec += "|";
			strZaUpis += strIdLajkovanihRec;

			// Upis Id-a korisnikovih dislajkovanih recepata.
			String strIdDislajkRec = "";
			for (int i = 0; i < kor.getDislajkovaniRecepti().size(); i++) {
				if (i > 0) {
					strIdDislajkRec += ";";
				}
				strIdDislajkRec += kor.getDislajkovaniRecepti().get(i).getIdRecepta();
			}
			strIdDislajkRec += "|";
			strZaUpis += strIdDislajkRec;

			// Upis Id-a korisnikovih aparata.
			String strNazivAparata = "";
			for (int i = 0; i < kor.getAparati().size(); i++) {
				if (i > 0) {
					strNazivAparata += ";";
				}
				strNazivAparata += kor.getAparati().get(i).getIdAparata();
			}
			strZaUpis += strNazivAparata;

			// Upis korisnika u fajl.
			upisiKorisnika.println(strZaUpis);

		}
		upisiKorisnika.close();

	}

	private Recept pronadjiRecept(HashMap<Integer, Recept> recepti, int id) {
		Recept pronadjeniRecept = null;
		if (recepti.containsKey(id)) {
			pronadjeniRecept = recepti.get(id);
		}

		return pronadjeniRecept;
	}

	private Aparat pronadjiAparat(ArrayList<Aparat> aparati, String id) {
		Aparat pronadjeniAparat = null;
		for (Aparat ap : aparati) {
			if (ap.getIdAparata() == Integer.parseInt(id)) {
				pronadjeniAparat = ap;
				break;
			}
		}

		return pronadjeniAparat;
	}

	private KolicinaSastojka pronadjiKolicinuSastojka(ArrayList<KolicinaSastojka> sastojci, int id) {
		KolicinaSastojka sastojak = null;
		for (int i = 0; i < sastojci.size(); i++) {
			if (sastojci.get(i).getIdKolicineSastojaka() == id) {
				sastojak = sastojci.get(i);
				break;
			}
		}
		return sastojak;
	}

	public HashMap<String, Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(HashMap<String, Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

}
