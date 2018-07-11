package dataClasses;

public class Sastojak {

	private int idSastojka;
	private String naziv;
	private String opis;

	public Sastojak(int id, String naziv, String opis) {
		super();
		this.idSastojka = id;
		this.naziv = naziv;
		this.opis = opis;
	}

	@Override
	public String toString() {
		String line = "Naziv: " + naziv + ". " + opis + "\n";
		return line;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sastojak) {
			Sastojak s = (Sastojak) obj;
			if (s.getIdSastojka() == this.getIdSastojka() && s.getNaziv() == this.getNaziv()
					&& s.getOpis() == this.getOpis()) {
				return true;
			}
		}
		return false;
	}

	public int getIdSastojka() {
		return idSastojka;
	}

	public void setIdSastojka(int idSastojka) {
		this.idSastojka = idSastojka;
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
