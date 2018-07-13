package dataClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Kategorija {

	private int idKategorije;
	private String naziv;
	private ArrayList<Recept> receptiKategorije;
	private static ArrayList<Kategorija> kategorije;

	public Kategorija(int id, String naziv) {
		super();
		this.idKategorije = id;
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		String line = naziv + "\n";
		return line;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Kategorija) {
			Kategorija k = (Kategorija) obj;
			if (k.getIdKategorije() == this.getIdKategorije() && k.getNaziv() == this.getNaziv()) {
				return true;
			}
		}
		return false;
	}

	public int getIdKategorije() {
		return idKategorije;
	}

	public void setIdKategorije(int idKategorije) {
		this.idKategorije = idKategorije;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	

	public static void ucitaj(String nazivFajla) throws IOException {
		kategorije = new ArrayList<>();
		BufferedReader bf = new BufferedReader(new FileReader(nazivFajla));
		String line = "";
		while ( (line = bf.readLine()) != null ) {
			String[] podaci = line.split("\\|");
			int id = Integer.parseInt(podaci[0]);
			String naziv = podaci[1];
			Kategorija kategorija = new Kategorija(id,naziv);
			
			kategorije.add(kategorija);
		}
		bf.close();
	}
	
	public static void upisiKategorije(String nazivFajla) throws IOException {
		PrintWriter upisiKategoriju = new PrintWriter(new FileWriter(nazivFajla));
		for(Kategorija kat : Aplikacija.aplikacija.getKategorije()) {
			String strZaUpis = kat.getIdKategorije() + "|" + kat.getNaziv();
			
			upisiKategoriju.println(strZaUpis);
		}
		upisiKategoriju.close();
	}

	public static ArrayList<Kategorija> getKategorije() {
		return kategorije;
	}

	public static void setKategorije(ArrayList<Kategorija> kat) {
		kategorije = kat;
	}
	
	


}
