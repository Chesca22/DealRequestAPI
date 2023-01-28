package com.francisca.datawarehouse.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "deal")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DealDetails implements Serializable {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private Long Id;


    private String dealId;


    @Pattern(regexp="^[A-Z]{3}$",message = "Invalid Input")
    private String orderingCurrency;

    @Pattern(regexp="^[A-Z]{3}$",message = "Invalid Input")

    private String convertedCurrency;

   @NotNull(message = "amount cannot be blank")
   private BigDecimal amount;

   @CreationTimestamp
   private LocalDateTime dealTimeStamp;
}
