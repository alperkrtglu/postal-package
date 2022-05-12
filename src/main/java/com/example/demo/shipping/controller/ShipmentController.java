package com.example.demo.shipping.controller;

import com.example.demo.shipping.dto.ShipmentDTO;
import com.example.demo.shipping.dto.mapper.ShipmentMapper;
import com.example.demo.shipping.entity.Shipment;
import com.example.demo.shipping.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipment")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping("/postman")
    public String retrieve(Model model) {
        List<Shipment> shipmentList = shipmentService.retrieveShipmentsByPostmanId(10000L);
        model.addAttribute("message", shipmentList.iterator().next().getPostman().fullName());
        model.addAttribute("shipmentList", shipmentList);
        return "postman";
    }

    @GetMapping("/sender")
    public String sender(Model model) {
        model.addAttribute("shipmentDTO", new ShipmentDTO());
        return "sender";
    }

    @PostMapping("/sender")
    public String createShipment(Model model, @ModelAttribute ShipmentDTO shipmentDTO) {
        Long posmanId = 10000L;
        Long senderId = 10000L;

        shipmentService.save(ShipmentMapper.INSTANCE.toEntity(shipmentDTO, posmanId, senderId));
        return "created";
    }
}
