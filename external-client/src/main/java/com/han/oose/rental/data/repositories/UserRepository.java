package com.han.oose.rental.data.repositories;

import com.han.oose.rental.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Object> {

}
