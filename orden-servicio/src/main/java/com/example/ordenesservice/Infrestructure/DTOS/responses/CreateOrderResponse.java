package com.example.ordenesservice.Infrestructure.DTOS.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CreateOrderResponse {

    private OrderResponse orden;
    private List<OrderProductsResponse> products;
}
