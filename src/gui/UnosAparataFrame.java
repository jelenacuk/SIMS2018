package gui;

import javax.swing.JFrame;

import model.UnosReceptaModel;
import view.UnosAparataView;
import view.UnosRecepataView;

public class UnosAparataFrame  extends JFrame {
	
	public UnosAparataFrame(UnosReceptaModel unosRModel) {
		
		UnosAparataView unosAparataView = new UnosAparataView(unosRModel, this);
		this.add(unosAparataView);
		setTitle("Dodaj novi aparat");
		this.setSize(400, 400);
		this.setVisible(true);
		
	}

}
