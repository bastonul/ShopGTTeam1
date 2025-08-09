package com.GTteam1.shop_backend.dto;

import java.util.List;
import com.GTteam1.shop_backend.entity.Reward;

public class RewardResponse {
	
    private List<Reward> rewards;

    public RewardResponse(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<Reward> getRewards() {
        return rewards;
    }
    
    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
}

