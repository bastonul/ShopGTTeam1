package com.GTteam1.shop_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GTteam1.shop_backend.dto.GiftRequest;
import com.GTteam1.shop_backend.dto.GiftResponse;
import com.GTteam1.shop_backend.entity.CartReward;
import com.GTteam1.shop_backend.entity.OrderHistory;
import com.GTteam1.shop_backend.entity.UserProfile;
import com.GTteam1.shop_backend.repository.OrderHistoryRepository;
import com.GTteam1.shop_backend.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.GTteam1.shop_backend.dto.OrderHistoryResponse;

@Service
public class UserService {

	private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfile getUserProfile(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public GiftResponse giftPoints(GiftRequest request) {
        Optional<UserProfile> optionalUser = userRepository.findById("88");

        if (optionalUser.isEmpty()) {
            return new GiftResponse(false, "Utilizatorul nu a fost gasit", 0);
        }

        UserProfile user = optionalUser.get();

        if (request.getAmount() <= 0) {
            return new GiftResponse(false, "Numar de puncte invalid", user.getActivityPoints());
        }

        if (user.getActivityPoints() < request.getAmount()) {
            return new GiftResponse(false, "AP insuficient", user.getActivityPoints());
        }

        user.setActivityPoints(user.getActivityPoints() - request.getAmount());
        userRepository.save(user);

        return new GiftResponse(true, "Ai daruit " + request.getAmount() + " AP catre " + request.getNume(),
            user.getActivityPoints()
        );
    }
    
    
}
