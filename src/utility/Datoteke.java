package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Datoteke {

	public static boolean proveraDatoteke(String imeDatoteke) {
		File f = new File(imeDatoteke);
		if (!f.exists()) {
			try {
				f.createNewFile();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	// ucitavanje u array listu
	public static ArrayList<String> listaLinija(String imeDatoteke) {
		ArrayList<String> linije = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(imeDatoteke));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String linija;
		try {
			while ((linija = br.readLine()) != null) {
				linije.add(linija);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linije;
	}

	// upis u fajl
	public static boolean upisUDatoteku(ArrayList<String> linije, String imeDatoteke) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(imeDatoteke));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String l : linije) {
			pw.println(l);
		}
		pw.close();
		return false;
	}

}
