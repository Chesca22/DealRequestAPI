package com.francisca.datawarehouse.controller;

import com.francisca.datawarehouse.dto.DealDetailsDto;
import com.francisca.datawarehouse.dto.RequestDto;
import com.francisca.datawarehouse.exception.DealAlreadyExistException;
import com.francisca.datawarehouse.exception.DealNotFoundException;
import com.francisca.datawarehouse.model.DealDetails;
import com.francisca.datawarehouse.repository.DealRepository;
import com.francisca.datawarehouse.service.DealService;
import com.francisca.datawarehouse.serviceImpl.DealServiceImpl;
import com.francisca.datawarehouse.utils.ValidateUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
public class DealServiceTest {
       @InjectMocks
    private DealServiceImpl dealService;
    @Mock
    private DealRepository dealRepository;
    @Mock
    private DealDetails deals;
    @Mock
    private ValidateUtil util;

    @BeforeEach
void init(){
        LocalDateTime localDateTime = LocalDateTime.of(2022, 12, 2, 1, 34, 19);
     deals = new DealDetails(1L,"234","USD","NGN", BigDecimal.valueOf(340), localDateTime);
    when(dealRepository.save(deals)).thenReturn(deals);
}

    @Test
    @DisplayName("should save the deal details")
    void saveDetails()  {

        var dto = new RequestDto(util.validateCurrency("USD"), util.validateCurrency("NGN"), util.handleDealAmount(BigDecimal.valueOf(340)));
        when(dealRepository.findByDealId(deals.getDealId())).thenReturn(Optional.empty());
        var actual = dealService.saveDealDetails(dto);
        assertEquals("success", actual.getMessage());

    }

   @Test
   void testToFindDealDetailsById(){
       when(dealRepository.findByDealId(deals.getDealId())).thenReturn(Optional.of(deals));
       var actual = dealService.getDealById("234");
       assertEquals("success", actual.getMessage());
   }


    @Test
    void shouldThrowDealAlreadyExistException() {
        RequestDto dto = new RequestDto("USD", "NGN", BigDecimal.valueOf(340));
        when(dealRepository.findByDealId(deals.getDealId())).thenReturn(Optional.of(deals));
        assertThrows(DealAlreadyExistException.class, () -> dealService.saveDealDetails(dto));

    }

    @Test
    void shouldThrowDealNotFoundException(){
        when(dealRepository.findByDealId(deals.getDealId())).thenReturn(Optional.of(deals));
        assertThrows(DealNotFoundException.class, () -> dealService.getDealById("230"));
    }
}
