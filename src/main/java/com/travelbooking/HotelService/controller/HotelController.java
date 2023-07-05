package com.travelbooking.HotelService.controller;

import com.travelbooking.HotelService.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;
}
