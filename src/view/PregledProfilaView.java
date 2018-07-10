package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataClasses.Aplikacija;
import javafx.scene.control.Label;

public class PregledProfilaView extends JPanel {
	JLabel ime,prezime,brLajkova,titula;
	public PregledProfilaView() {
		if (Aplikacija.aplikacija.getTrenutniKorisnik() != null)
		{
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			ime = new JLabel(Aplikacija.aplikacija.getTrenutniKorisnik().getIme());
			prezime = new JLabel(Aplikacija.aplikacija.getTrenutniKorisnik().getPrezime());
			brLajkova = new JLabel(Integer.toString(Aplikacija.aplikacija.getTrenutniKorisnik().getBrojacLajkova()));
			titula = new JLabel(Aplikacija.aplikacija.getTrenutniKorisnik().getTitula().toString());
			
			add(ime);
			add(prezime);
			add(brLajkova);
			add(titula);
			
			setVisible(true);
		}
		
	}
}
