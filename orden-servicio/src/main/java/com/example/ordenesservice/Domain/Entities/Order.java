package com.example.ordenesservice.Domain.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Order {
    private  String id;

    @Setter
    private float total;

    @Setter
    private Date date;

    @Setter
    private String status;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }
}
