package gui;

import javax.swing.JFrame;

import model.UnosReceptaModel;
import view.UnosSastojakaView;

public class UnosSastojakaFrame extends JFrame {

	public UnosSastojakaFrame(UnosReceptaModel unosRModel) {
		UnosSastojakaView unosSastojakaView = new UnosSastojakaView(unosRModel, this);
		this.add(unosSastojakaView);
		setTitle("Dodaj novi sastojak");
		this.setSize(400, 400);
		this.setVisible(true);
	}

}
