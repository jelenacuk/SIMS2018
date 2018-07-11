package dataClasses;

public class Kategorija {

	private int idKategorije;
	private String naziv;

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

}
