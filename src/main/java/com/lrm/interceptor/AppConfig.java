/*package com.lrm.interceptor;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    *//*
    * This is a configuration class that creates a RestTemplate bean.
    * The @LoadBalanced annotation tells Spring Cloud to create a load-balanced RestTemplate.
    * it will understand the services id for Eureka to use Ribbon to load balance the requests
     *//*

    @LoadBalanced
    @Bean // spring will manage the lifecycle of this bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}*/
