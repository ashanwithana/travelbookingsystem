package com.travelbookingsystem.offers.controller;

import com.travelbookingsystem.offers.model.Offer;
import com.travelbookingsystem.offers.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public String getOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("offers", offers);
        return "offers";
    }

    @GetMapping("/{offerId}")
    public String getOfferDetails(@PathVariable("offerId") Long offerId, Model model) {
        Offer offer = offerService.getOfferById(offerId);
        model.addAttribute("offer", offer);
        return "offer-details";
    }

    @GetMapping("/add")
    public String showAddOfferForm(Model model) {
        model.addAttribute("offer", new Offer());
        return "add-offer";
    }

    @PostMapping("/add")
    public String addOffer(@ModelAttribute("offer") Offer offer) {
        offerService.createOffer(offer);
        return "redirect:/offers";
    }

    @GetMapping("/{offerId}/edit")
    public String showEditOfferForm(@PathVariable("offerId") Long offerId, Model model) {
        Offer offer = offerService.getOfferById(offerId);
        model.addAttribute("offer", offer);
        return "edit-offer";
    }

    @PostMapping("/{offerId}/edit")
    public String updateOffer(@PathVariable("offerId") Long offerId, @ModelAttribute("offer") Offer updatedOffer) {
        updatedOffer.setOfferId(offerId);
        offerService.updateOffer(updatedOffer);
        return "redirect:/offers";
    }

    @GetMapping("/{offerId}/delete")
    public String deleteOffer(@PathVariable("offerId") Long offerId) {
        offerService.deleteOfferById(offerId);
        return "redirect:/offers";
    }

    // Exception handling

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
