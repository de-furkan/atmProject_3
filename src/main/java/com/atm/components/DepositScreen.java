package com.atm.components;

import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;
import java.util.Scanner;

public class DepositScreen {

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
    public DepositScreen() {
        this.database = Atm_Runner.database;
    }

    public String checkAmountToDeposit() {
        //deposit message
        System.out.println(
                console.blackBackground + console.greenBold +
                " How much would you like to deposit? "
                + console.reset + "\n\n"
        );

        // get the deposit amount
        String depositAmount = scanner.nextLine();

        // Check if the provided deposit amount is a number
        while (true) {
            if (!depositAmount.matches("\\d+")) {
                System.out.println(depositAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                        " Invalid input. Please provide a numeric value: " +
                        console.reset
                );
                depositAmount = scanner.nextLine();
                // Check if the provided deposit amount is less than 5
            } else if (Double.parseDouble(depositAmount) < 5) {
                System.out.println(depositAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                        " Invalid input. The value must be greater than or equal to 5: " +
                        console.reset
                );
                depositAmount = scanner.nextLine();
                // Check if the provided deposit amount is greater than 1000
            } else if (Double.parseDouble(depositAmount) > 1000) {
                System.out.println(depositAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                        " Invalid input. The value must be less than or equal to 1000: " +
                        console.reset
                );
                depositAmount = scanner.nextLine();
            } else {
                System.out.println(depositAmount);
                return depositAmount;
            }
        }
    }

    public void createDepositTransaction() {
        database.depositAmount(Double.parseDouble(checkAmountToDeposit()));
        splashScreen.homeMenu();
    }
}
