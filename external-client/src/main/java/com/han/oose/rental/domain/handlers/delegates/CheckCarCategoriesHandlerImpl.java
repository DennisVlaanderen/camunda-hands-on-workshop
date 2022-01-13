package com.han.oose.rental.domain.handlers.delegates;

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
        boolean allowedToRentCar;

        Optional<Car> result = carService.findById(carId);
        Car car = result.orElse(null);
        assert car != null;
        String carCategory = car.getCategory();

        // https://stackoverflow.com/questions/15027231/java-how-to-convert-letters-in-a-string-to-a-number
        switch (userCarCat) {
            case CAR_CATEGORY_A:
                allowedToRentCar = true;
                break;
            case CAR_CATEGORY_B:
                allowedToRentCar = carCategory.equals(CAR_CATEGORY_B) || carCategory.equals(CAR_CATEGORY_C);
                break;
            case CAR_CATEGORY_C:
                allowedToRentCar = carCategory.equals(CAR_CATEGORY_C);
                break;
            default:
                allowedToRentCar = false;
        }
        return allowedToRentCar;
    }

    @Override
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
