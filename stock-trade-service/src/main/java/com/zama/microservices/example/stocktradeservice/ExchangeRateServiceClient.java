package com.zama.microservices.example.stocktradeservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ExchangeRateServiceClient.
 *
 * @author Zakir Magdum
 */
@FeignClient(name = "exchange-rate-service")
public interface ExchangeRateServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/to-usd/{fromCurrency}")
    Double getToUsdRate(String fromCurrency);
}
