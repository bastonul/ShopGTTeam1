package com.GTteam1.shop_backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GTteam1.shop_backend.dto.RewardResponse;
import com.GTteam1.shop_backend.entity.Reward;
import com.GTteam1.shop_backend.repository.RewardRepository;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
	
	private final RewardRepository rewardRepository;

    public RewardController(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @GetMapping
    public RewardResponse getAllRewards() {
        List<Reward> rewards = rewardRepository.findAll();
        return new RewardResponse(rewards);
    }
}
