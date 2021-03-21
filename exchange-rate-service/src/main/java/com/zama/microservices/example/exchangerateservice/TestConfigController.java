package com.zama.microservices.example.exchangerateservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestConfigController.
 *
 * @author Zakir Magdum
 */
@RefreshScope
@RestController
public class TestConfigController {
    @Value("${test.property:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}
