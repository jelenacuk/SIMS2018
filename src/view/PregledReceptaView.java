package view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataClasses.Aparat;
import dataClasses.KolicinaSastojka;
import dataClasses.Recept;

public class PregledReceptaView extends JPanel {
	
	public PregledReceptaView(Recept recept) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		
		JLabel naziv = new JLabel(recept.getNaziv().toUpperCase());
		this.add(naziv);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		
		JLabel nacinPripreme = new JLabel(recept.getOpis());
		nacinPripreme.setPreferredSize(new Dimension(600, 200));
		
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		
		
		JLabel sastojci = new JLabel("Potrebni sastojci:");
		this.add(sastojci);
		JPanel panelSastojci = new JPanel();
		panelSastojci.setLayout(new BoxLayout(panelSastojci, BoxLayout.Y_AXIS));
		for (KolicinaSastojka sastojak : recept.getNeophodniSastojci()) {
			String kolicinaSastojka = sastojak.getKolicina();
			String nazivSastojka = sastojak.getSastojak().getNaziv();
			String sastojakTekst = nazivSastojka + " ," + kolicinaSastojka;
			JLabel stavka = new JLabel(sastojakTekst);
			panelSastojci.add(stavka);
		}
		this.add(panelSastojci);
		
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		
		JLabel aparati = new JLabel("Potrebni aparati:");
		this.add(aparati);
		JPanel panelAparati = new JPanel();
		panelAparati.setLayout(new BoxLayout(panelAparati, BoxLayout.Y_AXIS));
		for (Aparat aparat : recept.getNeophodniAparati()) {
			String nazivAparata = aparat.getNaziv();
			JLabel stavka = new JLabel(nazivAparata);
			panelAparati.add(stavka);
		}
		this.add(panelAparati);
		
		this.setVisible(true);
		
	}

}
