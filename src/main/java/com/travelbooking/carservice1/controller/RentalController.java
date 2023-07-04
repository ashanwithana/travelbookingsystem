package com.travelbooking.carservice1.controller;


import com.travelbooking.carservice1.model.Rental;
import com.travelbooking.carservice1.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/confirm")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public String createRental(@ModelAttribute("rental") Rental rental, RedirectAttributes redirectAttributes) {
        rentalService.saveRental(rental);
        redirectAttributes.addFlashAttribute("message", "Rental created successfully!");
        return "redirect:/cars.html";

    }

    @DeleteMapping("/rentals/{rId}")
    public String deleteRental(@PathVariable("rId") Long rId) {
        rentalService.deleteRentalById(rId);
        return "redirect:/rentals"; // Redirect to the rentals list page or any other appropriate view
    }
}
