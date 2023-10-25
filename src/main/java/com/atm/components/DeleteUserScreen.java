package com.atm.components;

import com.atm.bank.Bank;
import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;

import java.util.Scanner;

public class DeleteUserScreen {
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
    Bank bank = new Bank();
    SplashScreen splashScreen = new SplashScreen();

    /*
     *****************************************
     * Constructors
     *****************************************
     */
    public DeleteUserScreen() {
        this.database = Atm_Runner.database;
    }

    public void deleteUser() {
        //user confirmation before deleting account
        String proceed = "";

        //prompt message
        String promptMessage =
                console.redBrightBackground + console.blackBold +
                " Are you sure you want to delete your account? (y/n) "
                + console.reset;

        //invalid input message
        String invalidInputMessage =
                console.redBrightBackground + console.blackBold +
                " Invalid input. Please enter 'y' for yes or 'n' for no. "
                + console.reset;

        //account deleted message
        String accountDeletedMessage =
                console.redBrightBackground + console.blackBold +
                " Your account has been deleted. "
                + console.reset;

        while (true) {
            System.out.println(promptMessage);
            proceed = scanner.nextLine().toLowerCase();

            if (proceed.equals("y")) {
                database.deleteUserAccount();
                System.out.println(accountDeletedMessage);
                break;
            } else if (proceed.equals("n")) {
                splashScreen.homeMenu();
                break;
            } else {
                System.out.println(invalidInputMessage);
                deleteUser();
            }
        }
    }
}
