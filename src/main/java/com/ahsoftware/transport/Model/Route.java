package com.ahsoftware.transport.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;


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

    // Explicit getter for schedules
    @Getter
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

}
