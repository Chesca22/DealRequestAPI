package com.francisca.datawarehouse.controller;


import com.francisca.datawarehouse.service.DealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class DealControllerTest {
  @Mock
  private DealService dealService;
  @InjectMocks
  DealController dealController;

  @BeforeEach
  void init(){
   }

    @Test
    void getAllDeals(){
    }

    @Test
    void getDealById() {
    }



}