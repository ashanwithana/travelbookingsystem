package com.example.hotelbooking.controller;

import com.example.hotelbooking.model.HotelDetails;
import com.example.hotelbooking.model.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HotelController {
    @Autowired private HotelService service;

    @GetMapping("/hotels")
    public String showHotelList(Model model){
        List<HotelDetails> listHotels = service.listAll();
        model.addAttribute("listHotels",listHotels);
        return "hotels";
    }
//    @GetMapping("/hotels/single-page")
//    public String showSingleHotels(Model model){
//
//    }
}
