package com.user.library;

public class User {
	protected int ID;
	protected String name;
	
	public User() {
		ID = -1;
		name = "Anonymity";
	}
	
	public User(int id, String n) {
		ID = id;
		name = n;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		ID = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
}
