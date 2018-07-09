package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import dataClasses.Aplikacija;
import dataClasses.Sastojak;
import model.FrontPageModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	JPanel sastojciPanel;
	JPanel aparatiPanel;
	JPanel kategorijePanel;
	JPanel upper;
	JPanel left;
	JPanel center;
	HashMap<Sastojak, JCheckBox> sastojciDugmad;  // veza izmedju sastojaka i dugmadi, kako bi znali koji su sastojci selektovani
	public FrontPageView(FrontPageModel model)
	{
		setLayout(new BorderLayout());
		upper = new JPanel();
		upper.setSize(800, 60);
		left = new JPanel();
		left.setSize(200,100);
		left.setLayout(new GridLayout(0, 3));
		center = new JPanel(new GridLayout(3, 5));
		center.setSize(500,500);
		
		add(upper,BorderLayout.NORTH);
		add(left,BorderLayout.WEST);
		add(center,BorderLayout.CENTER);
		sastojciPanel = new JPanel();
		this.model = model;
		int i = 0,j= 0;
		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {
			
			JCheckBox check = new JCheckBox(sastojak.getNaziv());
			left.add(check,i,j);
			if(j++>3)
			{
				j = 0;
				i++;
			}
		}
		BufferedImage image;
		JButton btTest;

			//image = ImageIO.read(new File("./src/download.jpg"));
			//btTest = new JButton(new ImageIcon(image));
			btTest = new JButton("recept 1");
			btTest.setSize(120,120);

			btTest.setBorderPainted(false);
			center.add(btTest,0,0);

		JButton btTest2 = new JButton("Primer recepta2");
		JButton btTest3 = new JButton("Primer recepta3");

		btTest2.setBackground(Color.BLUE);
		btTest3.setBackground(Color.CYAN);

		btSearch = new JButton("search");
		center.add(btTest2,0,1);
		center.add(btTest3,0,2);

		SearchListen searchListen = new SearchListen();
		btSearch.addActionListener(searchListen);
		textSearch = new JTextField("Unesite naziv recepta", 20);
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
			upper.add(btLogIn,BorderLayout.NORTH);
			upper.add(btRegister,BorderLayout.NORTH);
		}
		else
		{
			upper.add(btLogOut,BorderLayout.NORTH);
		}
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
