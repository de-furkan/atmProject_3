package com.atm.components;

import com.atm.bank.Bank;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static com.atm.utilities.DbUtils.connection;

public class SplashScreen {
    /*
     *****************************************
     * Libraries / Classes
     *****************************************
     */
    Bank bank = new Bank();
    //console object for text output colors in the console
    ConsoleUtils console = new ConsoleUtils();
    //scanner object for user input
    Scanner scanner = new Scanner(System.in);
    //DbUtils for database connection/information
    DbUtils database = new DbUtils();

    /*
     *****************************************
     * Private Fields / Data
     *****************************************
     */

    private String accountNumber;
    private int pin;

    /*
     **********
     * Getters
     **********
     */

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    /*
     **********
     * Setters
     **********
     */

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    /*
     *****************************************
     * Welcome message before card verification
     *****************************************
     */
    public void welcomeMessageBeforeCardVerification() {
        StringBuilder buildMessage = new StringBuilder();
        buildMessage
                //Branch Id
                .append("Branch id: ").append(console.whiteBrightBackground).append(console.blackBold)
                .append(" ").append(bank.getBankBranchId()).append(" ").append(console.reset).append("\n\n")

                //Welcome & Introduction
                .append("Welcome to ").append(console.yellowBold).append(bank.getBankName()).append(console.reset).append(",")
                .append("your trusted partner for all your banking needs.\n")

                //Security Reminder
                .append("Remember, never share your PIN with anyone...\n")

                //Lost or Stolen Cards
                .append("In case of ").append(console.redUnderlined).append("lost or stolen cards").append(console.reset)
                .append(", please contact us ").append(console.redBold).append("immediately").append(console.reset).append(".\n\n")

                //Contact Number and Working Hours
                .append("--------------------------------------------------------------------------\n")
                .append("Contact Number: ").append(console.yellowBold).append(bank.getContactNumber()).append(console.reset).append("\n\n")
                .append("Working Days: \n").append(bank.getWorkingHours()).append("\n")
                .append("--------------------------------------------------------------------------");

        System.out.println(buildMessage);
    }

    /*
     *****************************************
     * Verification/Authentication Message
     *****************************************
     */
    public void verificationIntroMessage() {
        System.out.println(console.purpleBold +"Verification & Authentication Screen" + console.reset);
        System.out.println("You will be prompted to enter your account number and pin to proceed.");
        System.out.println("Please note, you can check your information by scrolling to the top\n" +
                "in the console, or by checking the database. \n" +
                "Your personal data is stored in the database for your convenience, usually the first entry.\n");
    }

    /*
     *****************************************
     * Verify Cardholder Account Number
     *****************************************
     */
    public void verifyCardNumber() {
        //Check account number
        try {
            System.out.println("Please enter your account number below: ");
            setAccountNumber(scanner.nextLine().replaceAll("[^0-9]", ""));

            if (getAccountNumber().length() != 8) {
                throw new Exception("Card number must be 8 digits long.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            verifyCardNumber();
        }
    }

    /*
     *****************************************
     * Verify Cardholder Pin
     *****************************************
     */
    public void verifyCardPin() {
    //Check pin
        try {
            System.out.println("Please enter your pin below: ");
            setPin(scanner.nextInt());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            verifyCardPin();
        }
    }
}
