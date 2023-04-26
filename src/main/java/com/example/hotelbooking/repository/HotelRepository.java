package com.example.hotelbooking.repository;

import com.example.hotelbooking.model.HotelDetails;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<HotelDetails, Integer> {
}
