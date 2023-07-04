package com.travelbooking.carservice1.repository;

import com.travelbooking.carservice1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByNoOfPerson(int passengerCount);
}
