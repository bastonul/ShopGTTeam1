package com.GTteam1.shop_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CartReward {
  
	 @Id
	 private String rewardId; 
	 private String name; 
	 private double price; private
	 int quantity;

	 public CartReward() {} 
  
  public CartReward(String rewardId, String name, double price, int quantity) {
	  
	  	super(); 
	  	this.rewardId = rewardId; 
	  	this.name = name; 
	  	this.price = price;
	  	this.quantity = quantity; 
  }

public String getRewardId() {
	return rewardId;
}

public void setRewardId(String rewardId) {
	this.rewardId = rewardId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
  

  }
 