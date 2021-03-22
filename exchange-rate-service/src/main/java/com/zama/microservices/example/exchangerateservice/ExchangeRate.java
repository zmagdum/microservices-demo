package com.zama.microservices.example.exchangerateservice;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * ExchangeRate.
 *
 * @author Zakir Magdum
 */
@Data
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "from_currency")
    private String fromCurrency;
    @Column(name = "to_currency")
    private String toCurrency;
    @Column
    private Double rate;
    @Column
    private LocalDateTime updated;
}
