package com.GTteam1.shop_backend.dto;

import java.util.List;

import com.GTteam1.shop_backend.entity.CartReward;

public class CartResponse {
	
	
    private List<CartReward> items;
    private int totalPoints;
    
	public CartResponse(List<CartReward> items, int totalPoints) {
		super();
		this.items = items;
		this.totalPoints = totalPoints;
	}
	public List<CartReward> getItems() {
		return items;
	}
	public void setItems(List<CartReward> items) {
		this.items = items;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

    
}
