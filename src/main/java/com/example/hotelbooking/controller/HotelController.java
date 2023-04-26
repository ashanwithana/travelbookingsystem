package com.example.hotelbooking.controller;

import com.example.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HotelController {
    @Autowired private HotelRepository repo;
}
