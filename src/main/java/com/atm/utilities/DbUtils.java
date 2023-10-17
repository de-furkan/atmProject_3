package com.atm.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DbUtils {
    /*
     *****************************************
     * Libraries / Classes
     *****************************************
     */
    ConsoleUtils console = new ConsoleUtils();
    Scanner scanner = new Scanner(System.in);
    /*
     *****************************************
     * Private Fields / Data
     *****************************************
     */
    private String connectionChoice = null; //user input for connection choice
    private String connectionDomainName; //user input for domain name
    private String connectionPortNumber; //user input for port number
    private String connectionDatabaseName; //user input for database name
    private String connectionUsername; //user input for username
    private String connectionPassword; //user input for password


    public static Connection connection; //connection object to connect to database

    /*
     *********
     * Getters
     *********
     */
    public String getConnectionChoice() { //get connection choice
        return connectionChoice;
    }

    private String getConnectionDomainName() { //get domain name
        return connectionDomainName;
    }

    private String getConnectionPortNumber() { //get port number
        return connectionPortNumber;
    }

    private String getConnectionDatabaseName() { //get database name
        return connectionDatabaseName;
    }

    private String getConnectionUsername() { //get username
        return connectionUsername;
    }

    private String getConnectionPassword() { //get password
        return connectionPassword;
    }

    /*
     *********
     * Setters
     *********
     */
    public void setConnectionChoice(String connectionChoice) { //set connection choice
        this.connectionChoice = connectionChoice;
    }

    public void setConnectionDomainName(String connectionDomainName) { //set domain name
        this.connectionDomainName = connectionDomainName;
    }

    public void setConnectionPortNumber(String connectionPortNumber) { //set port number
        this.connectionPortNumber = connectionPortNumber;
    }

    public void setConnectionDatabaseName(String connectionDatabaseName) { //set database name
        this.connectionDatabaseName = connectionDatabaseName;
    }

    public void setConnectionUsername(String connectionUsername) { //set username
        this.connectionUsername = connectionUsername;
    }

    public void setConnectionPassword(String connectionPassword) { //set password
        this.connectionPassword = connectionPassword;
    }

    /*
     *****************************************
     * Display intro message for database connection
     *****************************************
     */
    public void connectDatabaseMessage() throws SQLException {
        StringBuilder buildMessage = new StringBuilder();
        buildMessage
                //Introduction message
                .append("A few details are required before proceeding.")
                .append(console.greenBold).append(console.blackBackground)
                .append(" Following and successfully ")
                .append("completing the steps below ").append(console.reset)
                .append(" will\nallow you to complete the database connection process, ")
                .append("and this will also help with providing a smooth\nexperience.\n\n")

                //Note message in red
                .append(console.redBold).append(console.blackBackground)
                .append(" NOTE: ")
                .append(console.reset).append(console.redBold)
                .append(" It is ESSENTIAL that you connect a database to run this programming as smoothly as possible. ")
                .append(console.reset).append("\n\n")

                //How to connect a database message
                //create a hyperlink to GitHub profile readme file shown in console output
                .append("To connect a database successfully, please make sure to see the README file on GitHub for more information: \n")
                .append(console.blackBackground).append(" https://github.com/de-furkan/atmProject_3/#readme ").append(console.reset).append("\n");

        System.out.println(buildMessage);

        System.out.println("Have you read the README file in the GitHub link provided above? (Y/N)");
        String userResponse = scanner.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();

        while (!userResponse.equals("y") && !userResponse.equals("n")) {
            System.out.println("Please provide a valid input. Type only Y or N.");
            userResponse = scanner.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();
        }

        if (userResponse.equals("y")) {
            //if user has read the instructions, then proceed to the next step
            //Which will provide options for connecting to the database
            //The console output below will create a blank line for better readability
            System.out.println("\n");
            connectToDatabaseOptions();
        } else {
            //if user has not read the instructions, then display the message below
            //and call this method again to display the instructions again
            //Note: connectDatabaseMessage() is recursive
            System.out.println(
                    "-----------------------------------------------------\n" +
                            console.redBackground + console.blackBold + " Please READ the instructions below and try again... " + console.reset + "\n" +
                            "-----------------------------------------------------"
            );
            connectDatabaseMessage();
        }
    }

    /*
     *****************************************
     * Provide options to connect database
     * 1. automatically [admin use only]
     * 2. manually      [external use]
     *****************************************
     */
    public void connectToDatabaseOptions() {

        //initial connectionChoice value is null to ensure the while loop runs
        //while loop will run until user provides a valid input
        //valid inputs are 1 or 2
        String input;
        while (
                getConnectionChoice() == null ||
                        !getConnectionChoice().equals("1") && !getConnectionChoice().equals("2")
        ) {
            String chooseOptionMessage = console.blackBackground + console.purpleBold + " Below, you will be prompted to choose an option for connecting to a database. " + console.reset + "\n\n" +
                    "Note: This is a one time setup to ensure the program runs smoothly.\n" +
                    "Please select option 2 if you do not own this project.\n";

            System.out.println(chooseOptionMessage);

            System.out.println(
                    console.blackBackground + console.whiteBold +
                            " Please choose one of the options below by typing " + console.redBold + " 1 " + console.reset + console.blackBackground + "or" + console.greenBold + " 2 " + console.reset + "\n\n" +
                            "[" + console.redBold + "1" + console.reset + "] Automatic setup - " + console.redBold + "Admin" + console.reset + "\n" +
                            "[" + console.greenBold + "2" + console.reset + "] Manual setup - " + console.greenBold + "External" + console.reset
            );
            input = scanner.nextLine();

            if (input.startsWith("-")) {
                System.out.println(console.redBrightBackground + console.blackBold + " Invalid input, negative numbers are not allowed. Please try again. " + console.reset);
                continue;
            }

            setConnectionChoice(input.replaceAll("[^1-2]", ""));
            //the if-else clause below is used to display the option chosen by the user in colour-coded format
            if (getConnectionChoice().length() == 1 && getConnectionChoice().equals("1")) {
                System.out.println(console.greenBackground + console.blackBold + " You have chosen option: " + getConnectionChoice() + " " + console.reset + "\n");
                connectToDatabase();
                return;
            } else if (getConnectionChoice().length() == 1 && getConnectionChoice().equals("2")) {
                System.out.println(console.greenBackground + console.blackBold + "You have chosen option: " + getConnectionChoice() + " " + console.reset + "\n");
                setDataForDatabaseConnectionChoiceTwo();
            } else {
                System.out.println(console.redBrightBackground + console.blackBold + " Invalid input. Please try again. " + console.reset);
                setConnectionChoice(null);
            }
        }
    }

    /*
     *****************************************
     * Option 1 connection - Admin
     *****************************************
     */

    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/atmProject3",
                    "admin",
                    "root123"
            );
            //Show success message if connection is a success
            System.out.println(
                    "Successfully connected to database:" + console.reset + " " +
                            console.blackBackground + console.greenBold + " " + connection.getCatalog() + " " + console.reset
            );
        } catch (SQLException e) {
            //throw an exception if connection fails
            e.printStackTrace();
        }
    }

    /*
     *****************************************
     * set data for connection option 2
     *****************************************
     */
    public void setDataForDatabaseConnectionChoiceTwo() {
        try {
            System.out.println(
                    "Below you will be prompted to provide valid information to connect to a postgreSQL based database.\n" +
                            "Please double check that the provided details are correct...\n\n"
            );

            //user must provide a valid domain name
            System.out.println("Please provide the domain name of the server you wish to connect to:");
            setConnectionDomainName(scanner.nextLine());

            //user must provide a valid port number
            System.out.println("Please provide the correct port number of this server:");
            setConnectionPortNumber(scanner.nextLine().replaceAll("[^0-9]", ""));

            //user must provide a valid database name
            System.out.println("Please provide the database name to connect to within this server:");
            setConnectionDatabaseName(scanner.nextLine());

            //user must provide a valid username
            System.out.println("Please provide the correct username of this server");
            setConnectionUsername(scanner.nextLine());

            //user must provide a valid password
            System.out.println("Please provide the correct password of this server");
            setConnectionPassword(scanner.nextLine());

            //connect to database using the provided information
            connectToDatabase(
                    getConnectionDomainName(),
                    getConnectionPortNumber(),
                    getConnectionDatabaseName(),
                    getConnectionUsername(),
                    getConnectionPassword()
            );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection == null) {
                System.out.println("Could not connect to database. Please try Again.");
                setDataForDatabaseConnectionChoiceTwo();
            } else {
                System.out.println("Thank-you. The provided data has been accepted.");
            }
        }
    }

    /*
     *****************************************
     * Option 2 connection - External
     *****************************************
     */
    public void connectToDatabase(String domainName, String portNumber, String databaseName, String userName, String password) {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + getConnectionDomainName() + ":" + getConnectionPortNumber() + "/" + getConnectionDatabaseName(),
                    getConnectionUsername(),
                    getConnectionPassword()
            );
            //Show success message if connection is a success
            System.out.println(
                    "Successfully connected to database:" + console.reset + " " +
                            console.blackBackground + console.greenBold + " " + connection.getCatalog() + " " + console.reset
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     *****************************************
     * Close the database connection
     *****************************************
     */
    public void closeConnectionToDatabase() {
        //closes the connection to database
        try {
            connection.close();
            System.out.println("Connection to database " + console.purpleBold + console.blackBackground + " closed " + console.reset + " successfully.");
        } catch (SQLException e) {
            //throw an exception if connection fails
            e.printStackTrace();
        } catch (NullPointerException e) {
            //throw an exception if connection is null
            //and prints a message to let user know of the error
            System.out.println(console.redBold + "Cannot close the database connection because there is no connection to close..." + console.reset);
        }
    }
}