package Ababa;

import java.util.Scanner;

public class Product {

    private final Product[] products = new Product[100];  
    private int nums = 0;  
    private int id;       
    private String name;   
    private double price;  
    private int stocks;    
    private int sold;      

    public void getProducts() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("WELCOME TO PRODUCT INVENTORY");
            System.out.println("---------------------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. EDIT");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.println("---------------------------------");

            System.out.print("Enter Action: ");
            int opt = scan.nextInt();

            switch (opt) {
                case 1:
                    addProducts(scan);
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    editProduct(scan);
                    break;
                case 4:
                    deleteProduct(scan);
                    break;
                case 5:
                    System.out.println("Exiting Products Inventory... ");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

   
    private void addProducts(Scanner scan) {
        System.out.print("Enter Number of Products: ");
        int np = scan.nextInt();

        for (int i = 0; i < np; i++) {
            System.out.println("\nEnter Details for Product " + (i + 1));
            System.out.print("ID: ");
            int pid = scan.nextInt();
            System.out.print("Name: ");
            String pname = scan.next();
            System.out.print("Price: ");
            double pprice = scan.nextDouble();
            System.out.print("Stocks: ");
            int pstocks = scan.nextInt();
            int psold;

            
            while (true) {
                System.out.print("Sold (cannot exceed stocks): ");
                psold = scan.nextInt();
                if (psold <= pstocks) {
                    break;
                }
                System.out.println("Error: Sold products cannot exceed available stocks.");
            }

            System.out.println("");
            products[nums] = new Product();
            products[nums].addProduct(pid, pname, pprice, pstocks, psold);  
            nums++;
        }
    }

   
    private void viewProducts() {
        if (nums == 0) {
            System.out.println("No products added yet!");
        } else {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "ID", "Name", "Price", "Stocks", "Sold", "Profit", "TEP", "Status");
            for (int i = 0; i < nums; i++) {
                products[i].viewProduct();  
            }
        }
    }

    
    private void editProduct(Scanner scan) {
        System.out.print("Enter the ID of the product to edit: ");
        int idToEdit = scan.nextInt();
        for (int i = 0; i < nums; i++) {
            if (products[i].id == idToEdit) {
                System.out.print("New Name: ");
                products[i].name = scan.next();
                System.out.print("New Price: ");
                products[i].price = scan.nextDouble();
                System.out.print("New Stocks: ");
                products[i].stocks = scan.nextInt();

                int psold;              
                while (true) {
                    System.out.print("New Sold (cannot exceed stocks): ");
                    psold = scan.nextInt();
                    if (psold <= products[i].stocks) {
                        products[i].sold = psold;
                        break;
                    }
                    System.out.println("Error: Sold products cannot exceed available stocks.");
                }

                System.out.println("Product updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private void deleteProduct(Scanner scan) {
        System.out.print("Enter the ID of the product to delete: ");
        int idToDelete = scan.nextInt();
        for (int i = 0; i < nums; i++) {
            if (products[i].id == idToDelete) {
                products[i] = products[nums - 1];  
                products[nums - 1] = null;  
                nums--;  
                System.out.println("Product deleted.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public static void main(String[] args) {
        Product pr = new Product();
        pr.getProducts();
    }
    private void addProduct(int pid, String pname, double pprice, int pstocks, int psold) {
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.stocks = pstocks;
        this.sold = psold;
    } 
    private void viewProduct() {
        double profit = price * sold;
        double tep = profit - (price * stocks);  // Total Estimated Profit (TEP)
        String status = stocks > 0 ? "Available" : "Out of Stock";

        System.out.printf("%-10d %-10s %-10.2f %-10d %-10d %-10.2f %-10.2f %-10s\n",
                id, name, price, stocks, sold, profit, tep, status);
    }
}