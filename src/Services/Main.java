package Services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Kategorija;
import dataClasses.KolicinaSastojka;
import dataClasses.Komentar;
import dataClasses.Korisnik;
import dataClasses.Recept;
import dataClasses.Sastojak;
import gui.MainFrame;

public class Main {

	public static void ucitajPodatke(AparatServis aparati, SastojakServis sastojci,
			KolicinaSastojkaServis kolicineSastojaka, KategorijaServis kategorije, KomentarServis komentari,
			ReceptServis recepti, KorisnikServis korisnici) throws IOException, ParseException {

		aparati.ucitaj("./src/Files/aparati.txt");
		sastojci.ucitaj("./src/Files/sastojci.txt");
		kolicineSastojaka.ucitaj("./src/Files/kolicineSastojaka.txt", sastojci.getSastojci());
		kategorije.ucitaj("./src/Files/kategorije.txt");
		korisnici.ucitajKorisnike("./src/Files/korisnici.txt", recepti.getListaRecepata(),
				kolicineSastojaka.getKolicineSastojaka(), aparati.getAparati());
		komentari.ucitaj("./src/Files/komentari.txt", korisnici.getKorisnici());
		recepti.ucitaj("./src/Files/recepti.txt", korisnici.getKorisnici(), kolicineSastojaka.getKolicineSastojaka(),
				aparati.getAparati(), kategorije.getKategorije(), komentari.getKomentari());

		ArrayList<Integer> idRec = null;
		for (Korisnik kor : korisnici.getKorisnici()) {
			if (korisnici.getIdRecepata().containsKey(kor.getUsername())) {
				idRec = korisnici.getIdRecepata().get(kor.getUsername());
				for (Integer id : idRec) {
					Recept rec = null;
					rec = korisnici.pronadjiRecept(recepti.getListaRecepata(), id.intValue());
					kor.getRecepti().add(rec);
				}
			}

		}

	}

	public static void upisiPodatke() throws IOException, ParseException {

		KorisnikServis.upisiKorisnikeNew("./src/Files/korisnici.txt");
		AparatServis.upisiAparate("./src/Files/aparati.txt");
		KomentarServis.upisiKomentare("./src/Files/komentari.txt");
		KategorijaServis.upisiKategorije("./src/Files/kategorije.txt");
		SastojakServis.upisiSastojke("./src/Files/sastojci.txt");
		KolicinaSastojkaServis.upisiKolicinuSastojaka("./src/Files/kolicineSastojaka.txt");
		ReceptServis.upisiRecepte("./src/Files/recepti.txt");
	}

	public static void main(String[] args) throws IOException, ParseException {

		AparatServis aparati = new AparatServis();
		SastojakServis sastojci = new SastojakServis();
		KolicinaSastojkaServis kolicineSastojaka = new KolicinaSastojkaServis();
		KategorijaServis kategorije = new KategorijaServis();
		KomentarServis komentari = new KomentarServis();
		ReceptServis recepti = new ReceptServis();
		KorisnikServis korisnici = new KorisnikServis();

		ucitajPodatke(aparati, sastojci, kolicineSastojaka, kategorije, komentari, recepti, korisnici);

		for (Korisnik k : korisnici.getKorisnici()) {
			System.out.println(k);
		}

		Aplikacija app = new Aplikacija(sastojci.getSastojci(), recepti.getListaRecepata(), kategorije.getKategorije(),
				aparati.getAparati(), korisnici.getKorisnici());

		for (Korisnik k : korisnici.getKorisnici()) {
			if (k.getUsername() == "pera") {
				Aplikacija.aplikacija.setTrenutniKorisnik(k);
			}
		}

		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);

	}

}
