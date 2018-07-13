package dataClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.plaf.BorderUIResource.TitledBorderUIResource;

public class Korisnik {
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private int brojacLajkova;
	private VrstaKorisnika vrstaKorisnika;
	private TitulaKorisnika titula;
	private ArrayList<Recept> recepti;
	private ArrayList<KolicinaSastojka> kolicinaSastojaka;
	private ArrayList<Recept> lajkovaniRecepti;
	private ArrayList<Recept> dislajkovaniRecepti;
	private ArrayList<Aparat> aparati;
	
	private static ArrayList<Korisnik> korisnici;
	private static HashMap<String, ArrayList<Integer>> idRecepata;

	public Korisnik() {
		super();
		recepti = new ArrayList<Recept>();
		lajkovaniRecepti = new ArrayList<Recept>();
		dislajkovaniRecepti = new ArrayList<Recept>();
		aparati = new ArrayList<Aparat>();
		kolicinaSastojaka = new ArrayList<KolicinaSastojka>();
	}

	
	public Korisnik(String ime, String prezime, String username, String password, int brojacLajkova,
			VrstaKorisnika vrstaKorisnika, TitulaKorisnika titula, ArrayList<Recept> recepti,
			ArrayList<KolicinaSastojka> kolicinaSastojaka, ArrayList<Recept> lajkovaniRecepti,
			ArrayList<Recept> dislajkovaniRecepti, ArrayList<Aparat> aparati) {
		this( username,  password,  brojacLajkova,  vrstaKorisnika, titula, recepti,  kolicinaSastojaka,
				 lajkovaniRecepti,  dislajkovaniRecepti,  aparati);
		this.ime = ime;
		this.prezime = prezime;
	}


	public Korisnik(String username, String password, int brojacLajkova, VrstaKorisnika vrstaKorisnika,
			TitulaKorisnika titula, ArrayList<Recept> recepti, ArrayList<KolicinaSastojka> kolicinaSastojaka,
			ArrayList<Recept> lajkovaniRecepti, ArrayList<Recept> dislajkovaniRecepti, ArrayList<Aparat> aparati) {
		super();
		this.username = username;
		this.password = password;
		this.brojacLajkova = brojacLajkova;
		this.vrstaKorisnika = vrstaKorisnika;
		this.titula = titula;
		this.recepti = recepti;
		this.kolicinaSastojaka = kolicinaSastojaka;
		this.lajkovaniRecepti = lajkovaniRecepti;
		this.dislajkovaniRecepti = dislajkovaniRecepti;
		this.aparati = aparati;
	}

	@Override
	public String toString() {
		String line = "Korisnicko ime: " + username + "\nPassword: " + password + "\n";
		line += "Aparati:\n";

		for (Aparat a : aparati) {
			line += "\t" + a.getNaziv() + "\n";
		}

		line += "Kolicine sastojaka:\n";
		for (KolicinaSastojka s : kolicinaSastojaka) {
			line += "\t" + s.getKolicina() + "\n";
		}
		line += "Recepti:\n";
		for (Recept r : recepti) {
			line += "\t" + r.getNaziv() + "\n";
		}
		line += "Lajkovani recepti:\n";
		for (Recept r : lajkovaniRecepti) {
			line += "\t" + r.getNaziv() + "\n";
		}
		line += "Dislajkovani recepti:\n";
		for (Recept r : dislajkovaniRecepti) {
			line += "\t" + r.getNaziv() + "\n";
		}
		return line;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBrojacLajkova() {
		return brojacLajkova;
	}

	public void setBrojacLajkova(int brojacLajkova) {
		this.brojacLajkova = brojacLajkova;
	}

	public VrstaKorisnika getVrstaKorisnika() {
		return vrstaKorisnika;
	}

	public void setVrstaKorisnika(VrstaKorisnika vrstaKorisnika) {
		this.vrstaKorisnika = vrstaKorisnika;
	}

	public TitulaKorisnika getTitula() {
		return titula;
	}

	public void setTitula(TitulaKorisnika titula) {
		this.titula = titula;
	}

	public ArrayList<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}

	public ArrayList<KolicinaSastojka> getKolicinaSastojaka() {
		return kolicinaSastojaka;
	}

	public void setKolicinaSastojaka(ArrayList<KolicinaSastojka> kolicinaSastojaka) {
		this.kolicinaSastojaka = kolicinaSastojaka;
	}

	public ArrayList<Recept> getLajkovaniRecepti() {
		return lajkovaniRecepti;
	}

	public void setLajkovaniRecepti(ArrayList<Recept> lajkovaniRecepti) {
		this.lajkovaniRecepti = lajkovaniRecepti;
	}

	public ArrayList<Recept> getDislajkovaniRecepti() {
		return dislajkovaniRecepti;
	}

	public void setDislajkovaniRecepti(ArrayList<Recept> dislajkovaniRecepti) {
		this.dislajkovaniRecepti = dislajkovaniRecepti;
	}

	public ArrayList<Aparat> getAparati() {
		return aparati;
	}

	public void setAparati(ArrayList<Aparat> aparati) {
		this.aparati = aparati;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Korisnik) {
			Korisnik kor = (Korisnik) obj;
			if (kor.getUsername().equals(this.username)) {
				return true;
			}
		}
		return false;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public static void ucitajKorisnike(String nazivFajla, ArrayList<Recept> recepti, ArrayList<KolicinaSastojka> sastojci,
			ArrayList<Aparat> aparati) throws IOException {
		idRecepata = new HashMap<>();
		korisnici = new ArrayList<>();
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

	public static void upisiKorisnikeNew(String nazivFajla) throws IOException {
		PrintWriter upisiKorisnika = new PrintWriter(new FileWriter(nazivFajla));

		for (Korisnik kor : Aplikacija.aplikacija.getKorisnici()) {
			String strZaUpis = kor.getUsername() + "|" + kor.getPassword() + "|" + kor.getBrojacLajkova() + "|"
					+ kor.getVrstaKorisnika().toString() + "|" + kor.getTitula().toString() + "|";

			// Upis Id-a korisnikovih recepata.
			String strIdRecepata = "";
			if (kor.getRecepti().isEmpty()) {
				strIdRecepata = " ";
			} else {
				for (int i = 0; i < kor.getRecepti().size(); i++) {
					if (i > 0) {
						strIdRecepata += ";";
					}
					strIdRecepata += kor.getRecepti().get(i).getIdRecepta();
				}
			}

			strIdRecepata += "|";
			strZaUpis += strIdRecepata;

			// Upis Id-a korisnikovih sastojaka(Kolicine sastojaka).
			String strIdKolicineSastojaka = "";
			if (kor.getKolicinaSastojaka().isEmpty()) {
				strIdKolicineSastojaka = " ";
			} else {
				for (int i = 0; i < kor.getKolicinaSastojaka().size(); i++) {
					if (i > 0) {
						strIdKolicineSastojaka += ";";
					}
					strIdKolicineSastojaka += kor.getKolicinaSastojaka().get(i).getIdKolicineSastojaka();
				}
			}

			strIdKolicineSastojaka += "|";
			strZaUpis += strIdKolicineSastojaka;

			// Upis Id-a korisnikovih lajkovanih recepata.
			String strIdLajkovanihRec = "";
			if (kor.getLajkovaniRecepti().isEmpty()) {
				strIdLajkovanihRec = " ";
			} else {
				for (int i = 0; i < kor.getLajkovaniRecepti().size(); i++) {
					if (i > 0) {
						strIdLajkovanihRec += ";";
					}
					strIdLajkovanihRec += kor.getLajkovaniRecepti().get(i).getIdRecepta();
				}
			}

			strIdLajkovanihRec += "|";
			strZaUpis += strIdLajkovanihRec;

			// Upis Id-a korisnikovih dislajkovanih recepata.
			String strIdDislajkRec = "";
			if (kor.getDislajkovaniRecepti().isEmpty()) {
				strIdDislajkRec = " ";
			} else {
				for (int i = 0; i < kor.getDislajkovaniRecepti().size(); i++) {
					if (i > 0) {
						strIdDislajkRec += ";";
					}
					strIdDislajkRec += kor.getDislajkovaniRecepti().get(i).getIdRecepta();
				}
			}

			strIdDislajkRec += "|";
			strZaUpis += strIdDislajkRec;

			// Upis Id-a korisnikovih aparata.
			String strNazivAparata = "";
			if(kor.getAparati().isEmpty()) {
				strNazivAparata = " ";
			} else {
				for (int i = 0; i < kor.getAparati().size(); i++) {
					if (i > 0) {
						strNazivAparata += ";";
					}
					strNazivAparata += kor.getAparati().get(i).getIdAparata();
				}
			}
			
			strZaUpis += strNazivAparata;
			strZaUpis += "|" + kor.getIme() + "|" + kor.getPrezime();

			// Upis korisnika u fajl.
			upisiKorisnika.println(strZaUpis);

		}
		upisiKorisnika.close();

	}

	public static Recept pronadjiRecept(ArrayList<Recept> recepti, int id) {
		Recept pronadjeniRecept = null;

		for (Recept r : recepti) {
			if (id == r.getIdRecepta()) {
				pronadjeniRecept = r;
			}
		}

		return pronadjeniRecept;
	}

	private static Aparat pronadjiAparat(ArrayList<Aparat> aparati, String id) {
		Aparat pronadjeniAparat = null;
		for (Aparat ap : aparati) {
			if (ap.getIdAparata() == Integer.parseInt(id)) {
				pronadjeniAparat = ap;
				break;
			}
		}

		return pronadjeniAparat;
	}

	private static KolicinaSastojka pronadjiKolicinuSastojka(ArrayList<KolicinaSastojka> sastojci, int id) {
		KolicinaSastojka sastojak = null;
		for (int i = 0; i < sastojci.size(); i++) {
			if (sastojci.get(i).getIdKolicineSastojaka() == id) {
				sastojak = sastojci.get(i);
				break;
			}
		}
		return sastojak;
	}

	public static ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public static void setKorisnici(ArrayList<Korisnik> korisnici) {
		korisnici = korisnici;
	}

	public static HashMap<String, ArrayList<Integer>> getIdRecepata() {
		return idRecepata;
	}

	public static void setIdRecepata(HashMap<String, ArrayList<Integer>> idRecepata) {
		idRecepata = idRecepata;
	}

}
