/*
 * Author: Caitlin Hagler
 * Class: Observer
 * Purpose: Defines the interface for objects that receive Shop events.
 * IDE: BlueJ
 * Last Revision Date: September 16, 2026
 *
 * Design Pattern: Observer
 */

public interface Observer {
    /*
     * Receives an event published by a Shop.
     * 
     * @param event Shop event being published
     */
    void update(
        Shop shop,
        ShopEvent event,
        double price
    );
}