package com.GTteam1.shop_backend.dto;

import java.time.LocalDateTime;

public class PurchaseHistoryReward {
		
	private String id;
    private String rewardName;
    private int pointsSpent;
    private LocalDateTime purchaseDate;
    private String status;
    private String awbNumber;
    
    
	public PurchaseHistoryReward(String id, String rewardName, int pointsSpent, LocalDateTime purchaseDate,
			String status, String awbNumber) {
		super();
		this.id = id;
		this.rewardName = rewardName;
		this.pointsSpent = pointsSpent;
		this.purchaseDate = purchaseDate;
		this.status = status;
		this.awbNumber = awbNumber;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRewardName() {
		return rewardName;
	}


	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}


	public int getPointsSpent() {
		return pointsSpent;
	}


	public void setPointsSpent(int pointsSpent) {
		this.pointsSpent = pointsSpent;
	}


	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAwbNumber() {
		return awbNumber;
	}


	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
    
    
}
