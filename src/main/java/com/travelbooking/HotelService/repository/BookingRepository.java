package com.travelbooking.hotelservice.repository;

import com.travelbooking.hotelservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
