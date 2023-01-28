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
import java.util.regex.Pattern;


@RequiredArgsConstructor
@Component
@Getter
public class ValidateUtil {

    public String validateCurrency(String code) {
        Currency.getAvailableCurrencies();
        for(Currency currency : Currency.getAvailableCurrencies()) {
            if(currency.getCurrencyCode().equals(code)) {
                return code;

        }
        }
        throw new InvalidCurrencyException("Unknown currency code: " + code);
    }




    public BigDecimal handleDealAmount(BigDecimal amount) {
        if(amount == null) {
            throw new InvalidCurrencyException("Invalid amount: " + amount);
        }
        return amount;
    }

}
