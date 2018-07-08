package dataClasses;

public class Kategorija {
	
	private int idKategorije;
	private String naziv;

	public Kategorija(int id, String naziv) {
		super();
		this.idKategorije = id;
		this.naziv = naziv;
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
	
}
