package com.travelbooking.hotelservice.service;

import com.travelbooking.hotelservice.model.Booking;
import com.travelbooking.hotelservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveRental(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBookingById(Long bId) {
        bookingRepository.deleteById(bId);
    }
}
