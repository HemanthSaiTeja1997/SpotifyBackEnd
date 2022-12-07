/*
 *Author Name :P.Hemanth Sai Teja
 *Date:07-12-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.apiGatewayDemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v2/**")
                        .uri("http://authentication-service2:8081/")) // use the name of the application in the uri

                .route(p->p
                        .path("/api/v1/**")
                        .uri("http://music-service2:8083/"))
                .build();
    }


}
