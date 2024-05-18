package com.example.ordenesservice.Infrestructure.DTOS.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class CreateOrderRequest {
    private  float total;

    private Date date;

    private String status;

    private List<CreateOrderProductsRequest> products ;
}
