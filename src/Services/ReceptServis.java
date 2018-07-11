package Services;

import dataClasses.Recept;
import dataClasses.Sastojak;
import dataClasses.Aparat;
import dataClasses.Kategorija;
import dataClasses.KolicinaSastojka;
import dataClasses.Komentar;
import dataClasses.Korisnik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReceptServis {

	private ArrayList<Recept> recepti;
	public SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

	public ReceptServis() {
		this.recepti = new ArrayList<Recept>();
	}

	public void ucitaj(String nazivFajla, ArrayList<Korisnik> korisnici, ArrayList<KolicinaSastojka> sastojci,
			ArrayList<Aparat> aparati, ArrayList<Kategorija> kategorije, ArrayList<Komentar> komentari)
			throws IOException, ParseException {
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
			ArrayList<Aparat> neophodniAparati = napraviListuAparata(podaci[10], aparati);
			ArrayList<Aparat> opcioniAparati = napraviListuAparata(podaci[11], aparati);
			ArrayList<KolicinaSastojka> neophodniSastojci = napraviListuSastojaka(podaci[12], sastojci);
			ArrayList<KolicinaSastojka> opcioniSastojci = napraviListuSastojaka(podaci[13], sastojci);
			ArrayList<Komentar> komentarii = napraviListuKomentara(podaci[14], komentari);

			Recept recept = new Recept(idRecepta, naziv, opis, tekst, brLajkova, brDislajkova, datumObjave, suspendovan,
					kategorija, korisnik, neophodniAparati, opcioniAparati, neophodniSastojci, opcioniSastojci,
					komentarii);

			recepti.add(recept);

		}
		bf.close();
	}

	public void upisiRecepte(String nazivFajla) throws IOException {
		PrintWriter upisiRecept = new PrintWriter(new FileWriter(nazivFajla));
		for (Recept rec : recepti) {
			String strZaUpis = rec.getIdRecepta() + "|" + rec.getNaziv() + "|" + rec.getOpis() + "|" + rec.getTekst()
					+ "|" + rec.getBrLajkova() + "|" + rec.getBrDislajkova() + "|" + sdf.format(rec.getDatumObjave())
					+ "|" + rec.isSuspendovan() + "|" + rec.getKategorija().getIdKategorije() + "|"
					+ rec.getKorisnik().getUsername() + "|";

			// Upis Id-a neophodnih aparata.
			String strAparati = "";
			for (int i = 0; i < rec.getNeophodniAparati().size(); i++) {
				if (i > 0) {
					strAparati += ";";
				}
				strAparati += rec.getNeophodniAparati().get(i).getIdAparata();
			}
			strAparati += "|";
			strZaUpis += strAparati;

			// Upis Id-a opcionih aparata.
			String strAparati2 = "";
			for (int i = 0; i < rec.getOpcioniAparati().size(); i++) {
				if (i > 0) {
					strAparati2 += ";";
				}
				strAparati2 += rec.getOpcioniAparati().get(i).getIdAparata();
			}
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
			for (int i = 0; i < rec.getKomentari().size(); i++) {
				if (i > 0) {
					strKomentari += ";";
				}
				strKomentari += rec.getKomentari().get(i).getIdKomentara();
			}
			strZaUpis += strKomentari;

			upisiRecept.println(strZaUpis);
		}
		upisiRecept.close();
	}

	public ArrayList<Komentar> napraviListuKomentara(String line, ArrayList<Komentar> listaKomentara) {
		ArrayList<Komentar> vrati = new ArrayList<Komentar>();
		String[] komentari = line.split("\\;");
		for (String ko : komentari) {
			if (ko.equals("")) {
				break;
			}
			vrati.add(nadjiKomentar(listaKomentara, Integer.parseInt(ko)));
		}
		return vrati;

	}

	public ArrayList<Aparat> napraviListuAparata(String line, ArrayList<Aparat> listaAparata) {
		ArrayList<Aparat> vrati = new ArrayList<Aparat>();
		String[] aparati = line.split("\\;");
		for (String ap : aparati) {
			if (ap.equals("")) {
				break;
			}
			vrati.add(nadjiSAparat(listaAparata, Integer.parseInt(ap)));
		}
		return vrati;

	}

	public ArrayList<KolicinaSastojka> napraviListuSastojaka(String line, ArrayList<KolicinaSastojka> listaSastojaka) {
		ArrayList<KolicinaSastojka> vrati = new ArrayList<KolicinaSastojka>();
		String[] sastojci = line.split("\\;");
		for (String sa : sastojci) {
			if (sa.equals("")) {
				break;
			}
			vrati.add(nadjiKolicinuSastojka(listaSastojaka, Integer.parseInt(sa)));
		}
		return vrati;

	}

	public Korisnik nadjiKorisnika(ArrayList<Korisnik> korisnici, String username) {
		Korisnik korisnik = null;
		for (Korisnik kor : korisnici) {
			if (kor.getUsername() == username) {
				korisnik = kor;
			}
		}
		return korisnik;
	}

	public Kategorija nadjiKategoriju(ArrayList<Kategorija> kategorije, int id) {
		Kategorija kategorija = null;
		for (int i = 0; i < kategorije.size(); i++) {
			if (kategorije.get(i).getIdKategorije() == id) {
				kategorija = kategorije.get(i);
				break;
			}
		}
		return kategorija;
	}

	public KolicinaSastojka nadjiKolicinuSastojka(ArrayList<KolicinaSastojka> sastojci, int id) {
		KolicinaSastojka sastojak = null;
		for (int i = 0; i < sastojci.size(); i++) {
			if (sastojci.get(i).getIdKolicineSastojaka() == id) {
				sastojak = sastojci.get(i);
				break;
			}
		}
		return sastojak;
	}

	public Aparat nadjiSAparat(ArrayList<Aparat> aparati, int id) {
		Aparat aparat = null;
		for (int i = 0; i < aparati.size(); i++) {
			if (aparati.get(i).getIdAparata() == id) {
				aparat = aparati.get(i);
				break;
			}
		}
		return aparat;
	}

	public Komentar nadjiKomentar(ArrayList<Komentar> komentari, int id) {
		Komentar komentar = null;
		for (int i = 0; i < komentari.size(); i++) {
			if (komentari.get(i).getIdKomentara() == id) {
				komentar = komentari.get(i);
				break;
			}
		}
		return komentar;
	}

	public ArrayList<Recept> getListaRecepata() {
		return recepti;
	}

	public void setListaRecepata(ArrayList<Recept> listaRecepata) {
		this.recepti = listaRecepata;
	}

}