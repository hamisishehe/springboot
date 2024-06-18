package com.ahsoftware.transport.seeder;

import com.ahsoftware.transport.Model.Role;
import com.ahsoftware.transport.Model.User;
import com.ahsoftware.transport.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class DatabaseSeeder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void seedDatabase() {
        if (userRepository.findAll().isEmpty()) {
            createAdmin();
            createUser();
        }
    }

    private void createAdmin() {
        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("User");
        admin.setEmail("admin@example.com");
        admin.setPassword(passwordEncoder.encode("adminpassword"));
        admin.setMobile("1234567890");
        admin.setRole(Role.ADMIN);
        admin.setEnabled(true);
        admin.setLocked(false);
        userRepository.save(admin);
    }

    private void createUser() {
        User user = new User();
        user.setFirstName("Regular");
        user.setLastName("User");
        user.setEmail("user@example.com");
        user.setPassword(passwordEncoder.encode("userpassword"));
        user.setMobile("0987654321");
        user.setRole(Role.USER);
        user.setEnabled(true);
        user.setLocked(false);
        userRepository.save(user);
    }
}
