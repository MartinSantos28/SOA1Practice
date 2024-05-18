package com.example.ordenesservice.Infrestructure.DTOS.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderProductsResponse {

    private  String id;

    private String orderId;

    private  String  productId;

    private  float total;

    private  int stock;

}
