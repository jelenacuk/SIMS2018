package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.KolicinaSastojka;
import dataClasses.Sastojak;
import gui.UnosAparataFrame;
import gui.UnosRecepataFrame;
import model.UnosReceptaModel;



public class UnosRecepataView extends JPanel{
	
	private UnosReceptaModel unosReceptaModel;
	
	private JPanel panelSastojci, panelAparati, panelDugmici;
	private JTextArea tekst;
	JTextField naziv;
	private JButton dodajSastojak, dodajAparat, objavi, odustani;
	private ArrayList<JCheckBox> sastojciDugmad,aparatiDugmad;
	private HashMap<JCheckBox, Sastojak> mapaDugmeSastojak;
	private HashMap<JCheckBox, JTextField> mapaDugmeKolicinaSastojka;
	private HashMap<JCheckBox, Aparat> mapaDugmeAparat;
	private UnosRecepataFrame unosReceptaFrame;
	
	public UnosRecepataView(UnosRecepataFrame unosRFrame) {
		
		Controller control = new Controller();
		unosReceptaModel = new UnosReceptaModel();
		unosReceptaFrame = unosRFrame;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		JLabel nazivRecepta = new JLabel("Naziv Recepta: ");
		this.add(nazivRecepta);
		naziv = new JTextField();
		naziv.setPreferredSize(new Dimension(10, 20));
		naziv.setMaximumSize(new Dimension(1000, 20));
		this.add(naziv);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JLabel nacinPripreme = new JLabel("Nacin pripreme: ");
		this.add(nacinPripreme);
		tekst = new JTextArea();
		//tekst.setPreferredSize(new Dimension(1000, 800));
		//tekst.setMaximumSize(new Dimension(1000, 800));
		this.add(tekst);
		
		
		JScrollPane scrollTekst= new JScrollPane(tekst, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollTekst.setPreferredSize(new Dimension(100, 100));
		scrollTekst.setMaximumSize(new Dimension(1000, 100));
		this.add(scrollTekst);
		this.setVisible(true);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		//IZBOR SASTOJAKA I DUGME ZA DODAVAMJE NOVIH SASTOJAKA
		sastojciDugmad = new ArrayList<JCheckBox>();
		mapaDugmeSastojak = new HashMap<JCheckBox, Sastojak>();
		mapaDugmeKolicinaSastojka = new HashMap<JCheckBox, JTextField>();
		JPanel panelZaSastojkeIDugme = new JPanel();
		panelZaSastojkeIDugme.setLayout(new BoxLayout(panelZaSastojkeIDugme, BoxLayout.X_AXIS));
		
		
		panelSastojci = new JPanel();
		panelSastojci.setLayout(new BoxLayout (panelSastojci,BoxLayout.PAGE_AXIS));
		JLabel izborSastojaka =  new JLabel("Izaberi sastojke: ");
		this.add(izborSastojaka);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		
		JScrollPane scrollSastojci= new JScrollPane(panelSastojci, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSastojci.setPreferredSize(new Dimension(200, 200));
		scrollSastojci.setMaximumSize(new Dimension(200, 200));
		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {	
			JPanel stavka = new JPanel();
			stavka.setLayout(new BoxLayout(stavka, BoxLayout.X_AXIS));
			JCheckBox check = new JCheckBox(sastojak.getNaziv());
			sastojciDugmad.add(check);
			stavka.add(check);
			JTextField kolicina = new JTextField("kolicina");
			stavka.add(kolicina);
			panelSastojci.add(stavka);
			check.addActionListener(control);
			mapaDugmeSastojak.put(check, sastojak);
			mapaDugmeKolicinaSastojka.put(check, kolicina);
			
		}
		panelZaSastojkeIDugme.add(scrollSastojci);
		panelZaSastojkeIDugme.add(Box.createRigidArea(new Dimension(50,0)));
		dodajSastojak = new JButton("Dodaj sastojak");
		dodajSastojak.addActionListener(control);
		panelZaSastojkeIDugme.add(dodajSastojak);
		this.add(panelZaSastojkeIDugme);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		//IZBOR APARATA I DUGME ZA DODAVAMJE NOVIH APARATA
		mapaDugmeAparat = new HashMap<JCheckBox, Aparat>();
		aparatiDugmad = new ArrayList<JCheckBox>();
		JPanel panelZaAparateIDugme = new JPanel();
		panelZaAparateIDugme.setLayout(new BoxLayout(panelZaAparateIDugme, BoxLayout.X_AXIS));
		
		
		panelAparati = new JPanel();
		panelAparati.setLayout(new BoxLayout (panelAparati,BoxLayout.PAGE_AXIS));
		JLabel izborAparata = new JLabel("Izaberi aparate:");
		this.add(izborAparata);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		JScrollPane scrollAparati = new JScrollPane(panelAparati,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAparati.setPreferredSize(new Dimension(200, 200));
		scrollAparati.setMaximumSize(new Dimension(200, 200));
		for (Aparat aparat : Aplikacija.aplikacija.getAparati()) {
			JCheckBox check = new JCheckBox(aparat.getNaziv());
			aparatiDugmad.add(check);
			panelAparati.add(check);
			check.addActionListener(control);
			mapaDugmeAparat.put(check, aparat);
		}
		panelZaAparateIDugme.add(scrollAparati);
		panelZaAparateIDugme.add(Box.createRigidArea(new Dimension(50,0)));
		dodajAparat = new JButton("Dodaj aparat");
		dodajAparat.addActionListener(control);
		panelZaAparateIDugme.add(dodajAparat);
		this.add(panelZaAparateIDugme);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDugmici = new JPanel();
		panelDugmici.setLayout( new BoxLayout( panelDugmici, BoxLayout.X_AXIS));
		objavi = new JButton("Objavi");
		objavi.addActionListener(control);
		panelDugmici.add(objavi);
		panelDugmici.add(Box.createRigidArea(new Dimension(50,0)));
		odustani = new JButton("Odustani");
		odustani.addActionListener(control);
		panelDugmici.add(odustani);
		
		this.add(panelDugmici);
		
		
	}
	
	
	private class Controller implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent obj) {
			if(obj.getSource() == objavi)
			{
				System.out.println("Objavi");
				String nazivR = naziv.getText();
				String tekstR = tekst.getText();
				unosReceptaModel.unos(nazivR, tekstR);
			}
			else if (obj.getSource() == dodajSastojak) {
				
				System.out.println("dodaj sastojak");
				
			}
			else if (obj.getSource() == dodajAparat) {
				
				System.out.println("dodaj aparat");	
				UnosAparataFrame unosAparata = new UnosAparataFrame(unosReceptaModel);
			}
			else if (obj.getSource() == odustani) {
				
				System.out.println("Odustani");
				unosReceptaFrame.setVisible(false);
				
				
			}
			else {
				for (JCheckBox sastojakDugme : sastojciDugmad) {
					if(sastojakDugme == obj.getSource())
					{
						if (sastojakDugme.isSelected())
						{
							///Problem!!
							String koliko = mapaDugmeKolicinaSastojka.get(sastojakDugme).getText();
							KolicinaSastojka kolS = new KolicinaSastojka(1, koliko, mapaDugmeSastojak.get(sastojakDugme));
							unosReceptaModel.addPotrebanSastojak(kolS);
						}
						else
						{
							unosReceptaModel.removePotrebanSastojak(mapaDugmeSastojak.get(sastojakDugme));
						}
						break;
					}
				}
				for (JCheckBox aparatDugme : aparatiDugmad) {
					if(aparatDugme == obj.getSource())
					{
						if (aparatDugme.isSelected())
						{
							unosReceptaModel.addPotrebanAparat(mapaDugmeAparat.get(aparatDugme));
						}
						else
						{
							unosReceptaModel.removePotrebanAparat(mapaDugmeAparat.get(aparatDugme));
						}
						break;
					}
				}
				
			}
			
		}
		
		
	}

}