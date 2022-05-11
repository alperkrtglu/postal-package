package com.example.demo.shipping.controller;

import com.example.demo.shipping.entity.Shipment;
import com.example.demo.shipping.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequestMapping("shipment")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping("/retrieve/{id}")
    public List<Shipment> retrieve(@PathVariable Long id) {
        return shipmentService.retrieve(id);
    }

}
