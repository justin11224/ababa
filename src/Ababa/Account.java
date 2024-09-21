package Ababa;

import java.util.Scanner;

public class Account {

    public Account(int id1, String firstName1, String lastName1, String email1, String username1, String password1) {
    }

    private static final Account[] accountsList = new Account[100];  
    private static int numAccounts = 0;  

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nWELCOME TO ACCOUNT MANAGEMENT SYSTEM");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. EDIT");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.print("Enter Action: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    addAccounts(scan);
                    break;
                case 2:
                    viewAccounts();
                    break;
                case 3:
                    editAccounts(scan);
                    break;
                case 4:
                    deleteAccounts(scan);
                    break;
                case 5:
                    System.out.println("Exiting Account Management System.");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addAccounts(Scanner scan) {
        System.out.print("Enter Number of Accounts to Add: ");
        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter ID: ");
            int id = scan.nextInt();
            scan.nextLine();  

            System.out.print("Enter First Name: ");
            String firstName = scan.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scan.nextLine();

            System.out.print("Enter Email: ");
            String email = scan.nextLine();

            System.out.print("Enter Username: ");
            String username = scan.nextLine();

            String password;
            while (true) {
                System.out.print("Enter Password (minimum 6 characters, at least 1 number): ");
                password = scan.nextLine();
                if (isValidPassword(password)) {
                    break;
                } else {
                    System.out.println("Password doesn't meet the criteria, please try again.");
                }
            }
            accountsList[numAccounts] = new Account(id, firstName, lastName, email, username, password);
            numAccounts++;
            System.out.println("Account added successfully!");
        }
    }

    
    private static boolean isValidPassword(String password) {
        return password.length() >= 6 && password.matches(".*\\d.*");
    }

    private static void viewAccounts() {
        if (numAccounts == 0) {
            System.out.println("No accounts available.");
        } else {
            for (int i = 0; i < numAccounts; i++) {
                System.out.println("\nAccount " + (i + 1) + ":");
                accountsList[i].view();
            }
        }
    }

    private static void editAccounts(Scanner scan) {
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

                String newPassword;
                while (true) {
                    System.out.print("New Password (minimum 6 characters, at least 1 number): ");
                    newPassword = scan.nextLine();
                    if (isValidPassword(newPassword)) {
                        accountsList[i].password = newPassword;
                        break;
                    } else {
                        System.out.println("Password doesn't meet the criteria, please try again.");
                    }
                }
                System.out.println("Account updated successfully!");
                return;
            }
        }
        System.out.println("Account with ID " + idToEdit + " not found.");
    }

    private static void deleteAccounts(Scanner scan) {
        System.out.print("Enter ID of the account to delete: ");
        int idToDelete = scan.nextInt();

        for (int i = 0; i < numAccounts; i++) {
            if (accountsList[i].id == idToDelete) {
                accountsList[i] = accountsList[numAccounts - 1];  
                accountsList[numAccounts - 1] = null;  
                numAccounts--;
                System.out.println("Account deleted successfully!");
                return;
            }
        }
        System.out.println("Account with ID " + idToDelete + " not found.");
    }

    Account() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void view() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void getAccounts() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}