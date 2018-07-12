package gui;

import java.awt.Dimension;
import javax.swing.JFrame;

import Services.Main;
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
		setPreferredSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FrontPageView view = new FrontPageView(model,this);
		setResizable(false);
		add(view);
	}
public void replaceWindow(){
		instance.setVisible(false);
		instance = new MainFrame();
		instance.initGUI();
		instance.setVisible(true);
	}
}
