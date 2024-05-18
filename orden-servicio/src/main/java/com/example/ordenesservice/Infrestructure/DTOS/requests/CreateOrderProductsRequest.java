package com.example.ordenesservice.Infrestructure.DTOS.requests;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CreateOrderProductsRequest {
    private  String productId;

    private float total;

    private int stock;
}
