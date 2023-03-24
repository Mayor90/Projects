import java.util.Date;

public class Transaction {
    
    private double amount;
    //This is the amount of this transaction

    private Date timeStamp;
    //The time and date of this transaction

    private String memo;
    //A memo for this transaction

    private Account inAccount;
    //The account in which the transaction was performed

    public Transaction(double amount, Account inAccount){

        this.amount = amount;
        this.inAccount = inAccount;
        this.timeStamp = new Date();
        this.memo = "";
    }

    //constructor for the transaction class
    public Transaction(double amount, String memo, Account inAccount){
        
        //call the two argument constructor first
        this(amount, inAccount);

        //set the memo
        this.memo = memo;
    }

    //get the amount for the transaction
    public double getAmount() {
        return this.amount;
    }

    //get a string summary of the transaction
    public String getSummaryLine() {
        
        if(this.amount >= 0){
            return String.format("%s : $ %.02f : %s", this.timeStamp.toString(), this.amount, this.memo);
        }
        else {
            return String.format("%s : $ (%.02f) : %s", this.timeStamp.toString(), -this.amount, this.memo);
        }
    } 
}
