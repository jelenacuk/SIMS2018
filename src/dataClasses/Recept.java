package dataClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Recept {
	private int idRecepta;
	private String naziv;
	private String opis;
	private String tekst;
	private int brLajkova;
	private int brDislajkova;
	private Date datumObjave;
	private boolean suspendovan;
	private Kategorija kategorija;
	private Korisnik korisnik;
	private ArrayList<Aparat> neophodniAparati;
	private ArrayList<Aparat> opcioniAparati;
	private ArrayList<KolicinaSastojka> neophodniSastojci;
	private ArrayList<KolicinaSastojka> opcioniSastojci;
	private ArrayList<Komentar> komentari;
	private int trajanjePripreme;
	private String slika;
	private static ArrayList<Recept> recepti;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

	public Recept() {
		super();
		opcioniAparati = new ArrayList<>();
		neophodniAparati = new ArrayList<>();
		komentari = new ArrayList<>();
		neophodniSastojci = new ArrayList<>();
		opcioniSastojci = new ArrayList<>();
		slika = "./src/download.jpg";

	}

	public Recept(int idRecepta, String naziv, String opis, String tekst, int brLajkova, int brDislajkova,
			Date datumObjave, boolean suspendovan, Kategorija kategorija, Korisnik korisnik,
			ArrayList<Aparat> neophodniAparati, ArrayList<Aparat> opcioniAparati,
			ArrayList<KolicinaSastojka> neophodniSastojci, ArrayList<KolicinaSastojka> opcioniSastojci,
			ArrayList<Komentar> komentari, int trajanje) {
		super();
		this.idRecepta = idRecepta;
		this.naziv = naziv;
		this.opis = opis;
		this.tekst = tekst;
		this.brLajkova = brLajkova;
		this.brDislajkova = brDislajkova;
		this.datumObjave = datumObjave;
		this.suspendovan = suspendovan;
		this.kategorija = kategorija;
		this.korisnik = korisnik;
		this.neophodniAparati = neophodniAparati;
		this.opcioniAparati = opcioniAparati;
		this.neophodniSastojci = neophodniSastojci;
		this.opcioniSastojci = opcioniSastojci;
		this.komentari = komentari;
		this.trajanjePripreme = trajanje;
		slika = "./src/download.jpg";
	}

	public int getIdRecepta() {
		return idRecepta;
	}

	public void setIdRecepta(int idRecepta) {
		this.idRecepta = idRecepta;
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

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public int getBrLajkova() {
		return brLajkova;
	}

	public void setBrLajkova(int brLajkova) {
		this.brLajkova = brLajkova;
	}

	public int getBrDislajkova() {
		return brDislajkova;
	}

	public void setBrDislajkova(int brDislajkova) {
		this.brDislajkova = brDislajkova;
	}

	public Date getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}

	public boolean isSuspendovan() {
		return suspendovan;
	}

	public void setSuspendovan(boolean suspendovan) {
		this.suspendovan = suspendovan;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public ArrayList<Aparat> getNeophodniAparati() {
		return neophodniAparati;
	}

	public void setNeophodniAparati(ArrayList<Aparat> neophodniAparati) {
		this.neophodniAparati = neophodniAparati;
	}

	public ArrayList<Aparat> getOpcioniAparati() {
		return opcioniAparati;
	}

	public void setOpcioniAparati(ArrayList<Aparat> opcioniAparati) {
		this.opcioniAparati = opcioniAparati;
	}

	public ArrayList<KolicinaSastojka> getNeophodniSastojci() {
		return neophodniSastojci;
	}

	public void setNeophodniSastojci(ArrayList<KolicinaSastojka> neophodniSastojci) {
		this.neophodniSastojci = neophodniSastojci;
	}

	public ArrayList<KolicinaSastojka> getOpcioniSastojci() {
		return opcioniSastojci;
	}

	public void setOpcioniSastojci(ArrayList<KolicinaSastojka> opcioniSastojci) {
		this.opcioniSastojci = opcioniSastojci;
	}

	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public int getTrajanjePripreme() {
		return trajanjePripreme;
	}

	public void setTrajanjePripreme(int trajanjePripreme) {
		this.trajanjePripreme = trajanjePripreme;
	}

	public static void ucitaj(String nazivFajla, ArrayList<Korisnik> korisnici, ArrayList<KolicinaSastojka> sastojci,
			ArrayList<Aparat> aparati, ArrayList<Kategorija> kategorije, ArrayList<Komentar> komentari)
			throws IOException, ParseException {
		recepti = new ArrayList<>();
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ((line = bf.readLine()) != null) {
			String[] podaci = line.split("\\|");
			int idRecepta = Integer.parseInt(podaci[0]);
			String naziv = podaci[1];
			String opis = podaci[2];
			String tekst = podaci[3];
			int brLajkova = Integer.parseInt(podaci[4]);
			int brDislajkova = Integer.parseInt(podaci[5]);
			Date datumObjave = sdf.parse(podaci[6]);
			Boolean suspendovan = Boolean.parseBoolean(podaci[7]);
			Kategorija kategorija = nadjiKategoriju(kategorije, Integer.parseInt(podaci[8]));
			Korisnik korisnik = nadjiKorisnika(korisnici, podaci[9]);
			if (korisnik == null) {
				System.out.println("Korisnik nije pronadjen!");
			}
			ArrayList<Aparat> neophodniAparati = napraviListuAparata(podaci[10], aparati);
			ArrayList<Aparat> opcioniAparati = napraviListuAparata(podaci[11], aparati);
			ArrayList<KolicinaSastojka> neophodniSastojci = napraviListuSastojaka(podaci[12], sastojci);
			ArrayList<KolicinaSastojka> opcioniSastojci = napraviListuSastojaka(podaci[13], sastojci);
			ArrayList<Komentar> komentarii = napraviListuKomentara(podaci[14], komentari);
			int trajanje = Integer.parseInt(podaci[15]);

			Recept recept = new Recept(idRecepta, naziv, opis, tekst, brLajkova, brDislajkova, datumObjave, suspendovan,
					kategorija, korisnik, neophodniAparati, opcioniAparati, neophodniSastojci, opcioniSastojci,
					komentarii, trajanje);

			recepti.add(recept);

		}
		bf.close();
	}

	public static void upisiRecepte(String nazivFajla) throws IOException {
		PrintWriter upisiRecept = new PrintWriter(new FileWriter(nazivFajla));
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		for (Recept rec : Aplikacija.aplikacija.getRecepti()) {
			String strZaUpis = rec.getIdRecepta() + "|" + rec.getNaziv() + "|" + rec.getOpis() + " |" + rec.getTekst()
					+ "|" + rec.getBrLajkova() + "|" + rec.getBrDislajkova() + "|" + sdf.format(rec.getDatumObjave())
					+ "|" + rec.isSuspendovan() + "|" + rec.getKategorija().getIdKategorije() + "|"
					+ rec.getKorisnik().getUsername() + "|";

			// Upis Id-a neophodnih aparata.
			String strAparati = "";
			if (rec.getNeophodniAparati().isEmpty()) {
				strAparati = " ";
			} else {
				for (int i = 0; i < rec.getNeophodniAparati().size(); i++) {
					if (i > 0) {
						strAparati += ";";
					}
					strAparati += rec.getNeophodniAparati().get(i).getIdAparata();
				}
			}

			strAparati += "|";
			strZaUpis += strAparati;

			// Upis Id-a opcionih aparata.
			String strAparati2 = " ";
			/*
			 * if(rec.getOpcioniAparati().size() == 0) { strAparati2 = " "; } else { for
			 * (int i = 0; i < rec.getOpcioniAparati().size(); i++) { if (i > 0) {
			 * strAparati2 += ";"; } strAparati2 +=
			 * rec.getOpcioniAparati().get(i).getIdAparata(); } }
			 */

			strAparati2 += "|";
			strZaUpis += strAparati2;

			// Upis Id-a neophodnih sastojaka (KolicinaSastojaka).
			String strSastojci = "";
			for (int i = 0; i < rec.getNeophodniSastojci().size(); i++) {
				if (i > 0) {
					strSastojci += ";";
				}
				strSastojci += rec.getNeophodniSastojci().get(i).getIdKolicineSastojaka();
			}
			strSastojci += "|";
			strZaUpis += strSastojci;

			// Upis Id-a opcionih sastojaka (KolicinaSastojaka).
			String strSastojci2 = "";
			if (rec.getOpcioniSastojci().isEmpty()) {
				strSastojci2 = " ";
			}
			for (int i = 0; i < rec.getOpcioniSastojci().size(); i++) {
				if (i > 0) {
					strSastojci2 += ";";
				}
				strSastojci2 += rec.getOpcioniSastojci().get(i).getIdKolicineSastojaka();
			}
			strSastojci2 += "|";
			strZaUpis += strSastojci2;

			// Upis Id-a komentara.
			String strKomentari = "";
			if (rec.getKomentari().isEmpty()) {
				strKomentari = " ";
			}
			for (int i = 0; i < rec.getKomentari().size(); i++) {
				if (i > 0) {
					strKomentari += ";";
				}
				strKomentari += rec.getKomentari().get(i).getIdKomentara();
			}
			strZaUpis += strKomentari;
			strZaUpis += "|" + rec.getTrajanjePripreme();

			upisiRecept.println(strZaUpis);
		}
		upisiRecept.close();
	}

	public static ArrayList<Komentar> napraviListuKomentara(String line, ArrayList<Komentar> listaKomentara) {
		ArrayList<Komentar> vrati = new ArrayList<Komentar>();
		String[] komentari = line.split("\\;");
		for (String ko : komentari) {
			if (ko.equals(" ")) {
				break;
			}
			vrati.add(nadjiKomentar(listaKomentara, Integer.parseInt(ko)));
		}
		return vrati;

	}

	public static ArrayList<Aparat> napraviListuAparata(String line, ArrayList<Aparat> listaAparata) {
		ArrayList<Aparat> vrati = new ArrayList<Aparat>();
		String[] aparati = line.split("\\;");
		for (String ap : aparati) {
			if (ap.equals(" ")) {
				break;
			}
			vrati.add(nadjiSAparat(listaAparata, Integer.parseInt(ap)));
		}
		return vrati;

	}

	public static ArrayList<KolicinaSastojka> napraviListuSastojaka(String line, ArrayList<KolicinaSastojka> listaSastojaka) {
		ArrayList<KolicinaSastojka> vrati = new ArrayList<KolicinaSastojka>();
		String[] sastojci = line.split("\\;");
		for (String sa : sastojci) {
			if (sa.equals(" ")) {
				break;
			}
			vrati.add(nadjiKolicinuSastojka(listaSastojaka, Integer.parseInt(sa)));
		}
		return vrati;

	}

	public static Korisnik nadjiKorisnika(ArrayList<Korisnik> korisnici, String username) {
		Korisnik korisnik = null;
		for (Korisnik kor : korisnici) {
			if (kor.getUsername().equals(username)) {
				korisnik = kor;
			}
		}
		return korisnik;
	}

	public static Kategorija nadjiKategoriju(ArrayList<Kategorija> kategorije, int id) {
		Kategorija kategorija = null;
		for (int i = 0; i < kategorije.size(); i++) {
			if (kategorije.get(i).getIdKategorije() == id) {
				kategorija = kategorije.get(i);
				break;
			}
		}
		return kategorija;
	}

	public static KolicinaSastojka nadjiKolicinuSastojka(ArrayList<KolicinaSastojka> sastojci, int id) {
		KolicinaSastojka sastojak = null;
		for (int i = 0; i < sastojci.size(); i++) {
			if (sastojci.get(i).getIdKolicineSastojaka() == id) {
				sastojak = sastojci.get(i);
				break;
			}
		}
		return sastojak;
	}

	public static Aparat nadjiSAparat(ArrayList<Aparat> aparati, int id) {
		Aparat aparat = null;
		for (int i = 0; i < aparati.size(); i++) {
			if (aparati.get(i).getIdAparata() == id) {
				aparat = aparati.get(i);
				break;
			}
		}
		return aparat;
	}

	public static Komentar nadjiKomentar(ArrayList<Komentar> komentari, int id) {
		Komentar komentar = null;
		for (int i = 0; i < komentari.size(); i++) {
			if (komentari.get(i).getIdKomentara() == id) {
				komentar = komentari.get(i);
				break;
			}
		}
		return komentar;
	}

	public static ArrayList<Recept> getListaRecepata() {
		return recepti;
	}

	public static void setListaRecepata(ArrayList<Recept> listaRecepata) {
		recepti = listaRecepata;
	}

}
