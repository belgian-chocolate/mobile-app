package com.tainguyenbui.techsprint.Utils;

import android.support.annotation.NonNull;

import com.tainguyenbui.techsprint.model.transaction.Merchant;
import com.tainguyenbui.techsprint.model.transaction.Transaction;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public enum TransactionsUtil {;

    @NonNull
    public static String getMerchantName(Transaction transaction) {

        if(transaction == null) {
            return "";
        }

        String suggestedName = transaction.getSuggested_name();

        if(suggestedName == null && transaction.getName() != null) {
            return transaction.getName();
        }

        return suggestedName == null ? "" : suggestedName;
    }

    public static String getMerchantLogo(Transaction transaction) {

        if (transaction == null) {
            return "";
        }

        String merchantLogoUrl = transaction.getLogo();

        if(merchantLogoUrl == null) {

            if(transaction.getFoursquare_category_icon() == null) {
                return "";
            }

            String metadataLogo = transaction.getFoursquare_category_icon();

            return metadataLogo == null ? "" : metadataLogo;
        }

        return merchantLogoUrl.trim();
    }
}
