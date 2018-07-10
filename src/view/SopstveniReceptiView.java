package view;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dataClasses.Aplikacija;
import dataClasses.Korisnik;
import dataClasses.Recept;

public class SopstveniReceptiView extends JPanel {
	private ArrayList<Recept> recepti;
	public SopstveniReceptiView() {
		if(Aplikacija.aplikacija.getTrenutniKorisnik() != null)
		{
			Korisnik korisnik = Aplikacija.aplikacija.getTrenutniKorisnik();
			recepti = korisnik.getRecepti();
			if (korisnik.getRecepti().size() == 0)
			{
				JLabel labela = new JLabel("Nema objavljenih recepata");
				add(labela);
			}
			else
			{
				for (Recept recept : recepti) {
					
				}
			}
		}
	}

}
