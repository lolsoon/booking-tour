package com.example.bookingTour.repository;


import com.example.bookingTour.entity.ERole;
import com.example.bookingTour.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}