package com.francisca.datawarehouse.serviceImpl;

import com.francisca.datawarehouse.dto.DealDetailsDto;
import com.francisca.datawarehouse.dto.RequestDto;
import com.francisca.datawarehouse.exception.DealAlreadyExistException;
import com.francisca.datawarehouse.exception.DealNotFoundException;
import com.francisca.datawarehouse.model.DealDetails;
import com.francisca.datawarehouse.repository.DealRepository;
import com.francisca.datawarehouse.response.ApiResponse;
import com.francisca.datawarehouse.service.DealService;
import com.francisca.datawarehouse.utils.ValidateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import static org.springframework.http.HttpStatus.CREATED;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealServiceImpl implements DealService {
private final DealRepository dealRepository;

private final ValidateUtil validateUtil;


    public ApiResponse<?> saveDealDetails(RequestDto dto)  {
        String uniqueId = UUID.randomUUID().toString();
        Optional <DealDetails> existingDealDetails = dealRepository.findByDealId(uniqueId);
        if(existingDealDetails.isEmpty()) {
            DealDetails dealDetails = DealDetails.builder()
                    .dealId(uniqueId)
                    .orderingCurrency(validateUtil.validateCurrency(dto.getOrderingCurrency()))
                    .convertedCurrency(validateUtil.validateCurrency(dto.getConvertedCurrency()))
                    .amount(validateUtil.handleDealAmount(dto.getAmount()))
                    .build();
            dealRepository.save(dealDetails);
            log.info("deal details saved successfully");

            return new ApiResponse<>("success" , LocalDateTime.now(), CREATED);
        }
        else {
            throw new DealAlreadyExistException("Deal with Id number: " + uniqueId + " already exist");
        }

    }


    public ApiResponse<List<DealDetailsDto>> getAllDeals(){
        List<DealDetails> allDeals = dealRepository.findAll();
        log.info("All deals retrieved successfully");
        return new ApiResponse<>("success",LocalDateTime.now(),allDeals.stream().map(this::mapToDealDetailsDto).toList());
    }

    private DealDetailsDto mapToDealDetailsDto(DealDetails dealDetails){
        return DealDetailsDto.builder()
                .dealId(dealDetails.getDealId())
                .orderingCurrency(dealDetails.getOrderingCurrency())
                .convertedCurrency(dealDetails.getConvertedCurrency())
                .amount(dealDetails.getAmount())
                .dealTimeStamp(dealDetails.getDealTimeStamp())
                .build();
    }

    @Override
    public ApiResponse<DealDetailsDto> getDealById(String id){
        DealDetails dealDetails = dealRepository.findByDealId(id).orElseThrow(() -> new DealNotFoundException("Deal with Id number: " + id + " does not exist"));
        log.info("Deal with Id number: " + id + " retrieved successfully");
        return new ApiResponse<>("success",LocalDateTime.now(),mapToDealDetailsDto(dealDetails));
    }


}
