package com.francisca.datawarehouse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class RequestDto {

        @Pattern(regexp="^[A-Z]{3}$",message = "Invalid Input")
        private String orderingCurrency;

        @Pattern(regexp="^[A-Z]{3}$",message = "Invalid Input")
        private String convertedCurrency;

        @NotNull(message = "amount cannot be blank")
        private BigDecimal amount;

    }
