package com.ahsoftware.transport.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Route_table")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate_number;
    private String start_location;
    private String end_location;
}
