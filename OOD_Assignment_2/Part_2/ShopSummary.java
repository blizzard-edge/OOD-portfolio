/*
 * Author: Caitlin Hagler
 * Class: ShopSummary
 * Purpose: Stores daily sales statistics for one Shop.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 */

public class ShopSummary {
    private int visits;
    private int sales;
    private double totalSales;
    private int exits;

    // Creates an empty daily summary.
    public ShopSummary() {
        visits = 0;
        sales = 0;
        totalSales = 0.0;
        exits = 0;
    }
    public void addVisit() {
        visits++;
    }
    public void addSale(double price) {
        sales++;
        totalSales += price;
    }
    public void addExit() {
        exits++;
    }
    public int getVisits() {
        return visits;
    }
    public int getSales() {
        return sales;
    }
    public double getTotalSales() {
        return totalSales;
    }
    public int getExits() {
        return exits;
    }
}