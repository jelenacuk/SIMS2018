package view;

import javax.swing.*;

import Services.MyGridBagConstraints;
import dataClasses.Aparat;
import dataClasses.Aplikacija;
import dataClasses.Sastojak;
import gui.ImagePanel;
import gui.KorisnikFrame;
import gui.MainFrame;
import gui.UnosRecepataFrame;
import model.FrontPageModel;
import model.LoginModel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class FrontPageView extends JPanel implements Observer {
	private FrontPageModel model;
	private FrontPageView FPview;
	JButton btLogIn, btRegister, btLogOut; // Dugmad za prijavu/odjavu i registraciju
	JButton btProfil; // Dugme koje vodi do pregleda profila
	// pretraga po nazivu
	JButton btSearch, btSearchPoFilt;
	JTextField textSearch, textVreme;
	JPanel kategorijePanel;
	JPanel upper; // panel koji sadrzi dugmad za prijavu/odjavu, registraciju, profil i pretragu
	MainFrame mf;
	// paneli sa leve strane ekrana. Filtriranje po sastojcima i aparatima
	// panel left sadrzi dugme za kreiranje novog recepta i panele sastojciPanel i
	// aparatiPanel
	// sastojciPanel sadrzi checkbox-ove sa svaki sastojak.
	// aparatiPanel sarzi checkbox-ove za aparate
	// sastojciPanel i aparatiPanel imaju scrollPanele JScrollPane
	JPanel left, sastojciPanel, aparatiPanel;

	// panel centar sadrzi panele noviReceptiPanel i popularniReceptiPanel
	// panel noviReceptiPanel i popularniReceptiPanel sadrze do 3 recepta koji su
	// prikazani koriscenjem ImagePanel klase
	JPanel center, noviReceptiPanel, popularniReceptiPanel;
	JButton btNoviExpand, btPopExpand; // dugmad sluze za prikaz svih recepata sortiranih po datom kriterijumu
	ImagePanel nov1, nov2, nov3, pop1, pop2, pop3; // paneli kojima su predstavljeni recepti
	ArrayList<JCheckBox> sastojciDugmad, aparatiDugmad;
	HashMap<JCheckBox, Sastojak> mapaDugmeSastojak;
	HashMap<JCheckBox, Aparat> mapaDugmeAparat;
	JButton btDodajRecept;
	JCheckBox checkKorisnikSastojci, checkKorisnikAparati;

	public FrontPageView(FrontPageModel model, MainFrame mf) {
		Controller control = new Controller(); // instanca kontrolera. U kontroleru su implementirane akcije za pritisak
												// na dugmad
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(800, 600));
		this.model = model;
		this.FPview = this;
		this.mf = mf;
		// Kreiranje instanci i podesavanje layout-a
		sastojciDugmad = new ArrayList<>();
		aparatiDugmad = new ArrayList<>();
		mapaDugmeSastojak = new HashMap<>();
		mapaDugmeAparat = new HashMap<>();
		upper = new JPanel();
		left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
		noviReceptiPanel = new JPanel();
		popularniReceptiPanel = new JPanel();
		sastojciPanel = new JPanel();
		sastojciPanel.setLayout(new BoxLayout(sastojciPanel, BoxLayout.PAGE_AXIS));
		sastojciPanel.add(new JLabel("Sastojci:"));
		aparatiPanel = new JPanel();
		aparatiPanel.setLayout(new BoxLayout(aparatiPanel, BoxLayout.PAGE_AXIS));
		aparatiPanel.add(new JLabel("aparati"));

		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));

		// kreira scroll panel za sastojke i aparate i povezuje ih sa odgovarajucim
		// panelima i postavlja im odgovarajucu velicinu
		JScrollPane scrollSastojci = new JScrollPane(sastojciPanel);
		scrollSastojci.setPreferredSize(new Dimension(190, 200));
		JScrollPane scrollAparati = new JScrollPane(aparatiPanel);
		scrollAparati.setPreferredSize(new Dimension(190, 200));

		//Ako je korisnik ulogovan, ponudice mu da filtrira po svojim sastojcima i aparatima
		if (Aplikacija.aplikacija.getTrenutniKorisnik() != null) {
			checkKorisnikSastojci = new JCheckBox("Korisnikovi sastojci");
			sastojciPanel.add(checkKorisnikSastojci);
			checkKorisnikSastojci.addActionListener(control);
			checkKorisnikAparati = new JCheckBox("Korisnikovi aparati");
			aparatiPanel.add(checkKorisnikAparati);
			checkKorisnikAparati.addActionListener(control);
		}
		// Iterira kroz sastojke koji se nalaze u instanci klase Aplikacija i za svaki
				// sastojak kreira checkbox
				// koji dodaje u listu checkbox-ova i povezuje checkbox sa sastojkom koristeci
				// mapu i povezuje kontroler sa checkbox-om
		for (Sastojak sastojak : Aplikacija.aplikacija.getSastojci()) {
			JCheckBox check = new JCheckBox(sastojak.getNaziv());
			sastojciDugmad.add(check);
			sastojciPanel.add(check);
			check.addActionListener(control);
			mapaDugmeSastojak.put(check, sastojak);
		}
		// isto kao i gore, samo za aparate

		for (Aparat aparat : Aplikacija.aplikacija.getAparati()) {
			JCheckBox check = new JCheckBox(aparat.getNaziv());
			aparatiDugmad.add(check);
			aparatiPanel.add(check);
			check.addActionListener(control);
			mapaDugmeAparat.put(check, aparat);
		}
		// Panel koji sadrzi labelu i dugme za prikaz svih najnovijih recepata
		JPanel novirecOpste = new JPanel();
		novirecOpste.add(new JLabel("Najnoviji recepti"));
		btNoviExpand = new JButton("Prikazi sve");
		btNoviExpand.addActionListener(control);
		novirecOpste.add(btNoviExpand);

		// deo koda koji ce biti zamenjen uskoro. kreira dugmad za recepte
		nov1 = new ImagePanel("./src/download.jpg", "Recept1", control);
		nov2 = new ImagePanel("./src/download.jpg", "Recept2", control);
		nov3 = new ImagePanel("./src/download.jpg", "Recept3", control);
		pop1 = new ImagePanel("./src/download.jpg", "Recept4", control);
		pop2 = new ImagePanel("./src/download.jpg", "Recept5", control);
		pop3 = new ImagePanel("./src/download.jpg", "Recept6", control);

		// dodaje dugmad u panel za nove recepte
		noviReceptiPanel.add(nov1);
		noviReceptiPanel.add(nov2);
		noviReceptiPanel.add(nov3);

		// Panel koji sadrzi labelu i dugme za prikaz svih popularnih recepata
		JPanel poprecOpste = new JPanel();
		poprecOpste.add(new JLabel("Najpopularniji recepti"));
		btPopExpand = new JButton("Prikazi sve");
		btPopExpand.addActionListener(control);
		poprecOpste.add(btPopExpand);

		// dodaje dugmad u panel za popularne recepte
		popularniReceptiPanel.add(pop1);
		popularniReceptiPanel.add(pop2);
		popularniReceptiPanel.add(pop3);

		// dodaje panele za nove i popularne recepte u centralni panel
		center.add(novirecOpste);
		center.add(noviReceptiPanel);
		center.add(poprecOpste);
		center.add(popularniReceptiPanel);

		// TextField i dugme za pretragu
		btSearch = new JButton("search");
		btSearch.addActionListener(control);
		textSearch = new JTextField("Unesite naziv recepta", 20);
		upper.add(Box.createHorizontalGlue());
		upper.add(textSearch);
		upper.add(btSearch);
		// Dugmad za registraciju i prijavu/odjavu
		btLogIn = new JButton("Log In");
		btLogIn.addActionListener(control);
		btLogOut = new JButton("Log Out");
		btLogOut.addActionListener(control);
		btRegister = new JButton("Register");
		btRegister.addActionListener(control);

		// Razlike u gui-i ako je korisnik prijavljen ili nije
		if (Aplikacija.aplikacija.getTrenutniKorisnik() == null) {
			upper.add(btLogIn);
			upper.add(btRegister);

		} else {
			btProfil = new JButton("Profil");
			btProfil.addActionListener(control);
			upper.add(btProfil);
			upper.add(btLogOut);
			btDodajRecept = new JButton("Dodaj recept");
			btDodajRecept.addActionListener(control);
			left.add(btDodajRecept);
		}
		textVreme = new JTextField();
		textVreme.setPreferredSize(new Dimension(40, 20));
		JLabel lbVreme = new JLabel("vreme spremanja");
		JPanel vremePanel = new JPanel();
		vremePanel.add(lbVreme);
		vremePanel.add(textVreme);
		btSearchPoFilt = new JButton("Filtriraj");
		btSearchPoFilt.addActionListener(control);
		left.add(scrollSastojci);
		left.add(scrollAparati);
		left.add(vremePanel);
		left.add(btSearchPoFilt);
		add(upper, new MyGridBagConstraints(1, 0, 9, 1));
		add(left, new MyGridBagConstraints(0, 1, 2, 9));
		add(center, new MyGridBagConstraints(3, 2, 3, 2));
		setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Ulogovan");
		repaint();
	}

	public void reload() {
		mf.replaceWindow();
	}

	private class Controller implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent obj) {
			if (obj.getSource() == btLogIn) {
				JFrame loginFrame = new JFrame();
				loginFrame.setSize(500, 400);
				loginFrame.setLocationRelativeTo(null);

				LoginModel loginModel = new LoginModel(FPview);
				LoginView loginView = new LoginView(loginModel, loginFrame);
				loginFrame.add(loginView);
				loginFrame.setVisible(true);
			} else if (obj.getSource() == btDodajRecept) {
				UnosRecepataFrame r = new UnosRecepataFrame();
			} else if (obj.getSource() == btRegister) {
				System.out.println("reg");
			} else if (obj.getSource() == btLogOut) {
				System.out.println("log out");
			} else if (obj.getSource() == btSearch) {
				System.out.println("Search");
				String naziv = textSearch.getText();
				JFrame pretragaPoNazivuFrame = new JFrame("Rezultati pretrage po nazivu");
				PretragaRecepataPoNazivuView pretragaPoNazivuView = new PretragaRecepataPoNazivuView(naziv);
				pretragaPoNazivuFrame.add(pretragaPoNazivuView);
				pretragaPoNazivuFrame.setTitle("Pretraga");
				pretragaPoNazivuFrame.setSize(800, 800);
				pretragaPoNazivuFrame.setVisible(true);
				
			} else if (obj.getSource() == btNoviExpand) {
				System.out.println("Prikazi nove recepte");
			} else if (obj.getSource() == btPopExpand) {
				System.out.println("Prikazi popularne recepte");
			} else if (obj.getSource() == nov1.getButton()) {
				System.out.println("Novi recept1");
			} else if (obj.getSource() == nov2.getButton()) {
				System.out.println("Novi recept2");
			} else if (obj.getSource() == nov3.getButton()) {
				System.out.println("Novi recept3");
			} else if (obj.getSource() == pop1.getButton()) {
				System.out.println("Popularni recept1");
			} else if (obj.getSource() == pop2.getButton()) {
				System.out.println("Popularni recept2");
			} else if (obj.getSource() == pop3.getButton()) {
				System.out.println("Popularni recept3");
			} else if (obj.getSource() == btProfil) {
				new KorisnikFrame();
			} else if (obj.getSource() == checkKorisnikSastojci) {
				System.out.println("cekirani sastojci korisnika");
			} else if (obj.getSource() == checkKorisnikAparati) {
				System.out.println("cekirani aparatai korisnika");
			} else if (obj.getSource() == btSearchPoFilt) {
				System.out.println("Pretraga po filterima");
			} else {
				for (JCheckBox aparatDugme : aparatiDugmad) {
					if (aparatDugme == obj.getSource()) {
						if (aparatDugme.isSelected()) {
							model.addSelektovanAparat(mapaDugmeAparat.get(aparatDugme));
						} else {
							model.removeSelektovanAparat(mapaDugmeAparat.get(aparatDugme));
						}
						break;
					}
				}
				for (JCheckBox sastojakDugme : sastojciDugmad) {
					if (sastojakDugme == obj.getSource()) {
						if (sastojakDugme.isSelected()) {
							model.addSelektovanAparat(mapaDugmeAparat.get(sastojakDugme));
						} else {
							model.removeSelektovanAparat(mapaDugmeAparat.get(sastojakDugme));
						}
						break;
					}
				}

			}
		}

	}

}
