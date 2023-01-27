package com.francisca.datawarehouse.repository;

import com.francisca.datawarehouse.model.DealDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealRepository extends JpaRepository<DealDetails, Long> {
Optional<DealDetails> findByDealId(String dealId);
}
