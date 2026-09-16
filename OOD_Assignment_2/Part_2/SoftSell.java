/*
 * Author: Caitlin Hagler
 * Purpose: Strategy that increases sale likelihood by 10%.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Strategy
 */

public class SoftSell implements SalesBehavior {
    @Override
    public double getSaleModifier() {
        return 1.10;
    }
    @Override
    public double getExitModifier() {
        return 0.00;
    }
}