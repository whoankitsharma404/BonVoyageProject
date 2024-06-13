package com.BonVoyage.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name= "dummy",url = "http://localhost:4002")
public interface FeignClientConfig {

    @PostMapping("/bookings/add")
    Object doPostCall(@RequestHeader Map<String,String> headers, @RequestParam Map<String,String> params, @RequestBody Object body);


}
