package dataClassesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Sastojak;

class SastojciTest {

	static int brojac;

	@Test
	void ucitaj() throws IOException {
		ArrayList<Sastojak> sastojci = Sastojak.ucitaj("./test/TestFiles/SastojciTest.txt");
		prebroj("./test/TestFiles/SastojciTest.txt");
		assertEquals(brojac, sastojci.size());
		//provera atributa
		assertEquals(0, Sastojak.getSastojci().get(0).getIdSastojka());
		assertEquals(1, Sastojak.getSastojci().get(1).getIdSastojka());
		assertEquals(2, Sastojak.getSastojci().get(2).getIdSastojka());
		
		assertEquals("Luk", Sastojak.getSastojci().get(0).getNaziv());
		assertEquals("Krastavci", Sastojak.getSastojci().get(1).getNaziv());
		assertEquals("Pavlaka", Sastojak.getSastojci().get(2).getNaziv());
		
		
	}
	
	@Test
	public void upisi() throws IOException {
		
		Aplikacija app = new Aplikacija();
		Sastojak.ucitaj("./test/TestFiles/SastojciTest.txt");
		app.setSastojci(Sastojak.getSastojci());
		
		Sastojak.upisiSastojke("./test/TestFiles/SastojciTest.txt");
		prebroj("./test/TestFiles/SastojciTest.txt");
		assertEquals(brojac, Aplikacija.aplikacija.getSastojci().size());
	}
	
	
	public void prebroj(String fajl) throws IOException{
		brojac = 0;
		BufferedReader bf = new BufferedReader(new FileReader(fajl));
		while ((bf.readLine()) != null) {
			brojac++;
		}
		bf.close();
	} 

}
