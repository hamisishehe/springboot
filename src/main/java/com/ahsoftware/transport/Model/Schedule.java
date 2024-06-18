package com.ahsoftware.transport.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule_table")
public class Schedule {

    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne
    private Route route;

    private LocalTime departureTime;
    private LocalTime arrivalTime;

}
