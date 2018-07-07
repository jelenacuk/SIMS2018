package dataClasses;

import java.util.Date;

public class Komentar {
	private int idKomentara;
	private String tekst;
	private Date datum;
	private Korisnik korisnik;
	public Komentar(int idKomentara,String tekst, Date datum, Korisnik korisnik) {
		super();
		this.idKomentara = idKomentara;
		this.tekst = tekst;
		this.datum = datum;
		this.korisnik = korisnik;
	}
	
	public int getIdKomentara() {
		return idKomentara;
	}

	public void setIdKomentara(int idKomentara) {
		this.idKomentara = idKomentara;
	}

	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
}
