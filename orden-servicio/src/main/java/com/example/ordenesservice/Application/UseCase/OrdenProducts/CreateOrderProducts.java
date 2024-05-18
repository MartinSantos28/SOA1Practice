package com.example.ordenesservice.Application.UseCase.OrdenProducts;

import com.example.ordenesservice.Domain.Entities.OrderProducts;
import com.example.ordenesservice.Domain.Port.IOrderProductsPort;
import com.example.ordenesservice.Infrestructure.DTOS.requests.CreateOrderProductsRequest;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrderProducts {
    @Autowired
    IOrderProductsPort repository;


    public List<OrderProductsResponse> run(String id, List<CreateOrderProductsRequest> products){
        return products.stream().map(product -> from (id, product)).toList();
    }

    private OrderProductsResponse from (String id, CreateOrderProductsRequest createOrderProductsRequest){
        OrderProducts orderProducts = new OrderProducts();
        orderProducts.setProductId(createOrderProductsRequest.getProductId());
        orderProducts.setStock(createOrderProductsRequest.getStock());
        orderProducts.setTotal(createOrderProductsRequest.getTotal());
        orderProducts.setOrderId(id);
        return repository.CreateOrderProduct(orderProducts);
    }

}
