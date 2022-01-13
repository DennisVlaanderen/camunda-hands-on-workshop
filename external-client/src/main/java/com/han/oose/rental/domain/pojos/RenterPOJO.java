package com.han.oose.rental.domain.pojos;

public class RenterPOJO {
    private boolean isVerified;
    private int age;
    private int driversLicenseAge;

    public RenterPOJO() {
    }

    public RenterPOJO(boolean isVerified, int age, int driversLicenseAge) {
        this.isVerified = isVerified;
        this.age = age;
        this.driversLicenseAge = driversLicenseAge;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDriversLicenseAge() {
        return driversLicenseAge;
    }

    public void setDriversLicenseAge(int driversLicenseAge) {
        this.driversLicenseAge = driversLicenseAge;
    }
}
