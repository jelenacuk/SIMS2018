package dataClasses;

public class Aparat {
	private String naziv;
	private String opis;
	public Aparat(String naziv, String opis) {
		super();
		this.naziv = naziv;
		this.opis = opis;
	}
	public Aparat() {
		super();
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
	
}
