package com.BonVoyage.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name= "userpackage",url = "http://localhost:4003")
public interface FeignClientUserPackage {

    @PostMapping("/createNewPackage")
    Object doPostSavePackage(@RequestHeader Map<String,String> headers, @RequestParam Map<String,String> params, @RequestBody Object body);

}
