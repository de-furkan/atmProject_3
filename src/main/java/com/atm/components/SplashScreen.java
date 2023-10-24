package com.atm.components;

import com.atm.bank.Bank;
import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;

import java.sql.SQLException;
import java.util.Scanner;


public class SplashScreen {

    private DbUtils database;

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

    BalanceScreen balanceScreen = new BalanceScreen();

    /*
     *****************************************
     * Constructors
     *****************************************
     */
    public SplashScreen() {
        this.database = Atm_Runner.database;
    }

    public SplashScreen(DbUtils database) {
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
     * Display options home menu
     *****************************************
     */
    public void homeMenu() {
        System.out.println("Please type number to select an option below: ");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Delete Account");
        System.out.println("6. Change Pin");
        System.out.println("7. Exit");

        String selectMenuOption;
        do {
            if (DbUtils.connection == null) {
                this.database.getSavedOption();
            }
            selectMenuOption = scanner.nextLine();
            switch (selectMenuOption) {
                case "1":
                    System.out.println("You have selected option 1");
                    balanceScreen.showBalanceMessage();
                    break;
                case "2":
                    System.out.println("You have selected option 2");
                    WithdrawalScreen withdrawalScreen = new WithdrawalScreen();
                    withdrawalScreen.createWithdrawTransaction();
                    break;
                case "3":
                    System.out.println("You have selected option 3");
                    DepositScreen depositScreen = new DepositScreen();
                    depositScreen.createDepositTransaction();
                    break;
                case "4":
                    System.out.println("You have selected option 4");
                    TransferScreen transferScreen = new TransferScreen();
                    transferScreen.createTransferTransaction();
                    break;
                case "5":
                    System.out.println("You have selected option 5");
                    break;
                case "6":
                    System.out.println("You have selected option 6");
                    ChangePin changePin = new ChangePin();
                    changePin.checkCurrentPin();
                    break;
                case "7":
                    System.out.println("You have selected option 7");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (!selectMenuOption.matches("[1-7]"));
    }
}
