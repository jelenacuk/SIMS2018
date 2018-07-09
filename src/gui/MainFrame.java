package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import model.FrontPageModel;
import view.FrontPageView;


public class MainFrame extends JFrame{
	private static MainFrame instance = null;
	private FrontPageModel model = new FrontPageModel();
	
	public MainFrame(){
	}
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initGUI();
		}
		return instance;
	}
public void initGUI(){
		setTitle("Dine");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrontPageView view = new FrontPageView(model);
		add(view);
		pack();
	}
}
