package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import dataClasses.Komentar;
import dataClasses.Korisnik;

public class KomentarServis {

	private ArrayList<Komentar> komentari;
	public SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

	public KomentarServis() {
		this.komentari = new ArrayList<Komentar>();
	}

	public void ucitaj(String nazivFajla, ArrayList<Korisnik> korisnici) throws IOException, ParseException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ((line = bf.readLine()) != null) {
			String[] podaci = line.split("\\|");
			int idKomentara = Integer.parseInt(podaci[0]);
			String tekst = podaci[1];
			Date datum = this.sdf.parse(podaci[2]);
			Korisnik korisnik = nadjiKorisnika(korisnici, podaci[3]);
			Komentar komentar = new Komentar(idKomentara, tekst, datum, korisnik);

			this.komentari.add(komentar);
		}
		bf.close();
	}

	public void upisiKomentare(String nazivFajla) throws IOException {
		PrintWriter upisiKomentar = new PrintWriter(new FileWriter(nazivFajla));
		for (Komentar kom : this.komentari) {
			String strZaUpis = kom.getIdKomentara() + "|" + kom.getTekst() + "|" + this.sdf.format(kom.getDatum()) + "|"
					+ kom.getKorisnik().getUsername();

			upisiKomentar.println(strZaUpis);
		}
		upisiKomentar.close();
	}

	public Korisnik nadjiKorisnika(ArrayList<Korisnik> korisnici, String username) {
		/*
		 * Korisnik korisnik = null; if (korisnici.containsKey(username)) { korisnik =
		 * korisnici.get(username); }
		 */
		for (Korisnik k : korisnici) {
			if (k.getUsername() == username) {
				return k;
			}
		}
		return null;
	}

	public ArrayList<Komentar> getKomentari() {
		return this.komentari;
	}

	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}

}
