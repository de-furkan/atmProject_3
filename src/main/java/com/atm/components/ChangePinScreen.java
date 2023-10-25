package com.atm.components;

import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;
import java.util.Scanner;

public class ChangePinScreen {
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

    public ChangePinScreen() {
        this.database = Atm_Runner.database;
    }

    public  void checkCurrentPin() {
        //change account pin message
        System.out.println(
                console.blackBackground + console.greenBold +
                " Change Account Pin "
                + console.reset + "\n\n"
        );
        //provide current pin message
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

        //check if pin is  correct and exists in database
        if (Integer.parseInt(database.showEntryField("pin")) == Integer.parseInt(currentPin)) {
            System.out.println(
                    console.greenBrightBackground + console.blackBold +
                    " Current pin matches our records. "
                    + console.reset + "\n\n"
            );
            //if pin exists, then call the updatePin() method
            //this method will update the pin in the database
            updatePin();
        } else {
            //if pin does not exist, then let user know
            System.out.println(
                    console.redBrightBackground + console.blackBold +
                    " Current pin does not match our records. "
                    + console.reset + "\n\n"
            );
            //close connection to database and call checkCurrentPin() method again
            database.closeConnectionToDatabase();
            checkCurrentPin();
        }
    }

    public void updatePin() {
        //check connection valid
        if (DbUtils.connection == null) {
            this.database.getSavedOption();
        }

        //provide new pin message
        System.out.println(
                console.blackBackground + console.purpleBold +
                " Please provide your new pin: "
                + console.reset + "\n\n"
        );

        //get new pin input
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

        //message to confirm new pin has been accepted and updated in database
        try {
            if (Integer.parseInt(database.showEntryField("pin")) != Integer.parseInt(newPin)) {
                System.out.println(
                        console.greenBrightBackground + console.blackBold +
                        " Your pin has been updated successfully. "
                        + console.reset + "\n\n"
                );
                //update pin in database
                database.updateNumericFields("pin", Integer.parseInt(newPin));
                //close connection to database
                database.closeConnectionToDatabase();
                //set account pin to new pin
                database.setAccountPin(Integer.parseInt(newPin));
                //call homeMenu() method
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
