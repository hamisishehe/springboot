package com.ahsoftware.transport.controller.admin;



import com.ahsoftware.transport.Model.Bus;
import com.ahsoftware.transport.Model.Route;
import com.ahsoftware.transport.Model.Schedule;
import com.ahsoftware.transport.Service.RouteService;
import com.ahsoftware.transport.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("adminScheduleController")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private RouteService routeService;

    @GetMapping("admin/viewschedule")
    public String viewSchedules(Model model) {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        model.addAttribute("schedules", schedules);
        return "admin/view-schedule";
    }

    @GetMapping("admin/schedule")
    public String addScheduleForm(Model model) {
        List<Route> routes = routeService.getAllRoutes();
        model.addAttribute("routes", routes);
        return "admin/schedule";
    }

    @PostMapping("admin/schedule")
    public String addSchedule(@ModelAttribute("schedule") Schedule schedule, Model model) {
        scheduleService.saveSchedule(schedule); // Save the schedule using the service
        model.addAttribute("successMessage", "Schedule added successfully!"); // Add success message
        return "redirect:/admin/viewschedule"; // Redirect to view all schedules page
    }

    // Additional handler methods for viewing schedules, if needed



}

