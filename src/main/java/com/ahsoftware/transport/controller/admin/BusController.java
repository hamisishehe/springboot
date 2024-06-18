package com.ahsoftware.transport.controller.admin;



import com.ahsoftware.transport.Model.Bus;
import com.ahsoftware.transport.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("adminBusController")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/admin/viewbus")
    public String viewBuses(Model model) {
        List<Bus> buses = busService.getAllBuses();
        model.addAttribute("buses", buses);
        return "admin/view-bus";
    }

    @GetMapping("admin/addbus")
    @ResponseBody
    public String addBusForm(Model model) {

        return "admin/add-bus";
    }

    @PostMapping("admin/savebus")
    public String addBus(@ModelAttribute Bus bus, RedirectAttributes redirectAttributes) {
        busService.saveBus(bus);
        redirectAttributes.addFlashAttribute("successMessage", "Bus added successfully!");
        return "redirect:/admin/addbus";
    }

    @DeleteMapping("/admin/deletebus/{id}")
    public String deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return "redirect:/admin/viewbus";
    }

    @GetMapping("/admin/editbus/{id}")
    public String editBusForm(@PathVariable Long id, Model model) {
        Bus bus = busService.getBusById(id);
        model.addAttribute("bus", bus);
        return "admin/edit-bus";
    }

    @PostMapping("/admin/updatebus")
    public String updateBus(@ModelAttribute Bus bus, RedirectAttributes redirectAttributes) {
        busService.saveBus(bus);
        redirectAttributes.addFlashAttribute("successMessage", "Bus updated successfully!");
        return "redirect:/admin/viewbus";
    }
}
