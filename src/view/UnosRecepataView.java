package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Sastojak;


public class UnosRecepataView extends JPanel{
	
	
	private JLabel nazivRecepata, izborSastojaka, izborRecepata;
	private JPanel panelSastojci, panelAparati, panelDugmici;
	private JTextField tekst;
	private JButton objavi;
	ArrayList<JCheckBox> sastojciDugmad,aparatiDugmad;
	HashMap<JCheckBox, Sastojak> mapaDugmeSastojak;
	HashMap<JCheckBox, Aparat> mapaDugmeAparat;
	
	
	public UnosRecepataView() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		nazivRecepata = new JLabel("Naziv recepta: ");
		this.add(nazivRecepata);
		tekst = new JTextField();
		tekst.setPreferredSize(new Dimension(1000, 500));
		tekst.setMaximumSize(new Dimension(1000, 500));
		this.add(tekst);
		JScrollPane scrollTekst= new JScrollPane(tekst, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollTekst.setPreferredSize(new Dimension(100, 100));
		scrollTekst.setMaximumSize(new Dimension(1000, 100));
		this.add(scrollTekst);
		this.setVisible(true);
		
		sastojciDugmad = new ArrayList<>();
		panelSastojci = new JPanel();
		panelSastojci.setLayout(new BoxLayout (panelSastojci,BoxLayout.PAGE_AXIS));
		mapaDugmeAparat = new HashMap();
		mapaDugmeSastojak = new HashMap();
		objavi = new JButton("Objavi");
		izborSastojaka = new JLabel("Izaberi sastojke: ");
		
		
		this.add(izborSastojaka);

		JScrollPane scrollSastojci= new JScrollPane(panelSastojci, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSastojci.setPreferredSize(new Dimension(200, 250));
		scrollSastojci.setMaximumSize(new Dimension(200, 250));
		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {	
			JCheckBox check = new JCheckBox(sastojak.getNaziv());
			sastojciDugmad.add(check);
			panelSastojci.add(check);
			//check.addActionListener(control);
			mapaDugmeSastojak.put(check, sastojak);
		}
		this.add(scrollSastojci);


		add(objavi);
		//objavi.addActionListener(control);
		
	
		
	}
	
	
	private class Controller implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent obj) {
			if(obj.getSource() == objavi)
			{
				System.out.println("Objavi");
			}
			
		}
		
	}

}