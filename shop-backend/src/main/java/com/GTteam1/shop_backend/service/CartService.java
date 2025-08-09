package com.GTteam1.shop_backend.service;

import com.GTteam1.shop_backend.dto.*;
import com.GTteam1.shop_backend.entity.*;
import com.GTteam1.shop_backend.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CartService {

    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private ObjectMapper objectMapper;
    private Cart cart = new Cart(new ArrayList<>(), 0);
    
    private void recalcTotalPoints() {
        int total = (int) cart.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
        cart.setTotalPoints(total);
    }
    private CartResponse toResponse() {
        List<CartReward> copiedItems = new ArrayList<>();
        for (CartReward item : cart.getItems()) {
            copiedItems.add(new CartReward(item.getRewardId(), item.getName(), item.getPrice(), item.getQuantity()));
        }
        return new CartResponse(copiedItems, cart.getTotalPoints());
    }

    
    private String generateAWB() {	
    	StringBuilder digits = new StringBuilder();
        Random random = new Random();

        while (digits.length() < 15) {
            digits.append(random.nextInt(10));
        }
        return "AWB" + digits;
    }   
    private String generateTransactionId() {
        return "TXN" + UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
    }    
    public AddToCartResponse addToCart(AddToCartRequest request) {
        Optional<Reward> optionalReward = rewardRepository.findById(request.getRewardId());
        
        if (optionalReward.isEmpty()) {
            return new AddToCartResponse(false, "Reward-ul nu a fost gasit", toResponse());
        }

        Reward reward = optionalReward.get();
 
        CartReward existing = cart.getItems().stream()
            .filter(item -> item.getRewardId().equals(reward.getId()))
            .findFirst()
            .orElse(null);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + request.getQuantity());
        } else {
            cart.getItems().add(new CartReward(
                    reward.getId(), reward.getName(), reward.getPrice(), request.getQuantity()
            ));
        }
        recalcTotalPoints();
        return new AddToCartResponse(true, "Reward adaugat cu success", toResponse());
    }

    public AddToCartResponse removeFromCart(RemoveFromCartRequest request) {
        Iterator<CartReward> iterator = cart.getItems().iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            CartReward item = iterator.next();
            if (item.getRewardId().equals(request.getRewardId())) {
                if (item.getQuantity() <= request.getQuantity()) {
                    iterator.remove();
                } else {
                    item.setQuantity(item.getQuantity() - request.getQuantity());
                }
                found = true;
                break;
            }
        }

        recalcTotalPoints();
        return new AddToCartResponse(found, found ? "Reward inlaturat cu success" : "Reward-ul nu a fost gasit", toResponse());
    }

    public CartResponse getCart() {
        return toResponse();
    }

    
    public CheckoutResponse checkout() {
        Optional<UserProfile> optionalUser = userRepository.findById("88");
        if (optionalUser.isEmpty()) {
            return new CheckoutResponse(false, "Utilizatorul nu a fost gasit", 0, new ArrayList<>(), null);
        }

        UserProfile user = optionalUser.get();
        int totalCost = cart.getTotalPoints();

        if (user.getActivityPoints() < totalCost) {
            return new CheckoutResponse(false, "AP insuficient", user.getActivityPoints(), new ArrayList<>(), null);
        }

        for (CartReward item : cart.getItems()) {
            Reward reward = rewardRepository.findById(item.getRewardId()).orElse(null);
            if (reward == null || reward.getStockCount() < item.getQuantity()) {
                return new CheckoutResponse(false, "Stoc insuficient pentru " + item.getName(), user.getActivityPoints(), new ArrayList<>(), null);
            }
        }

        user.setActivityPoints(user.getActivityPoints() - totalCost);
        userRepository.save(user);

        for (CartReward item : cart.getItems()) {
            Reward reward = rewardRepository.findById(item.getRewardId()).orElse(null);
            if (reward != null) {
                reward.setStockCount(reward.getStockCount() - item.getQuantity());
                rewardRepository.save(reward);
            }
        }

        try {
            String cartSnapshot = objectMapper.writeValueAsString(cart.getItems());

            OrderHistory history = new OrderHistory();
            history.setDate(LocalDateTime.now());
            history.setTotalPoints(cart.getTotalPoints());
            history.setCartSnapshot(cartSnapshot);

            boolean areProduseFizice = cart.getItems().stream().anyMatch(item -> {
                try {
                    int id = Integer.parseInt(item.getRewardId());
                    return id <= 10;
                } catch (NumberFormatException e) {
                    return false;
                }
            });

            history.setAwbNumber(areProduseFizice ? generateAWB() : null);
            orderHistoryRepository.save(history);
        } catch (Exception e) {}

        List<CartReward> purchasedItems = new ArrayList<>();
        for (CartReward item : cart.getItems()) {
            purchasedItems.add(new CartReward(item.getRewardId(), item.getName(), item.getPrice(), item.getQuantity()));
        }

        String transactionId = generateTransactionId();
        int newBalance = user.getActivityPoints();

        cart.getItems().clear();
        cart.setTotalPoints(0);

        return new CheckoutResponse(true, "Checkout realizat cu succes", newBalance, purchasedItems, transactionId);
    }

}
//winton is a monke   

