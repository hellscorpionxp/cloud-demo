package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
@RestController
public class EurekaClientApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @RequestMapping("/metadata")
    @ResponseBody
    public String getMetadata() {
        List<ServiceInstance> instances = discoveryClient
            .getInstances("eureka-client");
        if (instances != null && !instances.isEmpty()) {
            return instances.get(0).getMetadata().toString();
        }
        return null;
    }

}
