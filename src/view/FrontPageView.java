package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import Services.MyGridBagConstraints;
import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Sastojak;
import gui.ImagePanel;
import gui.KorisnikFrame;
import gui.UnosRecepataFrame;
import model.FrontPageModel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
public class FrontPageView extends JPanel implements Observer{
	private FrontPageModel model;
	//Dugmad za prijavu/odjavu
	JButton btLogIn;
	JButton btRegister;
	JButton btLogOut;
	JButton btProfil;
	//pretraga i filteri
	JButton btSearch;
	JTextField textSearch;
	JPanel kategorijePanel;
	JPanel upper;
	JPanel left,sastojciPanel,aparatiPanel;
	JPanel center,noviReceptiPanel,popularniReceptiPanel;
	JButton btNoviExpand, btPopExpand;
	ImagePanel nov1,nov2,nov3,pop1,pop2,pop3;
	ArrayList<JCheckBox> sastojciDugmad,aparatiDugmad;
	HashMap<JCheckBox, Sastojak> mapaDugmeSastojak;
	HashMap<JCheckBox, Aparat> mapaDugmeAparat;
	JButton btDodajRecept;
	public FrontPageView(FrontPageModel model)
	{
		Controller control = new Controller();
		sastojciDugmad = new ArrayList<>();
		aparatiDugmad = new ArrayList<>();
		mapaDugmeSastojak = new HashMap<>();
		mapaDugmeAparat = new HashMap<>();
		setLayout(new GridBagLayout());
		upper = new JPanel();
		left = new JPanel();
		this.setPreferredSize(new Dimension(800, 600));
		noviReceptiPanel = new JPanel();
		popularniReceptiPanel = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
		sastojciPanel = new JPanel();
		sastojciPanel.setLayout(new BoxLayout(sastojciPanel, BoxLayout.PAGE_AXIS));
		sastojciPanel.add(new JLabel("Sastojci:"));
		aparatiPanel = new JPanel();
		aparatiPanel.setLayout(new BoxLayout(aparatiPanel, BoxLayout.PAGE_AXIS));
		aparatiPanel.add(new JLabel("aparati"));
		
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
		
		JScrollPane scrollSastojci = new JScrollPane(sastojciPanel);
		scrollSastojci.setPreferredSize(new Dimension(180, 200));
		JScrollPane scrollAparati = new JScrollPane(aparatiPanel);
		scrollAparati.setPreferredSize(new Dimension(180, 200));
		this.model = model;
		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {	
			JCheckBox check = new JCheckBox(sastojak.getNaziv());
			sastojciDugmad.add(check);
			sastojciPanel.add(check);
			check.addActionListener(control);
			mapaDugmeSastojak.put(check, sastojak);
		}
		for (Aparat aparat : Aplikacija.aplikacija.getAparati()) {	
			JCheckBox check = new JCheckBox(aparat.getNaziv());
			aparatiDugmad.add(check);
			aparatiPanel.add(check);
			check.addActionListener(control);
			mapaDugmeAparat.put(check, aparat);
		}
		BufferedImage image = new BufferedImage(100, 100, 11);
		try {
			image = ImageIO.read(new File("./src/download.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nov1 = new ImagePanel("./src/download.jpg","Recept1",control);
		nov2 = new ImagePanel("./src/download.jpg","Recept2",control);
		nov3 = new ImagePanel("./src/download.jpg","Recept3",control);
		pop1 = new ImagePanel("./src/download.jpg","Recept4",control);
		pop2 = new ImagePanel("./src/download.jpg","Recept5",control);
		pop3 = new ImagePanel("./src/download.jpg","Recept6",control);
		
		JPanel novirecOpste = new JPanel();
		novirecOpste.add(new JLabel("Najnoviji recepti"));
		btNoviExpand = new JButton("Prikazi sve");
		btNoviExpand.addActionListener(control);
		novirecOpste.add(btNoviExpand);
		
		JPanel poprecOpste = new JPanel();
		poprecOpste.add(new JLabel("Najpopularniji recepti"));
		btPopExpand = new JButton("Prikazi sve");
		btPopExpand.addActionListener(control);
		poprecOpste.add(btPopExpand);
		
		
		noviReceptiPanel.add(nov1);
		noviReceptiPanel.add(nov2);
		noviReceptiPanel.add(nov3);
		popularniReceptiPanel.add(pop1);
		popularniReceptiPanel.add(pop2);
		popularniReceptiPanel.add(pop3);

		center.add(novirecOpste);
		center.add(noviReceptiPanel);
		center.add(poprecOpste);
		center.add(popularniReceptiPanel);
		
		

		btSearch = new JButton("search");
		

		btSearch.addActionListener(control);
		textSearch = new JTextField("Unesite naziv recepta", 20);
		upper.add(Box.createHorizontalGlue());
		upper.add(textSearch);
		upper.add(btSearch);
		
		//Dugmad za registraciju i klase koje reaguju na pritisak dugmeta
		btLogIn = new JButton("Log In");
		btLogIn.addActionListener(control);
		btLogOut = new JButton("Log Out");
		btLogOut.addActionListener(control);
		btRegister = new JButton("Register");
		btRegister.addActionListener(control);
		if(Aplikacija.aplikacija.getTrenutniKorisnik() == null)
		{
			upper.add(btLogIn);
			upper.add(btRegister);
		}
		else
		{
			btProfil = new JButton("Profil");
			btProfil.addActionListener(control);
			upper.add(btProfil);
			upper.add(btLogOut);
		}
		if (Aplikacija.aplikacija.getTrenutniKorisnik() != null)
		{
			btDodajRecept = new JButton("Dodaj recept");
			btDodajRecept.addActionListener(control);
			left.add(btDodajRecept);
			
		}
		left.add(scrollSastojci);
		left.add(scrollAparati);
		add(upper,new MyGridBagConstraints(1, 0, 9, 1));
		add(left,new MyGridBagConstraints(0, 1, 2, 9));
		add(center,new MyGridBagConstraints(3, 2, 3, 2));
		setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	private class Controller implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent obj) {
			if(obj.getSource() == btLogIn)
			{
				System.out.println("log in");
			}
			else if(obj.getSource() == btDodajRecept)
			{
				UnosRecepataFrame r = new UnosRecepataFrame();
			}
			else if(obj.getSource() == btRegister)
			{
				System.out.println("reg");
			}
			else if(obj.getSource() == btLogOut) {
				System.out.println("log out");
			}
			else if(obj.getSource() == btSearch)
			{
				System.out.println("Search");
			}
			else if(obj.getSource() == btNoviExpand)
			{
				System.out.println("Prikazi nove recepte");
			}
			else if(obj.getSource() == btPopExpand)
			{
				System.out.println("Prikazi popularne recepte");
			}
			else if(obj.getSource() == nov1.getButton())
			{
				System.out.println("Novi recept1");
			}
			else if(obj.getSource() == nov2.getButton())
			{
				System.out.println("Novi recept2");
			}
			else if(obj.getSource() == nov3.getButton())
			{
				System.out.println("Novi recept3");
			}
			else if(obj.getSource() == pop1.getButton())
			{
				System.out.println("Popularni recept1");
			}
			else if(obj.getSource() == pop2.getButton())
			{
				System.out.println("Popularni recept2");
			}
			else if(obj.getSource() == pop3.getButton())
			{
				System.out.println("Popularni recept3");
			}
			else if(obj.getSource() == btProfil) {
				new KorisnikFrame();
			}
			else {
				for (JCheckBox aparatDugme : aparatiDugmad) {
					if(aparatDugme == obj.getSource())
					{
						if (aparatDugme.isSelected())
						{
							model.addSelektovanAparat(mapaDugmeAparat.get(aparatDugme));
						}
						else
						{
							model.removeSelektovanAparat(mapaDugmeAparat.get(aparatDugme));
						}
						break;
					}
				}
				for (JCheckBox sastojakDugme : sastojciDugmad) {
					if(sastojakDugme == obj.getSource())
					{
						if (sastojakDugme.isSelected())
						{
							model.addSelektovanAparat(mapaDugmeAparat.get(sastojakDugme));
						}
						else
						{
							model.removeSelektovanAparat(mapaDugmeAparat.get(sastojakDugme));
						}
						break;
					}
				}
				
			}
		}
		
	}
	
}
