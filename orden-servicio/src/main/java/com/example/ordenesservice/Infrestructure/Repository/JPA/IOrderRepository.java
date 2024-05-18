package com.example.ordenesservice.Infrestructure.Repository.JPA;

import com.example.ordenesservice.Infrestructure.Models.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, String> {
}
