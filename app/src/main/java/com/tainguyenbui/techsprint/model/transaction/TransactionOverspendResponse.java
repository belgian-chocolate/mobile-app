package com.tainguyenbui.techsprint.model.transaction;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by tainguyenbui on 15/03/2017.
 */

public class TransactionOverspendResponse {

    @SerializedName("averageDailySpend")
    BigDecimal averageDailySpend;
    @SerializedName("currentSpend")
    BigDecimal currentSpend;

    public BigDecimal getAverageDailySpend() {
        return averageDailySpend;
    }

    public void setAverageDailySpend(BigDecimal averageDailySpend) {
        this.averageDailySpend = averageDailySpend;
    }

    public BigDecimal getCurrentSpend() {
        return currentSpend;
    }

    public void setCurrentSpend(BigDecimal currentSpend) {
        this.currentSpend = currentSpend;
    }
}
