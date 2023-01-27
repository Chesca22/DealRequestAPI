package com.francisca.datawarehouse.utils;


import com.francisca.datawarehouse.exception.InvalidCurrencyException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;


@RequiredArgsConstructor
@Component
@Getter
public class ValidateUtil {



    public String validateCurrency(String code) {
        for(Currency currency : Currency.getAvailableCurrencies()) {
            if(currency.getCurrencyCode().equalsIgnoreCase(code)) {
                return code;
            }
        }
        throw new InvalidCurrencyException("Unkown currency code: " + code);
    }


    public String formatAmount(String amount, String currencyCode){
        try {
            Float amountFloat = Float.parseFloat(amount);

            Locale locale = new Locale(Currency.getInstance(validateCurrency(currencyCode)).getCurrencyCode());
            NumberFormat Us = NumberFormat.getCurrencyInstance(locale);
            String m = (Us.format(amountFloat));
            return m;
        } catch (NumberFormatException e) {
            throw new InvalidCurrencyException("Invalid amount: " + amount);
        }
    }

//    public String formatAmount(String amount, String currencyCode){
//        Float amountFloat = Float.parseFloat(amount);
//        Locale locale = new Locale(Currency.getInstance(currencyCode).getCurrencyCode());
//        NumberFormat Us = NumberFormat.getCurrencyInstance(locale);
//        String m = (Us.format(amountFloat));
//        return m;
//    }
}
