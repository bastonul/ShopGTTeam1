package com.GTteam1.shop_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reward")

public class Reward {
			
			@Id
			@Column(name = "rewardid")
		    private String id;
		    @Column(name = "name")
		    private String name;
		    @Column(name = "description")
		    private String description;
		    @Column(name = "full_description")
		    private String fullDescription;
		    @Column(name = "price")
		    private double price;
		    @Column(name = "image")
		    private String image;
		    @Column(name = "category")
		    private String category;
		    @Column(name = "in_stock")
		    private boolean inStock;
		    @Column(name = "stock_count")
		    private int stockCount;
			
			public Reward() {}  
						
			public Reward(String id, String name, String description, String fullDescription, double price, String image,
					String category, boolean inStock, int stockCount) {
				super();
				this.id = id;
				this.name = name;
				this.description = description;
				this.fullDescription = fullDescription;
				this.price = price;
				this.image = image;
				this.category = category;
				this.inStock = inStock;
				this.stockCount = stockCount;
			}
			
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getFullDescription() {
				return fullDescription;
			}
			public void setFullDescription(String fullDescription) {
				this.fullDescription = fullDescription;
			}
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
			public String getImage() {
				return image;
			}
			public void setImage(String image) {
				this.image = image;
			}
			public String getCategory() {
				return category;
			}
			public void setCategory(String category) {
				this.category = category;
			}
			public boolean isInStock() {
				return inStock;
			}
			public void setInStock(boolean inStock) {
				this.inStock = inStock;
			}
			public int getStockCount() {
				return stockCount;
			}
			public void setStockCount(int stockCount) {
				this.stockCount = stockCount;
			}	
}
