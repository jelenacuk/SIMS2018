package utility;

import java.util.Comparator;

import dataClasses.Korisnik;
import dataClasses.Recept;

public class Sorter implements Comparator <Object>{
	
	private String kriterijum; // za korisnika je recimo broj lajkova
	private int smer = 1; // 1 rastuce, -1 opadajuce

	public Sorter(String kriterijum, int smer) {
		super();
		this.kriterijum = kriterijum;
		this.smer = smer;
	}

	@Override
	public int compare(Object o1, Object o2) {
		int retVal = 0;
		
		if (o1 != null && o2 != null && o1 instanceof Korisnik && o2 instanceof Korisnik) {
			Korisnik k1 = (Korisnik) o1;
			Korisnik k2 = (Korisnik) o2;
			if (kriterijum.equals("brojLajkova")) {
				retVal = k1.getBrojacLajkova() - k2.getBrojacLajkova();
			}
		}
		else if (o1 != null && o2 != null && o1 instanceof Recept && o2 instanceof Recept) {
			Recept r1 = (Recept) o1;
			Recept r2 = (Recept) o2;
			if (kriterijum.equals("datumObjave")) {
				retVal = r1.getDatumObjave().compareTo(r2.getDatumObjave());
			}
		}
		
		return retVal*smer;
	}
	
	/* ako je neko voljan da koristi ovo, sorter poziva na sledeci nacin:
	   Collections.sort(nekaLista, new Sorter("brojLajkova", 1)); */

}
