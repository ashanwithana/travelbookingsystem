package com.travelbooking.carservice1.repository;

import com.travelbooking.carservice1.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}