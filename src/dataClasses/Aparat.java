package dataClasses;

public class Aparat {

	private int idAparata;
	private String naziv;
	private String opis;

	// test
	public Aparat() {
	}

	public Aparat(int id, String naziv, String opis) {

		super();
		this.idAparata = id;
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
		if (obj instanceof Aparat) {
			Aparat a = (Aparat) obj;
			if (a.getIdAparata() == this.getIdAparata() && a.getNaziv() == this.getNaziv()
					&& a.getOpis() == this.getOpis()) {
				return true;
			}
		}
		return false;
	}

	public int getIdAparata() {
		return idAparata;
	}

	public void setIdAparata(int idAparata) {
		this.idAparata = idAparata;
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
