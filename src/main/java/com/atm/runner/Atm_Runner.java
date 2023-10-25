package com.atm.runner;

import com.atm.bank.Customer;
import com.atm.components.SplashScreen;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;
import java.sql.SQLException;
import java.util.Scanner;

public class Atm_Runner {
    //personal data
    public static Customer user_1;

    //Dummy data for testing
    public static Customer user_2;

    public static DbUtils database = new DbUtils();

    public static void main(String[] args) throws SQLException, InterruptedException {
        ConsoleUtils console = new ConsoleUtils();

        //Create instance of database connection object


        //Show welcome message
        database.connectDatabaseMessage();

        //Show database connection options and connect to database
        database.connectToDatabaseOptions();

        //Create database tables
        database.createRegisteredUsersTable();

        //close database connection
        database.closeConnectionToDatabase();

        //Register first customer
        System.out.println("Before proceeding, we need to create a bank account for you.\n" +
                "Don't worry, the process is automatic and will only take a second...\n" +
                console.redBold + console.blackBackground +" Would you like to proceed? (y/n) " + console.reset);

        Scanner scanner = new Scanner(System.in);
        String proceed;


        do {
            proceed = scanner.nextLine().toLowerCase();
            if (proceed.equals("y")) {
                System.out.println("Great! Let's get started...");

                //Create an instance of Customer classes
                user_1 = new Customer();
                user_2 = new Customer();

                //Create personal data and add to database
                user_1.createUserData();
                database.registerCustomer();

                //animate message
                String saveYourDataMessage =console.blackBackground + console.redBold  +" ❯ Save a copy of the data above somewhere safe " + console.reset;
                for (int i = 0; i < saveYourDataMessage.length(); i++) {
                    System.out.print(saveYourDataMessage.charAt(i));
                    Thread.sleep(50);
                }

                Thread.sleep(7000);
                //Create dummy data and add to database Please check database after completion.
                System.out.println(" ");
                String creatingDummyDataMessage = console.blackBackground + console.greenBold +
                                                    " ❯ Creating dummy data. Please check database after transfer is completed. "
                                                    + console.reset;
                for (int i = 0; i < creatingDummyDataMessage.length(); i++) {
                    System.out.print(creatingDummyDataMessage.charAt(i));
                    Thread.sleep(50);
                }
                Thread.sleep(3000);
                for (int i = 1; i <= 10; i++) {
                    user_2.createUserData();
                    database.registerDummyData();
                    Thread.sleep(1000);
                }
                System.out.println(
                        console.blackBackground + console.purpleBold +
                        " Data Transfer Completed. " +
                        "Proceeding to next step..." + console.reset + "\n"
                );
                Thread.sleep(3000);
            } else if (proceed.equals("n")) {
                System.out.println("Thank you for using our services. Have a nice day!");
                //need a way to go back to home screen and prevent the program from continuing
            } else {
                System.out.println("Invalid input. Please try again. Must be y or n.");
            }
        } while (!proceed.equals("y") && !proceed.equals("n"));

        //delay 1.5seconds
        Thread.sleep(3000);

        //Create an instance of SplashScreen [Represents the ATM Screen]
        SplashScreen splashScreen = new SplashScreen(database);

        //Display the welcome message before card verification
        splashScreen.welcomeMessageBeforeCardVerification();

        //Display the card verification screen message
        splashScreen.verificationIntroMessage();

        //Ask user for account number
        //This method will check that account number meets some preconditions
        database.loginAskAccountNumber();

        //Ask user for account pin
        //This method will check that account pin meets some preconditions
        database.loginAskAccountPin();

        //validate account exists with the provided account number and pin
        database.validateAccountExists();

        //Once successfully logged in, update the user activity
        //This should change isActive from false to true
        database.updateUserActivity();

        //user should be presented with all the possible options of what they can do
        //this is the main menu
        //this is where the user can choose to do any of the following:
        //1. Check Balance
        //2. Withdraw
        //3. Deposit
        //4. Transfer
        //5. Change Pin
        //6. Update user information
        //7. Logout
        splashScreen.homeMenu();
    }
}
