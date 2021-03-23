package com.zama.microservices.example.stockpriceservice;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * StockPrice.
 *
 * @author Zakir Magdum
 */
@Data
@Entity
@Table(name = "stock_price")
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String ticker;
    @Column
    private Double price;
    @Column
    private LocalDateTime updated;
}
