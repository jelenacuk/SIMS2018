package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataClasses.Aplikacija;

public class IzmenaProfilaView extends JPanel {
	
	private JTextField novaSifra, novoIme, novoPrezime;
	private JButton izmeni, odustani;
	
	public IzmenaProfilaView() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Controller control = new Controller();
		
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		
		JPanel panelNovoIme = new JPanel();
		panelNovoIme.setLayout(new BoxLayout(panelNovoIme, BoxLayout.X_AXIS));
		JLabel imeL = new JLabel("Promeni  ime: ");
		panelNovoIme.add(imeL);
		panelNovoIme.add(Box.createRigidArea(new Dimension(30, 0)));
		novoIme = new JTextField();
		novoIme.setPreferredSize(new Dimension(400, 20));
		novoIme.setMaximumSize(new Dimension(400, 20));
		panelNovoIme.add(novoIme);
		this.add(panelNovoIme);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JPanel panelNovoPrezime = new JPanel();
		panelNovoPrezime.setLayout(new BoxLayout(panelNovoPrezime, BoxLayout.X_AXIS));
		JLabel prezimeL = new JLabel("Promeni prezime:");
		panelNovoPrezime.add(prezimeL);
		panelNovoPrezime.add(Box.createRigidArea(new Dimension(30, 0)));
		novoPrezime = new JTextField();
		novoPrezime.setPreferredSize(new Dimension(400, 20));
		novoPrezime.setMaximumSize(new Dimension(400, 20));
		panelNovoPrezime.add(novoPrezime);
		this.add(panelNovoPrezime);
		
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JPanel panelNovaSifra = new JPanel();
		panelNovaSifra.setLayout(new BoxLayout(panelNovaSifra, BoxLayout.X_AXIS));
		JLabel sifraL = new JLabel("Promeni sifru: ");
		panelNovaSifra.add(sifraL);
		panelNovaSifra.add(Box.createRigidArea(new Dimension(30, 0)));
		novaSifra = new JTextField();
		novaSifra.setPreferredSize(new Dimension(400, 20));
		novaSifra.setMaximumSize(new Dimension(400, 20));
		panelNovaSifra.add(novaSifra);
		this.add(panelNovaSifra);
		
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel panelDugmici = new JPanel();
		panelDugmici.setLayout(new BoxLayout(panelDugmici, BoxLayout.X_AXIS));
		izmeni = new JButton("Izmeni");
		izmeni.addActionListener(control);
		panelDugmici.add(izmeni);
		panelDugmici.add(Box.createRigidArea(new Dimension(20, 0)));
		odustani = new JButton("Odustani");
		odustani.addActionListener(control);
		panelDugmici.add(odustani);
		this.add(panelDugmici);
				
		
	}
	
	private class Controller implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent obj) {
			if(obj.getSource() == izmeni) {
				System.out.println("izmeni");
				String novoI = novoIme.getText();
				String novoP = novoPrezime.getText();
				String novaS = novaSifra.getText();
				if ( novoI != "" ) {
					Aplikacija.aplikacija.getTrenutniKorisnik().setIme(novoI);
				}
				if ( novoP != "" ) {
					Aplikacija.aplikacija.getTrenutniKorisnik().setPrezime(novoP);
				}
				if ( novaS != "" ) {
					Aplikacija.aplikacija.getTrenutniKorisnik().setPassword(novaS);
				}
				
			}
			else if (obj.getSource() == odustani) {
				System.out.println("odustani");
			}
			
		}
		
	}
		
}
