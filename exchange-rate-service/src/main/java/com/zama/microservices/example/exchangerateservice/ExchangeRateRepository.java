package com.zama.microservices.example.exchangerateservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ExchangeRateRepository.
 *
 * @author Zakir Magdum
 */
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
    Optional<ExchangeRate> getByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
