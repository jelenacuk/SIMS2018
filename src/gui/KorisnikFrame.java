package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import dataClasses.Aplikacija;
import dataClasses.Recept;
import view.IzmenaProfilaView;
import view.KorisnikAparatiView;
import view.KorisnikSastojciView;
import view.PregledProfilaView;
import view.PrikazSvihRecepataView;

public class KorisnikFrame extends JFrame {

	PregledProfilaView pregledView;
	PrikazSvihRecepataView sopstveniView;
	PrikazSvihRecepataView lajkovaniView;
	IzmenaProfilaView izmenaView;
	KorisnikAparatiView aparatiView;
	KorisnikSastojciView sastojciView;
	JTabbedPane tabovi;

	public KorisnikFrame() {
		tabovi = new JTabbedPane();
		setLocationRelativeTo(null);
		ArrayList<Recept> sopstveniRecepti = Aplikacija.aplikacija.getTrenutniKorisnik().getRecepti(); 
		sopstveniView = new PrikazSvihRecepataView(sopstveniRecepti);
		ArrayList<Recept> lajkovaniRecepti = Aplikacija.aplikacija.getTrenutniKorisnik().getLajkovaniRecepti(); 
		lajkovaniView = new PrikazSvihRecepataView(lajkovaniRecepti);
		izmenaView = new IzmenaProfilaView();
		pregledView = new PregledProfilaView();
		aparatiView = new KorisnikAparatiView();
		sastojciView = new KorisnikSastojciView();
		tabovi.addTab("Pregled", pregledView);
		tabovi.add("Moji recepti", sopstveniView);
		tabovi.add("Lajkovani recepti", lajkovaniView);
		tabovi.add("Izmena profila", izmenaView);
		tabovi.add("Moji aparati", aparatiView);
		tabovi.add("Moji sastojci", sastojciView);

		this.add(tabovi);
		setTitle("Pregled profila");
		this.setSize(600, 600);
		this.setVisible(true);
	}
}
