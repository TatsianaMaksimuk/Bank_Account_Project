package account;

public class CheckingAccount extends Account {
    //default transaction fee:
    private static double FEE = 2.5;

    //default constructor
    public CheckingAccount() {
        super();
    }

    //Parameter constructor to initialize Checking Account with a custom Account Number and a customer Transaction Fee

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    //abstract methods

    //Function to deposit funds into the account  as long as the amount parameter is>0
    //Apply transaction fee for the Checking Account
    //param amount value to be deposited

    public void deposit(double amount){
        if (amount>0){
            balance += amount;
            System.out.println("Amount deposited: " + amount);
            //Apply transaction fee:
            balance -= FEE;
            System.out.println("Fee applied: -"+FEE);
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
            if ((amount+FEE) <= balance){
            balance-=amount;
                System.out.println(amount + " was withdrawn from account");
            balance-=FEE;
                System.out.println(FEE + " fee applied");
                System.out.println("Current balance is "+ balance);
            }
        }else {
            System.out.println("Negative amount cannot be deposited");
        }
    };

}

