package dataClasses;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.BorderUIResource.TitledBorderUIResource;

public class Korisnik {
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private int brojacLajkova;
	private VrstaKorisnika vrstaKorisnika;
	private TitulaKorisnika titula;
	private ArrayList<Recept> recepti;
	private ArrayList<KolicinaSastojka> kolicinaSastojaka;
	private ArrayList<Recept> lajkovaniRecepti;
	private ArrayList<Recept> dislajkovaniRecepti;
	private ArrayList<Aparat> aparati;

	public Korisnik() {
		super();
		recepti = new ArrayList<Recept>();
		lajkovaniRecepti = new ArrayList<Recept>();
		dislajkovaniRecepti = new ArrayList<Recept>();
		aparati = new ArrayList<Aparat>();
		kolicinaSastojaka = new ArrayList<KolicinaSastojka>();
	}

	
	public Korisnik(String ime, String prezime, String username, String password, int brojacLajkova,
			VrstaKorisnika vrstaKorisnika, TitulaKorisnika titula, ArrayList<Recept> recepti,
			ArrayList<KolicinaSastojka> kolicinaSastojaka, ArrayList<Recept> lajkovaniRecepti,
			ArrayList<Recept> dislajkovaniRecepti, ArrayList<Aparat> aparati) {
		this( username,  password,  brojacLajkova,  vrstaKorisnika, titula, recepti,  kolicinaSastojaka,
				 lajkovaniRecepti,  dislajkovaniRecepti,  aparati);
		this.ime = ime;
		this.prezime = prezime;
	}


	public Korisnik(String username, String password, int brojacLajkova, VrstaKorisnika vrstaKorisnika,
			TitulaKorisnika titula, ArrayList<Recept> recepti, ArrayList<KolicinaSastojka> kolicinaSastojaka,
			ArrayList<Recept> lajkovaniRecepti, ArrayList<Recept> dislajkovaniRecepti, ArrayList<Aparat> aparati) {
		super();
		this.username = username;
		this.password = password;
		this.brojacLajkova = brojacLajkova;
		this.vrstaKorisnika = vrstaKorisnika;
		this.titula = titula;
		this.recepti = recepti;
		this.kolicinaSastojaka = kolicinaSastojaka;
		this.lajkovaniRecepti = lajkovaniRecepti;
		this.dislajkovaniRecepti = dislajkovaniRecepti;
		this.aparati = aparati;
	}

	@Override
	public String toString() {
		String line = "Korisnicko ime: " + username + "\nPassword: " + password + "\n";
		line += "Aparati:\n";

		for (Aparat a : aparati) {
			line += "\t" + a.getNaziv() + "\n";
		}

		line += "Kolicine sastojaka:\n";
		for (KolicinaSastojka s : kolicinaSastojaka) {
			line += "\t" + s.getKolicina() + "\n";
		}
		line += "Recepti:\n";
		for (Recept r : recepti) {
			line += "\t" + r.getNaziv() + "\n";
		}
		line += "Lajkovani recepti:\n";
		for (Recept r : lajkovaniRecepti) {
			line += "\t" + r.getNaziv() + "\n";
		}
		line += "Dislajkovani recepti:\n";
		for (Recept r : dislajkovaniRecepti) {
			line += "\t" + r.getNaziv() + "\n";
		}
		return line;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBrojacLajkova() {
		return brojacLajkova;
	}

	public void setBrojacLajkova(int brojacLajkova) {
		this.brojacLajkova = brojacLajkova;
	}

	public VrstaKorisnika getVrstaKorisnika() {
		return vrstaKorisnika;
	}

	public void setVrstaKorisnika(VrstaKorisnika vrstaKorisnika) {
		this.vrstaKorisnika = vrstaKorisnika;
	}

	public TitulaKorisnika getTitula() {
		return titula;
	}

	public void setTitula(TitulaKorisnika titula) {
		this.titula = titula;
	}

	public ArrayList<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}

	public ArrayList<KolicinaSastojka> getKolicinaSastojaka() {
		return kolicinaSastojaka;
	}

	public void setKolicinaSastojaka(ArrayList<KolicinaSastojka> kolicinaSastojaka) {
		this.kolicinaSastojaka = kolicinaSastojaka;
	}

	public ArrayList<Recept> getLajkovaniRecepti() {
		return lajkovaniRecepti;
	}

	public void setLajkovaniRecepti(ArrayList<Recept> lajkovaniRecepti) {
		this.lajkovaniRecepti = lajkovaniRecepti;
	}

	public ArrayList<Recept> getDislajkovaniRecepti() {
		return dislajkovaniRecepti;
	}

	public void setDislajkovaniRecepti(ArrayList<Recept> dislajkovaniRecepti) {
		this.dislajkovaniRecepti = dislajkovaniRecepti;
	}

	public ArrayList<Aparat> getAparati() {
		return aparati;
	}

	public void setAparati(ArrayList<Aparat> aparati) {
		this.aparati = aparati;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Korisnik) {
			Korisnik kor = (Korisnik) obj;
			if (kor.getUsername().equals(this.username)) {
				return true;
			}
		}
		return false;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	

}
