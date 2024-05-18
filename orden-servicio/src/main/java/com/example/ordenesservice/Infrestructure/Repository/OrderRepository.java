package com.example.ordenesservice.Infrestructure.Repository;


import com.example.ordenesservice.Domain.Entities.Order;
import com.example.ordenesservice.Domain.Port.IOrderPort;
import com.example.ordenesservice.Infrestructure.DTOS.responses.BaseResponse;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderResponse;
import com.example.ordenesservice.Infrestructure.Models.OrderModel;
import com.example.ordenesservice.Infrestructure.Repository.JPA.IOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepository implements IOrderPort {
    @Autowired
    private IOrderRepository repository;

    @Override
    public BaseResponse Listar(){
        return  from(repository.findAll().stream().map(this::from).toList(),
                "Ordenes listadas correctamente", true , 200
        );
    }

    @Override
    public OrderResponse Create(Order order){
        OrderModel model = new OrderModel();
        model.setId(order.getId());
        model.setDate(order.getDate());
        model.setTotal(order.getTotal());
        model.setStatus(order.getStatus());
        return from(repository.save(model));
    }

    @Override
    public BaseResponse UpdateStatus(String id, String status){
        OrderModel model = findAndEnsureExist(id);
        model.setStatus(status);
        return from(from(repository.save(model)), "Status actualizado correctamente", true , 200);
    }

    private  BaseResponse from(OrderResponse response,String message, boolean success, int code){
        BaseResponse base = new BaseResponse();
        base.setData(response);
        base.setMessage(message);
        base.setSuccess(success);
        base.setHttpStatus(HttpStatus.valueOf(code));
        return base;
    }

    public  OrderModel findAndEnsureExist(String id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }

    OrderResponse from(OrderModel orderModel){
         OrderResponse orderResponse = new OrderResponse();
         orderResponse.setId(orderModel.getId());
         orderResponse.setStatus(orderModel.getStatus());
         orderResponse.setDate(orderModel.getDate());
         orderResponse.setTotal(orderModel.getTotal());
         return orderResponse;
    }


    BaseResponse from(List<OrderResponse> responses, String message, boolean success, int code){
        BaseResponse base = new BaseResponse();
        base.setData(responses);
        base.setSuccess(success);
        base.setMessage(message);
        base.setHttpStatus(HttpStatus.valueOf(code));
        return base;
    }

}
