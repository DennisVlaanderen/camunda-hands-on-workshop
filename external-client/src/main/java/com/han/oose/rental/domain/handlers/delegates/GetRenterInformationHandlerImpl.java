package com.han.oose.rental.domain.handlers.delegates;

import com.han.oose.rental.data.User;
import com.han.oose.rental.domain.interfaces.UserService;
import com.han.oose.rental.domain.pojos.RenterPOJO;
import com.han.oose.rental.resources.interfaces.GetRenterInformationHandler;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetRenterInformationHandlerImpl implements GetRenterInformationHandler {

    @Autowired
    private UserService userService;

    @Override
    public RenterPOJO getRenterInfo(int userId) {
        Optional<User> user = userService.findById(userId);
        RenterPOJO renterPOJO = new RenterPOJO();
        if(user.isPresent()) {
            boolean isUserVerified = user.get().isVerified();

            renterPOJO.setVerified(isUserVerified);
            if (isUserVerified) {
                Long dateOfBirth = user.get().getDateOfBirth();
                Long driversLicenseObtained = user.get().getDriversLicenseObtained();
                renterPOJO.setAge(getYearDifference(dateOfBirth));
                renterPOJO.setDriversLicenseAge(getYearDifference(driversLicenseObtained));
            }
        }
        return renterPOJO;
    }

    private int getYearDifference(Long date) {
        Interval interval = new Interval(new DateTime(date), DateTime.now());
        return interval.toPeriod().getYears();
    }

    @Override
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
