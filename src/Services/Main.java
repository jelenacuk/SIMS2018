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
		
		
		aparati.ucitaj("./src/aparati.txt");
		sastojci.ucitaj("./src/sastojci.txt");
		kolicineSastojaka.ucitaj("./src/kolicineSastojaka.txt", sastojci.getSastojci());
		kategorije.ucitaj("./src/kategorije.txt");
		korisnici.ucitajKorisnike("./src/korisnici.txt", recepti.getListaRecepata(),kolicineSastojaka.getKolicineSastojaka() , aparati.getAparati());
		komentari.ucitaj("./src/komentari.txt", korisnici.getKorisnici());
		recepti.ucitaj("./src/recepti.txt", korisnici.getKorisnici(), kolicineSastojaka.getKolicineSastojaka(), aparati.getAparati(), kategorije.getKategorije(), komentari.getKomentari());
		korisnici.ucitajKorisnike("./src/korisnici.txt", recepti.getListaRecepata(),kolicineSastojaka.getKolicineSastojaka() , aparati.getAparati());
		
		
		for (String k : korisnici.getKorisnici().keySet()) {
			System.out.println(korisnici.getKorisnici().get(k));
		}
		
	}
	

}
