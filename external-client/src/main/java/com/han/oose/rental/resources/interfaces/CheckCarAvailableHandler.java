package com.han.oose.rental.resources.interfaces;

import com.han.oose.rental.domain.interfaces.CarService;

public interface CheckCarAvailableHandler {

    /**
     * Method to check if a car is available for rental.
     * @param carId The id representing the car.
     * @param rentPeriod Integer value of the amount of days the rental period should take.
     * @return boolean value representing availability. True = available.
     */
    boolean checkCarAvailable(int carId, int rentPeriod);

    void setCarService(CarService carService);
}
