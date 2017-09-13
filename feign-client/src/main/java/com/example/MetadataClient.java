package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import feign.hystrix.FallbackFactory;

/**
 * @author Tony
 * @date 2017年8月30日
 * @version 1.0
 */
@FeignClient(name = "eureka-client", fallbackFactory = MetadataClientFallbackFactory.class)
public interface MetadataClient {

    @RequestMapping("/metadata")
    String getMetadata();

}

class MetadataClientFallbackFactory implements FallbackFactory<MetadataClient> {

    /*
     * (non-Javadoc)
     *
     * @see feign.hystrix.FallbackFactory#create(java.lang.Throwable)
     */
    @Override
    public MetadataClient create(Throwable cause) {
        System.out.println("metadata from fallback: " + cause.getMessage());
        return () -> "metadata from fallback";
    }

}
