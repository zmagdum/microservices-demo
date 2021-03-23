package com.zama.microservices.example.stockpriceservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static java.lang.String.join;

/**
 * StockPriceController.
 *
 * @author Zakir Magdum
 */
@RestController
public class StockPriceController {
    private final StockPriceRepository priceRepository;

    public StockPriceController(StockPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @RequestMapping("/price/{ticker}")
    private ResponseEntity<Double> getPrice(@PathVariable String ticker) {
        Optional<StockPrice> er = priceRepository.getByTicker(ticker);
        if (er.isPresent()) {
            return ResponseEntity.ok(er.get().getPrice());
        }
        throw new IllegalArgumentException(join(" ", "Price not found", ticker));
    }
}
