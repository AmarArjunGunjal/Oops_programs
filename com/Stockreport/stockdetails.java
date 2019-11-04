package com.Stockreport;

public class stockdetails {
	private String name;
	
	private int balance;
	private int shares;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
