package com.GTteam1.shop_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GTteam1.shop_backend.dto.AddToCartRequest;
import com.GTteam1.shop_backend.dto.AddToCartResponse;
import com.GTteam1.shop_backend.dto.CartResponse;
import com.GTteam1.shop_backend.dto.RemoveFromCartRequest;
import com.GTteam1.shop_backend.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public CartResponse getCart() {
        return cartService.getCart();
    }

    @PostMapping("/add")
    public ResponseEntity<AddToCartResponse> addToCart(@RequestBody AddToCartRequest request) {
        AddToCartResponse response = cartService.addToCart(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/remove")
    public ResponseEntity<AddToCartResponse> removeFromCart(@RequestBody RemoveFromCartRequest request) {
        AddToCartResponse response = cartService.removeFromCart(request);
        return ResponseEntity.ok(response);
    }
}

