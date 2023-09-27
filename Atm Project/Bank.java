import java.util.ArrayList;
import java.util.Random;

public class Bank {
    
    private String name;
    //This is the name of the Bank

    private ArrayList<User> users;
    //This is the list of customers the bank has

    private ArrayList<Account> accounts;
    //This is the list of accounts with the bank
    
    public Bank (String name){
        //creates a bank object with empty list for accounts and users
        this.name = name;
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>(); 
    }
    //generates a new universally unique ID for a user
    public String getNewUserUUID(){

        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;
        
        //continue looping until the uuid become unique
        do {
            //generate the uuid
            uuid = "";
            for(int c = 0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //check to see if the uuid is unique
            for(Account a : this.accounts){
                if(uuid.equals(a.getUUID())){
                    nonUnique = true;
                    break;
                }
                nonUnique = false;
            }
        }while (nonUnique);

        return uuid;       

    }

    public String getNewAccountUUID(){
        
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;
        
        //continue looping until the uuid become unique
        do {
            //generate the uuid
            uuid = "";
            for(int c = 0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //check to see if the uuid is unique
            for(User u : this.users){
                if(uuid.equals(u.getUUID())){
                    nonUnique = true;
                    break;
                }
                nonUnique = false;
            }
        }while (nonUnique);
        
        return uuid;  
    }

    //add an account to the bank when an account is created
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    //create a new user
    public void addUser(String firstName, String lastName, String pin){
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //create a savings account for the user
        Account newAccount = new Account("Savings", newUser, this);
        //add to holder and bank lists
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        
    }
    //add an existing user to the bank
    public void addUser (User newUser){
        this.users.add(newUser);

        //create a savings account for the user
        Account newAccount = new Account("Savings", newUser, this);
        //add to holder and bank lists
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

    }

    public User userLogin(String userID, String pin){

        //search the user list 
        for(User u : this.users){

            //check user ID is correct
            if(u.getUUID().equals(userID) && u.validatePin(pin)){
                return u;
            } 
        }
        //if we haven't found the user or have an incorrect pin
        return null;
    }
    //getter method for the name of the bank
    public String getName() {
        return this.name;
    }

} 
 