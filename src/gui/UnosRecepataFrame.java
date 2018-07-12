package gui;

import javax.swing.JFrame;

import view.UnosRecepataView;

public class UnosRecepataFrame extends JFrame {
	
	UnosRecepataView unosRecepataView;
	
	public UnosRecepataFrame() {
		unosRecepataView = new UnosRecepataView(this);
		this.add(unosRecepataView);
		setTitle("Unos recepta");
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	
}
