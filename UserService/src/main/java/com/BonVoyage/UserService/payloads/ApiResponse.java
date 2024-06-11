package com.BonVoyage.UserService.payloads;


import lombok.Data;

@Data
public class ApiResponse {


    private String status;
    private int results;
    private Object data;


    public ApiResponse(String status, int results){
        this.status=status;
        this.results=results;
    }
    public ApiResponse(){
    }

    public ApiResponse(String status, Object data){
        this.status=status;
        this.data=data;
    }

    public ApiResponse(Object data){
        this.status="success";
        this.data=data;
    }

    public ApiResponse(Object data, String status, int results){
        this.status=status;
        this.data=data;
        this.results=results;
    }
}
