package com.han.oose.rental.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "price_day")
    private double priceDay;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Contract> contracts;

    public Car() {
    }

    /**
     * Constructor to create a new Car object. These objects should not be created by manually inserting parameters.
     * Doing so will risk overwriting database records with faulty data. Manual creating can be done for testing purposes.
     * @param id Unique identifier for a Car object.
     * @param category String value representing the category of the car.
     * @param licensePlate String value representing the license plate.
     * @param priceDay Double value representing the daily cost of rent.
     * @param contracts A list containing all Contract objects tied to the Car object.
     */
    public Car(long id, String category, String licensePlate, double priceDay, List<Contract> contracts) {
        this.id = id;
        this.category = category;
        this.licensePlate = licensePlate;
        this.priceDay = priceDay;
        this.contracts = contracts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(double priceDay) {
        this.priceDay = priceDay;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
