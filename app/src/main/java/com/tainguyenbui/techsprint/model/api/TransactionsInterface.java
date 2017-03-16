package com.tainguyenbui.techsprint.model.api;

import com.tainguyenbui.techsprint.model.transaction.TransactionOverspendResponse;
import com.tainguyenbui.techsprint.model.transaction.TransactionsResponse;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tainguyenbui on 15/03/2017.
 */

public interface TransactionsInterface {

    @GET("api/transactions")
    Call<TransactionsResponse> getTransactions();

    @GET("api/transactions/overspend")
    Call<TransactionOverspendResponse> getTransactionsOverspend();
}
