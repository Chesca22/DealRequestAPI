package com.francisca.datawarehouse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class DealDetailsDto {
    private String dealId;
    private String orderingCurrency;
    private String convertedCurrency;
    private String amount;
    private LocalDateTime dealTimeStamp;

}
