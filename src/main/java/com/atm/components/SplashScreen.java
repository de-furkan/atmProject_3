package com.atm.components;

import com.atm.bank.Bank;
import com.atm.utilities.ConsoleUtils;
import java.util.Scanner;

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

    /*
     *****************************************
     * Private Fields / Data
     *****************************************
     */

    private String accountNumber;
    private String pin;

    /*
     **********
     * Getters
     **********
     */

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
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

    public void setPin(String pin) {
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
        System.out.println("You will be prompted to enter your card number and pin to proceed.");
    }

    /*
     *****************************************
     * Verify Cardholder Account Number
     *****************************************
     */
    public void verifyCardNumber() {
        //Check account number
        try {
            System.out.println("Please enter your card number below: ");
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
            setPin(scanner.nextLine().replaceAll("[^0-9]", ""));

            if (getPin().length() != 4) {
                    throw new Exception("Pin must be 4 digits long.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            verifyCardPin();
        }
    }

    /*
     *****************************************
     * Display Verification Success Message
     *****************************************
     */
    public void verificationSuccessMessage() {
        if (getAccountNumber().length() == 8 && getPin().length() == 4) {
            System.out.println("Cardholder verification and authentication successful...");
        }
    }

    /*
     *****************************************
     * Authenticate Cardholder
     *****************************************
     */
    public void authenticateCardholder() {

    }
}
