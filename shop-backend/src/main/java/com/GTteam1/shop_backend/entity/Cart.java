package com.GTteam1.shop_backend.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartReward> items;

    private int totalPoints;

    public Cart() {}

    public Cart(List<CartReward> items, int totalPoints) {
        this.items = items;
        this.totalPoints = totalPoints;
    }

    public Long getId() {
        return id;
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

