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

	public static void ucitajPodatke() throws IOException, ParseException {

		Aparat.ucitaj("./src/Files/aparati.txt");
		Sastojak.ucitaj("./src/Files/sastojci.txt");
		KolicinaSastojka.ucitaj("./src/Files/kolicineSastojaka.txt", Sastojak.getSastojci());
		Kategorija.ucitaj("./src/Files/kategorije.txt");
		Korisnik.ucitajKorisnike("./src/Files/korisnici.txt", Recept.getListaRecepata(),
				KolicinaSastojka.getKolicineSastojaka(), Aparat.getAparati());
		Komentar.ucitaj("./src/Files/komentari.txt", Korisnik.getKorisnici());
		Recept.ucitaj("./src/Files/recepti.txt", Korisnik.getKorisnici(), KolicinaSastojka.getKolicineSastojaka(),
				Aparat.getAparati(), Kategorija.getKategorije(), Komentar.getKomentari());

		ArrayList<Integer> idRec = null;
		for (Korisnik kor : Korisnik.getKorisnici()) {
			if (Korisnik.getIdRecepata().containsKey(kor.getUsername())) {
				idRec = Korisnik.getIdRecepata().get(kor.getUsername());
				for (Integer id : idRec) {
					Recept rec = null;
					rec = Korisnik.pronadjiRecept(Recept.getListaRecepata(), id.intValue());
					kor.getRecepti().add(rec);
				}
			}

		}

	}

	public static void upisiPodatke() throws IOException, ParseException {

		Korisnik.upisiKorisnikeNew("./src/Files/korisnici.txt");
		Aparat.upisiAparate("./src/Files/aparati.txt");
		Komentar.upisiKomentare("./src/Files/komentari.txt");
		Kategorija.upisiKategorije("./src/Files/kategorije.txt");
		Sastojak.upisiSastojke("./src/Files/sastojci.txt");
		KolicinaSastojka.upisiKolicinuSastojaka("./src/Files/kolicineSastojaka.txt");
		Recept.upisiRecepte("./src/Files/recepti.txt");
	}

	public static void main(String[] args) throws IOException, ParseException {

		ucitajPodatke();

		for (Korisnik k : Korisnik.getKorisnici()) {
			System.out.println(k);
		}

		Aplikacija app = new Aplikacija(Sastojak.getSastojci(), Recept.getListaRecepata(), Kategorija.getKategorije(),
				Aparat.getAparati(), Korisnik.getKorisnici());

		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);

	}

}
