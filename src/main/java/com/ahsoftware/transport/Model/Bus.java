package com.ahsoftware.transport.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "BusTable")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number_plate;
    private int capacity;

}
