package com.example.proxy;

import com.example.domain.Track;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authentication-service2",url = "authentication-service2:8081")
public interface UserProxy {
    @PostMapping("/api/v2/register/")
    public ResponseEntity<?> saveUser(@RequestBody Track user);

}
