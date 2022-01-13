package com.han.oose.rental.resources.variables;

import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

public class CarRentalProcessVariables {
    private ExternalTask externalTask;
    private VariableMap variables;

    public CarRentalProcessVariables(ExternalTask externalTask) {
        this.externalTask = externalTask;
        this.variables = Variables.createVariables();
    }

    public CarRentalProcessVariables() {
    }

    public VariableMap getVariables(){
        return variables;
    }

    public int getUserId() {
        return (int) externalTask.getVariable(ProcessConstants.USER_ID);
    }

    public void setUserId(int userId) {
        variables.put(ProcessConstants.USER_ID, userId);
    }

    public String getEmail() {
        return (String) externalTask.getVariable(ProcessConstants.EMAIL);
    }

    public void setEmail(String email) {
        variables.put(ProcessConstants.EMAIL, email);
    }

    public int getCarId() {
        return (int) externalTask.getVariable(ProcessConstants.CAR_ID);
    }

    public void setCarId(int carId) {
        variables.put(ProcessConstants.CAR_ID, carId);
    }

    public int getRentalPeriod() {
        return (int) externalTask.getVariable(ProcessConstants.RENTAL_PERIOD);
    }

    public void setRentalPeriod(int rentalPeriod) {
        variables.put(ProcessConstants.RENTAL_PERIOD, rentalPeriod);
    }

    public boolean getUserIsVerified() {
        return (boolean) externalTask.getVariable(ProcessConstants.USER_IS_VERIFIED);
    }

    public void setUserIsVerified(boolean userIsVerified) {
        variables.put(ProcessConstants.USER_IS_VERIFIED, userIsVerified);
    }

    public int getAge() {
        return (int) externalTask.getVariable(ProcessConstants.AGE);
    }

    public void setAge(int age) {
        variables.put(ProcessConstants.AGE, age);
    }

    public int getDriverLicenseAge() {
        return (int) externalTask.getVariable(ProcessConstants.DRIVER_LICENSE_AGE);
    }

    public void setDriverLicenseAge(int driverLicenseAge) {
        variables.put(ProcessConstants.DRIVER_LICENSE_AGE, driverLicenseAge);
    }

    public int getUserMaxCategoryId() {
        return (int) externalTask.getVariable(ProcessConstants.USER_MAX_CATEGORY_ID);
    }

    public void setUserMaxCategoryId(int userMaxCategoryId) {
        variables.put(ProcessConstants.USER_MAX_CATEGORY_ID, userMaxCategoryId);
    }

    public boolean userIsAllowedToRentCar() {
        return (boolean) externalTask.getVariable(ProcessConstants.USER_IS_ALLOWED_TO_RENT_CAR);
    }

    public void setUserIsAllowedToRentCar(boolean userIsAllowedToRentCar) {
        variables.put(ProcessConstants.USER_IS_ALLOWED_TO_RENT_CAR, userIsAllowedToRentCar);
    }

    public String getUserCategory() {
        return (String) externalTask.getVariable(ProcessConstants.CAR_CATEGORY);
    }

    public void setUserCategory(String userCategory) {
        variables.put(ProcessConstants.CAR_CATEGORY, userCategory);
    }

    public String getDecidedCategory() {
        return (String) externalTask.getVariable(ProcessConstants.DECIDED_CATEGORY);
    }

    public void setDecidedCategory(String decidedCategory) {
        variables.put(ProcessConstants.DECIDED_CATEGORY, decidedCategory);
    }

    public boolean isAvailable() {
        return (boolean) externalTask.getVariable(ProcessConstants.CAR_IS_AVAILABLE);
    }

    public void setCarIsAvailable(boolean carIsAvailanle) {
        variables.put(ProcessConstants.CAR_IS_AVAILABLE, carIsAvailanle);
    }

    public String getLicensePlate() {
        return (String) externalTask.getVariable(ProcessConstants.LICENSE_PLATE);
    }

    public void setLicensePlate(String licensePlate) {
        variables.put(ProcessConstants.LICENSE_PLATE, licensePlate);
    }

    public float getPriceTotal() {
        return (float) externalTask.getVariable(ProcessConstants.PRICE_TOTAL);
    }

    public void setPriceTotal(float priceTotal) {
        variables.put(ProcessConstants.PRICE_TOTAL, priceTotal);
    }

    public String getImgUrl() {
        return (String) externalTask.getVariable(ProcessConstants.IMG_URL);
    }

    public void setImgUrl(String imgUrl) {
        variables.put(ProcessConstants.IMG_URL, imgUrl);
    }

    public Long getBirthday() {
        java.util.Date date = (java.util.Date) externalTask.getVariable(ProcessConstants.BIRTHDAY);
        return date.getTime();
    }

    public void setBirthday(Long birthday) {
        variables.put(ProcessConstants.BIRTHDAY, birthday);
    }

    public Long getDriversLicenseObtained() {
        java.util.Date date = (java.util.Date) externalTask.getVariable(ProcessConstants.DRIVERS_LICENSE_OBTAINED);
        return date.getTime();
    }

    public void setDriversLicenseObtained(Long driversLicenseObtained) {
        variables.put(ProcessConstants.DRIVERS_LICENSE_OBTAINED, driversLicenseObtained);
    }
}