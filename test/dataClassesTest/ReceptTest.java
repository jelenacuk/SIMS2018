package dataClassesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataClasses.Aparat;
import dataClasses.Korisnik;
import dataClasses.Recept;

class ReceptTest {
	
	static ArrayList<Korisnik> korisnici;
	static Korisnik k1,k2 = new Korisnik();
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		korisnici = new ArrayList<>();
		k1 = new Korisnik();
		k1.setUsername("pera");
		k2 = new Korisnik();
		k2.setUsername("mira");
		korisnici.add(k1);
		korisnici.add(k2);
	}

	@Test
	void PronadjiKorisnikaTest() {
		Korisnik korisnik = Recept.nadjiKorisnika(korisnici, "mira");
		assertTrue(k2 == korisnik);
	}

}
