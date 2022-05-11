package com.example.demo.shipping.service;

import com.example.demo.shipping.entity.Shipment;
import com.example.demo.shipping.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public List<Shipment> retrieve(Long id) {
        return shipmentRepository.findAll();
    }
}
