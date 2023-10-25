package com.atm.components;

import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;
import java.util.Scanner;

public class TransferScreen {

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
    public TransferScreen() {
        this.database = Atm_Runner.database;
    }

    public String transferAmountCheck() {
        //transfer message
        System.out.println(
                console.blackBackground + console.greenBold +
                        " How much would you like to Transfer? "
                        + console.reset + "\n\n"
        );

        // get the transfer amount
        String transferAmount = scanner.nextLine();

        // Check if the provided transfer amount is a number
        while (true) {
            if (!transferAmount.matches("\\d+")) {
                System.out.println(transferAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                        " Invalid input. Please provide a numeric value: " +
                        console.reset
                );
                transferAmount = scanner.nextLine();
                // Check if the provided transfer amount is less than 50
            } else if (Double.parseDouble(transferAmount) < 50) {
                System.out.println(transferAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                        " Invalid input. The value must be greater than or equal to 50: " +
                        console.reset
                );
                transferAmount = scanner.nextLine();
                // Check if the provided transfer amount is greater than 1500
            } else if (Double.parseDouble(transferAmount) > 1500) {
                System.out.println(transferAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                        " Invalid input. The value must be less than or equal to 1500: " +
                        console.reset
                );
                transferAmount = scanner.nextLine();
            } else {
                System.out.println(transferAmount);
                return transferAmount;
            }
        }
    }

    public void createTransferTransaction() {
        database.transferMoney(Double.parseDouble(transferAmountCheck()));
        splashScreen.homeMenu();
    }
}
