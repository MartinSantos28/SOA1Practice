package com.example.ordenesservice.Domain.Port;

import com.example.ordenesservice.Domain.Entities.Order;
import com.example.ordenesservice.Infrestructure.DTOS.responses.BaseResponse;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderResponse;

public interface IOrderPort {
    BaseResponse Listar();

    OrderResponse Create(Order order);

    BaseResponse UpdateStatus(String id, String status);

}
