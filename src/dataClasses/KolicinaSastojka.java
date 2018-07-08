package dataClasses;


public class KolicinaSastojka {
	
	private int idKolicineSastojaka;
	private int kolicina;
	private Sastojak sastojak;
	
	public KolicinaSastojka(int id, int kolicina, Sastojak sastojak) {
		super();
		this.idKolicineSastojaka = id;
		this.kolicina = kolicina;
		this.sastojak = sastojak;
	}
	
	
	public int getIdKolicineSastojaka() {
		return idKolicineSastojaka;
	}

	public void setIdKolicineSastojaka(int idKolicineSastojaka) {
		this.idKolicineSastojaka = idKolicineSastojaka;
	}

	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public Sastojak getSastojak() {
		return sastojak;
	}
	public void setSastojak(Sastojak sastojak) {
		this.sastojak = sastojak;
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
