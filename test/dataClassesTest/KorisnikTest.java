package dataClassesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataClasses.Aparat;
import dataClasses.Korisnik;
import dataClasses.Recept;

public class KorisnikTest {
	static ArrayList<Korisnik> korisnici;
	static Korisnik k;
	static ArrayList<Recept> recepti;
	static Recept r;
	static ArrayList<Aparat> aparati;
	static Aparat a;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		korisnici = new ArrayList<>();
		k = new Korisnik();
		recepti = new ArrayList<>();
		r = new Recept();
		r.setIdRecepta(1);
		recepti.add(r);
		aparati = new ArrayList<>();
		a = new Aparat();
		a.setIdAparata(2);
		aparati.add(a);
	}

	@Test
	void pronadjiReceptTest() {
		Recept pronadjenRecept = Korisnik.pronadjiRecept(recepti, 1);
		assertTrue(r == pronadjenRecept);
	}

	@Test
	void pronadjiAparatTest() {
		Aparat pronadjenAparat = Korisnik.pronadjiAparat(aparati, "2");
		assertTrue(a == pronadjenAparat);
	}
}
