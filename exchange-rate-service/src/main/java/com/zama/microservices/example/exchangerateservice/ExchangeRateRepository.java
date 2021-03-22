package com.zama.microservices.example.exchangerateservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ExchangeRateRepository.
 *
 * @author Zakir Magdum
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
    Optional<ExchangeRate> getByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
