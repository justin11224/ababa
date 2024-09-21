package Ababa;

public class Products {
    private int id;
    private String name;
    private double price;
    private int stocks;
    private int sold;

    public void addProducts(int id, String name, double price, int stocks, int sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stocks = stocks;
        this.sold = sold;
    }

    public void viewProducts() {
        double profit = price * sold;
        double tep = profit - (price * stocks); // Total Estimated Profit
        System.out.printf("%-10d %-10s %-10.2f %-10d %-10d %-10.2f %-10.2f %-10s\n",
                id, name, price, stocks, sold, profit, tep, stocks > 0 ? "Available" : "Out of Stock");
    }

    public void editProducts(int pid, String newName, double newPrice, int newStocks, int newSold) {
        if (this.id == pid) {
            this.name = newName;
            this.price = newPrice;
            this.stocks = newStocks;
            this.sold = newSold;
            System.out.println("Product details updated successfully!");
        } else {
            System.out.println("Product ID not found!");
        }
    }

    public void deleteProducts(int pid) {
        if (this.id == pid) {
            this.id = 0;
            this.name = null;
            this.price = 0.0;
            this.stocks = 0;
            this.sold = 0;
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product ID not found!");
        }
    }

    public int getId() {
        return this.id;
    }
}