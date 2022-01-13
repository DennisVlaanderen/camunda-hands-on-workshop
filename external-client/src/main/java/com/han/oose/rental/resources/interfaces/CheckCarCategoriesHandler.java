package com.han.oose.rental.resources.interfaces;

import com.han.oose.rental.domain.interfaces.CarService;

public interface CheckCarCategoriesHandler {

    /**
     * Method to determine if a user is allowed to rent a specific car.
     * @param carId The id representing the car.
     * @param userCarCat A String representing the highest category a user is allowed to rent.
     * @return boolean value representing the ability to rent a specific car. True = allowed.
     */
    boolean isAllowedToRentCar(Long carId, String userCarCat);

    void setCarService(CarService carService);

}
