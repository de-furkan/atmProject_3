package com.atm.components;

import com.atm.bank.Bank;
import com.atm.runner.Atm_Runner;
import com.atm.utilities.ConsoleUtils;
import com.atm.utilities.DbUtils;
import java.time.LocalDate;
import java.time.LocalTime;

public class BalanceScreen {

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

    public BalanceScreen() {
        this.database = Atm_Runner.database;
    }

    public void showBalanceMessage() {

        //create date object
        LocalDate dateNow = LocalDate.now();
        //day
        int day = dateNow.getDayOfMonth();
        //month
        int month = dateNow.getMonthValue();
        //year
        int year = dateNow.getYear();

        //create time object
        LocalTime timeNow = LocalTime.now();
        //hour
        int hour = timeNow.getHour();
        //minute
        int minute = timeNow.getMinute();
        //second
        int second = timeNow.getSecond();

        //create formatted date string
        String date = day + "/" + month + "/" + year;

        //create formatted time string
        String time = hour + ":" + minute + ":" + second;

        //print date and time
        System.out.println(
                console.purpleBold +
                "Date" + "\t\t\t\t\ttime" +
                console.reset
        );

        //store full card number then mask all numbers expect last 4
        String fullCardNumber = database.showFullCardNumber();
        String maskedCardNumber = fullCardNumber.substring(0, fullCardNumber.length() - 4)
                .replaceAll("\\d", "X") +
                fullCardNumber.substring(fullCardNumber.length() - 4);

        //create message that will be printed
        //this message will show the date, time, masked card number and current balance
        StringBuilder message = new StringBuilder();
        message.append("\n")
                .append(date).append("\t\t\t\t").append(time).append("\n")
                .append(console.redBold).append(console.blackBackground).append("CARD NUMBER").append(console.reset).append("\n")
                .append(console.blackBackground).append(console.greenBold).append(maskedCardNumber).append(console.reset).append("\n\n")
                .append("TRANSACTION").append("\n")
                .append("WITHDRAWAL CHECKING").append("\n")
                .append(bank.getBankName().toUpperCase()).append("\n")
                .append(console.greenBackground).append(console.blackBold).append("CASH\t\t\t\t")
                .append("£").append(database.showEntryField("current_amount")).append(console.reset);

        System.out.println(message);
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.homeMenu();
    }
}
