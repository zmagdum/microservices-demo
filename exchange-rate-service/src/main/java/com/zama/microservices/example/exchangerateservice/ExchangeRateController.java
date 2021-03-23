package com.zama.microservices.example.exchangerateservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static java.lang.String.join;

/**
 * ExchangeRateController.
 *
 * @author Zakir Magdum
 */
@RestController
public class ExchangeRateController {
    private final ExchangeRateRepository rateRepository;

    public ExchangeRateController(ExchangeRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }
    @RequestMapping("/to-usd/{fromCurrency}")
    private ResponseEntity<Double> getToUsdRate(@PathVariable String fromCurrency) {
        Optional<ExchangeRate> er = rateRepository.getByFromCurrencyAndToCurrency("USD", fromCurrency);
        if (er.isPresent()) {
            return ResponseEntity.ok(er.get().getRate());
        }
        throw new IllegalArgumentException(join(" ", "Currencies not found", fromCurrency, "USD"));
    }

    @RequestMapping("/{toCurrency}/{fromCurrency}")
    private ResponseEntity<Double> getRate(@PathVariable String toCurrency, @PathVariable String fromCurrency) {
        if ("USD".equals(toCurrency)) {
            return getToUsdRate(fromCurrency);
        }
        Optional<ExchangeRate> er1 = rateRepository.getByFromCurrencyAndToCurrency("USD", fromCurrency);
        Optional<ExchangeRate> er2 = rateRepository.getByFromCurrencyAndToCurrency("USD", toCurrency);
        if (er1.isPresent() && er2.isPresent()) {
            return ResponseEntity.ok(er1.get().getRate()/er2.get().getRate());
        }
        throw new IllegalArgumentException(join(" ", "Currencies not found", fromCurrency, "USD"));
    }
}
