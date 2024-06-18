package com.ahsoftware.transport.controller.user;


import com.ahsoftware.transport.Service.BusService;
import com.ahsoftware.transport.Service.RouteService;
import com.ahsoftware.transport.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("userdashboard")
public class Dashboard {
    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user/dashboard")
    public String showAdminDashboard(Model model) {
        long totalBuses = busService.getAllBuses().size();
        model.addAttribute("totalBuses", totalBuses);

        long totalroutes = routeService.getAllRoutes().size();

        model.addAttribute("totalroutes", totalroutes);


        return "user/home"; // This should match the name of your Thymeleaf template for the admin dashboard
    }
}
