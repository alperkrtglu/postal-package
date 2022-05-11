package com.example.demo.shipping.repository;

import com.example.demo.shipping.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

//    List<Shipment> findAllById(Long id);
}
