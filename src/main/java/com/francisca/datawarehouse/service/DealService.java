package com.francisca.datawarehouse.service;

import com.francisca.datawarehouse.dto.DealDetailsDto;
import com.francisca.datawarehouse.dto.RequestDto;
import com.francisca.datawarehouse.response.ApiResponse;

import java.util.List;

public interface DealService {
    ApiResponse<?> saveDealDetails(RequestDto dto) throws Exception;

    ApiResponse<List<DealDetailsDto>> getAllDeals();

    ApiResponse<DealDetailsDto> getDealById(String id);


}
