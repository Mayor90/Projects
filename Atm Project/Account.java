import java.util.ArrayList;

public class Account {
    
    private String name;
    // This is the name of the account

    private double balance;
    //this returns the balance of the account

    private String uuid;
    //This is the account ID number. This also serves as the account number of the account

    private User holder;
    //This user object owns this account

    private ArrayList<Transaction> transactions;
    //This is a list of transactions for this account

    public Account(String name, User holder, Bank theBank){

        //set the account name and holder
        this.name = name;
        this.holder = holder;
        this.balance = 0;

        //get new account uuid
        this.uuid = theBank.getNewAccountUUID();

        //initialize transactions
        this.transactions = new ArrayList<>();


    }

    //getter method for the account UUID 
    public String getUUID(){
        return this.uuid;
    }

    //return the string summary
    public String getSummaryLine() {
        
        //get the account's balance
        double balance = this.getBalance();

        //format the summary line depending on the value of the balance i.e. if the balance is negative
        if(balance >= 0){
            return String.format("%s : $ %.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $ (%.02f) : %s", this.uuid, balance, this.name);
        }

    }

    //Get the balance of this account by adding the amounts of transactions
    public double getBalance() {
        
       return this.balance;
    }

    //Adjust balance after each transaction
    public void adjustBalance(double amount) {

        //This updates the balance in the account after each transaction
        this.balance += amount;
    }

    //print the transaction history of this account
    public void printTransactionHistory() {
        System.out.printf("\n Transaction history for account %s\n", this.uuid);
        for (int t = this.transactions.size()-1; t >= 0; t--){
            System.out.println(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

    //create a new transaction object and add to the list of transactions existing for this account
    public void addTransaction(double amount, String memo) {
        
        Transaction newTrans = new Transaction(amount, memo, this);
        this.transactions.add(newTrans);
        adjustBalance(amount);

    }
}
