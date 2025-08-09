package com.GTteam1.shop_backend.dto;

import java.util.List;

public class PurchaseHistoryResponse {
    private List<PurchaseHistoryReward> purchases;

    public PurchaseHistoryResponse(List<PurchaseHistoryReward> purchases) {
        this.purchases = purchases;
    }

    public List<PurchaseHistoryReward> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseHistoryReward> purchases) {
        this.purchases = purchases;
    }
}
