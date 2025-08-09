package com.GTteam1.shop_backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GTteam1.shop_backend.dto.GiftRequest;
import com.GTteam1.shop_backend.dto.GiftResponse;
import com.GTteam1.shop_backend.dto.OrderHistoryResponse;
import com.GTteam1.shop_backend.dto.PurchaseHistoryResponse;
import com.GTteam1.shop_backend.dto.PurchaseHistoryReward;
import com.GTteam1.shop_backend.entity.UserProfile;
import com.GTteam1.shop_backend.repository.OrderHistoryRepository;
import com.GTteam1.shop_backend.service.CartService;
import com.GTteam1.shop_backend.service.UserService;
import com.GTteam1.shop_backend.entity.CartReward;
import com.GTteam1.shop_backend.entity.OrderHistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    
    @GetMapping("/profile")
    public UserProfile getProfile() {
        return userService.getUserProfile("88");
    }
    
    @GetMapping("/history")
    public ResponseEntity<PurchaseHistoryResponse> getHistory() {
        List<OrderHistory> history = orderHistoryRepository.findAll();
        List<PurchaseHistoryReward> purchases = new ArrayList<>();

        for (OrderHistory order : history) {
            try {
                List<CartReward> items = new ObjectMapper().readValue(
                    order.getCartSnapshot(),
                    new TypeReference<List<CartReward>>() {}
                );

                for (CartReward item : items) {
                    boolean isPhysical;
                    try {
                        int id = Integer.parseInt(item.getRewardId());
                        isPhysical = id <= 10;
                    } catch (NumberFormatException e) {
                        isPhysical = false;
                    }

                    String status = isPhysical ? "Confirmat" : "Digital";
                    String awb = isPhysical ? order.getAwbNumber() : null;

                    purchases.add(new PurchaseHistoryReward(order.getId(), item.getName(), (int)(item.getPrice() * item.getQuantity()), order.getDate(), status, awb));
                }
            } catch (Exception e) {}
        }

        return ResponseEntity.ok(new PurchaseHistoryResponse(purchases));
    }
 
    @PostMapping("/gift")
    public ResponseEntity<GiftResponse> giftPoints(@RequestBody GiftRequest request) {
        GiftResponse response = userService.giftPoints(request); 
        return ResponseEntity.ok(response);
    }
}

