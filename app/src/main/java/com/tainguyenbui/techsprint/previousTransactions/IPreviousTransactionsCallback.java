package com.tainguyenbui.techsprint.previousTransactions;

import com.tainguyenbui.techsprint.model.transaction.Transaction;
import com.tainguyenbui.techsprint.model.transaction.TransactionOverspendResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tainguyenbui on 15/03/2017.
 */

public interface IPreviousTransactionsCallback {

    void updateTransactions(List<Transaction> transactions);
    void processOverspending(TransactionOverspendResponse transactionOverspendResponse);
}
