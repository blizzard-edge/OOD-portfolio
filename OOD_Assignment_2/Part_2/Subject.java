/*
 * Author: Caitlin Hagler
 * Class: Subject
 * Purpose: Defines the interface for objects that publish events to observers.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Observer
 */

public interface Subject {
    /*
     * Subscribes an Observer to receive events.
     *
     * @param observer observer to subscribe
     */
    void subscribe(Observer observer);
    /*
     * Removes an Observer from the subscription list.
     *
     * @param observer observer to unsubscribe
     */
    void unsubscribe(Observer observer);
    /*
     * Publishes an event to all subscribed observers.
     *
     * @param event event being published
     */
    void notify(ShopEvent event);
}