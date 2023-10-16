package com.atm.components;

import com.atm.bank.Bank;
import com.atm.utilities.ConsoleUtils;

public class SplashScreen {
    /*
     *****************************************
     * Libraries / Classes
     *****************************************
     */
    Bank bank = new Bank();
    ConsoleUtils console = new ConsoleUtils();

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
                .append("Contact Number: ").append(console.purpleBold).append(bank.getContactNumber()).append(console.reset).append("\n\n")
                .append("Working Days: \n").append(bank.getWorkingHours()).append("\n")
                .append("--------------------------------------------------------------------------");

        System.out.println(buildMessage);
    }

    public static void main(String[] args) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.welcomeMessageBeforeCardVerification();
    }
}
