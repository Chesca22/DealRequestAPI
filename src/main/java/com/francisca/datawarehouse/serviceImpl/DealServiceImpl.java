package com.francisca.datawarehouse.serviceImpl;

import com.francisca.datawarehouse.dto.DealDetailsDto;
import com.francisca.datawarehouse.dto.RequestDto;
import com.francisca.datawarehouse.exception.DealAlreadyExistException;
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


import static org.springframework.http.HttpStatus.CREATED;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealServiceImpl implements DealService {
private final DealRepository dealRepository;

private final ValidateUtil validateUtil;


  public ApiResponse<?> saveDealDetails(RequestDto dto)  {

    String uniqueId = dto.getDealId();
   Optional <DealDetails> existingDealDetails = dealRepository.findByDealId(uniqueId);
    if(existingDealDetails.isEmpty()) {
        DealDetails dealDetails = DealDetails.builder()
                .dealId(dto.getDealId())
                .orderingCurrency(validateUtil.validateCurrency(dto.getOrderingCurrency().toUpperCase()))
                .convertedCurrency(validateUtil.validateCurrency(dto.getConvertedCurrency().toUpperCase()))
                .amount(validateUtil.formatAmount(dto.getAmount(), dto.getOrderingCurrency().toUpperCase()))
                .build();
        dealRepository.save(dealDetails);
        log.info("deal details saved successfully");

      return new ApiResponse<>("Deal with Id number: " + dealDetails.getDealId() + " saved successfully", LocalDateTime.now(), CREATED);
  }
    else {
        throw new DealAlreadyExistException("Deal with Id number: " + uniqueId + " already exist");
    }

  }


    public List<DealDetailsDto> getAllDeals(){
        List<DealDetails> allDeals = dealRepository.findAll();
        log.info("All deals retrieved successfully");
        return allDeals.stream().map(this::mapToDealDetailsDto).toList();
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
}
