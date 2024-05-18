package com.example.ordenesservice.Infrestructure.DTOS.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class BaseResponse {

    private Object data;
    private String message;
    private Boolean success;
    private HttpStatus httpStatus;
}
