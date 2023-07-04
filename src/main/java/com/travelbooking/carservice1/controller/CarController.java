package com.travelbooking.carservice1.controller;

import com.travelbooking.carservice1.model.Car;
import com.travelbooking.carservice1.repository.CarRepository;
import com.travelbooking.carservice1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "cars";
    }


    @PostMapping("/addCar")
    public String addCar(@RequestParam("file") MultipartFile file,
                         @RequestParam("carName") String carName,
                         @RequestParam("carNumber") String carNumber,
                         @RequestParam("carType") String carType,
                         @RequestParam("noOfPassengers") int noOfPassengers,
                         @RequestParam("pricePerDay") double pricePerDay,
                         Model model) throws IOException {

        carService.addCarToDB(file, carName, carNumber, carType, noOfPassengers, pricePerDay);
        model.addAttribute("successMessage", "Car added successfully");
        return "redirect:/cars/add";
    }
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("car", new Car());
        return "AddForm";
    }

    @GetMapping("/{carId}")
    public String getCarDetails(@PathVariable("carId") Long carId, Model model) {
        Car car = carService.getCarById(carId);
        model.addAttribute("car", car);

        // Get related cars based on passenger count
        int passengerCount = car.getNoOfPerson();
        List<Car> relatedCars = carService.getRelatedCars(passengerCount);
        model.addAttribute("relatedCars", relatedCars);

        return "single";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam("carId") Long carId,
                           @RequestParam("totalPrice") double totalPrice,
                           @RequestParam("days") int days,
                           Model model) {
        // Get the car details based on the carId
        Car car = carService.getCarById(carId);

        // Calculate the total based on price per day and number of days
        double calculatedTotalPrice = car.getPricePerDay() * days;

        // Pass the car details and calculated values to the view
        model.addAttribute("car", car);
        model.addAttribute("totalPrice", calculatedTotalPrice);
        model.addAttribute("days", days);

        return "checkout";
    }

}