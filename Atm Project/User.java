import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class User{
    private String firstName;
    //The first name of the user

    private String lastName;
    //The last name of the user

    private String uuid;
    //The ID number for the user

    private byte pinHash[];
    //The MD5 hash of the user's in number
    

    private ArrayList<Account> accounts;
    //The list if accounts for this user

    public User(String firstName, String lastName, String pin, Bank theBank){
        //set the user name
        this.firstName = firstName;
        this.lastName = lastName;
        
        //stores the pin MD5 hash rather than the original value for security reasons
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes()); 
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a new, unique universal ID for the user - uuid
        this.uuid = theBank.getNewUserUUID();

        //create empty list of accounts
        this.accounts = new ArrayList<Account>();

        //print log message
        System.out.printf("New user %s %s with ID %s created .\n", lastName, firstName, this.uuid);
    }

    //add an account for the user. anAcct is the account to be added
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    //getter method for uuid
    public String getUUID(){
        return this.uuid;
    }

    public boolean validatePin(String aPin) {
        //validates the pin entered by the user when logging in
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        
        return false;
    }

    public String getFirstName() {
        return this.firstName;
    }

    //print the summaries for the accounts the user has
    public void printAccountsSummary() {

        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        //REPLACE FOR LOOP WITH A FOR EACH LOOP
        for(int a = 0; a < this.accounts.size(); a++){
            System.out.printf("\n%d) %s\n", a+1, this.accounts.get(a).getSummaryLine());
        } 
        System.out.println();
    }

    //get the number of accounts the user has
    public int numAccounts() {
        return this.accounts.size();
    }

    //print transaction history for a particular account
    public void printAcctTransactionHistory(int accIdx) {
        this.accounts.get(accIdx).printTransactionHistory();
    }

    //get the balance of a particular account
    public double getAccountBalance(int accIdx) {
        return this.accounts.get(accIdx).getBalance();
    }

    //get the UUID of a particular account
    public Object getAcctUUID(int accIdx) {
        return this.accounts.get(accIdx).getUUID();
    }

    //add a transaction to a particular account 
    public void addAcctTransaction(int accIdx, double amount, String memo) {
        this.accounts.get(accIdx).addTransaction(amount, memo);
    } 
}