package dataClassesTest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dataClasses.Aplikacija;
import dataClasses.Sastojak;

class SastojciTest {

	static int brojac;
	
	@Test
	void ucitaj() throws IOException {
		ArrayList<Sastojak> sastojci = Sastojak.ucitaj("./test/TestFiles/SastojciTest.txt");
		prebroj("./test/TestFiles/SastojciTest.txt");
		assertEquals(brojac, sastojci.size());
		
	}
	
	@Test
	public void upisi() throws IOException {
		ArrayList<Sastojak> sastojci = Sastojak.ucitaj("./test/TestFiles/SastojciTest.txt");
		Aplikacija app = new Aplikacija();
		app.setSastojci(sastojci);
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
