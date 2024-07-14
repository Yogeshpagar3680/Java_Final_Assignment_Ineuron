package banking;

import java.util.Scanner;

public class BankingApp {

    public void verification(){

        Scanner sc = new Scanner(System.in);
        System.out.println("=====| WELCOME TO PAGAR BANK PVT.LTD |=====");
        System.out.println("Please enter customer id : ");
        String customerId = sc.next();
        String verifiedId = "Yogesh@123";
        System.out.println("Please enter password : ");
        String password = sc.next();
        String verifiedPassword = "1234";
        System.out.println();

        if((customerId.equals(verifiedId)) && (password.equals(verifiedPassword))){
            Operations operations = new Operations();
            operations.basicDetails();
            BankAccountOperations bankAccountOperations = new BankAccountOperations();
            bankAccountOperations.showMenu();
        }
        else
            System.out.println("Login Failed!");
    }

}
