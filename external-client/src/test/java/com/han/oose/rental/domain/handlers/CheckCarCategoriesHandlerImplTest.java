package com.han.oose.rental.domain.handlers;

import com.han.oose.rental.data.Car;
import com.han.oose.rental.data.repositories.CarRepository;
import com.han.oose.rental.domain.interfaces.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CheckCarCategoriesHandlerImplTest {

    private CheckCarCategoriesHandlerImpl sut;

    @BeforeEach
    public void setup(){
        sut = new CheckCarCategoriesHandlerImpl();
    }

    @Test
    public void whenEligibleForAReturnTrue() {
        long CAR_ID = 1;
        String USER_CAR_CAT = "A";

        Car car = mock(Car.class);
        Optional<Car> optionalCar = Optional.of(car);
        CarService carService = mock(CarService.class);
        CarRepository carRepository = mock(CarRepository.class);
        carService.setCarRepository(carRepository);
        sut.setCarService(carService);

        doReturn(optionalCar).when(carService).findById(CAR_ID);
        when(Objects.requireNonNull(car).getCategory()).thenReturn(USER_CAR_CAT);

        assertTrue(sut.isAllowedToRentCar(CAR_ID, USER_CAR_CAT));
    }

    @Test
    public void whenEligibleForBReturnTrue() {
        long CAR_ID = 1;
        String USER_CAR_CAT = "B";

        Car car = mock(Car.class);
        Optional<Car> optionalCar = Optional.of(car);
        CarService carService = mock(CarService.class);
        CarRepository carRepository = mock(CarRepository.class);
        carService.setCarRepository(carRepository);
        sut.setCarService(carService);

        doReturn(optionalCar).when(carService).findById(CAR_ID);
        when(Objects.requireNonNull(car).getCategory()).thenReturn(USER_CAR_CAT);

        assertTrue(sut.isAllowedToRentCar(CAR_ID, USER_CAR_CAT));
    }

    @Test
    public void whenEligibleForCReturnTrue() {
        long CAR_ID = 1;
        String USER_CAR_CAT = "C";

        Car car = mock(Car.class);
        Optional<Car> optionalCar = Optional.of(car);
        CarService carService = mock(CarService.class);
        CarRepository carRepository = mock(CarRepository.class);
        carService.setCarRepository(carRepository);
        sut.setCarService(carService);

        doReturn(optionalCar).when(carService).findById(CAR_ID);
        when(Objects.requireNonNull(car).getCategory()).thenReturn(USER_CAR_CAT);

        assertTrue(sut.isAllowedToRentCar(CAR_ID, USER_CAR_CAT));
    }

    @Test
    public void whenNotEligebleReturnFalse() {
        long CAR_ID = 1;
        String USER_CAR_CAT = "Bullshit";

        Car car = mock(Car.class);
        Optional<Car> optionalCar = Optional.of(car);
        CarService carService = mock(CarService.class);
        CarRepository carRepository = mock(CarRepository.class);
        carService.setCarRepository(carRepository);
        sut.setCarService(carService);

        doReturn(optionalCar).when(carService).findById(CAR_ID);
        when(Objects.requireNonNull(car).getCategory()).thenReturn(USER_CAR_CAT);

        assertFalse(sut.isAllowedToRentCar(CAR_ID, USER_CAR_CAT));
    }
}
