package com.example.demo.shipping.controller;

import com.example.demo.shipping.dto.ShipmentDTO;
import com.example.demo.shipping.dto.mapper.ShipmentMapper;
import com.example.demo.shipping.entity.Postman;
import com.example.demo.shipping.entity.Shipment;
import com.example.demo.shipping.repository.PostmanRepository;
import com.example.demo.shipping.security.AuthenticationService;
import com.example.demo.shipping.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipment")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final AuthenticationService authenticationService;
    private final PostmanRepository postmanRepository;

    @GetMapping("/postman")
    @PreAuthorize("hasAuthority('POSTMAN')")
    public String retrieve(Model model) {
        Postman postman = authenticationService.postman();
        List<Shipment> shipmentList = shipmentService.retrieveShipmentsByPostmanId(postman.getId());

        model.addAttribute("message", postman.fullName());
        model.addAttribute("shipmentList", shipmentList);
        return "postman";
    }

    @GetMapping("/sender")
    @PreAuthorize("hasAuthority('SENDER')")
    public String sender(Model model) {
        model.addAttribute("shipmentDTO", new ShipmentDTO());
        return "sender";
    }

    @PostMapping("/sender")
    @PreAuthorize("hasAuthority('SENDER')")
    public String createShipment(Model model, @ModelAttribute ShipmentDTO shipmentDTO) {
        Long postmanId = postmanRepository.findAll().stream().findAny().get().getId();
        Long senderId = authenticationService.sender().getId();

        shipmentService.save(ShipmentMapper.INSTANCE.toEntity(shipmentDTO, postmanId, senderId));
        return "created";
    }
}
