package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import dataClasses.Aparat;
import dataClasses.KolicinaSastojka;
import dataClasses.Korisnik;
import dataClasses.Recept;
import dataClasses.TitulaKorisnika;
import dataClasses.VrstaKorisnika;

public class KorisnikServis {
	private ArrayList<Korisnik> korisnici;
	private HashMap<String, ArrayList<Integer>> idRecepata;

	public KorisnikServis() {
		korisnici = new ArrayList<>();
		idRecepata = new HashMap<>();
	}

	// Metoda za ucitavanje postojecih korisnika iz fajla.
	// Metoda ucitava podatke, liniju po liniju i za svaku liniju pravi novog
	// korisnika.
	public void ucitajKorisnike(String nazivFajla, ArrayList<Recept> recepti, ArrayList<KolicinaSastojka> sastojci,
			ArrayList<Aparat> aparati) throws IOException {

		String trenutnaLinija;
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		while ((trenutnaLinija = bf.readLine()) != null) {
			String[] sL = trenutnaLinija.split("\\|");
			// Instanciranje ucitanog korisnika.
			Korisnik ucitaniKorisnik = new Korisnik(sL[0], sL[1], Integer.parseInt(sL[2]), VrstaKorisnika.REGULARAN,
					TitulaKorisnika.NOVAJLIJA, new ArrayList<Recept>(), new ArrayList<KolicinaSastojka>(),
					new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Aparat>());
			ucitaniKorisnik.setIme(sL[10]);
			ucitaniKorisnik.setPrezime(sL[11]);
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
			ArrayList<Integer> idRec = new ArrayList<>();
			if (!sL[5].equals(" ")) {
				String[] sLRecepti = sL[5].split("\\;");
				for (int i = 0; i < sLRecepti.length; i++) {
					idRec.add(Integer.parseInt(sLRecepti[i]));
				}
				
			}
			idRecepata.put(sL[0], idRec);

			// Ucitavanje kolicineSastojaka.
			if (!sL[6].equals(" ")) {
				String[] sLSastojci = sL[6].split("\\;");
				for (int i = 0; i < sLSastojci.length; i++) {
					if (sLSastojci[i].equals("")) {
						break;
					}
					KolicinaSastojka ks = pronadjiKolicinuSastojka(sastojci, Integer.parseInt(sLSastojci[i]));
					ucitaniKorisnik.getKolicinaSastojaka().add(ks);
				}
			}

			// Ucitavanje lajkovanih recepata (preko id-a recepta).
			if (!sL[7].equals(" ")) {
				String[] sLLajkovani = sL[7].split("\\;");
				for (int i = 0; i < sLLajkovani.length; i++) {
					if (sLLajkovani[i].equals("")) {
						break;
					}
					Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLLajkovani[i]));
					ucitaniKorisnik.getLajkovaniRecepti().add(ucitaniRecept);
				}
			}

			// Ucitavanje dislajkovanih recepata (preko id-a recepta).
			if (!sL[8].equals(" ")) {
				String[] sLDis = sL[8].split("\\;");
				for (int i = 0; i < sLDis.length; i++) {
					if (sLDis[i].equals("")) {
						break;
					}
					Recept ucitaniRecept = pronadjiRecept(recepti, Integer.parseInt(sLDis[i]));
					ucitaniKorisnik.getDislajkovaniRecepti().add(ucitaniRecept);
				}
			}

			// Ucitavanje aparata (preko naziva aparata).
			if (!sL[9].equals(" ")) {
				String[] sLAparati = sL[9].split("\\;");
				for (int i = 0; i < sLAparati.length; i++) {
					if (sLAparati[i].equals("")) {
						break;
					}

					Aparat ucitaniAparat = pronadjiAparat(aparati, sLAparati[i]);
					ucitaniKorisnik.getAparati().add(ucitaniAparat);
				}
			}

			korisnici.add(ucitaniKorisnik);

		}
		bf.close();
	}

	public void upisiKorisnike(String nazivFajla) throws IOException {
		PrintWriter upisiKorisnika = new PrintWriter(new FileWriter(nazivFajla));

		for (Korisnik kor : korisnici) {
			String strZaUpis = kor.getUsername() + "|" + kor.getPassword() + "|" + kor.getBrojacLajkova() + "|"
					+ kor.getVrstaKorisnika().toString() + "|" + kor.getTitula().toString() + "|";

			// Upis Id-a korisnikovih recepata.
			String strIdRecepata = " ";
			for (int i = 0; i < kor.getRecepti().size(); i++) {
				if (i > 0) {
					strIdRecepata += ";";
				}
				strIdRecepata += kor.getRecepti().get(i).getIdRecepta();
			}
			strIdRecepata += "|";
			strZaUpis += strIdRecepata;

			// Upis Id-a korisnikovih sastojaka(Kolicine sastojaka).
			String strIdKolicineSastojaka = " ";
			for (int i = 0; i < kor.getKolicinaSastojaka().size(); i++) {
				if (i > 0) {
					strIdKolicineSastojaka += ";";
				}
				strIdKolicineSastojaka += kor.getKolicinaSastojaka().get(i).getIdKolicineSastojaka();
			}
			strIdKolicineSastojaka += "|";
			strZaUpis += strIdKolicineSastojaka;

			// Upis Id-a korisnikovih lajkovanih recepata.
			String strIdLajkovanihRec = " ";
			for (int i = 0; i < kor.getLajkovaniRecepti().size(); i++) {
				if (i > 0) {
					strIdLajkovanihRec += ";";
				}
				strIdLajkovanihRec += kor.getLajkovaniRecepti().get(i).getIdRecepta();
			}
			strIdLajkovanihRec += "|";
			strZaUpis += strIdLajkovanihRec;

			// Upis Id-a korisnikovih dislajkovanih recepata.
			String strIdDislajkRec = " ";
			for (int i = 0; i < kor.getDislajkovaniRecepti().size(); i++) {
				if (i > 0) {
					strIdDislajkRec += ";";
				}
				strIdDislajkRec += kor.getDislajkovaniRecepti().get(i).getIdRecepta();
			}
			strIdDislajkRec += "|";
			strZaUpis += strIdDislajkRec;

			// Upis Id-a korisnikovih aparata.
			String strNazivAparata = " ";
			for (int i = 0; i < kor.getAparati().size(); i++) {
				if (i > 0) {
					strNazivAparata += ";";
				}
				strNazivAparata += kor.getAparati().get(i).getIdAparata();
			}
			strZaUpis += strNazivAparata;
			strZaUpis += "|" +  kor.getIme() + "|" + kor.getPrezime();

			// Upis korisnika u fajl.
			upisiKorisnika.println(strZaUpis);

		}
		upisiKorisnika.close();

	}

	public Recept pronadjiRecept(ArrayList<Recept> recepti, int id) {
		Recept pronadjeniRecept = null;

		for (Recept r : recepti) {
			if (id == r.getIdRecepta()) {
				pronadjeniRecept = r;
			}
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

	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public HashMap<String, ArrayList<Integer>> getIdRecepata() {
		return idRecepata;
	}

	public void setIdRecepata(HashMap<String, ArrayList<Integer>> idRecepata) {
		this.idRecepata = idRecepata;
	}

}
