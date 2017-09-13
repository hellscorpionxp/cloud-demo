package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tony
 * @date 2017年8月30日
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@RestController
public class FeignClientApplication {

    @Autowired
    private MetadataClient metadataClient;

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

    @RequestMapping("/r_metadata")
    @ResponseBody
    public String getMetadata() {
        return metadataClient.getMetadata();
    }

}
