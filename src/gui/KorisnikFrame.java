package gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.IzmenaProfilaView;
import view.LajkovaniReceptiView;
import view.PregledProfilaView;
import view.SopstveniReceptiView;

public class KorisnikFrame extends JFrame {
	
	PregledProfilaView pregledView;
	SopstveniReceptiView sopstveniView;
	LajkovaniReceptiView lajkovaniView;
	IzmenaProfilaView izmenaView;
	JTabbedPane tabovi;
	public KorisnikFrame()
	{
		tabovi = new JTabbedPane();
		setLocationRelativeTo(null);
		sopstveniView = new SopstveniReceptiView();
		lajkovaniView = new LajkovaniReceptiView();
		izmenaView = new IzmenaProfilaView();
		pregledView = new PregledProfilaView();
		tabovi.addTab("Pregled", pregledView);
		tabovi.add("Moji recepti", sopstveniView);
		tabovi.add("Lajkovani recepti", lajkovaniView);
		tabovi.add("Izmena profila", izmenaView);
		
		this.add(tabovi);
		setTitle("Pregled profila");
		this.setSize(600, 600);
		this.setVisible(true);
	}
}
