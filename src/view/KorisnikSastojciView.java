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

import dataClasses.Aplikacija;
import dataClasses.KolicinaSastojka;
import dataClasses.Korisnik;
import dataClasses.Sastojak;

public class KorisnikSastojciView extends JPanel {

	private ArrayList<KolicinaSastojka> sastojci;
	private JButton dodaj;

	public KorisnikSastojciView() {
		Controller control = new Controller();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		Korisnik korisnik = Aplikacija.aplikacija.getTrenutniKorisnik();

		if (korisnik.getKolicinaSastojaka().size() == 0) {
			//JLabel labela = new JLabel("Nema sastojaka");
			//add(labela);
		}

		sastojci = korisnik.getKolicinaSastojaka();

		for (KolicinaSastojka kolicinaSastojka : sastojci) {
			JLabel naziv = new JLabel(kolicinaSastojka.getSastojak().getNaziv());
			JLabel prazanProstor = new JLabel("           ");
			JLabel kolicina = new JLabel(kolicinaSastojka.getKolicina());
			add(naziv);
			add(prazanProstor);
			add(kolicina);
		}

		this.add(Box.createRigidArea(new Dimension(0, 40)));
		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {
			JPanel kolicinaPanel = new JPanel();
			JLabel sastojakLab = new JLabel(sastojak.getNaziv());
			JLabel space = new JLabel("     ");
			JLabel kolicinaLab = new JLabel("2");
			kolicinaPanel.add(sastojakLab);
			kolicinaPanel.add(space);
			kolicinaPanel.add(kolicinaLab);
			add(kolicinaPanel);
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
