package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataClasses.Aplikacija;
import dataClasses.Recept;
import model.FrontPageModel;

public class FrontPageModelTest {
	static ArrayList<Recept> receptiPoVremenuTest;
	static ArrayList<Recept> receptiPoPopularnostiTest;
	static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	static Aplikacija aplikacija;
	static FrontPageModel model;
	static Recept r1;
	static Recept r2;
	static Recept r3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		receptiPoVremenuTest = new ArrayList<>();
		receptiPoPopularnostiTest = new ArrayList<>();
		r1 = new Recept();
		r1.setDatumObjave(sdf.parse("15.07.2018."));
		r1.setBrLajkova(3);
		r1.setIdRecepta(1);
		r2 = new Recept();
		r2.setDatumObjave(sdf.parse("08.07.2018."));
		r2.setBrLajkova(5);
		r2.setIdRecepta(2);
		r3 = new Recept();
		r3.setDatumObjave(sdf.parse("13.07.2018."));
		r3.setBrLajkova(7);
		r3.setIdRecepta(3);
		aplikacija = new Aplikacija();
		model = new FrontPageModel();
		receptiPoVremenuTest.add(r1);
		receptiPoVremenuTest.add(r2);
		receptiPoVremenuTest.add(r3);
		receptiPoPopularnostiTest.add(r1);
		receptiPoPopularnostiTest.add(r2);
		receptiPoPopularnostiTest.add(r3);
	}

	@Test
	void testSortiranjaReceptaPoVremenu() {
		ArrayList<Recept> sortiranPoVremenu = model.sortirajReceptPoVremenu(receptiPoVremenuTest);
		assertTrue(sortiranPoVremenu.get(0) == r1);
		assertTrue(sortiranPoVremenu.get(1) == r3);
		assertTrue(sortiranPoVremenu.get(2) == r2);
	}

	@Test
	void testSortiranjaReceptaPoLajkovima() {
		ArrayList<Recept> sortiranPoPopularnosti = model.sortirajReceptPoPopularnosti(receptiPoPopularnostiTest);
		assertTrue(sortiranPoPopularnosti.get(0) == r3);
		assertTrue(sortiranPoPopularnosti.get(1) == r2);
		assertTrue(sortiranPoPopularnosti.get(2) == r1);
	}
}
