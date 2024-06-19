package com.ahsoftware.transport.Repository;



import com.ahsoftware.transport.Model.Route;
import com.ahsoftware.transport.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s " +
            "JOIN s.route r " +
            "WHERE r.start_location = :startLocation " +
            "AND r.end_location = :endLocation")
    List<Schedule> findByRouteStartLocationAndRouteEndLocation(
            @Param("startLocation") String startLocation,
            @Param("endLocation") String endLocation);
}
