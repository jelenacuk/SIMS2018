package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dataClasses.Aplikacija;
import dataClasses.Recept;
import gui.ImagePanel;
import gui.PrikazReceptaFrame;
import view.PrikazSvihRecepataView.Controler;

public class PretragaRecepataPoNazivuView extends JPanel {
	
	private ArrayList<Recept> recepti;
	ArrayList<ImagePanel> receptiSlika;
	HashMap<ImagePanel, Recept> mapaSlikaRecept;
	public PretragaRecepataPoNazivuView(String naziv) {
		mapaSlikaRecept = new HashMap<>();
		receptiSlika = new ArrayList<>();
		Controler controller = new Controler();
		
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
				ImagePanel panel = new ImagePanel(recept.getSlika(), recept.getNaziv(),controller);
				receptiSlika.add(panel);
				mapaSlikaRecept.put(panel, recept);
				receptiPanel.add(panel);
			}
		}
		this.add(receptiPanel);
		this.setVisible(true);
	}
	public class Controler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent obj) {
			for (ImagePanel imagePanel : receptiSlika) {
				if(imagePanel.getButton() == obj.getSource()) {
					PrikazReceptaFrame prikaz = new PrikazReceptaFrame();
					PregledReceptaView pregledReceptaView = new PregledReceptaView(mapaSlikaRecept.get(imagePanel));
					prikaz.setSize(new Dimension(600, 400));
					prikaz.setLocationRelativeTo(null);
					prikaz.add(pregledReceptaView);
					prikaz.setVisible(true);
				}
			}
			
		}
		
	}
}
