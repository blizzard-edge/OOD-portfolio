/*
 * Author: Caitlin Hagler
 * Class: Vendor
 * Purpose: Represents a staff member assigned to a Shop.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Strategy
 *
 * A Vendor contains a SalesBehavior Strategy. The behavior can
 * therefore vary between Vendors without changing the Vendor class.
 */

public class Vendor extends Staff {
    private final Shop shop;
    private final SalesBehavior salesBehavior;
    /*
     * Creates a Vendor assigned to a Shop.
     *
     * @param shop Shop assigned to the Vendor
     * @param salesBehavior sales strategy used by the Vendor
     */
    public Vendor(Shop shop, SalesBehavior salesBehavior) {
        super("Vendor");
        this.shop = shop;
        this.salesBehavior = salesBehavior;
    }
    /*
     * Prepares the Vendor's Shop.
     *
     * If inventory is below 20 items, the Shop purchases
     * 100 additional items.
     */
    public void prepareShop() {
        if (shop.getInventory() < 20) {
            shop.prepareInventory();
        }
    }
    /*
     * Gets the Vendor's Shop.
     *
     * @return assigned Shop
     */
    public Shop getShop() {
        return shop;
    }
    /*
     * Gets the Vendor's SalesBehavior.
     *
     * @return sales behavior strategy
     */
    public SalesBehavior getSalesBehavior() {
        return salesBehavior;
    }
}