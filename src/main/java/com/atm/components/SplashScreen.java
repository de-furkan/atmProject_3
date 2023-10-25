package com.atm.components;

import com.atm.bank.Bank;
import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;

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
                    System.out.println(
                            console.yellowBackground + console.blackBold +
                            " Selected Check Balance "
                            + console.reset
                    );
                    balanceScreen.showBalanceMessage();
                    break;
                case "2":
                    System.out.println(
                            console.yellowBackground + console.blackBold +
                            " Selected Withdraw "
                            + console.reset
                    );
                    WithdrawalScreen withdrawalScreen = new WithdrawalScreen();
                    withdrawalScreen.createWithdrawTransaction();
                    break;
                case "3":
                    System.out.println(
                            console.yellowBackground + console.blackBold +
                            " Selected Deposit "
                            + console.reset
                    );
                    DepositScreen depositScreen = new DepositScreen();
                    depositScreen.createDepositTransaction();
                    break;
                case "4":
                    System.out.println(
                                console.yellowBackground + console.blackBold +
                            " Selected Transfer "
                            + console.reset
                    );
                    TransferScreen transferScreen = new TransferScreen();
                    transferScreen.createTransferTransaction();
                    break;
                case "5":
                    System.out.println(
                            console.yellowBackground + console.blackBold +
                            " Selected Delete Account "
                            + console.reset
                    );
                    DeleteUserScreen deleteUserScreen = new DeleteUserScreen();
                    deleteUserScreen.deleteUser();
                    break;
                case "6":
                    System.out.println(
                            console.yellowBackground + console.blackBold +
                            " Selected Change Pin "
                            + console.reset
                    );
                    ChangePinScreen changePin = new ChangePinScreen();
                    changePin.checkCurrentPin();
                    break;
                case "7":

                    String closeMessage =  console.yellowBackground + console.blackBold +
                            " Closing the ATM application... "
                            + console.reset;
                    for (int i = 0; i < closeMessage.length(); i++) {
                        System.out.print(closeMessage.charAt(i));
                        try {
                            Thread.sleep(60);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ExitScreen exitScreen = new ExitScreen();
                    exitScreen.exitScreen();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (!selectMenuOption.matches("[1-7]"));
    }
}
