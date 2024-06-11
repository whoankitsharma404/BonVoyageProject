package com.BonVoyage.PackageService.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class ApiResponse {
    private String status;
    private int results;
    private Object data;


    public ApiResponse(String status, int results){
        this.status=status;
        this.results=results;
    }

    public ApiResponse(Object data){
        this.status="success";
        this.data=data;
    }

    public ApiResponse(Object data,String status, int results){
        this.status=status;
        this.data=data;
        this.results=results;
    }
}
