package Services;

import java.io.IOException;
import java.text.ParseException;
import dataClasses.Aplikacija;
import gui.KorisnikFrame;
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
		korisnici.ucitajKorisnike("./src/Files/korisnici.txt", recepti.getListaRecepata(),
				kolicineSastojaka.getKolicineSastojaka(), aparati.getAparati());

	}

	public static void upisiPodatke(AparatServis aparati, SastojakServis sastojci,
			KolicinaSastojkaServis kolicineSastojaka, KategorijaServis kategorije, KomentarServis komentari,
			ReceptServis recepti, KorisnikServis korisnici) throws IOException, ParseException {

		korisnici.upisiKorisnike("./src/Files/korisnici.txt");
		aparati.upisiAparate("./src/Files/aparati.txt");
		komentari.upisiKomentare("./src/Files/komentari.txt");
		kategorije.upisiKategorije("./src/Files/kategorije.txt");
		sastojci.upisiSastojke("./src/Files/sastojci.txt");
		kolicineSastojaka.upisiKolicinuSastojaka("./src/Files/kolicineSastojaka.txt");
		recepti.upisiRecepte("./src/Files/recepti.txt");
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

		for (String k : korisnici.getKorisnici().keySet()) {
			System.out.println(korisnici.getKorisnici().get(k));
		}

		upisiPodatke(aparati, sastojci, kolicineSastojaka, kategorije, komentari, recepti, korisnici);

		Aplikacija app = new Aplikacija();
		SastojakServis sasServ = new SastojakServis();
		try {
			Aplikacija.aplikacija.setSastojci(sasServ.ucitaj("./src/Files/sastojci.txt"));
			Aplikacija.aplikacija.setAparati(aparati.getAparati());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Aplikacija.aplikacija.setTrenutniKorisnik(korisnici.getKorisnici().get("pera"));
		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);
		KorisnikFrame k = new KorisnikFrame();
	}

}
