package com.example.ordenesservice.Application.UseCase.Orden;

import com.example.ordenesservice.Domain.Entities.Order;
import com.example.ordenesservice.Domain.Port.IOrderPort;
import com.example.ordenesservice.Infrestructure.DTOS.requests.CreateOrderRequest;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Create {

    @Autowired
    IOrderPort repository;

    public OrderResponse run(CreateOrderRequest request){
        Order order = new Order();
        order.setDate(request.getDate());
        order.setStatus(request.getStatus());
        order.setTotal(request.getTotal());
        return repository.Create(order);
    }

}
