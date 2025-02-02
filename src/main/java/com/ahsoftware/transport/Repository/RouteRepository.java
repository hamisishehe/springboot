package com.ahsoftware.transport.Repository;


import com.ahsoftware.transport.Model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface RouteRepository extends JpaRepository<Route, Long> {


}
