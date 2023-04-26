package com.example.hotelbooking.model;

import com.example.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired private HotelRepository repo;

    public List<HotelDetails> listAll(){
        return (List<HotelDetails>) repo.findAll();
    }
}
