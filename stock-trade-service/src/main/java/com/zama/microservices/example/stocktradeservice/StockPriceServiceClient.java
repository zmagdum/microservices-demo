package com.zama.microservices.example.stocktradeservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * StockPriceClient.
 *
 * @author Zakir Magdum
 */
@FeignClient(name = "stock-price-service")
public interface StockPriceServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/price/{ticker}")
    Double getPrice(String ticker);
}
