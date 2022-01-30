package com.han.oose.rental.domain.handlers;

import com.han.oose.rental.data.Car;
import com.han.oose.rental.domain.interfaces.CarService;
import com.han.oose.rental.resources.interfaces.CheckCarCategoriesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CheckCarCategoriesHandlerImpl implements CheckCarCategoriesHandler {
    private static final String CAR_CATEGORY_A = "A";
    private static final String CAR_CATEGORY_B = "B";
    private static final String CAR_CATEGORY_C = "C";

    @Autowired
    CarService carService;

    @Override
    public boolean isAllowedToRentCar(Long carId, String userCarCat) {
        boolean allowedToRentCar = false;

        Optional<Car> result = carService.findById(carId);
        Car car = result.orElse(null);
        if (car != null) {
            String carCategory = car.getCategory();

            // Determine rental categories based on a user's allowed categories compared to the car requested
            if (CAR_CATEGORY_A.equals(userCarCat)) {
                allowedToRentCar = true;
            } else if (CAR_CATEGORY_B.equals(userCarCat)) {
                allowedToRentCar = carCategory.equals(CAR_CATEGORY_B) || carCategory.equals(CAR_CATEGORY_C);
            } else if (CAR_CATEGORY_C.equals(userCarCat)) {
                allowedToRentCar = carCategory.equals(CAR_CATEGORY_C);
            }
        }
        return allowedToRentCar;
    }

    @Override
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
