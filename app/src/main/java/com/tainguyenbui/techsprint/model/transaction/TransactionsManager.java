package com.tainguyenbui.techsprint.model.transaction;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tainguyenbui.techsprint.model.api.TransactionsInterface;
import com.tainguyenbui.techsprint.previousTransactions.IPreviousTransactionsCallback;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public class TransactionsManager {

    private Context context;
    private Retrofit retrofit;
    private TransactionsInterface transactionsApiService;

    public TransactionsManager(Context context) {

        this.context = context;

        setupRetrofit();
    }

    private void setupRetrofit() {

        retrofit = new Retrofit
                .Builder()
                .baseUrl("http://132.148.83.45:9090")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        transactionsApiService = retrofit.create(TransactionsInterface.class);


    }

    public List<Transaction> getTransactions() {


        List<Transaction> transactions = new ArrayList<>();

        try {
            InputStream inputStream = context.getAssets().open("transactions.json");
            Reader reader = new InputStreamReader(inputStream);

            Gson gson = new GsonBuilder().create();

            transactions = gson.fromJson(reader, TransactionsResponse.class).getTransactions();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    public void getOnlineTransations(final IPreviousTransactionsCallback callback) {

        if(transactionsApiService == null) {
            setupRetrofit();
        }

        Call<TransactionsResponse> call = transactionsApiService.getTransactions();
        call.enqueue(new Callback<TransactionsResponse>() {
            @Override
            public void onResponse(Call<TransactionsResponse> call, Response<TransactionsResponse> response) {

                TransactionsResponse body = response.body();
                List<Transaction> transactions =  body.getTransactions();
                Collections.reverse(transactions);
                callback.updateTransactions(transactions);
                Log.d("TRANSACTIONS API", "SUCCESSFUL");
            }

            @Override
            public void onFailure(Call<TransactionsResponse> call, Throwable t) {

                Toast.makeText(context, "Something went wrong, we are unable to refresh the transactions", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getTransactionsOverspend(final IPreviousTransactionsCallback callback) {

        if(transactionsApiService == null) {
            setupRetrofit();
        }

        Call<TransactionOverspendResponse> call = transactionsApiService.getTransactionsOverspend();
        call.enqueue(new Callback<TransactionOverspendResponse>() {
            @Override
            public void onResponse(Call<TransactionOverspendResponse> call, Response<TransactionOverspendResponse> response) {

                int statusCode = response.code();

                callback.processOverspending(response.body());
            }

            @Override
            public void onFailure(Call<TransactionOverspendResponse> call, Throwable t) {

                Log.d("TRANS OVERSPEND API", "ERROR");
            }
        });
    }
}
