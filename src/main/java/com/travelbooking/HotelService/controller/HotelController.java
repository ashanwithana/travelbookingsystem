package com.travelbooking.hotelservice.controller;

import com.travelbooking.hotelservice.model.Hotel;
import com.travelbooking.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String getHotels(Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotel";
    }
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "addHotel";
    }
    @PostMapping("/addHotel")
    public String addHotel(@RequestParam("file") MultipartFile file,
                         @RequestParam("hotelName") String hotelName,
                         @RequestParam("location") String location,
                         @RequestParam("hotelType") String hotelType,
                         @RequestParam("desc") String desc,
                         @RequestParam("pricePerPerson") double pricePerPerson,
                         Model model) throws IOException {

        hotelService.addHotelToDB(file, hotelName, location, hotelType, desc, pricePerPerson);
        model.addAttribute("successMessage", "Car added successfully");
        return "redirect:/hotels/add";
    }

    @GetMapping("/{hId}")
    public String getHotelDetails(@PathVariable("hId") Long hId, Model model) {
        Hotel hotel = hotelService.getHotelById(hId);
        model.addAttribute("hotel", hotel);

        String hotelType = hotel.getHotelType();

        List<Hotel> relatedHotels = hotelService.getRelatedHotel(hotelType);
        model.addAttribute("relatedHotels", relatedHotels);

        return "single-hotel";
    }

    @PostMapping("/checkout")
    public String checkoutHotel(@RequestParam("hotelId") Long hotelId,
                                @RequestParam("arrivalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arrivalDate,
                                @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
                                @RequestParam("noOfPerson") int noOfPerson,
                                @RequestParam("totalPrice") double totalPrice,
                                @RequestParam("hotelName") String hotelName,
                                @RequestParam("hotelType") String hotelType,
                                @RequestParam("pricePerPerson") double pricePerPerson,
                                Model model) {

        // Get the hotel details based on the hotelId
        Hotel hotel = hotelService.getHotelById(hotelId);

        // Calculate the number of days between arrival and departure
        long numberOfDays = ChronoUnit.DAYS.between(arrivalDate, departureDate);

        // Calculate the total based on price per person, number of persons, and number of days
        double calculatedTotalPrice = pricePerPerson * noOfPerson * numberOfDays;

        // Set the necessary attributes in the model
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("arrivalDate", arrivalDate);
        model.addAttribute("departureDate", departureDate);
        model.addAttribute("noOfPerson", noOfPerson);
        model.addAttribute("totalPrice", calculatedTotalPrice);
        model.addAttribute("hotelName", hotelName);
        model.addAttribute("hotelType", hotelType);
        model.addAttribute("pricePerPerson", pricePerPerson);
        model.addAttribute("numberOfDays", numberOfDays);

        // Return the checkout.html view
        return "checkout";
    }

}
