package com.tainguyenbui.techsprint.Utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public enum CurrencyUtil {;

    public static String getAmountInPencesFormattedToPound(BigDecimal amount) {

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);

        formatter.setCurrency(Currency.getInstance(Locale.UK));

        return formatter.format(amount.divide(new BigDecimal(100)));
    }
}
