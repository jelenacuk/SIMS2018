package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dataClasses.Aparat;
import dataClasses.Aplikacija;
import gui.UnosAparataFrame;
import model.UnosReceptaModel;

public class UnosAparataView extends JPanel {
	
	private JTextField naziv;
	private JTextArea opis;
	private JButton dodaj, odustani;
	private UnosReceptaModel unosReceptaModel;
	private UnosAparataFrame unosAparataFrame;
	
	public UnosAparataView(UnosReceptaModel unosR, UnosAparataFrame unosApFrame) {
		
		unosReceptaModel = unosR;
		unosAparataFrame = unosApFrame;
		Controller control = new Controller();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		
		JLabel nazivL = new JLabel("Naziv aparata");
		this.add(nazivL);
		naziv  = new JTextField();
		naziv.setPreferredSize( new Dimension(400, 20));
		naziv.setMaximumSize(new Dimension(400, 20));
		this.add(naziv);
		
		
		
		JLabel opisL = new JLabel("Opis: ");
		this.add(opisL);
		opis = new JTextArea();
		
		JScrollPane scrollTekst= new JScrollPane(opis, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollTekst.setPreferredSize(new Dimension(400, 100));
		scrollTekst.setMaximumSize(new Dimension(400, 100));
		this.add(scrollTekst);
		
		
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel panelZaDugmice = new JPanel();
		panelZaDugmice.setLayout(new BoxLayout(panelZaDugmice, BoxLayout.X_AXIS));
		dodaj = new JButton("Dodaj");
		panelZaDugmice.add(dodaj);
		dodaj.addActionListener(control);
		panelZaDugmice.add(Box.createRigidArea(new Dimension(20, 0)));
		odustani = new JButton("Odustani");
		odustani.addActionListener(control);
		panelZaDugmice.add(odustani);
		this.add(panelZaDugmice);
		
		this.setVisible(true);
	}
	
	private class Controller implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent obj) {
			
			if ( obj.getSource() == dodaj) {
				System.out.println("dodaj");
				String nazivA = naziv.getText();
				String opisA = opis.getText();
				Aparat aparat = new Aparat(Aplikacija.aplikacija.getAparati().size(), nazivA, opisA);
				unosReceptaModel.addPotrebanAparat(aparat);
				unosAparataFrame.setVisible(false);
			}
			else if ( obj.getSource() == odustani ) {
				System.out.println("odustani");
				unosAparataFrame.setVisible(false);
			}
		}
		
	}

}
