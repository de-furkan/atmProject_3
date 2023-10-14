package com.atm.bank;

import org.testng.annotations.Test;

public class Bank {

    /*
     *****************************************
     * Private Fields / Bank Internal
     *****************************************
    */

    private final String bankName = "XBankUniversal";
    private final String bankBranchId = "XB13541";
    private final String address = "6595 Breitenberg Orchard, New Margo, MO 81496";
    private final String contactNumber = "850-615-1458";
    private final String workingHours = "Monday - Sat: 9am - 3pm\n" + "Sunday: Closed";
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
        return bankName;
    }

    public String getBankBranchId() {
        return bankBranchId;
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
