package com.GTteam1.shop_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GTteam1.shop_backend.entity.OrderHistory;

import jakarta.persistence.OrderBy;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, String> {
    List<OrderBy> findAllByOrderByDateDesc();
}
