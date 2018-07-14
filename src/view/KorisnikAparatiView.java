package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Korisnik;
import dataClasses.Sastojak;

public class KorisnikAparatiView extends JPanel {

	private ArrayList<Aparat> aparati;
	private JButton dodaj;

	public KorisnikAparatiView() {
		Controller control = new Controller();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		Korisnik korisnik = Aplikacija.aplikacija.getTrenutniKorisnik();

		if (korisnik.getAparati().size() == 0) {
			//JLabel labela = new JLabel("Nema aparata");
			//add(labela);
		}

		aparati = korisnik.getAparati();

		for (Aparat aparat : aparati) {
			JLabel naziv = new JLabel(aparat.getNaziv());
			add(naziv);
		}

		this.add(Box.createRigidArea(new Dimension(0, 40)));
		for (Aparat aparat : Aplikacija.aplikacija.getAparati()) {
			JPanel aparatPanel = new JPanel();
			JLabel aparatLab = new JLabel(aparat.getNaziv());
			aparatPanel.add(aparatLab);
			add(aparatPanel);
		}
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(control);
		add(dodaj);
		setVisible(true);

	}

	private class Controller implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent obj) {

			if (obj.getSource() == dodaj) {
				System.out.println("Treba nesto da radi");
			}

		}

	}
}
