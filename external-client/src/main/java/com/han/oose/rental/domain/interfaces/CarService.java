package com.han.oose.rental.domain.interfaces;

import com.han.oose.rental.data.Car;
import com.han.oose.rental.data.repositories.CarRepository;

import java.util.Optional;

public interface CarService {

    /**
     * Method to find data of a car from the database.
     * @param id The id representing the car.
     * @return Optional containing a Car data-object. Can be checked to verify if a car with the given id was available.
     */
    Optional<Car> findById(long id);

    void setCarRepository(CarRepository carRepository);

}
