package com.han.oose.rental.data.services;

import com.han.oose.rental.data.Car;
import com.han.oose.rental.data.repositories.CarRepository;
import com.han.oose.rental.domain.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Optional<Car> findById(long id) {
        return carRepository.findById(id);
    }

    @Override
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

}
