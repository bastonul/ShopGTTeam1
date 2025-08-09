package com.GTteam1.shop_backend.dto;

import java.util.List;
import com.GTteam1.shop_backend.entity.CartReward;

public class CheckoutResponse {
	
    private boolean success;
    private String message;
    private int newBalance;
    private List<CartReward> purchasedItems;
    private String transactionId;

    public CheckoutResponse(boolean success, String message, int newBalance, List<CartReward> purchasedItems, String transactionId) {
        this.success = success;
        this.message = message;
        this.newBalance = newBalance;
        this.purchasedItems = purchasedItems;
        this.transactionId = transactionId;
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

	public List<CartReward> getPurchasedItems() {
		return purchasedItems;
	}

	public void setPurchasedItems(List<CartReward> purchasedItems) {
		this.purchasedItems = purchasedItems;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

    
}