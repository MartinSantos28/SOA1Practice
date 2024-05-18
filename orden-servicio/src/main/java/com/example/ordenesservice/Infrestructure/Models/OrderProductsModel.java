package com.example.ordenesservice.Infrestructure.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "orders_products")
@Getter @Setter
public class OrderProductsModel {
    @Id
    private  String id;

    @Column(nullable = false)
    private  String product_id;

    @Column(nullable = false)
    private  float total;

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel order ;


}