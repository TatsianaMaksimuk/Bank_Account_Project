package account;
//Savings account child class
//has an interested rate
//a method to apply interest - profit
public class SavingsAccount extends Account {



    //interest rate:
    private double interestRate;

    public SavingsAccount() {
        super();
    }

    //Parameter constructor to initialize Savings account with a customer account number and interest rate

    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }


    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest(){
        return balance*interestRate;
    }

    public void applyInterest(){
        double interest = calcInterest();
        System.out.println("Interest amount added to balance "+ interest);
        deposit(interest);
    }
    //abstract methods

    //Function to deposit funds into the account  as long as the amount parameter is>0
    //Apply transaction fee for the Checking Account
    //param amount value to be deposited

    public void deposit(double amount){
        if (amount>0){
            balance += amount;
            System.out.println("Amount deposited: " + amount);
            System.out.println("Balance updated: " + balance);
        } else {
            System.out.println("Negative amount cannot be deposited");
        }

    };

    //Function to withdraw funds into the account  as long as
    // the amount to withdraw is>0
    //the amount to withdraw is<=balance
    public void withdraw(double amount){
        if (amount>0){
            if (amount <= balance){
                balance-=amount;
                System.out.println(amount + " was withdrawn from account");
                System.out.println("Current balance is "+ balance);
            }
        }else {
            System.out.println("Negative amount cannot be deposited");
        }
    };

}
