package com.han.oose.rental.resources.interfaces;

import com.han.oose.rental.domain.interfaces.UserService;
import com.han.oose.rental.domain.pojos.RenterPOJO;

public interface GetRenterInformationHandler {

    /**
     * A method to get all available data of a user from the database.
     * @param userId The id representing the user.
     * @return A data-object with all available fields for a specific user filled.
     */
    RenterPOJO getRenterInfo(int userId);

    void setUserService(UserService userService);
}
