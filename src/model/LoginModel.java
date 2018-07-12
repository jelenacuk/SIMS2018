package model;

import java.util.Observable;
import java.util.Observer;

import dataClasses.Aplikacija;
import dataClasses.Korisnik;
import view.FrontPageView;

public class LoginModel extends Observable { 
	private FrontPageView fpveiw;
	public LoginModel(FrontPageView fpveiw) {
		this.fpveiw = fpveiw;
	}

	public boolean proveriLogin(String username, String password) {
		for (Korisnik k : Aplikacija.aplikacija.getKorisnici()) {
			if (k.getUsername().equals(username) && k.getPassword().equals(password)) {
				Aplikacija.aplikacija.setTrenutniKorisnik(k);
				fpveiw.reload();
				return true;
			}
		}
		return false;
	}
}
