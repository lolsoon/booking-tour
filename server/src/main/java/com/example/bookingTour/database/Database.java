package com.example.bookingTour.database;

import com.example.bookingTour.entity.User;
import com.example.bookingTour.entity.UserStatus;
import com.example.bookingTour.repository.RoleRepository;
import com.example.bookingTour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Database {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
            // Check if any users exist in the database
            if (userRepository.count() == 0) {
                // Create the admin user
                User admin = new User();
                admin.setFirstName("admin");
                admin.setLastName("admin");
                admin.setUserName("admintrator");
                admin.setEmail("admintrator@gmail.com");
                admin.setRole("Admin");
                admin.setStatus(UserStatus.ACTIVE);
                admin.setPassword(encoder.encode("admin123"));

//                // Create the ROLE_ADMIN role if it doesn't exist
//                Role adminRole = roleRepository.findByName(ERole.ADMIN)
//                        .orElseGet(() -> {
//                            Role role = new Role();
//                            role.setName(ERole.ADMIN);
//                            return roleRepository.save(role);
//                        });
//
//                // Assign the ROLE_ADMIN role to the admin user
//                Set<Role> roles = new HashSet<>();
//                roles.add(adminRole);
//                admin.setRoles(roles);

                // Save the admin user
                userRepository.save(admin);
            }
//            else {
//                // Update the password of the existing admin user
//                User admin = userRepository.findByEmail("hanhhanoi1999@gmail.com");
//                admin.setPassword(encoder.encode("123456"));
//                userRepository.save(admin);
//            }
        };
    }
}