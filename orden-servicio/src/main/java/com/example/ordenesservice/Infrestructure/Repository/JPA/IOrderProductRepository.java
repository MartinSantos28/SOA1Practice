package com.example.ordenesservice.Infrestructure.Repository.JPA;

import com.example.ordenesservice.Infrestructure.Models.OrderProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProductsModel, String> {
}
