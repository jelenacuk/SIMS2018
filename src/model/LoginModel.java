package model;

import dataClasses.Aplikacija;
import dataClasses.Korisnik;

public class LoginModel {

	public LoginModel() {

	}

	public boolean proveriLogin(String username, String password) {
		for (Korisnik k : Aplikacija.aplikacija.getKorisnici()) {
			if (k.getUsername().equals(username) && k.getPassword().equals(password)) {
				return true;
			}
		}

		return false;
	}
}
