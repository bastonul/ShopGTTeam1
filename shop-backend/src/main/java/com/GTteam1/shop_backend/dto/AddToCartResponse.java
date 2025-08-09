package com.GTteam1.shop_backend.dto;

public class AddToCartResponse {
	
    	private boolean success;
    	private String message;
    	private CartResponse cart;

    	public AddToCartResponse(boolean success, String message, CartResponse cart) {
    		this.success = success;
    		this.message = message;
    		this.cart = cart;
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

    	public CartResponse getCart() {
    		return cart;
    	}

    	public void setCart(CartResponse cart) {
    		this.cart = cart;
    	}
}

//licurici si unicorni 
