package com.example.ordenesservice.Domain.Port;

import com.example.ordenesservice.Domain.Entities.OrderProducts;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderProductsResponse;

public interface IOrderProductsPort {

    OrderProductsResponse CreateOrderProduct(OrderProducts orderProducts);

}
