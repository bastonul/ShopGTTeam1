package com.GTteam1.shop_backend.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class OrderHistory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime date;
    private int totalPoints;

    @Column
    private String cartSnapshot;

    private String awbNumber;

    public OrderHistory() {}
    
	public OrderHistory(String id, LocalDateTime date, int totalPoints, String cartSnapshot, String awbNumber) {
		this.id = id;
		this.date = date;
		this.totalPoints = totalPoints;
		this.cartSnapshot = cartSnapshot;
		this.awbNumber = awbNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCartSnapshot() {
		return cartSnapshot;
	}

	public void setCartSnapshot(String cartSnapshot) {
		this.cartSnapshot = cartSnapshot;
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	} 
    
}
