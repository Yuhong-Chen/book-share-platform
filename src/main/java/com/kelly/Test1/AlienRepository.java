package com.kelly.Test1;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	List<Alien> aliens;
	public AlienRepository () {
		aliens = new ArrayList<>();
		
		Alien a1 = new Alien();
		a1.setId(1);
		a1.setUserName("Kelly");
		a1.setUserPwd("123");
		
		Alien a2 = new Alien();
		a2.setId(2);
		a2.setUserName("Kelly");
		a2.setUserPwd("123");
		
		aliens.add(a1);
		aliens.add(a2);
	}
	
	public List<Alien> getAliens() {
		return aliens;
		
	}
	
	public Alien getAlien(int id) {
		for (Alien alien : aliens) {
			if (alien.getId()==id) {
				return alien;
			}
			
		}
		return null;
	}
}
