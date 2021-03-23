package com.zama.microservices.example.stocktradeservice;

import lombok.Data;

/**
 * StockTrade.
 *
 * @author Zakir Magdum
 */
@Data
public class StockTrade {
    private String ticker;
    private int quantity;
    private String payCurrency;
    private double cost;
}
