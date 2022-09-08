package account;
//Base class
//Abstract
public abstract class Account {



    private int accountNumber;


    protected double balance;

    //Default constructor
    public Account (){

    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance  = 0;
    }


//getters
    public double getBalance() {
        return balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    //abstract methods

    //Function to deposit funds into the account  as long as the amount parameter is>0
    //Apply transaction fee for the Checking Account
    //param amount value to be deposited

    public abstract void deposit(double amount);

    //Function to withdraw funds into the account  as long as
    // the amount to withdraw is>0
    //the amount to withdraw is<=balance
    public abstract void withdraw(double amount);

}
