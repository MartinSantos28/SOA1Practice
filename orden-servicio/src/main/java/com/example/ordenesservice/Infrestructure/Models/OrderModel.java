package com.example.ordenesservice.Infrestructure.Models;


import jakarta.persistence.*;
import  lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter @Setter
public class OrderModel {
    @Id
    private  String id;

    @Column(nullable = false)
    private  float total;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "order")
    private  List<OrderProductsModel> products;
}