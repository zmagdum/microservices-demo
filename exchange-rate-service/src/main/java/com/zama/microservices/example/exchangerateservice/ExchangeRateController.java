package com.zama.microservices.example.exchangerateservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
@RestController
public class ExchangeRateController {
    @Autowired
    private ExchangeRateRepository rateRepository;

    @RequestMapping("/to-usd/{fromCurrency}")
    ResponseEntity<Double> getToUsdRate(@PathVariable String fromCurrency) {
        Optional<ExchangeRate> er = rateRepository.getByFromCurrencyAndToCurrency(fromCurrency, "USD");
        if (er.isPresent()) {
            return ResponseEntity.ok(er.get().getRate());
        }
        throw new IllegalArgumentException(join(" ", "Currencies not found", fromCurrency, "USD"));
    }
}
