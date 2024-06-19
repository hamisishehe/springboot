package com.ahsoftware.transport.controller.admin;


import com.ahsoftware.transport.Model.Bus;
import com.ahsoftware.transport.Model.Route;
import com.ahsoftware.transport.Model.Schedule;
import com.ahsoftware.transport.Service.BusService;
import com.ahsoftware.transport.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("adminRouteController")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private BusService busService;

    @GetMapping("admin/viewroute")
    public String viewRoutes(Model model) {
        List<Route> routes = routeService.getAllRoutes();
        model.addAttribute("routes", routes);
        return "admin/view-route";
    }

    @GetMapping("admin/addroute")
    public String addRouteForm(Model model) {
        List<Bus> buses = busService.getAllBuses();
        model.addAttribute("buses", buses);
        return "admin/add-route";
    }

    @PostMapping("admin/addroute")
    public String addRoute(@ModelAttribute Route route, RedirectAttributes redirectAttributes, Model model) {
        routeService.saveRoute(route);
        List<Bus> buses = busService.getAllBuses();
        model.addAttribute("buses", buses);

        redirectAttributes.addFlashAttribute("successMessage", "Route added successfully!");
        return "redirect:addroute";
    }

    @DeleteMapping("/admin/deleteroute/{id}")
    public String deleteBus(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return "redirect:/admin/viewroute";
    }

    @GetMapping("/admin/editroute/{id}")
    public String editRouteForm(@PathVariable Long id, Model model) {
        Route route = routeService.getRouteById(id);
        List<Bus> buses = busService.getAllBuses();
        model.addAttribute("route", route);
        model.addAttribute("buses", buses);
        return "admin/edit-route";
    }

    @PostMapping("/admin/updateroute")
    public String updateRoute(@ModelAttribute Route route, RedirectAttributes redirectAttributes) {
        routeService.saveRoute(route);
        redirectAttributes.addFlashAttribute("successMessage", "Route updated successfully!");
        return "redirect:/admin/viewroute";
    }


//    @PostMapping("/find")
//    public String findRoutes(@RequestParam("start_location") String startLocation,
//                             @RequestParam("end_location") String endLocation,
//                             Model model) {
//        List<Schedule> schedules = routeService.findSchedulesByLocations(startLocation, endLocation);
//        model.addAttribute("schedules", schedules);
//        model.addAttribute("startLocation", startLocation);
//        model.addAttribute("endLocation", endLocation);
//        return "find-results"; // Assuming find-results.html is your template to display search results
//    }





}

