package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Tony
 * @date 2017-08-30
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulModuleApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ZuulModuleApplication.class, args);
    }

}
