package dataClassesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import dataClasses.Aparat;
import dataClasses.Aplikacija;

class AparatTest {

	@Test
	public void ucitajTest() throws IOException {
		// Lista komentara se instancira u metodi Ucittaj.

		Aparat.ucitaj("./test/TestFiles/aparatiTest.txt");

		// Posle ucitavanja treba da se nalaze 2 aparata u listi aparati.
		assertEquals(2, Aparat.getAparati().size());

		// Provera atributa ucitanih aparata.
		assertEquals(0, Aparat.getAparati().get(0).getIdAparata());
		assertEquals("Mikser", Aparat.getAparati().get(0).getNaziv());
		assertEquals("Elektricni", Aparat.getAparati().get(0).getOpis());

		assertEquals(1, Aparat.getAparati().get(1).getIdAparata());
		assertEquals("Toster", Aparat.getAparati().get(1).getNaziv());
		assertEquals("Obican", Aparat.getAparati().get(1).getOpis());
	}

	@Test
	public void upisiAparateTest() throws IOException {
		// Mora postojati Aplikacija zbog metode upisivanje.
		Aplikacija app = new Aplikacija();

		Aparat.ucitaj("./test/TestFiles/aparatiTest.txt");
		app.setAparati(Aparat.getAparati());

		// Posle upisivanja u fajl, iz fajla se ucitavaju podaci pomocu buffera
		// i proverava se njihova tacnost.
		Aparat.upisiAparate("./test/TestFiles/upisivanjeAparataTest.txt");
		int brojac = 0;
		BufferedReader bf = new BufferedReader(new FileReader("./test/TestFiles/upisivanjeAparataTest.txt"));
		String line;
		while ((line = bf.readLine()) != null) {
			String[] sL = line.split("\\|");
			if (sL[0].equals("0")) {
				assertEquals("Mikser", sL[1]);
				assertEquals("Elektricni", sL[2]);
			} else if (sL[0].equals("1")) {
				assertEquals("Toster", sL[1]);
				assertEquals("Obican", sL[2]);
			}
			brojac++;
		}
		bf.close();

		assertEquals(Aparat.getAparati().size(), brojac);

	}

}
