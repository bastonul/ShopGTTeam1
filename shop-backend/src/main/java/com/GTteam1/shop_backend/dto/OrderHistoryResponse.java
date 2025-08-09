package com.GTteam1.shop_backend.dto;


import java.time.LocalDateTime;
import java.util.List;

import com.GTteam1.shop_backend.entity.CartReward;

public class OrderHistoryResponse {
	
	private LocalDateTime date;
    private int totalPoints;
    private List<CartReward> items;
    private String awbNumber;

    
    public OrderHistoryResponse(LocalDateTime date, int totalPoints, List<CartReward> items, String awbNumber) {
    	super();
        this.date = date;
        this.totalPoints = totalPoints;
        this.items = items;
        this.awbNumber = awbNumber;
    }


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public int getTotalPoints() {
		return totalPoints;
	}


	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}


	public List<CartReward> getItems() {
		return items;
	}


	public void setItems(List<CartReward> items) {
		this.items = items;
	}


	public String getAwbNumber() {
		return awbNumber;
	}


	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
    
    
}
