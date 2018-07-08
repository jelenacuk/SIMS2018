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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class ReceptServis {
	
	private HashMap<Integer , Recept> recepti;
	public  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	
	public ReceptServis() {
		this.recepti = new HashMap<Integer , Recept>();
	}
	
	public void ucitaj(String nazivFajla,HashMap<String, Korisnik> korisnici,  ArrayList<KolicinaSastojka> sastojci, ArrayList<Aparat> aparati, ArrayList<Kategorija> kategorije,ArrayList<Komentar> komentari ) throws IOException, ParseException {
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ( (line = bf.readLine()) != null ) {
			String[] podaci = line.split("\\|");
			int idRecepta = Integer.parseInt(podaci[0]);
			String naziv =  podaci[1];
			String opis = podaci[2];
			String tekst = podaci[3];
			int brLajkova = Integer.parseInt(podaci[4]);
			int brDislajkova = Integer.parseInt(podaci[5]);
			Date datumObjave = sdf.parse(podaci[6]);
			Boolean suspendovan = Boolean.parseBoolean(podaci[7]);
			Kategorija kategorija = nadjiKategoriju(kategorije, Integer.parseInt(podaci[8]));
			Korisnik korisnik =  nadjiKorisnika(korisnici, podaci[9]);
			ArrayList<Aparat> neophodniAparati = napraviListuAparata(podaci[10], aparati);
			ArrayList<Aparat> opcioniAparati = napraviListuAparata(podaci[11], aparati);
			ArrayList<KolicinaSastojka> neophodniSastojci = napraviListuSastojaka(podaci[12], sastojci);
			ArrayList<KolicinaSastojka> opcioniSastojci = napraviListuSastojaka(podaci[13], sastojci);
			ArrayList<Komentar> komentarii = napraviListuKomentara(podaci[14], komentari);
			
			Recept recept = new Recept( idRecepta,  naziv,  opis,  tekst,  brLajkova, brDislajkova,  datumObjave,
					 suspendovan,  kategorija,  korisnik,  neophodniAparati, opcioniAparati,  neophodniSastojci, opcioniSastojci, komentarii);
			
			
			recepti.put(idRecepta, recept);
				
		}
	}
	
	
	
	public ArrayList<Komentar> napraviListuKomentara(String line, ArrayList<Komentar> listaKomentara){
		ArrayList<Komentar> vrati = new ArrayList<Komentar>();
		String[] komentari = line.split("\\;");
		for (String ko : komentari) {
			if ( ko.equals("")) {
				break;
			}
			vrati.add( nadjiKomentar(listaKomentara, Integer.parseInt(ko)) );
		}
		return vrati;
		
	}
	
	public ArrayList<Aparat> napraviListuAparata(String line, ArrayList<Aparat> listaAparata){
		ArrayList<Aparat> vrati = new ArrayList<Aparat>();
		String[] aparati = line.split("\\;");
		for (String ap : aparati) {
			if ( ap.equals("")) {
				break;
			}
			vrati.add(nadjiSAparat(listaAparata, Integer.parseInt(ap)));
		}
		return vrati;
		
	}
	
	public ArrayList<KolicinaSastojka> napraviListuSastojaka(String line, ArrayList<KolicinaSastojka> listaSastojaka){
		ArrayList<KolicinaSastojka> vrati = new ArrayList<KolicinaSastojka>();
		String[] sastojci = line.split("\\;");
		for (String sa : sastojci) {
			if ( sa.equals("")) {
				break;
			}
			vrati.add(nadjiKolicinuSastojka(listaSastojaka, Integer.parseInt(sa)) );
		}
		return vrati;
		
	}
	
	public Korisnik nadjiKorisnika(HashMap<String, Korisnik> korisnici, String username) {
		Korisnik korisnik = null;
		if (korisnici.containsKey(username)) {
			korisnik = korisnici.get(username);
		}
		return korisnik;
	}
	
	
	public Kategorija nadjiKategoriju(ArrayList<Kategorija> kategorije, int id) {
		Kategorija kategorija = null;
		for (int i = 0; i < kategorije.size(); i++) {
			if ( kategorije.get(i).getIdKategorije() == id ) {
				kategorija = kategorije.get(i);
				break;
			}
		}
		return kategorija;
	}
	
	
	
	
	public KolicinaSastojka nadjiKolicinuSastojka(ArrayList<KolicinaSastojka> sastojci, int id) {
		KolicinaSastojka sastojak = null;
		for (int i = 0; i < sastojci.size(); i++) {
			if ( sastojci.get(i).getIdKolicineSastojaka() == id ) {
				sastojak = sastojci.get(i);
				break;
			}
		}
		return sastojak;
	}
	
	public Aparat nadjiSAparat(ArrayList<Aparat> aparati, int id) {
		Aparat aparat = null;
		for (int i = 0; i < aparati.size(); i++) {
			if ( aparati.get(i).getIdAparata() == id ) {
				aparat = aparati.get(i);
				break;
			}
		}
		return aparat;
	}
	
	public Komentar nadjiKomentar(ArrayList<Komentar> komentari, int id) {
		Komentar komentar = null;
		for (int i = 0; i < komentari.size(); i++) {
			if ( komentari.get(i).getIdKomentara() == id ) {
				komentar = komentari.get(i);
				break;
			}
		}
		return komentar;
	}
	
	

	public HashMap<Integer , Recept> getListaRecepata() {
		return recepti;
	}

	public void setListaRecepata(HashMap<Integer , Recept> listaRecepata) {
		this.recepti = listaRecepata;
	}


}