package com.example.ordenesservice.Infrestructure.DTOS.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class OrderResponse {
    private  String id;

    private float total;

    private Date date;

    private  String status;

}
