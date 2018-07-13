package dataClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class KolicinaSastojka {
	
	private int idKolicineSastojaka;
	private String kolicina;
	private Sastojak sastojak;
	private static ArrayList<KolicinaSastojka> kolicineSastojaka;

	public KolicinaSastojka(int id, String kolicina, Sastojak sastojak) {
		super();
		this.idKolicineSastojaka = id;
		this.kolicina = kolicina;
		this.sastojak = sastojak;
	}
	
	
	public KolicinaSastojka(String kolicina, Sastojak sastojak) {
		super();
		this.kolicina = kolicina;
		this.sastojak = sastojak;
	}


	public KolicinaSastojka() {
		super();
	}


	public int getIdKolicineSastojaka() {
		return idKolicineSastojaka;
	}

	public void setIdKolicineSastojaka(int idKolicineSastojaka) {
		this.idKolicineSastojaka = idKolicineSastojaka;
	}

	public String getKolicina() {
		return kolicina;
	}
	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}
	public Sastojak getSastojak() {
		return sastojak;
	}
	public void setSastojak(Sastojak sastojak) {
		this.sastojak = sastojak;
	}
	
	@Override
	public String toString() {
		String line = "Sastojak: " + sastojak.toString() + "Kolicina: " + kolicina + "\n";
		return line;
		
	}
	public static void ucitaj(String nazivFajla, ArrayList<Sastojak> sastojci) throws IOException {
		kolicineSastojaka = new ArrayList<>();
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ((line = bf.readLine()) != null) {
			String[] podaci = line.split("\\|");
			int id = Integer.parseInt(podaci[0]);
			String kolicina = podaci[1];
			Sastojak sastojak = nadjiSastojak(sastojci, Integer.parseInt(podaci[2]));
			KolicinaSastojka ks = new KolicinaSastojka(id, kolicina, sastojak);
			kolicineSastojaka.add(ks);

		}
		bf.close();

	}

	public static void upisiKolicinuSastojaka(String nazivFajla) throws IOException {
		PrintWriter upisiKS = new PrintWriter(new FileWriter(nazivFajla));
		ArrayList<KolicinaSastojka> kolicineSastojaka = new ArrayList<>();
		for (Korisnik korisnik : Aplikacija.aplikacija.getKorisnici()) {
			for (KolicinaSastojka kolicinaSastojka : korisnik.getKolicinaSastojaka()) {
				kolicineSastojaka.add(kolicinaSastojka);
			}
		}
		for (Recept recept : Aplikacija.aplikacija.getRecepti()) {
			for (KolicinaSastojka kolicinaSastojka : recept.getNeophodniSastojci()) {
				kolicineSastojaka.add(kolicinaSastojka);
			}
		}
		for (KolicinaSastojka kS : kolicineSastojaka) {
			String strZaUpis = kS.getIdKolicineSastojaka() + "|" + kS.getKolicina() + "|"
					+ kS.getSastojak().getIdSastojka();

			upisiKS.println(strZaUpis);
		}
		upisiKS.close();
	}

	public static Sastojak nadjiSastojak(ArrayList<Sastojak> sastojci, int id) {
		Sastojak sastojak = null;
		for (int i = 0; i < sastojci.size(); i++) {
			if (sastojci.get(i).getIdSastojka() == id) {
				sastojak = sastojci.get(i);
				break;
			}
		}
		return sastojak;
	}

	public static ArrayList<KolicinaSastojka> getKolicineSastojaka() {
		return kolicineSastojaka;
	}

	public static void setKolicineSastojaka(ArrayList<KolicinaSastojka> kolSastojaka) {
		kolicineSastojaka = kolSastojaka;
	}
}
