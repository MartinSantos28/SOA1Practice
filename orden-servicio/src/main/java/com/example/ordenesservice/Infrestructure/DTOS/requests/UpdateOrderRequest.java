package com.example.ordenesservice.Infrestructure.DTOS.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateOrderRequest {
    private  String id;
    private  String status;
}
