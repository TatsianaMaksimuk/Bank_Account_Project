package account;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AccountDriver {
    //entry point of progrzmm
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        //create array of accounts
        Account accounts[] = new Account[10];
        int numAccounts = 0;

        int choice;
        do{
            choice = menu(keyboard);
            System.out.println();

            if (choice == 1){
            accounts[numAccounts++] = createAccount(keyboard);
            }else if(choice == 2){
                doDeposit(accounts, numAccounts, keyboard);
            }else if(choice == 3){
                doWithdraw(accounts, numAccounts, keyboard);
            }else if(choice == 4){
                applyInterest(accounts, numAccounts, keyboard);
            } else {
                System.out.println("Bye");
            }

            System.out.println();

        } while(choice!=5);
    }

    public static int accountMenu(Scanner keyboard) {
        System.out.println("Select Account Type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        int choice;

        do {
            System.out.println("Enter choice:");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 2);
        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    //Function to perform deposit on a selected account:
    public static void doDeposit(Account accounts[], int count, Scanner keyboard) {
        //Get the account number;
        System.out.println("Enter account number: ");
        int accountNumber = keyboard.nextInt();
        int index = searchAccount(accounts, count, accountNumber);
        //Amount
        if (index >= 0) {
            System.out.println("Enter deposit amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with Account Number: " + accountNumber);
        }
    }

    //Function to withdraw money from a selected account:
    public static void doWithdraw(Account accounts[], int count, Scanner keyboard) {
        //Get the account number;
        System.out.println("Enter account number: ");
        int accountNumber = keyboard.nextInt();
        int index = searchAccount(accounts, count, accountNumber);
        //Amount
        if (index >= 0) {
            System.out.println("Enter withdraw amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with Account Number: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner keyboard) {
        System.out.println("Enter account number: ");
        int accountNumber = keyboard.nextInt();
        int index = searchAccount(accounts, count, accountNumber);
        if (index >= 0) {
            if (accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount) accounts[index]).applyInterest();
            }
        }else{
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }


        //Function to create a new account
        public static Account createAccount (Scanner keyboard){
            Account account = null;
            int choice = accountMenu(keyboard);
            int accountNumber;
            System.out.println("Enter account number: ");
            accountNumber = keyboard.nextInt();
            if (choice == 1) { //checking account
                System.out.println("Enter transaction fee: ");
                double fee = keyboard.nextDouble();
                account = new CheckingAccount(accountNumber, fee);

            } else {//savings account
                System.out.println("Please Enter Interest Rate: ");
                double interest = keyboard.nextDouble();
                account = new SavingsAccount(accountNumber, interest);
            }
            return account;
        }

        //menu to display options and get the user's selection
        public static int menu (Scanner keyboard){
            System.out.println("Bank Account Menu");
            System.out.println("1. Create new Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw funds");
            System.out.println("4. Apply Interest");
            System.out.println("5. Quit");

            int choice;

            do {
                System.out.println("Enter choice:");
                choice = keyboard.nextInt();
            } while (choice < 1 || choice > 5);
            return choice;
        }
    }

