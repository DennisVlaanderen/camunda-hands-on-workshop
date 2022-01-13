package com.han.oose.rental.resources.interfaces;

import com.han.oose.rental.domain.interfaces.UserService;

public interface SaveRenterInformationHandler {

    /**
     * Method to store the data of a user into the database.
     * @param userId The id representing the user.
     * @param birthday The birthday of the user in Epoch-time.
     * @param driversLicenseObtained The date of obtaining a driver's license in Epoch-time.
     */
    void saveRenterInformation(int userId, Long birthday, Long driversLicenseObtained);

    void setUserService(UserService userService);
}
