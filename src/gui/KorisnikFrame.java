package gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.IzmenaProfilaView;
import view.KorisnikAparatiView;
import view.KorisnikSastojciView;
import view.LajkovaniReceptiView;
import view.PregledProfilaView;
import view.SopstveniReceptiView;

public class KorisnikFrame extends JFrame {

	PregledProfilaView pregledView;
	SopstveniReceptiView sopstveniView;
	LajkovaniReceptiView lajkovaniView;
	IzmenaProfilaView izmenaView;
	KorisnikAparatiView aparatiView;
	KorisnikSastojciView sastojciView;
	JTabbedPane tabovi;

	public KorisnikFrame() {
		tabovi = new JTabbedPane();
		setLocationRelativeTo(null);
		sopstveniView = new SopstveniReceptiView();
		lajkovaniView = new LajkovaniReceptiView();
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
