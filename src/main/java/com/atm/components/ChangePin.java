package com.atm.components;

import com.atm.bank.Bank;
import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;

import java.util.Scanner;

public class ChangePin {
    /*
     *****************************************
     * Private Fields / Data
     *****************************************
     */
    private DbUtils database;

    /*
     *****************************************
     * Libraries / Classes
     *****************************************
     */
    ConsoleUtils console = new ConsoleUtils();
    Scanner scanner = new Scanner(System.in);
    SplashScreen splashScreen = new SplashScreen();

    /*
     *****************************************
     * Constructors
     *****************************************
     */

    public ChangePin() {
        this.database = Atm_Runner.database;
    }

    public  void checkCurrentPin() {

        System.out.println(
                console.blackBackground + console.greenBold +
                " Change Account Pin "
                + console.reset + "\n\n"
        );
        System.out.println(
                console.blackBackground + console.purpleBold +
                " Please provide your current pin: "
                + console.reset + "\n\n"
        );

        //get current pin
        String currentPin = scanner.nextLine();

        // Check if the provided pin is a number
        while (!currentPin.matches("\\d+")) {
            System.out.println(
                    console.redBrightBackground + console.blackBold +
                            " Invalid input. Please provide a numeric pin: " +
                            console.reset
            );
            currentPin = scanner.nextLine();
        }

        //create connection to database
        if (DbUtils.connection == null) {
            this.database.getSavedOption();
        }

        //check if pin is  correct
        if (Integer.parseInt(database.showEntryField("pin")) == Integer.parseInt(currentPin)) {
            System.out.println(
                    console.greenBrightBackground + console.blackBold +
                    " Current pin matches our records. "
                    + console.reset + "\n\n"
            );
            updatePin();
        } else {
            System.out.println(
                    console.redBrightBackground + console.blackBold +
                    " Current pin does not match our records. "
                    + console.reset + "\n\n"
            );
            database.closeConnectionToDatabase();
            checkCurrentPin();
        }
    }

    public void updatePin() {
        //check connection valid
        if (DbUtils.connection == null) {
            this.database.getSavedOption();
        }

        System.out.println(
                console.blackBackground + console.purpleBold +
                " Please provide your new pin: "
                + console.reset + "\n\n"
        );
        String newPin = scanner.nextLine();

        // Check if the provided pin is a number
        while (!newPin.matches("\\d+") || newPin.length() != 4) {
            System.out.println(
                    console.redBrightBackground + console.blackBold +
                    " Invalid input. Please provide a numeric pin and ensure it is 4 digits long: " +
                    console.reset
            );
            newPin = scanner.nextLine();
        }

        //message
        try {
            if (Integer.parseInt(database.showEntryField("pin")) != Integer.parseInt(newPin)) {
                System.out.println(
                        console.greenBrightBackground + console.blackBold +
                        " Your pin has been updated successfully. "
                        + console.reset + "\n\n"
                );
                database.updateNumericFields("pin", Integer.parseInt(newPin));
                database.closeConnectionToDatabase();
                database.setAccountPin(Integer.parseInt(newPin));
                splashScreen.homeMenu();
            } else {
                System.out.println("Error updating the pin");
                database.closeConnectionToDatabase();
                checkCurrentPin();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
