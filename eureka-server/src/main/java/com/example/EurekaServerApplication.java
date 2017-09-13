package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Tony
 * @date 2017年8月30日
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
