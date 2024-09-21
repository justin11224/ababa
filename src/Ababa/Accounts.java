package Ababa;

import java.util.Scanner;

public class Accounts {

    private static final Accounts[] accountsList = new Accounts[100];
    private static int numAccounts = 0;  
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    
    public Accounts(int id, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    Accounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Method to view account details
    public void viewAccounts() {
        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
    }

    private static void viewAllAccounts() {
        if (numAccounts == 0) {
            System.out.println("No accounts available.");
        } else {
            for (int i = 0; i < numAccounts; i++) {
                System.out.println("\nAccount " + (i + 1) + ":");
                accountsList[i].viewAccounts();
            }
        }
    }

    private static void editAccount(Scanner scan) {
        System.out.print("Enter ID of the account to edit: ");
        int idToEdit = scan.nextInt();
        scan.nextLine();  // Consume newline

        for (int i = 0; i < numAccounts; i++) {
            if (accountsList[i].id == idToEdit) {
                System.out.print("New First Name: ");
                accountsList[i].firstName = scan.nextLine();
                System.out.print("New Last Name: ");
                accountsList[i].lastName = scan.nextLine();
                System.out.print("New Email: ");
                accountsList[i].email = scan.nextLine();
                System.out.print("New Username: ");
                accountsList[i].username = scan.nextLine();
                System.out.print("New Password: ");
                accountsList[i].password = scan.nextLine();

                System.out.println("Account updated successfully!");
                return;
            }
        }
        System.out.println("Account with ID " + idToEdit + " not found.");
    }

    private static void deleteAccount(Scanner scan) {
        System.out.print("Enter ID of the account to delete: ");
        int idToDelete = scan.nextInt();

        for (int i = 0; i < numAccounts; i++) {
            if (accountsList[i].id == idToDelete) {
                accountsList[i] = accountsList[numAccounts - 1];  // Replace with the last account
                accountsList[numAccounts - 1] = null;  // Remove the last account
                numAccounts--;
                System.out.println("Account deleted successfully!");
                return;
            }
        }
        System.out.println("Account with ID " + idToDelete + " not found.");
    }
}
 