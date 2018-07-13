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

public class Komentar {
	private int idKomentara;
	private String tekst;
	private Date datum;
	private Korisnik korisnik;
	private static ArrayList<Komentar> komentari;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	public Komentar(int idKomentara, String tekst, Date datum, Korisnik korisnik) {
		super();
		this.idKomentara = idKomentara;
		this.tekst = tekst;
		this.datum = datum;
		this.korisnik = korisnik;
	}

	@Override
	public String toString() {
		String line = "Datum: " + datum + "\nKorisnik: " + korisnik.toString() + "\nTekst: " + tekst + "\n";
		return line;

	}

	public int getIdKomentara() {
		return idKomentara;
	}

	public void setIdKomentara(int idKomentara) {
		this.idKomentara = idKomentara;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public static void ucitaj(String nazivFajla, ArrayList<Korisnik> korisnici) throws IOException, ParseException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		komentari = new ArrayList<>();
		while ((line = bf.readLine()) != null) {
			String[] podaci = line.split("\\|");
			int idKomentara = Integer.parseInt(podaci[0]);
			String tekst = podaci[1];
			Date datum = sdf.parse(podaci[2]);
			Korisnik korisnik = nadjiKorisnika(korisnici, podaci[3]);
			Komentar komentar = new Komentar(idKomentara, tekst, datum, korisnik);

			komentari.add(komentar);
		}
		bf.close();
	}

	public static void upisiKomentare(String nazivFajla) throws IOException {
		PrintWriter upisiKomentar = new PrintWriter(new FileWriter(nazivFajla));
		ArrayList<Komentar> komentari = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		for (Recept recept : Aplikacija.aplikacija.getRecepti()) {
			for (Komentar komentar : recept.getKomentari()) {
				komentari.add(komentar);
			}
		}
		for (Komentar kom : komentari) {
			String strZaUpis = kom.getIdKomentara() + "|" + kom.getTekst() + "|" + sdf.format(kom.getDatum()) + "|"
					+ kom.getKorisnik().getUsername();

			upisiKomentar.println(strZaUpis);
		}
		upisiKomentar.close();
	}

	public static Korisnik nadjiKorisnika(ArrayList<Korisnik> korisnici, String username) {
		/*
		 * Korisnik korisnik = null; if (korisnici.containsKey(username)) { korisnik =
		 * korisnici.get(username); }
		 */
		for (Korisnik k : korisnici) {
			if (username.equals(k.getUsername())) {
				return k;
			}
		}
		return null;
	}

	public static ArrayList<Komentar> getKomentari() {
		return komentari;
	}

	public static void setKomentari(ArrayList<Komentar> kom) {
		komentari = kom;
	}
}
