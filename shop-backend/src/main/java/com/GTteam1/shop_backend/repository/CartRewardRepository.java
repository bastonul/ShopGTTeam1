package com.GTteam1.shop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GTteam1.shop_backend.entity.CartReward;

public interface CartRewardRepository extends JpaRepository<CartReward, String> {
	
}
