package Services;

import java.io.IOException;
import java.text.ParseException;

import dataClasses.Aparat;
import dataClasses.KolicinaSastojka;
import dataClasses.Korisnik;


public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		
		AparatServis aparati = new AparatServis();
		SastojakServis sastojci = new SastojakServis();
		KolicinaSastojkaServis kolicineSastojaka = new KolicinaSastojkaServis();
		KategorijaServis kategorije = new KategorijaServis();
		KomentarServis komentari = new KomentarServis();
		ReceptServis recepti = new ReceptServis();
		KorisnikServis korisnici = new KorisnikServis();
		
		
		aparati.ucitaj("./src/Files/aparati.txt");
		sastojci.ucitaj("./src/Files/sastojci.txt");
		kolicineSastojaka.ucitaj("./src/Files/kolicineSastojaka.txt", sastojci.getSastojci());
		kategorije.ucitaj("./src/Files/kategorije.txt");
		korisnici.ucitajKorisnike("./src/Files/korisnici.txt", recepti.getListaRecepata(),kolicineSastojaka.getKolicineSastojaka() , aparati.getAparati());
		komentari.ucitaj("./src/Files/komentari.txt", korisnici.getKorisnici());
		recepti.ucitaj("./src/Files/recepti.txt", korisnici.getKorisnici(), kolicineSastojaka.getKolicineSastojaka(), aparati.getAparati(), kategorije.getKategorije(), komentari.getKomentari());
		korisnici.ucitajKorisnike("./src/Files/korisnici.txt", recepti.getListaRecepata(),kolicineSastojaka.getKolicineSastojaka() , aparati.getAparati());
		
		
		for (String k : korisnici.getKorisnici().keySet()) {
			System.out.println(korisnici.getKorisnici().get(k));
		}
		
	}
	

}
