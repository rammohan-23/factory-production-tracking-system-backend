package com.rammohan.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;

@Configuration
public class PreflightFilter {

    @Bean
    public WebFilter corsPreflightFilter() {
        return (exchange, chain) -> {
            if (exchange.getRequest().getMethod().name().equals("OPTIONS")) {
                exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.OK);
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        };
    }
}