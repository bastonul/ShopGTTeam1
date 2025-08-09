package com.GTteam1.shop_backend.dto;

public class RemoveFromCartRequest {
	
	private String rewardId;
	int quantity;
	
    public RemoveFromCartRequest() {}

    public RemoveFromCartRequest(String rewardId, int quantity) {
        this.rewardId = rewardId;
        this.quantity = quantity;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
