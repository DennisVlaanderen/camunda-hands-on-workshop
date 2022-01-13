package com.han.oose.rental.domain.handlers.delegates;

import com.han.oose.rental.data.Car;
import com.han.oose.rental.data.Contract;
import com.han.oose.rental.domain.interfaces.CarService;
import com.han.oose.rental.resources.interfaces.CheckCarAvailableHandler;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CheckCarAvailableHandlerImpl implements CheckCarAvailableHandler {

    @Autowired
    private CarService carService;

    @Override
    public boolean checkCarAvailable(int carId, int rentPeriod) {
        Optional<Car> car = carService.findById(carId);
        boolean isAvailable = false;

        if (car.isPresent()) {
            Date rentalStartDate = Date.valueOf(LocalDate.now());
            List<Contract> contractList = car.get().getContracts();
            List<Contract> inUseContracts = contractList.stream()
                    .filter(contract -> dateIsTaken(rentalStartDate, contract, rentPeriod))
                    .collect(Collectors.toList());
            isAvailable = inUseContracts.isEmpty();
        }
        return isAvailable;
    }

    public boolean dateIsTaken(Date startDate, Contract contract, int rentPeriod) {
        Interval interval = new Interval(new DateTime(contract.getStartDate()), new DateTime(contract.getEndDate()));
        return interval.contains(new DateTime(startDate)) || interval.contains(new DateTime(startDate).plusDays(rentPeriod));
    }

    @Override
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
