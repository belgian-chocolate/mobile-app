package com.tainguyenbui.techsprint.model.transaction;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public class TransactionsResponse {

    @SerializedName("transactions")
    List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
