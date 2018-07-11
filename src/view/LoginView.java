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

import model.LoginModel;

public class LoginView extends JPanel {
	private LoginModel model;
	private JTextField username, password;
	private JButton potvrdi, odustani;
	private JLabel greskaLabela;

	public LoginView(LoginModel model) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Controller control = new Controller();

		this.add(Box.createRigidArea(new Dimension(0, 50)));

		JPanel panelNoviUsername = new JPanel();
		panelNoviUsername.setLayout(new BoxLayout(panelNoviUsername, BoxLayout.X_AXIS));

		JLabel usernameL = new JLabel("Korisnicko ime: ");
		panelNoviUsername.add(usernameL);
		panelNoviUsername.add(Box.createRigidArea(new Dimension(30, 0)));

		username = new JTextField();
		username.setPreferredSize(new Dimension(400, 20));
		username.setMaximumSize(new Dimension(400, 20));
		panelNoviUsername.add(username);
		this.add(panelNoviUsername);

		this.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelNoviPassword = new JPanel();
		panelNoviPassword.setLayout(new BoxLayout(panelNoviPassword, BoxLayout.X_AXIS));

		JLabel passwordL = new JLabel("Korisnicko ime: ");
		panelNoviPassword.add(passwordL);
		panelNoviPassword.add(Box.createRigidArea(new Dimension(30, 0)));

		password = new JTextField();
		password.setPreferredSize(new Dimension(400, 20));
		password.setMaximumSize(new Dimension(400, 20));
		panelNoviPassword.add(username);
		this.add(panelNoviPassword);

		this.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelDugmici = new JPanel();
		panelDugmici.setLayout(new BoxLayout(panelDugmici, BoxLayout.X_AXIS));
		potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(control);
		panelDugmici.add(potvrdi);
		panelDugmici.add(Box.createRigidArea(new Dimension(20, 0)));
		odustani = new JButton("Odustani");
		odustani.addActionListener(control);
		panelDugmici.add(odustani);
		this.add(panelDugmici);

	}

	private class Controller implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == potvrdi) {
				boolean rez = model.proveriLogin(username.getText(), password.getText());
				if (!rez) {
					greskaLabela.setText("Neuspesna prijava");
				}
			} else if (e.getSource() == odustani) {
				System.out.println("odustani");
			}

		}

	}

}
