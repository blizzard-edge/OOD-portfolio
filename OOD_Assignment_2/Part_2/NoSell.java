/*
 * Author: Caitlin Hagler
 * Class: NoSell
 * Purpose: Strategy representing a Vendor who does not influence sales 
 *          or visitor exit behavior.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Strategy
 */

public class NoSell implements SalesBehavior {
    @Override
    public double getSaleModifier() {
        return 1.00;
    }
    @Override
    public double getExitModifier() {
        return 0.00;
    }
}