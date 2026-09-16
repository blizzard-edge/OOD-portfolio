import java.util.ArrayList;
import java.util.List;

/*
 * Author: Caitlin Hagler
 * Class: Shop
 * Purpose: Represents a Zoo Shop that stores inventory, cash,
 *          pricing, and visitor sale likelihood.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Observer
 *
 * Shop is the Subject. It publishes Visit, Sale, and Exit events
 * to its subscribed Observers.
 */

public class Shop implements Subject {
    private final String name;
    private int inventory;
    private final double price;
    private final double likelihood;
    private double cash;
    private final List<Observer> observers;
    private Vendor vendor;
    /*
     * Creates a Shop.
     *
     * @param name Shop name
     * @param inventory starting inventory
     * @param price item price
     * @param likelihood normal sale likelihood
     */
    public Shop(
            String name,
            int inventory,
            double price,
            double likelihood) {

        this.name = name;
        this.inventory = inventory;
        this.price = price;
        this.likelihood = likelihood;
        this.cash = inventory * (price / 2.0);
        this.observers = new ArrayList<>();
    }
    /*
     * Assigns a Vendor to this Shop.
     *
     * @param vendor Vendor assigned to the Shop
     */
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    /*
     * Gets the Shop's Vendor.
     *
     * @return Vendor assigned to this Shop
     */
    public Vendor getVendor() {
        return vendor;
    }
    /*
     * Prepares inventory when the inventory level is below 20.
     *
     * Adds 100 items and pays for them using Shop cash.
     */
    public void prepareInventory() {
        if (inventory < 20) {

            int addedItems = 100;
            double cost = addedItems * (price / 2.0);

            inventory += addedItems;
            cash -= cost;

            System.out.printf(
                    "%s is preparing inventory: "
                    + "added %d items. Cost: $%.2f%n",
                    name,
                    addedItems,
                    cost
            );
        }
    }
    /*
     * Processes one visitor's visit to this Shop.
     *
     * @return true if the visitor exits after this Shop
     */
    public boolean visit() {
        notify(ShopEvent.Visit, 0.0);

        double saleChance = likelihood;

        if (vendor != null) {
            saleChance *=
                    vendor.getSalesBehavior().getSaleModifier();
        }
        // Prevent the modified likelihood from exceeding 100%.
        saleChance = Math.min(saleChance, 1.0);
        if (inventory > 0 && Math.random() < saleChance) {
            sellItem();
        }
        double exitChance = 0.05;
        if (vendor != null) {
            exitChance +=
                    vendor.getSalesBehavior().getExitModifier();
        }
        if (Math.random() < exitChance) {
            notify(ShopEvent.Exit, 0.0);
            return true;
        }
        return false;
    }
    /*
     * Sells one item.
     *
     * Shop events are published to observers and are not printed
     * directly to the console.
     */
    private void sellItem() {
        if (inventory <= 0) {
            return;
        }
        inventory--;
        cash += price;

        notify(ShopEvent.Sale, price);
    }
    /*
     * Subscribes an Observer.
     *
     * @param observer Observer to subscribe
     */
    @Override
    public void subscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    /*
     * Unsubscribes an Observer.
     *
     * @param observer Observer to remove
     */
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    /*
     * Publishes an event to all Observers.
     */
    @Override
    public void notify(ShopEvent event) {
        notify(event, 0.0);
    }
    /*
     * Publishes an event and sale price to all Observers.
     *
     * @param event event being published
     * @param price sale price
     */
    public void notify(
            ShopEvent event,
            double price) {
        for (Observer observer :
                new ArrayList<>(observers)) {

            observer.update(this, event, price);
        }
    }
    public String getName() {
        return name;
    }
    public int getInventory() {
        return inventory;
    }
    public double getPrice() {
        return price;
    }
    public double getLikelihood() {
        return likelihood;
    }
    public double getCash() {
        return cash;
    }
}