package com.example.bookingTour.repository;

import com.example.bookingTour.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TourRepository extends JpaRepository<Tour, Integer>, JpaSpecificationExecutor<Tour> {
    public Tour findByMaTour(String maTour);

    public void deleteTourByMaTour(String maTour);
}
