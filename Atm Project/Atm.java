
/*This is a project for an ATM machine.
 * The machine prompts the user for an ID and a pin. The ID is a randomly generated number given to the user.
 * The pin(1048) is passed as an argument when the user object is created
 * The user can have as many accounts as possible. The name of the account defines whether it is a checkings or a savings account
 * The user can also perform basic functions on the account such as deposit funds or transfer funds between accounts
 * When an account is credited, the transaction reflects the amount without brackets to show that money was added
 * When an account is debited, the transaction reflects the amount with brackets to show that money was removed
 */
import java.util.*;

public class Atm {

    public static void main(String[] args) {
        // init Scanner
        Scanner sc = new Scanner(System.in);

        // init Bank
        Bank theBank = new Bank("Bank of the UNSC");

        // add a user to the bank, which also creates a savings account
        User aUser = new User("James", "Dobberman", "1048", theBank);
        theBank.addUser(aUser);

        // add a checking account for our user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true) {

            // stay in the login prompt until successful
            curUser = Atm.mainMenuPrompt(theBank, sc);

            // stay in the main menu until user quits
            Atm.printUserMenu(curUser, sc);
        }

    }

    public static void printUserMenu(User theUser, Scanner sc) {

        // print a summary of the user's account
        theUser.printAccountsSummary();

        // init
        int choice;

        // user menu
        do {
            System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
            System.out.println("\t1. Show account transaction history");
            System.out.println("\t2. Withdrawal");
            System.out.println("\t3. Deposit");
            System.out.println("\t4. Transfer");
            System.out.println("\t5. Log out");
            System.out.println("");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose a number between 1 and 5");
            }

        } while (choice < 1 || choice > 5);

        // process the choice
        switch (choice) {
            case 1:
                Atm.showTransferHistory(theUser, sc);
                break;
            case 2:
                Atm.withdrawFunds(theUser, sc);
                break;
            case 3:
                Atm.depositFunds(theUser, sc);
                break;
            case 4:
                Atm.transferFunds(theUser, sc);
                break;
            case 5:
                // gobble up user input
                sc.nextLine();
                break;
        }

        // redisplay this menu unless the user wants to quit
        if (choice != 5) {
            Atm.printUserMenu(theUser, sc);
        }
    }
    // public void deposit(User theUser, Scanner sc){

    // //inits
    // String toAcct;
    // double amount;
    // String memo;
    // do{
    // System.out.print("Enter the name of the Bank whose account: ");

    // }
    // }

    // deposit funds into an account
    public static void depositFunds(User theUser, Scanner sc) {
        // inits
        int toAcct;
        double amount;
        // double acctBal;
        String memo;
        // get the account to deposit to
        do {
            System.out.printf("Enter the number (1 - %d) of the account\n to deposit to: ", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid entry. Please try again");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());
        // acctBal = theUser.getAccountBalance(toAcct);

        // get the amount to deposit
        do {
            System.out.print("Enter the amount to deposit:\t");
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than 0");
            }
        } while (amount < 0);

        // gobble up the rest of the previous input
        sc.nextLine();

        // get a memo
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();

        // do the deposit
        theUser.addAcctTransaction(toAcct, amount, memo);
    }

    // withdraw funds from an account
    public static void withdrawFunds(User theUser, Scanner sc) {
        // inits
        int fromAcct;
        double amount;
        double acctBal;
        String memo;
        // get the account to withdraw from
        do {
            System.out.printf("Enter the number (1 - %d) of the account\n to withdraw from: ", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid entry. Please try again");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());
        acctBal = theUser.getAccountBalance(fromAcct);

        // get the amount to withdraw
        do {
            System.out.printf("Enter the amount to withdraw (max $ %.02f)", acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than 0");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than \n balance of $ %.02f \n", acctBal);
            }
        } while (amount < 0 || amount > acctBal);

        // gobble up the rest of the previous input
        sc.nextLine();

        // get a memo
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();

        // do the withdrawal
        theUser.addAcctTransaction(fromAcct, -1 * amount, memo);
    }

    // Transfer funds from once account to another for a single user
    public static void transferFunds(User theUser, Scanner sc) {

        // inits
        int fromAcct;
        int toAcct;
        double amount;
        double acctBal;

        // get the account to transfer from
        do {
            System.out.printf("Enter the number (1 - %d) of the account\n to transfer from: ", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid entry. Please try again");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());
        acctBal = theUser.getAccountBalance(fromAcct);

        // get the account to transfer to
        do {
            System.out.printf("Enter the number (1 - %d) of the account\n to transfer to: ", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid entry. Please try again");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());

        // get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $ %.02f)", acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than 0");
            } else if (amount > acctBal) {
                System.out.printf("Amount must be greater than \n balance of $ %.02f \n", acctBal);
            }
        } while (amount < 0 || amount > acctBal);

        // carry out the transfer
        theUser.addAcctTransaction(fromAcct, -1 * amount,
                String.format("Transfer to account %s", theUser.getAcctUUID(toAcct)));
        theUser.addAcctTransaction(toAcct, amount,
                String.format("Transfer from account %s", theUser.getAcctUUID(fromAcct)));
    }

    public static User mainMenuPrompt(Bank theBank, Scanner sc) {

        // inits
        String userID;
        String pin;
        User authUser;

        // prompt the user for the userID/pin until a correct one is reached
        do {

            System.out.printf("\n\nWelcome to the %s\n\n", theBank.getName());
            System.out.print("Enter the user ID: ");
            userID = sc.nextLine();
            System.out.print("Enter the pin: ");
            pin = sc.nextLine();

            // try to get the user object corresponding to the ID and pin
            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorect user ID/pin combination. Please try again.");
            }

        } while (authUser == null);// continue looping until succesful login
        return authUser;
    }

    // show the transaction history for the account
    public static void showTransferHistory(User theUser, Scanner sc) {

        int theAcct;
        // get which of the accounts the user wants to look at
        do {

            System.out.printf("Enter the number (1 - %d) of the account\n whose transactions you want to see: ",
                    theUser.numAccounts());
            theAcct = sc.nextInt() - 1;
            if (theAcct < 0 || theAcct >= theUser.numAccounts()) {
                System.out.println("Invalid entry. Please try again");
            }

        } while (theAcct < 0 || theAcct >= theUser.numAccounts());

        // print the Transaction history
        theUser.printAcctTransactionHistory(theAcct);

    }

}
