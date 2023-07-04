package com.travelbooking.carservice1.service;

import com.travelbooking.carservice1.model.Car;
import com.travelbooking.carservice1.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;


@Service
public class CarService {


    @Autowired
    private CarRepository carRepo;

    public void addCarToDB(MultipartFile file, String carName, String carNumber, String carType,
                           int noOfPerson, double pricePerDay) throws IOException {

        Car car = new Car();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains("..")) {
            System.out.println("Not a valid file");
        }
        try {
            car.setCarImage(Base64.getEncoder().encodeToString(file.getBytes()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        car.setCarName(carName);
        car.setCarNumber(carNumber);
        car.setCarType(carType);
        car.setNoOfPerson(noOfPerson);
        car.setPricePerDay(pricePerDay);
        carRepo.save(car);
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }
    public Car getCarById(Long carId) {
        return carRepo.findById(carId).orElse(null);
    }

    public List<Car> getRelatedCars(int passengerCount) {
        return carRepo.findByNoOfPerson(passengerCount);
    }

}

