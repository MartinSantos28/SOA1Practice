package com.example.ordenesservice.Infrestructure.Controllers;

import com.example.ordenesservice.Application.UseCase.Orden.Get;
import com.example.ordenesservice.Infrestructure.DTOS.responses.BaseResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class GetController {
    @Autowired
    private Get useCase;

    @GetMapping
    public BaseResponse run(){return useCase.run();}
}
