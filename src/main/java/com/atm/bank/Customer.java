package com.atm.bank;

import com.github.javafaker.Faker;

import java.sql.Date;

public class Customer {
    /*
     *****************************************
     * Libraries / Classes
     *****************************************
     */
    Faker faker = new Faker();

    /*
     *****************************************
     * Private Fields / Data
     *****************************************
     */
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String countryOfBirth;
    private String address;
    private String socialSecurityNumber;
    private String phone;
    private String username;
    private String password;
    private double currentAmount;
    private boolean isActive;
    private int pin;
    private String cardNumber;
    private String sortCode;
    private int accountNumber;

    /*
     **********
     * Getters
     **********
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
            return lastName;
    }

    public Date getDateOfBirth() {
            return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getPin() {
        return pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /*
     **********
     * Setters
     **********
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /*
     *****************************************
     * Private Fields / Data
     *****************************************
     */
}
