package com.example.ordenesservice.Domain.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class OrderProducts {
    private  String id;

    @Setter
    private String orderId;

    @Setter
    private  String productId;

    @Setter
    private float total;

    @Setter
    private int stock;

    public OrderProducts(){
        this.id = UUID.randomUUID().toString();
    }
}
