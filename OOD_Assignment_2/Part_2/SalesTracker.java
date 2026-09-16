import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Author: Caitlin Hagler
 * Class: SalesTracker
 * Purpose: Tracks daily Shop visits, sales, sales revenue, and exits.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Patterns:
 *
 * Singleton:
 * SalesTracker uses lazy instantiation. The object is not created
 * until getInstance() is called for the first time.
 *
 * Observer:
 * SalesTracker observes Shop events and updates the appropriate
 * ShopSummary when a Shop publishes an event.
 */

public class SalesTracker implements Observer {
    // Singleton: Lazy instance.
    private static SalesTracker instance;

    private final Map<Shop, ShopSummary> shopData;

    // Private constructor prevents direct construction.
    private SalesTracker() {
        shopData = new LinkedHashMap<>();
    }
    /*
     * Returns the single SalesTracker instance.
     *
     * Lazy Instantiation:
     * The instance is created only when first requested.
     *
     * @return Singleton SalesTracker
     */
    public static SalesTracker getInstance() {
        if (instance == null) {
            instance = new SalesTracker();
        }

        return instance;
    }
    /*
     * Registers a Shop with the SalesTracker.
     *
     * @param shop Shop being registered
     */
    public void registerShop(Shop shop) {
        shopData.putIfAbsent(shop, new ShopSummary());
        shop.subscribe(this);
    }
    /*
     * Receives events published by Shops.
     *
     * Observer Pattern:
     * This method updates the appropriate ShopSummary when a Shop
     * publishes a Visit, Sale, or Exit event.
     *
     * @param shop Shop that generated the event
     * @param event event type
     * @param price sale price, or 0 for non-sale events
     */
    @Override
    public void update(
            Shop shop,
            ShopEvent event,
            double price) {
        ShopSummary summary = shopData.get(shop);
        if (summary == null) {
            return;
        }
        switch (event) {
            case Visit:
                summary.addVisit();
                break;
            case Sale:
                summary.addSale(price);
                break;
            case Exit:
                summary.addExit();
                break;
            default:
                break;
        }
    }
    /*
     * Records a Shop visit.
     *
     * @param shop Shop visited
     */
    public void recordVisit(Shop shop) {
        update(shop, ShopEvent.Visit, 0.0);
    }
    /*
     * Records a sale.
     *
     * @param shop Shop where sale occurred
     * @param price sale price
     */
    public void recordSale(Shop shop, double price) {
        update(shop, ShopEvent.Sale, price);
    }
    /*
     * Records a visitor exit.
     *
     * @param shop Shop where visitor exited
     */
    public void recordExit(Shop shop) {
        update(shop, ShopEvent.Exit, 0.0);
    }
    /*
     * Displays the daily summary for every Shop.
     */
    public void summary() {

        System.out.println();
        System.out.println(
                "--------------- SHOP SUMMARY ---------------"
        );

        for (Map.Entry<Shop, ShopSummary> entry :
                shopData.entrySet()) {

            Shop shop = entry.getKey();
            ShopSummary summary = entry.getValue();

            System.out.printf(
                    "%-10s Vendor: %-15s Visits: %-4d "
                    + "Sales: %-4d Total Sales: $%-7.2f Exits: %d%n",
                    shop.getName(),
                    shop.getVendor().getName(),
                    summary.getVisits(),
                    summary.getSales(),
                    summary.getTotalSales(),
                    summary.getExits()
            );
        }
        System.out.println(
                "---------------------------------------------"
        );
    }
    // Resets all daily statistics to zero.
    public void resetDailyData() {

        for (ShopSummary summary : shopData.values()) {
            // Replace the old values by resetting each statistic.
            while (summary.getVisits() > 0) {
                // handled below through new summary
                break;
            }
        }
        for (Shop shop : shopData.keySet()) {
            shopData.put(shop, new ShopSummary());
        }
    }
}