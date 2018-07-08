package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import dataClasses.Komentar;
import dataClasses.Korisnik;

public class KomentarServis {
	
	private ArrayList<Komentar> komentari;
	public  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	public KomentarServis() {
		komentari = new ArrayList<Komentar>();
	}
	
	public void ucitaj(String nazivFajla, HashMap<String, Korisnik> korisnici) throws IOException, ParseException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ( (line = bf.readLine()) != null ) {
			String[] podaci = line.split("\\|");
			int idKomentara = Integer.parseInt(podaci[0]);
			String tekst = podaci[1];
			Date datum = sdf.parse(podaci[2]);
			Korisnik korisnik = nadjiKorisnika(korisnici, podaci[3]);
			Komentar komentar = new Komentar(idKomentara, tekst, datum, korisnik);
			
			komentari.add(komentar);
		}
	}
	
	
	public Korisnik nadjiKorisnika(HashMap<String, Korisnik> korisnici, String username) {
		Korisnik korisnik = null;
		if (korisnici.containsKey(username)) {
			korisnik = korisnici.get(username);
		}
		return korisnik;
	}

	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}

}
