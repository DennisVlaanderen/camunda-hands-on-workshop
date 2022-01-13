package com.han.oose.rental.domain.handlers.delegates;

import com.han.oose.rental.data.User;
import com.han.oose.rental.domain.interfaces.UserService;
import com.han.oose.rental.resources.interfaces.SaveRenterInformationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaveRenterInformationHandlerImpl implements SaveRenterInformationHandler {

    @Autowired
    private UserService userService;

    @Override
    public void saveRenterInformation(int userId, Long birthday, Long driversLicenseObtained) {
        Optional<User> userOpt = userService.findById(userId);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setDateOfBirth(birthday);
            user.setDriversLicenseObtained(driversLicenseObtained);
            user.setVerified(true);
            userService.update(user);
        }
    }

    @Override
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
