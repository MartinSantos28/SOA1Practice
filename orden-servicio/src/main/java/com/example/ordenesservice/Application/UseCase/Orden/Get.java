package com.example.ordenesservice.Application.UseCase.Orden;

import com.example.ordenesservice.Domain.Port.IOrderPort;
import com.example.ordenesservice.Infrestructure.DTOS.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Get {

    @Autowired
    IOrderPort repository;

    public BaseResponse run(){
        return  repository.Listar();
    }
}
