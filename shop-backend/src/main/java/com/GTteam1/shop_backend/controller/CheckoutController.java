package com.GTteam1.shop_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GTteam1.shop_backend.service.CartService;
import com.GTteam1.shop_backend.dto.AddToCartResponse;
import com.GTteam1.shop_backend.dto.CheckoutResponse;

@RestController
@RequestMapping("/api")
public class CheckoutController {

    private final CartService cartService;

    public CheckoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutResponse> checkout() {
        return ResponseEntity.ok(cartService.checkout());
    }

}
//platypus
