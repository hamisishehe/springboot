package com.ahsoftware.transport.controller.admin;


import com.ahsoftware.transport.Model.Bus;
import com.ahsoftware.transport.Model.User;
import com.ahsoftware.transport.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("adminUserController")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/viewusers")
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/admin/view-users";
    }

    @GetMapping("/admin/adduser")
    public String addUserForm(Model model) {
        return "/admin/add-user";
    }



    @PostMapping("/admin/saveuser")
    public String saveUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        try {
            userService.saveUser(user); // Delegate saving user to UserService
            redirectAttributes.addFlashAttribute("success", "User created successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to create user account. Please try again.");
        }
        return "redirect:/admin/adduser"; // Redirect back to the add user form
    }

    @RequestMapping(value = "/admin/deleteuser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/viewusers";  // Redirect to user list page
    }



}
