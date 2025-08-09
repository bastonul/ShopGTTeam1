package com.GTteam1.shop_backend.dto;

public class GiftResponse {
		
	 private boolean success;
	 private String message;
	 private int newBalance;
	 	 
	public GiftResponse(boolean success, String message, int newBalance) {
		super();
		this.success = success;
		this.message = message;
		this.newBalance = newBalance;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(int newBalance) {
		this.newBalance = newBalance;
	}
	     
}
