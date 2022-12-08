package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BejC2S3RestfulMongoDbChallengeTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BejC2S3RestfulMongoDbChallengeTrackApplication.class, args);
    }

}
