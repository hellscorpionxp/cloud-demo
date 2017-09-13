package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tony
 * @date 2017年8月30日
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClientApplication {

    @Value("${combined}")
    private String combined;
    @Value("${foo.db.passwd}")
    private String passwd;

    @RequestMapping("/")
    public String index() {
        return String.format("combined: %s, passwd: %s", combined, passwd);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
