package com.ahsoftware.transport.Repository;



import com.ahsoftware.transport.Model.Route;
import com.ahsoftware.transport.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
