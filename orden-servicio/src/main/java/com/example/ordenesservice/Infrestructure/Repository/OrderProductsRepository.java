package com.example.ordenesservice.Infrestructure.Repository;

import com.example.ordenesservice.Domain.Entities.OrderProducts;
import com.example.ordenesservice.Domain.Port.IOrderProductsPort;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderProductsResponse;
import com.example.ordenesservice.Infrestructure.Models.OrderProductsModel;
import com.example.ordenesservice.Infrestructure.Repository.JPA.IOrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProductsRepository implements IOrderProductsPort {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    IOrderProductRepository repository;

    @Override
    public OrderProductsResponse CreateOrderProduct(OrderProducts orderProducts){
        OrderProductsModel model = new OrderProductsModel();
        model.setId(orderProducts.getId());
        model.setProduct_id(orderProducts.getProductId());
        model.setOrder(orderRepository.findAndEnsureExist(orderProducts.getOrderId()));
        model.setStock(orderProducts.getStock());
        model.setTotal(orderProducts.getTotal());
        return from(repository.save(model));
    }

    OrderProductsResponse from (OrderProductsModel orderProducts){
        OrderProductsResponse  resp = new OrderProductsResponse();
        resp.setId(orderProducts.getId());
        resp.setProductId(orderProducts.getProduct_id());
        resp.setOrderId(orderProducts.getOrder().getId());
        resp.setStock(orderProducts.getStock());
        resp.setTotal(orderProducts.getTotal());
        return resp;
    }
}
