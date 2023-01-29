package com.francisca.datawarehouse.controller;

import com.francisca.datawarehouse.dto.RequestDto;
import com.francisca.datawarehouse.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/deals")
@Slf4j
public class DealController {
    private final DealService dealService;


    @PostMapping
    public ResponseEntity<?> saveDealDetails(@RequestBody RequestDto dto) throws Exception {
        log.info("Deal details saved in the successfully");
        return new ResponseEntity<>(dealService.saveDealDetails(dto), OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllDeals(){
        log.info("All deals retrieved successfully");
        return new ResponseEntity<>(dealService.getAllDeals(), OK);
    }
    @GetMapping("/{deal-id}")
    public ResponseEntity<?> getDealById(@PathVariable(value="deal-id") String id){
        log.info("deal retrieved successfully");
        return new ResponseEntity<>(dealService.getDealById(id), OK);
    }
}