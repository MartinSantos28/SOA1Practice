package com.example.ordenesservice.Infrestructure.Controllers;

import com.example.ordenesservice.Application.UseCase.Orden.Update;
import com.example.ordenesservice.Infrestructure.DTOS.requests.UpdateOrderRequest;
import com.example.ordenesservice.Infrestructure.DTOS.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class UpdateController {
    @Autowired
    private Update useCase;

    @PutMapping
    public BaseResponse update(@RequestBody UpdateOrderRequest request){return useCase.run(request);}
}
