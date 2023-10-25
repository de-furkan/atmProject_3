package com.atm.bank;

import com.atm.utilities.ConsoleUtils;
import com.github.javafaker.Faker;
import java.sql.Date;


public class Customer {
    /*
     *****************************************
     * Libraries / Classes
     *****************************************
     */
    Faker faker = new Faker();
    ConsoleUtils console = new ConsoleUtils();

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
    private String accountNumber;

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

    public String getAccountNumber() {
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

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /*
     *****************************************
     * Generate firstName
     *****************************************
     */
    public void generateFirstName() {
        setFirstName(faker.name().firstName());
    }

    /*
     *****************************************
     * Generate lastName
     *****************************************
     */
    public void generateLastName() {
        setLastName(faker.name().lastName());
    }

    /*
     *****************************************
     * Generate dateOfBirth
     *****************************************
     */
    public void generateDateOfBirth() {
        // Generate a random date of birth between 1950 and 2000
        int year = faker.number().numberBetween(1950, 2000);
        int month = faker.number().numberBetween(1, 12);
        int day;

        // Check if the month is February
        if (month == 2) {
            // Check if it's a leap year
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                // For leap years, February has 29 days
                day = faker.number().numberBetween(1, 30);
            } else {
                // For non-leap years, February has 28 days
                day = faker.number().numberBetween(1, 29);
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // April, June, September and November have 30 days
            day = faker.number().numberBetween(1, 31);
        } else {
            // The rest of the months have 31 days
            day = faker.number().numberBetween(1, 32);
        }

        StringBuilder birthDate = new StringBuilder();
        birthDate.append(year).append("-")
                .append(String.format("%02d", month)).append("-")
                .append(String.format("%02d", day));

        setDateOfBirth(Date.valueOf(birthDate.toString()));
    }

    /*
     *****************************************
     * Generate gender
     *****************************************
     */
    public void generateGender() {
        int randomNumber = faker.number().numberBetween(1, 4);

        //choose correct case number that matches randomNumber
        //then set a gender based on the case number
        switch (randomNumber) {
            case 1:
                setGender("Male");
                break;

            case 2:
                setGender("Female");
                break;

            case 3:
                setGender("Other");
                break;
        }
    }

    /*
     *****************************************
     * Generate Country of Birth
     *****************************************
     */
    public void generateCountryOfBirth() {
        setCountryOfBirth(faker.country().name());
    }

    /*
     *****************************************
     * Generate Address
     *****************************************
     */
    public void generateAddress() {
        setAddress(faker.address().fullAddress());
    }

    /*
     *****************************************
     * Generate Social Security Number
     *****************************************
     */
    public void generateSocialSecurityNumber() {
        setSocialSecurityNumber(faker.idNumber().ssnValid());
    }

    /*
     *****************************************
     * Generate Phone Number
     *****************************************
     */
    public void generatePhoneNumber() {
        StringBuilder formatPhone = new StringBuilder();
        formatPhone
                .append("+44").append(" ")
                .append(faker.number().numberBetween(1000, 10_000)).append(" ")
                .append(faker.number().numberBetween(100_000, 1_000_000));

        setPhone(formatPhone.toString());
    }

    /*
     *****************************************
     * Generate Username
     *****************************************
     */
    public void generateUsername() {
        //Get the first 3 letters from firstName
        //Add dot between the firstName and lastName
        //Get the first 2 letters from lastName
        //Get 3 random numbers
        //Add the @ sign followed by example.com

        String firstName = getFirstName().toLowerCase();
        String lastName = getLastName().toLowerCase();
        String randomNumber = String.valueOf(faker.number().numberBetween(100, 1000));

        String firstThreeLettersFirstName = firstName.substring(0, Math.min(firstName.length(), 3));
        String firstThreeLettersLastName = lastName.substring(0, Math.min(lastName.length(), 3));


        StringBuilder formatUsername = new StringBuilder();
        formatUsername
                .append(firstThreeLettersFirstName)
                .append(".")
                .append(firstThreeLettersLastName)
                .append(randomNumber)
                .append("@example.com");

        setUsername(formatUsername.toString());
    }

    /*
     *****************************************
     * Generate Password
     *****************************************
     */
    public void generatePassword() {
        //Simple password [same for all users]
        //Can be changed later by user
        setPassword("Admin123");
    }

    /*
     *****************************************
     * Generate Current Amount
     *****************************************
     */
    public void generateCurrentAmount() {
        //Generate a random amount between 10,000 and 250,000
        double amount = faker.number().numberBetween(10_000, 250_000);
        setCurrentAmount(amount);
    }

    /*
     *****************************************
     * Generate isActive
     *****************************************
     */
    public void generateIsActive() {
        //isActive is set to false by default
        setActive(false);
    }

    /*
     *****************************************
     * Generate Pin
     *****************************************
     */
    public void generatePin() {
        //Generate a random 4 digit pin
        int pin = faker.number().numberBetween(1000, 10_000);
        setPin(pin);
    }

    /*
     *****************************************
     * Generate Card Number
     *****************************************
     */
    public void generateCardNumber() {
        //Generate a random 16 digit card number
        StringBuilder cardNumber = new StringBuilder();
        cardNumber
                .append(faker.number().numberBetween(1000, 10_000)).append("-")
                .append(faker.number().numberBetween(1000, 10_000)).append("-")
                .append(faker.number().numberBetween(1000, 10_000)).append("-")
                .append(faker.number().numberBetween(1000, 10_000));

        //convert to string
        setCardNumber(cardNumber.toString());
    }

    /*
     *****************************************
     * Generate Sort Code
     *****************************************
     */
    public void generateSortCode() {
        //Generate a random 6 digit sort code
        StringBuilder sortCode = new StringBuilder();
        sortCode
                .append(faker.number().numberBetween(10, 100)).append("-")
                .append(faker.number().numberBetween(10, 100)).append("-")
                .append(faker.number().numberBetween(10, 100));

        //convert to string
        setSortCode(sortCode.toString());
    }

    /*
     *****************************************
     * Generate Account Number
     *****************************************
     */
    public void generateAccountNumber() {
        //Generate a random 8-digit account number
        int accountNumber = faker.number().numberBetween(100_000_00, 999_999_99);
        setAccountNumber(String.valueOf(accountNumber));
    }

    /*
     *****************************************
     * Get all user data as JSON
     *****************************************
     */
    public void createUserData() {
        //Generate all the data for the customer
        generateFirstName(); //First Name
        generateLastName(); //Last Name
        generateDateOfBirth(); //Date of Birth
        generateGender(); //Gender
        generateCountryOfBirth(); //Country of Birth
        generateAddress(); //Address
        generateSocialSecurityNumber(); //Social Security Number
        generatePhoneNumber(); //Phone Number
        generateUsername(); //Username
        generatePassword(); //Password
        generateCurrentAmount(); //Current Amount i.e. amount of money in bank account
        generateIsActive(); //check if the user is currently active
        generatePin(); //Pin
        generateCardNumber();  //Card Number
        generateSortCode(); //Sort Code
        generateAccountNumber(); //Account Number

        //Show data in Custom JSON format
        System.out.println(console.greenBrightBackground + console.blackBold + " User created successfully... " + console.reset);
        StringBuilder buildJson = new StringBuilder();
        buildJson
                .append("{").append("\n")
                .append("\t").append("firstName: ").append(getFirstName()).append("\n")
                .append("\t").append("lastName: ").append(getLastName()).append("\n")
                .append("\t").append("dateOfBirth: ").append(getDateOfBirth()).append("\n")
                .append("\t").append("gender: ").append(getGender()).append("\n")
                .append("\t").append("countryOfBirth: ").append(getCountryOfBirth()).append("\n")
                .append("\t").append("address: ").append(getAddress()).append("\n")
                .append("\t").append("socialSecurityNumber: ").append(getSocialSecurityNumber()).append("\n")
                .append("\t").append("phone: ").append(getPhone()).append("\n")
                .append("\t").append("username: ").append(getUsername()).append("\n")
                .append("\t").append("password: ").append(getPassword()).append("\n")
                .append("\t").append("currentAmount: ").append(getCurrentAmount()).append("\n")
                .append("\t").append("isActive: ").append(isActive()).append("\n")
                .append("\t").append("pin: ").append(getPin()).append("\n")
                .append("\t").append("cardNumber: ").append(getCardNumber()).append("\n")
                .append("\t").append("sortCode: ").append(getSortCode()).append("\n")
                .append("\t").append("accountNumber: ").append(getAccountNumber()).append("\n")
                .append("}");

        //Display custom JSON formatted data
        System.out.println(buildJson);
    }
}
