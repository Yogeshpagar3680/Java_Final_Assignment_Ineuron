package banking;

import java.util.Scanner;

public class BankAccountOperations {

    int balance;
    int transactionHistory;

    public void depositAmount(int amount){
        if(amount != 0){
            balance = balance + amount;
            transactionHistory = amount;
            System.out.println("Transaction successful!");
        }
    }

    public void withdrawAmount(int amount){
        if(balance != 0 && amount <= balance){
            balance = balance - amount;
            transactionHistory = -amount;
            System.out.println("Transaction successful!");
        }
        else
            System.out.println("Insufficient balance!");
    }

    public void transferAmount(int amount){
        if(balance != 0 && amount <= balance){
            balance = balance - amount;
            transactionHistory = -amount;
            System.out.println("Transaction successful!");

        }
        else
            System.out.println("Insufficient balance!");
    }

    public void showMenu(){

        int option;
        Scanner sc = new Scanner(System.in);

        System.out.println("1 : View Account Balance");
        System.out.println("2 : Deposit Amount");
        System.out.println("3 : Withdraw Amount");
        System.out.println("4 : Transfer Amount");
        System.out.println("5 : Exit");

        do{
            System.out.println("-------------------------------------------------");
            System.out.println("***********| PLEASE SELECT AN OPTION |***********");
            System.out.println("-------------------------------------------------");
            option = sc.nextInt();
            System.out.println("\n");

            switch (option){

                case 1:
                    System.out.println("-------------------------------");
                    System.out.println("Current Balance :: " + balance);
                    System.out.println("-------------------------------");
                    break;

                case 2:
                    System.out.println("Enter an amount to deposit :");
                    int amountToDeposit = sc.nextInt();
                    depositAmount(amountToDeposit);
                    break;

                case 3:
                    System.out.println("Enter an amount to withdraw :");
                    int amountToWithdraw = sc.nextInt();
                    withdrawAmount(amountToWithdraw);
                    break;

                case 4:
                    System.out.println("Enter an amount to Transfer");
                    int amountToTransfer = sc.nextInt();
                    transferAmount(amountToTransfer);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid option! Please enter correct option!");
                    break;
            }
        }while (option != 5);
                   System.out.println("Thank you for using our services...!!");
    }
}
