package com.zama.microservices.example.stocktradeservice;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StockTradeController.
 *
 * @author Zakir Magdum
 */
@RestController
public class StockTradeController {
    private final ExchangeRateServiceClient rateServiceClient;
    private final StockPriceServiceClient priceServiceClient;

    public StockTradeController(ExchangeRateServiceClient rateServiceClient, StockPriceServiceClient priceServiceClient) {
        this.priceServiceClient = priceServiceClient;
        this.rateServiceClient = rateServiceClient;
    }

    @RequestMapping("/cost")
    private ResponseEntity<StockTrade> calculateCost(@RequestBody StockTrade trade) {
        double exchangeRate = 1.0;
        if (StringUtils.isNotBlank(trade.getPayCurrency()) && !"USD".equals(trade.getPayCurrency())) {
            exchangeRate = rateServiceClient.getToUsdRate(trade.getPayCurrency());
        }
        double price = priceServiceClient.getPrice(trade.getTicker());
        trade.setCost(exchangeRate * price * trade.getQuantity());

        return ResponseEntity.ok(trade);
    }
}
