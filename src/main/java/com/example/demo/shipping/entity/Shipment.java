package com.example.demo.shipping.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "SHIPMENT")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sender sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Postman postman;

    @OneToOne(mappedBy = "shipment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SHIPMENT_TAG",
            joinColumns = @JoinColumn(name = "SHIPMENT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID", referencedColumnName = "ID"))
    private List<Tag> tagList;

}
