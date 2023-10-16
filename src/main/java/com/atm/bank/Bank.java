package com.atm.bank;

public class Bank {

    /*
     *****************************************
     * Private Fields / Bank Internal
     *****************************************
    */

    private final String name = "XBankUniversal";
    private final String branchId = "XB13541";
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
