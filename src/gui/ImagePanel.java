package gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private JButton button;
	private JLabel label;
	public ImagePanel(String fileLocation,String labelText)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		BufferedImage image = new BufferedImage(100, 100, 11);
		try {
			image = ImageIO.read(new File(fileLocation));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		button = new JButton(new ImageIcon(image));
		button.setPreferredSize(new Dimension(100, 100));
		label = new JLabel(labelText);
		add(button);
		add(label);
	}
	
	public ImagePanel(String fileLocation,String labelText,ActionListener actionListener) {
		this(fileLocation,labelText);
		button.addActionListener(actionListener);
	}

	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
