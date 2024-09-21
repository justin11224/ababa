package Ababa;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grade gr = new Grade();
        Product pr = new Product();
        Account ac = new Account();
        
        String transaction;
        
        System.out.println("Product CRUD System\n");
        
        do {
            System.out.println("1. Grade");
            System.out.println("2. Product");  
            System.out.println("3. Account");
            System.out.println("Enter selection: ");
            
            int select = sc.nextInt();

            switch(select) {
                case 1:
                    gr.getGradeInput();
                    break;
                case 2: 
                    pr.getProducts();
                    break;
                case 3:
                    ac.getAccounts();
                    break;
                default: 
                    System.out.println("Invalid choice.");
            }
            System.out.print("Make another transaction? (y/n): ");
            transaction = sc.next();
        } while(transaction.equalsIgnoreCase("y")); 
        
        sc.close();
    }
}