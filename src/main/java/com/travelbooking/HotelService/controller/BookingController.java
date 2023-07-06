package com.travelbooking.hotelservice.controller;

import com.travelbooking.hotelservice.model.Booking;
import com.travelbooking.hotelservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/confirm")
public class BookingController {
    private BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public String createRental(@ModelAttribute("booking") Booking booking, RedirectAttributes redirectAttributes) {
        bookingService.saveRental(booking);
        redirectAttributes.addFlashAttribute("message", "Rental created successfully!");
        return "redirect:/hotels/checkout";
    }

    @DeleteMapping("/booking/{bId}")
    public ResponseEntity<String> deleteBooking(@PathVariable("bId") Long bId) {
        bookingService.deleteBookingById(bId);
        return ResponseEntity.ok("Booking deleted successfully");
    }

}
