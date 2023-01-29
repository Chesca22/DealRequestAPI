package com.francisca.datawarehouse.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public class RequestDto {
        @NotNull
        private String dealId;

        @Size(min = 3, max = 3, message = "Ordering currency code must be 3 characters")
        @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
        private String orderingCurrency;

        @Size(min = 3, max = 3, message = "Currency code must be 3 characters")
        @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
        private String convertedCurrency;

        @NotNull
        private String amount;

    }
