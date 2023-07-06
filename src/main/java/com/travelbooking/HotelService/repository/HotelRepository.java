package com.travelbooking.hotelservice.repository;

import com.travelbooking.hotelservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByHotelType(String hotelType);
}
