package com.example.ordenesservice.Infrestructure.Controllers;

import com.example.ordenesservice.Application.UseCase.Orden.Create;
import com.example.ordenesservice.Application.UseCase.OrdenProducts.CreateOrderProducts;
import com.example.ordenesservice.Infrestructure.DTOS.requests.CreateOrderRequest;
import com.example.ordenesservice.Infrestructure.DTOS.responses.BaseResponse;
import com.example.ordenesservice.Infrestructure.DTOS.responses.CreateOrderResponse;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderProductsResponse;
import com.example.ordenesservice.Infrestructure.DTOS.responses.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class CreateController {
    @Autowired
    public Create mainUseCase;

    @Autowired
    public CreateOrderProducts secondUseCase;

    @PostMapping
    public BaseResponse run(@RequestBody CreateOrderRequest request){
        OrderResponse order = mainUseCase.run(request);
        List<OrderProductsResponse> products = secondUseCase.run(order.getId(), request.getProducts());
        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrden(order);
        response.setProducts(products);
        BaseResponse resp = new BaseResponse();
        resp.setData(response);
        resp.setMessage("Orden creada con exito");
        resp.setSuccess(true);
        resp.setHttpStatus(HttpStatus.valueOf(201));
        return resp;
    }
}
