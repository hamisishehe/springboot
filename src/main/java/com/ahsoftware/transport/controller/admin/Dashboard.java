package com.ahsoftware.transport.controller.admin;

import com.ahsoftware.transport.Service.BusService;
import com.ahsoftware.transport.Service.RouteService;
import com.ahsoftware.transport.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("adminDashboardController")
public class Dashboard {

    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(Model model) {
        long totalBuses = busService.getAllBuses().size();
        // Add totalBuses attribute to the model
        model.addAttribute("totalBuses", totalBuses);

        long totalroutes = routeService.getAllRoutes().size();
        // Add totalBuses attribute to the model
        model.addAttribute("totalroutes", totalroutes);


        long totalusers = userService.getAllUsers().size();
        // Add totalBuses attribute to the model
        model.addAttribute("totalusers", totalusers);

        return "admin/dashboard"; // This should match the name of your Thymeleaf template for the admin dashboard
    }
}
