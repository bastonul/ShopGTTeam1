package com.GTteam1.shop_backend.dto;

public class GiftRequest {
	
	private String nume;
    private int amount;
    
    public GiftRequest() {}
    
	public GiftRequest(String nume, int amount) {
		super();
		this.nume = nume;
		this.amount = amount;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
    
    
}
