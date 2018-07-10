package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dataClasses.Aplikacija;
import dataClasses.Korisnik;
import dataClasses.Recept;
import gui.ImagePanel;

public class LajkovaniReceptiView extends JPanel{
	private ArrayList<Recept> recepti;
	public LajkovaniReceptiView() {
		if(Aplikacija.aplikacija.getTrenutniKorisnik() != null)
		{
			setPreferredSize(new Dimension(600, 600));
			setMaximumSize(new Dimension(600, 600));
			Korisnik korisnik = Aplikacija.aplikacija.getTrenutniKorisnik();
			recepti = korisnik.getLajkovaniRecepti();
			JPanel receptiPanel = new JPanel(new GridLayout(0, 5));
			receptiPanel.setPreferredSize(new Dimension(400,400));
			receptiPanel.setMaximumSize(new Dimension(400, 400));
			JScrollPane scroll = new JScrollPane(receptiPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setPreferredSize(new Dimension(500, 500));
			scroll.setMaximumSize(new Dimension(500, 500));
			if (korisnik.getRecepti().size() == 0)
			{
				JLabel labela = new JLabel("Nema objavljenih recepata");
				add(labela);
			}
			else
			{
				int j = 0,k = 0;
				for (Recept recept : recepti) {
					ImagePanel panel = new ImagePanel(recept.getSlika(), recept.getNaziv());
					receptiPanel.add(panel);
					j++;
					if(j>=5)
					{
						j = 0;
						k++;
					}
				}
			}
			add(scroll);
		}
		setVisible(true);
	}
}
