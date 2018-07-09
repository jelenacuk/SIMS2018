package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import Services.MyGridBagConstraints;
import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Sastojak;
import model.FrontPageModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Scrollbar;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;import java.io.File;
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
	
	//pretraga i filteri
	JButton btSearch;
	JTextField textSearch;
	JPanel kategorijePanel;
	JPanel upper;
	JPanel left,sastojciPanel,aparatiPanel;
	JPanel center,noviReceptiPanel,popularniReceptiPanel;
	HashMap<Sastojak, JCheckBox> sastojciDugmad;  // veza izmedju sastojaka i dugmadi, kako bi znali koji su sastojci selektovani
	public FrontPageView(FrontPageModel model)
	{
		setLayout(new GridBagLayout());
		upper = new JPanel();
		left = new JPanel();
		noviReceptiPanel = new JPanel();
		noviReceptiPanel.setSize(300, 200);
		popularniReceptiPanel = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
		sastojciPanel = new JPanel();
		sastojciPanel.setSize(200, 200);
		sastojciPanel.setLayout(new BoxLayout(sastojciPanel, BoxLayout.Y_AXIS));
		sastojciPanel.add(new JLabel("Sastojci:"));
		aparatiPanel = new JPanel();
		aparatiPanel.setLayout(new BoxLayout(aparatiPanel, BoxLayout.Y_AXIS));
		aparatiPanel.add(new JLabel("aparati"));
		
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
		
		JScrollPane scrollSastojci = new JScrollPane(sastojciPanel);
		scrollSastojci.setPreferredSize(new Dimension(200, 150));
		this.model = model;
		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {	
			JCheckBox check = new JCheckBox(sastojak.getNaziv());
			sastojciPanel.add(check);
		}
		for (Aparat aparat : Aplikacija.aplikacija.getAparati()) {	
			JCheckBox check = new JCheckBox(aparat.getNaziv());
			aparatiPanel.add(check);
		}
		BufferedImage image;

		//image = ImageIO.read(new File("./src/download.jpg"));
		//btTest = new JButton(new ImageIcon(image));
		 JButton btTest = new JButton("recept 1");
		JButton btTest2 = new JButton("Primer recepta2");
		JButton btTest3 = new JButton("Primer recepta3");
		JButton btTest4 = new JButton("recept 4");
		JButton btTest5 = new JButton("Primer recepta5");
		JButton btTest6 = new JButton("Primer recepta6");
		noviReceptiPanel.add(btTest);
		noviReceptiPanel.add(btTest2);
		noviReceptiPanel.add(btTest3);
		popularniReceptiPanel.add(btTest4);
		popularniReceptiPanel.add(btTest5);
		popularniReceptiPanel.add(btTest6);

		center.add(noviReceptiPanel);
		center.add(popularniReceptiPanel);
		
		

		btSearch = new JButton("search");
		

		SearchListen searchListen = new SearchListen();
		btSearch.addActionListener(searchListen);
		textSearch = new JTextField("Unesite naziv recepta", 20);
		upper.add(Box.createHorizontalGlue());
		upper.add(textSearch);
		upper.add(btSearch);
		
		//Dugmad za registraciju i klase koje reaguju na pritisak dugmeta
		btLogIn = new JButton("Log In");
		LogInListener logInListen = new LogInListener();
		btLogIn.addActionListener(logInListen);
		LogOutListener logOutListen = new LogOutListener();
		btLogOut = new JButton("Log Out");
		btLogOut.addActionListener(logOutListen);
		btRegister = new JButton("Register");
		RegisterListener regListen = new RegisterListener();
		btRegister.addActionListener(regListen);
		if(Aplikacija.aplikacija.getTrenutniKorisnik() == null)
		{
			upper.add(btLogIn);
			upper.add(btRegister);
		}
		else
		{
			upper.add(btLogOut);
		}
		left.add(scrollSastojci);
		left.add(aparatiPanel);
		add(upper,new MyGridBagConstraints(1, 0, 9, 1));
		add(left,new MyGridBagConstraints(0, 1, 2, 9));
		add(center,new MyGridBagConstraints(3, 2, 3, 2));
		setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	private class LogInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("log in");
			
		}
		
	}
	private class LogOutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("log Out");
		}
		
	}
	private class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("reg");
			
		}
		
	}
	private class SearchListen implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("reg");
			
		}
		
	}
}
