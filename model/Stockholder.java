package model;

public class Stockholder 
{
	private String name;
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
	public String[] getShareholding() {
		return shareholding;
	}
	public void setShareholding(String[] shareholding) {
		this.shareholding = shareholding;
	}
	public int[] getQuantity() {
		return quantity;
	}
	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}
	private int balance;
	private String []shareholding;
	private int quantity[];
	
}
