package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dataClasses.Aplikacija;
import dataClasses.Recept;
import gui.ImagePanel;

public class PretragaRecepataPoNazivuView extends JPanel {
	
	private ArrayList<Recept> recepti;
	
	public PretragaRecepataPoNazivuView(String naziv) {
		
		
		setSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(600, 600));
		setMaximumSize(new Dimension(600, 600));
		
		
		recepti = new ArrayList<Recept>();
		for (Recept recept : Aplikacija.aplikacija.getRecepti()) {
			if ( recept.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
				recepti.add(recept);
			}
		}
		
		JPanel receptiPanel = new JPanel(new GridLayout(0, 5));
		receptiPanel.setPreferredSize(new Dimension(400, 400));
		receptiPanel.setMaximumSize(new Dimension(400, 400));
		
		JScrollPane scroll = new JScrollPane(receptiPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(500, 500));
		scroll.setMaximumSize(new Dimension(500, 500));
		
		
		if (recepti.size() == 0) {
			JLabel labela = new JLabel("Nema takvih recepata");
			add(labela);
		}
		else {
			for (Recept recept : recepti) {
				ImagePanel panel = new ImagePanel(recept.getSlika(), recept.getNaziv());
				receptiPanel.add(panel);
			}
		}
		this.add(receptiPanel);
		this.setVisible(true);
	}

}
