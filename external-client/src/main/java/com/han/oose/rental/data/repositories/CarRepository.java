package com.han.oose.rental.data.repositories;

import com.han.oose.rental.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Object> {

}
