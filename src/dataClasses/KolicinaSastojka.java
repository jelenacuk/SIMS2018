package dataClasses;


public class KolicinaSastojka {
	
	private int idKolicineSastojaka;
	private String kolicina;
	private Sastojak sastojak;
	
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

	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof KolicinaSastojka)
		{
			KolicinaSastojka ks = (KolicinaSastojka) obj;
			if (ks.getSastojak() == this.getSastojak() && ks.getKolicina() == this.getKolicina())
			{
				return true;
			}
		}
		return false;
	}
}
