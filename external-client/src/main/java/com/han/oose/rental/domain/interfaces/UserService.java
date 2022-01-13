package com.han.oose.rental.domain.interfaces;

import com.han.oose.rental.data.User;
import com.han.oose.rental.data.repositories.UserRepository;

import java.util.Optional;

public interface UserService {

    /**
     * Method to find a user from the database.
     * @param id The id representing the user.
     * @return Optional containing a User data-object. Can be checked to verify if a user was found with the given id.
     */
    Optional<User> findById(long id);

    void setUserRepository(UserRepository userRepository);

    /**
     * Method to update the data stored in a User object to the database.
     * @param user User object containing all information of a user that needs to be updated.
     */
    void update(User user);
}
