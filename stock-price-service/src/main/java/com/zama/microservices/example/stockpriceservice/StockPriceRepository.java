package com.zama.microservices.example.stockpriceservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * StockPriceRepository.
 *
 * @author Zakir Magdum
 */
@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {
    Optional<StockPrice> getByTicker(String ticker);
}
