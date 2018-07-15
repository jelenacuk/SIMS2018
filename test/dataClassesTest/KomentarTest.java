package dataClassesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataClasses.Komentar;
import dataClasses.Korisnik;

class KomentarTest {
	static ArrayList<Korisnik> korisnici;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		korisnici = new ArrayList<>();
		Korisnik k = new Korisnik();
		k.setUsername("pera");
		korisnici.add(k);
	}

	@Test
	void ucitajtest() throws IOException, ParseException {
		Komentar.ucitaj("./test/TestFiles/komentariTest.txt", korisnici);
		assertTrue(Komentar.getKomentari().get(0).getKorisnik() == korisnici.get(0));
		assertTrue(Komentar.getKomentari().size() == 1);
	}
	@Test
	void nadjiKorisnikaTest() {
		Korisnik k2 = Komentar.nadjiKorisnika(korisnici, "pera");
		assertTrue(korisnici.get(0) == k2);
	}

}
