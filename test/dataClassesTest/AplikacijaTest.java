package dataClassesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataClasses.Aplikacija;
import dataClasses.Korisnik;
import dataClasses.Recept;

class AplikacijaTest {
	static Aplikacija apl;
	static Korisnik k;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		apl  = new Aplikacija();
		k = new Korisnik();
		k.setUsername("test");
		apl.setTrenutniKorisnik(k);
	}

	@Test
	void dodajRecepttest() {
		Recept r = new Recept();
		apl.dodajRecept(r);
		assertTrue(k.getRecepti().get(0) == r);
	}

}
