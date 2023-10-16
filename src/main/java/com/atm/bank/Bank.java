package com.atm.bank;

import com.atm.utilities.ConsoleUtils;

public class Bank {

    /*
     *****************************************
     * Libraries / Classes
     *****************************************
     */
    ConsoleUtils console = new ConsoleUtils();

    /*
     *****************************************
     * Private Fields / Bank Internal
     *****************************************
     */

    private final String name = "XBankUniversal";
    private final String branchId = "XB13541";
    private final String address = "6595 Breitenberg Orchard, New Margo, MO 81496";
    private final String contactNumber = "850-615-1458";
    private final String workingHours = "Mon - Sat: " + console.whiteBrightBackground + console.blackBold + " 9am - 3pm " + console.reset + "\n" +
            "Sunday:"+ console.redBold + " Closed " + console.reset;
    private final String[] listOfEmployees = {
            "Millard Batz",
            "Kayce Quitzon",
            "Dale Koch",
            "Bradford Witting",
            "Isela Romaguera",
            "Mariano Braun",
            "Devin Hand",
            "Valentine Morar",
            "Granville McKenzie"
    };

    /*
     *****************************************
     * Getters for Private Data Bank Internal
     *****************************************
    */

    public String getBankName() {
        return name;
    }

    public String getBankBranchId() {
        return branchId;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getWorkingHours() {
        return workingHours;
    }
}
