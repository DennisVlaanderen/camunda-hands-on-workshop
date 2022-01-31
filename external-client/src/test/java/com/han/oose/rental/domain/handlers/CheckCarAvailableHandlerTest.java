package com.han.oose.rental.domain.handlers;

import com.han.oose.rental.data.Car;
import com.han.oose.rental.data.Contract;
import com.han.oose.rental.domain.interfaces.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CheckCarAvailableHandlerTest {

    private CheckCarAvailableHandlerImpl sut;

    @BeforeEach
    public void setup(){
        sut = new CheckCarAvailableHandlerImpl();
    }

    @Test
    public void whenCheckCarAvailableCalledWithAvailableCarThenTrueReturned() {
        int CARID = 2;
        int RENTPERIOD = 8;

        CarService carService = mock(CarService.class);
        sut.setCarService(carService);
        Car car = mock(Car.class);
        List<Contract> emptyList = new ArrayList<>();

        when(carService.findById(CARID)).thenReturn(Optional.of(car));
        when(car.getContracts()).thenReturn(emptyList);

        assertTrue(sut.checkCarAvailable(CARID, RENTPERIOD));
    }

    @Test
    public void whenDateIsNotTakenReturnFalse() {
        Date STARTDATE = new Date(2021, 12, 10);
        int RENTPERIOD = 8;

        Contract contract = mock(Contract.class);

        when(contract.getStartDate()).thenReturn(new Date(2021, 12, 1));
        when(contract.getEndDate()).thenReturn(new Date(2021, 12, 8));

        assertFalse(sut.dateIsTaken(STARTDATE, contract, RENTPERIOD));
    }

    @Test
    public void whenDateisIsTakenReturnTrue() {
        Date STARTDATE = new Date(2021, 12, 5);
        int RENTPERIOD = 8;

        Contract contract = mock(Contract.class);

        when(contract.getStartDate()).thenReturn(new Date(2021, 12, 1));
        when(contract.getEndDate()).thenReturn(new Date(2021, 12, 8));

        assertTrue(sut.dateIsTaken(STARTDATE, contract, RENTPERIOD));
    }
}
