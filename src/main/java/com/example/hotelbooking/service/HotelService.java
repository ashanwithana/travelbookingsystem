package com.travelbooking.hotelservice.service;

import com.travelbooking.hotelservice.model.Hotel;
import com.travelbooking.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    public void addHotelToDB(MultipartFile file, String hotelName, String location, String hotelType, String hotelDesc,
                            double pricePerPerson) throws IOException {

        Hotel hotel = new Hotel();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains("..")) {
            System.out.println("Not a valid file");
        }
        try {
            hotel.setHotelImage(Base64.getEncoder().encodeToString(file.getBytes()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        hotel.setHotelName(hotelName);
        hotel.setLocation(location);
        hotel.setHotelType(hotelType);
        hotel.setHotelDesc(hotelDesc);
        hotel.setPricePerPerson(pricePerPerson);
        hotelRepo.save(hotel);
    }
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    public Hotel getHotelById(Long carId) {
        return hotelRepo.findById(carId).orElse(null);
    }

    public List<Hotel> getRelatedHotel(String hotelType) {
        return hotelRepo.findByHotelType(hotelType);
    }
}
