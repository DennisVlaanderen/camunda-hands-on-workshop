package com.han.oose.rental.data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mail;
    private String password;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "drivers_license_obtained")
    private Date driversLicenseObtained;

    @Column(name = "is_verified")
    private boolean isVerified;

    @OneToMany(mappedBy = "user")
    private List<Contract> contracts;

    public User() {
    }

    /**
     * Constructor to create a new User object. These objects should not be created by manually inserting parameters.
     * Doing so will risk overwriting database records with faulty data. Manual creating can be done for testing purposes.
     * @param id Integer parameter representing a unique identifier tied to a specific user.
     * @param mail String parameter representing a User's e-mail.
     * @param password String parameter representing a User's hashed password. Do not pass plaintext password in here.
     * @param dateOfBirth Date parameter representing a User's birthdate. Formatted as sql.Date.
     * @param driversLicenseObtained Date parameter representing a User's date of obtaining a license. Formatted as sql.Date.
     * @param contracts List of all Contracts tied to the specific User.
     */
    public User(long id, String mail, String password, Date dateOfBirth, Date driversLicenseObtained, List<Contract> contracts) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.driversLicenseObtained = driversLicenseObtained;
        this.contracts = contracts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDateOfBirth() {
        return dateOfBirth.getTime();
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = new Date(dateOfBirth);
    }

    public Long getDriversLicenseObtained() {
        return driversLicenseObtained.getTime();
    }

    public void setDriversLicenseObtained(Long driversLicenseObtained) {
        this.driversLicenseObtained = new Date(driversLicenseObtained);
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

}
