package com.ahsoftware.transport.controller.user;


import com.ahsoftware.transport.Model.Route;
import com.ahsoftware.transport.Model.Schedule;
import com.ahsoftware.transport.Repository.ScheduleRepository;
import com.ahsoftware.transport.Service.BusService;
import com.ahsoftware.transport.Service.RouteService;
import com.ahsoftware.transport.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("findroute")
public class FindRoute {


    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private ScheduleRepository scheduleRepository;


    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user/find-route")
    public String showAdminDashboard(Model model) {
        long totalBuses = busService.getAllBuses().size();
        model.addAttribute("totalBuses", totalBuses);

        long totalroutes = routeService.getAllRoutes().size();

        model.addAttribute("totalroutes", totalroutes);


        return "user/find-route"; // This should match the name of your Thymeleaf template for the admin dashboard
    }



    @PostMapping("/user/find-route")
    public String searchRoutes(@RequestParam("start_location") String startLocation,
                               @RequestParam("end_location") String endLocation,
                               Model model) {
        List<Schedule> schedules = scheduleRepository.findByRouteStartLocationAndRouteEndLocation(startLocation, endLocation);
        if (schedules.isEmpty()) {
            model.addAttribute("message", "No routes found for the given locations.");
            return "user/find-route";
        } else {
            model.addAttribute("schedules", schedules);
            return "user/find-route";
        }


    }



}
