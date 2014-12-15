package com.user.library;

public class User {
	private int ID;
	private String name;
	
	public User() {
		ID = -1;
		name = "Anonymity";
	}
	
	public User(int id, String n) {
		ID = id;
		name = n;
	}
}
