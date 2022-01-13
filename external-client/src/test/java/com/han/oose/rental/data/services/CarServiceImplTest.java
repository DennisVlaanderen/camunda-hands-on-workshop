package com.han.oose.rental.data.services;

import com.han.oose.rental.data.Car;
import com.han.oose.rental.data.Contract;
import com.han.oose.rental.data.repositories.CarRepository;
import com.han.oose.rental.domain.interfaces.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarServiceImplTest {

    private final CarService sut = new CarServiceImpl();
    private Car car1;

    @BeforeEach
    public void setup() {
        CarRepository carRepository = mock(CarRepository.class);
        sut.setCarRepository(carRepository);

        List<Contract> contracts = new ArrayList<Contract>();
        contracts.add(new Contract());
        final int CAR_ID = 1;
        car1 = new Car(CAR_ID, "A", "JT487Z", 80, contracts);

        when(sut.findById(CAR_ID)).thenReturn(Optional.of(car1));
    }

    @Test
    void findMockedCarById(){

        Optional<Car> cars = sut.findById(car1.getId());
        Car car2 = cars.get();

        assertEquals(car1.getId(), car2.getId());
    }
}
