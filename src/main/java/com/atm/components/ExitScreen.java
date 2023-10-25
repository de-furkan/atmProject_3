package com.atm.components;

import com.atm.bank.Bank;
import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;

import java.util.Scanner;

public class ExitScreen {
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
    Bank bank = new Bank();

    /*
     *****************************************
     * Constructors
     *****************************************
     */
    public ExitScreen() {
        this.database = Atm_Runner.database;
    }

    public void exitScreen() {
        System.out.println("\n" +
                console.blackBackground + console.yellowBold +
                " Thank you for being a customer at " + bank.getBankName() +  "! " + console.reset + "\n" +
                console.blackBackground + console.yellowBold + " We hope to see you again soon! " + console.reset
        );

        //take user offline
        //this will set isActive to false in the database
        database.userActivityOffline();

        try {
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
