package dataClasses;

import java.util.ArrayList;
import java.util.Date;

public class Recept {
	private int idRecepta;
	private String naziv;
	private String opis;
	private String tekst;
	private int brLajkova;
	private int brDislajkova;
	private Date datumObjave;
	private boolean suspendovan;
	private Kategorija kategorija;
	private Korisnik korisnik;
	private ArrayList<Aparat> neophodniAparati;
	private ArrayList<Aparat> opcioniAparati;
	private ArrayList<KolicinaSastojka> neophodniSastojci;
	private ArrayList<KolicinaSastojka> opcioniSastojci;
	private ArrayList<Komentar> komentari;
	private String slika;
	public Recept() {
		super(); 
		opcioniAparati = new ArrayList<>();
		neophodniAparati = new ArrayList<>();
		komentari = new ArrayList<>();
		neophodniSastojci = new ArrayList<>();
		opcioniSastojci = new ArrayList<>();
		slika = "./src/download.jpg";
		
	}
	public Recept(int idRecepta,String naziv, String opis, String tekst, int brLajkova, int brDislajkova, Date datumObjave,
			boolean suspendovan, Kategorija kategorija, Korisnik korisnik, ArrayList<Aparat> neophodniAparati,
			ArrayList<Aparat> opcioniAparati, ArrayList<KolicinaSastojka> neophodniSastojci,
			ArrayList<KolicinaSastojka> opcioniSastojci, ArrayList<Komentar> komentari) {
		super();
		this.idRecepta = idRecepta;
		this.naziv = naziv;
		this.opis = opis;
		this.tekst = tekst;
		this.brLajkova = brLajkova;
		this.brDislajkova = brDislajkova;
		this.datumObjave = datumObjave;
		this.suspendovan = suspendovan;
		this.kategorija = kategorija;
		this.korisnik = korisnik;
		//System.out.println("Korisnik je: " + this.korisnik.getUsername() );
		this.neophodniAparati = neophodniAparati;
		this.opcioniAparati = opcioniAparati;
		this.neophodniSastojci = neophodniSastojci;
		this.opcioniSastojci = opcioniSastojci;
		this.komentari = komentari;
		slika = "./src/download.jpg";
	}
	
	
	public int getIdRecepta() {
		return idRecepta;
	}
	public void setIdRecepta(int idRecepta) {
		this.idRecepta = idRecepta;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public int getBrLajkova() {
		return brLajkova;
	}
	public void setBrLajkova(int brLajkova) {
		this.brLajkova = brLajkova;
	}
	public int getBrDislajkova() {
		return brDislajkova;
	}
	public void setBrDislajkova(int brDislajkova) {
		this.brDislajkova = brDislajkova;
	}
	public Date getDatumObjave() {
		return datumObjave;
	}
	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}
	public boolean isSuspendovan() {
		return suspendovan;
	}
	public void setSuspendovan(boolean suspendovan) {
		this.suspendovan = suspendovan;
	}
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public ArrayList<Aparat> getNeophodniAparati() {
		return neophodniAparati;
	}
	public void setNeophodniAparati(ArrayList<Aparat> neophodniAparati) {
		this.neophodniAparati = neophodniAparati;
	}
	public ArrayList<Aparat> getOpcioniAparati() {
		return opcioniAparati;
	}
	public void setOpcioniAparati(ArrayList<Aparat> opcioniAparati) {
		this.opcioniAparati = opcioniAparati;
	}
	public ArrayList<KolicinaSastojka> getNeophodniSastojci() {
		return neophodniSastojci;
	}
	public void setNeophodniSastojci(ArrayList<KolicinaSastojka> neophodniSastojci) {
		this.neophodniSastojci = neophodniSastojci;
	}
	public ArrayList<KolicinaSastojka> getOpcioniSastojci() {
		return opcioniSastojci;
	}
	public void setOpcioniSastojci(ArrayList<KolicinaSastojka> opcioniSastojci) {
		this.opcioniSastojci = opcioniSastojci;
	}
	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}
	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	
	
	

}
