package com.GTteam1.shop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GTteam1.shop_backend.entity.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
