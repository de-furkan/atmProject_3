package com.atm.components;

import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;

import java.util.Scanner;

public class WithdrawalScreen {
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
    public WithdrawalScreen() {
        this.database = Atm_Runner.database;
    }

    public String checkAmountToWithdraw() {
        //deposit message
        System.out.println(
                console.blackBackground + console.greenBold +
                        " How much would you like to Withdraw? "
                        + console.reset + "\n\n"
        );

        // get the deposit amount
        String withdrawAmount = scanner.nextLine();

        // Check if the provided deposit amount is a number
        while (true) {
            if (!withdrawAmount.matches("\\d+")) {
                System.out.println(withdrawAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                                " Invalid input. Please provide a numeric value: " +
                                console.reset
                );
                withdrawAmount = scanner.nextLine();
                // Check if the provided deposit amount is less than 5
            } else if (Double.parseDouble(withdrawAmount) < 5) {
                System.out.println(withdrawAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                                " Invalid input. The value must be greater than or equal to 5: " +
                                console.reset
                );
                withdrawAmount = scanner.nextLine();
                // Check if the provided deposit amount is greater than 1000
            } else if (Double.parseDouble(withdrawAmount) > 1500) {
                System.out.println(withdrawAmount);
                System.out.println(
                        console.redBrightBackground + console.blackBold +
                                " Invalid input. The value must be less than or equal to 1500: " +
                                console.reset
                );
                withdrawAmount = scanner.nextLine();
            } else {
                System.out.println(withdrawAmount);
                return withdrawAmount;
            }
        }
    }

    public void createWithdrawTransaction() {

        database.withdrawAmount(Double.parseDouble(checkAmountToWithdraw()));
        splashScreen.homeMenu();
    }
}
