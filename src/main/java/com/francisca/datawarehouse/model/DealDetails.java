package com.francisca.datawarehouse.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
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

    @NotNull
   private String dealId;

    @Size(min = 3, max = 3, message = "Ordering currency code must be 3 characters")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")

   private String orderingCurrency;
    @Size(min = 3, max = 3, message = "Ordering currency code must be 3 characters")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
   private String convertedCurrency;

   @NotNull
   private String amount;

   @CreationTimestamp
   private LocalDateTime dealTimeStamp;
}
